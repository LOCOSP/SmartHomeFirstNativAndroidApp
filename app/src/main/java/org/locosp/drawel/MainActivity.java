package org.locosp.drawel;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    LinearLayout hueBulbsNoVisible;

    private static final String TAG = MainActivity.class.getName();

    private static final String REQUESTTAG = "string request first";




    // buttons register

    private Button cornerOnBtn;

    private Button cornerOffBtn;

    private Button galleryOnBtn;

    private Button galleryOffBtn;

    private Button livingAreaOnBtn;

    private Button livingAreaOffBtn;

    private Button diningAreaOnBtn;

    private Button diningAreaOffBtn;

    private Button speakersLightsOnBtn;

    private Button speakersLightsOffBtn;

    private Button hueComputerOnBtn;

    private Button hueComputerOffBtn;

    private Button hueSpkrLeftOnBtn;

    private Button hueSpkrLeftOffBtn;

    private Button hueSpkrRightOnBtn;

    private Button hueSpkrRightOffBtn;




    private RequestQueue mRequestQueue ;

    private StringRequest stringRequest;



    //URL's register

    private String galleryOnUrl = "http://192.168.1.10:90/interface/tasker/lights/GalleryLightOn.php";

    private String galleryOffUrl = "http://192.168.1.10:90/interface/tasker/lights/GalleryLightOff.php";

    private String cornerOnUrl = "http://192.168.1.10:90/interface/tasker/lights/CornnerLightOn.php";

    private String cornerOffUrl = "http://192.168.1.10:90/interface/tasker/lights/CornnerLightOff.php";

    private String livingAreaOnUrl = "http://192.168.1.10:90/interface/tasker/lights/SmallTableLightOn.php";

    private String livingAreaOffUrl = "http://192.168.1.10:90/interface/tasker/lights/SmallTableLightOff.php";

    private String diningAreaOnUrl = "http://192.168.1.10:90/interface/tasker/lights/BigTableLightOn.php";

    private String diningAreaOffUrl = "http://192.168.1.10:90/interface/tasker/lights/BigTableLightOff.php";

    private String speakersLightsOnUrl = "http://192.168.1.10:90/interface/tasker/lights/HueSpeakersLightsOn.php";

    private String speakersLightsOffUrl = "http://192.168.1.10:90/interface/tasker/lights/HueSpeakersLightsOff.php";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        hueBulbsNoVisible = (LinearLayout)findViewById(R.id.hueBulbsNoVisible);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        cornerOnBtn = (Button) findViewById(R.id.cornerOnBtn);

        cornerOnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // send request and print the response using volley library

                sendRequestAndPrintResponse(cornerOnUrl);

                Toast.makeText(getApplicationContext(), "Włączono Lampki boczne!", Toast.LENGTH_SHORT)
                        .show();
            }
        });

        cornerOffBtn = (Button) findViewById(R.id.cornerOffBtn);

        cornerOffBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // send request and print the response using volley library

                sendRequestAndPrintResponse(cornerOffUrl);

                Toast.makeText(getApplicationContext(), "Wyłączono Lampki boczne!", Toast.LENGTH_SHORT)
                        .show();
            }
        });

        galleryOnBtn = (Button) findViewById(R.id.galleryOnBtn);

        galleryOnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // send request and print the response using volley library

                sendRequestAndPrintResponse(galleryOnUrl);

                Toast.makeText(getApplicationContext(), "Włączono Galerię!", Toast.LENGTH_SHORT)
                        .show();
            }
        });

        galleryOffBtn = (Button) findViewById(R.id.galleryOffBtn);

        galleryOffBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // send request and print the response using volley library

                sendRequestAndPrintResponse(galleryOffUrl);

                Toast.makeText(getApplicationContext(), "Wyłączono Galerię!", Toast.LENGTH_SHORT)
                        .show();
            }
        });

        livingAreaOnBtn = (Button) findViewById(R.id.livingAreaOnBtn);

        livingAreaOnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // send request and print the response using volley library

                sendRequestAndPrintResponse(livingAreaOnUrl);

                Toast.makeText(getApplicationContext(), "Włączono Światło nad małym stołem!", Toast.LENGTH_SHORT)
                        .show();
            }
        });

        livingAreaOffBtn = (Button) findViewById(R.id.livingAreaOffBtn);

        livingAreaOffBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // send request and print the response using volley library

                sendRequestAndPrintResponse(livingAreaOffUrl);

                Toast.makeText(getApplicationContext(), "Wyłączono światło nad małym stołem!", Toast.LENGTH_SHORT)
                        .show();
            }
        });

        diningAreaOnBtn = (Button) findViewById(R.id.diningAreaOnBtn);

        diningAreaOnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // send request and print the response using volley library

                sendRequestAndPrintResponse(diningAreaOnUrl);

                Toast.makeText(getApplicationContext(), "Włączono Światło nad dużym stołem!", Toast.LENGTH_SHORT)
                        .show();
            }
        });

        diningAreaOffBtn = (Button) findViewById(R.id.diningAreaOffBtn);

        diningAreaOffBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // send request and print the response using volley library

                sendRequestAndPrintResponse(diningAreaOffUrl);

                Toast.makeText(getApplicationContext(), "Wyłączono Światło nad dużym stołem!", Toast.LENGTH_SHORT)
                        .show();
            }
        });

        speakersLightsOnBtn = (Button) findViewById(R.id.speakersLightsOnBtn);

        speakersLightsOnBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // send request and print the response using volley library

                sendRequestAndPrintResponse(speakersLightsOnUrl);

                Toast.makeText(getApplicationContext(), "Włączono Światła głośników!", Toast.LENGTH_SHORT)
                        .show();
            }
        });

        speakersLightsOffBtn = (Button) findViewById(R.id.speakersLightsOffBtn);

        speakersLightsOffBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // send request and print the response using volley library

                sendRequestAndPrintResponse(speakersLightsOffUrl);

                Toast.makeText(getApplicationContext(), "Wyłączono Światła głośników!", Toast.LENGTH_SHORT)
                        .show();
            }
        });


    }


    private void sendRequestAndPrintResponse(String url) {

        mRequestQueue = Volley.newRequestQueue(this);

        stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.i(TAG,"Response : " + response.toString());

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Log.i(TAG,"Error : "+ error.toString());

                Toast.makeText(getApplicationContext(), "No! Something went wrong! Check VPN or WiFi connection!", Toast.LENGTH_LONG)
                        .show();

            }
        });

        stringRequest.setTag(REQUESTTAG);

        mRequestQueue.add(stringRequest);

    }

    @Override
    protected void onStop() {

        super.onStop();

        if (mRequestQueue!=null)
        {
            mRequestQueue.cancelAll(REQUESTTAG);
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }


    public void showMoreHue (View view)
    {
        // Toast.makeText(getApplicationContext(), "Text was clicked!", Toast.LENGTH_SHORT).show();

        if (hueBulbsNoVisible.getVisibility() == View.VISIBLE){
        hueBulbsNoVisible.setVisibility(View.GONE);
    }
    else {
            hueBulbsNoVisible.setVisibility(View.VISIBLE);
        }

}
}

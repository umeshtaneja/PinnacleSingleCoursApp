package com.pinnacle.garorasu.course;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.pinnacle.garorasu.course.AboutPinnacle.AboutPinnacleFragment;
import com.pinnacle.garorasu.course.AboutSSCCGL.AboutSsccglFragment;
import com.pinnacle.garorasu.course.Explore.ExploreFragment;
import com.pinnacle.garorasu.course.Explore.Subject;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,SubjectListener {

    private SubjectListener msubjectListener;
    DrawerLayout drawer;
    Toolbar toolbar;
    boolean flag = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.BLACK);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        exploreFragment();


    }




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

        int id = item.getItemId();

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

        if (id == R.id.Explore) {


        } else if (id == R.id.AboutUs) {


        } else if (id == R.id.AboutSsc) {

        } else if (id == R.id.ContactUs) {

        } else if (id == R.id.Share) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void exploreFragment() {
        ExploreFragment fragment = new ExploreFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.main_content_frame_container, fragment).commit();

    }

    @Override
    public void subjectSelect(Subject subject) {

        Intent intent = new Intent(getApplicationContext(), SubjectActivity.class);
        intent.putExtra("subjectObject", subject);
        intent.putExtra("subject", subject.getTitle());
        intent.putExtra("color", subject.getColor());
        startActivity(intent);
    }

    public void exploreOnClick(MenuItem item) {

        drawer.closeDrawer(GravityCompat.START);
        exploreFragment();
    }

    public void aboutUsOnClick(MenuItem item) {

        getSupportActionBar().setTitle("About PINNACLE");
        drawer.closeDrawer(GravityCompat.START);
        Fragment f1;
        f1 = new AboutPinnacleFragment();
        FragmentManager fn = getSupportFragmentManager();
        FragmentTransaction ft = fn.beginTransaction();
        ft.replace(R.id.main_content_frame_container, f1);
        ft.commit();
    }

    public void aboutSsscglOnClick(MenuItem item) {

        getSupportActionBar().setTitle("About SSCCGL");
        drawer.closeDrawer(GravityCompat.START);
        Fragment f1;
        f1 = new AboutSsccglFragment();
        FragmentManager fn = getSupportFragmentManager();
        FragmentTransaction ft = fn.beginTransaction();
        ft.replace(R.id.main_content_frame_container, f1);
        ft.commit();
        Toast.makeText(getApplicationContext(), "SSCCGL", Toast.LENGTH_SHORT).show();
    }

    public void contactUsOnClick(MenuItem item) {

        drawer.closeDrawer(GravityCompat.START);
        String uriText =
                "mailto:parul.chopra53@gmail.com" +
                        "?subject=" + Uri.encode("some subject text here") +
                        "&body=" + Uri.encode("some text here");

        Uri uri = Uri.parse(uriText);

        Intent sendIntent = new Intent(Intent.ACTION_SENDTO);
        sendIntent.setData(uri);
        startActivity(Intent.createChooser(sendIntent, "Send email"));
        Toast.makeText(getApplicationContext(), "contact us", Toast.LENGTH_SHORT).show();
    }

    public void shareOnClick(MenuItem item) {
        drawer.closeDrawer(GravityCompat.START);
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");

        intent.putExtra(Intent.EXTRA_TEXT, "APP URL");

        startActivity(Intent.createChooser(intent, "sharing"));

        Toast.makeText(getApplicationContext(), "share", Toast.LENGTH_SHORT).show();

    }

}

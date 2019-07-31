package com.example.tanush.maindemo2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawer;
    NavigationView navigationView;
    Toolbar toolbar=null;

    ImageView instabutton, fbbutton, wwwbutton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));
        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView = findViewById(R.id.nav_view);
        navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(this);

        instabutton = findViewById(R.id.insta);
        fbbutton = findViewById(R.id.facebook);
        wwwbutton = findViewById(R.id.site);

        instabutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String insta = "https://www.instagram.com/acm.pict/?hl=en";
                openSite(insta);
            }
        });
        fbbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fb = "https://www.facebook.com/acmpict/";
                openSite(fb);
            }
        });
        wwwbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String web = "https://pict.acm.org/pulzion19";
                openSite(web);
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
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
            switch (item.getItemId()) {

                case R.id.bug_report:
                    Intent intent1 = new Intent(MainActivity.this, BugReport.class);
                    startActivity(intent1);
                    return true;
                case R.id.share:
                    Intent intent = new Intent(android.content.Intent.ACTION_SEND);
                    intent.setType("text/plain");
                    String link = "Here is the share content body";
                    intent.putExtra(android.content.Intent.EXTRA_TEXT, link);
                    startActivity(Intent.createChooser(intent, "Share via"));
                    return true;

                default:
                    return super.onOptionsItemSelected(item);
            }
        }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        switch (id) {
            case R.id.Home:
                Intent i = new Intent(MainActivity.this, MainActivity.class);
                startActivity(i);
                break;
            case R.id.nav_register:
                Intent h2 = new Intent(MainActivity.this, EventRegistrationActivity.class);
                startActivity(h2);
                break;
            case R.id.nav_receipts:
                Intent h = new Intent(MainActivity.this, Receipts.class);
                startActivity(h);
                break;
            case R.id.nav_events:
                Intent h1 = new Intent(MainActivity.this, Events.class);
                startActivity(h1);
                break;
            case R.id.workshops:
                Intent i1 = new Intent(MainActivity.this, Workshops.class);
                startActivity(i1);
                break;
            case R.id.nav_sponsors:
                Intent g = new Intent(MainActivity.this, Sponsors.class);
                startActivity(g);
                break;
            case R.id.nav_aboutus:
                Intent s = new Intent(MainActivity.this, AboutUs.class);
                startActivity(s);
                break;
        }


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void openSite(String url) {

        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}

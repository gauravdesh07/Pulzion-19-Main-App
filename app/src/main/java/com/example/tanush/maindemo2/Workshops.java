package com.example.tanush.maindemo2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class Workshops extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workshops);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(this);
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
                Intent intent1 = new Intent(Workshops.this, BugReport.class);
                startActivity(intent1);
                return true;
            case R.id.share1:
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
                Intent i = new Intent(Workshops.this, MainActivity.class);
                startActivity(i);
                break;
            case R.id.nav_register:
                Intent h2 = new Intent(Workshops.this, EventRegistrationActivity.class);
                startActivity(h2);
                break;
            case R.id.nav_receipts:
                Intent h = new Intent(Workshops.this, Receipts.class);
                startActivity(h);
                break;
            case R.id.nav_events:
                Intent h1 = new Intent(Workshops.this, Events.class);
                startActivity(h1);
                break;
            case R.id.workshops:
                Intent i1 = new Intent(Workshops.this, Workshops.class);
                startActivity(i1);
                break;
            case R.id.nav_sponsors:
                Intent g = new Intent(Workshops.this, Sponsors.class);
                startActivity(g);
                break;
            case R.id.nav_aboutus:
                Intent s = new Intent(Workshops.this, AboutUs.class);
                startActivity(s);
                break;
        }


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

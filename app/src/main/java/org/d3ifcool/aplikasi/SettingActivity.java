package org.d3ifcool.aplikasi;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class SettingActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout mDrawLayoutt;
    private ActionBarDrawerToggle mToggle;
    private NavigationView navigation_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        setNavigationViewListner();
        navigation_view = (NavigationView)findViewById(R.id.nav_view_setting);

        mDrawLayoutt = (DrawerLayout) findViewById(R.id.drawLayout);
        mToggle = new ActionBarDrawerToggle(this, mDrawLayoutt, R.string.open, R.string.close);

        mDrawLayoutt.addDrawerListener(mToggle);
        mToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.notif){
            Toast.makeText(this, "Pemberitahuan Selected", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.sorting) {
            Toast.makeText(this, "Sorting Selected",Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.delete) {
            startActivity(new Intent(this, helpActivity.class));
        } else if (item.getItemId() == R.id.history){
            Toast.makeText(this, "History Selected",Toast.LENGTH_SHORT).show();
        }
        if (mToggle.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_today: {
                Intent intent_today = new Intent(this,todayActivity.class);
                this.startActivity(intent_today);
                break;
            }
            case R.id.nav_pengatuan: {
                Toast.makeText(this, "Maaf Fitur Belum Berjalan", Toast.LENGTH_SHORT).show();
            }
            case R.id.nav_prioritas: {
                Intent intent_prioritas = new Intent(this, MainActivity.class);
                this.startActivity(intent_prioritas);
                break;
            }
            case R.id.nav_label: {
                Toast.makeText(this, "Maaf Fitur Belum Berjalan", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.nav_projek: {
                Intent intent_project = new Intent(this, ProjectActivity.class);
                this.startActivity(intent_project);
                break;
            }
        }
        //close navigation drawer
        mDrawLayoutt.closeDrawer(GravityCompat.START);
        return true;
    }

    private void setNavigationViewListner() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view_setting);
        navigationView.setNavigationItemSelectedListener(this);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
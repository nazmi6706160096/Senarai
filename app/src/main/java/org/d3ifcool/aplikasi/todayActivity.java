package org.d3ifcool.aplikasi;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class todayActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout mDrawLayoutt;
    private ActionBarDrawerToggle mToggle;
    public NavigationView navigation_view;
    public Calendar calendar = Calendar.getInstance();
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_today);
        //get name of the day
        TextView day_name = (TextView) findViewById(R.id.day_name);
        String today_name = new SimpleDateFormat("EEEE").format(calendar.getTime());
        day_name.setText(today_name);
        //get date today
        TextView date = (TextView) findViewById(R.id.today_date);
        String date_today = new SimpleDateFormat("dd").format(calendar.getTime());
        date.setText(date_today);
        //get month today
        String monthName = new SimpleDateFormat("MMMM").format(calendar.getTime());
        TextView month_name = (TextView) findViewById(R.id.today_month);
        month_name.setText(monthName);
        //get year today
        String yearName = new SimpleDateFormat("yyyy").format(calendar.getTime());
        TextView year = (TextView) findViewById(R.id.today_year);
        year.setText(yearName);

        todayAdapter adapter = new todayAdapter(this, MainActivity.addZ);
        list = (ListView) findViewById(R.id.list_agenda);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

            }
        });

        setNavigationViewListner();
        navigation_view = (NavigationView)findViewById(R.id.nav_view_today);

        mDrawLayoutt = (DrawerLayout) findViewById(R.id.drawLayout);
        mToggle = new ActionBarDrawerToggle(this, mDrawLayoutt, R.string.open, R.string.close);

        mDrawLayoutt.addDrawerListener(mToggle);
        mToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
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
                break;
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
                Intent intent_projek = new Intent(this, ProjectActivity.class);
                this.startActivity(intent_projek);
                break;
            }
        }
        //close navigation drawer
        mDrawLayoutt.closeDrawer(GravityCompat.START);
        return true;
    }
    private void setNavigationViewListner() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view_today);
        navigationView.setNavigationItemSelectedListener(this);
    }
}
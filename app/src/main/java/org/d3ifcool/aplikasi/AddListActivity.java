package org.d3ifcool.aplikasi;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AddListActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout mDrawLayoutt;
    private ActionBarDrawerToggle mToggle;
    public NavigationView navigation_view;
    private Calendar calendar;
    private String mDate;
    private Boolean mPrioritas = false;
    private static final int RESULT_LOAD_IMG = 100;
    Uri imageUri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_list);

        setNavigationViewListner();
        navigation_view = (NavigationView)findViewById(R.id.nav_view_add_list);

        mDrawLayoutt = (DrawerLayout) findViewById(R.id.drawLayout);
        mToggle = new ActionBarDrawerToggle(this, mDrawLayoutt, R.string.open, R.string.close);

        mDrawLayoutt.addDrawerListener(mToggle);
        mToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    /* btSimpan  */
    public void btSimpan(View view){
        calendar = Calendar.getInstance();
        mDate = new SimpleDateFormat("dd MMMM yyyy").format(calendar.getTime());
        TextView judul = (TextView) findViewById(R.id.judul_textview);
        TextView isi = (TextView) findViewById(R.id.isi_textview);
        MainActivity.addZ.add(0,new addNew(judul.getText().toString(),isi.getText().toString(),mDate,mPrioritas,R.drawable.ic_launcher_background));
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    /* Change Type Of List (Priority or No) */
    public void clickStar(View view){
        ImageView imgStar = (ImageView) findViewById(R.id.image_star_priority);
        if (!mPrioritas){
            imgStar.setImageResource(R.drawable.ic_star_black_24dp);
            mPrioritas = true;
        } else{
            imgStar.setImageResource(R.drawable.ic_star_border_black_24dp);
            mPrioritas = false;
        }
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
                Intent intent_project = new Intent(this, ProjectActivity.class);
                this.startActivity(intent_project);
                break;
            }
        }
        //close navigation drawer
        mDrawLayoutt.closeDrawer(GravityCompat.START);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }

    private void setNavigationViewListner() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view_add_list);
        navigationView.setNavigationItemSelectedListener(this);
    }

    public void btProjek(View view) {
        Toast.makeText(this, "Maaf Fitur Belum Berjalan", Toast.LENGTH_SHORT).show();
    }

    public void btLabel(View view) {
        Toast.makeText(this, "Maaf Fitur Belum Berjalan", Toast.LENGTH_SHORT).show();
    }

    public void btClip(View view) {
        Toast.makeText(this, "Maaf Fitur Belum Berjalan", Toast.LENGTH_SHORT).show();
    }
}
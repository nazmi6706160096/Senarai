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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Detail_ListActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout mDrawLayoutt;
    private ActionBarDrawerToggle mToggle;
    public NavigationView navigation_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail__list);

        setNavigationViewListner();
        navigation_view = (NavigationView)findViewById(R.id.nav_view);

        mDrawLayoutt = (DrawerLayout) findViewById(R.id.drawLayout);
        mToggle = new ActionBarDrawerToggle(this, mDrawLayoutt, R.string.open, R.string.close);

        mDrawLayoutt.addDrawerListener(mToggle);
        mToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //find the textview in activity_detail with id judul_textview_detail
        TextView txtJudul = (TextView) findViewById(R.id.judul_textview_detail);

        //find the textview in activity_detail with id isi_textview_detail
        TextView txtIsi= (TextView) findViewById(R.id.isi_textview_detail);

        //find the textview in activity_detail with id tanggal_detail_list
        TextView txtTanggal = (TextView) findViewById(R.id.tanggal_detail_list);

        //find the imageview in activity_detail with id star_detail_list
        ImageView img_star = (ImageView) findViewById(R.id.star_detail_list);

        Intent intent = getIntent();
        Bundle bd = intent.getExtras();
        if (bd != null){
            //get Intent Extra from Main Activity
            String getJudul = (String) bd.get("judul");
            txtJudul.setText(getJudul);
            String getIsi = (String) bd.get("isi");
            txtIsi.setText(getIsi);
            String getTanggal = (String) bd.get("tanggal");
            txtTanggal.setText(getTanggal);
            Boolean getPrio = (Boolean) bd.get("prioritas");
            if (getPrio.toString().equals("true")) {
                img_star.setVisibility(View.VISIBLE);
            }else {
                img_star.setVisibility(View.INVISIBLE);
            }
        }
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
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }
}
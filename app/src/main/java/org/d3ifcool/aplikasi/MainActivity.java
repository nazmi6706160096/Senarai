package org.d3ifcool.aplikasi;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout mDrawLayoutt;
    private ActionBarDrawerToggle mToggle;
    public NavigationView navigation_view;
    static ArrayList<addNew> addZ = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addNewAdapter addListAdapter = new addNewAdapter(this,addZ);
        ListView listView = (ListView)findViewById(R.id.list);
        listView.setAdapter(addListAdapter);
        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent detail_list = new Intent(MainActivity.this, Detail_ListActivity.class);
                /*
                Bring Judul, isi , tanggal and prioritas to next activity,
                so the next activity(Detail_ListActity) can load value based on name
                */
                detail_list.putExtra("judul",addZ.get(i).getJudul());
                detail_list.putExtra("isi",addZ.get(i).getmIsi());
                detail_list.putExtra("tanggal",addZ.get(i).getmDate());
                detail_list.putExtra("prioritas",addZ.get(i).ismPrioritas());
                startActivity(detail_list);
            }
        });

        setNavigationViewListner();
        navigation_view = (NavigationView)findViewById(R.id.nav_view);
        mDrawLayoutt = (DrawerLayout) findViewById(R.id.drawLayout);
        mToggle = new ActionBarDrawerToggle(this, mDrawLayoutt, R.string.open, R.string.close);
        mDrawLayoutt.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void buttonNew(View view) {
        Intent addList = new Intent(MainActivity.this, AddListActivity.class);
        startActivity(addList);
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
                Toast.makeText(MainActivity.this, "Maaf Fitur Belum Berjalan", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.nav_prioritas: {
                break;
            }
            case R.id.nav_label: {
                Toast.makeText(MainActivity.this, "Maaf Fitur Belum Berjalan", Toast.LENGTH_SHORT).show();
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
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    //Menu Option
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.notif){
            Toast.makeText(MainActivity.this, "Maaf Fitur Belum Berjalan", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.sorting) {
            Toast.makeText(MainActivity.this, "Maaf Fitur Belum Berjalan", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.delete) {
            Toast.makeText(MainActivity.this, "Maaf Fitur Belum Berjalan", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.history){
            Toast.makeText(MainActivity.this, "Maaf Fitur Belum Berjalan", Toast.LENGTH_SHORT).show();
        }
        if (mToggle.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }
}
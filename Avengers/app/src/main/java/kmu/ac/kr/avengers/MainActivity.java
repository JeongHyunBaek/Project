package kmu.ac.kr.avengers;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.estimote.coresdk.common.requirements.SystemRequirementsChecker;
import com.estimote.coresdk.observation.region.beacon.BeaconRegion;
import com.estimote.coresdk.service.BeaconManager;

import java.util.UUID;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener
{
    CustomListViewAdapter customListViewAdapter;
    ListView customList;
    Toolbar toolbar;
    private BeaconManager beaconManager;
    private BeaconRegion region;
    boolean visible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, SplashActivity.class);
        startActivity(intent);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        customList = (ListView) findViewById(R.id.list_main);
        customListViewAdapter = new CustomListViewAdapter();

        String[] daegu_no1 = getResources().getStringArray(R.array.daegu_no1);
        String[] daegu_no2 = getResources().getStringArray(R.array.daegu_no2);
        String[] daegu_no3 = getResources().getStringArray(R.array.daegu_no3);
        // 대구 1호선 데이터 정리
        for (int k = 0; k < daegu_no1.length; k++)
        {
            customListViewAdapter.addItem(getResources().getDrawable(R.drawable.daegu_line1), daegu_no1[k]);
        }
        // 대구 2호선 데이터 정리
        for (int k = 0; k < daegu_no2.length; k++)
        {
            customListViewAdapter.addItem(getResources().getDrawable(R.drawable.daegu_line2), daegu_no2[k]);
        }
        // 대구 3호선 데이터 정리
        for (int k = 0; k < daegu_no3.length; k++)
        {
            customListViewAdapter.addItem(getResources().getDrawable(R.drawable.daegu_line3), daegu_no3[k]);
        }
        customList.setAdapter(customListViewAdapter);

        beaconManager = new BeaconManager(this);
        region = new BeaconRegion("ranged region", UUID.fromString("B9407F30-F5F8-466E-AFF9-25556B57FE6D"), null, null);
    }

    @Override
    public void onBackPressed()
    {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START))
        {
            drawer.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.search_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView)searchItem.getActionView();
        searchView.setQueryHint("역명 검색...");

        final ConstraintLayout layout_contents = (ConstraintLayout)findViewById(R.id.layout_contents);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener()
        {
            @Override
            public boolean onQueryTextSubmit(String query)
            {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText)
            {
                String search = searchView.getQuery().toString();
                customListViewAdapter.filter(search);

                return true;
            }
        });

        searchView.setOnSearchClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String query = searchView.getQuery().toString();
            }
        });

        searchView.setOnCloseListener(new SearchView.OnCloseListener()
        {
            @Override
            public boolean onClose()
            {
                return true;
            }
        });

        searchItem.setOnActionExpandListener(new MenuItem.OnActionExpandListener()
        {
            @Override
            public boolean onMenuItemActionExpand(MenuItem item)
            {
                customList.setVisibility(View.VISIBLE);
                layout_contents.setVisibility(View.GONE);
                visible = true;

                return true;
            }

            @Override
            public boolean onMenuItemActionCollapse(MenuItem item)
            {
                layout_contents.setVisibility(View.VISIBLE);
                customList.setVisibility(View.GONE);
                visible = false;

                return true;
            }
        });
        return true;
 }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item)
    {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.country_settings)
        {
            // Handle the camera action
        }
        else if (id == R.id.schedule)
        {

        }
        else if (id == R.id.settings)
        {

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    protected void onResume()
    {
        super.onResume();

        SystemRequirementsChecker.checkWithDefaultDialogs(this);

        beaconManager.connect(new BeaconManager.ServiceReadyCallback()
        {
            @Override
            public void onServiceReady()
            {
                beaconManager.startRanging(region);
            }
        });
    }

    protected void onPause()
    {
        beaconManager.stopRanging(region);

        super.onPause();
    }
}
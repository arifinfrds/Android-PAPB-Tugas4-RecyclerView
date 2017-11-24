package com.arifinfrds.tugas4recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class OperatingSystemActivity extends AppCompatActivity implements
        OperatingSystemRecyclerViewCallback {

    private ArrayList<OperatingSystem> mOperatingSystems;
    private RecyclerView mRvOperatingSystem;

    private OperatingSystemAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mOperatingSystems = new ArrayList<>();
        mRvOperatingSystem = (RecyclerView) findViewById(R.id.rv_operating_system);

        prepareData();
        setupRecyclerView(mRvOperatingSystem);
    }

    private void prepareData() {
        mOperatingSystems.add(new OperatingSystem(R.drawable.android, "Android"));
        mOperatingSystems.add(new OperatingSystem(R.drawable.ios, "iOS"));
        mOperatingSystems.add(new OperatingSystem(R.drawable.windows_phone_10, "Windows Phone"));
        mOperatingSystems.add(new OperatingSystem(R.drawable.blackberry, "BlackBerry OS"));
        mOperatingSystems.add(new OperatingSystem(R.drawable.webos, "WebOS"));
        mOperatingSystems.add(new OperatingSystem(R.drawable.ubuntu, "Ubuntu"));
        mOperatingSystems.add(new OperatingSystem(R.drawable.windows_10, "Windows"));
        mOperatingSystems.add(new OperatingSystem(R.drawable.macos, "macOS"));
    }

    private void setupRecyclerView(RecyclerView mRvOperatingSystem) {
        mAdapter = new OperatingSystemAdapter(
                mOperatingSystems,
                this,
                this
        );
        mRvOperatingSystem.setAdapter(mAdapter);
        mRvOperatingSystem.setLayoutManager(
                new LinearLayoutManager(
                        this,
                        LinearLayoutManager.VERTICAL,
                        false
                )
        );
    }

    @Override
    public void onItemClick(int position) {
        mOperatingSystems.remove(position);
        mAdapter.notifyItemRemoved(position);
        mAdapter.notifyItemRangeChanged(position, mOperatingSystems.size());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}

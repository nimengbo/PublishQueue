package com.example.abner.publishqueue.activity;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuItem;

import com.example.abner.publishqueue.R;
import com.example.abner.publishqueue.job.PublishJob;
import com.path.android.jobqueue.JobManager;

public class HandlerQueueActivity extends AppCompatActivity {

    JobManager jobManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_queue);
        ActionBar actionbar = getActionBar();
        if(actionbar != null) {
            actionbar.setDisplayHomeAsUpEnabled(true);
        }
        initView();

    }

    private void initView(){
        jobManager.addJobInBackground(new PublishJob(new SparseArray<String>()));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_handler_queue, menu);
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
        }else if(id ==  android.R.id.home){
            onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }
}

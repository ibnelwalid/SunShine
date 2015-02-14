package com.example.yehyakhaled.sunshine;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ShareActionProvider;
import android.widget.TextView;

public class DisplayMessageActivity extends Activity
{
    Intent data;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity2);
        data = getIntent();
        TextView forecast_data = (TextView) findViewById(R.id.forecast_data);
        forecast_data.setText(data.getStringExtra("weatherdata"));

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_display_message, menu);
        MenuItem mItem = menu.findItem(R.id.share);
        ShareActionProvider my_share = (ShareActionProvider) mItem.getActionProvider();
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_STREAM,data.getStringExtra("weatherdata"));
        my_share.setShareIntent(shareIntent);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if(id == R.id.action_settings)
        {
            Log.v("yahia", "will launch settings");
            Intent settings = new Intent(this,SettingActivity.class);
            startActivity(settings);
        }

        return super.onOptionsItemSelected(item);
    }
}

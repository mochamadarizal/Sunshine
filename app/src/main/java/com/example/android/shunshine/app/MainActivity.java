package com.example.android.shunshine.app;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
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

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        ArrayAdapter<String> mAdapterForcast;


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

               String[] data = {
                        "MOn 6/23 - sunny - 31/17",
                        "Tue 6/24 - sunny - 21/17",
                        "Wed 6/25 - cloudy - 57/17",
                        "Thurs 6/26 - sunny - 31/17",
                        "Fry 6/27 - cloudy - 38/17",
                        "Sat 6/28 - sunny - 78/17",
                        "Sun 6/29 - Trapped - 37/17"
            };

            List<String> WeekForecast = new ArrayList<String>(Arrays.asList(data));

            mAdapterForcast = new ArrayAdapter<String>(
                    getActivity(), //id activity
                    R.layout.list_item_forecast, //id layout
                    R.id.list_item_forecast_textview, // ID text view
                    WeekForecast //list data

            );

            ListView listView =(ListView) rootView.findViewById(R.id.listview_forecast);
            listView.setAdapter(mAdapterForcast);
            return rootView;


        }
    }
}

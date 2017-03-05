package com.example.abdulhakim.classtest;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Restaurant> places = new ArrayList<>();
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new GetRestaurants(places,this,lv).execute();


        setContentView(R.layout.activity_main);
        ArrayAdapter<Restaurant> adapter = new CustomAdapter(this, 0, places);

        ListView listView = (ListView) findViewById(R.id.customListView);
        listView.setAdapter(adapter);



    }
    public class GetRestaurants extends AsyncTask<Void, Void, Void> {
        private  String url = "http://192.168.0.17:5000/api/restaurants/search/?key=Burger&col=menu_type";
        private String TAG = MainActivity.class.getSimpleName();
        private ArrayList<Restaurant>places;
        private Context context;
        private Dialog dialog;
        private ListView lv;


        public GetRestaurants(ArrayList<Restaurant> places,Context context,ListView lv) {
            this.places = places;
            this.context=context;
            this.lv=lv;
        }
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            dialog = new ProgressDialog(context,ProgressDialog.STYLE_SPINNER);
            dialog.setCancelable(true);
            dialog.show();
        }
        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            ArrayAdapter<Restaurant> adapter = new CustomAdapter(context, 0, places);
            ListView lv = (ListView) findViewById(R.id.customListView);
            lv.setAdapter(adapter);
            // Dismiss the progress dialog
            if (dialog.isShowing())
                dialog.dismiss();
        }

        protected Void doInBackground(Void... arg0) {
            places = new ArrayList<>();

            HttpHandler sh = new HttpHandler();

            // Making a request to url and getting response
            String jsonStr = sh.makeServiceCall(url);

            Log.e(TAG, "Response from url: " + jsonStr);
            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);

                    // Getting JSON Array node
                    JSONArray restaurants = jsonObj.getJSONArray("restaurants");

                    // looping through the JSON object
                    for (int i = 0; i < restaurants.length(); i++) {
                        JSONObject c = restaurants.getJSONObject(i);

                        String  id = c.getString("id");
                        String name = c.getString("name");
                        String address1 = c.getString("address1");
                        String address2 = c.getString("address2");
                        String lat = c.getString("lat");
                        String lng = c.getString("lng");
                        String cost = c.getString("cost");
                        String menu_type = c.getString("menu_type");
                        String rate = c.getString("rate");
                        String offer = c.getString("offer");
                        // Phone node is JSON Object
                        String mobile = c.getString("phone");

                        places.add(new Restaurant(Integer.parseInt(id),name,address1,address2,Integer.parseInt(mobile)
                                ,Float.parseFloat(lat),Float.parseFloat(lng)
                                ,Integer.parseInt(cost),menu_type,Float.parseFloat(rate),offer));
                    }
                }
                catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());
                }
            } else {
                Log.e(TAG, "Couldn't get json from server.");
            }

            return null;
        }
    }
}

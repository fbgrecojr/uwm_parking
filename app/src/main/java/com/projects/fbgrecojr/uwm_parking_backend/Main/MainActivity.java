package com.projects.fbgrecojr.uwm_parking_backend.Main;

import android.app.ProgressDialog;
import android.content.Context;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.projects.fbgrecojr.uwm_parking_backend.GPSLocation.LocationTracker;
import com.projects.fbgrecojr.uwm_parking_backend.GPSLocation.ProviderLocationTracker;
import com.projects.fbgrecojr.uwm_parking_backend.HttpManager.HttpManager;
import com.projects.fbgrecojr.uwm_parking_backend.HttpManager.RequestPackage;
import com.projects.fbgrecojr.uwm_parking_backend.Parser.JSONParser;
import com.projects.fbgrecojr.uwm_parking_backend.R;
import com.projects.fbgrecojr.uwm_parking_backend.Structures.Building;
import com.projects.fbgrecojr.uwm_parking_backend.Structures.LogItem;
import com.projects.fbgrecojr.uwm_parking_backend.Structures.Lot;
import com.projects.fbgrecojr.uwm_parking_backend.Structures.User;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button one, two, three, four, five, six;
    TextView screen;

    //create a Progress Dialog to be used throughout Activity
    private ProgressDialog p;
    //URL
    public static String uri = "http://ec2-54-152-4-103.compute-1.amazonaws.com/scripts.php";
    //location
    ProviderLocationTracker tracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tracker = new ProviderLocationTracker(MainActivity.this, ProviderLocationTracker.ProviderType.GPS);

        one = (Button) findViewById(R.id.button0);
        two = (Button) findViewById(R.id.button1);
        three = (Button) findViewById(R.id.button2);
        four = (Button) findViewById(R.id.button3);
        five = (Button) findViewById(R.id.button4);
        six = (Button) findViewById(R.id.button5);
        screen = (TextView) findViewById(R.id.textView);

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isOnline()){
                    screen.setText("");
                    //*****FOR EACH CALL TO THE WEBSERVICE, THIS OVERHEAD MUST BE DONE*****
                    //1. Create a RequestPackage Object that will hold all of the information
                    RequestPackage p = new RequestPackage();
                    //2. Set the Request type
                    p.setMethod("GET");
                    //3. Set the URL
                    p.setUri(MainActivity.getUri());
                    //4. Set all of the parameters
                    p.setParam("query", "available");
                    //5. Make a call to a private class extending AsyncTask which will run off of the main thread.
                    new WebserviceCallOne().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, p);
                }else{
                    Toast.makeText(getApplicationContext(), "you are not connected to the internet", Toast.LENGTH_LONG).show();
                }
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isOnline()) {
                    screen.setText("");
                    RequestPackage p = new RequestPackage();
                    p.setMethod("GET");
                    p.setUri(MainActivity.getUri());
                    p.setParam("query", "user");
                    p.setParam("username", "fbgrecojr");
                    new WebserviceCallTwo().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, p);
                } else {
                    Toast.makeText(getApplicationContext(), "you are not connected to the internet", Toast.LENGTH_LONG).show();
                }
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isOnline()) {
                    screen.setText("");
                    RequestPackage p = new RequestPackage();
                    p.setMethod("GET");
                    p.setUri(MainActivity.getUri());
                    p.setParam("query", "log");
                    p.setParam("username", "testuser");
                    p.setParam("day", String.valueOf(formatDay("sunday")));
                    new WebserviceCallThree().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, p);
                } else {
                    Toast.makeText(getApplicationContext(), "you are not connected to the internet", Toast.LENGTH_LONG).show();
                }
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isOnline()) {
                    screen.setText("");
                    RequestPackage p = new RequestPackage();
                    p.setMethod("GET");
                    p.setUri(MainActivity.getUri());
                    p.setParam("query", "insert");
                    p.setParam("username", "fbgrecojr");
                    p.setParam("keyword", "BOLTON");
                    p.setParam("lotName", "test");
                    p.setParam("length", "500");
                    new WebserviceCallFour().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, p);
                } else {
                    Toast.makeText(getApplicationContext(), "you are not connected to the internet", Toast.LENGTH_LONG).show();
                }
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isOnline()) {
                    screen.setText("");
                    RequestPackage p = new RequestPackage();
                    p.setMethod("GET");
                    p.setUri(MainActivity.getUri());
                    p.setParam("query", "buildings");
                    new WebserviceCallFive().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, p);
                } else {
                    Toast.makeText(getApplicationContext(), "you are not connected to the internet", Toast.LENGTH_LONG).show();
                }
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isOnline()) {
                    screen.setText("");
                    RequestPackage p = new RequestPackage();
                    p.setMethod("GET");
                    p.setUri(MainActivity.getUri());
                    p.setParam("query", "add");
                    p.setParam("username", "test2");
                    p.setParam("password", "pass123");
                    p.setParam("first", "joseph");
                    p.setParam("last", "greco");
                    p.setParam("phone", "4141111111");
                    p.setParam("email", "joe@me.com");
                    p.setParam("covered", "false");
                    p.setParam("dist_price", "price");
                    new WebserviceCallSix().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, p);
                } else {
                    Toast.makeText(getApplicationContext(), "you are not connected to the internet", Toast.LENGTH_LONG).show();
                }
            }
        });

        //ideally call this method when the user initiates parking
        tracker.start(new LocationTracker.LocationUpdateListener() {
            @Override
            public void onUpdate(Location oldLoc, long oldTime, Location newLoc, long newTime) {
                NumberFormat formatter = new DecimalFormat("#0.00000");
                //LOG LOCATION UPDATES TO THE CONSOLE FOR DEBUGGING/REFERENCE
                Log.i("LOCATION UPDATED", tracker.hasLocation() ? ("old: [" + oldLoc.getLatitude() + ", " + oldLoc.getLongitude() + "]") : "no previous location");
                Log.i("LOCATION UPDATED", "new: [" + newLoc.getLatitude() + ", " + newLoc.getLongitude() + "]\n");
                Toast.makeText(MainActivity.this, (tracker.hasLocation() ? ("OLD: [" + formatter.format(oldLoc.getLatitude()) + ", " + formatter.format(oldLoc.getLongitude()) + "]") : "no previous location")
                        + "\n" + "NEW: [" + formatter.format(newLoc.getLatitude()) + ", " + formatter.format(newLoc.getLongitude()) + "]", Toast.LENGTH_SHORT).show();
                //this method will be called upon 2 conditions
                //1. minimum, specified distance is covered
                //2. minimum, specified time has passed
                //All that needs to be done here is to call the algorithm


            }
        });

    }

    public int formatDay(String day){
        day = day.toUpperCase();
        switch(day){
            case "MONDAY":
                return 0;
            case "TUESDAY":
                return 1;
            case "WEDNESDAY":
                return 2;
            case "THURSDAY":
                return 3;
            case "FRIDAY":
                return 4;
            case "SATURDAY":
                return 5;
            case "SUNDAY":
                return 6;
            default:
                return -1;
        }
    }

    private static ProgressDialog controlProgressDialog(boolean show, Context context, ProgressDialog p, String message){
        if(show){
            p = new ProgressDialog(context);
            p.setMessage(message);
            p.setIndeterminate(false);
            p.setCancelable(false);
            p.show();
        }
        else{
            p.dismiss();
        }

        return p;
    }

    public void updateDisplay(String append) {
        screen.setText(screen.getText() + append + "\n");
    }

    public void clearScreen(){ screen.setText(""); }


    /**
     * Check to see whether there is an internet connection or not.
     * @return whether there is an internet connection
     */
    public boolean isOnline(){
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }

    public ProgressDialog getP() {
        return p;
    }

    public void setP(ProgressDialog p) {
        this.p = p;
    }

    public static String getUri() {
        return uri;
    }

    public static void setUri(String uri) {
        MainActivity.uri = uri;
    }

    private class WebserviceCallOne extends AsyncTask<RequestPackage, String, List<Lot>> {
        @Override
        protected List<Lot> doInBackground(RequestPackage... params) {

            String content = HttpManager.getData(params[0]);

            return JSONParser.parseLotFeed(content);
        }

        @Override
        protected void onProgressUpdate(String... values) {
        }

        @Override
        protected void onPostExecute(List<Lot> s) {

            MainActivity.controlProgressDialog(false, null, MainActivity.this.getP(), null);

            if(s != null){
                Session.setCurrentLotList(s);
                StringBuilder sb = new StringBuilder();
                for(Lot item : s){
                    sb.append(item.toString() + "\n");
                }
                updateDisplay(sb.toString());
            }
            else updateDisplay("no rows available");
        }

        @Override
        protected void onPreExecute() {

            MainActivity.this.setP(MainActivity.controlProgressDialog(true, MainActivity.this, p, "Getting Information..."));

        }
    }

    private class WebserviceCallTwo extends AsyncTask<RequestPackage, String, User> {
        @Override
        protected User doInBackground(RequestPackage... params) {

            String content = HttpManager.getData(params[0]);

            return JSONParser.parseUserFeed(content);
        }

        @Override
        protected void onProgressUpdate(String... values) {
        }

        @Override
        protected void onPostExecute(User s) {

            MainActivity.controlProgressDialog(false, null, MainActivity.this.getP(), null);

            Session.setCurrentUser(s);
            updateDisplay(s.toString());
        }

        @Override
        protected void onPreExecute() {
            MainActivity.this.setP(MainActivity.controlProgressDialog(true, MainActivity.this, p, "Getting Information..."));
        }
    }

    private class WebserviceCallThree extends AsyncTask<RequestPackage, String, List<LogItem>> {
        @Override
        protected List<LogItem> doInBackground(RequestPackage... params) {

            String content = HttpManager.getData(params[0]);

            return JSONParser.parseLogFeed(content);
        }

        @Override
        protected void onProgressUpdate(String... values) {
        }

        @Override
        protected void onPostExecute(List<LogItem> s) {

            MainActivity.controlProgressDialog(false, null, MainActivity.this.getP(), null);

            if(s != null){
                Session.setCurrentLog(s);
                s = Session.getCurrentLogWithinRange(2, 18, 1);
                StringBuilder sb = new StringBuilder();
                for(LogItem item : s){
                    sb.append(item.toString() + "\n");
                }
                updateDisplay(sb.toString());
            }
            else updateDisplay("no rows available");
        }

        @Override
        protected void onPreExecute() {
            MainActivity.this.setP(MainActivity.controlProgressDialog(true, MainActivity.this, p, "Getting Information..."));
        }
    }

    private class WebserviceCallFour extends AsyncTask<RequestPackage, String, String> {
        @Override
        protected String doInBackground(RequestPackage... params) {

            String content = HttpManager.getData(params[0]);

            return content == null ? "failed" : "successful";
        }

        @Override
        protected void onProgressUpdate(String... values) {
        }

        @Override
        protected void onPostExecute(String s) {

            MainActivity.controlProgressDialog(false, null, MainActivity.this.getP(), null);

            updateDisplay(s);
        }

        @Override
        protected void onPreExecute() {
            MainActivity.this.setP(MainActivity.controlProgressDialog(true, MainActivity.this, p, "Getting Information..."));
        }
    }

    private class WebserviceCallFive extends AsyncTask<RequestPackage, String, List<Building>> {
        @Override
        protected List<Building> doInBackground(RequestPackage... params) {

            String content = HttpManager.getData(params[0]);

            return JSONParser.parseBuildingFeed(content);
        }

        @Override
        protected void onProgressUpdate(String... values) {
        }

        @Override
        protected void onPostExecute(List<Building> s) {

            MainActivity.controlProgressDialog(false, null, MainActivity.this.getP(), null);

            if(s != null){
                Session.setCurrentBuildings(s);
                StringBuilder sb = new StringBuilder();
                for(Building item : s){
                    sb.append(item.toString() + "\n");
                }
                updateDisplay(sb.toString());
            }
            else updateDisplay("no rows available");
        }

        @Override
        protected void onPreExecute() {
            MainActivity.this.setP(MainActivity.controlProgressDialog(true, MainActivity.this, p, "Getting Information..."));
        }
    }

    private class WebserviceCallSix extends AsyncTask<RequestPackage, String, String> {
        @Override
        protected String doInBackground(RequestPackage... params) {

            String content = HttpManager.getData(params[0]);

            return content == null ? "failed" : "successful";
        }

        @Override
        protected void onProgressUpdate(String... values) {
        }

        @Override
        protected void onPostExecute(String s) {

            MainActivity.controlProgressDialog(false, null, MainActivity.this.getP(), null);

            updateDisplay(s);
        }

        @Override
        protected void onPreExecute() {
            MainActivity.this.setP(MainActivity.controlProgressDialog(true, MainActivity.this, p, "Getting Information..."));
        }
    }


}

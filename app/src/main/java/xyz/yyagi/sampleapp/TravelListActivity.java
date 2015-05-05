package xyz.yyagi.sampleapp;

import android.app.Activity;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.orhanobut.wasp.CallBack;
import com.orhanobut.wasp.Wasp;
import com.orhanobut.wasp.WaspError;
import com.orhanobut.wasp.http.Auth;
import com.orhanobut.wasp.parsers.GsonParser;
import com.orhanobut.wasp.utils.LogLevel;

import java.net.CookiePolicy;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import xyz.yyagi.sampleapp.models.Authorization;
import xyz.yyagi.sampleapp.models.Travel;
import xyz.yyagi.sampleapp.services.TravelBaseService;


public class TravelListActivity extends ActionBarActivity {
    Activity mActivity;
    TravelBaseService mService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel_list);
        mActivity = this;

        mService = new Wasp.Builder(this)
                .setEndpoint("https://travel-base.herokuapp.com")   // Must be set
                //.setEndpoint("http://10.0.3.2:3000")        // http://10.0.3.2(genymotion IP)
                .setLogLevel(LogLevel.FULL)              // Optional, default NONE
                .setParser(new GsonParser())             // Optional, default Gson
                .trustCertificates()                     // Optional
                .enableCookies(CookiePolicy.ACCEPT_ALL)  // Optional
                .build()                                 // Must be called
                .create(TravelBaseService.class);        // Must be called

        Map mapBody = new HashMap<>();
        mapBody.put("grant_type", "password");
        mapBody.put("id", BuildConfig.USER_ID);
        mapBody.put("provider", BuildConfig.PROVIDER);

        String authHeader = "Basic ";
        authHeader += Base64.encode((
                BuildConfig.TRAVEL_BASE_API_ID + ":" + BuildConfig.TRAVEL_BASE_API_SECRET).getBytes(), Base64.DEFAULT);

        mService.authenticate(authHeader, mapBody, new CallBack<Authorization>() {
            @Override
            public void onSuccess(Authorization authorization) {
                Toast.makeText(mActivity, "auth success", Toast.LENGTH_LONG).show();

                String authHeader = "Bearer " + authorization.access_token;
                mService.fetchTravels(authHeader, "v1", new CallBack<List<Travel>>() {
                    @Override
                    public void onSuccess(List<Travel> travels) {
                        Toast.makeText(mActivity, "success", Toast.LENGTH_LONG).show();
                        String detail = "";
                        for (Travel travel : travels) {
                            detail += travel.id + " : " + travel.name + "\n";
                        }
                        TextView textView = (TextView)findViewById(R.id.detail);
                        textView.setText(detail);
                    }

                    @Override
                    public void onError(WaspError waspError) {
                        Toast.makeText(mActivity, "error", Toast.LENGTH_LONG).show();
                    }
                });
            }

            @Override
            public void onError(WaspError waspError) {
                Toast.makeText(mActivity, "auth error", Toast.LENGTH_LONG).show();
            }
        });

    }
}

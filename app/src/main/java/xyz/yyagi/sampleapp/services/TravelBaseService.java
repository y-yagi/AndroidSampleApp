package xyz.yyagi.sampleapp.services;

import com.orhanobut.wasp.CallBack;
import com.orhanobut.wasp.http.BodyMap;
import com.orhanobut.wasp.http.GET;
import com.orhanobut.wasp.http.Header;
import com.orhanobut.wasp.http.Mock;
import com.orhanobut.wasp.http.POST;
import com.orhanobut.wasp.http.Path;
import com.orhanobut.wasp.http.RetryPolicy;

import java.util.ArrayList;
import java.util.Map;

import xyz.yyagi.sampleapp.models.Authorization;
import xyz.yyagi.sampleapp.models.Travel;

/**
 * Created by yaginuma on 15/05/05.
 */
public interface TravelBaseService {
    @Mock
    @RetryPolicy(timeout = 5000)
    @POST("/oauth/token")
    void authenticate(
        @Header("Authorization") String authToken,
        @BodyMap Map body,
        CallBack<Authorization> callBack
    );

    @Mock(statusCode = 200, path = "mockData/TravelBaseService.fetchTravels")
    @GET("/api/{version}/travels")
    void fetchTravels(
        @Header("Authorization") String authToken,
        @Path("version") String version,
        CallBack<ArrayList<Travel>> callBack
    );

}

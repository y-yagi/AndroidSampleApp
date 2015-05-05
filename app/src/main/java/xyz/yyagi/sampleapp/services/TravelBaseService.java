package xyz.yyagi.sampleapp.services;

import com.orhanobut.wasp.CallBack;
import com.orhanobut.wasp.http.BodyMap;
import com.orhanobut.wasp.http.GET;
import com.orhanobut.wasp.http.Header;
import com.orhanobut.wasp.http.POST;
import com.orhanobut.wasp.http.Path;

import java.util.List;
import java.util.Map;

import xyz.yyagi.sampleapp.models.Authorization;
import xyz.yyagi.sampleapp.models.Travel;

/**
 * Created by yaginuma on 15/05/05.
 */
public interface TravelBaseService {
    @POST("/oauth/token")
    void authenticate(
        @Header("Authorization") String authToken,
        @BodyMap Map body,
        CallBack<Authorization> callBack
    );

    @GET("/api/{version}/travels")
    void fetchTravels(
        @Header("Authorization") String authToken,
        @Path("version") String version,
        CallBack<List<Travel>> callBack
    );

}

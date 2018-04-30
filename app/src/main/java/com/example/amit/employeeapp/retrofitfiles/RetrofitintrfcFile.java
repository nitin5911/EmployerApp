package com.example.amit.employeeapp.retrofitfiles;

import com.example.amit.employeeapp.mappojofiles.AllmapdataPOJO1;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Amit on 19-12-2017.
 */

public interface RetrofitintrfcFile {

    @GET("directions/json")
    Call<AllmapdataPOJO1> trackapiintrfc_method(@Query("origin") String driverlocation,
                                                @Query("destination") String destlocation,
                                                @Query("units") String units,
                                                @Query("key") String apikey);



}//end of interface file

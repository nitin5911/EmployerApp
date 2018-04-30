package com.example.amit.employeeapp.activities;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.example.amit.employeeapp.R;
import com.example.amit.employeeapp.mappojofiles.AllmapdataPOJO1;
import com.example.amit.employeeapp.retrofitfiles.RetrofitInstancefile;
import com.example.amit.employeeapp.retrofitfiles.RetrofitintrfcFile;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindViews;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TrackingPathMap extends AppCompatActivity  implements OnMapReadyCallback,
        GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener,LocationListener {
    GoogleMap mGoogleMap_obj;
    UiSettings uisettings_obj;
    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;
    GoogleApiClient mGoogleApiClient_obj;
    LocationRequest mLocationRequest;
    MarkerOptions drivermarkerOption_obj,packagemarkerOption_obj;
    double driverlat=30.7223, driverlng=76.7032, packagelat=30.6425, packagelng=76.8173;
    @BindViews({R.id.trackdistanceid,R.id.trackdurationid}) List<TextView> infotxt_obj;
    RetrofitintrfcFile retrofitinterfacefile_obj;
    String track_API_KEY_VALUE ="AIzaSyAT-P7e-zXmiqdpsQ0QafSUVUKlmI8w6Gs";
    ArrayList<String> track_duration_value = new ArrayList<>(),track_distance_value = new ArrayList<>();
    Polyline trackpolyline;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracking_path_map);
        ButterKnife.bind(this);
        //Retrofit file work
        retrofitinterfacefile_obj = RetrofitInstancefile.retrofit_method().create(RetrofitintrfcFile.class);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.trackmapid);
        mapFragment.getMapAsync(this);
    }//end of onCreate method

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mGoogleMap_obj = googleMap;
        mGoogleMap_obj.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        uisettings_obj = mGoogleMap_obj.getUiSettings();
        uisettings_obj.setZoomControlsEnabled(true);
        uisettings_obj.setAllGesturesEnabled(true);
        uisettings_obj.setCompassEnabled(false);
        uisettings_obj.setMapToolbarEnabled(false);
        uisettings_obj.setMyLocationButtonEnabled(false);
        uisettings_obj.setIndoorLevelPickerEnabled(true);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)
            checkLocationPermission();
        else{
            buildGoogleApiClient();
            markeroperations_method();
        }
    }//end of onMapReady method

    //  Here give the permission to access the map location
    private void checkLocationPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)!= PackageManager.PERMISSION_GRANTED){
            // Should we show an explanation
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION)&& ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_COARSE_LOCATION)) {
                new AlertDialog.Builder(this).setTitle("Location Permission Needed")
                        .setMessage("This app needs the Location permission, please accept to use location functionality")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                ActivityCompat.requestPermissions(TrackingPathMap.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, MY_PERMISSIONS_REQUEST_LOCATION);
                                ActivityCompat.requestPermissions(TrackingPathMap.this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, MY_PERMISSIONS_REQUEST_LOCATION);
                            }
                        }).create().show();
            } else
            {
                ActivityCompat.requestPermissions(TrackingPathMap.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, MY_PERMISSIONS_REQUEST_LOCATION);
                ActivityCompat.requestPermissions(TrackingPathMap.this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, MY_PERMISSIONS_REQUEST_LOCATION);
            }
        }
    }//end of checkLocationPermission method

    protected synchronized void buildGoogleApiClient() {
        mGoogleApiClient_obj = new GoogleApiClient.Builder(this).addApi(LocationServices.API).addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this).build();
        mGoogleApiClient_obj.connect();
    }//end of buildGoogleApiClient method

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(10000);
        mLocationRequest.setFastestInterval(10000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient_obj, mLocationRequest, this);
        }
    }//end of onConnected method
    @Override
    public void onConnectionSuspended(int i) {

    }//end of onConnectionSuspended method

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }//end of onConnectionFailed method

    /***** Location Change work ****/
    @Override
    public void onLocationChanged(Location location) {

    }//end of onLocationChanged method

    /***** Marker and Tracking Work *****/
    public void markeroperations_method() {
        //Marker options initialize
        drivermarkerOption_obj = new MarkerOptions();
        packagemarkerOption_obj = new MarkerOptions();
        //marker icon set
        packagemarkerOption_obj.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
        drivermarkerOption_obj.icon(BitmapDescriptorFactory.fromResource(R.drawable.mapcaricon));
        //Add markers
        mGoogleMap_obj.addMarker(packagemarkerOption_obj.position(new LatLng(packagelat, packagelng)).title("Collect Package From Here"));
        mGoogleMap_obj.addMarker(drivermarkerOption_obj.position(new LatLng(driverlat, driverlng)));
        //Move camera on origin location
        mGoogleMap_obj.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(driverlat, driverlng)));
        mGoogleMap_obj.animateCamera(CameraUpdateFactory.zoomTo(15));
        allgoogleapitrackdata_method();
    }//end of marker operations method

    public void allgoogleapitrackdata_method() {
        Call<AllmapdataPOJO1> alldatacall_obj = retrofitinterfacefile_obj.trackapiintrfc_method(driverlat+","+driverlng,
                packagelat+","+packagelng,"metric",track_API_KEY_VALUE);
        alldatacall_obj.enqueue(new Callback<AllmapdataPOJO1>() {
            @Override
            public void onResponse(Call<AllmapdataPOJO1> call, Response<AllmapdataPOJO1> response) {
                if (response.body() != null) {
                    //Distance and duration Arraylist work
                    track_distance_value.add(response.body().getRoutes().get(0).getLegs().get(0).getDistance().getText());
                    track_duration_value.add(response.body().getRoutes().get(0).getLegs().get(0).getDuration().getText());

                    if(track_duration_value!=null && track_duration_value.size()!=0 && track_distance_value!=null && track_distance_value.size()!=0){
                        infotxt_obj.get(0).setText(track_distance_value.get(0));
                        infotxt_obj.get(1).setText(track_duration_value.get(0));
                    }
                    List<LatLng> route_list = decodePoly(response.body().getRoutes().get(0).getOverviewPolyline().getPoints());
                    trackpolyline = mGoogleMap_obj.addPolyline(new PolylineOptions().addAll(route_list).width(22).color(Color.parseColor("#05b1fb")).geodesic(true));
                    List<LatLng> smallroute_list = decodePoly(response.body().getRoutes().get(0).getLegs().get(0).getSteps().get(0).getPolyline().getPoints());
                    trackpolyline = mGoogleMap_obj.addPolyline(new PolylineOptions().addAll(smallroute_list).width(22).color(Color.parseColor("#05b1fb")).geodesic(true));
                }//end of outer if condition
            }//end of onResponse method
            @Override
            public void onFailure(Call<AllmapdataPOJO1> call, Throwable t) {
                Toast.makeText(getApplication(), "" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }//end of onFailure method
        });
    }//end of all google api data method


    private List<LatLng> decodePoly(String encoded) {
        List<LatLng> poly = new ArrayList<>();
        int index = 0, len = encoded.length();
        int lat = 0, lng = 0;

        while (index < len) {
            int b, shift = 0, result = 0;
            do {
                b = encoded.charAt(index++) - 63;
                result |= (b & 0x1f) << shift;
                shift += 5;
            } while (b >= 0x20);
            int dlat = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
            lat += dlat;
            shift = 0;
            result = 0;
            do {
                b = encoded.charAt(index++) - 63;
                result |= (b & 0x1f) << shift;
                shift += 5;
            } while (b >= 0x20);
            int dlng = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
            lng += dlng;
            LatLng p = new LatLng((((double) lat / 1E5)),
                    (((double) lng / 1E5)));
            poly.add(p);
        }
        return poly;
    }//end of decodePoly method


}//end of main class
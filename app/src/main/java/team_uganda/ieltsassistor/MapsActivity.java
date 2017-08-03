package team_uganda.ieltsassistor;


import android.content.Intent;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import android.content.Intent;
import android.graphics.Color;
import android.location.Geocoder;
import android.location.Location;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.Locale;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    double lattitude;
    double longitude;
    LatLng latLng;
    LatLng b_council = new LatLng(24.8861907,91.8791557);
    LatLng nirvana = new LatLng(24.9024239,91.8733639);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        lattitude = extras.getDouble("lattitude");
        longitude = extras.getDouble("longitude");
        latLng = new LatLng(lattitude, longitude);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera


        //mMap.addMarker(new MarkerOptions().position(nirvana).title("IDP IELTS Sylhet office, Sylhet"));
        mMap.addMarker(new MarkerOptions().position(latLng).title("Marker at my place"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 15.2f));

        float results[] = new float[10];
        Location.distanceBetween(lattitude, longitude, 24.8861907, 91.8791557, results);

        mMap.addMarker(new MarkerOptions()
                .position(b_council)
                .title("British Council, Sylhet")
                .snippet("Distance: " + results[0] + " meters"));

        //double distance = (double) Math.sqrt((24.9024239 - lattitude)* (24.9024239 - lattitude) +
        //      (91.8733639 - longitude)*(91.8733639 - longitude));
        Location.distanceBetween(lattitude, longitude, 24.9024239,91.8733639, results);

        mMap.addMarker(new MarkerOptions()
                .position(nirvana)
                .title("IDP IELTS Sylhet office, Sylhet")
                .snippet("Distance: " + results[1] + " km"));
        distanceCalculator();




    }
    private void distanceCalculator() {
        Location me   = new Location("");
        Location dest1 = new Location("");
        Location dest2 = new Location("");

        me.setLatitude(lattitude);
        me.setLongitude(longitude);

        dest1.setLatitude(24.8861907);
        dest1.setLongitude(91.8791557);

        dest2.setLatitude(24.9024239);
        dest2.setLongitude(91.8733639);

        float distance_1 = me.distanceTo(dest1);
        float distance_2 = me.distanceTo(dest2);

        if(distance_1 < distance_2)
        {
            mMap.addPolyline(new PolylineOptions().add(
                    latLng,
                    b_council
                    ).width(10).color(Color.CYAN)
            );
        }
        else
        {
            mMap.addPolyline(new PolylineOptions().add(
                    latLng,
                    nirvana
                    ).width(10).color(Color.CYAN)
            );
        }
        //abncl7rruythfgkjhgjjgh
    } //ghgg//2ueu2gdugedg
}

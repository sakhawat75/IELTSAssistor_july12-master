package team_uganda.ieltsassistor;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class ExamCentre extends AppCompatActivity {
    private Button button;
    private Button button2;
    private TextView textView;
    private TextView textView3;
    private LocationManager locationManager;
    private LocationListener locationListener;
    String string;
    double lattitude;
    double longitude;
    Geocoder geocoder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam_centre);

        //initialize the four objects
        button = (Button) findViewById(R.id.button);
        //button2 = (Button) findViewById(R.id.button2);

        textView = (TextView) findViewById(R.id.textView);
        textView3 = (TextView) findViewById(R.id.textView3);
        geocoder = new Geocoder(this, Locale.getDefault());

        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                textView.setText(null);
                textView3.setText(null);
                string = null;



                //string += "\n " + location.getLatitude() + " " + location.getLongitude();

                //lnj = new LatLng(location.getLatitude(), location.getLongitude());
                lattitude = location.getLatitude();
                longitude = location.getLongitude();
                try {
                    List<android.location.Address> addresses  = geocoder.getFromLocation(lattitude,longitude, 1);
                    textView.append("\n " + "Your Current location: " + addresses.get(0).getAddressLine(0));
                    textView.setBackgroundColor(getResources().getColor(R.color.colorMajenda));
                    string += "\n " +  "Your location is: " + location.getLatitude() + " " + location.getLongitude();
                    Toast.makeText(getApplicationContext(), "Your " + string, Toast.LENGTH_LONG).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                distanceCalculator();


            }

            @Override
            public void onStatusChanged(String s, int i, Bundle bundle) {

            }

            @Override
            public void onProviderEnabled(String s) {

            }

            @Override
            public void onProviderDisabled(String s) {
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(intent);
            }
        };
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{
                        android.Manifest.permission.ACCESS_FINE_LOCATION,
                        android.Manifest.permission.ACCESS_COARSE_LOCATION,
                        android.Manifest.permission.INTERNET

                }, 10);
                return;
            }
        } else {
            //configureButton();

        }

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
            textView3.setText("British Council, Sylhet");
        }
        else
        {
            textView3.setText("IDP IELTS Sylhet office,Sylhet");
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 10:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                    //configureButton();
                    break;
        }
    }

    public void configureButton(View view)
    {

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        locationManager.requestSingleUpdate("gps", locationListener, null);
        //locationManager.requestLocationUpdates("gps", 10000, 0, locationListener);

        textView.setText(null);
        textView.setBackgroundColor(getResources().getColor(R.color.colorWhite));
        textView3.setText(null);
        textView3.setEnabled(false);
//        try {
//            textView3.wait(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        textView3.setBackgroundColor(getResources().getColor(R.color.colorWhite));
        string = null;



        //Toast.makeText(getApplicationContext(), "Location is " + string, Toast.LENGTH_LONG).show();
        //locationManager.removeUpdates(locationListener);
    }



    public void go(View view) {

        Intent intent = new Intent(ExamCentre.this, MapsActivity.class);
        Bundle extras = new Bundle();
        extras.putDouble("lattitude", lattitude);
        extras.putDouble("longitude", longitude);
        intent.putExtras(extras);

        startActivity(intent);
    }

}


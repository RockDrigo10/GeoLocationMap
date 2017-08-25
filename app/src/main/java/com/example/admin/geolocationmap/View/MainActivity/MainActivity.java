package com.example.admin.geolocationmap.View.MainActivity;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.admin.geolocationmap.Injection.mainactivity.DaggerMainActivityComponent;
import com.example.admin.geolocationmap.R;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View {

    private static final int MY_PERMISSIONS_REQUEST_LOCATION = 1;
    private static final int REQUEST_CHECK_SETTINGS = 1;
    @Inject
    MainActivityPresenter presenter;
    EditText etLatitude, etLongitude, etStreet, etCity, etState, etZip, etCountry;
    String lat = "";
    String lon = "";
    String a, b, c, d, e = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etLatitude = (EditText) findViewById(R.id.etLatitude);
        etLongitude = (EditText) findViewById(R.id.etLongitude);
        etCity = (EditText) findViewById(R.id.etCity);
        etState = (EditText) findViewById(R.id.etState);
        etZip = (EditText) findViewById(R.id.etZip);
        etCountry = (EditText) findViewById(R.id.etCountry);
        etStreet = (EditText) findViewById(R.id.etStreet);
        DaggerMainActivityComponent.create().inject(this);
        presenter.attachView(this);
        presenter.getContext(this);
        presenter.init(this);
        presenter.checkLocationActive(this);
    }


    public void getLocationNow(View view) {
        presenter.checkLocationActive(this);
        lat = String.valueOf(etLatitude.getText());
        lon = String.valueOf(etLongitude.getText());
        a = String.valueOf(etStreet.getText());
        b = String.valueOf(etCity.getText());
        c = String.valueOf(etState.getText());
        d = String.valueOf(etZip.getText());
        e = String.valueOf(etCountry.getText());
        switch (view.getId()) {
            case R.id.btnMaps:
                if (lat.equals("") || lon.equals(""))
                    Toast.makeText(this, "Insert Latitude and Longitude", Toast.LENGTH_LONG).show();
                else {
                    presenter.getLocation(etLatitude.getText().toString(), etLongitude.getText().toString());
                }
                break;
            case R.id.btnAddress:
                if (a.equals("") || b.equals("") || c.equals("") || d.equals(""))
                    Toast.makeText(this, "Insert all fields", Toast.LENGTH_LONG).show();
                else
                    presenter.getLocationByAddress(a, b, c, d, e);
                break;
            case R.id.btnGeocode:
                presenter.getLocationByGeo(a, b, c, d, e);
                break;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                } else {
                }
                return;
            }
        }
    }

    @Override
    public void showError(String s) {

    }

    @Override
    public void locationObtained(boolean isObtained) {

    }

    @Override
    public void locationEnabled(boolean isEnabled) {

    }
}

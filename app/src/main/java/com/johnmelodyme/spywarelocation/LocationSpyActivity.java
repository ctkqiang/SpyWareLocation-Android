package com.johnmelodyme.spywarelocation;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.TextView;
import android.widget.Toast;

import com.johnmelodyme.spywarelocation.util.logger;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

public class LocationSpyActivity extends AppCompatActivity {
    private static final String Application = "LocationSpyActivity";
    private Intent OSlocationetting;
    private TextView _display_Location;
    private logger logger;


    @Override
    public void onStart() {
        super.onStart();
        Dexter.withActivity(this).withPermission(Manifest.permission.ACCESS_FINE_LOCATION).withListener(new PermissionListener() {

            @Override
            public void onPermissionGranted(PermissionGrantedResponse permissionGrantedResponse) {
                Toast.makeText(LocationSpyActivity.this, "Location Permission Granted",
                        Toast.LENGTH_SHORT)
                        .show();
            }

            @Override
            public void onPermissionDenied(PermissionDeniedResponse permissionDeniedResponse) {
                if (permissionDeniedResponse.isPermanentlyDenied()) {
                    logger.dev("User DeniedTHe Permission");
                    _GotoLocationSetting();
                    logger.tell("Prompt To Location Setting");
                }
            }

            @Override
            public void onPermissionRationaleShouldBeShown(PermissionRequest permissionRequest, PermissionToken permissionToken) {
                permissionToken.continuePermissionRequest();
            }

        }).check();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Load UIComponent
        _UIComponent();
    }

    private void _UIComponent() {
        _display_Location = findViewById(R.id.displayLocation);
        logger.tell("UI Component Loaded");
    }

    private void _GotoLocationSetting() {
        OSlocationetting = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
        startActivity(OSlocationetting);
    }
}

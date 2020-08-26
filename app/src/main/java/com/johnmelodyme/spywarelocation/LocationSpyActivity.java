package com.johnmelodyme.spywarelocation;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import com.johnmelodyme.spywarelocation.util.logger;

public class LocationSpyActivity extends AppCompatActivity {
    private static final String Application = "LocationSpyActivity";
    private TextView _display_Location;
    private logger logger;

    private void _UIComponent() {
        _display_Location = findViewById(R.id.displayLocation);
        logger.tell("UI Component Loaded");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Load UIComponent
        _UIComponent();

    }
}

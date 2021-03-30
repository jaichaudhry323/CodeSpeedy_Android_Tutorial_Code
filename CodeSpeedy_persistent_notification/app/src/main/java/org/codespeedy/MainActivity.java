package org.codespeedy;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

import org.codespeedy.Service.YourService;
import org.codespeedy.utils.PreferencesManager;

public class MainActivity extends AppCompatActivity {

    ToggleButton mScreenTrackingToggleButton;

    @Override
    public void onCreate(Bundle saved) {
        super.onCreate(saved);
        setContentView(R.layout.activity_main);

        PreferencesManager.init(getApplicationContext());

        if(PreferencesManager.getInstance().getBoolean("track_screen"))
        {
            this.startService(new Intent(this, YourService.class));
        }

        mScreenTrackingToggleButton = findViewById(R.id.screen_tracking_toggle_button);
        mScreenTrackingToggleButton.setOnCheckedChangeListener(
                ((compoundButton, b) -> {

                    if(b)
                    {
                        PreferencesManager.getInstance().putBoolean("track_screen",true);
                        Intent intent = new Intent(this, YourService.class);
                        startService(intent);
                    }
                    else
                    {
                        PreferencesManager.getInstance().putBoolean("track_screen",false);
                        Intent intent = new Intent(this, YourService.class);
                        intent.putExtra("close",true);
                        startService(intent);
                    }
                })
        );

    }
}

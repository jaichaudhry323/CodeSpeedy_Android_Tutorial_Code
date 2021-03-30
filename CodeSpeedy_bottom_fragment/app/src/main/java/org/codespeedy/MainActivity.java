package org.codespeedy;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class MainActivity extends AppCompatActivity {

    Button mBottomFragmentButton;

    @Override
    public void onCreate(Bundle saved) {
        super.onCreate(saved);
        setContentView(R.layout.activity_main);

        mBottomFragmentButton = findViewById(R.id.bottom_fragment_button);

        mBottomFragmentButton.setOnClickListener(v -> {
            BottomSheetDialogFragment bottomSheetDialogFragment = new MyBottomFragment();
            bottomSheetDialogFragment.show(getSupportFragmentManager(), bottomSheetDialogFragment.getTag());
        });
    }
}


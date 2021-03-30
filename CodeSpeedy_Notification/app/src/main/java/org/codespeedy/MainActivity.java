package org.codespeedy;

import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import org.codespeedy.utils.NotificationUtil;

public class MainActivity extends AppCompatActivity {

    Button mSetNotificationButton;

    @Override
    public void onCreate(Bundle saved) {
        super.onCreate(saved);
        setContentView(R.layout.activity_main);

        mSetNotificationButton = findViewById(R.id.set_notification_button);

        NotificationUtil.createChannel(this,"your_notification_channel_id");

        mSetNotificationButton.setOnClickListener(v->{
            NotificationUtil.setNotification(this,"Notification From CodeSpeedy","CodeSpeedy App",200);
        });
    }
}

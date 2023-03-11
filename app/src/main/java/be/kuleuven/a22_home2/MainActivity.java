package be.kuleuven.a22_home2;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;


public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    private final String ESP32_PATH ="http://192.168.4.2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);

        Glide.with(this)
                .load(ESP32_PATH)
                .into(imageView);


        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                Glide.with(MainActivity.this)
                        .load(ESP32_PATH)
                        .into(imageView);
                handler.postDelayed(this, 50); // adjust the delay time as necessary
            }
        };
        handler.post(runnable);


    }
}

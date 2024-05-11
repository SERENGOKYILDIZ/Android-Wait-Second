package com.example.android_wait_second;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    static String TAG = "EREN_SERVER";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myThread myThread = new myThread();
        myThread.start();
    }
    static class myThread extends Thread
    {
        @Override
        public void run() {
            Object lock = new Object();
            while(true)
            {
                synchronized (lock) {
                    try {
                        TimeUnit.SECONDS.sleep(5);
                    } catch (InterruptedException e) {
                        // Handle the exception
                    }
                }
                Log.d(TAG, "run: data");
            }
        }
    }
}
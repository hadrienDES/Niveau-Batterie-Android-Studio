package com.example.mybatterie;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;
import android.widget.TextView;

public class Batterie extends AppCompatActivity {

    private TextView battery;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.battery_main);

        progressBar = (ProgressBar) this.findViewById(R.id.progressBar);
        battery = (TextView) this.findViewById(R.id.battery);
        this.registerReceiver(this.batteryInfo,new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
    }

    private BroadcastReceiver batteryInfo = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {


            int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
            battery.setText(String.valueOf(level)+"%");

            progressBar.setProgress(level);
        }
    };
}

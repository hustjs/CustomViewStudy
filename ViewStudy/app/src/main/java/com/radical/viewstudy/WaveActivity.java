package com.radical.viewstudy;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;

import com.radical.viewstudy.View.WaveView;

public class WaveActivity extends Activity {

    private WaveView mWaveView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wave);
        mWaveView = (WaveView) findViewById(R.id.wave);
        mWaveView.setDuration(5000);
        mWaveView.setStyle(Paint.Style.FILL);
        mWaveView.setColor(Color.RED);
        mWaveView.setInterpolator(new LinearOutSlowInInterpolator());
        mWaveView.start();
        /*mWaveView.postDelayed(new Runnable() {
            @Override
            public void run() {
                mWaveView.stop();
            }
        }, 10000);*/
    }
}

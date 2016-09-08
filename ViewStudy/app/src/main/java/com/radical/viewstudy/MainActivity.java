package com.radical.viewstudy;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ListView;
import android.widget.Toast;

import com.radical.viewstudy.adapter.SimpleAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;

public class MainActivity extends AppCompatActivity {
    private Intent intent;
    private SimpleAdapter adapter;
    private static final ButterKnife.Action<View> ALPHA_FADE = new ButterKnife.Action<View>() {
        @Override
        public void apply(@NonNull View view, int index) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);
            alphaAnimation.setFillBefore(true);
            alphaAnimation.setDuration(2500);
            alphaAnimation.setStartOffset(index * 100);
            view.startAnimation(alphaAnimation);
        }
    };
    @BindView(R.id.list_of_things)
    ListView listOfThings;
    @OnItemClick(R.id.list_of_things)
    void onItemClick(int position) {
        Toast.makeText(this, "You clicked: " + adapter.getItem(position), Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.btn_viewTest)
    void viewTest() {
        intent = new Intent(MainActivity.this, CustomViewTest.class);
        startActivity(intent);
    }

    @OnClick(R.id.btn_viewGroupTest)
    void testViewDragHelper() {
        intent = new Intent(MainActivity.this, ViewDragHelperTest.class);
        startActivity(intent);
    }

    @OnClick(R.id.btn_waveTest)
    void testWaveView() {
        intent = new Intent(MainActivity.this, WaveActivity.class);
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        // Contrived code to use the bound fields.
        adapter = new SimpleAdapter(this);
        listOfThings.setAdapter(adapter);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }
}

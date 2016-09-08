package com.radical.viewstudy;

import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Window;

import com.radical.viewstudy.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ViewDragHelperTest extends AppCompatActivity {
    @BindView(R.id.toolbar_vg)
    Toolbar mToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_view_drag_helper_test);
        ButterKnife.bind(this);
        setSupportActionBar(mToolbar);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            getWindow().setStatusBarColor(getResources().getColor(R.color.colorPrimary));
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
    }
}

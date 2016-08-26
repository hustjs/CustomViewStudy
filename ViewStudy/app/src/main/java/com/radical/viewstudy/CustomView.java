package com.radical.viewstudy;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;

/**
 * Copyright (c)
 * Title.
 * <p/>
 * Description.
 *
 * @author radical
 * @version 1.0
 * @since 2016-08-26
 */
public class CustomView extends TextView {
    private int mViewWidth;
    private Paint mPaint;
    private LinearGradient mLinearGradient;
    private Matrix matrix;
    private float mTranslate;
    private int mRectCount;

    public CustomView(Context context) {
        super(context);
    }

    public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CustomView(Context context, AttributeSet attrs) {

        super(context, attrs);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (mViewWidth == 0) {
            mViewWidth = getMeasuredWidth();
            if (mViewWidth > 0) {
                mPaint = getPaint();
                mLinearGradient = new LinearGradient(0, 0, mViewWidth,
                        0, new int[]{Color.BLUE, 0xffffffff, Color.BLUE},
                        null, Shader.TileMode.CLAMP);
                mPaint.setShader(mLinearGradient);
                matrix = new Matrix();
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        Paint paint1 = new Paint();
        paint.setColor(getResources().getColor(android.R.color.holo_blue_light));
        paint.setStyle(Paint.Style.FILL);
        paint1.setColor(Color.YELLOW);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(),
                paint);
        canvas.drawRect(0, 0, getMeasuredWidth() - 10, getMeasuredHeight() - 10,
                paint1);
        canvas.save();
        super.onDraw(canvas);
        canvas.restore();
        if (matrix != null) {
            mTranslate += mViewWidth / 5;
            if (mTranslate > 2 * mViewWidth) {
                mTranslate = mViewWidth;
            }
            matrix.setTranslate(mTranslate, 0);
            mLinearGradient.setLocalMatrix(matrix);
            postInvalidateDelayed(300);
        }
    }
}

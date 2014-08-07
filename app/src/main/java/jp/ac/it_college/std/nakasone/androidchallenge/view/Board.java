package jp.ac.it_college.std.nakasone.androidchallenge.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class Board extends View {

    private final float mSize;
    private static final float DP_SIZE = 20;
    private static final int HORIZONTAL_BLOCKS = 10;
    private static final int VERTICAL_BLOCKS = 20;

    {
        mSize = DP_SIZE * getResources().getDisplayMetrics().density;
        Log.d("display", "" + getResources().getDisplayMetrics().heightPixels
                + " : " + getResources().getDisplayMetrics().widthPixels
                + " : " + mSize);
    }

    public Board(Context context) {
        super(context);
    }

    public Board(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Board(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.PURPLE);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(0, 0, HORIZONTAL_BLOCKS * mSize, VERTICAL_BLOCKS * mSize, paint);
    }

    public static class Block extends View {
        private Paint mPaint;
        private int mFillColor;
        private int mStrokeColor;
        private float mSize;

        public Block(Context context, int color, float size) {
            super(context);
            mSize = size;
            mPaint = new Paint();
            switch (color) {
                case Color.GRAY:
                    // non break;
                case Color.RED:
                    // non break;
                case Color.BLUE:
                    // non break;
                case Color.CYAN:
                    // non break;
                case Color.GREEN:
                    // non break;
                case Color.YELLOW:
                    // non break;
                case Color.PURPLE:
                    // non break;
                case Color.ORANGE:
                    mFillColor = color;
                    mStrokeColor = Color.BLACK;
                    break;
                default:
                    mFillColor = Color.BLACK;
                    mStrokeColor = Color.LTGRAY;
                    break;
            }
        }

        @Override
        protected void onDraw(Canvas canvas) {
            mPaint.setColor(mFillColor);
            mPaint.setStyle(Paint.Style.FILL);
            canvas.drawRect(0, 0, mSize, mSize, mPaint);
            mPaint.setColor(mStrokeColor);
            mPaint.setStyle(Paint.Style.STROKE);
            mPaint.setStrokeWidth(getResources().getDisplayMetrics().density);
            canvas.drawRect(0, 0, mSize, mSize, mPaint);
        }
    }

    public static class Color extends android.graphics.Color {
        public static final int PURPLE = 0xff800080;
        public static final int ORANGE = 0xfff08000;
    }
}

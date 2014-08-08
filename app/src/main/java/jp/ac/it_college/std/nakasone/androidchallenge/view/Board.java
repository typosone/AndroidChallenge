package jp.ac.it_college.std.nakasone.androidchallenge.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;

import jp.ac.it_college.std.nakasone.androidchallenge.graphics.Block;
import jp.ac.it_college.std.nakasone.androidchallenge.graphics.Tetrimino;

public class Board extends View {

    private final float mSize;
    private static final int HORIZONTAL_BLOCKS = 10;
    private static final int VERTICAL_BLOCKS = 20;
    private int[][] squares;
    private Block[] blocks;

    {
        float density = getResources().getDisplayMetrics().density;
        float wp = getResources().getDisplayMetrics().widthPixels;
        mSize = (wp - 10 * density) * 2 / 3 / HORIZONTAL_BLOCKS;
        squares = new int[HORIZONTAL_BLOCKS][VERTICAL_BLOCKS];
        blocks = new Block[Tetrimino.KINDS + 1];
        blocks[0] = new Block(mSize, Color.BLACK, Color.LTGRAY);
        blocks[1] = new Block(mSize, Color.CYAN, Color.BLACK);
        blocks[2] = new Block(mSize, Color.YELLOW, Color.BLACK);
        blocks[3] = new Block(mSize, Color.GREEN, Color.BLACK);
        blocks[4] = new Block(mSize, Color.RED, Color.BLACK);
        blocks[5] = new Block(mSize, Color.BLUE, Color.BLACK);
        blocks[6] = new Block(mSize, 0xfff08000, Color.BLACK);
        blocks[7] = new Block(mSize, 0xff800080, Color.BLACK);

        // debug
        squares[0][0] = 1;
        squares[1][0] = 1;
        squares[0][1] = 1;
        squares[1][1] = 1;
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
        for (int x = 0; x < HORIZONTAL_BLOCKS; x++) {
            for (int y = 0; y < VERTICAL_BLOCKS; y++) {
                canvas.save();
                canvas.translate(x * mSize, y * mSize);
                blocks[squares[x][y]].onDraw(canvas);
                canvas.restore();
            }
        }
    }


}

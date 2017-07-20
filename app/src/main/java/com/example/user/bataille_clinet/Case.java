package com.example.user.bataille_clinet;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by eric on 2017/7/19.
 */

public class Case {
    private int _x,_y,_width;
    private Paint mypaint;
    private boolean isused =false;



    public Case(int _x, int _y, int _width) {
        this._x = _x;
        this._y = _y;
        this._width = _width;
        mypaint =  new Paint();
        mypaint.setColor(Color.rgb(102,254,204));
    }

    public boolean GetIsused() {
        return isused;
    }

    public void setIsused(boolean isused) {
        this.isused = isused;
        if(this.isused==true)
        {

            mypaint.setColor(Color.RED);
        }
    }

    public int get_x() {
        return _x;
    }

    public void set_x(int _x) {
        this._x = _x;
    }

    public int get_y() {
        return _y;
    }

    public void set_y(int _y) {
        this._y = _y;
    }

    public int get_width() {
        return _width;
    }

    public void set_width(int _width) {
        this._width = _width;
    }

    protected void onDraw(Canvas canvas) {
        Rect rect = new Rect(_x, _y,_x + _width,_y+ _width);
        canvas.drawRect(rect,mypaint);
    }
    public boolean checkhit(int touchx,int touchy)
    {

        if(touchx >=_x && touchx<=(_x+_width))
        {
            return touchy>=_y&&touchy<=(_y+_width);
        }
        else
        {
            return  false;
        }
    }
}

package com.example.user.bataille_clinet;

import android.content.Context;
import android.graphics.Canvas;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

/**
 * Created by eric on 2017/7/19.
 */

public class Battlefield extends View {
    private Context mycontext;
    private  Case[] lescase =new Case[100];
    private  static  final  int rectwidth = 90,X=20,Y=60;
    private  Bateau bateau;
    public static  String statu ="stop" ;

    public Battlefield(Context context,Bateau bateau) {
        super(context);
        this.mycontext =context;
        this.bateau =bateau;
        for(int i=0;i<10;i++)  //  i  行
        {
            for(int j=0;j<10;j++)  //j 列
            {
                lescase[i*10+j] = new Case(X+j*(rectwidth+10),Y+i*(rectwidth+25),rectwidth);
            }
        }

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for(int i=0;i<100;i++)
        {
            lescase[i].onDraw(canvas);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        int touchX = (int) event.getX();
        int touchY = (int) event.getY();
        if(bateau.isalive()==false)
        {
            Toast.makeText(mycontext, "you have lost this game!!", Toast.LENGTH_SHORT).show();
            return true;
        }
        if(Battlefield.statu == "win") {
            Toast.makeText(mycontext, "you have win this game!!", Toast.LENGTH_SHORT).show();
            return true;
        }
        if(Battlefield.statu == "stop") {
            Toast.makeText(mycontext, "game is not started", Toast.LENGTH_SHORT).show();
            return true;
        }
        if (action == MotionEvent.ACTION_DOWN) {

            if(bateau.isCanshoot()==true) {         // this logic test the bateau can shoot or not,if not show message
                for (int i = 0; i < 100; i++) {
                    if (lescase[i].checkhit(touchX, touchY) == true) {
                        if (lescase[i].GetIsused() == false) {
                            lescase[i].setIsused(true);   //设置当前位置为已经使用，下次就不能再用了
                            bateau.shoot(i);
                        }
                        else   // bateau 为不可射击状态
                            Toast.makeText(mycontext, "Le case deja utilise!", Toast.LENGTH_SHORT).show();
                        break;
                    }
                }
            }
            else
                Toast.makeText(mycontext, "Attendre l'ennemi de l'achèvement de l'attaque", Toast.LENGTH_SHORT).show();
        }
            invalidate();
            return true;
        }


}

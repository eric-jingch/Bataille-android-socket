package com.example.user.bataille_clinet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /* setContentView(R.layout.activity_main);
        socketRunable sr = new socketRunable();
        Thread t = new Thread(sr);
        t.start();*/
        Bateau bateau =new Bateau();
        bataillesoceket socket =new bataillesoceket(bateau);
        Thread t =new Thread(socket);
        t.start();
        Battlefield battlefield = new Battlefield(this,bateau);
        setContentView(battlefield);
    }
}

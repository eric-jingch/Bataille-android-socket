package com.example.user.bataille_clinet;

import android.util.Log;

import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Created by user on 2017/7/19.
 */

public class bataillesoceket implements Runnable {
    private Scanner sc;
    private PrintStream pts;
    private Socket socket;
    private InetAddress myadrs;
    private Bateau bateau;
    private final String filtre = "socketRuna";
    private int rep;


    @Override
    public void run() {
        while (Battlefield.statu == "stop") {
            try {
                socket = new Socket("10.1.0.85", 25000);
                sc = new Scanner(socket.getInputStream());// 指定来源为 socket 端口的输入
                pts = new PrintStream(socket.getOutputStream());
                Battlefield.statu = "stared";
                Log.i(filtre, "connect ok!!!!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            while (Battlefield.statu == "stared") {
                rep = sc.nextInt();
                if (rep == 999)   //this is mean i win
                {
                    Battlefield.statu = "win";
                } else {
                    if (rep == bateau.getPosition()) {
                        bateau.destroy();
                        pts.println(999);
                        Battlefield.statu = "loss";
                    } else {
                        bateau.setCanshoot(true);
                    }
                }
                Log.i(filtre, String.valueOf(rep));
                while(bateau.isCanshoot())
                {

                }
                pts.println(bateau.getShootpositon());
            }
        }
        catch (Exception e) {

        }
    }

    public void sentmessage() {
        if(Battlefield.statu=="stared") {
            Log.i(filtre, "shot.....");
            //printStream.println(bateau.getShootpositon());
            try {
                pts.println(33);
            }
            catch (Exception e)
            {
                Log.i(filtre, e.toString());
            }
        }
    }

    public bataillesoceket(Bateau bateau) {
        this.bateau = bateau;
    }
}

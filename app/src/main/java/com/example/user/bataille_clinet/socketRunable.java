package com.example.user.bataille_clinet;

import android.util.Log;

import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by user on 2017/7/19.
 */

public class socketRunable implements Runnable {
    private  int message ;
    private  int rep;
    private Scanner sc2;
    private PrintStream pts;
    private Socket socket;
    private  final String filtre = "socketRuna";
    private InetAddress myadrs;
    @Override
    public void run()
    {
        try
        {
            myadrs = InetAddress.getLocalHost();
            Log.i(filtre, "client:" + myadrs+", attempting to connect ");
            Log.i(filtre, "client attempting to connect ");
            //mettre votre address ip

            socket = new Socket("192.168.100.4",25000);
            sc2 = new Scanner(socket.getInputStream());
            for(int i=0;i<10;i++)
            {
                Log.i(filtre,"value to send to server:" + ++message);
                pts = new PrintStream(socket.getOutputStream());
                Log.i(filtre, "client writing to server");
                pts.println(message);
                //réception de la réponse du serveur
                rep = sc2.nextInt();
                Log.i(filtre, Integer.toString(rep));

            }
            // TODO code application logic here
        }
        catch (IOException ex)
        {

        }

    }
}

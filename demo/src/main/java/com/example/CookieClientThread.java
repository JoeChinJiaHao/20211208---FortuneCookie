package com.example;


import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.plaf.TreeUI;


public class CookieClientThread {
    public static void main(String[] args) throws IOException {
        String hostLocationComb = args[args.length-1];
        Scanner scan = new Scanner(hostLocationComb);
        scan.useDelimiter(":");
        String hostLocation = scan.next();
        String hostPort = scan.nextLine().replace(":","");
        System.out.printf("Looking for Server %s with port number %s \n",hostLocation,hostPort);
        scan.close();
        System.out.println("Type close to end session.\n");
        
        Socket socket = new Socket(hostLocation,Integer.parseInt(hostPort));//Integer.parseInt(hostPort));
        String msg;
        String serverReply;
        try(OutputStream os = socket.getOutputStream();
            InputStream is = socket.getInputStream();
            BufferedOutputStream bos = new BufferedOutputStream(os);
            DataOutputStream dos = new DataOutputStream(bos);
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br1 = new BufferedReader(isr);
            PrintWriter pw = new PrintWriter(os, true);
             ){
            if(socket.isConnected()){
                System.out.println("Connection success from client side!");
            }
            //for client console input
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            msg = "";
               // pw.print("Attempting Connection...\n");
            try{
                //String tLine = br1.readLine();
                //System.out.println(br1.readLine());
                //dos.writeUTF("Attempting connection!");
            }finally{
            }
            while (!msg.equals("close")){
            
                msg = br.readLine();
                //dos.writeUTF(msg);
                //dos.flush();
                pw.println(msg);
                serverReply= br1.readLine();
                System.out.println(serverReply);
                if(msg.equals("get-cookie")){
                    try{
                        //String tLine = br1.readLine();
                        String sss = br1.readLine();

                        System.out.println(sss.substring(12));
                    }finally{
                    }
            }
        }

        }
        socket.close();

    }
}

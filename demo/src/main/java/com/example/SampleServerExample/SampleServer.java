package com.example.SampleServerExample;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SampleServer {
    public static void main(String[] args) throws IOException {
       

        String cookieTxtLoc = args[args.length-1];
        String serverPortNum = args[args.length-2];
        

        System.out.println("Server starting...");
        System.out.printf("Listening at port %s", 12345);//,serverPortNum));
        ServerSocket server = new ServerSocket(12345);//Integer.parseInt(serverPortNum));
        Socket socket = server.accept();
        
        try(InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            DataInputStream dis = new DataInputStream(bis);
            PrintWriter pw = new PrintWriter(os,true);
            //DataOutputStream dos = new DataOutputStream(pw);
            ){
            System.out.println("\n");
            String line = "";
            pw.println("You are connected");
            //System.out.println(pw.checkError());
            pw.flush();
            
            while(!line.equals("exit")) {
                line = dis.readUTF();
                System.out.println("Message:"+ line);
                pw.println("Roger!");
               
                pw.flush();
            }
        }

    }
}

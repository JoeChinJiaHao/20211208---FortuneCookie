package com.example.SampleServerExample;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSplitPaneUI;

public class SampleClient {
    public static void main(String[] args) throws IOException {
        String hostLocationComb = args[args.length-1];
        Scanner scan = new Scanner(hostLocationComb);
        scan.useDelimiter(":");
        String hostLocation = scan.next();
        String hostPort = scan.nextLine().replace(":","");
        System.out.printf("Looking for Server %s with port number %s \n",hostLocation,hostPort);
        scan.close();
        System.out.println("Type exit to end session.\n");
        
        Socket socket = new Socket(hostLocation,Integer.parseInt(hostPort));
        String msg;
        try(OutputStream os = socket.getOutputStream();
            InputStream is = socket.getInputStream();
            BufferedOutputStream bos = new BufferedOutputStream(os);
            DataOutputStream dos = new DataOutputStream(bos);
            
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br1 = new BufferedReader(isr)
            ){
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            msg = "";
            
        while (!msg.equals("exit")){
            try{
                System.out.println(br1.readLine());
            }finally{
                
            }
            msg = br.readLine();
            dos.writeUTF(msg);
            dos.flush();
            
                        
        }

        }
        socket.close();

    }
}

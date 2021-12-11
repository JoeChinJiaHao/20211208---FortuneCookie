package com.example;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class CookieServerThread {
    //main method to set up server which will always be running
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        //Cookie cookie = new Cookie();
        DirCon wc = new DirCon();
        //String cookieTxtLoc = args[args.length-1];
        //String serverPortNum = args[args.length-2];
        String cookieTxtLoc = "cookie_file.txt";
        String serverPortNum = "12345";
        //System.out.println(wc.GetWorkingDirStrForNonJavaFile() + cookieTxtLoc);
        //cookie.LoadCookie(wc.GetWorkingDirStrForNonJavaFile()+ cookieTxtLoc);

        try{
            serverSocket = new ServerSocket(Integer.parseInt(serverPortNum));
            serverSocket.setReuseAddress(true);
            while(true){
                Socket client = serverSocket.accept();
                CookieClientHandler CCH = new CookieClientHandler(client,wc.GetWorkingDirStrForNonJavaFile()+ cookieTxtLoc);
                System.out.println("Request accepted from client");
                //new thread obj for new connection of each client
                
                //make new thread
                new Thread(CCH).start();


            }
        }catch(IOException e){
            e.printStackTrace();
        }
        finally{
            if (serverSocket!=null){
                try{
                    serverSocket.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }


    }

//client handler for multiple clients
private static class CookieClientHandler implements Runnable{
    private Socket clientSocket;
    private Cookie cookie;
    
    //private DirCon wc;
    //constructor
    public CookieClientHandler(Socket socket,String sCookie) throws IOException{
        Cookie sCookie1 = new Cookie();
        clientSocket=socket;
        sCookie1.LoadCookie(sCookie);
        cookie = sCookie1;
        System.out.println("Listening...");
    }

    @Override
    public void run() {

        // TODO Auto-generated method stub
        //import all reader and writer for handling client request
        try {
            if(clientSocket.isConnected()){
            System.out.println("Connection success!");
            }
            //get inputstream of client
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            //get outputstream for client
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            String line="";
            
            //out.print("Connection successful from server side!");
            
            
            
            while(!line.equals("close")){
                //best to set input from socket to string first 
                line=in.readLine();
                System.out.println("Message from client: "+line);
                out.println("Message Received: "+line);
                if(line.equals("get-cookie")){
                    out.println("Cookie-Text "+cookie.ReturnOneRandomCookie());
                }


            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            try{
                clientSocket.close();
            }catch(IOException e){
                e.printStackTrace();
            }   
        }
        
    }
    
}
}
package com.example;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
public class CookieServer {
    public static void main(String[] args) throws IOException {
        //DirCon wc1 = new DirCon();
        Cookie cookie = new Cookie();
        DirCon wc = new DirCon();
        //String cookieTxtLoc = args[args.length-1];
        //String serverPortNum = args[args.length-2];
        String cookieTxtLoc = "cookie_file.txt";
        String serverPortNum = "12345";
        
        //load cookie here
        System.out.println(wc.GetWorkingDirStrForNonJavaFile() + cookieTxtLoc);
        cookie.LoadCookie(wc.GetWorkingDirStrForNonJavaFile()+ cookieTxtLoc);

        System.out.println("Server starting...");
        System.out.printf("Listening at port %s\n", serverPortNum);
        ServerSocket server = new ServerSocket(Integer.parseInt(serverPortNum));
        Socket socket = server.accept();
        
        try(InputStream is = socket.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            DataInputStream dis = new DataInputStream(bis);
            PrintWriter Pw = new PrintWriter(socket.getOutputStream(),true);){
            
            
            String line = "";
            Pw.println("You are connected!");
        
            while(!line.equals("close")) {
                line = dis.readUTF();
                System.out.println("Message:"+ line);
                if(line.equals("get-cookie")){
                    Pw.println("cookie-text "+cookie.ReturnOneRandomCookie());
                }
        }

        //socket.close();


    }
    }
}

package com.example;
    

import java.io.IOException;

import com.example.DirCon;

public class CookieRun {
    public static void main(String[] args) throws IOException {
    DirCon wc = new DirCon();
    Cookie cookie = new Cookie();
    String CookieFileLoc;
    CookieFileLoc = "cookie_file.txt";
    //System.out.println(wc.GetWorkingDirStr());
    //load cookie
    cookie.LoadCookie(wc.GetWorkingDirStr()+CookieFileLoc);
    //cookie list loaded
    //cookie.PSCookieList();
    for(Integer i =0 ; i<=10;i++){
    System.out.println(cookie.ReturnOneRandomCookie());
    }
}
    
}



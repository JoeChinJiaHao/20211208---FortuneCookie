package com.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Cookie {
    public Cookie(){}
    public List<String> CookieList = new ArrayList<String>(); 
    public void LoadCookie(String s) throws IOException{ //load cookie using file location
        Path path = Paths.get(s);
        File file = path.toFile();  
        CookieList.clear();
        //get reader
        BufferedReader in = new BufferedReader(new FileReader(file));
        String line;
        while((line=in.readLine())!=null){
            CookieList.add(line);
        }
        in.close();
    }
    public void PSCookieList(){//print out all items in cookie list
        for(String s:CookieList){
            System.out.println(s);
        }
    }
    public String ReturnOneRandomCookie(){
        Integer numOfCookie = CookieList.size();
        Integer RandomValue = (int) (Math.random()*(numOfCookie-0));
        return CookieList.get(RandomValue);
    }

}

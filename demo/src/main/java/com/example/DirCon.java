package com.example;


import java.nio.file.Path;
import java.nio.file.Paths;

public class DirCon {
    public DirCon(){}
    public Path UD; 
    public String GetWorkingDirStr(){
        Path curPath = Paths.get("");
        String s = curPath.toAbsolutePath().toString()+"/demo/src/main/java/com/example/";
        s=s.replace("\\", "/");
        return s;
    }
    public String GetWorkingDirStrForNonJavaFile(){
        Path curPath = Paths.get("");
        String s = curPath.toAbsolutePath().toString()+"/com/example/";
        s=s.replace("\\", "/");
        return s;
    }

}



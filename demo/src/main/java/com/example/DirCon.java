package com.example;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
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
        System.out.println(s);
        return s;
    }

    //check if there is folder
    public void MakeFile(String s) throws IOException{
        //System.out.println(this.DefaultDBDirStr());
        Path path = Paths.get(this.GetWorkingDirStr()+s);
        File file = path.toFile();
        if(!file.exists()){
            //make file here
            file.createNewFile();
            System.out.printf("File has been created at %s",this.GetWorkingDirStr()+s);
        }else{
            //do nothing
            System.out.printf("There is an existing file with name %s",s);
        }
        
        
    }

    public void MakeFileNonJava(String s) throws IOException{
        Path path = Paths.get(this.GetWorkingDirStrForNonJavaFile()+s);
        File file = path.toFile();
        if(!file.exists()){
            //make file here
            file.createNewFile();
            System.out.printf("File has been created at ",this.GetWorkingDirStrForNonJavaFile()+s);
        }else{
            //do nothing
            System.out.printf("There is an existing file with name %s",s);
        }
    }

}



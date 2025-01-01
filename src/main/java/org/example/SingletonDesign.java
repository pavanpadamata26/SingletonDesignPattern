package org.example;

public class SingletonDesign {
    private static SingletonDesign singleton;
    //private constructor used to prevent the instantiation
    private SingletonDesign(){
        System.out.println("instance is initialized");
    }
    //static factory method ,provides single global access point
    public  static SingletonDesign getInstance(){
        if(singleton==null){
            singleton=new SingletonDesign();
        }
        return singleton;

    }
    public void showMessage(String message){
        System.out.println("message = " + message);
    }
}

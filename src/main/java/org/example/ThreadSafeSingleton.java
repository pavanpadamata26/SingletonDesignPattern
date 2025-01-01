package org.example;

public class ThreadSafeSingleton {
    private static volatile ThreadSafeSingleton instance;
    private ThreadSafeSingleton(){
        System.out.println("Instance is initialized");
    }
    public  static  ThreadSafeSingleton getInstance(){
        if(instance==null){
            synchronized (ThreadSafeSingleton.class){
                if(instance==null){
                    instance=new ThreadSafeSingleton();
                }
            }
        }
        return instance;
    }
    public  void dispaly(){
        System.out.println("instance = " + instance);
    }

}

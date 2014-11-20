package util;

public class ParallelThread implements Runnable {

    public void run() {
        System.out.println("Hello from a thread!");
        try{
        	Thread.sleep(5000);
        	MainUI.clearMessageBar();
        }catch(Exception ex){
        	System.out.println(ex.toString());
        }
        
    }
}
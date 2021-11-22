import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Worker {

    public synchronized void work(){
        String name = Thread.currentThread().getName();
        String filename = name + ".txt";

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filename))){
            writer.write("Thread " + name + " wrote this message");
        } catch (IOException e){
            e.printStackTrace();
        }

        while(true){
            System.out.println(name + " is working");

            //ADD the wait so that other threads can grab these resources (otherwise it is hogged by thread1)
            try{
                wait(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

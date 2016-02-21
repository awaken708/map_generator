package map_generator;

import java.awt.Frame;
import java.util.ArrayList;
import java.util.Random;


public class Test_seq {
    
    public static void main(String[] arg) throws InterruptedException{
        seq map = new seq();
        
        ArrayList<koord> list = new ArrayList();
        Random rnd = new Random();
        for(int i = 0; i < 30; i++){
        koord temp = new koord(rnd.nextInt(490)+5,rnd.nextInt(490)+5);
        list.add(temp);}
        Visual sc = new Visual(map.list_to_array(map.search(list , 500) , 500));
        
        while(true){
         list = new ArrayList();
        
        for(int i = 0; i < 50; i++){
        koord temp = new koord(rnd.nextInt(490)+5,rnd.nextInt(490)+5);
        list.add(temp);}
        sc.set_map(map.list_to_array(map.search(list , 500) , 500));
        sc.repaint();
        
        //Thread.sleep(500);
        
        
        }

    }
        
       
}

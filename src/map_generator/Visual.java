/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package map_generator;

import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author awaken707
 */
public class Visual extends Frame{
    int[][] map_class;
    
    Visual(int[][] map){
        map_class = map;
        
            
        
        setSize(map[0].length,map[0].length);
        setVisible(true);
        addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent ev){System.exit(0);}});
        
    }
    public void set_map(int[][] map){
        map_class = map;
    }
    Image offscreen;
    Graphics g2;
    public void paint(Graphics g){
        
        offscreen = createImage(map_class[0].length,map_class[0].length);
        g2 = offscreen.getGraphics();
        g2.clearRect(0, 0, map_class[0].length, map_class[0].length);
        for(int i = 0; i < map_class[0].length;i++ )
            for(int j = 0; j < map_class[0].length;j++ )
                if(map_class[i][j]>0){
                    g2.setColor(Color.red);
                    g2.drawLine(i,j,i,j);} else
                   {g2.setColor(Color.black);
                    g2.drawLine(i,j,i,j);}
        //if(!offscreen.getGraphics().equals(g))
            g.drawImage(offscreen,0,0, null);
        
        
    }
    public void update(Graphics g){
        paint(g); 
    }
    
}


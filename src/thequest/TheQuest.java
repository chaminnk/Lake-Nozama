/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thequest;

import java.util.ArrayList;

/**
 *
 * @author 160259G
 */
public class TheQuest {
    
    
    public static void main(String[] args) {
        
        
        LakeNozama lake = new LakeNozama(); 
        Grid grid = lake.getGrid();
       
        Warrior nw1 = new Warrior("Altair",grid,grid.getLocation(0, 5),lake);
       
        Warrior nw2 = new Warrior("Robert Langdon",grid,grid.getLocation(9, 0),lake);
        
        SuperWarrior sw1 = new SuperWarrior("Shazam",grid,grid.getLocation(0, 4),lake);
        
        SuperWarrior sw2 = new SuperWarrior("Black Panther",grid,grid.getLocation(10, 0),lake);
        System.out.println("++++++++++++ Number of warriors are " + nw1.getNoOfWarriors() + " +++++++++++++");
        
        lake.startGame();
        
    }   
}


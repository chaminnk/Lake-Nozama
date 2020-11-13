/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thequest;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
class Chest implements Observer{ //also an observable
    private boolean open;
    private GridLocation gl;
    private static ArrayList<Warrior> observers; 
   
    Chest(GridLocation gl){
        this.gl = gl; 
        gl.addObserver(this);
        this.open = false;
        this.observers = new ArrayList<>(); 
        System.out.println("Treasure chest is in (5,5)");
    }
    public GridLocation getGL(){
        return gl;
    }
    public void notifyWarriors(){
       
            for (Warrior w : observers){
                w.setHasWon(true); //observers
            }
        
    }
    @Override
    public void update(Warrior w){
        System.out.println("^*^*^*^*^*^"+w.getInhabitantName()+" WINS!!!^*^*^*^*^*^\n Time taken to win = " + (w.getLake().getEndTime()-w.getLake().getStartTime()) +"ms");
        this.open = true; 
        notifyWarriors();
        try {
            FileWriter file = new FileWriter("E:\\The Quest\\Winner.txt");
            file.write("^*^*^*^*^*^"+w.getInhabitantName()+" WINS!!!^*^*^*^*^*^ \n Time taken to win = " + (w.getLake().getEndTime()-w.getLake().getStartTime()) +"ms" );
            file.close();
        }  
        catch (IOException ex) {
            Logger.getLogger(Chest.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    public ArrayList<Warrior> getObservers() {
        return observers;
    }

    public void setObservers(ArrayList<Warrior> observers) {
        this.observers = observers;
    }
    
}
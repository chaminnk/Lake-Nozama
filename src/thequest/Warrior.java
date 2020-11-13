/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thequest;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author ASUS
 */
class Warrior extends Inhabitant{
    private Fin fin1;
    private Fin fin2;
    private boolean hasFins;
    private boolean mortality;
    private boolean alive;
    private Binocular bino;
    private static int noOfWarriors=0;
    private int randomNum;
    private boolean hasWon;
    private boolean startPos;
    Warrior(String name,Grid g,GridLocation gl,LakeNozama lake){
        super(name,g,gl,lake);
        hasFins = true;
        hasWon = false; 
        getLake().getWarriors().add(this);
        mortality = true;
        alive = true;
        getGL().setOccupied(true); 
        noOfWarriors++;
        startPos = false;
        checkStarting();
    }

    public void checkStarting(){
        if ((getGL().getX()!=0) && (getGL().getX()!=10) && (getGL().getY()!=0) && (getGL().getY()!=10)){
            System.out.println("Warrior " + getInhabitantName() +" is not placed on the border. Please place him on the border and start again.");
              
        }  
        else{
            startPos = true;
        }
    }
    
    public boolean getHasFins(){
        return hasFins;
    }
    public boolean getMortality(){
        return mortality;

    }
    public boolean getAlive(){
        return alive;
    }
    

    
    public void swim(){
       
        int x=0;
        int y=0;
            randomNum = ThreadLocalRandom.current().nextInt(0, 4);
            switch(randomNum){
                case(0):
                    //swimUp();
                    y = 1; 
                break;
                case(1):
                    //swimDown();
                    y=-1;
                break;
                case(2):
                   // swimLeft();
                    x=-1;
                break;
                case(3):
                    //swimRight();
                    x=1;
                break;
            }
        int X=getGL().getX()+x;
        int Y=getGL().getY()+y;
        if(X!=11 && X!=-1 && Y!=11 && Y!=-1){
                        GridLocation gNew= getGrid().getLocation(X,Y); 
                        synchronized(gNew){
                            if (!(gNew.getOccupied())){
                                
                                    getGL().setOccupied(false);
                                    setGL(gNew);
                                    getGL().setOccupied(true); 
                                    System.out.println(getInhabitantName() + " swam to (" + (getGL().getX()) + "," + (getGL().getY()) + ")");
                                    if(getGL().getHasObserver()){
                                        getGL().notifyObserver(this);
                                    }
                                    if(noOfWarriors==0){
                                        System.out.println("/////////// All Warriors are immobilized!!! Game over!! \\\\\\\\\\\\ \n Time taken = " + (getLake().getEndTime()-getLake().getStartTime()) +"s");
                                        try {
                                            FileWriter file = new FileWriter("E:\\The Quest\\Winner.txt");
                                            file.write("/////////// All Warriors are immobilized!!! Game over!! \\\\\\\\\\\\ \n Time taken = " + (getLake().getEndTime()-getLake().getStartTime()) +"s" );
                                            file.close();
                                        }  
                                        catch (IOException ex) {
                                            Logger.getLogger(Chest.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                    }
                                    try{
                                        currentThread().sleep(00);
                                    }
                                    catch(InterruptedException e){

                                    }
                            }
                            else{
                                swim();
                            }
                            }
                            
                                
                    }  
                    else{
                        swim();
                    }
    }
    public int getNoOfWarriors(){
        return noOfWarriors;
    }
    public void pluck(Lotus l){
        if (l.getPetals()>0){
            this.mortality = false;
            System.out.println(getInhabitantName() + " plucked a petal from lotus in " + "(" + (getGL().getX()) + "," + (getGL().getY()) + ") and is immortal now.");
        }
        else{
            System.out.println("Lotus in " + "(" + (getGL().getX()) + "," + (getGL().getY()) + ")" + "has no petals");
        }
    }

    public void die(){
        if (mortality){
            this.alive = false;
            getGL().setOccupied(false);
            noOfWarriors--;
            System.out.println("Warrior " + getInhabitantName() + " is dead!!!");
        }
    }
    public void loseFins(){
        noOfWarriors--;
        this.hasFins = false;
        getGL().setOccupied(false);
        System.out.println("Warrior " + getInhabitantName() + " lost his fins!!! Warrior " + getInhabitantName() + " is stuck in Lake Nozama forever!!!");
    }

    @Override
    public void run(){
        while(alive && hasFins && startPos &&(!(hasWon))){
            swim();  
            
        }
        getLake().setEndTime(System.currentTimeMillis());
                
        
    }
    public  void eat(){

        System.out.println("Normal warrior ate");
    }

    public void sleep(){
        System.out.println("Normal Warrior slept");
    }

    public boolean getHasWon() {
        return hasWon;
    }

    public void setHasWon(boolean hasWon) {
        this.hasWon = hasWon;
    }
    
}


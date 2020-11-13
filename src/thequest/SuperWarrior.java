/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thequest;

import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
class SuperWarrior extends Warrior{
    private int randomNum;
    private boolean mortal;
    private boolean seen; //if the super warrior sees a lotus and that location is occupied,it will continuesly try to enter that location. This boolean prevents it
    SuperWarrior(String name, Grid g, GridLocation gl, LakeNozama lake){
        super(name,g,gl,lake);
        seen=false;
        Binocular bino = new Binocular();
        swim(); 
    }
            
    
    @Override
    public void swim(){
        int x=0;
        int y=0;
        //override swim method in Warrior class 
            mortal=getMortality();
            if ((!seen) && mortal && (!(getGL().getY()+1 == 11)) && (getGrid().getLocation(getGL().getX(), getGL().getY()+1).getHasLotus())){
                //checks upper location if super warrior is mortal
                //doesn't check location if immortal
                seen=true;
                System.out.println(getInhabitantName()+" sees Lotus in ("+getGL().getX()+ "," + (getGL().getY()+ 1) + ")"); 
                y=1;
                        
            }           


            else if ((!seen) && mortal && (!(getGL().getY()-1 == -1)) && (getGrid().getLocation(getGL().getX(), getGL().getY()-1).getHasLotus())){                       
                        seen=true;
                        System.out.println(getInhabitantName()+" sees Lotus in ("+getGL().getX()+ "," + (getGL().getY()-1 )+")"); 
                        y=-1;
            }

            else if ((!seen) && mortal && (!(getGL().getX()-1 == -1)) && (getGrid().getLocation(getGL().getX()-1, getGL().getY()).getHasLotus())){                       
                        seen=true;
                        System.out.println(getInhabitantName()+" sees Lotus in ("+(getGL().getX()-1)+ "," + (getGL().getY())+")"); 
                        x=-1;
            }


            else if ((!seen) && mortal && (!(getGL().getX()+1 == 11)) && (getGrid().getLocation(getGL().getX()+1, getGL().getY()).getHasLotus())){                               
                seen=true;
                x=1;
                System.out.println(getInhabitantName()+" sees Lotus in ("+(getGL().getX()+1)+ "," + getGL().getY() + ")"); 
            }
            else {
                
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
            }
            int X=getGL().getX()+x;
            int Y=getGL().getY()+y;
            if(X!=11 && X!=-1 && Y!=11 && Y!=-1){
                            GridLocation gNew= getGrid().getLocation(X,Y); 
                            synchronized(gNew){        
                                if (!(gNew.getOccupied())){
                                    
                                        seen=false;
                                        getGL().setOccupied(false);
                                        setGL(gNew);
                                        getGL().setOccupied(true); 
                                        System.out.println(getInhabitantName() + " swam to (" + (getGL().getX()) + "," + (getGL().getY()) + ")");
                                        if(getGL().getHasObserver()){
                                                getGL().notifyObserver(this);
                                        }
                                        if(getNoOfWarriors()==0){
                                            System.out.println("/////////// All Warriors are immobilized!!! Game over!! \\\\\\\\\\\\ \n Time taken = " + (getLake().getEndTime()-getLake().getStartTime()) +"ms");
                                            try {
                                                FileWriter file = new FileWriter("E:\\The Quest\\Winner.txt");
                                                file.write("/////////// All Warriors are immobilized!!! Game over!! \\\\\\\\\\\\ \n Time taken = " + (getLake().getEndTime()-getLake().getStartTime()) +"ms" );
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
    @Override
    public  void eat(){
        System.out.println("Super warrior ate");
    }

    @Override
    public void sleep(){
        System.out.println("Super warrior slept");
    }
}

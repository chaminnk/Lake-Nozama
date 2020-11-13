/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thequest;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
/**
 *
 * @author ASUS
 */
class LakeNozama {
    private Grid grid;
    private Chest chest;
    private final int[] border;    
    private int count;
    private int randomNum1;
    private int randomNum2; 
    private Fish f;
    private Lotus l;
    private ArrayList<Warrior> warriors;
    private ArrayList<Inhabitant> inhabitants; 
    private long startTime;
    private long endTime;
    LakeNozama(){         
        border = new int[2];
        border[0]=0;
        border[1]=10;   
        grid = new Grid();
        chest = new Chest(grid.getLocation(5, 5));
        warriors = new ArrayList<>();
        inhabitants = new ArrayList<>(); 
        chest.setObservers(warriors); 
        startTime = 0; 
        endTime = 0;
        System.out.println("++++++++++++ Available Inhabitants are +++++++++++++");
        for (Inhabitant i : inhabitants ){
            System.out.println(i.getInhabitantName());
            
        }
        
        
        
        
        
        
           
               
        count= 0;
        while(count<2){
            randomNum1 = ThreadLocalRandom.current().nextInt(0, 11);
            randomNum2 = ThreadLocalRandom.current().nextInt(0, 11);
            if(!((grid.getLocation(randomNum1, randomNum2).getHasKillerFish())||((randomNum1==5)&&(randomNum2==5)))){
                f = new KillerFish("Killer Fish "+(count+1),grid,grid.getLocation(randomNum1, randomNum2),this);             
                System.out.println("Killer Fish " + (count+1) + " in " + "(" + randomNum1 +","  + randomNum2 + ")");
                count++;         
            }   
        }
        while(count<4){
            randomNum1 = ThreadLocalRandom.current().nextInt(0, 11);
            randomNum2 = ThreadLocalRandom.current().nextInt(0, 11);            
            if(!((grid.getLocation(randomNum1, randomNum2).getHasKillerFish())||(grid.getLocation(randomNum1, randomNum2).getHasThiefFish())||((randomNum1==5)&&(randomNum2==5)))){
                f = new ThiefFish("Thief Fish "+(count-1),grid,grid.getLocation(randomNum1, randomNum2),this);       
                System.out.println("Thief Fish " + (count-1) + " in " + "(" + randomNum1 +","  + randomNum2 + ")");
                count++;
            }
        }
        while(count<6){
            randomNum1 = ThreadLocalRandom.current().nextInt(0, 11);
            randomNum2 = ThreadLocalRandom.current().nextInt(0, 11);    
            if(!((grid.getLocation(randomNum1, randomNum2).getHasKillerFish())||(grid.getLocation(randomNum1, randomNum2).getHasThiefFish())||(grid.getLocation(randomNum1, randomNum2).getHasInnocentFish())||((randomNum1==5)&&(randomNum2==5)))){
                f = new InnocentFish("Innocent Fish "+(count-3),grid,grid.getLocation(randomNum1, randomNum2),this);          
                System.out.println("Innocent Fish " + (count-3) + " in " + "(" + randomNum1 +","  + randomNum2 + ")");
                count++;
            }
        }
        while(count<11){
            randomNum1 = ThreadLocalRandom.current().nextInt(0, 11);
            randomNum2 = ThreadLocalRandom.current().nextInt(0, 11);  
            if(!((grid.getLocation(randomNum1, randomNum2).getHasKillerFish())||(grid.getLocation(randomNum1, randomNum2).getHasThiefFish())||((randomNum1==5)&&(randomNum2==5)))){
                
            
            l = new Lotus(grid.getLocation(randomNum1, randomNum2));           
            System.out.println("Lotus " + (count-5) + " in " + "(" + randomNum1 +","  + randomNum2 + ")");
            count++;
            }
        }
        
            
        
        
    }
    public Chest getChest(){
            return this.chest;
    }
    

    public Grid getGrid() {
        return grid;
    }

    public  ArrayList<Inhabitant> getInhabitants() {
        return inhabitants;
    }
    public  ArrayList<Warrior> getWarriors() {
        return warriors;
    }
    public void startGame(){
        startTime = System.currentTimeMillis(); 
        for (Warrior w : warriors){
            w.start();
        } 
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }
    
}
 
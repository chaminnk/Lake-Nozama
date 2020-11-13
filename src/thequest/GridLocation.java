/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thequest;

/**
 *
 * @author ASUS
 */
class GridLocation {
    private final int x; //grid location is a fixed place
    private final int y;
    private boolean occupied;
    private boolean hasLotus;
    private boolean hasKillerFish;
    private boolean hasThiefFish;
    private boolean hasInnocentFish;
    private Lotus lotus;
    private Observer observer;
    private boolean hasObserver;
    
    GridLocation(int x, int y){
        //assigns [y][x] location
        this.x=x;
        this.y=y;
        occupied = false;
        hasLotus = false;
        hasKillerFish = false;
        hasThiefFish = false;
        hasInnocentFish = false;
        hasObserver = false;
    }
    public void setLotus(Lotus l){
        this.lotus=l;
        this.hasLotus=true;
    }
    public Lotus getLotus(){
        return this.lotus;
    }
    public void setOccupied(boolean occupied){
        this.occupied=occupied;
    }
     public boolean getOccupied(){
        return this.occupied;
    }
   
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public boolean getHasLotus(){
        return this.hasLotus;
    }
    public void setHasLotus(boolean hasLotus){
        this.hasLotus=hasLotus; 
    }
    public boolean getHasKillerFish(){
        return hasKillerFish; 
    }
    public void setHasKillerFish(boolean b){
        this.hasKillerFish = b;
    }
    public boolean getHasThiefFish(){
        return hasThiefFish; 
    }
    public void setHasThiefFish(boolean b){
        this.hasThiefFish = b;
    }

    public boolean getHasInnocentFish() {
        return hasInnocentFish;
    }

    public void setHasInnocentFish(boolean hasInnocentFish) {
        this.hasInnocentFish = hasInnocentFish;
    }
    
    
    public void addObserver(Observer o){
        hasObserver = true;
        this.observer=o;
    }
    public boolean getHasObserver(){
        return hasObserver;
    }
    public void notifyObserver(Warrior w){
        observer.update(w);
    }
}

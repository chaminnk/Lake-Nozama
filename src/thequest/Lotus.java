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
class Lotus implements Observer{ 
    private GridLocation gl ;
    private int petals;
   Lotus(GridLocation gl){
        petals = 100;           
        this.gl = gl;   
        gl.setHasLotus(true);
        gl.addObserver(this);
    }


    public void losePetals(){
        if (petals>0){
            petals--;
            System.out.println("Lotus in " + "(" + gl.getX() + "," + gl.getY() + ")" + " lost a petal. It now has "+ this.petals + " petals.");
        }   
        else {
            gl.setHasLotus(false);
        }
    }
    public int getPetals(){
        return petals; 
    }
    @Override
    public void update(Warrior w){
        if(w.getMortality()){
            w.pluck(this);
            losePetals();
        }
    }
    
}

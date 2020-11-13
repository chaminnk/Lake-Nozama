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
class InnocentFish extends Fish {
    InnocentFish(String name,Grid g, GridLocation gl,LakeNozama lake){
        super(name,g,gl,lake); 
        getGL().setHasInnocentFish(true);
    }
    @Override
    public void update(Warrior w){
        System.out.println("Innocent fish " + getInhabitantName() + " in location (" + getGL().getX() + "," + getGL().getY() + ")");
    }
}

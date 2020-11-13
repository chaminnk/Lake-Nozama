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
class KillerFish extends Fish{
    KillerFish(String name,Grid g,GridLocation gl,LakeNozama lake){ 
        super(name,g,gl,lake);
        getGL().setHasKillerFish(true);
    }
    @Override
    public void update(Warrior w){
        w.die();
        System.out.println("Killer fish " + getInhabitantName() + " in location (" + getGL().getX() + "," + getGL().getY() + ")");
    }   

}
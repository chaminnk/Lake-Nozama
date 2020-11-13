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
class ThiefFish extends Fish{
    ThiefFish(String name, Grid g, GridLocation gl,LakeNozama lake){
       super(name,g,gl,lake);
       getGL().setHasThiefFish(true);
    }
    @Override
    public void update(Warrior w){
        w.loseFins();
        System.out.println("Thief fish " + getInhabitantName() + " in location (" + getGL().getX() + "," + getGL().getY() + ")");
        
    }
        
}
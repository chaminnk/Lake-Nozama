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
abstract class Fish extends Inhabitant implements Observer{
    Fish(String name,Grid g,GridLocation gl,LakeNozama lake){
        super(name,g,gl,lake);
        gl.addObserver(this);
    }
    @Override
    abstract public void update(Warrior w);
}

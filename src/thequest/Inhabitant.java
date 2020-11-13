
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
abstract class Inhabitant extends Thread{
    private String name;
    private Grid g;
    private GridLocation gl;
    private LakeNozama lake;
    Inhabitant(String name,Grid g,GridLocation gl,LakeNozama lake){
        this.name=name;
        this.g=g;
        this.gl=gl;
        this.lake=lake;
        lake.getInhabitants().add(this); 
    }

    public LakeNozama getLake() {
        return lake;
    }
    
    public String getInhabitantName(){
        return this.name;
    }
    public void setInhabitantName(String name){
        this.name = name; 
    }
    public Grid getGrid(){
        return this.g;
    }
    public GridLocation getGL(){
        return this.gl;
    }
    public void setGL(GridLocation gl){
        this.gl=gl;
    }
}
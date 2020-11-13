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
class Grid {
    GridLocation[][] grid;
    Grid(){
        grid = new GridLocation[11][11];
        for (int y=0;y<11;y++){
            for(int x=0;x<11;x++){
                grid[y][x] = new GridLocation(x,y);
                grid[y][x].setOccupied(false);
            }
        }
    }
    public GridLocation getLocation(int x,int y){
        return grid[y][x];
    }
}

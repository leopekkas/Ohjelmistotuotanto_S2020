/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;

/**
 *
 * @author lbsarast
 */
public class Player {
    private String name;
    private int points;

    public Player(String name) {
        this.name = name;
        this.points = 0;
    }
    
    public void incrementPoints() {
        points++;
    }

    public int getPoints() {
        return points;
    }
    
    public String getName() {
        return name;
    }
    
    
}

package logic;

/**
 * Player class
 *
 * @author David Azofeifa H.
 */
public class Player {
	
    private int score = 0;
    private boolean activeTurn;
    private String name;
    
    public Player(String name) {
        this.name = name;
        activeTurn = false;
    }
    
    public void setName(String name) {
    	this.name = name;
    }
    
    public String getName() {
    	return name;
    }
   
    public void switchTurn() {
    	if(this.activeTurn) {
    		this.activeTurn = false;
    	}else {
    		this.activeTurn = true;
    	}
    }

    public boolean getActiveTurn() { return activeTurn; }

    public void setActiveTurn(boolean activeTurn) { this.activeTurn = activeTurn; }
    
    public void scoreSquarePoints() {
    	this.score += 8;
    }
    
    public void scoreTriPoints() {
    	this.score += 6;
    }
    
    public int getScore() {
    	return this.score;
    }
    
    public void setScore(int score) {
    	this.score = score;
    }
  


}

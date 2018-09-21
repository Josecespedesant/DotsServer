package game;

/**
 * Player class
 *
 * @author David Azofeifa H.
 */
public class Player {
	
	int playerType;
    private int score = 0;
    private boolean hasTurn;
    private String name;
    
    public Player(String name, int p) {
    	this.playerType = p;
        this.name = name;
        hasTurn = false;
    }
    
    public void setName(String name) {
    	this.name = name;
    }
    
    public String getName() {
    	return name;
    }
    
    public void setType(int i) {
    	this.playerType = i;
    }
    
    public void switchTurn() {
    	if(this.hasTurn) {
    		this.hasTurn = false;
    	}else {
    		this.hasTurn = true;
    	}
    }

    public void setTurn(boolean turn) {
    	this.hasTurn = turn;
    }
    
    public boolean getHasTurn() {
    	return this.hasTurn;
    }
    
    public void scorePoints() {
    	this.score += 1;
    }
    
    public int getScore() {
    	return this.score;
    }
    
  


}

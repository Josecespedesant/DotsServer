package game;
public class Turnbase{
	GameBoard gb;
	boolean gameOver = false;
	Player p1;
	Player p2;
	
	//Constructor
	public Turnbase(GameBoard gb, Player p1, Player p2)
	{
		this.gb = gb;
		this.p1 = p1;
		this.p2 = p2;
		
		this.p1.setTurn(true);
		this.p2.setTurn(false);
		
		
	}
	
	public boolean checkIsScore(int[][] box)
	{
		for(int i = 0; i < box.length; i++)
		{
			if(box[i][0] == 0)
			{
				return false;
			}
		}
		return true;
		
	}
	
	public boolean checkGameOver(int[][][] allBoxes)
	{
		
		for(int i = 0; i < allBoxes.length; i++)
		{
			for(int x = 0; x < allBoxes[i].length; x++)
			{
				
					if(allBoxes[i][x][0] == 0)
					{
						return false;
					}
				
			}
		}
		return true;
	}
}

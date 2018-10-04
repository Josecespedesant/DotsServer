package logic;

/**
 * @author José Antonio
 *
 */
public class TurnBaseB{
	Logic bl;
	boolean gameOver = false;
	Player p1;
	Player p2;
	
	/**
	 *
	 * @param bl
	 * @param p1
	 * @param p2
	 */
	public TurnBaseB(Logic bl, Player p1, Player p2)
	{
		this.bl = bl;
		this.p1 = p1;
		this.p2 = p2;
		
		this.p1.setActiveTurn(true);
		this.p2.setActiveTurn(false);
		
		
	}
	
	/**
	 * verifies is there's a square
	 * @param box
	 * @return
	 */
	public boolean checkIsScore(int[][] box) {
		
		for(int i = 0; i < box.length; i++)
		{
			if(box[i][0] == 0)
			{
				return false;
			}
		}
		
		return true;
		
	}

	public boolean checkIsScoreTri(int[][] tri) {
		for(int i = 0; i < tri.length; i++)
		{
			if(tri[i][0] == 0)
			{
				return false;
			}
		}
		return true;
	}
	/**
	 * Checks if game is over
	 * @param allBoxes
	 * @param allTriang
	 * @return if all dots have been used
	 */
	public boolean checkGameOver(int[][][] allBoxes, int[][][] allTriang)
	{
		
		for(int i = 0; i < allTriang.length; i++)
		{
			for(int x = 0; x < allTriang[i].length; x++)
			{
				
					if(allTriang[i][x][0] == 0)
					{
						return false;
					}
				
			}
		}
		
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

package logic;

/**
 * Declaraci�n de la clase TurnBaseB.
 * @author Jos� Antonio
 *
 */
public class TurnBaseB{
	BoardLogic bl;
	boolean gameOver = false;
	Player p1;
	Player p2;
	
	/**
	 * Constructor de la clase TurnBaseB que recibe como par�metros la l�gica del juego y ambos jugadores.
	 * @param bl
	 * @param p1
	 * @param p2
	 */
	public TurnBaseB(BoardLogic bl, Player p1, Player p2)
	{
		this.bl = bl;
		this.p1 = p1;
		this.p2 = p2;
		
		this.p1.setTurn(true);
		this.p2.setTurn(false);
		
		
	}
	
	/**
	 * M�todo que verifica si el un cuadrado se termin� de cerrar.
	 * @param box
	 * @return true si el cuadrado se cierra y false si a�n no.
	 */
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
	
	/**
	 * M�todo que verifica si se termin� el juego.
	 * @param allBoxes
	 * @param allTriang
	 * @return true si ya todas las l�neas se usaron y false si a�n no.
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

package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

import matrix.Matrix;


public class GameBoard extends JPanel implements MouseListener{

	/**
	 * 
	 */
	
	Graphics g;
	Matrix matrix = new Matrix(5,5,0);
	
	Player p1;
	Player p2;
	GameFrame gf;
	int gameType;
	Turnbase tb;
	int lineColor;
	
	int[] A1,B1,C1,D1,E1,F1,G1,H1,I1,J1,K1,L1,M1,N1,O1,P1,Q1,R1,S1,T1,U1,V1,W1,X1,Y1,Z1,A2,B2,C2,D2,E2,F2,G2,H2,I2,J2,K2,L2,M2,N2,O2;
	private static final long serialVersionUID = 1L;
	
	//boxes to include line segments
	int[][] box1, box2, box3, box4, box5, box6, box7, box8, box9, box10, box11, box12, box13, box14, box15, box16;
	
	//array to hold all boxes
	int[][][] allBoxes;
	
	//Constructor
	public GameBoard(GameFrame gf)
	{
		
		this.gf = gf;
		this.gameType = this.gf.getGameType();
		
		Dimension d = new Dimension(800,200);
		this.setBackground(Color.black);
		
		//Line color determined by players turn
		this.lineColor = 1;
		
		this.setSize(d);
		this.setPreferredSize(d);
		this.setMaximumSize(d);
		this.setMinimumSize(d);
		
		createLineObjects();
		organizeBoxes();
		this.addMouseListener(this);
		
		
		
		super.repaint();
		
		this.p1	= new Player("Perro",1);
		this.p2	= new Player("Gato",2);
		this.tb = new Turnbase(this, p1, p2);
		
		
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		
		g.setColor(Color.white);
		
		drawGrid(g);

		
		
		/////////////////////////////////////////////////////
		///////////SECTION FOR DRAWING LINES/////////////////
		/////////////////////////////////////////////////////
		
		for(int count = 0; count < this.allBoxes.length; count++)
		{
			int[][] tmpBox = this.allBoxes[count];
			
			for(int count2 = 0; count2 < tmpBox.length; count2++)
			{
				int[] tmpLine = tmpBox[count2];
				
				if(tmpLine[0] == 1)
				{
					g.setColor(Color.red);
				}
				else
				{
					g.setColor(Color.blue);
				}
				
				if(tmpLine[0] > 0)
				{
					g.drawLine(tmpLine[1], tmpLine[2], tmpLine[3], tmpLine[4]);
				}
			}
		}
		this.gf.getFrame().revalidate();
		
		/////////////////////////////////////////////////////
		/////////////////////////////////////////////////////
	}
	
	public void awardRightfulPoints()
	{
		if(this.p1.getHasTurn())
		{
			this.p1.scorePoints();
			
			this.gf.getP1Label().setText(Integer.toString(this.p1.getScore()));
			this.gf.getFrame().revalidate();
			
		}
		else
		{
			this.p2.scorePoints();
			
			this.gf.getP2Label().setText(Integer.toString(this.p2.getScore()));
			this.gf.getFrame().revalidate();
		}
	}
	public void organizeBoxes()
	{
		
		this.box1 = new int[][]{this.A1, this.E1, this.F1, this.J1};
		this.box2 = new int[][]{this.B1, this.F1, this.G1, this.K1};
		this.box3 = new int[][]{this.C1, this.G1, this.H1, this.L1};
		this.box4 = new int[][]{this.D1, this.H1, this.I1, this.M1};
		
		this.box5 = new int[][]{this.J1, this.N1, this.O1, this.S1};
		this.box6 = new int[][]{this.K1, this.O1, this.P1, this.T1};
		this.box7 = new int[][]{this.L1, this.P1, this.Q1, this.U1};
		this.box8 = new int[][]{this.M1, this.Q1, this.R1, this.V1};
		
		this.box9  = new int[][]{this.S1, this.W1, this.X1, this.B2};
		this.box10 = new int[][]{this.T1, this.X1, this.Y1, this.C2};
		this.box11 = new int[][]{this.U1, this.Y1, this.Z1, this.D2};
		this.box12 = new int[][]{this.V1, this.Z1, this.A2, this.E2};
		
		this.box13 = new int[][]{this.B2, this.F2, this.G2, this.K2};
		this.box14 = new int[][]{this.C2, this.G2, this.H2, this.L2};
		this.box15 = new int[][]{this.D2, this.H2, this.I2, this.M2};
		this.box16 = new int[][]{this.E2, this.I2, this.J2, this.N2};
		
		//adds all box objects to allBoxes array
		this.allBoxes = new int[][][]{this.box1, this.box2, this.box3, this.box4, this.box5, this.box6, this.box7, this.box8,	
									  this.box9, this.box10, this.box11, this.box12, this.box13, this.box14, this.box15, this.box16};
	}
	
	public void createLineObjects()
	{
		//Top horizonal
		this.A1 = new int[]{0,30, 10, 120, 10};
		this.B1 = new int[]{0,130, 10, 220, 10};
		this.C1 = new int[]{0,230,10,320,10};
		this.D1 = new int[]{0,330,10,420,10};
		
		this.E1 = new int[]{0,25, 15, 25, 105};
		this.F1 = new int[]{0,125, 15, 125, 105};
		this.G1 = new int[]{0,225, 15, 225, 105};
		this.H1 = new int[]{0,325, 15, 325, 105};
		this.I1 = new int[]{0,425, 15, 425, 105};
		
		//Second horizonal
		this.J1 = new int[]{0,30, 110, 120, 110};
		this.K1 = new int[]{0,130, 110, 220, 110};
		this.L1 = new int[]{0,230,110,320,110};
		this.M1 = new int[]{0,330,110,420,110};
		
		this.N1 = new int[]{0,25, 115, 25, 205};
		this.O1 = new int[]{0,125, 115, 125, 205};
		this.P1 = new int[]{0,225, 115, 225, 205};
		this.Q1 = new int[]{0,325, 115, 325, 205};
		this.R1 = new int[]{0,425, 115, 425, 205};
		
		//third horizonal
		this.S1 = new int[]{0,30, 210, 120, 210};
		this.T1 = new int[]{0,130, 210, 220, 210};
		this.U1 = new int[]{0,230,210,320,210};
		this.V1 = new int[]{0,330,210,420,210};
		
		this.W1 = new int[]{0,25, 215, 25, 305};
		this.X1 = new int[]{0,125, 215, 125, 305};
		this.Y1 = new int[]{0,225, 215, 225, 305};
		this.Z1 = new int[]{0,325, 215, 325, 305};
		this.A2 = new int[]{0,425, 215, 425, 305};
		
		//fourth horizonal
		this.B2 = new int[]{0,30, 310, 120, 310};
		this.C2 = new int[]{0,130, 310, 220, 310};
		this.D2 = new int[]{0,230,310,320,310};
		this.E2 = new int[]{0,330,310,420,310};
		
		this.F2 = new int[]{0,25, 315, 25, 405};
		this.G2 = new int[]{0,125, 315, 125, 405};
		this.H2 = new int[]{0,225, 315, 225, 405};
		this.I2 = new int[]{0,325, 315, 325, 405};
		this.J2 = new int[]{0,425, 315, 425, 405};
		
		//fifth horizonal
		this.K2 = new int[]{0,30, 410, 120, 410};
		this.L2 = new int[]{0,130, 410, 220, 410};
		this.M2 = new int[]{0,230,410,320,410};
		this.N2 = new int[]{0,330,410,420,410};
	}
	

	
	
	/**
	 * Dibuja todos los puntos
	 * @param g
	 */
	public void drawGrid(Graphics g)
	{
		//first row
		g.drawOval(20, 5, 10, 10);
		g.drawOval(120, 5, 10, 10);
		g.drawOval(220, 5, 10, 10);
		g.drawOval(320, 5, 10, 10);
		g.drawOval(420, 5, 10, 10);
		
		//second row
		g.drawOval(20, 105, 10, 10);
		g.drawOval(120, 105, 10, 10);
		g.drawOval(220, 105, 10, 10);
		g.drawOval(320, 105, 10, 10);
		g.drawOval(420, 105, 10, 10);
		
		//third row
		g.drawOval(20, 205, 10, 10);
		g.drawOval(120, 205, 10, 10);
		g.drawOval(220, 205, 10, 10);
		g.drawOval(320, 205, 10, 10);
		g.drawOval(420, 205, 10, 10);
		
		//fourth row
		g.drawOval(20, 305, 10, 10);
		g.drawOval(120, 305, 10, 10);
		g.drawOval(220, 305, 10, 10);
		g.drawOval(320, 305, 10, 10);
		g.drawOval(420, 305, 10, 10);
		
		//fifth row
		g.drawOval(20, 405, 10, 10);
		g.drawOval(120, 405, 10, 10);
		g.drawOval(220, 405, 10, 10);
		g.drawOval(320, 405, 10, 10);
		g.drawOval(420, 405, 10, 10);
		
		this.gf.getFrame().revalidate();
	}
	
	
	
	public void switchPointers()
	{
		if(this.p1.getHasTurn())
		{
			this.gf.setP1TurnPointer();
			this.gf.setP2TurnPointerOff();
		}
		else
		{
			this.gf.setP1TurnPointerOff();
			this.gf.setP2TurnPointer();
		}
	}
	

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println(e.getX() + " " + e.getY());
		
		if(this.p1.getHasTurn())
		{
			this.lineColor = 1;
		}
		else
		{
			this.lineColor = 2;
		}
		//////////////////////////////////////
		////// H O R I Z O N T A L S /////////
		//////////////////////////////////////
		//Top
		
		//A1
		//if((30 < e.getX()) && (e.getX() < 115) && (5 < e.getY()) && (e.getY() < 15))
		if((30 < e.getX()) && (e.getX() < 115) && (0 < e.getY()) && (e.getY() < 30))
		{
			if(this.A1[0] == 0)
			{
				this.A1[0] = this.lineColor;
				
				
				if(this.tb.checkIsScore(this.box1))
				{
					awardRightfulPoints();
				}
				else
				{
					this.p1.switchTurn();
					this.p2.switchTurn();
					this.switchPointers();
					
				}
				
			}
			
			
			
			
			
		}
		//B1
		if((135 < e.getX()) && (e.getX() < 215) && (0 < e.getY()) && (e.getY() < 30))
		{
			
			if(this.B1[0] == 0)
			{
				this.B1[0] = this.lineColor;
				if(this.tb.checkIsScore(this.box2))
				{
					awardRightfulPoints();
				}
				else
				{
					this.p1.switchTurn();
					this.p2.switchTurn();
					this.switchPointers();
				}
				
			}
			
		}
		//C1
		if((235 < e.getX()) && (e.getX() < 315) && (0 < e.getY()) && (e.getY() < 30))
		{
			if(this.C1[0] == 0)
			{
				this.C1[0] = this.lineColor;
				if(this.tb.checkIsScore(this.box3))
				{
					awardRightfulPoints();
				}
				else
				{
					this.p1.switchTurn();
					this.p2.switchTurn();
					this.switchPointers();
				}
				
			}
			
		}
		//D1
		if((335 < e.getX()) && (e.getX() < 415) && (0 < e.getY()) && (e.getY() < 30))
		{
			if(this.D1[0] == 0)
			{
				this.D1[0] = this.lineColor;
				if(this.tb.checkIsScore(this.box4))
				{
					awardRightfulPoints();
				}
				else
				{
					this.p1.switchTurn();
					this.p2.switchTurn();
					this.switchPointers();
				}
				
			}
			
			
		}
		
		//Second Row
		
		//J1
		if((30 < e.getX()) && (e.getX() < 115) && (100 < e.getY()) && (e.getY() < 130))
		{
			if(this.J1[0] == 0)
			{
				this.J1[0] = this.lineColor;
				
				if(this.tb.checkIsScore(this.box1))
				{
					awardRightfulPoints();
				}
				if(this.tb.checkIsScore(this.box5))
				{
					awardRightfulPoints();
				}
				
				if(!(this.tb.checkIsScore(this.box1) || this.tb.checkIsScore(this.box5)))
				{
					this.p1.switchTurn();
					this.p2.switchTurn();
					this.switchPointers();
				}
				
			}
			
			
		}
		
		//K1
		if((135 < e.getX()) && (e.getX() < 215) && (100 < e.getY()) && (e.getY() < 130))
		{
			if(this.K1[0] == 0)
			{
				this.K1[0] = this.lineColor;
				if(this.tb.checkIsScore(this.box2))
				{
					awardRightfulPoints();
				}
				
				if(this.tb.checkIsScore(this.box6))
				{
					awardRightfulPoints();
				}
				if(!(this.tb.checkIsScore(this.box2) || this.tb.checkIsScore(this.box6)))
				{
					this.p1.switchTurn();
					this.p2.switchTurn();
					this.switchPointers();
				}
			}
			
			
		}
		//L1
		if((235 < e.getX()) && (e.getX() < 315) && (100 < e.getY()) && (e.getY() < 130))
		{
			if(this.L1[0] == 0)
			{
				this.L1[0] = this.lineColor;
				if(this.tb.checkIsScore(this.box3))
				{
					awardRightfulPoints();
				}
				
				if(this.tb.checkIsScore(this.box7))
				{
					awardRightfulPoints();
				}
				if(!(this.tb.checkIsScore(this.box3) || this.tb.checkIsScore(this.box7)))
				{
					this.p1.switchTurn();
					this.p2.switchTurn();
					this.switchPointers();
				}
			}
			
			
		}
		
		//M1
		if((335 < e.getX()) && (e.getX() < 415) && (100 < e.getY()) && (e.getY() < 130))
		{
			if(this.M1[0] == 0)
			{
				this.M1[0] = this.lineColor;
				if(this.tb.checkIsScore(this.box4))
				{
					awardRightfulPoints();
				}
				
				if(this.tb.checkIsScore(this.box8))
				{
					awardRightfulPoints();
				}
				if(!(this.tb.checkIsScore(this.box4) || this.tb.checkIsScore(this.box8)))
				{
					this.p1.switchTurn();
					this.p2.switchTurn();
					this.switchPointers();
				}
			}
						
		}
		
		//Third Row
		
		//S1
		if((30 < e.getX()) && (e.getX() < 115) && (200 < e.getY()) && (e.getY() < 230))
		{
			
			if(this.S1[0] == 0)
			{
				this.S1[0] = this.lineColor;
				if(this.tb.checkIsScore(this.box5))
				{
					awardRightfulPoints();
				}
				
				if(this.tb.checkIsScore(this.box9))
				{
					awardRightfulPoints();
				}
				if(!(this.tb.checkIsScore(this.box5) || this.tb.checkIsScore(this.box9)))
				{
					this.p1.switchTurn();
					this.p2.switchTurn();
					this.switchPointers();
				}
			}
				
		}
		
		//T1
		if((135 < e.getX()) && (e.getX() < 215) && (200 < e.getY()) && (e.getY() < 230))
		{
			if(this.T1[0] == 0)
			{
				this.T1[0] = this.lineColor;
				if(this.tb.checkIsScore(this.box6))
				{
					awardRightfulPoints();
				}
				
				if(this.tb.checkIsScore(this.box10))
				{
					awardRightfulPoints();
				}
				if(!(this.tb.checkIsScore(this.box6) || this.tb.checkIsScore(this.box10)))
				{
					this.p1.switchTurn();
					this.p2.switchTurn();
					this.switchPointers();
				}
			}
					
		}
		
		
		//U1
		if((235 < e.getX()) && (e.getX() < 315) && (200 < e.getY()) && (e.getY() < 230))
		{
			if(this.U1[0] == 0)
			{
				this.U1[0] = this.lineColor;
				
				if(this.tb.checkIsScore(this.box7))
				{
					awardRightfulPoints();
				}
				
				if(this.tb.checkIsScore(this.box11))
				{
					awardRightfulPoints();
				}
				if(!(this.tb.checkIsScore(this.box7) || this.tb.checkIsScore(this.box11)))
				{
					this.p1.switchTurn();
					this.p2.switchTurn();
					this.switchPointers();
				}
			}
			
			
			
		}
		
		
		//V1
		if((335 < e.getX()) && (e.getX() < 415) && (200 < e.getY()) && (e.getY() < 230))
		{
			if(this.V1[0] == 0)
			{
				this.V1[0] = this.lineColor;
				
				if(this.tb.checkIsScore(this.box8))
				{
					awardRightfulPoints();
				}
				
				if(this.tb.checkIsScore(this.box12))
				{
					awardRightfulPoints();
				}
				if(!(this.tb.checkIsScore(this.box8) || this.tb.checkIsScore(this.box12)))
				{
					this.p1.switchTurn();
					this.p2.switchTurn();
					this.switchPointers();
				}
			}
			
		}

		//Fourth Row
		
		//B2
		if((30 < e.getX()) && (e.getX() < 115) && (300 < e.getY()) && (e.getY() < 330))
		{
			if(this.B2[0] == 0)
			{
				this.B2[0] = this.lineColor;
				if(this.tb.checkIsScore(this.box9))
				{
					awardRightfulPoints();
				}
				
				if(this.tb.checkIsScore(this.box13))
				{
					awardRightfulPoints();
				}
				if(!(this.tb.checkIsScore(this.box9) || this.tb.checkIsScore(this.box13)))
				{
					this.p1.switchTurn();
					this.p2.switchTurn();
					this.switchPointers();
				}
			}
			
			
		}
		
		
		//C2
		if((135 < e.getX()) && (e.getX() < 215) && (300 < e.getY()) && (e.getY() < 330))
		{
			if(this.C2[0] == 0)
			{
				this.C2[0] = this.lineColor;
				if(this.tb.checkIsScore(this.box10))
				{
					awardRightfulPoints();
				}
				
				if(this.tb.checkIsScore(this.box14))
				{
					awardRightfulPoints();
				}
				if(!(this.tb.checkIsScore(this.box10) || this.tb.checkIsScore(this.box14)))
				{
					this.p1.switchTurn();
					this.p2.switchTurn();
					this.switchPointers();
				}
			}
			
		}
		
		
		//D2
		if((235 < e.getX()) && (e.getX() < 315) && (300 < e.getY()) && (e.getY() < 330))
		{
			if(this.D2[0] == 0)
			{
				this.D2[0] = this.lineColor;
				if(this.tb.checkIsScore(this.box11))
				{
					awardRightfulPoints();
				}
				
				if(this.tb.checkIsScore(this.box15))
				{
					awardRightfulPoints();
				}
				if(!(this.tb.checkIsScore(this.box11) || this.tb.checkIsScore(this.box15)))
				{
					this.p1.switchTurn();
					this.p2.switchTurn();
					this.switchPointers();
				}
			}
			
		}
		
		
		//E2
		if((335 < e.getX()) && (e.getX() < 415) && (300 < e.getY()) && (e.getY() < 330))
		{
			if(this.E2[0] == 0)
			{
				this.E2[0] = this.lineColor;
				if(this.tb.checkIsScore(this.box12))
				{
					awardRightfulPoints();
				}
				
				if(this.tb.checkIsScore(this.box16))
				{
					awardRightfulPoints();
				}
				if(!(this.tb.checkIsScore(this.box12) || this.tb.checkIsScore(this.box16)))
				{
					this.p1.switchTurn();
					this.p2.switchTurn();
					this.switchPointers();
				}
			}
			
			
		}
		
		
		//Fifth Row
		
		//K2
		if((30 < e.getX()) && (e.getX() < 115) && (400 < e.getY()) && (e.getY() < 430))
		{
			
			if(this.K2[0] == 0)
			{
				this.K2[0] = this.lineColor;
				if(this.tb.checkIsScore(this.box13))
				{
					awardRightfulPoints();
				}
				else
				{
					this.p1.switchTurn();
					this.p2.switchTurn();
					this.switchPointers();
				}
			}
			
		}
		
		
		//L2
		if((135 < e.getX()) && (e.getX() < 215) && (400 < e.getY()) && (e.getY() < 430))
		{
			if(this.L2[0] == 0)
			{
				this.L2[0] = this.lineColor;
				if(this.tb.checkIsScore(this.box14))
				{
					awardRightfulPoints();
				}
				else
				{
					this.p1.switchTurn();
					this.p2.switchTurn();
					this.switchPointers();
				}
			}
			
		}
		
		
		//M2
		if((235 < e.getX()) && (e.getX() < 315) && (400 < e.getY()) && (e.getY() < 430))
		{
			if(this.M2[0] == 0)
			{
				this.M2[0] = this.lineColor;
				
				if(this.tb.checkIsScore(this.box15))
				{
					awardRightfulPoints();
				}
				else
				{
					this.p1.switchTurn();
					this.p2.switchTurn();
					this.switchPointers();
				}
			}
			
		}
		
		
		//N2
		if((335 < e.getX()) && (e.getX() < 415) && (400 < e.getY()) && (e.getY() < 430))
		{
			if(this.N2[0] == 0)
			{
				this.N2[0] = this.lineColor;
				if(this.tb.checkIsScore(this.box16))
				{
					awardRightfulPoints();
				}
				else
				{
					this.p1.switchTurn();
					this.p2.switchTurn();
					this.switchPointers();
				}
			}
			
			
		}
		
	
		
		//////////////////////////////////////
		////// V E R T I C A L S     /////////
		//////////////////////////////////////
		//Top
		//E1
		if((15 < e.getX()) && (e.getX() < 35) && (20 < e.getY()) && (e.getY() < 100))
		{
			if(this.E1[0] == 0)
			{
				this.E1[0] = this.lineColor;
				if(this.tb.checkIsScore(this.box1))
				{
					awardRightfulPoints();
				}
				else
				{
					this.p1.switchTurn();
					this.p2.switchTurn();
					this.switchPointers();
				}
			}
			
		}
		
		//F1
		if((115 < e.getX()) && (e.getX() < 135) && (20 < e.getY()) && (e.getY() < 100))
		{
			if(this.F1[0] == 0)
			{
				this.F1[0] = this.lineColor;
				if(this.tb.checkIsScore(this.box1))
				{
					awardRightfulPoints();
				}
				if(this.tb.checkIsScore(this.box2))
				{
					awardRightfulPoints();
				}
				if(!(this.tb.checkIsScore(this.box1) || this.tb.checkIsScore(this.box2)))
				{
					this.p1.switchTurn();
					this.p2.switchTurn();
					this.switchPointers();
				}
			}
		}
		
		//G1
		if((215 < e.getX()) && (e.getX() < 235) && (20 < e.getY()) && (e.getY() < 100))
		{
			if(this.G1[0] == 0)
			{
				this.G1[0] = this.lineColor;
				if(this.tb.checkIsScore(this.box2))
				{
					awardRightfulPoints();
				}
				if(this.tb.checkIsScore(this.box3))
				{
					awardRightfulPoints();
				}
				if(!(this.tb.checkIsScore(this.box2) || this.tb.checkIsScore(this.box3)))
				{
					this.p1.switchTurn();
					this.p2.switchTurn();
					this.switchPointers();
				}
			}
		
		}
		
		//H1
		if((315 < e.getX()) && (e.getX() < 335) && (20 < e.getY()) && (e.getY() < 100))
		{
			if(this.H1[0] == 0)
			{
				this.H1[0] = this.lineColor;
				if(this.tb.checkIsScore(this.box3))
				{
					awardRightfulPoints();
				}
				if(this.tb.checkIsScore(this.box4))
				{
					awardRightfulPoints();
				}
				if(!(this.tb.checkIsScore(this.box3) || this.tb.checkIsScore(this.box4)))
				{
					this.p1.switchTurn();
					this.p2.switchTurn();
					this.switchPointers();
				}
			}
			
		}
		
		//I1
		if((415 < e.getX()) && (e.getX() < 435) && (20 < e.getY()) && (e.getY() < 100))
		{
			if(this.I1[0] == 0)
			{
				this.I1[0] = this.lineColor;
				if(this.tb.checkIsScore(this.box4))
				{
					awardRightfulPoints();
				}
				else
				{
					this.p1.switchTurn();
					this.p2.switchTurn();
					this.switchPointers();
				}
			}
			
		}
		
		
		//Second Row
		//N1
		if((15 < e.getX()) && (e.getX() < 35) && (120 < e.getY()) && (e.getY() < 200))
		{
			if(this.N1[0] == 0)
			{
				this.N1[0] = this.lineColor;
				if(this.tb.checkIsScore(this.box5))
				{
					awardRightfulPoints();
				}
				else
				{
					this.p1.switchTurn();
					this.p2.switchTurn();
					this.switchPointers();
				}
			}
			
		}
		
		//O1
		if((115 < e.getX()) && (e.getX() < 135) && (120 < e.getY()) && (e.getY() < 200))
		{
			if(this.O1[0] == 0)
			{
				this.O1[0] = this.lineColor;
				if(this.tb.checkIsScore(this.box5))
				{
					awardRightfulPoints();
				}
				if(this.tb.checkIsScore(this.box6))
				{
					awardRightfulPoints();
				}
				if(!(this.tb.checkIsScore(this.box5) || this.tb.checkIsScore(this.box6)))
				{
					this.p1.switchTurn();
					this.p2.switchTurn();
					this.switchPointers();
				}
			}
			
		}
		
		//P1
		if((215 < e.getX()) && (e.getX() < 235) && (120 < e.getY()) && (e.getY() < 200))
		{
			if(this.P1[0] == 0)
			{
				this.P1[0] = this.lineColor;
				if(this.tb.checkIsScore(this.box6))
				{
					awardRightfulPoints();
				}
				if(this.tb.checkIsScore(this.box7))
				{
					awardRightfulPoints();
				}
				if(!(this.tb.checkIsScore(this.box6) || this.tb.checkIsScore(this.box7)))
				{
					this.p1.switchTurn();
					this.p2.switchTurn();
					this.switchPointers();
				}
			}
		
		}

		
		//Q1
		if((315 < e.getX()) && (e.getX() < 335) && (120 < e.getY()) && (e.getY() < 200))
		{
			if(this.Q1[0] == 0)
			{
				this.Q1[0] = this.lineColor;
				if(this.tb.checkIsScore(this.box7))
				{
					awardRightfulPoints();
				}
				if(this.tb.checkIsScore(this.box8))
				{
					awardRightfulPoints();
				}
				if(!(this.tb.checkIsScore(this.box7) || this.tb.checkIsScore(this.box8)))
				{
					this.p1.switchTurn();
					this.p2.switchTurn();
					this.switchPointers();
				}
			}			
		}
		
		//R1
		if((415 < e.getX()) && (e.getX() < 435) && (120 < e.getY()) && (e.getY() < 200))
		{
			if(this.R1[0] == 0)
			{
				this.R1[0] = this.lineColor;
				if(this.tb.checkIsScore(this.box8))
				{
					awardRightfulPoints();
				}
				else
				{
					this.p1.switchTurn();
					this.p2.switchTurn();
					this.switchPointers();
				}
			}
			
		}

		
		//third Row
		//W1
		if((15 < e.getX()) && (e.getX() < 35) && (220 < e.getY()) && (e.getY() < 300))
		{
			if(this.W1[0] == 0)
			{
				this.W1[0] = this.lineColor;
				if(this.tb.checkIsScore(this.box9))
				{
					awardRightfulPoints();
				}
				else
				{
					this.p1.switchTurn();
					this.p2.switchTurn();
					this.switchPointers();
				}
			}			
		}
		
		//X1
		if((115 < e.getX()) && (e.getX() < 135) && (220 < e.getY()) && (e.getY() < 300))
		{
			if(this.X1[0] == 0)
			{
				this.X1[0] = this.lineColor;
				if(this.tb.checkIsScore(this.box9))
				{
					awardRightfulPoints();
				}
				if(this.tb.checkIsScore(this.box10))
				{
					awardRightfulPoints();
				}
				if(!(this.tb.checkIsScore(this.box9) || this.tb.checkIsScore(this.box10)))
				{
					this.p1.switchTurn();
					this.p2.switchTurn();
					this.switchPointers();
				}
			}
		}

		
		//Y1
		if((215 < e.getX()) && (e.getX() < 235) && (220 < e.getY()) && (e.getY() < 300))
		{
			if(this.Y1[0] == 0)
			{
				this.Y1[0] = this.lineColor;
				if(this.tb.checkIsScore(this.box10))
				{
					awardRightfulPoints();
				}
				if(this.tb.checkIsScore(this.box11))
				{
					awardRightfulPoints();
				}
				if(!(this.tb.checkIsScore(this.box10) || this.tb.checkIsScore(this.box11)))
				{
					this.p1.switchTurn();
					this.p2.switchTurn();
					this.switchPointers();
				}
			}
		}

		//Z1
		if((315 < e.getX()) && (e.getX() < 335) && (220 < e.getY()) && (e.getY() < 300))
		{
			if(this.Z1[0] == 0)
			{
				this.Z1[0] = this.lineColor;
				if(this.tb.checkIsScore(this.box11))
				{
					awardRightfulPoints();
				}
				if(this.tb.checkIsScore(this.box12))
				{
					awardRightfulPoints();
				}
				if(!(this.tb.checkIsScore(this.box11) || this.tb.checkIsScore(this.box12)))
				{
					this.p1.switchTurn();
					this.p2.switchTurn();
					this.switchPointers();
				}
			}
		
		}
		
		//A2
		if((415 < e.getX()) && (e.getX() < 435) && (220 < e.getY()) && (e.getY() < 300))
		{
			if(this.A2[0] == 0)
			{
				this.A2[0] = this.lineColor;
				if(this.tb.checkIsScore(this.box12))
				{
					awardRightfulPoints();
				}
				else
				{
					this.p1.switchTurn();
					this.p2.switchTurn();
					this.switchPointers();
				}
			}
			
			
			
		}
		
		//fourth Row
		//F2
		if((15 < e.getX()) && (e.getX() < 35) && (320 < e.getY()) && (e.getY() < 400))
		{
			if(this.F2[0] == 0)
			{
				this.F2[0] = this.lineColor;
				if(this.tb.checkIsScore(this.box13))
				{
					awardRightfulPoints();
				}
				else
				{
					this.p1.switchTurn();
					this.p2.switchTurn();
					this.switchPointers();
				}
			}
			
		}

		//G2
		if((115 < e.getX()) && (e.getX() < 135) && (320 < e.getY()) && (e.getY() < 400))
		{
			if(this.G2[0] == 0)
			{
				this.G2[0] = this.lineColor;
				if(this.tb.checkIsScore(this.box13))
				{
					awardRightfulPoints();
				}
				if(this.tb.checkIsScore(this.box14))
				{
					awardRightfulPoints();
				}
				if(!(this.tb.checkIsScore(this.box13) || this.tb.checkIsScore(this.box14)))
				{
					this.p1.switchTurn();
					this.p2.switchTurn();
					this.switchPointers();
				}
			}
		}
		
		//H2
		if((215 < e.getX()) && (e.getX() < 235) && (320 < e.getY()) && (e.getY() < 400))
		{
			if(this.H2[0] ==0)
			{
				this.H2[0] = this.lineColor;
				if(this.tb.checkIsScore(this.box14))
				{
					awardRightfulPoints();
				}
				if(this.tb.checkIsScore(this.box15))
				{
					awardRightfulPoints();
				}
				if(!(this.tb.checkIsScore(this.box14) || this.tb.checkIsScore(this.box15)))
				{
					this.p1.switchTurn();
					this.p2.switchTurn();
					this.switchPointers();
				}
			}
			
		}
		
		//I2
		if((315 < e.getX()) && (e.getX() < 335) && (320 < e.getY()) && (e.getY() < 400))
		{
			if(this.I2[0] == 0)
			{
				this.I2[0] = this.lineColor;
				if(this.tb.checkIsScore(this.box15))
				{
					awardRightfulPoints();
				}
				if(this.tb.checkIsScore(this.box16))
				{
					awardRightfulPoints();
				}
				if(!(this.tb.checkIsScore(this.box15) || this.tb.checkIsScore(this.box16)))
				{
					this.p1.switchTurn();
					this.p2.switchTurn();
					this.switchPointers();
				}
			}
			
		}
		
		//J2
		if((415 < e.getX()) && (e.getX() < 435) && (320 < e.getY()) && (e.getY() < 400))
		{
			if(this.J2[0] == 0)
			{
				this.J2[0] = this.lineColor;
				if(this.tb.checkIsScore(this.box16))
				{
					awardRightfulPoints();
				}
				else
				{
					this.p1.switchTurn();
					this.p2.switchTurn();
					this.switchPointers();
				}
			}
			
			
		}
		
		
		this.repaint();
		if(this.gameType > 1)
		{
			while(this.p2.getHasTurn())
			{
				int r = 0;
				if(r == 0)
				{
					this.p1.switchTurn();
					this.p2.switchTurn();
					this.switchPointers();
				}
			}
		}
		this.repaint();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub	
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub	
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}
}

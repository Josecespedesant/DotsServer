package game;

import java.awt.event.MouseListener;

import com.sun.glass.events.MouseEvent;

import matrix.Matrix;

public class BoardLogic implements MouseListener{
	Matrix matrix = new Matrix(9,9,0);
	Player p1;
	Player p2;
	TurnBaseB tb;
	int[] A1, B1, C1, D1, A2, B2, C2, D2, A3, B3, C3, D3, A4, B4, C4, D4, A5, B5, C5, D5;
	int[] E1, F1, G1, H1, E2, F2, G2, H2, E3, F3, G3, H3, E4, F4, G4, H4, E5, F5, G5, H5;
	
	int[][] cuad1,cuad2,cuad3,cuad4,cuad5,cuad6,cuad7,cuad8,cuad9,cuad10,cuad11,cuad12,cuad13,cuad14,cuad15,cuad16;
	
	int[][][] todasLasCajas;
	
	//Esto sirve para cambiar el color de la línea
	private int lineColor;
	
	public BoardLogic() {
		this.p1 = new Player("Perro", 1);
		this.p2 = new Player("Gato", 2);
		organizarCuadrados();
		crearLineas();
		
		//Genera los "puntos" de la matriz
		matrix.changeValue(0, 0, 1);
		matrix.changeValue(2, 0, 1);
		matrix.changeValue(4, 0, 1);
		matrix.changeValue(6, 0, 1);
		matrix.changeValue(8, 0, 1);
		
		matrix.changeValue(0, 2, 1);
		matrix.changeValue(2, 2, 1);
		matrix.changeValue(4, 2, 1);
		matrix.changeValue(6, 2, 1);
		matrix.changeValue(8, 2, 1);
		
		matrix.changeValue(0, 4, 1);
		matrix.changeValue(2, 4, 1);
		matrix.changeValue(4, 4, 1);
		matrix.changeValue(6, 4, 1);
		matrix.changeValue(8, 4, 1);
		
		matrix.changeValue(0, 6, 1);
		matrix.changeValue(2, 6, 1);
		matrix.changeValue(4, 6, 1);
		matrix.changeValue(6, 6, 1);
		matrix.changeValue(8, 6, 1);
		
		matrix.changeValue(0, 8, 1);
		matrix.changeValue(2, 8, 1);
		matrix.changeValue(4, 8, 1);
		matrix.changeValue(6, 8, 1);
		matrix.changeValue(8, 8, 1);
		matrix.printMatrix();
		
		this.tb = new TurnBaseB(this,p1,p2);
	}


	public void organizarCuadrados() {
		this.cuad1 = new int[][] {this.A1, this.E1, this. A2, this. E2};
		this.cuad2 = new int[][] {this.B1, this.E2, this. B2, this. E3};
		this.cuad3 = new int[][] {this.C1, this.E3, this. C2, this. E4};
		this.cuad4 = new int[][] {this.D1, this.E4, this. D2, this. E5};
		
		this.cuad5 = new int[][] {this.A2, this.F1, this. A3, this. F2};
		this.cuad6 = new int[][] {this.B2, this.F2, this. B3, this. F3};
		this.cuad7 = new int[][] {this.C2, this.F3, this. C3, this. F4};
		this.cuad8 = new int[][] {this.D2, this.F4, this. D3, this. F5};
		
		this.cuad9 = new int[][] {this.A3, this.G1, this. A4, this. G2};
		this.cuad10 = new int[][] {this.B3, this.G2, this. B4, this. G3};
		this.cuad11 = new int[][] {this.C3, this.G3, this. C4, this. G4};
		this.cuad12 = new int[][] {this.D3, this.G4, this. D4, this. G5};
		
		this.cuad13 = new int[][] {this.A4, this.H1, this. A5, this. H2};
		this.cuad14 = new int[][] {this.B4, this.H2, this. B5, this. H3};
		this.cuad15 = new int[][] {this.C4, this.H3, this. C5, this. H4};
		this.cuad16 = new int[][] {this.D4, this.H4, this. D5, this. H5};
		
		this.todasLasCajas = new int[][][] {this.cuad1, this.cuad2, this.cuad3, 
			this.cuad4, this.cuad5, this.cuad6, 
			this.cuad7, this.cuad8, this.cuad9, 
			this.cuad10, this.cuad11, this.cuad12, 
			this.cuad13, this.cuad14, this.cuad15, this.cuad16};
	
	}
	
	public void crearLineas() {
		
		//Estructura del arreglo: 
		//{El color de la línea, pos X inicial, pos Y inicial, pos X final, pos Y final}
		
		//Horizontales
		this.A1 = new int[]{0,30, 10, 120, 10};
		this.B1 = new int[]{0,130, 10, 220, 10};
		this.C1 = new int[]{0,230,10,320,10};
		this.D1 = new int[]{0,330,10,420,10};
		
		this.A2 = new int[]{0,30, 10, 120, 10};
		this.B2 = new int[]{0,130, 10, 220, 10};
		this.C2 = new int[]{0,230,10,320,10};
		this.D2 = new int[]{0,330,10,420,10};
		
		this.A3 = new int[]{0,30, 10, 120, 10};
		this.B3 = new int[]{0,130, 10, 220, 10};
		this.C3 = new int[]{0,230,10,320,10};
		this.D3 = new int[]{0,330,10,420,10};
		
		this.A4 = new int[]{0,30, 10, 120, 10};
		this.B4 = new int[]{0,130, 10, 220, 10};
		this.C4 = new int[]{0,230,10,320,10};
		this.D4 = new int[]{0,330,10,420,10};
		
		this.A5 = new int[]{0,30, 10, 120, 10};
		this.B5 = new int[]{0,130, 10, 220, 10};
		this.C5 = new int[]{0,230,10,320,10};
		this.D5 = new int[]{0,330,10,420,10};
		
		//Verticales
		this.E1 = new int[]{0,30, 10, 120, 10};
		this.F1 = new int[]{0,130, 10, 220, 10};
		this.G1 = new int[]{0,230,10,320,10};
		this.H1 = new int[]{0,330,10,420,10};
		
		this.E2 = new int[]{0,30, 10, 120, 10};
		this.F2 = new int[]{0,130, 10, 220, 10};
		this.G2 = new int[]{0,230,10,320,10};
		this.H2 = new int[]{0,330,10,420,10};
		
		this.E3 = new int[]{0,30, 10, 120, 10};
		this.F3 = new int[]{0,130, 10, 220, 10};
		this.G3 = new int[]{0,230,10,320,10};
		this.H3 = new int[]{0,330,10,420,10};
		
		this.E4 = new int[]{0,30, 10, 120, 10};
		this.F4 = new int[]{0,130, 10, 220, 10};
		this.G4 = new int[]{0,230,10,320,10};
		this.H4 = new int[]{0,330,10,420,10};
		
		this.E5 = new int[]{0,30, 10, 120, 10};
		this.F5 = new int[]{0,130, 10, 220, 10};
		this.G5 = new int[]{0,230,10,320,10};
		this.H5 = new int[]{0,330,10,420,10};
	}
	
	public void awardRightfulPoints() {
		if(this.p1.getHasTurn()) {
			this.p1.scorePoints();
		}
		else {
			this.p2.scorePoints();
		}
	}

	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
		//Estos corresponden a las coordenadas de los arreglos en crearLineas()
				if((30 < e.getX()) && (e.getX() < 115) && (0 < e.getY()) && (e.getY() < 30))
				{
					if(matrix.viewValue(1, 0) == 0){
						//Cambia el color de la línea al color del jugador
						this.A1[0] = this.lineColor;
						matrix.changeValue(1, 0, 1);
						
						if(this.tb.checkIsScore(this.cuad1)) {
							awardRightfulPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
						
					}
				}
		
	}


	
	public static void main(String[] args) {
		BoardLogic b = new BoardLogic();
	}
	
	@Override
	public void mouseEntered(java.awt.event.MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(java.awt.event.MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(java.awt.event.MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(java.awt.event.MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}

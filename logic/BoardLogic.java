package logic;

import java.awt.event.MouseListener;

import game.Player;
import matrix.Matrix;

/**
 * Lógica del juego Dots.
 * @author Jose Antonio
 *
 */
public class BoardLogic implements MouseListener{
	/**
	 * Atributos de la clase BoardLogic
	 */
	Matrix matrix = new Matrix(9,9,0);
	Player p1;
	Player p2;
	TurnBaseB tb;
	//Lineas horizontales
	int[] A1, B1, C1, D1, A2, B2, C2, D2, A3, B3, C3, D3, A4, B4, C4, D4, A5, B5, C5, D5;
	//Lineas verticales
	int[] E1, F1, G1, H1, E2, F2, G2, H2, E3, F3, G3, H3, E4, F4, G4, H4, E5, F5, G5, H5;
	//Lineas diagonales (Diagonal N del Cuadro M, si es D1 = / si es D2 = \)
	int[] D1C1, D2C1, D1C2, D2C2,D1C3, D2C3,D1C4, D2C4,D1C5, D2C5,D1C6, 
	D2C6,D1C7, D2C7,D1C8, D2C8,D1C9, D2C9,D1C10, D2C10,D1C11, D2C11,D1C12, 
	D2C12,D1C13, D2C13,D1C14, D2C14,D1C15, D2C15,D1C16, D2C16;
	//Todos los posibles cuadrados
	int[][] cuad1,cuad2,cuad3,cuad4,cuad5,cuad6,cuad7,cuad8,cuad9,cuad10,cuad11,cuad12,cuad13,cuad14,cuad15,cuad16;
	//Todos los posibles triángulos
	int[][] tri1,tri2,tri3,tri4,tri5,tri6,tri7,tri8,tri9,tri10,tri11,tri12,tri13,tri14,tri15,tri16,tri17,tri18,tri19,tri20,tri21,tri22,tri23,tri24,tri25,tri26,tri27,tri28,tri29,tri30,tri31,tri32;
	int[][] tri33,tri34,tri35,tri36,tri37,tri38,tri39,tri40,tri41,tri42,tri43,tri44,tri45,tri46,tri47,tri48,tri49,tri50,tri51,tri52,tri53,tri54,tri55,tri56,tri57,tri58,tri59,tri60,tri61,tri62,tri63,tri64;
	//Donde se guarda todo
	int[][][] todosLosTriang;
	int[][][] todasLasCajas;
	
	//Esto sirve para cambiar el color de la línea
	private int lineColor;
	
	/**
	 * Constructor de la clase BoardLogic que maneja toda la lógica detrás del juego.
	 */
	public BoardLogic() {
		//Genera dos nuevos jugadores.
		this.p1 = new Player("Perro", 1);
		this.p2 = new Player("Gato", 2);
		//Define las distintas figuras posibles.
		organizarCuadrados();
		organizarTriangulos();
		//Crea las líneas en la interfaz.
		crearLineas();
		
		//Genera los "puntos" de la matriz.
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
		
		//Lleva el control de puntos y cuándo termina el juego
		this.tb = new TurnBaseB(this,p1,p2);
	}

	/**
	 * Método que determina los distintos triángulos posibles.
	 */
	public void organizarTriangulos() {
		//Primera fila
		this.tri1 = new int [][] {this.A1, this.E1, this.D1C1};
		this.tri2 = new int [][] {this.A1, this.E2, this.D2C1};
		this.tri3 = new int [][] {this.A2, this.E1, this.D2C1};
		this.tri4 = new int [][] {this.A2, this.E2, this.D1C1};
		
		this.tri5 = new int [][] {this.B1, this.E2, this.D1C2};
		this.tri6 = new int [][] {this.B1, this.E3, this.D2C2};
		this.tri7 = new int [][] {this.B2, this.E2, this.D2C2};
		this.tri8 = new int [][] {this.B2, this.E3, this.D1C2};
		
		 this.tri9 = new int [][] {this.C1, this.E3, this.D1C3};
		this.tri10 = new int [][] {this.C1, this.E4, this.D2C3};
		this.tri11 = new int [][] {this.C2, this.E3, this.D2C3};
		this.tri12 = new int [][] {this.C2, this.E4, this.D1C3};
		
		this.tri13 = new int [][] {this.D1, this.E4, this.D1C4};
		this.tri14 = new int [][] {this.D1, this.E5, this.D2C4};
		this.tri15 = new int [][] {this.D2, this.E4, this.D2C4};
		this.tri16 = new int [][] {this.D2, this.E5, this.D1C4};
		
		//Segunda fila
		this.tri17 = new int [][] {this.A2, this.F1, this.D1C5};
		this.tri18 = new int [][] {this.A2, this.F2, this.D2C5};
		this.tri19 = new int [][] {this.A3, this.F1, this.D2C5};
		this.tri20 = new int [][] {this.A3, this.F2, this.D1C5};
		
		this.tri21 = new int [][] {this.B2, this.F2, this.D1C6};
		this.tri22 = new int [][] {this.B2, this.F3, this.D2C6};
		this.tri23 = new int [][] {this.B3, this.F2, this.D2C6};
		this.tri24 = new int [][] {this.B3, this.F3, this.D1C6};
		
		this.tri25 = new int [][] {this.C2, this.F3, this.D1C7};
		this.tri26 = new int [][] {this.C2, this.F4, this.D2C7};
		this.tri27 = new int [][] {this.C3, this.F3, this.D2C7};
		this.tri28 = new int [][] {this.C3, this.F4, this.D1C7};
		
		this.tri29 = new int [][] {this.D2, this.F4, this.D1C8};
		this.tri30 = new int [][] {this.D2, this.F5, this.D2C8};
		this.tri31 = new int [][] {this.D3, this.F4, this.D2C8};
		this.tri32 = new int [][] {this.D3, this.F5, this.D1C8};
		
		//Tercera fila
		this.tri33 = new int [][] {this.A3, this.G1, this.D1C9};
		this.tri34 = new int [][] {this.A3, this.G2, this.D2C9};
		this.tri35 = new int [][] {this.A4, this.G1, this.D2C9};
		this.tri36 = new int [][] {this.A4, this.G2, this.D1C9};
		
		this.tri37 = new int [][] {this.B3, this.G2, this.D1C10};
		this.tri38 = new int [][] {this.B3, this.G3, this.D2C10};
		this.tri39 = new int [][] {this.B4, this.G2, this.D2C10};
		this.tri40 = new int [][] {this.B4, this.G3, this.D1C10};
		
		this.tri41 = new int [][] {this.C3, this.G3, this.D1C11};
		this.tri42 = new int [][] {this.C3, this.G4, this.D2C11};
		this.tri43 = new int [][] {this.C4, this.G3, this.D2C11};
		this.tri44 = new int [][] {this.C4, this.G4, this.D1C11};
		
		this.tri45 = new int [][] {this.D3, this.G4, this.D1C12};
		this.tri46 = new int [][] {this.D3, this.G5, this.D2C12};
		this.tri47 = new int [][] {this.D4, this.G4, this.D2C12};
		this.tri48 = new int [][] {this.D4, this.G5, this.D1C12};
		
		//Cuarta fila
		this.tri49 = new int [][] {this.A4, this.H1, this.D1C13};
		this.tri50 = new int [][] {this.A4, this.H2, this.D2C13};
		this.tri51 = new int [][] {this.A5, this.H1, this.D2C13};
		this.tri52 = new int [][] {this.A5, this.H2, this.D1C13};
		
		this.tri53 = new int [][] {this.B4, this.H2, this.D1C14};
		this.tri54 = new int [][] {this.B4, this.H3, this.D2C14};
		this.tri55 = new int [][] {this.B5, this.H2, this.D2C14};
		this.tri56 = new int [][] {this.B5, this.H3, this.D1C14};
		
		this.tri57 = new int [][] {this.C4, this.H3, this.D1C15};
		this.tri58 = new int [][] {this.C4, this.H4, this.D2C15};
		this.tri59 = new int [][] {this.C5, this.H3, this.D2C15};
		this.tri60 = new int [][] {this.C5, this.H4, this.D1C15};
		
		this.tri61 = new int [][] {this.D4, this.H4, this.D1C16};
		this.tri62 = new int [][] {this.D4, this.H5, this.D2C16};
		this.tri63 = new int [][] {this.D5, this.H4, this.D2C16};
		this.tri64 = new int [][] {this.D5, this.H5, this.D1C16};
		
		//Todos los posibles triángulos.
		this.todosLosTriang = new int[][][] {this.tri1, this.tri2, this.tri3, this.tri4, this.tri5, 
			this.tri6, this.tri7, this.tri8, this.tri9, this.tri10, this.tri11, this.tri12, this.tri13, 
			this.tri14, this.tri15, this.tri16, this.tri17, this.tri18, this.tri19, this.tri20, this.tri21, 
			this.tri22, this.tri23, this.tri24, this.tri25, this.tri26, this.tri27, this.tri28, this.tri29, 
			this.tri30, this.tri31, this.tri32, this.tri33, this.tri34, this.tri35, this.tri36, this.tri37, 
			this.tri38, this.tri39, this.tri40, this.tri41, this.tri42, this.tri43, this.tri44, this.tri45, 
			this.tri46, this.tri47, this.tri48, this.tri49, this.tri50, this.tri51, this.tri52, this.tri53, 
			this.tri54, this.tri55, this.tri56, this.tri57, this.tri58, this.tri59, this.tri60, this.tri61, 
			this.tri62};
	}
	
	/**
	 * Método que organiza todos los posibles cuadrados.
	 */
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
		
		//Todos los posibles cuadrados.
		this.todasLasCajas = new int[][][] {this.cuad1, this.cuad2, this.cuad3, 
			this.cuad4, this.cuad5, this.cuad6, 
			this.cuad7, this.cuad8, this.cuad9, 
			this.cuad10, this.cuad11, this.cuad12, 
			this.cuad13, this.cuad14, this.cuad15, this.cuad16};
	
	}
	
	/**
	 * Método que crea las distintas lineas que estarán en pantalla.
	 */
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
		
		//Diagonales
		this.D1C1 = new int[]{0,30, 10, 120, 10};
		this.D2C1 = new int[]{0,130, 10, 220, 10};
		this.D1C2 = new int[]{0,230,10,320,10};
		this.D2C2 = new int[]{0,330,10,420,10};

		this.D1C3 = new int[]{0,30, 10, 120, 10};
		this.D2C3 = new int[]{0,130, 10, 220, 10};
		this.D1C4 = new int[]{0,230,10,320,10};
		this.D2C4 = new int[]{0,330,10,420,10};

		this.D1C5 = new int[]{0,30, 10, 120, 10};
		this.D2C5 = new int[]{0,130, 10, 220, 10};
		this.D1C6 = new int[]{0,230,10,320,10};
		this.D2C6 = new int[]{0,330,10,420,10};

		this.D1C7 = new int[]{0,30, 10, 120, 10};
		this.D2C7 = new int[]{0,130, 10, 220, 10};
		this.D1C8 = new int[]{0,230,10,320,10};
		this.D2C8 = new int[]{0,330,10,420,10};

		this.D1C9 = new int[]{0,30, 10, 120, 10};
		this.D2C9 = new int[]{0,130, 10, 220, 10};
		this.D1C10 = new int[]{0,230,10,320,10};
		this.D2C10 = new int[]{0,330,10,420,10};

		this.D1C11 = new int[]{0,30, 10, 120, 10};
		this.D2C11 = new int[]{0,130, 10, 220, 10};
		this.D1C12 = new int[]{0,230,10,320,10};
		this.D2C12 = new int[]{0,330,10,420,10};

		this.D1C13 = new int[]{0,30, 10, 120, 10};
		this.D2C13 = new int[]{0,130, 10, 220, 10};
		this.D1C14 = new int[]{0,230,10,320,10};
		this.D2C14 = new int[]{0,330,10,420,10};

		this.D1C15 = new int[]{0,30, 10, 120, 10};
		this.D2C15 = new int[]{0,130, 10, 220, 10};
		this.D1C16 = new int[]{0,230,10,320,10};
		this.D2C16 = new int[]{0,330,10,420,10};		
		}
	
	/**
	 * Método que otorga los puntos dependiendo del jugador.
	 */
	public void awardRightfulPoints() {
		if(this.p1.getHasTurn()) {
			this.p1.scorePoints();
		}
		else {
			this.p2.scorePoints();
		}
	}

	/**
	 * Método que controla cuándo un jugador pulsa una linea.
	 */
	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
		//Horizontales

				//A1
				//Estos corresponden a las coordenadas de los arreglos en crearLineas()
				if((30 < e.getX()) && (e.getX() < 115) && (0 < e.getY()) && (e.getY() < 30)){
					if(matrix.viewValue(1, 0) == 0){
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
				
				//B1
				if((30 < e.getX()) && (e.getX() < 115) && (0 < e.getY()) && (e.getY() < 30)){
					if(matrix.viewValue(3, 0) == 0){
						//Cambia el color de la línea al color del jugador
						this.A1[0] = this.lineColor;
						matrix.changeValue(3, 0, 1);
						
						if(this.tb.checkIsScore(this.cuad2)) {
							awardRightfulPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				
				//C1
				if((30 < e.getX()) && (e.getX() < 115) && (0 < e.getY()) && (e.getY() < 30)){
					if(matrix.viewValue(5, 0) == 0){
						//Cambia el color de la línea al color del jugador
						this.A1[0] = this.lineColor;
						matrix.changeValue(5, 0, 1);
						
						if(this.tb.checkIsScore(this.cuad1)) {
							awardRightfulPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				
				//D1
				if((30 < e.getX()) && (e.getX() < 115) && (0 < e.getY()) && (e.getY() < 30)){
					if(matrix.viewValue(7, 0) == 0){
						//Cambia el color de la línea al color del jugador
						this.A1[0] = this.lineColor;
						matrix.changeValue(7, 0, 1);
						
						if(this.tb.checkIsScore(this.cuad1)) {
							awardRightfulPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				
				//A2
				if((30 < e.getX()) && (e.getX() < 115) && (0 < e.getY()) && (e.getY() < 30)){
					if(matrix.viewValue(1, 2) == 0){
						//Cambia el color de la línea al color del jugador
						this.A1[0] = this.lineColor;
						matrix.changeValue(1, 2, 1);
						
						if(this.tb.checkIsScore(this.cuad1)) {
							awardRightfulPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				
				//B2
				if((30 < e.getX()) && (e.getX() < 115) && (0 < e.getY()) && (e.getY() < 30)){
					if(matrix.viewValue(3, 2) == 0){
						//Cambia el color de la línea al color del jugador
						this.A1[0] = this.lineColor;
						matrix.changeValue(3, 2, 1);
						
						if(this.tb.checkIsScore(this.cuad2)) {
							awardRightfulPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				
				//C2
				if((30 < e.getX()) && (e.getX() < 115) && (0 < e.getY()) && (e.getY() < 30)){
					if(matrix.viewValue(5, 2) == 0){
						//Cambia el color de la línea al color del jugador
						this.A1[0] = this.lineColor;
						matrix.changeValue(5, 2, 1);
						
						if(this.tb.checkIsScore(this.cuad1)) {
							awardRightfulPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				
				//D2
				if((30 < e.getX()) && (e.getX() < 115) && (0 < e.getY()) && (e.getY() < 30)){
					if(matrix.viewValue(7, 2) == 0){
						//Cambia el color de la línea al color del jugador
						this.A1[0] = this.lineColor;
						matrix.changeValue(7, 2, 1);
						
						if(this.tb.checkIsScore(this.cuad1)) {
							awardRightfulPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				
				//A3
				if((30 < e.getX()) && (e.getX() < 115) && (0 < e.getY()) && (e.getY() < 30)){
					if(matrix.viewValue(1, 4) == 0){
						//Cambia el color de la línea al color del jugador
						this.A1[0] = this.lineColor;
						matrix.changeValue(1, 4, 1);
						
						if(this.tb.checkIsScore(this.cuad1)) {
							awardRightfulPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				
				//B3
				if((30 < e.getX()) && (e.getX() < 115) && (0 < e.getY()) && (e.getY() < 30)){
					if(matrix.viewValue(3, 4) == 0){
						//Cambia el color de la línea al color del jugador
						this.A1[0] = this.lineColor;
						matrix.changeValue(3, 4, 1);
						
						if(this.tb.checkIsScore(this.cuad2)) {
							awardRightfulPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				
				//C3
				if((30 < e.getX()) && (e.getX() < 115) && (0 < e.getY()) && (e.getY() < 30)){
					if(matrix.viewValue(5, 4) == 0){
						//Cambia el color de la línea al color del jugador
						this.A1[0] = this.lineColor;
						matrix.changeValue(5, 4, 1);
						
						if(this.tb.checkIsScore(this.cuad1)) {
							awardRightfulPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				
				//D3
				if((30 < e.getX()) && (e.getX() < 115) && (0 < e.getY()) && (e.getY() < 30)){
					if(matrix.viewValue(7, 4) == 0){
						//Cambia el color de la línea al color del jugador
						this.A1[0] = this.lineColor;
						matrix.changeValue(7, 4, 1);
						
						if(this.tb.checkIsScore(this.cuad1)) {
							awardRightfulPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				
				//A4
				if((30 < e.getX()) && (e.getX() < 115) && (0 < e.getY()) && (e.getY() < 30)){
					if(matrix.viewValue(1, 6) == 0){
						//Cambia el color de la línea al color del jugador
						this.A1[0] = this.lineColor;
						matrix.changeValue(1, 6, 1);
						
						if(this.tb.checkIsScore(this.cuad1)) {
							awardRightfulPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				
				//B4
				if((30 < e.getX()) && (e.getX() < 115) && (0 < e.getY()) && (e.getY() < 30)){
					if(matrix.viewValue(3, 6) == 0){
						//Cambia el color de la línea al color del jugador
						this.A1[0] = this.lineColor;
						matrix.changeValue(3, 6, 1);
						
						if(this.tb.checkIsScore(this.cuad2)) {
							awardRightfulPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				
				//C4
				if((30 < e.getX()) && (e.getX() < 115) && (0 < e.getY()) && (e.getY() < 30)){
					if(matrix.viewValue(5, 6) == 0){
						//Cambia el color de la línea al color del jugador
						this.A1[0] = this.lineColor;
						matrix.changeValue(5, 6, 1);
						
						if(this.tb.checkIsScore(this.cuad1)) {
							awardRightfulPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				
				//D4
				if((30 < e.getX()) && (e.getX() < 115) && (0 < e.getY()) && (e.getY() < 30)){
					if(matrix.viewValue(7, 6) == 0){
						//Cambia el color de la línea al color del jugador
						this.A1[0] = this.lineColor;
						matrix.changeValue(7, 6, 1);
						
						if(this.tb.checkIsScore(this.cuad1)) {
							awardRightfulPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				
				//A5
				if((30 < e.getX()) && (e.getX() < 115) && (0 < e.getY()) && (e.getY() < 30)){
					if(matrix.viewValue(1, 8) == 0){
						//Cambia el color de la línea al color del jugador
						this.A1[0] = this.lineColor;
						matrix.changeValue(1, 8, 1);
						
						if(this.tb.checkIsScore(this.cuad1)) {
							awardRightfulPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				
				//B5
				if((30 < e.getX()) && (e.getX() < 115) && (0 < e.getY()) && (e.getY() < 30)){
					if(matrix.viewValue(3, 8) == 0){
						//Cambia el color de la línea al color del jugador
						this.A1[0] = this.lineColor;
						matrix.changeValue(3, 8, 1);
						
						if(this.tb.checkIsScore(this.cuad2)) {
							awardRightfulPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				
				//C5
				if((30 < e.getX()) && (e.getX() < 115) && (0 < e.getY()) && (e.getY() < 30)){
					if(matrix.viewValue(5, 8) == 0){
						//Cambia el color de la línea al color del jugador
						this.A1[0] = this.lineColor;
						matrix.changeValue(5, 8, 1);
						
						if(this.tb.checkIsScore(this.cuad1)) {
							awardRightfulPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				
				//D5
				if((30 < e.getX()) && (e.getX() < 115) && (0 < e.getY()) && (e.getY() < 30)){
					if(matrix.viewValue(7, 8) == 0){
						//Cambia el color de la línea al color del jugador
						this.A1[0] = this.lineColor;
						matrix.changeValue(7, 8, 1);
						
						if(this.tb.checkIsScore(this.cuad1)) {
							awardRightfulPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				
		//Verticales
				//E1
				if((30 < e.getX()) && (e.getX() < 115) && (0 < e.getY()) && (e.getY() < 30)){
					if(matrix.viewValue(0, 1) == 0){
						//Cambia el color de la línea al color del jugador
						this.A1[0] = this.lineColor;
						matrix.changeValue(0, 1, 1);
						
						if(this.tb.checkIsScore(this.cuad1)) {
							awardRightfulPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				
				//E2
				if((30 < e.getX()) && (e.getX() < 115) && (0 < e.getY()) && (e.getY() < 30)){
					if(matrix.viewValue(2, 1) == 0){
						//Cambia el color de la línea al color del jugador
						this.A1[0] = this.lineColor;
						matrix.changeValue(2, 1, 1);
						
						if(this.tb.checkIsScore(this.cuad1)) {
							awardRightfulPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				//E3
				if((30 < e.getX()) && (e.getX() < 115) && (0 < e.getY()) && (e.getY() < 30)){
					if(matrix.viewValue(4, 1) == 0){
						//Cambia el color de la línea al color del jugador
						this.A1[0] = this.lineColor;
						matrix.changeValue(4, 1, 1);
						
						if(this.tb.checkIsScore(this.cuad1)) {
							awardRightfulPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				//E4
				if((30 < e.getX()) && (e.getX() < 115) && (0 < e.getY()) && (e.getY() < 30)){
					if(matrix.viewValue(6, 1) == 0){
						//Cambia el color de la línea al color del jugador
						this.A1[0] = this.lineColor;
						matrix.changeValue(6, 1, 1);
						
						if(this.tb.checkIsScore(this.cuad1)) {
							awardRightfulPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				//E5
				if((30 < e.getX()) && (e.getX() < 115) && (0 < e.getY()) && (e.getY() < 30)){
					if(matrix.viewValue(8, 1) == 0){
						//Cambia el color de la línea al color del jugador
						this.A1[0] = this.lineColor;
						matrix.changeValue(8, 1, 1);
						
						if(this.tb.checkIsScore(this.cuad1)) {
							awardRightfulPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				
				//F1
				if((30 < e.getX()) && (e.getX() < 115) && (0 < e.getY()) && (e.getY() < 30)){
					if(matrix.viewValue(0, 3) == 0){
						//Cambia el color de la línea al color del jugador
						this.A1[0] = this.lineColor;
						matrix.changeValue(0, 3, 1);
						
						if(this.tb.checkIsScore(this.cuad1)) {
							awardRightfulPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				
				//F2
				if((30 < e.getX()) && (e.getX() < 115) && (0 < e.getY()) && (e.getY() < 30)){
					if(matrix.viewValue(2, 3) == 0){
						//Cambia el color de la línea al color del jugador
						this.A1[0] = this.lineColor;
						matrix.changeValue(2, 3, 1);
						
						if(this.tb.checkIsScore(this.cuad1)) {
							awardRightfulPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				//F3
				if((30 < e.getX()) && (e.getX() < 115) && (0 < e.getY()) && (e.getY() < 30)){
					if(matrix.viewValue(4, 3) == 0){
						//Cambia el color de la línea al color del jugador
						this.A1[0] = this.lineColor;
						matrix.changeValue(4, 3, 1);
						
						if(this.tb.checkIsScore(this.cuad1)) {
							awardRightfulPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				//F4
				if((30 < e.getX()) && (e.getX() < 115) && (0 < e.getY()) && (e.getY() < 30)){
					if(matrix.viewValue(6, 3) == 0){
						//Cambia el color de la línea al color del jugador
						this.A1[0] = this.lineColor;
						matrix.changeValue(6, 3, 1);
						
						if(this.tb.checkIsScore(this.cuad1)) {
							awardRightfulPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				//F5
				if((30 < e.getX()) && (e.getX() < 115) && (0 < e.getY()) && (e.getY() < 30)){
					if(matrix.viewValue(8, 3) == 0){
						//Cambia el color de la línea al color del jugador
						this.A1[0] = this.lineColor;
						matrix.changeValue(8, 3, 1);
						
						if(this.tb.checkIsScore(this.cuad1)) {
							awardRightfulPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				
				//G1
				if((30 < e.getX()) && (e.getX() < 115) && (0 < e.getY()) && (e.getY() < 30)){
					if(matrix.viewValue(0, 5) == 0){
						//Cambia el color de la línea al color del jugador
						this.A1[0] = this.lineColor;
						matrix.changeValue(0, 5, 1);
						
						if(this.tb.checkIsScore(this.cuad1)) {
							awardRightfulPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				
				//G2
				if((30 < e.getX()) && (e.getX() < 115) && (0 < e.getY()) && (e.getY() < 30)){
					if(matrix.viewValue(2, 5) == 0){
						//Cambia el color de la línea al color del jugador
						this.A1[0] = this.lineColor;
						matrix.changeValue(2, 5, 1);
						
						if(this.tb.checkIsScore(this.cuad1)) {
							awardRightfulPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				//G3
				if((30 < e.getX()) && (e.getX() < 115) && (0 < e.getY()) && (e.getY() < 30)){
					if(matrix.viewValue(4, 5) == 0){
						//Cambia el color de la línea al color del jugador
						this.A1[0] = this.lineColor;
						matrix.changeValue(4, 5, 1);
						
						if(this.tb.checkIsScore(this.cuad1)) {
							awardRightfulPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				//G4
				if((30 < e.getX()) && (e.getX() < 115) && (0 < e.getY()) && (e.getY() < 30)){
					if(matrix.viewValue(6, 5) == 0){
						//Cambia el color de la línea al color del jugador
						this.A1[0] = this.lineColor;
						matrix.changeValue(6, 5, 1);
						
						if(this.tb.checkIsScore(this.cuad1)) {
							awardRightfulPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				//G5
				if((30 < e.getX()) && (e.getX() < 115) && (0 < e.getY()) && (e.getY() < 30)){
					if(matrix.viewValue(8, 5) == 0){
						//Cambia el color de la línea al color del jugador
						this.A1[0] = this.lineColor;
						matrix.changeValue(8, 5, 1);
						
						if(this.tb.checkIsScore(this.cuad1)) {
							awardRightfulPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				
				//H1
				if((30 < e.getX()) && (e.getX() < 115) && (0 < e.getY()) && (e.getY() < 30)){
					if(matrix.viewValue(0, 7) == 0){
						//Cambia el color de la línea al color del jugador
						this.A1[0] = this.lineColor;
						matrix.changeValue(0, 7, 1);
						
						if(this.tb.checkIsScore(this.cuad1)) {
							awardRightfulPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				
				//H2
				if((30 < e.getX()) && (e.getX() < 115) && (0 < e.getY()) && (e.getY() < 30)){
					if(matrix.viewValue(2, 7) == 0){
						//Cambia el color de la línea al color del jugador
						this.A1[0] = this.lineColor;
						matrix.changeValue(2, 7, 1);
						
						if(this.tb.checkIsScore(this.cuad1)) {
							awardRightfulPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				//H3
				if((30 < e.getX()) && (e.getX() < 115) && (0 < e.getY()) && (e.getY() < 30)){
					if(matrix.viewValue(4, 7) == 0){
						//Cambia el color de la línea al color del jugador
						this.A1[0] = this.lineColor;
						matrix.changeValue(4, 7, 1);
						
						if(this.tb.checkIsScore(this.cuad1)) {
							awardRightfulPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				//H4
				if((30 < e.getX()) && (e.getX() < 115) && (0 < e.getY()) && (e.getY() < 30)){
					if(matrix.viewValue(6, 7) == 0){
						//Cambia el color de la línea al color del jugador
						this.A1[0] = this.lineColor;
						matrix.changeValue(6, 7, 1);
						
						if(this.tb.checkIsScore(this.cuad1)) {
							awardRightfulPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				//H5
				if((30 < e.getX()) && (e.getX() < 115) && (0 < e.getY()) && (e.getY() < 30)){
					if(matrix.viewValue(8, 7) == 0){
						//Cambia el color de la línea al color del jugador
						this.A1[0] = this.lineColor;
						matrix.changeValue(8, 7, 1);
						
						if(this.tb.checkIsScore(this.cuad1)) {
							awardRightfulPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
		
		//Diagonales
				//D1C1
				if((30 < e.getX()) && (e.getX() < 115) && (0 < e.getY()) && (e.getY() < 30)){
					if(matrix.viewValue(1, 1) == 0){
						//Cambia el color de la línea al color del jugador
						this.A1[0] = this.lineColor;
						matrix.changeValue(1, 1, 1);
						
						if(this.tb.checkIsScore(this.cuad1)) {
							awardRightfulPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				//D1C1
				if((30 < e.getX()) && (e.getX() < 115) && (0 < e.getY()) && (e.getY() < 30)){
					if(matrix.viewValue(1, 1) == 0){
						//Cambia el color de la línea al color del jugador
						this.A1[0] = this.lineColor;
						matrix.changeValue(1, 1, 1);
						
						if(this.tb.checkIsScore(this.cuad1)) {
							awardRightfulPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				
				//D1C2
				if((30 < e.getX()) && (e.getX() < 115) && (0 < e.getY()) && (e.getY() < 30)){
					if(matrix.viewValue(3, 1) == 0){
						//Cambia el color de la línea al color del jugador
						this.A1[0] = this.lineColor;
						matrix.changeValue(3, 1, 1);
						
						if(this.tb.checkIsScore(this.cuad1)) {
							awardRightfulPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				//D2C2
				if((30 < e.getX()) && (e.getX() < 115) && (0 < e.getY()) && (e.getY() < 30)){
					if(matrix.viewValue(3, 1) == 0){
						//Cambia el color de la línea al color del jugador
						this.A1[0] = this.lineColor;
						matrix.changeValue(3, 1, 1);
						
						if(this.tb.checkIsScore(this.cuad1)) {
							awardRightfulPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				
				//D1C3
				if((30 < e.getX()) && (e.getX() < 115) && (0 < e.getY()) && (e.getY() < 30)){
					if(matrix.viewValue(5, 1) == 0){
						//Cambia el color de la línea al color del jugador
						this.A1[0] = this.lineColor;
						matrix.changeValue(5, 1, 1);
						
						if(this.tb.checkIsScore(this.cuad1)) {
							awardRightfulPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				//D2C3
				if((30 < e.getX()) && (e.getX() < 115) && (0 < e.getY()) && (e.getY() < 30)){
					if(matrix.viewValue(5, 1) == 0){
						//Cambia el color de la línea al color del jugador
						this.A1[0] = this.lineColor;
						matrix.changeValue(5, 1, 1);
						
						if(this.tb.checkIsScore(this.cuad1)) {
							awardRightfulPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				
				//D1C4
				if((30 < e.getX()) && (e.getX() < 115) && (0 < e.getY()) && (e.getY() < 30)){
					if(matrix.viewValue(7, 1) == 0){
						//Cambia el color de la línea al color del jugador
						this.A1[0] = this.lineColor;
						matrix.changeValue(7, 1, 1);
						
						if(this.tb.checkIsScore(this.cuad1)) {
							awardRightfulPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				//D2C4
				if((30 < e.getX()) && (e.getX() < 115) && (0 < e.getY()) && (e.getY() < 30)){
					if(matrix.viewValue(7, 1) == 0){
						//Cambia el color de la línea al color del jugador
						this.A1[0] = this.lineColor;
						matrix.changeValue(7, 1, 1);
						
						if(this.tb.checkIsScore(this.cuad1)) {
							awardRightfulPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				//D1C5
				if((30 < e.getX()) && (e.getX() < 115) && (0 < e.getY()) && (e.getY() < 30)){
					if(matrix.viewValue(1, 3) == 0){
						//Cambia el color de la línea al color del jugador
						this.A1[0] = this.lineColor;
						matrix.changeValue(1, 3, 1);
						
						if(this.tb.checkIsScore(this.cuad1)) {
							awardRightfulPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				//D2C5
				if((30 < e.getX()) && (e.getX() < 115) && (0 < e.getY()) && (e.getY() < 30)){
					if(matrix.viewValue(1, 3) == 0){
						//Cambia el color de la línea al color del jugador
						this.A1[0] = this.lineColor;
						matrix.changeValue(1, 3, 1);
						
						if(this.tb.checkIsScore(this.cuad1)) {
							awardRightfulPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				//D1C6
				if((30 < e.getX()) && (e.getX() < 115) && (0 < e.getY()) && (e.getY() < 30)){
					if(matrix.viewValue(3, 3) == 0){
						//Cambia el color de la línea al color del jugador
						this.A1[0] = this.lineColor;
						matrix.changeValue(3, 3, 1);
						
						if(this.tb.checkIsScore(this.cuad1)) {
							awardRightfulPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				//D2C6
				if((30 < e.getX()) && (e.getX() < 115) && (0 < e.getY()) && (e.getY() < 30)){
					if(matrix.viewValue(3, 3) == 0){
						//Cambia el color de la línea al color del jugador
						this.A1[0] = this.lineColor;
						matrix.changeValue(3, 3, 1);
						
						if(this.tb.checkIsScore(this.cuad1)) {
							awardRightfulPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				//D1C7
				if((30 < e.getX()) && (e.getX() < 115) && (0 < e.getY()) && (e.getY() < 30)){
					if(matrix.viewValue(5, 3) == 0){
						//Cambia el color de la línea al color del jugador
						this.A1[0] = this.lineColor;
						matrix.changeValue(5, 3, 1);
						
						if(this.tb.checkIsScore(this.cuad1)) {
							awardRightfulPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				//D2C7
				if((30 < e.getX()) && (e.getX() < 115) && (0 < e.getY()) && (e.getY() < 30)){
					if(matrix.viewValue(5, 3) == 0){
						//Cambia el color de la línea al color del jugador
						this.A1[0] = this.lineColor;
						matrix.changeValue(5, 3, 1);
						
						if(this.tb.checkIsScore(this.cuad1)) {
							awardRightfulPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				//D1C8
				if((30 < e.getX()) && (e.getX() < 115) && (0 < e.getY()) && (e.getY() < 30)){
					if(matrix.viewValue(7, 3) == 0){
						//Cambia el color de la línea al color del jugador
						this.A1[0] = this.lineColor;
						matrix.changeValue(7, 3, 1);
						
						if(this.tb.checkIsScore(this.cuad1)) {
							awardRightfulPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				//D2C8
				if((30 < e.getX()) && (e.getX() < 115) && (0 < e.getY()) && (e.getY() < 30)){
					if(matrix.viewValue(7, 3) == 0){
						//Cambia el color de la línea al color del jugador
						this.A1[0] = this.lineColor;
						matrix.changeValue(7, 3, 1);
						
						if(this.tb.checkIsScore(this.cuad1)) {
							awardRightfulPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				
				//D1C9
				if((30 < e.getX()) && (e.getX() < 115) && (0 < e.getY()) && (e.getY() < 30)){
					if(matrix.viewValue(1, 5) == 0){
						//Cambia el color de la línea al color del jugador
						this.A1[0] = this.lineColor;
						matrix.changeValue(1, 5, 1);
						
						if(this.tb.checkIsScore(this.cuad1)) {
							awardRightfulPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				//D1C9
				if((30 < e.getX()) && (e.getX() < 115) && (0 < e.getY()) && (e.getY() < 30)){
					if(matrix.viewValue(1, 5) == 0){
						//Cambia el color de la línea al color del jugador
						this.A1[0] = this.lineColor;
						matrix.changeValue(1, 5, 1);
						
						if(this.tb.checkIsScore(this.cuad1)) {
							awardRightfulPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				
				//D1C10
				if((30 < e.getX()) && (e.getX() < 115) && (0 < e.getY()) && (e.getY() < 30)){
					if(matrix.viewValue(3, 5) == 0){
						//Cambia el color de la línea al color del jugador
						this.A1[0] = this.lineColor;
						matrix.changeValue(3, 5, 1);
						
						if(this.tb.checkIsScore(this.cuad1)) {
							awardRightfulPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				//D2C10
				if((30 < e.getX()) && (e.getX() < 115) && (0 < e.getY()) && (e.getY() < 30)){
					if(matrix.viewValue(3, 5) == 0){
						//Cambia el color de la línea al color del jugador
						this.A1[0] = this.lineColor;
						matrix.changeValue(3, 5, 1);
						
						if(this.tb.checkIsScore(this.cuad1)) {
							awardRightfulPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				
				//D1C11
				if((30 < e.getX()) && (e.getX() < 115) && (0 < e.getY()) && (e.getY() < 30)){
					if(matrix.viewValue(5, 5) == 0){
						//Cambia el color de la línea al color del jugador
						this.A1[0] = this.lineColor;
						matrix.changeValue(5, 5, 1);
						
						if(this.tb.checkIsScore(this.cuad1)) {
							awardRightfulPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				//D2C11
				if((30 < e.getX()) && (e.getX() < 115) && (0 < e.getY()) && (e.getY() < 30)){
					if(matrix.viewValue(5, 5) == 0){
						//Cambia el color de la línea al color del jugador
						this.A1[0] = this.lineColor;
						matrix.changeValue(5, 5, 1);
						
						if(this.tb.checkIsScore(this.cuad1)) {
							awardRightfulPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				
				//D1C12
				if((30 < e.getX()) && (e.getX() < 115) && (0 < e.getY()) && (e.getY() < 30)){
					if(matrix.viewValue(7, 5) == 0){
						//Cambia el color de la línea al color del jugador
						this.A1[0] = this.lineColor;
						matrix.changeValue(7, 5, 1);
						
						if(this.tb.checkIsScore(this.cuad1)) {
							awardRightfulPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				//D2C12
				if((30 < e.getX()) && (e.getX() < 115) && (0 < e.getY()) && (e.getY() < 30)){
					if(matrix.viewValue(7, 5) == 0){
						//Cambia el color de la línea al color del jugador
						this.A1[0] = this.lineColor;
						matrix.changeValue(7, 5, 1);
						
						if(this.tb.checkIsScore(this.cuad1)) {
							awardRightfulPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				//D1C13
				if((30 < e.getX()) && (e.getX() < 115) && (0 < e.getY()) && (e.getY() < 30)){
					if(matrix.viewValue(1, 7) == 0){
						//Cambia el color de la línea al color del jugador
						this.A1[0] = this.lineColor;
						matrix.changeValue(1, 7, 1);
						
						if(this.tb.checkIsScore(this.cuad1)) {
							awardRightfulPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				//D2C13
				if((30 < e.getX()) && (e.getX() < 115) && (0 < e.getY()) && (e.getY() < 30)){
					if(matrix.viewValue(1, 7) == 0){
						//Cambia el color de la línea al color del jugador
						this.A1[0] = this.lineColor;
						matrix.changeValue(1, 7, 1);
						
						if(this.tb.checkIsScore(this.cuad1)) {
							awardRightfulPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				//D1C14
				if((30 < e.getX()) && (e.getX() < 115) && (0 < e.getY()) && (e.getY() < 30)){
					if(matrix.viewValue(3, 7) == 0){
						//Cambia el color de la línea al color del jugador
						this.A1[0] = this.lineColor;
						matrix.changeValue(3, 7, 1);
						
						if(this.tb.checkIsScore(this.cuad1)) {
							awardRightfulPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				//D2C14
				if((30 < e.getX()) && (e.getX() < 115) && (0 < e.getY()) && (e.getY() < 30)){
					if(matrix.viewValue(3, 7) == 0){
						//Cambia el color de la línea al color del jugador
						this.A1[0] = this.lineColor;
						matrix.changeValue(3, 7, 1);
						
						if(this.tb.checkIsScore(this.cuad1)) {
							awardRightfulPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				//D1C15
				if((30 < e.getX()) && (e.getX() < 115) && (0 < e.getY()) && (e.getY() < 30)){
					if(matrix.viewValue(5, 7) == 0){
						//Cambia el color de la línea al color del jugador
						this.A1[0] = this.lineColor;
						matrix.changeValue(5, 7, 1);
						
						if(this.tb.checkIsScore(this.cuad1)) {
							awardRightfulPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				//D2C15
				if((30 < e.getX()) && (e.getX() < 115) && (0 < e.getY()) && (e.getY() < 30)){
					if(matrix.viewValue(5, 7) == 0){
						//Cambia el color de la línea al color del jugador
						this.A1[0] = this.lineColor;
						matrix.changeValue(5, 7, 1);
						
						if(this.tb.checkIsScore(this.cuad1)) {
							awardRightfulPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				//D1C16
				if((30 < e.getX()) && (e.getX() < 115) && (0 < e.getY()) && (e.getY() < 30)){
					if(matrix.viewValue(7, 7) == 0){
						//Cambia el color de la línea al color del jugador
						this.A1[0] = this.lineColor;
						matrix.changeValue(7, 7, 1);
						
						if(this.tb.checkIsScore(this.cuad1)) {
							awardRightfulPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				//D2C16
				if((30 < e.getX()) && (e.getX() < 115) && (0 < e.getY()) && (e.getY() < 30)){
					if(matrix.viewValue(7, 7) == 0){
						//Cambia el color de la línea al color del jugador
						this.A1[0] = this.lineColor;
						matrix.changeValue(7, 7, 1);
						
						if(this.tb.checkIsScore(this.cuad1)) {
							awardRightfulPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				
				if(this.tb.checkGameOver(this.todasLasCajas, this.todasLasCajas))
				{
					System.out.println("Game over");
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

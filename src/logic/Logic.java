package logic;

import matrix.Matrix;

public class Logic {
	Matrix matrix = new Matrix(9,9,0);
	Player p1;
	Player p2;
	TurnBaseB tb;
	
	// Horizontal Lines
	int[] A1, B1, C1, D1, A2, B2, C2, D2, A3, B3, C3, D3, A4, B4, C4, D4, A5, B5, C5, D5;
	// Vertical Lines
	int[] E1, F1, G1, H1, E2, F2, G2, H2, E3, F3, G3, H3, E4, F4, G4, H4, E5, F5, G5, H5;
	// Diagonal Lines (Diagonal N del Cuadro M, si es D1 = / si es D2 = \)
	int[] D1C1, D2C1, D1C2, D2C2,D1C3, D2C3,D1C4, D2C4,D1C5, D2C5,D1C6, 
	D2C6,D1C7, D2C7,D1C8, D2C8,D1C9, D2C9,D1C10, D2C10,D1C11, D2C11,D1C12, 
	D2C12,D1C13, D2C13,D1C14, D2C14,D1C15, D2C15,D1C16, D2C16;
	//Todos los posibles cuadrados
	int[][] cuad1,cuad2,cuad3,cuad4,cuad5,cuad6,cuad7,cuad8,cuad9,cuad10,cuad11,cuad12,cuad13,cuad14,cuad15,cuad16;
	// All possible triangles
	int[][] tri1,tri2,tri3,tri4,tri5,tri6,tri7,tri8,tri9,tri10,tri11,tri12,tri13,tri14,tri15,tri16,tri17,tri18,tri19,tri20,tri21,tri22,tri23,tri24,tri25,tri26,tri27,tri28,tri29,tri30,tri31,tri32;
	int[][] tri33,tri34,tri35,tri36,tri37,tri38,tri39,tri40,tri41,tri42,tri43,tri44,tri45,tri46,tri47,tri48,tri49,tri50,tri51,tri52,tri53,tri54,tri55,tri56,tri57,tri58,tri59,tri60,tri61,tri62,tri63,tri64;
	// Where everything is saved
	int[][][] todosLosTriang;
	int[][][] todasLasCajas;
	
	public Logic(Player p1, Player p2) {
		this.p1 = p1;
		this.p2 = p2;
		generateMatrixDots();
		this.tb = new TurnBaseB(this,p1,p2);
		organizeTriangles();
		organizeSquares();
	}
		
	public void generateMatrixDots() {
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
	}
	
	public void organizeTriangles() {
		//1st row
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
		
		//2nd row
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
		
		//3rd row
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
		
		//4th row
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
		
		//All the posible triangles
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
	
	public void organizeSquares() {
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
	
	public void awardSquarePoints() {
		if(this.p1.getHasTurn()) {
			this.p1.scoreSquarePoints();
		}
		else {
			this.p2.scoreSquarePoints();
		}
	}
	
	
	public void awardTriPoints() {
		if(this.p1.getHasTurn()) {
			this.p1.scoreTriPoints();
		}
		else {
			this.p2.scoreTriPoints();
		}
	}
	
	public void modifyMatrix(java.awt.event.MouseEvent e, int lineColor) {
		//Horizontales
		
				//A1
				//First we verify if the mouse is touching the line
				if((A1[1] < e.getX()) && (e.getX() < A1[2]) && (A1[3] < e.getY()) && (e.getY() < A1[4])){
					//Then we see if the line is already made
					if(matrix.viewValue(1, 0) == 0){
						//If not, the value in A1[0] corresponds to the color of the line, changing the value to be drawn (later) on the screen
						this.A1[0] = lineColor;
						//We also change the value on the matrix so it can't be modified with this iteration again
						matrix.changeValue(1, 0, 1);
						
						//If the line is used to enclose a square, it awards 8 points to the player who made it
						if(this.tb.checkIsScore(this.cuad1)) {
							awardSquarePoints();
						//If the line is used to enclose a triangle, it awards 6 points to the player who made it
						} else if(this.tb.checkIsScoreTri(tri1) || this.tb.checkIsScoreTri(tri2)) {
							awardTriPoints();
						} else {
							//If nothing of that happens, it only switches the players turn
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
					
					//And all of those comments are valid for the rest of the verifications
				}
				
				//B1
				if((B1[1] < e.getX()) && (e.getX() < B1[2]) && (B1[3] < e.getY()) && (e.getY() < B1[4])){
					if(matrix.viewValue(3, 0) == 0){
						this.B1[0] = lineColor;
						matrix.changeValue(3, 0, 1);
						
						if(this.tb.checkIsScore(this.cuad2)) {
							awardSquarePoints();
						} else if(this.tb.checkIsScoreTri(tri5)||this.tb.checkIsScoreTri(tri6)) {
							awardTriPoints();
						} else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				
				//C1
				if((C1[1] < e.getX()) && (e.getX() < C1[2]) && (C1[3] < e.getY()) && (e.getY() < C1[4])){
					if(matrix.viewValue(5, 0) == 0){
						this.C1[0] = lineColor;
						matrix.changeValue(5, 0, 1);
						
						if(this.tb.checkIsScore(this.cuad3)) {
							awardSquarePoints();
						} else if(this.tb.checkIsScoreTri(tri9)||this.tb.checkIsScoreTri(tri10)) {
							awardTriPoints();
						} else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				
				//D1
				if((D1[1] < e.getX()) && (e.getX() < D1[2]) && (D1[3] < e.getY()) && (e.getY() < D1[4])){
					if(matrix.viewValue(7, 0) == 0){
						this.D1[0] = lineColor;
						matrix.changeValue(7, 0, 1);
						
						if(this.tb.checkIsScore(this.cuad4)) {
							awardSquarePoints();
						} else if(this.tb.checkIsScoreTri(tri13)||this.tb.checkIsScoreTri(tri14)) {
							awardTriPoints();
						} else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					
					}
				}
				
				//A2
				if((A2[1] < e.getX()) && (e.getX() < A2[2]) && (A2[3] < e.getY()) && (e.getY() < A2[4])){
					if(matrix.viewValue(1, 2) == 0){
						this.A2[0] = lineColor;
						matrix.changeValue(1, 2, 1);
						if(this.tb.checkIsScore(this.cuad1)||this.tb.checkIsScore(this.cuad5)) {
							awardSquarePoints();
						} else if(this.tb.checkIsScoreTri(tri3)||this.tb.checkIsScoreTri(tri4)||this.tb.checkIsScoreTri(tri17)||this.tb.checkIsScoreTri(tri18)) {
							awardTriPoints();
						} else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				
				//B2
				if((B2[1] < e.getX()) && (e.getX() < B2[2]) && (B2[3] < e.getY()) && (e.getY() < B2[4])){
					if(matrix.viewValue(3, 2) == 0){
						this.B2[0] = lineColor;
						matrix.changeValue(3, 2, 1);
						if(this.tb.checkIsScore(this.cuad2)||this.tb.checkIsScore(this.cuad6)) {
							awardSquarePoints();
						} else if(this.tb.checkIsScoreTri(tri7)||this.tb.checkIsScoreTri(tri8)||this.tb.checkIsScoreTri(tri21)||this.tb.checkIsScoreTri(tri22)) {
							awardTriPoints();
						} else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				
				//C2
				if((C2[1] < e.getX()) && (e.getX() < C2[2]) && (C2[3] < e.getY()) && (e.getY() < C2[4])){
					if(matrix.viewValue(5, 2) == 0){
						this.C2[0] = lineColor;
						matrix.changeValue(5, 2, 1);
						if(this.tb.checkIsScore(this.cuad3)||this.tb.checkIsScore(this.cuad7)) {
							awardSquarePoints();
						} else if(this.tb.checkIsScoreTri(tri11)||this.tb.checkIsScoreTri(tri12)||this.tb.checkIsScoreTri(tri25)||this.tb.checkIsScoreTri(tri26)) {
							awardTriPoints();
						} else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				
				//D2
				if((D2[1] < e.getX()) && (e.getX() < D2[2]) && (D2[3] < e.getY()) && (e.getY() < D2[4])){
					if(matrix.viewValue(7, 2) == 0){
						this.D2[0] = lineColor;
						matrix.changeValue(7, 2, 1);
						
						if(this.tb.checkIsScore(this.cuad4)||this.tb.checkIsScore(this.cuad8)) {
							awardSquarePoints();
						} else if(this.tb.checkIsScoreTri(tri15)||this.tb.checkIsScoreTri(tri16)||this.tb.checkIsScoreTri(tri29)||this.tb.checkIsScoreTri(tri30)) {
							awardTriPoints();
						} else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				
				//A3
				if((30 < e.getX()) && (e.getX() < 115) && (0 < e.getY()) && (e.getY() < 30)){
					if(matrix.viewValue(1, 4) == 0){
						this.A3[0] = lineColor;
						matrix.changeValue(1, 4, 1);
						
						if(this.tb.checkIsScore(this.cuad5)||this.tb.checkIsScore(this.cuad9)) {
							awardSquarePoints();
						} else if(this.tb.checkIsScoreTri(tri19)||this.tb.checkIsScoreTri(tri20)||this.tb.checkIsScoreTri(tri33)||this.tb.checkIsScoreTri(tri34)) {
							awardTriPoints();
						} else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
						
						
				}
				
				//B3
				if((B3[1] < e.getX()) && (e.getX() < B3[2]) && (B3[3] < e.getY()) && (e.getY() < B3[4])){
					if(matrix.viewValue(3, 4) == 0){
						this.B3[0] = lineColor;
						matrix.changeValue(3, 4, 1);
						
						if(this.tb.checkIsScore(this.cuad6)||this.tb.checkIsScore(cuad10)) {
							awardSquarePoints();
						} else if(this.tb.checkIsScoreTri(tri23)||this.tb.checkIsScoreTri(tri24)||this.tb.checkIsScoreTri(tri37)||this.tb.checkIsScoreTri(tri38)) {
							awardTriPoints();
						}
						else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				
				//C3
				if((C3[1] < e.getX()) && (e.getX() < C3[2]) && (C3[3] < e.getY()) && (e.getY() < C3[4])){
					if(matrix.viewValue(5, 4) == 0){
						this.C3[0] = lineColor;
						matrix.changeValue(5, 4, 1);
						
						if(this.tb.checkIsScore(this.cuad7)||this.tb.checkIsScore(cuad11)) {
							awardSquarePoints();
						} else if(this.tb.checkIsScoreTri(tri27)||this.tb.checkIsScoreTri(tri28)||this.tb.checkIsScoreTri(tri41)||this.tb.checkIsScoreTri(tri42)) {
							awardTriPoints();
						}
						else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				
				//D3
				if((D3[1] < e.getX()) && (e.getX() < D3[2]) && (D3[3] < e.getY()) && (e.getY() < D3[4])){
					if(matrix.viewValue(7, 4) == 0){
						this.D3[0] = lineColor;
						matrix.changeValue(7, 4, 1);
						
						if(this.tb.checkIsScore(this.cuad8)||this.tb.checkIsScore(cuad12)) {
							awardSquarePoints();
						} else if(this.tb.checkIsScoreTri(tri31)||this.tb.checkIsScoreTri(tri32)||this.tb.checkIsScoreTri(tri45)||this.tb.checkIsScoreTri(tri46)) {
							awardTriPoints();
						}
						else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				
				//A4
				if((A4[1] < e.getX()) && (e.getX() < A4[2]) && (A4[3] < e.getY()) && (e.getY() < A4[4])){
					if(matrix.viewValue(1, 6) == 0){
						this.A4[0] = lineColor;
						matrix.changeValue(1, 6, 1);
						
						if(this.tb.checkIsScore(this.cuad9)||this.tb.checkIsScore(cuad13)) {
							awardSquarePoints();
						} else if(this.tb.checkIsScoreTri(tri35)||this.tb.checkIsScoreTri(tri36)||this.tb.checkIsScoreTri(tri49)||this.tb.checkIsScoreTri(tri50)) {
							awardTriPoints();
						}
						else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				
				//B4
				if((B4[1] < e.getX()) && (e.getX() < B4[2]) && (B4[3] < e.getY()) && (e.getY() < B4[4])){
					if(matrix.viewValue(3, 6) == 0){
						this.B4[0] = lineColor;
						matrix.changeValue(3, 6, 1);
						
						if(this.tb.checkIsScore(this.cuad10)||this.tb.checkIsScore(cuad14)) {
							awardSquarePoints();
						} else if(this.tb.checkIsScoreTri(tri39)||this.tb.checkIsScoreTri(tri40)||this.tb.checkIsScoreTri(tri53)||this.tb.checkIsScoreTri(tri54)) {
							awardTriPoints();
						}
						else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				
				//C4
				if((C4[1] < e.getX()) && (e.getX() < C4[2]) && (C4[3] < e.getY()) && (e.getY() < C4[4])){
					if(matrix.viewValue(5, 6) == 0){
						this.C4[0] = lineColor;
						matrix.changeValue(5, 6, 1);
						
						if(this.tb.checkIsScore(this.cuad11)||this.tb.checkIsScore(cuad15)) {
							awardSquarePoints();
						} else if(this.tb.checkIsScoreTri(tri43)||this.tb.checkIsScoreTri(tri44)||this.tb.checkIsScoreTri(tri57)||this.tb.checkIsScoreTri(tri58)) {
							awardTriPoints();
						}
						else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				
				//D4
				if((D4[1] < e.getX()) && (e.getX() < D4[2]) && (D4[3] < e.getY()) && (e.getY() < D4[4])){
					if(matrix.viewValue(7, 6) == 0){
						this.D4[0] = lineColor;
						matrix.changeValue(7, 6, 1);
						
						if(this.tb.checkIsScore(this.cuad12)||this.tb.checkIsScore(cuad16)) {
							awardSquarePoints();
						} else if(this.tb.checkIsScoreTri(tri47)||this.tb.checkIsScoreTri(tri48)||this.tb.checkIsScoreTri(tri61)||this.tb.checkIsScoreTri(tri62)) {
							awardTriPoints();
						}
						else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				
				//A5
				if((A5[1] < e.getX()) && (e.getX() < A5[2]) && (A5[3] < e.getY()) && (e.getY() < A5[4])){
					if(matrix.viewValue(1, 8) == 0){
						this.A5[0] = lineColor;
						matrix.changeValue(1, 8, 1);
						
						if(this.tb.checkIsScore(this.cuad13)) {
							awardSquarePoints();
						} else if(this.tb.checkIsScoreTri(tri51)||this.tb.checkIsScoreTri(tri52)) {
							awardTriPoints();
						}
						else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				
				//B5
				if((B5[1] < e.getX()) && (e.getX() < B5[2]) && (B5[3] < e.getY()) && (e.getY() < B5[4])){
					if(matrix.viewValue(3, 8) == 0){
						this.B5[0] = lineColor;
						matrix.changeValue(3, 8, 1);
						
						if(this.tb.checkIsScore(this.cuad14)) {
							awardSquarePoints();
						} else if(this.tb.checkIsScoreTri(tri55)||this.tb.checkIsScoreTri(tri56)) {
							awardTriPoints();
						}
						else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				
				//C5
				if((C5[1] < e.getX()) && (e.getX() < C5[2]) && (C5[3] < e.getY()) && (e.getY() < C5[4])){
					if(matrix.viewValue(5, 8) == 0){
						this.C5[0] = lineColor;
						matrix.changeValue(5, 8, 1);
						
						if(this.tb.checkIsScore(this.cuad15)) {
							awardSquarePoints();
						} else if(this.tb.checkIsScoreTri(tri59)||this.tb.checkIsScoreTri(tri60)) {
							awardTriPoints();
						}
						else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				
				//D5
				if((D5[1] < e.getX()) && (e.getX() < D5[2]) && (D5[3] < e.getY()) && (e.getY() < D5[4])){
					if(matrix.viewValue(7, 8) == 0){
						this.D5[0] = lineColor;
						matrix.changeValue(7, 8, 1);
						
						if(this.tb.checkIsScore(this.cuad16)) {
							awardSquarePoints();
						} else if(this.tb.checkIsScoreTri(tri63)||this.tb.checkIsScoreTri(tri64)) {
							awardTriPoints();
						}
						else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				
		// Vertical
				//E1
				if((E1[1] < e.getX()) && (e.getX() < E1[2]) && (E1[3] < e.getY()) && (e.getY() < E1[4])){
					if(matrix.viewValue(0, 1) == 0){
						this.E1[0] = lineColor;
						matrix.changeValue(0, 1, 1);
						
						if(this.tb.checkIsScore(this.cuad1)) {
							awardSquarePoints();
						} else if(this.tb.checkIsScoreTri(tri1)||this.tb.checkIsScoreTri(tri3)) {
							awardTriPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				
				//E2
				if((E2[1] < e.getX()) && (e.getX() < E2[2]) && (E2[3] < e.getY()) && (e.getY() < E2[4])){
					if(matrix.viewValue(2, 1) == 0){
						this.E2[0] = lineColor;
						matrix.changeValue(2, 1, 1);
						
						if(this.tb.checkIsScore(this.cuad1)||this.tb.checkIsScore(this.cuad2)) {
							awardSquarePoints();
						}else if(this.tb.checkIsScoreTri(tri2)||this.tb.checkIsScoreTri(tri4)||this.tb.checkIsScoreTri(tri5)||this.tb.checkIsScoreTri(tri7)) {
							awardTriPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				//E3
				if((E3[1] < e.getX()) && (e.getX() < E3[2]) && (E3[3] < e.getY()) && (e.getY() < E3[4])){
					if(matrix.viewValue(4, 1) == 0){
						this.E3[0] = lineColor;
						matrix.changeValue(4, 1, 1);
						
						if(this.tb.checkIsScore(this.cuad2)||this.tb.checkIsScore(this.cuad3)) {
							awardSquarePoints();
						}else if(this.tb.checkIsScoreTri(tri6)||this.tb.checkIsScoreTri(tri8)||this.tb.checkIsScoreTri(tri9)||this.tb.checkIsScoreTri(tri11)) {
							awardTriPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				//E4
				if((E4[1] < e.getX()) && (e.getX() < E4[2]) && (E4[3] < e.getY()) && (e.getY() < E4[4])){
					if(matrix.viewValue(6, 1) == 0){
						this.E4[0] = lineColor;
						matrix.changeValue(6, 1, 1);
						
						if(this.tb.checkIsScore(this.cuad3)||this.tb.checkIsScore(this.cuad4)) {
							awardSquarePoints();
						}else if(this.tb.checkIsScoreTri(tri10)||this.tb.checkIsScoreTri(tri12)||this.tb.checkIsScoreTri(tri13)||this.tb.checkIsScoreTri(tri15)) {
							awardTriPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				//E5
				if((E5[1] < e.getX()) && (e.getX() < E5[2]) && (E5[3] < e.getY()) && (e.getY() < E5[4])){
					if(matrix.viewValue(8, 1) == 0){
						this.E5[0] = lineColor;
						matrix.changeValue(8, 1, 1);
						
						if(this.tb.checkIsScore(this.cuad4)) {
							awardSquarePoints();
						}else if(this.tb.checkIsScoreTri(tri14)||this.tb.checkIsScoreTri(tri16)) {
							awardTriPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				
				//F1
				if((F1[1] < e.getX()) && (e.getX() < F1[2]) && (F1[3] < e.getY()) && (e.getY() < F1[4])){
					if(matrix.viewValue(0, 3) == 0){
						this.F1[0] = lineColor;
						matrix.changeValue(0, 3, 1);
						
						if(this.tb.checkIsScore(this.cuad5)) {
							awardSquarePoints();
						}else if(this.tb.checkIsScoreTri(tri17)||this.tb.checkIsScoreTri(tri19)) {
							awardTriPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				
				//F2
				if((F2[1] < e.getX()) && (e.getX() < F2[2]) && (F2[3] < e.getY()) && (e.getY() < F2[4])){
					if(matrix.viewValue(2, 3) == 0){
						this.F2[0] = lineColor;
						matrix.changeValue(2, 3, 1);
						
						if(this.tb.checkIsScore(this.cuad5)||this.tb.checkIsScore(this.cuad6)) {
							awardSquarePoints();
						}else if(this.tb.checkIsScoreTri(tri18)||this.tb.checkIsScoreTri(tri20)||this.tb.checkIsScoreTri(tri21)||this.tb.checkIsScoreTri(tri23)) {
							awardTriPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				//F3
				if((F3[1] < e.getX()) && (e.getX() < F3[2]) && (F3[3] < e.getY()) && (e.getY() < F3[4])){
					if(matrix.viewValue(4, 3) == 0){
						this.F3[0] = lineColor;
						matrix.changeValue(4, 3, 1);
						
						if(this.tb.checkIsScore(this.cuad6)||this.tb.checkIsScore(this.cuad7)) {
							awardSquarePoints();
						}else if(this.tb.checkIsScoreTri(tri22)||this.tb.checkIsScoreTri(tri24)||this.tb.checkIsScoreTri(tri25)||this.tb.checkIsScoreTri(tri27)) {
							awardTriPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				//F4
				if((F4[1] < e.getX()) && (e.getX() < F4[2]) && (F4[3] < e.getY()) && (e.getY() < F4[4])){
					if(matrix.viewValue(6, 3) == 0){
						this.F4[0] = lineColor;
						matrix.changeValue(6, 3, 1);
						
						if(this.tb.checkIsScore(this.cuad7)||this.tb.checkIsScore(this.cuad8)) {
							awardSquarePoints();
						}else if(this.tb.checkIsScoreTri(tri26)||this.tb.checkIsScoreTri(tri28)||this.tb.checkIsScoreTri(tri29)||this.tb.checkIsScoreTri(tri31)) {
							awardTriPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				//F5
				if((F5[1] < e.getX()) && (e.getX() < F5[2]) && (F5[3] < e.getY()) && (e.getY() < F5[4])){
					if(matrix.viewValue(8, 3) == 0){
						this.F5[0] = lineColor;
						matrix.changeValue(8, 3, 1);
						
						if(this.tb.checkIsScore(this.cuad8)) {
							awardSquarePoints();
						}else if(this.tb.checkIsScoreTri(tri30)||this.tb.checkIsScoreTri(tri32)) {
							awardTriPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				
				//G1
				if((G1[1] < e.getX()) && (e.getX() < G1[2]) && (G1[3] < e.getY()) && (e.getY() < G1[4])){
					if(matrix.viewValue(0, 5) == 0){
						this.G1[0] = lineColor;
						matrix.changeValue(0, 5, 1);
						
						if(this.tb.checkIsScore(this.cuad9)) {
							awardSquarePoints();
						}else if(this.tb.checkIsScoreTri(tri33)||this.tb.checkIsScoreTri(tri35)) {
							awardTriPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}					}
				}
				
				//G2
				if((G2[1] < e.getX()) && (e.getX() < G2[2]) && (G2[3] < e.getY()) && (e.getY() < G2[4])){
					if(matrix.viewValue(2, 5) == 0){
						this.G2[0] = lineColor;
						matrix.changeValue(2, 5, 1);
						
						if(this.tb.checkIsScore(this.cuad9)||this.tb.checkIsScore(this.cuad10)) {
							awardSquarePoints();
						}else if(this.tb.checkIsScoreTri(tri34)||this.tb.checkIsScoreTri(tri36)||this.tb.checkIsScoreTri(tri37)||this.tb.checkIsScoreTri(tri39)) {
							awardTriPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				//G3
				if((G3[1] < e.getX()) && (e.getX() < G3[2]) && (G3[3] < e.getY()) && (e.getY() < G3[4])){
					if(matrix.viewValue(4, 5) == 0){
						this.G3[0] = lineColor;
						matrix.changeValue(4, 5, 1);
						
						if(this.tb.checkIsScore(this.cuad10)||this.tb.checkIsScore(this.cuad11)) {
							awardSquarePoints();
						}else if(this.tb.checkIsScoreTri(tri38)||this.tb.checkIsScoreTri(tri40)||this.tb.checkIsScoreTri(tri41)||this.tb.checkIsScoreTri(tri43)) {
							awardTriPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				//G4
				if((G4[1] < e.getX()) && (e.getX() < G4[2]) && (G4[3] < e.getY()) && (e.getY() < G4[4])){
					if(matrix.viewValue(6, 5) == 0){
						this.G4[0] = lineColor;
						matrix.changeValue(6, 5, 1);
						
						if(this.tb.checkIsScore(this.cuad11)||this.tb.checkIsScore(this.cuad12)) {
							awardSquarePoints();
						}else if(this.tb.checkIsScoreTri(tri42)||this.tb.checkIsScoreTri(tri44)||this.tb.checkIsScoreTri(tri45)||this.tb.checkIsScoreTri(tri47)) {
							awardTriPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				//G5
				if((G5[1] < e.getX()) && (e.getX() < G5[2]) && (G5[3] < e.getY()) && (e.getY() < G5[4])){
					if(matrix.viewValue(8, 5) == 0){
						this.G5[0] = lineColor;
						matrix.changeValue(8, 5, 1);
						
						if(this.tb.checkIsScore(this.cuad12)) {
							awardSquarePoints();
						}else if(this.tb.checkIsScoreTri(tri46)||this.tb.checkIsScoreTri(tri48)) {
							awardTriPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				
				//H1
				if((H1[1] < e.getX()) && (e.getX() < H1[2]) && (H1[3] < e.getY()) && (e.getY() < H1[4])){
					if(matrix.viewValue(0, 7) == 0){
						this.H1[0] = lineColor;
						matrix.changeValue(0, 7, 1);
						
						if(this.tb.checkIsScore(this.cuad13)) {
							awardSquarePoints();
						}else if(this.tb.checkIsScoreTri(tri49)||this.tb.checkIsScoreTri(tri51)) {
							awardTriPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				
				//H2
				if((H2[1] < e.getX()) && (e.getX() < H2[2]) && (H2[3] < e.getY()) && (e.getY() < H2[4])){
					if(matrix.viewValue(2, 7) == 0){
						this.H2[0] = lineColor;
						matrix.changeValue(2, 7, 1);
						
						if(this.tb.checkIsScore(this.cuad13)||this.tb.checkIsScore(this.cuad14)) {
							awardSquarePoints();
						}else if(this.tb.checkIsScoreTri(tri50)||this.tb.checkIsScoreTri(tri52)||this.tb.checkIsScoreTri(tri53)||this.tb.checkIsScoreTri(tri55)) {
							awardTriPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				//H3
				if((H3[1] < e.getX()) && (e.getX() < H3[2]) && (H3[3] < e.getY()) && (e.getY() < H3[4])){
					if(matrix.viewValue(4, 7) == 0){
						this.H3[0] = lineColor;
						matrix.changeValue(4, 7, 1);
						
						if(this.tb.checkIsScore(this.cuad14)||this.tb.checkIsScore(this.cuad15)) {
							awardSquarePoints();
						}else if(this.tb.checkIsScoreTri(tri54)||this.tb.checkIsScoreTri(tri56)||this.tb.checkIsScoreTri(tri57)||this.tb.checkIsScoreTri(tri59)) {
							awardTriPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				//H4
				if((H4[1] < e.getX()) && (e.getX() < H4[2]) && (H4[3] < e.getY()) && (e.getY() < H4[4])){
					if(matrix.viewValue(6, 7) == 0){
						//Cambia el color de la l�nea al color del jugador
						this.H4[0] = lineColor;
						matrix.changeValue(6, 7, 1);
						
						if(this.tb.checkIsScore(this.cuad15)||this.tb.checkIsScore(this.cuad16)) {
							awardSquarePoints();
						}else if(this.tb.checkIsScoreTri(tri58)||this.tb.checkIsScoreTri(tri60)||this.tb.checkIsScoreTri(tri61)||this.tb.checkIsScoreTri(tri63)) {
							awardTriPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				//H5
				if((H5[1] < e.getX()) && (e.getX() < H5[2]) && (H5[3] < e.getY()) && (e.getY() < H5[4])){
					if(matrix.viewValue(8, 7) == 0){
						this.H5[0] = lineColor;
						matrix.changeValue(8, 7, 1);
						
						if(this.tb.checkIsScore(this.cuad16)) {
							awardSquarePoints();
						}else if(this.tb.checkIsScoreTri(tri62)||this.tb.checkIsScoreTri(tri64)) {
							awardTriPoints();
						}else {
							this.p1.switchTurn();
							this.p2.switchTurn();
						}
					}
				}
				
				//The diagonals aren't implemented yet
				
				if(this.tb.checkGameOver(this.todasLasCajas, this.todasLasCajas))
				{
					System.out.println("Game over");
				}
			}	
				
	}
					
	
}

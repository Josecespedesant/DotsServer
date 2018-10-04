package logic;

import matrix.Matrix;

public class PintaCuad {
	Player p1;
	Player p2;
	
	public PintaCuad(Player p1, Player p2) {
		this.p1 = p1;
		this.p2 = p2;
	}
	
	public void cuadr1(Matrix matrix) {
		
		
		if(p1.getActiveTurn()==true) {
			matrix.changeValue(1, 0, 2);
			matrix.changeValue(1, 2, 2);
			matrix.changeValue(0, 1, 2);
			matrix.changeValue(2, 1, 2);
		}else { 
			matrix.changeValue(1, 0, 3);
			matrix.changeValue(1, 2, 3);
			matrix.changeValue(0, 1, 3);
			matrix.changeValue(2, 1, 3);
		}
	}
	public void cuadr2(Matrix matrix) {
		if(p1.getActiveTurn()==true) {
			matrix.changeValue(3, 0, 2);
			matrix.changeValue(3, 2, 2);
			matrix.changeValue(2, 1, 2);
			matrix.changeValue(4, 1, 2);
		}else {
			matrix.changeValue(3, 0, 3);
			matrix.changeValue(3, 2, 3);
			matrix.changeValue(2, 1, 3);
			matrix.changeValue(4, 1, 3);
		}
	}
	public void cuadr3(Matrix matrix) {
		if(p1.getActiveTurn()==true) {
			matrix.changeValue(5, 0, 2);
			matrix.changeValue(3, 2, 2);
			matrix.changeValue(4, 1, 2);
			matrix.changeValue(6, 1, 2);
		}else {
			matrix.changeValue(5, 0, 3);
			matrix.changeValue(3, 2, 3);
			matrix.changeValue(4, 1, 3);
			matrix.changeValue(6, 1, 3);
		}
	}
	public void cuadr4(Matrix matrix) {
		if(p1.getActiveTurn()==true) {
			matrix.changeValue(7, 0, 2);
			matrix.changeValue(7, 2, 2);
			matrix.changeValue(4, 1, 2);
			matrix.changeValue(8, 1, 2);
		}else {
			matrix.changeValue(7, 0, 3);
			matrix.changeValue(7, 2, 3);
			matrix.changeValue(4, 1, 3);
			matrix.changeValue(8, 1, 3);
		}
	}
	public void cuadr5(Matrix matrix) {
		if(p1.getActiveTurn()==true) {
			matrix.changeValue(1, 2, 2);
			matrix.changeValue(1, 4, 2);
			matrix.changeValue(0, 3, 2);
			matrix.changeValue(2, 3, 2);
		}else {
			matrix.changeValue(1, 2, 3);
			matrix.changeValue(1, 4, 3);
			matrix.changeValue(0, 3, 3);
			matrix.changeValue(2, 3, 3);
		}
	}
	public void cuadr6(Matrix matrix) {
		if(p1.getActiveTurn()==true) {
			matrix.changeValue(3, 2, 2);
			matrix.changeValue(3, 4, 2);
			matrix.changeValue(2, 3, 2);
			matrix.changeValue(4, 3, 2);
		}else {
			matrix.changeValue(3, 2, 3);
			matrix.changeValue(3, 4, 3);
			matrix.changeValue(2, 3, 3);
			matrix.changeValue(4, 3, 3);
		}
	}
	public void cuadr7(Matrix matrix) {
		if(p1.getActiveTurn()==true) {
			matrix.changeValue(5, 2, 2);
			matrix.changeValue(5, 4, 2);
			matrix.changeValue(4, 3, 2);
			matrix.changeValue(6, 3, 2);
		}else {
			matrix.changeValue(5, 2, 3);
			matrix.changeValue(5, 4, 3);
			matrix.changeValue(4, 3, 3);
			matrix.changeValue(6, 3, 3);
		}
	}
	public void cuadr8(Matrix matrix) {
		if(p1.getActiveTurn()==true) {
			matrix.changeValue(7, 2, 2);
			matrix.changeValue(7, 4, 2);
			matrix.changeValue(6, 3, 2);
			matrix.changeValue(8, 3, 2);
		}else {
			matrix.changeValue(1, 2, 3);
			matrix.changeValue(1, 4, 3);
			matrix.changeValue(0, 3, 3);
			matrix.changeValue(2, 3, 3);
		}
	}
	public void cuadr9(Matrix matrix) {
		if(p1.getActiveTurn()==true) {
			matrix.changeValue(1, 4, 2);
			matrix.changeValue(1, 6, 2);
			matrix.changeValue(0, 5, 2);
			matrix.changeValue(2, 5, 2);
		}else {
			matrix.changeValue(1, 4, 3);
			matrix.changeValue(1, 6, 3);
			matrix.changeValue(0, 5, 3);
			matrix.changeValue(2, 5, 3);
		}
	}
	public void cuadr10(Matrix matrix) {
		if(p1.getActiveTurn()==true) {
			matrix.changeValue(3, 4, 2);
			matrix.changeValue(3, 6, 2);
			matrix.changeValue(2, 5, 2);
			matrix.changeValue(4, 5, 2);
		}else {
			matrix.changeValue(3, 4, 3);
			matrix.changeValue(3, 6, 3);
			matrix.changeValue(2, 5, 3);
			matrix.changeValue(4, 5, 3);
		}
	}
	public void cuadr11(Matrix matrix) {
		if(p1.getActiveTurn()==true) {
			matrix.changeValue(5, 4, 2);
			matrix.changeValue(5, 6, 2);
			matrix.changeValue(4, 5, 2);
			matrix.changeValue(6, 5, 2);
		}else {
			matrix.changeValue(5, 4, 3);
			matrix.changeValue(5, 6, 3);
			matrix.changeValue(4, 5, 3);
			matrix.changeValue(6, 5, 3);
		}
	}
	public void cuadr12(Matrix matrix) {
		if(p1.getActiveTurn()==true) {
			matrix.changeValue(7, 4, 2);
			matrix.changeValue(7, 6, 2);
			matrix.changeValue(6, 5, 2);
			matrix.changeValue(8, 5, 2);
		}else {
			matrix.changeValue(7, 4, 3);
			matrix.changeValue(7, 6, 3);
			matrix.changeValue(6, 5, 3);
			matrix.changeValue(8, 5, 3);
		}
	}
	public void cuadr13(Matrix matrix) {
		if(p1.getActiveTurn()==true) {
			matrix.changeValue(1, 6, 2);
			matrix.changeValue(1, 8, 2);
			matrix.changeValue(0, 7, 2);
			matrix.changeValue(2, 7, 2);
		}else {
			matrix.changeValue(1, 4, 3);
			matrix.changeValue(1, 6, 3);
			matrix.changeValue(0, 3, 3);
			matrix.changeValue(2, 3, 3);
		}
	}
	public void cuadr14(Matrix matrix) {
		if(p1.getActiveTurn()==true) {
			matrix.changeValue(3, 6, 2);
			matrix.changeValue(3, 8, 2);
			matrix.changeValue(2, 7, 2);
			matrix.changeValue(4, 7, 2);
		}else {
			matrix.changeValue(3, 4, 3);
			matrix.changeValue(3, 6, 3);
			matrix.changeValue(2, 3, 3);
			matrix.changeValue(4, 3, 3);
		}
	}
	public void cuadr15(Matrix matrix) {
		if(p1.getActiveTurn()==true) {
			matrix.changeValue(5, 6, 2);
			matrix.changeValue(5, 8, 2);
			matrix.changeValue(4, 7, 2);
			matrix.changeValue(6, 7, 2);
		}else {
			matrix.changeValue(5, 4, 3);
			matrix.changeValue(5, 6, 3);
			matrix.changeValue(4, 3, 3);
			matrix.changeValue(6, 3, 3);
		}
	}
	public void cuadr16(Matrix matrix) {
		if(p1.getActiveTurn()==true) {
			matrix.changeValue(7, 6, 2);
			matrix.changeValue(7, 8, 2);
			matrix.changeValue(6, 7, 2);
			matrix.changeValue(8, 7, 2);
		}else {
			matrix.changeValue(7, 4, 3);
			matrix.changeValue(7, 6, 3);
			matrix.changeValue(6, 3, 3);
			matrix.changeValue(8, 3, 3);
		}
	}
}

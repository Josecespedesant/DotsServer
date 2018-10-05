package logic;

import matrix.Matrix;

public class PintaTri {
	Player p1;
	Player p2;
	
	public PintaTri(Player p1, Player p2) {
		this.p1 = p1;
		this.p2 = p2;
	}
	
	public void tria1(Matrix matrix) {
		if(p1.getActiveTurn()==true) {
			matrix.changeValue(1, 0, 2);
			matrix.changeValue(0, 1, 2);
			matrix.changeValue(1, 1, 2);
		}else {
			matrix.changeValue(1, 0, 3);
			matrix.changeValue(0, 1, 3);
			matrix.changeValue(1, 1, 3);
		}
	}
	public void tria2(Matrix matrix) {
		if(p1.getActiveTurn()==true) {
			matrix.changeValue(1, 0, 2);
			matrix.changeValue(2, 1, 2);
			matrix.changeValue(1, 1, 2);
		}else {
			matrix.changeValue(1, 0, 3);
			matrix.changeValue(2, 1, 3);
			matrix.changeValue(1, 1, 3);
		}
	}
	public void tria3(Matrix matrix) {
		if(p1.getActiveTurn()==true) {
			matrix.changeValue(1, 2, 2);
			matrix.changeValue(0, 1, 2);
			matrix.changeValue(1, 1, 2);
		}else {
			matrix.changeValue(1, 2, 3);
			matrix.changeValue(0, 1, 3);
			matrix.changeValue(1, 1, 3);
		}
	}
	public void tria4(Matrix matrix) {
		if(p1.getActiveTurn()==true) {
			matrix.changeValue(1, 2, 2);
			matrix.changeValue(2, 1, 2);
			matrix.changeValue(1, 1, 2);
		}else {
			matrix.changeValue(1, 2, 3);
			matrix.changeValue(2, 1, 3);
			matrix.changeValue(1, 1, 3);
		}
	}
	public void tria5(Matrix matrix) {
		if(p1.getActiveTurn()==true) {
			matrix.changeValue(3, 0, 2);
			matrix.changeValue(2, 1, 2);
			matrix.changeValue(1, 3, 2);
		}else {
			matrix.changeValue(3, 0, 3);
			matrix.changeValue(2, 1, 3);
			matrix.changeValue(1, 3, 3);
		}
	}
	public void tria6(Matrix matrix) {
		if(p1.getActiveTurn()==true) {
			matrix.changeValue(3, 0, 2);
			matrix.changeValue(4, 1, 2);
			matrix.changeValue(1, 3, 2);
		}else {
			matrix.changeValue(3, 0, 3); 
			matrix.changeValue(4, 1, 3);
			matrix.changeValue(1, 3, 3);
		}
	}
	public void tria7(Matrix matrix) {
		if(p1.getActiveTurn()==true) {
			matrix.changeValue(3, 2, 2);
			matrix.changeValue(2, 1, 2);
			matrix.changeValue(1, 3, 2);
		}else {
			matrix.changeValue(3, 2, 3);
			matrix.changeValue(2, 1, 3);
			matrix.changeValue(1, 3, 3);
		}
	}
	public void tria8(Matrix matrix) {
		if(p1.getActiveTurn()==true) {
			matrix.changeValue(3, 2, 2);
			matrix.changeValue(4, 1, 2);
			matrix.changeValue(1, 3, 2);
		}else {
			matrix.changeValue(3, 2, 3);
			matrix.changeValue(4, 1, 3);
			matrix.changeValue(1, 3, 3);
		}
	}
	public void tria9(Matrix matrix) {
		if(p1.getActiveTurn()==true) {
			matrix.changeValue(5, 0, 2);
			matrix.changeValue(4, 1, 2);
			matrix.changeValue(1, 5, 2);
		}else {
			matrix.changeValue(5, 0, 3);
			matrix.changeValue(4, 1, 3);
			matrix.changeValue(1, 5, 3);
		}
	}
	public void tria10(Matrix matrix) {
		if(p1.getActiveTurn()==true) {
			matrix.changeValue(5, 0, 2);
			matrix.changeValue(4, 1, 2);
			matrix.changeValue(1, 5, 2);
		}else {
			matrix.changeValue(5, 0, 3);
			matrix.changeValue(4, 1, 3);
			matrix.changeValue(1, 5, 3);
		}
	}
	public void tria11(Matrix matrix) {
		if(p1.getActiveTurn()==true) {
			matrix.changeValue(5, 2, 2);
			matrix.changeValue(4, 1, 2);
			matrix.changeValue(1, 5, 2);
		}else {
			matrix.changeValue(5, 2, 3);
			matrix.changeValue(4, 1, 3);
			matrix.changeValue(1, 5, 3);
		}
	}
	public void tria12(Matrix matrix) {
		if(p1.getActiveTurn()==true) {
			matrix.changeValue(5, 2, 2);
			matrix.changeValue(6, 1, 2);
			matrix.changeValue(1, 5, 2);
		}else {
			matrix.changeValue(5, 2, 3);
			matrix.changeValue(6, 1, 3);
			matrix.changeValue(1, 1, 3);
		}
	}
	public void tria13(Matrix matrix) {
		if(p1.getActiveTurn()==true) {
			matrix.changeValue(7, 0, 2);
			matrix.changeValue(6, 1, 2);
			matrix.changeValue(1, 7, 2);
		}else {
			matrix.changeValue(7, 0, 3);
			matrix.changeValue(6, 1, 3);
			matrix.changeValue(1, 7, 3);
		}
	}
	public void tria14(Matrix matrix) {
		if(p1.getActiveTurn()==true) {
			matrix.changeValue(7, 0, 2);
			matrix.changeValue(8, 1, 2);
			matrix.changeValue(1, 7, 2);
		}else {
			matrix.changeValue(7, 0, 3);
			matrix.changeValue(8, 1, 3);
			matrix.changeValue(1, 7, 3);
		}
	}
	public void tria15(Matrix matrix) {
		if(p1.getActiveTurn()==true) {
			matrix.changeValue(7, 2, 2);
			matrix.changeValue(6, 1, 2);
			matrix.changeValue(1, 7, 2);
		}else {
			matrix.changeValue(7, 2, 3);
			matrix.changeValue(6, 1, 3);
			matrix.changeValue(1, 7, 3);
		}
	}
	public void tria16(Matrix matrix) {
		if(p1.getActiveTurn()==true) {
			matrix.changeValue(7, 2, 2);
			matrix.changeValue(8, 1, 2);
			matrix.changeValue(1, 7, 2);
		}else {
			matrix.changeValue(7, 2, 3);
			matrix.changeValue(8, 1, 3);
			matrix.changeValue(1, 7, 3);
		}
	}
	public void tria17(Matrix matrix) {
		if(p1.getActiveTurn()==true) {
			matrix.changeValue(1, 2, 2);
			matrix.changeValue(0, 3, 2);
			matrix.changeValue(3, 1, 2);
		}else {
			matrix.changeValue(1, 2, 3);
			matrix.changeValue(0, 3, 3);
			matrix.changeValue(3, 1, 3);
		}
	}
	public void tria18(Matrix matrix) {
		if(p1.getActiveTurn()==true) {
			matrix.changeValue(1, 2, 2);
			matrix.changeValue(2, 3, 2);
			matrix.changeValue(3, 1, 2);
		}else {
			matrix.changeValue(1, 2, 3);
			matrix.changeValue(2, 3, 3);
			matrix.changeValue(3, 1, 3);
		}
	}
	public void tria19(Matrix matrix) {
		if(p1.getActiveTurn()==true) {
			matrix.changeValue(1, 4, 2);
			matrix.changeValue(0, 3, 2);
			matrix.changeValue(3, 1, 2);
		}else {
			matrix.changeValue(1, 4, 3);
			matrix.changeValue(0, 3, 3);
			matrix.changeValue(3, 1, 3);
		}
	}
	public void tria20(Matrix matrix) {
		if(p1.getActiveTurn()==true) {
			matrix.changeValue(1, 4, 2);
			matrix.changeValue(2, 3, 2);
			matrix.changeValue(3, 1, 2);
		}else {
			matrix.changeValue(1, 4, 3);
			matrix.changeValue(2, 3, 3);
			matrix.changeValue(3, 1, 3);
		}
	}
	public void tria21(Matrix matrix) {
		if(p1.getActiveTurn()==true) {
			matrix.changeValue(3, 2, 2);
			matrix.changeValue(2, 3, 2);
			matrix.changeValue(3, 3, 2);
		}else {
			matrix.changeValue(3, 2, 3);
			matrix.changeValue(2, 2, 3);
			matrix.changeValue(3, 3, 3);
		}
	}
	public void tria22(Matrix matrix) {
		if(p1.getActiveTurn()==true) {
			matrix.changeValue(3, 2, 2);
			matrix.changeValue(4, 3, 2);
			matrix.changeValue(3, 3, 2);
		}else {
			matrix.changeValue(3, 2, 3);
			matrix.changeValue(4, 3, 3);
			matrix.changeValue(3, 3, 3);
		}
	}
	public void tria23(Matrix matrix) {
		if(p1.getActiveTurn()==true) {
			matrix.changeValue(3, 4, 2);
			matrix.changeValue(2, 3, 2);
			matrix.changeValue(3, 3, 2);
		}else {
			matrix.changeValue(3, 4, 3);
			matrix.changeValue(2, 3, 3);
			matrix.changeValue(3, 3, 3);
		}
	}
	public void tria24(Matrix matrix) {
		if(p1.getActiveTurn()==true) {
			matrix.changeValue(3, 4, 2);
			matrix.changeValue(4, 3, 2);
			matrix.changeValue(3, 3, 2);
		}else {
			matrix.changeValue(3, 4, 3);
			matrix.changeValue(4, 3, 3);
			matrix.changeValue(3, 3, 3);
		}
	}
	public void tria25(Matrix matrix) {
		if(p1.getActiveTurn()==true) {
			matrix.changeValue(5, 2, 2);
			matrix.changeValue(4, 3, 2);
			matrix.changeValue(3, 5, 2);
		}else {
			matrix.changeValue(5, 2, 3);
			matrix.changeValue(4, 3, 3);
			matrix.changeValue(3, 5, 3);
		}
	}
	public void tria26(Matrix matrix) {
		if(p1.getActiveTurn()==true) {
			matrix.changeValue(5, 2, 2);
			matrix.changeValue(6, 3, 2);
			matrix.changeValue(3, 5, 2);
		}else {
			matrix.changeValue(5, 2, 3);
			matrix.changeValue(6, 3, 3);
			matrix.changeValue(3, 5, 3);
		}
	}
	public void tria27(Matrix matrix) {
		if(p1.getActiveTurn()==true) {
			matrix.changeValue(5, 4, 2);
			matrix.changeValue(4, 3, 2);
			matrix.changeValue(3, 5, 2);
		}else {
			matrix.changeValue(5, 4, 3);
			matrix.changeValue(4, 3, 3);
			matrix.changeValue(3, 5, 3);
		}
	}
	public void tria28(Matrix matrix) {
		if(p1.getActiveTurn()==true) {
			matrix.changeValue(5, 4, 2);
			matrix.changeValue(6, 3, 2);
			matrix.changeValue(3, 5, 2);
		}else {
			matrix.changeValue(5, 4, 3);
			matrix.changeValue(6, 3, 3);
			matrix.changeValue(3, 5, 3);
		}
	}
	public void tria29(Matrix matrix) {
		if(p1.getActiveTurn()==true) {
			matrix.changeValue(7, 2, 2);
			matrix.changeValue(8, 3, 2);
			matrix.changeValue(3, 7, 2);
		}else {
			matrix.changeValue(7, 2, 3);
			matrix.changeValue(8, 3, 3);
			matrix.changeValue(3, 7, 3);
		}
	}
	public void tria30(Matrix matrix) {
		if(p1.getActiveTurn()==true) {
			matrix.changeValue(7, 2, 2);
			matrix.changeValue(8, 3, 2);
			matrix.changeValue(3, 7, 2);
		}else {
			matrix.changeValue(7, 2, 3);
			matrix.changeValue(8, 3, 3);
			matrix.changeValue(3, 7, 3);
		}
	}
	public void tria31(Matrix matrix) {
		if(p1.getActiveTurn()==true) {						
			matrix.changeValue(7, 4, 2);
			matrix.changeValue(6, 3, 2);
			matrix.changeValue(3, 7, 2);

		}else {
			matrix.changeValue(7, 4, 3);
			matrix.changeValue(6, 3, 3);
			matrix.changeValue(3, 7, 3);
		}
	}
	public void tria32(Matrix matrix) {
		if(p1.getActiveTurn()==true) {
			matrix.changeValue(7, 4, 2);
			matrix.changeValue(8, 3, 2);
			matrix.changeValue(3, 7, 2);
		}else {
			matrix.changeValue(7, 4, 3);
			matrix.changeValue(8, 3, 3);
			matrix.changeValue(3, 7, 3);
		}
	}
	public void tria33(Matrix matrix) {
		if(p1.getActiveTurn()==true) {
			matrix.changeValue(1, 4, 2);
			matrix.changeValue(0, 5, 2);
			matrix.changeValue(5, 1, 2);
		}else {
			matrix.changeValue(1, 4, 3);
			matrix.changeValue(0, 5, 3);
			matrix.changeValue(5, 1, 3);
		}
	}
	public void tria34(Matrix matrix) {
		if(p1.getActiveTurn()==true) {
			matrix.changeValue(1, 4, 2);
			matrix.changeValue(2, 5, 2);
			matrix.changeValue(5, 1, 2);
		}else {
			matrix.changeValue(1, 4, 3);
			matrix.changeValue(2, 5, 3);
			matrix.changeValue(5, 1, 3);
		}
	}
	public void tria35(Matrix matrix) {
		if(p1.getActiveTurn()==true) {
			matrix.changeValue(1, 6, 2);
			matrix.changeValue(0, 5, 2);
			matrix.changeValue(5, 1, 2);
		}else {
			matrix.changeValue(1, 6, 3);
			matrix.changeValue(0, 5, 3);
			matrix.changeValue(5, 1, 3);
		}
	}
	public void tria36(Matrix matrix) {
		if(p1.getActiveTurn()==true) {
			matrix.changeValue(1, 6, 2);
			matrix.changeValue(2, 5, 2);
			matrix.changeValue(5, 1, 2);
		}else {
			matrix.changeValue(1, 6, 3);
			matrix.changeValue(2, 5, 3);
			matrix.changeValue(5, 1, 3);
		}
	}
	public void tria37(Matrix matrix) {
		if(p1.getActiveTurn()==true) {
			matrix.changeValue(3, 4, 2);
			matrix.changeValue(2, 5, 2);
			matrix.changeValue(5, 3, 2);
		}else {
			matrix.changeValue(3, 4, 3);
			matrix.changeValue(2, 5, 3);
			matrix.changeValue(5, 3, 3);
		}
	}
	public void tria38(Matrix matrix) {
		if(p1.getActiveTurn()==true) {
			matrix.changeValue(3, 4, 2);
			matrix.changeValue(4, 5, 2);
			matrix.changeValue(5, 3, 2);
		}else {
			matrix.changeValue(3, 4, 3);
			matrix.changeValue(4, 5, 3);
			matrix.changeValue(5, 3, 3);
		}
	}
	public void tria39(Matrix matrix) {
		if(p1.getActiveTurn()==true) {
			matrix.changeValue(3, 6, 2);
			matrix.changeValue(2, 5, 2);
			matrix.changeValue(5, 3, 2);
		}else {
			matrix.changeValue(3, 6, 3);
			matrix.changeValue(2, 5, 3);
			matrix.changeValue(5, 3, 3);
		}
	}
	public void tria40(Matrix matrix) {
		if(p1.getActiveTurn()==true) {
			matrix.changeValue(3, 6, 2);
			matrix.changeValue(4, 5, 2);
			matrix.changeValue(5, 3, 2);
		}else {
			matrix.changeValue(3, 6, 3);
			matrix.changeValue(4, 5, 3);
			matrix.changeValue(5, 3, 3);
		}
	}
	public void tria41(Matrix matrix) {
		if(p1.getActiveTurn()==true) {
			matrix.changeValue(5, 4, 2);
			matrix.changeValue(4, 5, 2);
			matrix.changeValue(5, 5, 2);
		}else {
			matrix.changeValue(5, 4, 3);
			matrix.changeValue(4, 5, 3);
			matrix.changeValue(5, 5, 3);
		}
	}
	public void tria42(Matrix matrix) {
		if(p1.getActiveTurn()==true) {
			matrix.changeValue(5, 4, 2);
			matrix.changeValue(6, 5, 2);
			matrix.changeValue(5, 5, 2);
		}else {
			matrix.changeValue(5, 4, 3);
			matrix.changeValue(6, 5, 3);
			matrix.changeValue(5, 5, 3);
		}
	}
	public void tria43(Matrix matrix) {
		if(p1.getActiveTurn()==true) {
			matrix.changeValue(5, 6, 2);
			matrix.changeValue(4, 5, 2);
			matrix.changeValue(5, 5, 2);
		}else {
			matrix.changeValue(5, 6, 3);
			matrix.changeValue(4, 5, 3);
			matrix.changeValue(5, 5, 3);
		}
	}
	public void tria44(Matrix matrix) {
		if(p1.getActiveTurn()==true) {
			matrix.changeValue(5, 6, 2);
			matrix.changeValue(6, 5, 2);
			matrix.changeValue(5, 5, 2);
		}else {
			matrix.changeValue(5, 6, 3);
			matrix.changeValue(6, 5, 3);
			matrix.changeValue(5, 5, 3);
		}
	}
	public void tria45(Matrix matrix) {
		if(p1.getActiveTurn()==true) {
			matrix.changeValue(7, 4, 2);
			matrix.changeValue(6, 5, 2);
			matrix.changeValue(5, 7, 2);
		}else {
			matrix.changeValue(7, 4, 3);
			matrix.changeValue(6, 5, 3);
			matrix.changeValue(5, 7, 3);
		}
	}
	public void tria46(Matrix matrix) {
		if(p1.getActiveTurn()==true) {
			matrix.changeValue(7, 4, 2);
			matrix.changeValue(8, 5, 2);
			matrix.changeValue(5, 7, 2);
		}else {
			matrix.changeValue(7, 4, 3);
			matrix.changeValue(8, 5, 3);
			matrix.changeValue(5, 7, 3);
		}
	}
	public void tria47(Matrix matrix) {
		if(p1.getActiveTurn()==true) {
			matrix.changeValue(7, 6, 2);
			matrix.changeValue(6, 5, 2);
			matrix.changeValue(5, 7, 2);
		}else {
			matrix.changeValue(7, 6, 3);
			matrix.changeValue(6, 5, 3);
			matrix.changeValue(5, 7, 3);
		}
	}
	public void tria48(Matrix matrix) {
		if(p1.getActiveTurn()==true) {
			matrix.changeValue(7, 6, 2);
			matrix.changeValue(8, 5, 2);
			matrix.changeValue(5, 7, 2);
		}else {
			matrix.changeValue(1, 0, 3);
			matrix.changeValue(2, 1, 3);
			matrix.changeValue(1, 1, 3);
		}
	}
	public void tria49(Matrix matrix) {
		if(p1.getActiveTurn()==true) {
			matrix.changeValue(1, 6, 2);
			matrix.changeValue(0, 7, 2);
			matrix.changeValue(7, 1, 2);
		}else {
			matrix.changeValue(1, 6, 3);
			matrix.changeValue(2, 1, 3);
			matrix.changeValue(7, 1, 3);
		}
	}
	public void tria50(Matrix matrix) {
		if(p1.getActiveTurn()==true) {
			matrix.changeValue(1, 6, 2);
			matrix.changeValue(2, 7, 2);
			matrix.changeValue(7, 1, 2);
		}else {
			matrix.changeValue(1, 6, 3);
			matrix.changeValue(2, 7, 3);
			matrix.changeValue(7, 1, 3);
		}
	}
	public void tria51(Matrix matrix) {
		if(p1.getActiveTurn()==true) {
			matrix.changeValue(1, 8, 2);
			matrix.changeValue(0, 7, 2);
			matrix.changeValue(7, 1, 2);
		}else {
			matrix.changeValue(1, 8, 3);
			matrix.changeValue(0, 7, 3);
			matrix.changeValue(7, 1, 3);
		}
	}
	public void tria52(Matrix matrix) {
		if(p1.getActiveTurn()==true) {
			matrix.changeValue(1, 8, 2);
			matrix.changeValue(0, 7, 2);
			matrix.changeValue(7, 1, 2);
		}else {
			matrix.changeValue(1, 8, 3);
			matrix.changeValue(0, 7, 3);
			matrix.changeValue(7, 1, 3);
		}
	}
	public void tria53(Matrix matrix) {
		if(p1.getActiveTurn()==true) {
			matrix.changeValue(3, 6, 2);
			matrix.changeValue(2, 7, 2);
			matrix.changeValue(7, 3, 2);
		}else {
			matrix.changeValue(3, 6, 3);
			matrix.changeValue(2, 7, 3);
			matrix.changeValue(7, 3, 3);
		}
	}
	public void tria54(Matrix matrix) {
		if(p1.getActiveTurn()==true) {
			matrix.changeValue(3, 6, 2);
			matrix.changeValue(4, 7, 2);
			matrix.changeValue(7, 3, 2);
		}else {
			matrix.changeValue(3, 6, 3);
			matrix.changeValue(4, 7, 3);
			matrix.changeValue(7, 3, 3);
		}
	}
	public void tria55(Matrix matrix) {
		if(p1.getActiveTurn()==true) {
			matrix.changeValue(3, 8, 2);
			matrix.changeValue(2, 7, 2);
			matrix.changeValue(7, 3, 2);
		}else {
			matrix.changeValue(3, 8, 3);
			matrix.changeValue(2, 7, 3);
			matrix.changeValue(7, 3, 3);
		}
	}
	public void tria56(Matrix matrix) {
		if(p1.getActiveTurn()==true) {
			matrix.changeValue(3, 8, 2);
			matrix.changeValue(4, 7, 2);
			matrix.changeValue(7, 3, 2);
		}else {
			matrix.changeValue(3, 8, 3);
			matrix.changeValue(4, 7, 3);
			matrix.changeValue(7, 3, 3);
		}
	}
	public void tria57(Matrix matrix) {
		if(p1.getActiveTurn()==true) {
			matrix.changeValue(5, 6, 2);
			matrix.changeValue(4, 7, 2);
			matrix.changeValue(7, 5, 2);
		}else {
			matrix.changeValue(5, 6, 3);
			matrix.changeValue(4, 7, 3);
			matrix.changeValue(7, 5, 3);
		}
	}
	public void tria58(Matrix matrix) {
		if(p1.getActiveTurn()==true) {
			matrix.changeValue(5, 6, 2);
			matrix.changeValue(6, 7, 2);
			matrix.changeValue(7, 5, 2);
		}else {
			matrix.changeValue(5, 6, 3);
			matrix.changeValue(6, 7, 3);
			matrix.changeValue(7, 5, 3);
		}
	}
	public void tria59(Matrix matrix) {
		if(p1.getActiveTurn()==true) {
			matrix.changeValue(5, 8, 2);
			matrix.changeValue(4, 7, 2);
			matrix.changeValue(7, 5, 2);
		}else {
			matrix.changeValue(5, 8, 3);
			matrix.changeValue(4, 7, 3);
			matrix.changeValue(7, 5, 3);
		}
	}
	public void tria60(Matrix matrix) {
		if(p1.getActiveTurn()==true) {
			matrix.changeValue(5, 8, 2);
			matrix.changeValue(6, 7, 2);
			matrix.changeValue(7, 5, 2);
		}else {
			matrix.changeValue(5, 8, 3);
			matrix.changeValue(6, 7, 3);
			matrix.changeValue(7, 5, 3);
		}
	}
	public void tria61(Matrix matrix) {
		if(p1.getActiveTurn()==true) {
			matrix.changeValue(7, 6, 2);
			matrix.changeValue(6, 7, 2);
			matrix.changeValue(7, 7, 2);
		}else {
			matrix.changeValue(7, 6, 3);
			matrix.changeValue(6, 7, 3);
			matrix.changeValue(7, 7, 3);
		}
	}
	public void tria62(Matrix matrix) {
		if(p1.getActiveTurn()==true) {
			matrix.changeValue(7, 6, 2);
			matrix.changeValue(8, 7, 2);
			matrix.changeValue(7, 7, 2);
		}else {
			matrix.changeValue(7, 6, 3);
			matrix.changeValue(8, 7, 3);
			matrix.changeValue(7, 7, 3);
		}
	}
	public void tria63(Matrix matrix) {
		if(p1.getActiveTurn()==true) {
			matrix.changeValue(7, 8, 2);
			matrix.changeValue(6, 7, 2);
			matrix.changeValue(7, 7, 2);
		}else {
			matrix.changeValue(7, 8, 3);
			matrix.changeValue(6, 7, 3);
			matrix.changeValue(7, 7, 3);
		}
	}
	public void tria64(Matrix matrix) {
		if(p1.getActiveTurn()==true) {
			matrix.changeValue(7, 8, 2);
			matrix.changeValue(8, 7, 2);
			matrix.changeValue(7, 7, 2);
		}else {
			matrix.changeValue(7, 8, 3);
			matrix.changeValue(8, 7, 3);
			matrix.changeValue(7, 7, 3);
		}
	}
}

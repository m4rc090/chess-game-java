package it.livetech.model;

import it.livetech.utils.ChessColor;
import it.livetech.utils.ChessType;

public class Pedone extends Pezzo {
	
	public Pedone(ChessColor color) {
		super(color, ChessType.PEDONE);
	}

	public Pedone() {
		super();
	}

	@Override
	public boolean isValidPath(int initX, int initY, int finalX, int finalY) {
		
		boolean outside = this.checkOutsideBoard(finalX, finalY);
		if(outside) {
			return false;
		}
		
		if(this.getColor() == ChessColor.WHITE && initX == finalX && (initY+1 == finalY || (initY == 1 && initY+2 == finalY))) {
			return true;
		}
		
		if(this.getColor() == ChessColor.BLACK && initX == finalX && (initY-1 == finalY || (initY == 6 && initY-2 == finalY))) {
			return true;
		}
		
		return false;
	}
}

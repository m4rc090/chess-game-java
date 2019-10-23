package it.livetech.model;

import it.livetech.utils.ChessColor;
import it.livetech.utils.ChessType;

public class Torre extends Pezzo {
		
	public Torre(ChessColor color) {
		super(color, ChessType.TORRE);
	}

	public Torre() {
		super();
	}

	@Override
	public boolean isValidPath(int initX, int initY, int finalX, int finalY) {
		boolean outside = this.checkOutsideBoard(finalX, finalY);
		if(outside) {
			return false;
		}
		
		if((initX == finalX && initY != finalY) || (initX != finalX && initY == finalY)) {
			return true;
		}
		return false;
	}
}

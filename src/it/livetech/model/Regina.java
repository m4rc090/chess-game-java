package it.livetech.model;

import it.livetech.utils.ChessColor;
import it.livetech.utils.ChessType;

public class Regina extends Pezzo {
		
	public Regina(ChessColor color) {
		super(color, ChessType.REGINA);
	}

	public Regina() {
		super();
	}

	@Override
	public boolean isValidPath(int initX, int initY, int finalX, int finalY) {
		boolean outside = this.checkOutsideBoard(finalX, finalY);
		if(outside) {
			return false;
		}
		
		//da rivedere il comportamento della Regina
		return true;
	}
}

package it.livetech.model;

import it.livetech.utils.ChessColor;
import it.livetech.utils.ChessType;

public class Re extends Pezzo {
		
	public Re(ChessColor color) {
		super(color, ChessType.RE);
	}

	public Re() {
		super();
	}

	@Override
	public boolean isValidPath(int initX, int initY, int finalX, int finalY) {
		boolean outside = this.checkOutsideBoard(finalX, finalY);
		if(outside) {
			return false;
		}
		
		if((initX+1 == finalX && initY == finalY) || (initX-1 == finalX && initY == finalY)
				|| (initX == finalX && initY+1  == finalY) || (initX == finalX && initY-1 == finalY)) {
			return true;
		}
		
		return false;
	}
}

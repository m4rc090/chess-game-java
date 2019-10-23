package it.livetech.model;

import it.livetech.utils.ChessColor;
import it.livetech.utils.ChessType;

public class Alfiere extends Pezzo {
		
	public Alfiere(ChessColor color) {
		super(color, ChessType.ALFIERE);
	}

	public Alfiere() {
		super();
	}

	@Override
	public boolean isValidPath(int initX, int initY, int finalX, int finalY) {
		boolean outside = this.checkOutsideBoard(finalX, finalY);
		if(outside) {
			return false;
		}
		
		int x_diff = Math.abs(finalX - initX);
		int y_diff = Math.abs(finalY - initY);
		
		return x_diff == y_diff;
	}
}

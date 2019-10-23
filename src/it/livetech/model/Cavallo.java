package it.livetech.model;

import it.livetech.utils.ChessColor;
import it.livetech.utils.ChessType;

public class Cavallo extends Pezzo {

	
	public Cavallo(ChessColor color) {
		super(color, ChessType.CAVALLO);
	}

	public Cavallo() {
		super();
	}

	@Override
	public boolean isValidPath(int initX, int initY, int finalX, int finalY) {
		// TODO Implement behaviour
		return false;
	}

}

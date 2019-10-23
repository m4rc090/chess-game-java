package it.livetech.model;

import it.livetech.utils.ChessColor;
import it.livetech.utils.ChessType;

public abstract class Pezzo {
	
	private ChessColor color;
	private ChessType type;
	
	public Pezzo() {}
	
	public Pezzo(ChessColor color, ChessType type) {

		this.color = color;
		this.type = type;
	}
	
	public abstract boolean isValidPath(int initX, int initY, int finalX, int finalY);

	public ChessColor getColor() {
		return color;
	}

	public void setColor(ChessColor color) {
		this.color = color;
	}
	
	public boolean checkOutsideBoard(int finalX, int finalY) {
		if(0 > finalX || finalX > 7 || 0 > finalY || finalY > 7) {
			return true;
		}
		return false;
	}
	
	public ChessType getType() {
		return type;
	}

	@Override
	public String toString() {
		return "pezzo " + type + " " + color;
	}
	
	
}

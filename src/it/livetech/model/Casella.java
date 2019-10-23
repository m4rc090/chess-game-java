package it.livetech.model;

public class Casella {
	
	private int x;
	private int y;
	private Pezzo pezzo;
	
	public Casella(int x, int y, Pezzo pezzo) {
		this.x = x;
		this.y = y;
		this.pezzo = pezzo;
	}

	public boolean hasPezzo() {
		return this.pezzo == null;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Pezzo getPezzo() {
		return pezzo;
	}

	public void setPezzo(Pezzo pezzo) {
		this.pezzo = pezzo;
	}
}

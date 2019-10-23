package it.livetech.model;

import it.livetech.utils.ChessColor;
import it.livetech.utils.ChessType;

public class Scacchiera {
	
	private Casella[][] board;

	public Scacchiera() {
		
		this.board = new Casella[8][8];
		
		/* Configurazione dei pezzi */
		
		/* Pezzi neri */
		this.board[0][0] = new Casella(0, 0, new Torre(ChessColor.WHITE));
		this.board[1][0] = new Casella(1, 0, new Cavallo(ChessColor.WHITE));
		this.board[2][0] = new Casella(2, 0, new Alfiere(ChessColor.WHITE));
		this.board[3][0] = new Casella(3, 0, new Re(ChessColor.WHITE));
		this.board[4][0] = new Casella(4, 0, new Regina(ChessColor.WHITE));
		this.board[5][0] = new Casella(5, 0, new Alfiere(ChessColor.WHITE));
		this.board[6][0] = new Casella(6, 0, new Cavallo(ChessColor.WHITE));
		this.board[7][0] = new Casella(7, 0, new Torre(ChessColor.WHITE));
		
		/* Pedoni neri */
		for(int i = 0; i < 8; i++) {
			this.board[i][1] = new Casella(i, 1, new Pedone(ChessColor.WHITE));
		}
		
		/* Pezzi bianchi */
		this.board[0][7] = new Casella(0, 7, new Torre(ChessColor.BLACK));
		this.board[1][7] = new Casella(1, 7, new Cavallo(ChessColor.BLACK));
		this.board[2][7] = new Casella(2, 7, new Alfiere(ChessColor.BLACK));
		this.board[3][7] = new Casella(3, 7, new Re(ChessColor.BLACK));
		this.board[4][7] = new Casella(4, 7, new Regina(ChessColor.BLACK));
		this.board[5][7] = new Casella(5, 7, new Alfiere(ChessColor.BLACK));
		this.board[6][7] = new Casella(6, 7, new Cavallo(ChessColor.BLACK));
		this.board[7][7] = new Casella(7, 7, new Torre(ChessColor.BLACK));
		
		/* Pedoni bianchi */
		for(int i = 0; i < 8; i++) {
			this.board[i][6] = new Casella(i, 6, new Pedone(ChessColor.BLACK));
		}
		
		/* Restanti caselle */
		for(int i = 2; i < 6; i++) {
			for(int j = 0; j < 8; j++) {
				this.board[j][i] = new Casella(j, i, null);
			}
		}
	}

	public String mostra() {
		Casella casella = null;
		Pezzo pezzo = null;
		ChessType type = null;
		ChessColor color = null;
		String st = "------------------------------------\n";
		for(int i = 7; i >= 0; i--) {
			st += i + " |";
			for(int j = 0; j < 8; j++) {
				
				casella = this.board[j][i];
				pezzo = casella.getPezzo();
				
				if(pezzo != null) {
					type = pezzo.getType();
					color = pezzo.getColor();
					String st_color = "";
					if(color == ChessColor.BLACK) {
						st_color = "B";
					} else {
						st_color = "W";
					}
					
					if(type == ChessType.TORRE) {	
						st += " " + "T" + st_color + " ";
					} else if (type == ChessType.CAVALLO) {
						st += " " + "C" + st_color + " ";
					} else if (type == ChessType.ALFIERE) {
						st += " " + "A" + st_color + " ";
					} else if (type == ChessType.RE) {
						st += " " + "K" + st_color + " ";
					} else if (type == ChessType.REGINA) {
						st += " " + "Q" + st_color + " ";
					} else {
						st += " " + "P" + st_color + " ";
					}

					
				} else {
					st += " __ ";
				}						
			}
			st += "|\n";
		}
		
		st += "    0   1   2   3   4   5   6   7    \n";
		st += "------------------------------------";
		
		return st;
	}
	
	public Pezzo getPezzo(int x, int y) throws Exception {
		
		if ((0 <= x && x <= 7) && (0 <= y && y <= 7)){ 
				return this.board[x][y].getPezzo();
		} else {
			throw new Exception("Coordinate fuori dalla scacchiera");
		}
	}
	
	public void setPezzo(int x, int y, Pezzo pezzo) throws Exception {
		this.board[x][y].setPezzo(pezzo);
	}
	
	public int countPezziByColor(ChessColor color) {
		int count = 0;
		Pezzo p = null;
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				p = this.board[i][j].getPezzo();
				if(p != null && p.getColor() == color) {
					count ++;
				}
			}
		}
		return count;
	}
}

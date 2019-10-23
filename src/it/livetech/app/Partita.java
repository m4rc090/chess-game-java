package it.livetech.app;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import it.livetech.model.Pezzo;
import it.livetech.model.Scacchiera;
import it.livetech.utils.ChessColor;

public class Partita {

	public static void main(String[] args) {
		
		BufferedReader br = null;
		
		/* Creo le stringhe fine partita*/
		String vittoriaBlack = "Partita finita! Vince il " + ChessColor.BLACK.toString();
		String vittoriaWhite = "Partita finita! Vince il " + ChessColor.WHITE.toString();
		String finePartitaPari = "Partita finita! E' pari";
		
		/* Creo la scacchiera */
		Scacchiera scacchiera = new Scacchiera();
		System.out.println(scacchiera.mostra());
		
		/* Inizializzo il nuemro di mosse massimo che voglio fare*/
		int mossa_attuale = 1;
		int max_mosse = 50;
		
		String input = null;
		ChessColor player = null;
		
		/* Itero sul numero di mosse */
		while(mossa_attuale <= max_mosse) {
			
			if (mossa_attuale % 2 == 0) {
				player = ChessColor.BLACK;
			} else {
				player = ChessColor.WHITE;
			}
			
			br = new BufferedReader(new InputStreamReader(System.in));

			System.out.println(player.toString() + " Tocca a te! Fai una mossa (<nome_pezzo>, <init_x>, <init_y>, <final_x>, <final_y>): ");
            try {
            	/* Faccio il parse del comando inserito */
				input = br.readLine();
            
	            String[] tokens = input.split(",");
	            
	            String nome_pezzo = tokens[0];
	            nome_pezzo = nome_pezzo.toUpperCase();
	            int init_x = Integer.parseInt(tokens[1].trim());
	            int init_y = Integer.parseInt(tokens[2].trim());
	            int final_x = Integer.parseInt(tokens[3].trim());
	            int final_y = Integer.parseInt(tokens[4].trim());
	            
	            /* Prendo il pezzo e lo muovo */
	            Pezzo pezzoDaMuovere = scacchiera.getPezzo(init_x, init_y);
	            
	            if(pezzoDaMuovere == null) {
	            	System.out.println("Coordinate init errate, inserisci un nuovo comando");
	            	System.out.println(scacchiera.mostra());
	            	continue;
	            } else {
	            	System.out.println(pezzoDaMuovere.toString());
	            	if(pezzoDaMuovere.isValidPath(init_x, init_y, final_x, final_y)) {
	            		
	            		/* Controllo se sulla casella target c'è già un pezzo */
	            		Pezzo pezzoTarget = scacchiera.getPezzo(final_x, final_y);
	            		if (pezzoTarget == null) {
	            			/* Nella casella target non c'è nulla, quindi posso muovere */
	            			scacchiera.setPezzo(init_x, init_y, null);
	            			scacchiera.setPezzo(final_x, final_y, pezzoDaMuovere);
	            			System.out.println(scacchiera.mostra());
	            		} else {
	            			/* Nella casella target c'è un pezzo, controllo il colore */
	            			if(pezzoTarget.getColor() == player) {
	            				System.out.println("Mossa non valida! Nella casella di arrivo c'è già un tuo pezzo! Fai un'altra mossa");
	            				continue;
	            			} else {
	            				scacchiera.setPezzo(init_x, init_y, null);
		            			scacchiera.setPezzo(final_x, final_y, pezzoDaMuovere);
		            			System.out.println("Il " + pezzoDaMuovere.toString() + " mangia il " + pezzoTarget.toString());
	            			}
	            		}
	            	} else {
	            		System.out.println("Mossa non valida!");
		            	System.out.println(scacchiera.mostra());
		            	continue;
	            	}
	            }
			} catch (Exception e) {
            	System.out.println("Input errato, inserisci un nuovo comando");
            	System.out.println(e.getMessage());
            	System.out.println(scacchiera.mostra());
            	continue;
			}
            
            /* Controllo  il numero di pezzi rimasti */
            if(scacchiera.countPezziByColor(ChessColor.BLACK) == 0) {
            	System.out.println(vittoriaWhite);
            } else if (scacchiera.countPezziByColor(ChessColor.WHITE) == 0) {
            	System.out.println(vittoriaBlack);
			}
            
			/* Decremento il numero di mosse */
            mossa_attuale++;
		}
		
		System.out.println(finePartitaPari);
	}
}

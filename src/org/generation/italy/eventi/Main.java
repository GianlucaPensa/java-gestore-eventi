package org.generation.italy.eventi;

import java.util.Scanner;
import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {
		int postiPrenotati = 0;
		char decisione = 's';
		
		System.out.println("Inserisci giorno : ");
		Scanner scan = new Scanner(System.in);
		String dayInput = scan.nextLine();
		int giorno = Integer.parseInt(dayInput);
		System.out.println("Inserisci mese : ");
		String monthInput = scan.nextLine();
		int mese = Integer.parseInt(monthInput);
		System.out.println("Inserisci anno : ");
		String yearInput = scan.nextLine();
		int anno = Integer.parseInt(yearInput);
		LocalDate data = LocalDate.of(anno, mese, giorno);
		System.out.println("Inserisci titolo evento : ");
		String titolo = scan.nextLine();
		System.out.println("Inserisci numero posti totali : ");
		int postiTotali = scan.nextInt();
				
		Evento evento = new Evento(titolo, data, postiTotali, postiPrenotati);
		
		try {
			evento.isValidData();
		}catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
		}
		try {
			evento.isValidPosti();
		}catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
			System.exit(1);
		}
		
		System.out.println("Vuoi effettuare prenotazioni? (s/n) ");
		decisione = scan.next().charAt(0);
		
		if(decisione == 's') {
			int prenotazioniDesiderate = 0;
			System.out.println("Quante prenotazioni vuoi fare?");
			prenotazioniDesiderate = scan.nextInt();
			for(int i = prenotazioniDesiderate; i>0; i--) {
				evento.prenota();
				postiPrenotati++;
			}
			System.out.println(postiTotali);
			postiTotali = postiTotali - postiPrenotati;
			System.out.println("Meno le prenotazioni : " + postiTotali);
		}
		
		System.out.println("Vuoi disdire qualche prenotazione? (s/n)");
		decisione = scan.next().charAt(0);
		
		if(decisione == 's') {
			int disdetteDesiderate = 0;
			System.out.println("Quante prenotazioni vuoi disdire?");
			disdetteDesiderate = scan.nextInt();
			for(int i = disdetteDesiderate; i>0; i--) {
				evento.disdici();
				postiPrenotati--;
			}
			System.out.println(postiTotali);
			postiTotali = postiTotali + postiPrenotati;
			System.out.println("Dopo le disdette : " + postiTotali);
		}
		
		scan.close();
	}

}

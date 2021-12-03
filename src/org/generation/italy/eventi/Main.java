package org.generation.italy.eventi;

import java.util.Scanner;
import java.time.LocalDate;

public class Main {

	public static void main(String[] args) {
		int prenotazioni = 0;
		int disdette = 0;
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
		LocalDate ld = LocalDate.of(giorno, mese, anno);
		System.out.println("Inserisci titolo evento : ");
		String titolo = scan.nextLine();
		System.out.println("Inserisci numero posti totali : ");
		int pTotali = scan.nextInt();
				
		Evento evento = new Evento(titolo, ld, pTotali);
		
		try {
			evento.isValidData();
		}catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
		}
		try {
			evento.isValidPosti();
		}catch (Exception e) {
			System.out.println("Error : " + e.getMessage());
		}
		
		System.out.println("Vuoi effettuare prenotazioni? (s/n) ");
		decisione = scan.next().charAt(0);
		
		if(decisione == 's') {
			int prenotazioniDesiderate = 0;
			System.out.println("Quante prenotazioni vuoi fare?");
			prenotazioniDesiderate = scan.nextInt();
			for(int i = prenotazioniDesiderate; i>=0; i--) {
				evento.prenota();
			}
		}
		
		System.out.println(pTotali);
		System.out.println(pTotali - prenotazioni);
		
		System.out.println("Vuoi disdire qualche prenotazione?");
		decisione = scan.next().charAt(0);
		
		if(decisione == 's') {
			int disdetteDesiderate = 0;
			System.out.println("Quante prenotazioni vuoi disdire?");
			disdetteDesiderate = scan.nextInt();
			for(int i = disdetteDesiderate; i>=0; i--) {
				evento.disdici();
			}
		}
		
		scan.close();
		
		System.out.println(pTotali);
		System.out.println(pTotali - disdette);

		
		
	}

}

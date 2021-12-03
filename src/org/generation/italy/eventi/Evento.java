package org.generation.italy.eventi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {
		private String titolo;
		private final LocalDate date = LocalDate.now();
		private LocalDate data;
		private int postiTotali;
		private int postiPrenotati = 0;
		
		public Evento(String titolo, LocalDate data, int postiTotali) {
			this.titolo = titolo;
			this.data = data;
			this.postiTotali = postiTotali;
		}

		public String getTitolo() {
			return titolo;
		}

		public void setTitolo(String titolo) {
			this.titolo = titolo;
		}

		public LocalDate getData() {
			return data;
		}

		public void setData(LocalDate data) {
			this.data = data;
		}

		public int getPostiTotali() {
			return postiTotali;
		}

		public int getPostiPrenotati() {
			return postiPrenotati;
		}
		
		public String dataFormattata(){
			String dataFormattata;
			DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			dataFormattata = this.data.format(df);
			return dataFormattata;
		}
		
		public boolean isValidData() throws Exception{
			if(data.isBefore(date)) {
				throw new Exception("Input a valid date");
			}
			return true;
		}
		
		public boolean isValidPosti() throws Exception{
			if (postiTotali<= 0) {
				throw new Exception("Input a number above 0");
			}
			return true;
		}
		
		private boolean isValidPrenotazione() throws Exception{
			if (postiPrenotati + 1 > postiTotali) {
				throw new Exception("Non ci sono più posti disponibili");
			}
			return true;
		}
		
		private boolean isValidDisdicere() throws Exception{
			if (postiPrenotati == 0) {
				throw new Exception("Non ci sono posti prenotati");
			}
			return true;
		}
		public int prenota() {
			try {
			isValidData();
			}
			catch(Exception e){
				System.out.println("Impossibile effetuare prenotazione: ");
				System.out.println(e.getMessage());
			}
			try {
				isValidPrenotazione();
				}
				catch(Exception e){
					System.out.println("Impossibile effetuare prenotazione: ");
					System.out.println(e.getMessage());
				}
			return postiPrenotati =+1;
		}
		
		public int disdici() {
			try {
			isValidData();
			}
			catch(Exception e){
				System.out.println("Impossibile disdicere: ");
				System.out.println(e.getMessage());
			}
			try {
			isValidDisdicere();
			}
			catch(Exception e){
				System.out.println("Impossibile disdicere: ");
				System.out.println(e.getMessage());
			}
				return postiPrenotati =-1;
		}
		
		@Override
		public String toString() {
			return dataFormattata() + "-" + titolo;
		}
}

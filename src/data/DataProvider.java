package data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import kalender.main.Veranstaltung;
import notenuebersicht.Modul;
import startseite.Tile;

public class DataProvider {
	private static List<Modul> semester1;
	private static List<Modul> semester2;

	private static List<Modul> semester3;
	private static List<Modul> semester4;

	private static List<Modul> semester5;
	private static List<Modul> semester6;

	public DataProvider() {
		semester1 = new ArrayList();

		for (double i = 0; i < 4; i++) {
			Modul modul = new Modul();

			modul.setNote(1.0 + (i / 16));
			modul.setVeranstaltungen(this.getNewVeranstaltungen());

			semester1.add(modul);
		}

		semester2 = new ArrayList();

		for (double i = 0; i < 4; i++) {
			Modul modul = new Modul();

			modul.setNote(1.0 + (i / 13));
			modul.setVeranstaltungen(this.getNewVeranstaltungen());

			semester2.add(modul);
		}

		semester3 = new ArrayList();

		for (double i = 0; i < 4; i++) {
			Modul modul = new Modul();

			modul.setNote(1.0 + (i / 5));
			modul.setVeranstaltungen(this.getNewVeranstaltungen());

			semester3.add(modul);
		}

		semester4 = new ArrayList();

		for (double i = 0; i < 4; i++) {
			Modul modul = new Modul();

			modul.setNote(1.0 + (i / 5));
			modul.setVeranstaltungen(this.getNewVeranstaltungen());

			semester4.add(modul);
		}

		semester5 = new ArrayList();

		for (double i = 0; i < 4; i++) {
			Modul modul = new Modul();

			modul.setNote(1.0 + (i / 7));
			modul.setVeranstaltungen(this.getNewVeranstaltungen());

			semester5.add(modul);
		}

		semester6 = new ArrayList();

		for (double i = 0; i < 4; i++) {
			Modul modul = new Modul();

			modul.setNote(1.0 + (i / 7));
			modul.setVeranstaltungen(this.getNewVeranstaltungen());

			semester6.add(modul);
		}
	}

	private List<Veranstaltung> getNewVeranstaltungen() {
		List<Veranstaltung> veranstaltungen = new ArrayList();

		veranstaltungen.add(new Veranstaltung(null, "Statistik", 0, "Meyer"));
		veranstaltungen.add(new Veranstaltung(null, "Wirtschaftsinformatik", 0, "M�ller"));
		veranstaltungen.add(new Veranstaltung(null, "Datenbankentwurf", 0, "Maier"));

		return veranstaltungen;
	}

	public List<String> getSemesterTexte() {
		List<String> semesterTexte = new ArrayList();

		semesterTexte.add("Semester 1 & 2");
		semesterTexte.add("Semester 3 & 4");
		semesterTexte.add("Semester 5 & 6");

		return semesterTexte;
	}

	public List<Double> getSemesterNoten() {
		List<Double> noten = new ArrayList();
		
		// Schnitt berechnen von dem Jahr
		// Schnitt auf zwei Nachkommastellen abschneiden
		// Schnitt den Jahresnoten hinzuf�gen
		double jahr1note = this.calculateNotenschnitt(semester1, semester2);
		jahr1note = Math.floor(jahr1note * 100) / 100;
		noten.add(jahr1note);

		// Schnitt berechnen von dem Jahr
		// Schnitt auf zwei Nachkommastellen abschneiden
		// Schnitt den Jahresnoten hinzuf�gen
		double jahr2note = this.calculateNotenschnitt(semester3 , semester4);
		jahr2note = Math.floor(jahr2note * 100) / 100;
		noten.add(jahr2note);

		// Schnitt berechnen von dem Jahr
		// Schnitt auf zwei Nachkommastellen abschneiden
		// Schnitt den Jahresnoten hinzuf�gen
		double jahr3note = this.calculateNotenschnitt(semester5, semester6);
		jahr3note = Math.floor(jahr3note * 100) / 100;
		noten.add(jahr3note);

		return noten;
	}

	private double calculateNotenschnitt(List<Modul> semesterA, List<Modul> semesterB) {
		double notensumme = 0;
		int anzahldernoten = 0;

		for (Modul modul : semesterA) {
			notensumme += modul.getNote();
			anzahldernoten++;
		}

		for (Modul modul : semesterB) {
			notensumme += modul.getNote();
			anzahldernoten++;
		}

		double schnitt = notensumme / anzahldernoten;

		return schnitt;
	}

	private static Collection<Tile> getNews() {
		Collection<Tile> news = new ArrayList<Tile>();
		news.add(new Tile("Heute:", "Die Vorlesung Rechnungslegung f�llt morgen aus!"));
		news.add(new Tile("18.02", "Die Vorlesung Verteilte Systeme f�llt am 19.2 aus!"));
		news.add(new Tile("02.02", "Die Abgabefirst f�r die UI-DOku ist der 05.04!"));
		news.add(new Tile("28.01", "Die Vorlesung Datenbanken wird um 1h auf 15 Uhr verschoben!"));
		return news;
	}

	private static Collection<Tile> getTiles() {
		Collection<Tile> tiles = new ArrayList<Tile>();
		tiles.add(new Tile("Noten�bersicht", "Neuste Note: 1,3 in Statistik"));
		tiles.add(new Tile("Stundenplan", "N�chste Vorlesung: UI in 2h 34min"));
		return tiles;
	}

}

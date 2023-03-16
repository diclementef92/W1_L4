package esercizi;

public class Dipendente {
	private Long matricola;
	private double stipendio;
	private double importoOrarioStraordinario; // importo per ogni ora di straordinario
	private Livello livello;
	private Dipartimento dipartimento;
	private static final double stipendioBase = 1000;

	public Dipendente(Long matr, Dipartimento dipartimento) {
		this.matricola = matr;
		this.dipartimento = dipartimento;
		this.stipendio = stipendioBase;
		this.importoOrarioStraordinario = 10;
		this.livello = Livello.OPERAIO;
	}

	public Dipendente(Long matr, double stipendio, double importoOrarioStraordinario, Livello livello,
			Dipartimento dipartimento) {
		// this(matr, dipartimento);// no perchè setterei due volte alcune variabili
		this.matricola = matr;
		this.stipendio = stipendio;
		this.importoOrarioStraordinario = importoOrarioStraordinario;
		this.livello = livello;
		this.dipartimento = dipartimento;
	}

	public Long getMatricola() {
		return matricola;
	}

	public double getStipendio() {
		return stipendio;
	}
	public double getImportoOrarioStraordinario() {
		return importoOrarioStraordinario;
	}

	public Livello getLivello() {
		return livello;
	}

	public Dipartimento getDipartimento() {
		return dipartimento;
	}
	public static double getStipendioBase() {
		return stipendioBase;
	}

	private void setLivello(Livello liv) {
		this.livello = liv;
	}

	private void setStipendio(double stipendio) {
		this.stipendio = stipendio;
	}

	public void setDipartimento(Dipartimento dipartimento) {
		this.dipartimento = dipartimento;
	}


	public void setImportoOrarioStraordinario(double importoOrarioStraordinario) {
		this.importoOrarioStraordinario = importoOrarioStraordinario;
	}

	public Livello promuovi() {
		switch (this.getLivello()) {
		case OPERAIO: {
			setLivello(Livello.IMPIEGATO);
			setStipendio(getStipendioBase() * 1.2);
		}
		case IMPIEGATO: {
			setLivello(Livello.QUADRO);
			setStipendio(getStipendioBase() * 1.5);
		}
		case QUADRO: {
			setLivello(Livello.DIRIGENTE);
			setStipendio(getStipendioBase() * 2);

		}
		case DIRIGENTE: {
			System.out.println("Errore: impossibile promuovere un dirigente");
		}
		default:
			System.out.println(
					"Errore in classe Dipendente, metodo promuovi, livello dipendente non trovato" + this.getLivello());
		}
		return getLivello();
	}

	public double calcolaPaga() {
		return getStipendio();
	}

	public double calcolaPaga(int oreStraordinario) {
		return getStipendio() + (oreStraordinario * getImportoOrarioStraordinario());
	}
	public String toString () {
		String text = "Dipendete:\nMatricola N°:" + getMatricola() + "\nDiaprtimento: " + getDipartimento()
				+ "Livello: " + getLivello() + "\nStipendio: " + getStipendio() + "\nOrarioStraordiario: "
				+ getImportoOrarioStraordinario();
		return text;
	}
	public void stampaDatiDipendente() {
		System.out.println(this.toString());
	}
}

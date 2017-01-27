package cliente;

public class Cliente {
	
	private String nome;
	private String cognome;
	private String sesso;
	private int eta;
	
	public Cliente(String nome, String cognome, String sesso, int eta) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.sesso = sesso;
		this.eta = eta;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public String getSesso() {
		return sesso;
	}

	public int getEta() {
		return eta;
	};

}

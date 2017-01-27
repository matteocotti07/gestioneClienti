package visita;

import java.util.Date;

import cliente.Cliente;

public class Visita {
	
	private Cliente cliente;
	private int altezza;
	private float peso;
	private int braccio;
	private int torace;
	private int ombelico;
	private int coscia;
	private int plica1;
	private int plica2;
	private int plica3;
	private int nVisita;
	private Date dataVisita;
	
	public Visita(Cliente cliente, int altezza, float peso, int braccio, int torace, int ombelico, int coscia,
			int plica1, int plica2, int plica3, int nVisita, Date dataVisita) {
		super();
		this.cliente = cliente;
		this.altezza = altezza;
		this.peso = peso;
		this.braccio = braccio;
		this.torace = torace;
		this.ombelico = ombelico;
		this.coscia = coscia;
		this.plica1 = plica1;
		this.plica2 = plica2;
		this.plica3 = plica3;
		this.nVisita = nVisita;
		this.dataVisita = dataVisita;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public int getAltezza() {
		return altezza;
	}

	public float getPeso() {
		return peso;
	}

	public int getBraccio() {
		return braccio;
	}

	public int getTorace() {
		return torace;
	}

	public int getOmbelico() {
		return ombelico;
	}

	public int getCoscia() {
		return coscia;
	}

	public int getPlica1() {
		return plica1;
	}

	public int getPlica2() {
		return plica2;
	}

	public int getPlica3() {
		return plica3;
	}

	public int getnVisita() {
		return nVisita;
	}

	public Date getDataVisita() {
		return dataVisita;
	}

}

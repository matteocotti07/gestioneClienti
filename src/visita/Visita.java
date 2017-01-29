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
        private float grasso;
	private int nVisita;
	private String dataVisita;
	
	public Visita(Cliente cliente, int altezza, float peso, int braccio, int torace, int ombelico, int coscia,
			int plica1, int plica2, int plica3, float grasso, int nVisita, String dataVisita) {
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
                this.grasso = grasso;
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
        
        public float getGrasso() {
		return grasso;
	}

	public int getnVisita() {
		return nVisita;
	}

	public String getDataVisita() {
		return dataVisita;
	}
        
        public float getGrassoKg() {
		return (peso*grasso)/100;
	}

        public float getBMI() {
                float h = (float) altezza/100;
		return (peso/(h*h));
	}
        
        public float getMagra() {
		return peso-getGrassoKg();
	}
        
        public float getMetabolismo() {
            float metabolismo = 0;
            if (cliente.getSesso().equalsIgnoreCase("M")) {
                metabolismo = (float) (66.4730 + (13.7156 * peso) + (5.033 * altezza) - (6.775 * cliente.getEta()));
            }
            else{
                metabolismo = (float) (65.5095 + (9.5634 * peso) + (1.849 * altezza) - (4.6756 * cliente.getEta()));
            }
		return metabolismo;
	}
        
}

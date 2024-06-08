package krakedev.entidades;

public class Pronostico {
	 private int codigoPro;
	 private Usuario cedulaUser;
	 private Partidos codigoPartido;
	 private Paises codigoEquipo1;
	 private Paises codigoEquipo2;
	 private int marcadorEquipo1;
	 private int marcadorEquipo2;
	 
	public Pronostico() {
		
	}
	 
	public Pronostico(int codigoPro, Usuario cedulaUser, Partidos codigoPartido, Paises codigoEquipo1,
			Paises codigoEquipo2, int marcadorEquipo1, int marcadorEquipo2) {
		super();
		this.codigoPro = codigoPro;
		this.cedulaUser = cedulaUser;
		this.codigoPartido = codigoPartido;
		this.codigoEquipo1 = codigoEquipo1;
		this.codigoEquipo2 = codigoEquipo2;
		this.marcadorEquipo1 = marcadorEquipo1;
		this.marcadorEquipo2 = marcadorEquipo2;
	}
	public int getCodigoPro() {
		return codigoPro;
	}
	public void setCodigoPro(int codigoPro) {
		this.codigoPro = codigoPro;
	}
	public Usuario getCedulaUser() {
		return cedulaUser;
	}
	public void setCedulaUser(Usuario cedulaUser) {
		this.cedulaUser = cedulaUser;
	}
	public Partidos getCodigoPartido() {
		return codigoPartido;
	}
	public void setCodigoPartido(Partidos codigoPartido) {
		this.codigoPartido = codigoPartido;
	}
	public Paises getCodigoEquipo1() {
		return codigoEquipo1;
	}
	public void setCodigoEquipo1(Paises codigoEquipo1) {
		this.codigoEquipo1 = codigoEquipo1;
	}
	public Paises getCodigoEquipo2() {
		return codigoEquipo2;
	}
	public void setCodigoEquipo2(Paises codigoEquipo2) {
		this.codigoEquipo2 = codigoEquipo2;
	}
	public int getMarcadorEquipo1() {
		return marcadorEquipo1;
	}
	public void setMarcadorEquipo1(int marcadorEquipo1) {
		this.marcadorEquipo1 = marcadorEquipo1;
	}
	public int getMarcadorEquipo2() {
		return marcadorEquipo2;
	}
	public void setMarcadorEquipo2(int marcadorEquipo2) {
		this.marcadorEquipo2 = marcadorEquipo2;
	}

	
	 
	 
}

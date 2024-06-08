package krakedev.entidades;

import java.sql.Date;
import java.sql.Time;

public class Partidos {
	private int codigo;
	private Paises equipo1 ;
	private Paises equipo2;
	private Date fecha;
	private Time hora;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Paises getEquipo1() {
		return equipo1;
	}
	public void setEquipo1(Paises equipo1) {
		this.equipo1 = equipo1;
	}
	public Paises getEquipo2() {
		return equipo2;
	}
	public void setEquipo2(Paises equipo2) {
		this.equipo2 = equipo2;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Time getHora() {
		return hora;
	}
	public void setHora(Time hora) {
		this.hora = hora;
	}
	public Partidos(int codigo, Paises equipo1, Paises equipo2, Date fecha, Time hora) {
		super();
		this.codigo = codigo;
		this.equipo1 = equipo1;
		this.equipo2 = equipo2;
		this.fecha = fecha;
		this.hora = hora;
	}
	public Partidos() {
		super();
	}
	@Override
	public String toString() {
		return "Partidos [codigo=" + codigo + ", equipo1=" + equipo1 + ", equipo2=" + equipo2 + ", fecha=" + fecha
				+ ", hora=" + hora + "]";
	}
	public Partidos(int codigo) {
		super();
		this.codigo = codigo;
	}
	
	
	
}

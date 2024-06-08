package krakedev.entidades;

public class Paises {
	private int codigo;
	private String nombre;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Paises(int codigo, String nombre) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
	}
	public Paises() {
		super();
	}
	@Override
	public String toString() {
		return "Paises [codigo=" + codigo + ", nombre=" + nombre + "]";
	}
	public Paises(int codigo) {
		super();
		this.codigo = codigo;
	}
	
	
	
}

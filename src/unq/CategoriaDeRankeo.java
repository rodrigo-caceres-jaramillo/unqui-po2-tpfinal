package unq;

public abstract class CategoriaDeRankeo {
	private String nombre;

	public CategoriaDeRankeo(String nombre) {
		super();
		this.nombre = nombre;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}

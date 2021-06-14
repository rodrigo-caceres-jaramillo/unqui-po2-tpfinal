package unq;

public  class CategoriaDePuntaje {

	private String nombre;

	public CategoriaDePuntaje(String nombre) {
		this.setNombre(nombre);
	}

	private void setNombre(String nombre) {
			this.nombre = nombre;
	}

	public String getNombre() {

		return (this.nombre);
	}

	

}

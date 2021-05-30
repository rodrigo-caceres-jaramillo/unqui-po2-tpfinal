package unq;

public class Propietario extends Usuario{
	public Propietario(String nombre, String mail, int telefono) {
		super(nombre, mail, telefono);
	}

	public void publicarInmueble(Inmueble inmueble) {
		this.getSitioWeb().registrarInmueble(this, inmueble);
	}
	
}

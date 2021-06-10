package unq;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Propietario extends Usuario {

	private List<Publicacion> publicaciones = new ArrayList<Publicacion>();
	private Publicacion publicacion;

	public Propietario(String nombre, String mail, int telefono) {
		super(nombre, mail, telefono);
	}

	public List<Publicacion> getPublicaciones() {
		return publicaciones;
	}

	public void setPublicaciones(List<Publicacion> publicaciones) {
		this.publicaciones = publicaciones;
	}

	public Publicacion getPublicacion() {
		return publicacion;
	}

	public void setPublicacion(Publicacion publicacion) {
		this.publicacion = publicacion;
	}

	public void publicarInmueble(Inmueble inmueble) {
		this.getSitioWeb().registrarInmueble(this, inmueble);
	}

	public void añadirPublicacion(Publicacion publicacion) {

		publicaciones.add(publicacion);
		// publicarInmueble(publicacion.getInmueble());

	}

}

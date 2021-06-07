package unq;

import java.time.LocalDate;
import java.util.ArrayList;

public class Propietario extends Usuario {

	private ArrayList<Publicacion> publicaciones = new ArrayList<Publicacion>();

	public ArrayList<Publicacion> getPublicaciones() {
		return publicaciones;
	}

	public void setPublicaciones(ArrayList<Publicacion> publicaciones) {
		this.publicaciones = publicaciones;
	}

	public Propietario(String nombre, String mail, int telefono) {
		super(nombre, mail, telefono);
	}

	public void publicarInmueble(Inmueble inmueble) {
		this.getSitioWeb().registrarInmueble(this, inmueble);
	}

	public void añadirPublicacion(Publicacion publicacion) {

		publicaciones.add(publicacion);
		publicarInmueble(publicacion.getInmueble());

	}

}

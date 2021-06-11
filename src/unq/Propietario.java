package unq;

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

			this.getSitioWeb().añadirNuevaPublicacion(publicacion);
	}

	public List<Publicacion> publicacionesEnElSitio() {

		return (this.getSitioWeb().getPublicacionesDe(this));
	}

	public void medioDePagoPara(Publicacion publicacion, FormasDePagoEnum formaDePago) {
			publicacion.addMedioDePago(formaDePago);	
			
	}

	public boolean algunaPublicacionConPago(FormasDePagoEnum formaDePago) {
					
		return (getSitioWeb().registraPubliDeUsuarioConFormaDePago(this, formaDePago ) );
	}

	public void bajarPrecioAPublicacionCon(Publicacion publi, double precio) {
		this.getSitioWeb().actualizarPrecioDePublicacion(publi, precio);
	}

}






















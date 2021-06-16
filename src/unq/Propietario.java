package unq;

import java.util.List;

public class Propietario extends Usuario {

	public Propietario(String nombre, String mail, Integer telefono) {
		super(nombre, mail, telefono);
	}

//	public void publicarInmueble(Inmueble inmueble) {
//		this.getSitioWeb().registrarInmueble(this, inmueble);
//	}

	public List<Publicacion> publicacionesEnElSitio(SitioWeb sitio) {

		return sitio.getPublicacionesDe(this);
	}

	public void medioDePagoPara(Publicacion publicacion, FormasDePagoEnum formaDePago) {
		publicacion.addMedioDePago(formaDePago);

	}

	public void bajarPrecioAPublicacionEnSitio(Publicacion publi, Double precio, SitioWeb sitio) {
		sitio.actualizarPrecioDePublicacion(publi, precio);
	}

	public void agregarPublicacion(Publicacion publicacion, SitioWeb sitio) {
		sitio.addPublicacion(publicacion);
	}

}

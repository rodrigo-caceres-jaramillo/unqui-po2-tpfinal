package unq;

import java.util.List;

public class Propietario extends Usuario {

	public Propietario(String nombre, String mail, Integer telefono) {
		super(nombre, mail, telefono);
	}

	public void publicarInmueble(Inmueble inmueble) {
		this.getSitioWeb().registrarInmueble(this, inmueble);
	}

	public List<Publicacion> publicacionesEnElSitio() {

		return (this.getSitioWeb().getPublicacionesDe(this));
	}

	public void medioDePagoPara(Publicacion publicacion, FormasDePagoEnum formaDePago) {
		publicacion.addMedioDePago(formaDePago);

	}

	public boolean algunaPublicacionConPago(FormasDePagoEnum formaDePago) {

		return (getSitioWeb().registraPubliDeUsuarioConFormaDePago(this, formaDePago));
	}

	public void bajarPrecioAPublicacionCon(Publicacion publi, Double precio) {
		this.getSitioWeb().actualizarPrecioDePublicacion(publi, precio);
	}

}

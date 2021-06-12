package unq;

import java.util.ArrayList;
import java.util.List;

public class AdministradorApp {

	private List<Publicacion> publicaciones;

	public List<Publicacion> getPublicaciones() {
		return publicaciones;
	}

	public void setPublicaciones(List<Publicacion> publicaciones) {
		this.publicaciones = publicaciones;
	}

	public void publicar(Publicacion publicacion) {
		if (getPublicaciones().isEmpty()) {
			publicaciones = new ArrayList<Publicacion>();
			publicaciones.add(publicacion);
			//Se podría publicar las publicaciones al sitio web
		}
	}

	// Lógica para filtrar la búsqueda de publicaciones de acuerdo a lo que el
	// usuario ingrese,
	// aunque lo podemos modificar para que se haga en algun Objeto Buscador

	public List<Publicacion> buscar(ParametrosBusqueda parametrosBusqueda) {
		List<Publicacion> publicacionesEncontradas = new ArrayList<Publicacion>();
		for (Publicacion publicacion : getPublicaciones()) {
			if (esPublicacionComparador(parametrosBusqueda, publicacion)) {
				publicacionesEncontradas.add(publicacion);
			}
		}
		return publicacionesEncontradas;

	}

	private Boolean esPublicacionComparador(ParametrosBusqueda parametrosBusqueda, Publicacion publicacion) {
		String ciudadInmueblePublicacion = publicacion.getInmueble().getCiudad();

		Boolean evalObligatorios = ciudadInmueblePublicacion.equals(parametrosBusqueda.getCiudad())
				&& publicacion.getCheckIn().equals(parametrosBusqueda.getCheckIn())
				&& publicacion.getCheckOut().equals(parametrosBusqueda.getCheckOut());
		// evalObligatorios evalúa los parámetros obligatorios que ingrese el usuario a
		// la publicacion que quiere buscar

		Boolean evalOpcionales = (esPrecioDentroDelRango(parametrosBusqueda, publicacion)
				|| seIndicaCantidadHuespedes(parametrosBusqueda, publicacion));

		if (evalObligatorios && !evalOpcionales) {
			//Si sólo se ingresaron los parámetros obligatorios, retorna true de esos parámetros			
			return evalObligatorios;

		} else { 
			//caso contrario quiere decir que se ingresaron los obligatorios y algún opcional
			return evalObligatorios && evalOpcionales;
		}

	}

	private Boolean seIndicaCantidadHuespedes(ParametrosBusqueda parametrosBusqueda, Publicacion publicacion) {
		return parametrosBusqueda.getCantidadDeHuespedes() != null;
	}

	private Boolean esPrecioDentroDelRango(ParametrosBusqueda parametrosBusqueda, Publicacion publicacion) {

		return publicacion.getPrecio() != null
				&& publicacion.getPrecio().compareTo(parametrosBusqueda.getPrecioMinimo()) >= 0
				&& publicacion.getPrecio().compareTo(parametrosBusqueda.getPrecioMinimo()) <= 0;
		// compara si el precio de la publicacion está dentro del rango de precios de
		// los que el
		// usuario envio por parametros
	}

}

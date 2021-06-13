package unq;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.mockito.ArgumentMatchers;

public class AdministradorPublicacion {

	private List<Publicacion> publicaciones;

	public AdministradorPublicacion() {
		setPublicaciones(new ArrayList<Publicacion>());
	}

	public void agregar(Publicacion publicacion) {
		if (getPublicaciones().isEmpty()) {
			publicaciones = new ArrayList<Publicacion>();
		}
		publicaciones.add(publicacion);
	}

	public List<Publicacion> getPublicaciones() {
		return publicaciones;
	}

	public void setPublicaciones(List<Publicacion> publicaciones) {
		this.publicaciones = publicaciones;
	}

	public void cambiarPrecio(Publicacion publicacion, Double precio) {
//		if (!this.elUsuarioPublico(publicacion.getPropietario(), publicacion)) {
//			System.out.println("error: no podés bajar precio de una publicación que no es tuya");
//		} else {
		for (Publicacion publi : getPublicaciones()) {
			if (publi.equals(publicacion)) {
				modificarPrecio(publi, precio);
				break;
			}
		}

	}

	public void modificarPrecio(Publicacion publicacion, Double nuevoPrecio) {
		if (publicacion.getPrecio() < nuevoPrecio) {
			// this.setPrecio(0.0);
			// si bajó el precio, hacer algo para notificar al observer
		}
		publicacion.setPrecio(nuevoPrecio);
	}

	public List<Publicacion> obtenerPublicacionesDelUsuario(Usuario propietario) {

		List<Publicacion> publicacionesDelUsuario = getPublicaciones().stream()
				.filter(p -> p.getPropietario().equals(propietario)).collect(Collectors.toList());
		return publicacionesDelUsuario;
	}

	/*
	 * public void publicar(Publicacion publicacion) { if
	 * (getPublicaciones().isEmpty()) { publicaciones = new
	 * ArrayList<Publicacion>(); } publicaciones.add(publicacion); }
	 */

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

		Boolean evalOpcionales = (esPrecioDentroDelRango(parametrosBusqueda, publicacion)
				|| seIndicaCantidadHuespedes(parametrosBusqueda, publicacion));

		return evalObligatorios || evalOpcionales;

	}

	private Boolean seIndicaCantidadHuespedes(ParametrosBusqueda parametrosBusqueda, Publicacion publicacion) {
		return parametrosBusqueda.getCantidadDeHuespedes() != null;
	}

	private Boolean esPrecioDentroDelRango(ParametrosBusqueda parametrosBusqueda, Publicacion publicacion) {

		return precioPublicacionNoEsNulo(publicacion) && precioMaximoYMinimoNoSonNulos(parametrosBusqueda)
				&& (publicacion.getPrecio().compareTo(parametrosBusqueda.getPrecioMinimo())) >= 0
				&& (publicacion.getPrecio().compareTo(parametrosBusqueda.getPrecioMinimo())) <= 0;

	}

	private boolean precioPublicacionNoEsNulo(Publicacion publicacion) {
		return publicacion.getPrecio() != null;
	}

	private boolean precioMaximoYMinimoNoSonNulos(ParametrosBusqueda parametrosBusqueda) {
		return parametrosBusqueda.getPrecioMinimo() != null && parametrosBusqueda.getPrecioMaximo() != null;
	}

	public void añadirPublicacion(Publicacion publicacion) {
		getPublicaciones().add(publicacion);

	}

	public Integer cantidadPublicaciones() {
		return getPublicaciones().size();
	}

}

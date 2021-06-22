package unq;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AdministradorPublicacion {

	private List<Publicacion> publicaciones;

	public AdministradorPublicacion() {
		setPublicaciones(new ArrayList<Publicacion>());
	}

	public void agregar(Publicacion publicacion) {
		publicaciones.add(publicacion);
	}

	public List<Publicacion> getPublicaciones() {
		return publicaciones;
	}

	public void setPublicaciones(List<Publicacion> publicaciones) {
		this.publicaciones = publicaciones;
	}

	public void actualizarPrecio(Publicacion publicacion, Double precio) {
//		if (!this.elUsuarioPublico(publicacion.getPropietario(), publicacion)) {
//			System.out.println("error: no podés bajar precio de una publicación que no es tuya");
//		} else {

		for (Publicacion publi : getPublicaciones()) {
			if (publi.equals(publicacion)) {
				publicacion.actualizarPrecio(precio);
				// si bajó el precio, hacer algo para notificar al observer
				break;
			}
		}

	}

	public List<Publicacion> publicacionesDelUsuario(Usuario propietario) {

		List<Publicacion> publicacionesDelUsuario = getPublicaciones().stream()
				.filter(p -> p.getPropietario().equals(propietario)).collect(Collectors.toList());
		return publicacionesDelUsuario;
	}

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

		Boolean evalOpcionales = evalObligatorios && (esPrecioDentroDelRango(parametrosBusqueda, publicacion)
				|| parametrosBusqueda.seIndicaCantidadDeHuespedes());

		return evalOpcionales;

	}

	private Boolean esPrecioDentroDelRango(ParametrosBusqueda parametrosBusqueda, Publicacion publicacion) {

		return precioPubliYPrecioMaxYMinSonNulos(parametrosBusqueda, publicacion)
				|| !precioPubliYPrecioMaxYMinSonNulos(parametrosBusqueda, publicacion);

	}

	private Boolean precioPubliYPrecioMaxYMinSonNulos(ParametrosBusqueda paramBusq, Publicacion publicacion) {
		return precioPubliEsNulo(publicacion) && precioMaxYMinSonNulos(paramBusq)
				&& estaDentroDelRango(publicacion, paramBusq);
	}

	private Boolean estaDentroDelRango(Publicacion publi, ParametrosBusqueda paramBusq) {
		return (publi.getPrecio().compareTo(paramBusq.getPrecioMinimo())) >= 0
				&& (publi.getPrecio().compareTo(paramBusq.getPrecioMinimo())) <= 0;
	}

	private Boolean precioMaxYMinSonNulos(ParametrosBusqueda paramBusq) {
		return paramBusq.getPrecioMinimo() == null && paramBusq.getPrecioMaximo() == null;
	}

	private Boolean precioPubliEsNulo(Publicacion publicacion) {
		return publicacion.getPrecio() == null;
	}

	public Integer cantidadPublicaciones() {
		return getPublicaciones().size();
	}

	public Boolean registraPublicacionDeUsuario(Usuario usuario) {
		return (!this.publicacionesDelUsuario(usuario).isEmpty());
	}

}

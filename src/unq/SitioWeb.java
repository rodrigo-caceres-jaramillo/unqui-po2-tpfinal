package unq;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;

public class SitioWeb {

	private Administrador administrador;
	private AdministradorUsuario adminUsuario;

	//private ArrayList<Usuario> usuarios;
	private ArrayList<CategoriaDePuntaje> categoriasDePuntaje;

	private ArrayList<TipoDeInmueble> tiposDeInmuebles;
	private AdministradorPublicacion adminPublicacion;

	public AdministradorPublicacion getAdminPublicacion() {
		return adminPublicacion;
	}

	public void setAdminPublicacion(AdministradorPublicacion adminPublicacion) {
		this.adminPublicacion = adminPublicacion;
	}

	// Constructor
	public SitioWeb() {
		this.setAdministrador(null);
		this.setCategoriasDePuntaje(new ArrayList<CategoriaDePuntaje>());
		this.setTiposDeInmuebles(new ArrayList<TipoDeInmueble>());
		
	}

	// Metodos

	public List<Inmueble> buscarInmueble(ParametrosBusqueda parametrosBusqueda) {

		List<Publicacion> publicacionesFiltradas = getAdminPublicacion().buscar(parametrosBusqueda);
		List<Inmueble> inmueblesFiltrados = new ArrayList<Inmueble>();

		for (int i = 0; i < publicacionesFiltradas.size(); i++) {
			inmueblesFiltrados.add(getPublicaciones().get(i).getInmueble());
		}
		return inmueblesFiltrados;
	}

	public void registrarUsuario(Usuario usuario) {
		getAdminUsuario().registrar(usuario);
	}

	public void registrarAdministrador(Administrador administrador) {
		administrador.registrarse(this);
		this.setAdministrador(administrador);
	}


	public void agregarTipoDeInmueble(TipoDeInmueble tipo) {
		this.tiposDeInmuebles.add(tipo);
	}

	public void publicar(Publicacion publicacion) {
		getAdminPublicacion().agregar(publicacion);
	}

	public void añadirOcupacionDelInmueble(Inmueble inmueble) {
		// TODO Auto-generated method stub

	}

	public Boolean elInmuebleEstaOcupado(Inmueble inmueble1) {
		return false;
	}

	public List<Publicacion> getPublicacionesDe(Usuario propietario) {

		return getAdminPublicacion().obtenerPublicacionesDelUsuario(propietario);
	}

	public Boolean registraPubliDeUsuarioConFormaDePago(Propietario propietario, FormasDePagoEnum formaDePago) {
		List<Publicacion> publicaciones = this.getPublicacionesDe(propietario);

		return (publicaciones.stream().anyMatch(publi -> publi.aceptaFormaDePago(formaDePago)));
	}


	public Boolean elUsuarioPublico(Publicacion publi, Usuario usuario) {

		return (getPublicacionesDe(usuario)).contains(publi);
	}

	public List<Publicacion> getPublicaciones() {
		return getAdminPublicacion().getPublicaciones();
	}

	public void agregarPublicacion(Publicacion publicacion) {
		getAdminPublicacion().agregar(publicacion);
	}

	public List<Usuario> getUsuarios() {

		return getAdminUsuario().getUsuarios();
	}

	
	// Gets y sets
	public Administrador getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}


	public void setCategoriasDePuntaje(ArrayList<CategoriaDePuntaje> categoriasDePuntaje) {
		this.categoriasDePuntaje = categoriasDePuntaje;
	}

	public ArrayList<TipoDeInmueble> getTiposDeInmuebles() {
		return tiposDeInmuebles;
	}

	public void setTiposDeInmuebles(ArrayList<TipoDeInmueble> tiposDeInmuebles) {
		this.tiposDeInmuebles = tiposDeInmuebles;
	}


	public void agregarCategoriaDePuntaje(CategoriaDePuntaje categoriaDePuntaje) {
		this.categoriasDePuntaje.add(categoriaDePuntaje);
	}


//	public void agregarTipoDeServicio(Servicio servicio) {
//		this.tiposDeServicios.add(servicio);
//	}

//	public void registrarInmueble(Propietario propietario, Inmueble inmueble) {
//		Publicacion nuevaPublicacion = new Publicacion(propietario, inmueble);
//		this.publicar(nuevaPublicacion);
//		;
//	}


//	public ArrayList<Inmueble> getInmueblesConBusquedaPor(String ciudad, LocalDate checkIn, LocalDate checkOut,
//			Integer capacidad, Double precioMinimo, Double precioMaximo) {
//
//		ArrayList<Inmueble> inmueblesFiltrados = new ArrayList<Inmueble>();
//
//		for (int i = 0; i < getPublicaciones().size(); i++) {
//			Publicacion publicacion = getPublicaciones().get(i);
//
//			if (publicacion.cumpleConEspecificaciones(ciudad, checkIn, checkOut, capacidad, precioMinimo,
//					precioMaximo)) {
//
//				inmueblesFiltrados.add(publicacion.getInmueble());
//			}
//		}
//		return (inmueblesFiltrados);
//	}


	public void actualizarPrecioDePublicacion(Publicacion publi, Double precio) {
		getAdminPublicacion().bajarPrecioDePubli(publi, precio);
	}


	public AdministradorUsuario getAdminUsuario() {
		return adminUsuario;
	}

	public void setAdminUsuario(AdministradorUsuario adminUsuario) {
		this.adminUsuario = adminUsuario;
	}


//	public boolean registraServicioDeInmueble(Servicio servicio) {
//		return (this.getTiposDeServicios().contains(servicio));
//	}

	public boolean registraTipoDeInmueble(TipoDeInmueble tipoDeInmueble) {
		return (this.getTiposDeInmuebles().contains(tipoDeInmueble));
	}

//	public Boolean registraCategoriaDePuntaje(CategoriaDePuntaje categoriaDePuntajeParaInmueble) {
//
//		return (this.getCategoriasDePuntaje().contains(categoriaDePuntajeParaInmueble));
//	}

	public Double promedioDePuntajeDe(Usuario usuario, CategoriaDePuntaje categoriaDePuntajeParaInquilino) {
		
		return (usuario.getPromedioDePuntajesDeCategoria(categoriaDePuntajeParaInquilino ) );
	}

}

package unq;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import entidades.ServicioDeMailTestCase;

@SuppressWarnings("deprecation")
public class SitioWeb extends Observable {
	// Atributos
	private Administrador administrador;
	private AdministradorUsuario adminUsuario;
	private AdministradorPublicacion adminPublicacion;
	private AdministradorReserva adminReserva;
	private List<CategoriaDePuntaje> categoriasDePuntaje;
	private List<TipoDeInmueble> tiposDeInmuebles;
	private ServicioDeMailTestCase servicioMail;
	private AdministadorOcupacionDeInmueble adminOcupaciones;

	// Constructor
	public SitioWeb() {
		this.setAdministrador(null);
		this.setCategoriasDePuntaje(new ArrayList<CategoriaDePuntaje>());
		this.setTiposDeInmuebles(new ArrayList<TipoDeInmueble>());
		this.setAdminPublicacion(new AdministradorPublicacion());
		this.setAdminUsuario(new AdministradorUsuario(this));
		this.setAdminReserva(new AdministradorReserva(this));
		this.setServicioDeMail(new ServicioDeMailTestCase());
		this.setAdminOcupaciones(new AdministadorOcupacionDeInmueble(this));
	}

	// Gets y sets
	public List<Publicacion> getPublicacionesDe(Usuario propietario) {
		return getAdminPublicacion().publicacionesDelUsuario(propietario);
	}

	public AdministradorPublicacion getAdminPublicacion() {
		return (adminPublicacion);
	}

	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}

	public AdministradorUsuario getAdminUsuario() {
		return adminUsuario;
	}

	public void setAdminPublicacion(AdministradorPublicacion adminPublicacion) {
		this.adminPublicacion = adminPublicacion;
	}

	public Administrador getAdministrador() {
		return administrador;
	}

	public void setAdminUsuario(AdministradorUsuario adminUsuario) {
		this.adminUsuario = adminUsuario;
	}

	public void setCategoriasDePuntaje(List<CategoriaDePuntaje> categoriasDePuntaje) {
		this.categoriasDePuntaje = categoriasDePuntaje;
	}

	public List<CategoriaDePuntaje> getCategoriasDePuntaje() {
		return (this.categoriasDePuntaje);
	}

	public List<TipoDeInmueble> getTiposDeInmuebles() {
		return (tiposDeInmuebles);
	}

	public void setTiposDeInmuebles(List<TipoDeInmueble> tiposDeInmuebles) {
		this.tiposDeInmuebles = tiposDeInmuebles;
	}

	public AdministradorReserva getAdminReserva() {
		return adminReserva;
	}

	public void setAdminReserva(AdministradorReserva adminReserva) {
		this.adminReserva = adminReserva;
	}

	public List<Publicacion> getPublicaciones() {
		return getAdminPublicacion().getPublicaciones();
	}

	public List<Usuario> getUsuarios() {
		return getAdminUsuario().getUsuarios();
	}

	public List<Reserva> getReservas() {
		return this.getAdminReserva().getReservas();
	}

	public void setServicioDeMail(ServicioDeMailTestCase servicioDeMail) {
		this.servicioMail = servicioDeMail;

	}

	public ServicioDeMailTestCase getServicioDeMail() {

		return (this.servicioMail);
	}

	public AdministadorOcupacionDeInmueble getAdminOcupaciones() {
		return (this.adminOcupaciones);
	}

	private void setAdminOcupaciones(AdministadorOcupacionDeInmueble adminOcupacionesInmuebles) {
		this.adminOcupaciones = adminOcupacionesInmuebles;
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

//	public void publicar(Publicacion publicacion) {
//		getAdminPublicacion().agregar(publicacion);
//	}

	public Boolean elInmuebleEstaOcupado(Inmueble inmueble) {
		return (this.getAdminOcupaciones().registraOcupacionDe(inmueble));
	}

	public Boolean registraPubliDeUsuarioConFormaDePago(Usuario propietario, FormasDePagoEnum formaDePago) {
		List<Publicacion> publicaciones = this.getPublicacionesDe(propietario);

		return (publicaciones.stream().anyMatch(publi -> publi.aceptaFormaDePago(formaDePago)));
	}

	public Boolean elUsuarioPublico(Publicacion publi, Usuario usuario) {
		return (getPublicacionesDe(usuario)).contains(publi);
	}

	public void registrarAdministrador(Administrador administrador) {
		administrador.setSitioAcargo(this);
		this.setAdministrador(administrador);
	}

	public void addCategoriaDePuntaje(CategoriaDePuntaje categoriaDePuntaje) {
		this.getCategoriasDePuntaje().add(categoriaDePuntaje);
	}

	public void addTipoDeInmueble(TipoDeInmueble tipo) {
		this.tiposDeInmuebles.add(tipo);
	}

	public void addPublicacion(Publicacion publicacion) {
		this.getAdminPublicacion().agregar(publicacion);
	}

	public void actualizarPrecioDePublicacion(Publicacion publi, Double precio) {
		this.getAdminPublicacion().actualizarPrecio(publi, precio);
		this.notifyObservers();
	}

	public void addUsuario(Usuario usuario) {
		this.getAdminUsuario().registrar(usuario);
	}

	public void addReserva(Reserva reserva) {
		this.getAdminReserva().agregar(reserva);
	}

	public List<Reserva> getReservasDe(Usuario usuario) {
		return this.getAdminReserva().obtenerReservasDelUsuario(usuario);
	}

	// testing messages
	public Boolean registraTipoDeServicio(ServiciosEnum servicio) {
		return (this.getAdministrador().registraElTipoDeServicio(servicio));
	}

	public Boolean registraTipoDeInmueble(TipoDeInmueble tipoDeInmueble) {
		return (this.getTiposDeInmuebles().contains(tipoDeInmueble));
	}

	public Boolean registraCategoriaDePuntaje(CategoriaDePuntaje categoriaDePuntajeParaInmueble) {
		return (this.getCategoriasDePuntaje().contains(categoriaDePuntajeParaInmueble));
	}

	public Double promedioDePuntajeDelUsuario(Usuario usuario, CategoriaDePuntaje categoriaDePuntaj) {
		return (usuario.getPromedioDePuntajesDeCategoria(categoriaDePuntaj));
	}

	/*
	 * public List<Reserva> getReservasFuturasDe(Usuario usuario) { return
	 * this.getAdminReserva().obtenerReservasFuturasDelUsuario(usuario); }
	 */

	public List<Reserva> getReservasDeLaCiudad(Usuario usuario, String ciudad) {
		return this.getAdminReserva().obtenerReservasEnLaCiudadDelUsuario(usuario, ciudad);
	}

	public List<String> getCiudadadesConReservasDe(Usuario usuario) {
		return (this.getAdminReserva().getCiudadadesConReservasDe(usuario));
	}

	public void cancelarReserva(Reserva reserva) {
		getAdminReserva().eliminar(reserva);

	}

	public Boolean contienePublicacionesDe(Usuario usuario) {
		return (this.getAdminPublicacion().registraPublicacionDeUsuario(usuario));
	}

	public void enviarMailDeConfirmacionAUsuario(Usuario inquilino) {
		this.getServicioDeMail().enviarMailDeConfirmacionA(inquilino.getMail());
	}

	public List<OcupacionDeInmueble> getOcupaciones() {

		return (getAdminOcupaciones().getOcupaciones());
	}

	public void addOcupacionDelInmubleDeLaReserva(Reserva reserva) {
		this.getAdminOcupaciones().addOcupacionConReserva(reserva);
		this.enviarMailDeConfirmacionAUsuario(reserva.getInquilino());

	}

}

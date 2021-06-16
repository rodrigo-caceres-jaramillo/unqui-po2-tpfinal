package unq;

import java.util.ArrayList;
import java.util.List;

public class SitioWeb {

	private Administrador administrador;
	private AdministradorUsuario adminUsuario;
	private AdministradorPublicacion adminPublicacion;
	private List<CategoriaDePuntaje> categoriasDePuntaje;
	private List<TipoDeInmueble> tiposDeInmuebles;

	// Constructor
	public SitioWeb() {
		this.setAdministrador(null);
		this.setCategoriasDePuntaje(new ArrayList<CategoriaDePuntaje>());
		this.setTiposDeInmuebles(new ArrayList<TipoDeInmueble>());
		setAdminPublicacion(new AdministradorPublicacion());
		setAdminUsuario(new AdministradorUsuario());

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

	public void publicar(Publicacion publicacion) {
		getAdminPublicacion().agregar(publicacion);
	}

	public void añadirOcupacionDelInmueble(Inmueble inmueble) {
		// TODO Auto-generated method stub

	}

	public Boolean elInmuebleEstaOcupado(Inmueble inmueble) {
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

	// Gets y sets

	public AdministradorPublicacion getAdminPublicacion() {
		return (adminPublicacion);
	}

	public void setAdminPublicacion(AdministradorPublicacion adminPublicacion) {
		this.adminPublicacion = adminPublicacion;
	}

	public void registrarAdministrador(Administrador administrador) {
		administrador.setSitioAcargo(this);
		this.setAdministrador(administrador);
	}

	public Administrador getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}

	public AdministradorUsuario getAdminUsuario() {
		return adminUsuario;
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

	public void addCategoriaDePuntaje(CategoriaDePuntaje categoriaDePuntaje) {
		this.getCategoriasDePuntaje().add(categoriaDePuntaje);
	}

	public List<TipoDeInmueble> getTiposDeInmuebles() {
		return (tiposDeInmuebles);
	}

	public void setTiposDeInmuebles(List<TipoDeInmueble> tiposDeInmuebles) {
		this.tiposDeInmuebles = tiposDeInmuebles;
	}

	public void addTipoDeInmueble(TipoDeInmueble tipo) {
		this.tiposDeInmuebles.add(tipo);
	}

	public List<Publicacion> getPublicaciones() {
		return getAdminPublicacion().getPublicaciones();
	}

	public void addPublicacion(Publicacion publicacion) {
		this.getAdminPublicacion().agregar(publicacion);
	}

	public void actualizarPrecioDePublicacion(Publicacion publi, Double precio) {
		this.getAdminPublicacion().actualizarPrecio(publi, precio);
	}

	public List<Usuario> getUsuarios() {
		return getAdminUsuario().getUsuarios();
	}

	public void addUsuario(Usuario usuario) {
		getAdminUsuario().registrar(usuario);
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

}

package unq;

import java.util.ArrayList;
import java.util.List;

public class SitioWeb {

	private Administrador administrador;
	private AdministradorUsuario adminUsuario;
	private ArrayList<CategoriaDeRankeo> categoriasDeRankeo;
	private ArrayList<TipoDeInmueble> tiposDeInmuebles;
	private ArrayList<TipoDeServicio> tiposDeServicios;
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
		this.setCategoriasDeRankeo(new ArrayList<CategoriaDeRankeo>());
		this.setTiposDeInmuebles(new ArrayList<TipoDeInmueble>());
		this.setTiposDeServicios(new ArrayList<TipoDeServicio>());

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

	public void agregarCategoriaDeRankeo(CategoriaDeRankeo rank) {
		this.categoriasDeRankeo.add(rank);
	}

	public void agregarTipoDeInmueble(TipoDeInmueble tipo) {
		this.tiposDeInmuebles.add(tipo);
	}

	public void agregarTipoDeServicio(TipoDeServicio servicio) {
		this.tiposDeServicios.add(servicio);
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

	public void actualizarPrecioDePublicacion(Publicacion publi, Double precio) {
		getAdminPublicacion().modificarPrecio(publi, precio);
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

	public ArrayList<CategoriaDeRankeo> getCategoriasDeRankeo() {
		return categoriasDeRankeo;
	}

	public void setCategoriasDeRankeo(ArrayList<CategoriaDeRankeo> categoriasDeRankeo) {
		this.categoriasDeRankeo = categoriasDeRankeo;
	}

	public ArrayList<TipoDeInmueble> getTiposDeInmuebles() {
		return tiposDeInmuebles;
	}

	public void setTiposDeInmuebles(ArrayList<TipoDeInmueble> tiposDeInmuebles) {
		this.tiposDeInmuebles = tiposDeInmuebles;
	}

	public ArrayList<TipoDeServicio> getTiposDeServicios() {
		return tiposDeServicios;
	}

	public void setTiposDeServicios(ArrayList<TipoDeServicio> tiposDeServicios) {
		this.tiposDeServicios = tiposDeServicios;
	}

	public AdministradorUsuario getAdminUsuario() {
		return adminUsuario;
	}

	public void setAdminUsuario(AdministradorUsuario adminUsuario) {
		this.adminUsuario = adminUsuario;
	}

}

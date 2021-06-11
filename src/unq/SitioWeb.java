package unq;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SitioWeb {
	// Atributos
	private Administrador administrador;
	private ArrayList<Usuario> usuarios;
	private ArrayList<CategoriaDeRankeo> categoriasDeRankeo;
	private ArrayList<TipoDeInmueble> tiposDeInmuebles;
	private ArrayList<TipoDeServicio> tiposDeServicios;
	private ArrayList<Publicacion> publicaciones;

	// Constructor
	public SitioWeb() {
		this.setAdministrador(null);
		this.setUsuarios(new ArrayList<Usuario>());
		this.setCategoriasDeRankeo(new ArrayList<CategoriaDeRankeo>());
		this.setTiposDeInmuebles(new ArrayList<TipoDeInmueble>());
		this.setTiposDeServicios(new ArrayList<TipoDeServicio>());
		this.setPublicaciones(new ArrayList<Publicacion>());
	}

	// Gets y sets
	public Administrador getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
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

	public ArrayList<Publicacion> getPublicaciones() {
		return publicaciones;
	}

	public void setPublicaciones(ArrayList<Publicacion> publicaciones) {
		this.publicaciones = publicaciones;
	}

	// Metodos
	public void registrarUsuario(Usuario usuario) {
		usuario.registrarse(this);
		this.usuarios.add(usuario);
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


	public void registrarInmueble(Propietario propietario, Inmueble inmueble) {
		Publicacion nuevaPublicacion = new Publicacion(propietario, inmueble);
		this.publicaciones.add(nuevaPublicacion);
	}
	 

	public ArrayList<Inmueble> getInmueblesConBusquedaPor(String ciudad, LocalDate checkIn, LocalDate checkOut,
			Integer capacidad, Double precioMinimo, Double precioMaximo) {

		ArrayList<Inmueble> inmueblesFiltrados = new ArrayList<Inmueble>();

		for (int i = 0; i < getPublicaciones().size(); i++) {
			Publicacion publicacion = getPublicaciones().get(i);

			if (publicacion.cumpleConEspecificaciones(ciudad, checkIn, checkOut, capacidad, precioMinimo,
					precioMaximo)) {

				inmueblesFiltrados.add(publicacion.getInmueble());
			}
		}
		return (inmueblesFiltrados);
	}

	public void añadirOcupacionDelInmueble(Inmueble inmueble) {
		// TODO Auto-generated method stub

	}

	public Boolean elInmuebleEstaOcupado(Inmueble inmueble1) {
		return false;
	}

	public List<Publicacion> getPublicacionesDe(Usuario usuario) {
		
		ArrayList<Publicacion> publicaciones = new ArrayList<Publicacion>();

		for (int i = 0; i < getPublicaciones().size(); i++) {
			Publicacion publicacion = getPublicaciones().get(i);

			if (publicacion.esDelUsuario(usuario) ) {

				publicaciones.add(publicacion);
			}
		}
		return( publicaciones ) ;
	}

	public void añadirNuevaPublicacion(Publicacion publicacion) {
			this.getPublicaciones().add(publicacion);
	}

	public boolean registraPubliDeUsuarioConFormaDePago(Propietario propietario, FormasDePagoEnum formaDePago) {
		List<Publicacion> publicaciones = this.getPublicacionesDe(propietario);

		return (publicaciones.stream().anyMatch(publi -> publi.aceptaFormaDePago(formaDePago) ) );
	}

	public void actualizarPrecioDePublicacion(Publicacion publi, double precio) {
			if(!this.elUsuarioPublicó(publi.getUsuario(), publi ) ){
					System.out.println("error: no podés bajar precio de una publicación que no es tuya");}
			else {
				publi.bajarPrecio(precio);
				this.publicaciones.remove(publi);
				this.añadirNuevaPublicacion(publi);
			}
	
	} 

	
	public boolean elUsuarioPublicó(Usuario usuario, Publicacion publi ){
		
		return (this.getPublicacionesDe(usuario).contains(publi)  ) ;
	}
}

package unq;

import java.time.LocalDate;
import java.util.ArrayList;

public class SitioWeb {
	//Atributos
	private Administrador administrador;
	private ArrayList<Usuario> usuarios;
	private ArrayList<CategoriaDeRankeo> categoriasDeRankeo;
	private ArrayList<TipoDeInmueble> tiposDeInmuebles;
	private ArrayList<TipoDeServicio> tiposDeServicios;
	private ArrayList<Publicacion> publicaciones;
	//Constructor
	public SitioWeb() {
		this.setAdministrador(null);
		this.setUsuarios(new ArrayList<Usuario>());
		this.setCategoriasDeRankeo(new ArrayList<CategoriaDeRankeo>());
		this.setTiposDeInmuebles(new ArrayList<TipoDeInmueble>());
		this.setTiposDeServicios(new ArrayList<TipoDeServicio>());
		this.setPublicaciones(new ArrayList<Publicacion>());
	}
	//Gets y sets
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
	//Metodos 
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
	public ArrayList<Publicacion> getInmueblesPublicadosConEspecificaciones(String ciudad, LocalDate fechaDeEntrada,
			LocalDate fechaDeSalida, Integer cantidadDeHuspedes, Double precioMinimo, Double precioMinimo2) {
		// TODO Auto-generated method stub
		return null;
	}
	public void registrarInmueble(Propietario propietario, Inmueble inmueble) {
		// TODO Auto-generated method stub
		
	}
}
	/**public void registrarInmueble(Propietario propietario, Inmueble inmueble) {
		Publicacion nuevaPublicacion = new Publicacion(propietario, inmueble);
		this.publicaciones.add(nuevaPublicacion);
	}
	
	public ArrayList<Publicacion> getInmueblesPublicadosConEspecificaciones(String ciudad, LocalDate fechaDeEntrada,LocalDate fechaDeSalida, Integer cantidadDeHuspedes, Double precioMinimo, Double precioMaximo) {
		ArrayList<Publicacion> inmueblesFiltrados = new ArrayList<Publicacion>();
		ArrayList<Publicacion> todosLosInmueblesPublicados = getPublicaciones();

		for (int i = 0; i < todosLosInmueblesPublicados.size(); i++) {
			Publicacion publicacion = todosLosInmueblesPublicados.get(i);
			if (publicacion.cumpleConEspecificaciones(ciudad, fechaDeEntrada, fechaDeSalida, cantidadDeHuspedes, precioMinimo, precioMinimo)) {
				inmueblesFiltrados.add(publicacion);
			}
		}
		return inmueblesFiltrados;
	}
}


**/

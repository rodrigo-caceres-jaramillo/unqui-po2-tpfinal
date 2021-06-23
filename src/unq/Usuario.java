package unq;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Usuario {
	// Atributos
	private String nombre;
	private String mail;
	private Integer telefono;
	private List<Puntaje> puntajes;
	private SitioWeb sitioWeb;
	
	// Constructor
	public Usuario(String nombre, String mail, Integer telefono) {
		super();
		this.setNombre(nombre);
		this.setMail(mail);
		this.setTelefono(telefono);
		this.setPuntajes(new ArrayList<Puntaje>());
		this.setSitioWeb(null);
	}
	
	// Gets y sets
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	public void addPuntaje(Puntaje puntaje) {
		this.getPuntajes().add(puntaje);
	}

	public List<Puntaje> getPuntajes() {
		return (this.puntajes);
	}

	public void setPuntajes(List<Puntaje> puntajes) {
		this.puntajes = puntajes;
	}

	public SitioWeb getSitioWeb() {
		return sitioWeb;
	}

	public void setSitioWeb(SitioWeb sitioWeb) {
		this.sitioWeb = sitioWeb;
	}
	
	// Metodos
	public void registrarse(SitioWeb sitioWeb) {
		this.setSitioWeb(sitioWeb);
		sitioWeb.addUsuario(this);
	}
	
	public List<Inmueble> buscarInmuebles(ParametrosBusqueda parametrosBusqueda) {
		return getSitioWeb().buscarInmueble(parametrosBusqueda);
	} 

	public void medioDePagoPara(Publicacion publicacion, FormasDePagoEnum formaDePago) {
		publicacion.addMedioDePago(formaDePago);
	}
		//Puntuar ------------------------------------------------------------------
	public void puntuarA(Usuario usuario, Integer puntuacion, CategoriaDePuntaje categoriaDePuntaje) {
	Puntaje puntaje = new Puntaje(puntuacion, this, categoriaDePuntaje);

			usuario.addPuntaje(puntaje);
	}
//	public void puntuarA(Usuario usuario, Integer puntuacion, CategoriaDePuntaje categoriaDePuntaje) {
//		Puntaje puntaje = new Puntaje(puntuacion, this, categoriaDePuntaje);
//		if(this.esPropietario()&& usuario.esInquilino()) {
//			usuario.addPuntaje(puntaje);
//		}else{ (this.puntuarAPropietario(propietario, puntaje)}
//		
//	}

// public void puntuarAPropietario(Usuario usuario, Puntaje puntaje ){
//           if( this.realizoCheckOutDe( "tipoUnInmuebleDelPropietario" ) {
//						usuario.addPuntaje(puntaje) }
	
//	
//	public void puntuarAInmueble(inmubele, catnPuntos, categoriaDePuntaje){
//	if(this.realizaCheckOut()){
			//	puntuar()
			//else( "no concretaste el periodo de alquiler")
//	realizaCheckOut(){
//		sitoWeb.hayOcupacionConCheckoOutDeInquilino(inquilino); 
	//reserva checkOut == ocupacion checkOut
	//ocupacion.conretoElPeriodo();  
//	}
//	
//	
//	
	
	public Double getPromedioDePuntajes() {
		double total = 0.0;
		if (!this.getPuntajes().isEmpty()) {
			Integer cantPuntajes = this.getPuntajes().size();
			total = this.puntajeTotal() / cantPuntajes;
		}
		return (total);
	}

	public Integer puntajeTotal() {
		Integer valor = this.getPuntajes().stream().mapToInt(Puntaje::getValor).sum();
		return (valor);
	}

	public Integer cantPuntajesDeCategoria(CategoriaDePuntaje categoriaDePuntaje) {
		Integer cant = 0;
		Integer cantPuntajes = this.getPuntajes().size();
		for (int i = 0; i < cantPuntajes; i++) {
			Puntaje puntaje = this.getPuntajes().get(i);
			if (puntaje.getCategoria().equals(categoriaDePuntaje)) {
				cant++;
			}
		}
		return (cant);
	}

	public Integer valorPuntajesDeLaCategoria(CategoriaDePuntaje categoriaDePuntaje) {
		Integer cant = 0;
		Integer cantPuntajes = this.getPuntajes().size();
		for (int i = 0; i < cantPuntajes; i++) {
			Puntaje puntaje = this.getPuntajes().get(i);
			if (puntaje.getCategoria().equals(categoriaDePuntaje)) {
				cant = cant + puntaje.getValor();
			}
		}
		return (cant);
	}

	public Double getPromedioDePuntajesDeCategoria(CategoriaDePuntaje categoriaDePuntaje) {
		double total = 0.0;
		if (!this.getPuntajes().isEmpty()) {
			total = this.valorPuntajesDeLaCategoria(categoriaDePuntaje)
					/ this.cantPuntajesDeCategoria(categoriaDePuntaje);
		}
		return (total);
	}
	
	public void puntuarInmueble(Inmueble inmueble, Integer valorDePuntaje, CategoriaDePuntaje categoriaDePuntaje) {
		inmueble.addPuntaje(new Puntaje(valorDePuntaje, this, categoriaDePuntaje));
	}
	
	
	public void puntuarADuenoDeInmueble(Inmueble inmueble, int puntuacion,
			CategoriaDePuntaje categoriaDePuntajeParaPropietario) {
		this.puntuarA(inmueble.getPropietario(), puntuacion, categoriaDePuntajeParaPropietario);
	}
	//Reservar Inmueble --------------------------------------------
	
	public void reservarInmueble(Publicacion publicacion, FormasDePagoEnum formaDePago, LocalDate checkIn, LocalDate checkOut) {
		Reserva reserva = new Reserva(publicacion, this, formaDePago, checkIn, checkOut);
		this.getSitioWeb().addReserva(reserva);
	}
	
	public List<Reserva> misReservas() {
		return this.getSitioWeb().getReservasDe(this);
	}

/*	public List<Reserva> misReservasFuturas() {
		return this.getSitioWeb().getReservasFuturasDe(this);
	}
	*/
	public List<Reserva> misReservasDeLaCiudad(String ciudad) {
		return this.getSitioWeb().getReservasDeLaCiudad(this, ciudad);
	} 
	
	public List<String> ciudadadesConReservas() {
		return this.getSitioWeb().getCiudadadesConReservasDe(this);
	}
		
	public void cancelarReserva (Reserva reserva) {
		this.getSitioWeb().cancelarReserva (reserva);
	}
	//Publicar Inmueble  --------------------------------------------
	public void agregarPublicacion(Publicacion publicacion) {
		this.getSitioWeb().addPublicacion(publicacion);
	}
	
	public List<Publicacion> misPublicaciones() {
		return this.getSitioWeb().getPublicacionesDe(this);
	}
	
	public void bajarPrecioAPublicacion(Publicacion publi, Double precio) {
		this.getSitioWeb().actualizarPrecioDePublicacion(publi, precio);
	}

	//TestingMessages ------------------------------------------------------

	public Boolean esPropietario() {
	
		return (this.getSitioWeb().contienePublicacionesDe(this) );
	}

	public Boolean esInquilino() {
		return (!this.esPropietario() );
	}

	public boolean elInmuebleRegistraPuntajePropio(Inmueble inmueble1) {
		return (inmueble1.registraPuntajeDe(this));
	}


	public Boolean registraPuntajeDe(Usuario usuario) {
		return (this.getPuntajes().stream().anyMatch(puntaje -> puntaje.getUsuario() == usuario));
	}

	

	
}


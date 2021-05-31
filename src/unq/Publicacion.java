<<<<<<< HEAD
package unq;

import java.util.ArrayList;

public class Publicacion {
	//Atributos
	private Usuario propietario;
	private Inmueble inmueble;
	private ArrayList<Puntacion> puntaciones;
	private ArrayList<Comentario> comentarios;
	//Constructor
	public Publicacion(Usuario propietario, Inmueble inmueble) {
		super();
		this.propietario = propietario;
		this.inmueble = inmueble;
		this.puntaciones = new ArrayList<Puntacion>();
		this.comentarios = new ArrayList<Comentario>();
	}
	//Gets y sets
	public Usuario getPropietario() {
		return propietario;
	}
	public void setPropietario(Usuario propietario) {
		this.propietario = propietario;
	}
	public Inmueble getInmueble() {
		return inmueble;
	}
	public void setInmueble(Inmueble inmueble) {
		this.inmueble = inmueble;
	}
	public ArrayList<Puntacion> getPuntaciones() {
		return puntaciones;
	}
	public void setPuntaciones(ArrayList<Puntacion> puntaciones) {
		this.puntaciones = puntaciones;
	}
	public ArrayList<Comentario> getComentarios() {
		return comentarios;
	}
	public void setComentarios(ArrayList<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
}
=======
package unq;

import java.time.LocalDate;
import java.util.ArrayList;

public class Publicacion {
	private Usuario usuario;
	private Inmueble inmueble;
	private LocalDate checkIn;
	private LocalDate checkOut;
	private ArrayList<String> formasDePagoAceptadas;
	private Double precio;
	// private ArrayList<Puntuacion> puntajesDeRankeo;
	// private ArrayList<Comentario> comentarios;

	// Constructores
	public Publicacion(LocalDate checkIn, LocalDate checkOut, Inmueble inmueble) {
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		setInmueble(inmueble);

	}

	// Métodos
	public boolean cumpleConEspecificaciones(String ciudad, LocalDate fechaDeEntrada, LocalDate fechaDeSalida) {
		String ciudadDelInmueble = getInmueble().getCiudad();

		return ciudadDelInmueble.equals(ciudad) && getCheckIn().equals(fechaDeEntrada)
				&& getCheckOut().equals(fechaDeSalida);
	}

	// Getters and Setters
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Inmueble getInmueble() {
		return inmueble;
	}

	public void setInmueble(Inmueble inmueble) {
		this.inmueble = inmueble;
	}

	public LocalDate getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(LocalDate checkIn) {
		this.checkIn = checkIn;
	}

	public LocalDate getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(LocalDate checkOut) {
		this.checkOut = checkOut;
	}

	public ArrayList<String> getFormasDePagoAceptadas() {
		return formasDePagoAceptadas;
	}

	public void setFormasDePagoAceptadas(ArrayList<String> formasDePagoAceptadas) {
		this.formasDePagoAceptadas = formasDePagoAceptadas;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

}
>>>>>>> branch 'main' of https://github.com/rodrigo-caceres-jaramillo/unqui-po2-tpfinal.git

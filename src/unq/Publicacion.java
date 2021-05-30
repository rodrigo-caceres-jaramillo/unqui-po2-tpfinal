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

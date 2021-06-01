package unq;

import java.util.ArrayList;

public class Publicacion {
	//Atributos
	private Usuario propietario;
	private Inmueble inmueble;
	private ArrayList<Comentario> comentarios;
	//Constructor
	public Publicacion(Usuario propietario, Inmueble inmueble) {
		super();
		this.propietario = propietario;
		this.inmueble = inmueble;
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
	public ArrayList<Comentario> getComentarios() {
		return comentarios;
	}
	public void setComentarios(ArrayList<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public boolean cumpleConEspecificaciones(String ciudad, LocalDate fechaDeEntrada, LocalDate fechaDeSalida) {
		String ciudadDelInmueble = getInmueble().getCiudad();

		return ciudadDelInmueble.equals(ciudad) && getCheckIn().equals(fechaDeEntrada)
				&& getCheckOut().equals(fechaDeSalida);
	}

}


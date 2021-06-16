package unq;

import java.util.ArrayList;
import java.util.List;

public abstract class Usuario {
	// Atributos

	private String nombre;
	private String mail;
	private Integer telefono;
	private List<Puntaje> puntajes;

	// Constructor
	public Usuario(String nombre, String mail, Integer telefono) {
		super();
		this.setNombre(nombre);
		this.setMail(mail);
		this.setTelefono(telefono);
		this.setPuntajes(new ArrayList<Puntaje>());
	}

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

	// Metodos

	public void puntuarA(Usuario usuario, Integer puntuacion, CategoriaDePuntaje categoriaDePuntaje) {

		Puntaje puntaje = new Puntaje(puntuacion, this, categoriaDePuntaje);
		usuario.addPuntaje(puntaje);

	}

	public Boolean registraPuntajeDe(Usuario usuario) {
		return (this.getPuntajes().stream().anyMatch(puntaje -> puntaje.getUsuario() == usuario));

	}

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

//	public Integer valorPuntajes2DeLaCategoria(CategoriaDePuntaje categoria) {
//		List<Puntaje> puntajes = getPuntajes();
//		Integer sum = puntajes.stream().mapToInt(Integer::intValue).sum();
//		
//		return sum;
//		
//	}

	public Double getPromedioDePuntajesDeCategoria(CategoriaDePuntaje categoriaDePuntaje) {
		double total = 0.0;
		if (!this.getPuntajes().isEmpty()) {
			total = this.valorPuntajesDeLaCategoria(categoriaDePuntaje)
					/ this.cantPuntajesDeCategoria(categoriaDePuntaje);
		}

		return (total);

	}

}

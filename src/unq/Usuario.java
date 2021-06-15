package unq;

import java.util.ArrayList;

public abstract class Usuario {
	// Atributos
	private SitioWeb sitioWeb;
	private String nombre;
	private String mail;
	private int telefono;
	private ArrayList<Puntaje> puntajes;

	// Constructor
	public Usuario(String nombre, String mail, int telefono) {
		super();
		this.nombre = nombre;
		this.mail = mail;
		this.telefono = telefono;
		this.puntajes = new ArrayList<Puntaje>();
	}

	// Gets y sets
	public SitioWeb getSitioWeb() {
		return sitioWeb;
	}

	public void setSitioWeb(SitioWeb sitioWeb) {
		this.sitioWeb = sitioWeb;
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

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	
	//Metodos 	


	public void puntuarA(Usuario usuario, int puntuacion,
			CategoriaDePuntaje categoriaDePuntajeParaPropietario) {
			usuario.addPuntaje( new Puntaje(puntuacion,this,categoriaDePuntajeParaPropietario ) );
				
	}

	public void addPuntaje(Puntaje puntaje) {
		this.getPuntajes().add(puntaje);
	}

	public ArrayList<Puntaje> getPuntajes() {

		return (this.puntajes);
	}
	
	public Boolean registraPuntajeDe(Usuario usuario) {
		return (this.getPuntajes().stream().anyMatch( puntaje-> puntaje.getUsuario() == usuario) );

	}
	public Double getPromedioDePuntajes( ) {
		double promedio = 0.0;
		int cantPuntajes = this.getPuntajes().size();
		for (int i = 0; i < cantPuntajes; i++) {
			Puntaje puntaje = this.getPuntajes().get(i);
			promedio = +puntaje.getValor();
		} 
		return ( promedio/cantPuntajes );
	}

	public int cantPuntajesDeCategoria(CategoriaDePuntaje categoriaDePuntaje){
		 int cant = 0;
			int cantPuntajes = this.getPuntajes().size();

		 for (int i = 0; i < cantPuntajes; i++) {
				Puntaje puntaje = this.getPuntajes().get(i);
				if (puntaje.getCategoria().equals(categoriaDePuntaje)) {
					cant ++;
				}
		 } return(cant);
				 
	}
	public Double getPromedioDePuntajesDeCategoria(CategoriaDePuntaje categoriaDePuntaje) {
		double promedio = 0.0;
		int cantPuntajes = this.getPuntajes().size();
		for (int i = 0; i < cantPuntajes; i++) {
			Puntaje puntaje = this.getPuntajes().get(i);
			promedio =+puntaje.valorSiEsDeCategoria(categoriaDePuntaje) ;
		} 
		return ( promedio/this.cantPuntajesDeCategoria(categoriaDePuntaje) );
	}

}

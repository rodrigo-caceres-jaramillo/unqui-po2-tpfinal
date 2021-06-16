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
		this.setNombre(nombre);
		this.setMail(mail);
		this.setTelefono(telefono);
		this.setPuntajes(new ArrayList<Puntaje>());
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
	public void addPuntaje(Puntaje puntaje) {
		this.getPuntajes().add(puntaje);
	}

	public ArrayList<Puntaje> getPuntajes() {

		return (this.puntajes);
	}
	
	public void setPuntajes(ArrayList<Puntaje> puntajes) {
		this.puntajes= puntajes;
	}
	
	//Metodos 	


	public void puntuarA(Usuario usuario, int puntuacion,
			CategoriaDePuntaje categoriaDePuntaje) {
		Puntaje puntaje =  new Puntaje(puntuacion,this,categoriaDePuntaje );
		usuario.addPuntaje(puntaje );
				
	}
	public Boolean registraPuntajeDe(Usuario usuario) {
		return (this.getPuntajes().stream()
								  .anyMatch( puntaje-> puntaje.getUsuario() == usuario) );

	}
	
	public Double getPromedioDePuntajes( ) {
		double total = 0.0;
		
		if(!this.getPuntajes().isEmpty()) {
			int cantPuntajes = this.getPuntajes().size();
				total = this.puntajeTotal()/ cantPuntajes;
		}
		
		return(total);
		
	}
	public int puntajeTotal() {
		int valor =  this.getPuntajes().stream()
						  .mapToInt(Puntaje::getValor)
						  .sum();
		return(valor);
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
	
	public int puntajeTotalDeLaCategoria(CategoriaDePuntaje categoriaDePuntaje) {
		 int cant = 0;
			int cantPuntajes = this.getPuntajes().size();

			 for (int i = 0; i < cantPuntajes; i++) {
					Puntaje puntaje = this.getPuntajes().get(i);
					if (puntaje.getCategoria().equals(categoriaDePuntaje)) {
						cant  =+ puntaje.valorSiEsDeCategoria(categoriaDePuntaje);
					}
			 } return(cant);
			
	}
	
	public Double getPromedioDePuntajesDeCategoria(CategoriaDePuntaje categoriaDePuntaje) {
		double total = 0.0;
		
		if(!this.getPuntajes().isEmpty()) {
				total = this.puntajeTotalDeLaCategoria(categoriaDePuntaje)/ 
						this.cantPuntajesDeCategoria(categoriaDePuntaje);
		}
		
		return(total);
		
	}

}

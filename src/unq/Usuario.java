package unq;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Usuario {
	// Atributos
	private SitioWeb sitioWeb;
	private String nombre;
	private String mail;
	private int telefono;

	// Constructor
	public Usuario(String nombre, String mail, int telefono) {
		super();
		this.sitioWeb = null;
		this.nombre = nombre;
		this.mail = mail;
		this.telefono = telefono;
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
	public void registrarse(SitioWeb sitioWeb) {
		this.setSitioWeb(sitioWeb);
	}
}
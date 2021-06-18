package unq;

import java.util.ArrayList;
import java.util.List;

public class AdministradorUsuario {
	// Atributos
	ArrayList<Usuario> usuarios;
	SitioWeb sitioWeb;
	
	// Constructor
	public AdministradorUsuario(SitioWeb sitioWeb) {
		this.setUsuarios(new ArrayList<Usuario>());
		this.setSitioWeb(sitioWeb);
	}

	// Gets y sets
	public SitioWeb getSitioWeb() {
		return sitioWeb;
	}

	public void setSitioWeb(SitioWeb sitioWeb) {
		this.sitioWeb = sitioWeb;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	// Metodos
	public void registrar(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.Registrarse(null);
	}

}

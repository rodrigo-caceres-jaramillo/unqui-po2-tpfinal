package unq;

import java.util.ArrayList;
import java.util.List;

public class AdministradorUsuario implements Administradores, Registrable{
	// Atributos
	ArrayList<Usuario> usuarios;
	SitioWeb sitioWeb;
	
	// Constructor
	public AdministradorUsuario() {
		this.setUsuarios(new ArrayList<Usuario>());
		this.setSitioWeb(null);
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
	}

	@Override
	public void administrar(SitioWeb sitioWeb) {
		sitioWeb.setAdminUsuario(this);
	}

	@Override
	public void registrarseEn(SitioWeb sitioWeb) {
		this.setSitioWeb(sitioWeb);
	}
}

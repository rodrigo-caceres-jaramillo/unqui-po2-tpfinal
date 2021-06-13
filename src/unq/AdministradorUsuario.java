package unq;

import java.util.ArrayList;
import java.util.List;

public class AdministradorUsuario {

	List<Usuario> usuarios;

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	public void registrar(Usuario usuario) {
		if (getUsuarios() == null) {
			setUsuarios(new ArrayList<Usuario>());
		}
		getUsuarios().add(usuario);
	}


	
	
}

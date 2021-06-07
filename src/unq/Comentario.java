package unq;

public class Comentario {

	private Usuario usuario;
	private String cuerpo;

	public void setUsuario(Usuario usuarioQueImplementaComentario) {
			this.usuario = usuarioQueImplementaComentario;
	}

	public Usuario getUsuario() {
		return (this.usuario);
	}

	public void setCuerpo(String cuerpoDeComentario) {
			this.cuerpo =cuerpoDeComentario;
	}

	public String getCuerpo() {
		
		return (this.cuerpo);
	}

}

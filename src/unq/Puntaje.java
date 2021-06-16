package unq;

public class Puntaje {
	private Integer valor;
	private Usuario usuario;
	private CategoriaDePuntaje categoria;

	public Puntaje() {
		super();
		this.setValor(0);
	}

	public void setValor(Integer valorDePuntuacion) {
		if (valorDePuntuacion >= 5) {
			this.valor = 5;
		} else if (valorDePuntuacion <= 0) {
			this.valor = 0;
		}

	}

	public Puntaje(int valor, Usuario usuario, CategoriaDePuntaje categoria) {
		super();
		this.valor = valor;
		this.usuario = usuario;
		this.categoria = categoria;
	}

	public int getValor() {
		return (this.valor);
	}

	public void setUsuario(Usuario usuarioQueImplementaPuntuacion) {
		this.usuario = usuarioQueImplementaPuntuacion;
	}

	public Usuario getUsuario() {

		return (this.usuario);
	}

	public void setCategoria(CategoriaDePuntaje categoria) {
		this.categoria = categoria;
	}

	public CategoriaDePuntaje getCategoria() {

		return (this.categoria);
	}

	public Integer valorSiEsDeCategoria(CategoriaDePuntaje categoriaDePuntaje) {
		Integer valor = 0;
		if (this.getCategoria().equals(categoriaDePuntaje)) {
			valor = this.getValor();
		}
		return (valor);
	}

}

package unq;

public abstract class PoliticaDeCancelacion {

	Usuario usuario;
	Reserva reserva;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	public PoliticaDeCancelacion() {
	
	}

	public abstract Boolean usuarioPuedeCancelarReserva(Usuario usuario, Reserva reserva);

	protected abstract Double calcularMonto(Reserva reserva);

}

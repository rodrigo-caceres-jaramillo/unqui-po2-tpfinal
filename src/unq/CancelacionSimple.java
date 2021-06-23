package unq;

public class CancelacionSimple extends PoliticaDeCancelacion {

	public CancelacionSimple() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public Boolean usuarioPuedeCancelarReserva(Usuario usuario , Reserva reserva) {
		
		return true;
	}

}

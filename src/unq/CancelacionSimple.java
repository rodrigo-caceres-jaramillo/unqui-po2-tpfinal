package unq;

import java.time.LocalDate;

public class CancelacionSimple extends PoliticaDeCancelacion {

	public CancelacionSimple() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Boolean usuarioPuedeCancelarReserva(Usuario usuario, Reserva reserva) {

		return true;
	}

	@Override
	protected Double calcularMonto(Reserva reserva) {
		Double precio = reserva.getPublicacion().getPrecio();
		LocalDate checkIn = reserva.getInicioDeAlquiler();
		LocalDate checkOut = reserva.getFinalDeAlquiler();
		Double monto = 0.0;

		for (LocalDate date = checkIn; date.isBefore(checkOut); date.plusDays(1)) {
			monto = monto + date.getDayOfMonth() * precio;
		}

		return monto;
	}

}

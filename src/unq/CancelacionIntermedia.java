package unq;

import java.time.LocalDate;

public class CancelacionIntermedia extends PoliticaDeCancelacion {

	public CancelacionIntermedia() {

	}

	@Override
	public Boolean usuarioPuedeCancelarReserva(Usuario usuario, Reserva reserva) {
		LocalDate checkInReserva = reserva.getPublicacion().getCheckIn();

		return LocalDate.now().isBefore(checkInReserva.plusDays(-20));
	}

	@Override
	public Double calcularMonto(Reserva reserva) {
		Double precio = reserva.getPublicacion().getPrecio();
		LocalDate checkInReserva = reserva.getPublicacion().getCheckIn();

		if (LocalDate.now().isBefore(checkInReserva.plusDays(-19))
				&& LocalDate.now().isBefore(checkInReserva.plusDays(-10))) {

			return precio / (precio * 50 / 100);

		} else {
			return precio;
		}

	}

}

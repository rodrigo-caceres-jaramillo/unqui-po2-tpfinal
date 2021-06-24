package unq;

import java.time.LocalDate;

public class CancelacionGratuita extends PoliticaDeCancelacion{

	public CancelacionGratuita() {
	}

	@Override
	public Boolean usuarioPuedeCancelarReserva(Usuario usuario, Reserva reserva) {
		LocalDate checkInReserva = reserva.getPublicacion().getCheckIn();
		
		return LocalDate.now().isBefore(checkInReserva.plusDays(-10)); 
	}

	public Double calcularMonto(Reserva reserva) {
		Double precioPubli = reserva.getPublicacion().getPrecio();
		
		return precioPubli * reserva.diasDeReserva();
	}

}

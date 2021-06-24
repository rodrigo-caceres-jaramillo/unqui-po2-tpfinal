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
	public Double calcularMonto(Reserva reserva) {
		Double precio = reserva.getPublicacion().getPrecio();
		LocalDate checkIn = reserva.getInicioDeAlquiler();
		LocalDate checkOut = reserva.getFinalDeAlquiler();
		Integer cantidadDeDias = checkOut.getDayOfMonth() - checkIn.getDayOfMonth(); 
		
		return cantidadDeDias * precio;
	}

}

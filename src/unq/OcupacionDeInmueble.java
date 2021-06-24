package unq;

import java.time.LocalDate;

public class OcupacionDeInmueble {

	private Usuario inquilino;
	private LocalDate checkOut;
	private LocalDate checkIn;
	private Inmueble inmueble;

	public OcupacionDeInmueble(Inmueble inmueble, LocalDate checkIn, LocalDate checkOut,
			Usuario inquilino) {
		this.setInmmuebleOcupado(inmueble);
		this.setCheckIn(checkIn);
		this.setCheckOut(checkOut);
		this.setInquilino(inquilino);
	}

	private void setInquilino(Usuario inquilino) {
	this.inquilino =inquilino;
	}

	private void setCheckOut(LocalDate checkOut) {
			this.checkOut = checkOut;
	}

	private void setCheckIn(LocalDate checkIn) {
		this.checkIn = checkIn;
	}

	private void setInmmuebleOcupado(Inmueble inmueble) {
		this.inmueble = inmueble;
	}
	public Inmueble getInmueble() {
		return(this.inmueble) ;
	}
}

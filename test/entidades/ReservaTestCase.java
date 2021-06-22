package entidades;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unq.*;


class ReservaTestCase {
	private Reserva reserva;
	private Publicacion publicacion;
	private Usuario inquilino;
	private Usuario propietario;
	
	public LocalDate checkIn = LocalDate.parse("2000-10-15");
	public LocalDate checkOut = LocalDate.parse("2000-10-20");
	public Inmueble inmueble;
	
	@BeforeEach
	public void setUp() throws Exception {
		reserva = new Reserva();
		
		inquilino = mock(Usuario.class);
		propietario =mock(Usuario.class);
		inmueble = mock(Inmueble.class);
		
		publicacion = mock(Publicacion.class); 
		when(publicacion.getPropietario()).thenReturn(propietario);
		when(publicacion.getInmueble()).thenReturn(inmueble);
	
		
	}
	
	@Test
	void testUnaReservaTieneLosDatosParaAsentarseEnElSitio() {
		reserva.setPublicacion(publicacion);
		reserva.setPropietario(propietario);
		reserva.setInquilino(inquilino);
		reserva.setInicioDeAlquiler(checkIn);
		reserva.setFinalDeAlquiler(checkOut);
		reserva.setFormaDePago(FormasDePagoEnum.TARJETADECREDITO);
		
		assertEquals(reserva.getPublicacion(),publicacion);
		assertEquals(reserva.getPropietario(),propietario);
		assertEquals(reserva.getInquilino(),inquilino);
		assertEquals(reserva.getInicioDeAlquiler(), checkIn);
		assertEquals(reserva.getFinalDeAlquiler(),checkOut);
		assertEquals(reserva.getFormaDePago(),FormasDePagoEnum.TARJETADECREDITO);
	}

	@Test
	void testUnaReservaConoceElInmuebleQueSeReserva() {
		reserva.setPublicacion(publicacion);

		assertEquals(reserva.getInmueble(), inmueble);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}

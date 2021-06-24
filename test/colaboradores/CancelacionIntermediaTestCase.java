package colaboradores;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unq.CancelacionIntermedia;
import unq.Publicacion;
import unq.Reserva;
import unq.Usuario;

class CancelacionIntermediaTestCase {

	CancelacionIntermedia tipoIntermedia;
	Reserva reserva;
	Usuario usuario;
	Publicacion publicacion;

	@BeforeEach
	void setUp() throws Exception {

		tipoIntermedia = new CancelacionIntermedia();
		reserva = mock(Reserva.class);
		usuario = mock(Usuario.class);
		publicacion = mock(Publicacion.class);

	}

	@Test
	void testCancelacionIntermediaDeUsuarioNOPuedeRealizarCancelacion() {
		when(publicacion.getCheckIn()).thenReturn(LocalDate.of(2021, 6, 30));
		when(publicacion.getCancelacion()).thenReturn(tipoIntermedia);
		when(reserva.getPropietario()).thenReturn(usuario);
		when(reserva.getPublicacion()).thenReturn(publicacion);

		assertFalse(tipoIntermedia.usuarioPuedeCancelarReserva(usuario, reserva));

	}

	@Test
	void testCancelacionIntermediaDeUsuarioPuedeRealizarCancelacionReserva() {
		when(publicacion.getCheckIn()).thenReturn(LocalDate.of(2021, 7, 30));
		when(publicacion.getCancelacion()).thenReturn(tipoIntermedia);
		when(reserva.getPropietario()).thenReturn(usuario);
		when(reserva.getPublicacion()).thenReturn(publicacion);

		assertTrue(tipoIntermedia.usuarioPuedeCancelarReserva(usuario, reserva));
	}

	@Test
	void testCancelacionIntermediaCalculaMontoACobrarDeCancelacionPagandoLaTotalidad() {
		Publicacion publicacion = new Publicacion();
		publicacion.setPrecio(100.0);
		publicacion.setCheckIn(LocalDate.of(2021, 6, 25));

		when(reserva.getPropietario()).thenReturn(usuario);
		when(reserva.getPublicacion()).thenReturn(publicacion);

		Double montoCalculado = tipoIntermedia.calcularMonto(reserva);

		assertEquals(montoCalculado, 100.0);

	}
	
	@Test
	void testCancelacionIntermediaCalculaMontoACobrarDeCancelacionPagandoLaMitad() {
		Publicacion publicacion = new Publicacion();
		publicacion.setPrecio(100.0);
		publicacion.setCheckIn(LocalDate.of(2021, 7, 30));

		when(reserva.getPropietario()).thenReturn(usuario);
		when(reserva.getPublicacion()).thenReturn(publicacion);

		Double montoCalculado = tipoIntermedia.calcularMonto(reserva);

		assertEquals(montoCalculado, 2.0);
	}
	

}

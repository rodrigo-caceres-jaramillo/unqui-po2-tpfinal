package colaboradores;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unq.CancelacionGratuita;
import unq.Publicacion;
import unq.Reserva;
import unq.Usuario;

class CancelacionGratuitaTestCase {
	
	CancelacionGratuita tipoGratuita;
	Reserva reserva;
	Usuario usuario;
	Publicacion publicacion;

	@BeforeEach
	void setUp() throws Exception {
		
		tipoGratuita = new CancelacionGratuita();
		reserva = mock(Reserva.class);
		usuario = mock(Usuario.class);
		publicacion = mock(Publicacion.class);
	}

	@Test
	void testCancelacionGratuitaDeUsuarioPuedeRealizarseDeUnaPublicacion() {
		when(publicacion.getCheckIn()).thenReturn(LocalDate.of(2021, 7, 4));
		when(publicacion.getCancelacion()).thenReturn(tipoGratuita);
		when(reserva.getPropietario()).thenReturn(usuario);
		when(reserva.getPublicacion()).thenReturn(publicacion);
				
		assertTrue(tipoGratuita.usuarioPuedeCancelarReserva(usuario, reserva));
	}
	
	@Test
	void testCancelacionGratuitaDeUsuarioNOPuedeRealizarse() {
		when(publicacion.getCheckIn()).thenReturn(LocalDate.of(2021, 6, 30));
		when(publicacion.getCancelacion()).thenReturn(tipoGratuita);
		when(reserva.getPropietario()).thenReturn(usuario);
		when(reserva.getPublicacion()).thenReturn(publicacion);
				
		assertFalse(tipoGratuita.usuarioPuedeCancelarReserva(usuario, reserva));
	}

}

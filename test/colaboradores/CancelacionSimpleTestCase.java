package colaboradores;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unq.CancelacionSimple;
import unq.Publicacion;
import unq.Reserva;
import unq.Usuario;

class CancelacionSimpleTestCase {
	
	CancelacionSimple tipoSimple;
	Reserva reserva;
	Usuario usuario;
	Publicacion publicacion;

	@BeforeEach
	void setUp() throws Exception {
		tipoSimple = new CancelacionSimple();
		reserva = mock(Reserva.class);
		usuario = mock(Usuario.class);
		publicacion = mock(Publicacion.class);
	}

	@Test
	void testCancelacionSimpleDeUsuarioPuedeRealizarseDeUnaPublicacion() {
		
		when(publicacion.getCancelacion()).thenReturn(tipoSimple);
		when(reserva.getPropietario()).thenReturn(usuario);
		when(reserva.getPublicacion()).thenReturn(publicacion);
				
		assertTrue(tipoSimple.usuarioPuedeCancelarReserva(usuario,reserva)); 
		//siempre va a poder realizar una de sin cancelacion
	}
	

}








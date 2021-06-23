package colaboradores;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.mock;

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
	void testCancelacionIntermediaPuedeSerRealizadaAPublicacion() {
		fail("Not yet implemented");
	}

}

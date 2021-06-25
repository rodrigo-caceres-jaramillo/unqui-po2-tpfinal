package administradores;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unq.*;

class AdministradorOcupacionInmuebleTestCase {
	AdministradorOcupacionDeInmueble adminOcupaciones;
	Inmueble inmueble;
	OcupacionDeInmueble ocupacionDeInmueble;
	SitioWeb sitio;
	@BeforeEach
	void setUp() throws Exception {
		adminOcupaciones = new AdministradorOcupacionDeInmueble();
		ocupacionDeInmueble = mock(OcupacionDeInmueble.class);
		inmueble = mock(Inmueble.class);
	}

	@Test
	void testUnAdminConoceElInmuebleDeUnaOcupacion() {
		
		when(ocupacionDeInmueble.getInmueble()).thenReturn(inmueble);
		
		assertEquals(ocupacionDeInmueble.getInmueble() ,  inmueble);
	}
	
	@Test
	void testUnAdministradorRegistraOcupacionesDeUnInmueble() {
		adminOcupaciones.addOcupacion(ocupacionDeInmueble);
		when(ocupacionDeInmueble.getInmueble()).thenReturn(inmueble);
		
		assertTrue(adminOcupaciones.registraOcupacionDe(inmueble));
	}
	@Test
	void testUnAdministradorNoRegistraOcupacionesDeUnInmueble() {
		
		assertFalse(adminOcupaciones.registraOcupacionDe(inmueble));
	}

}

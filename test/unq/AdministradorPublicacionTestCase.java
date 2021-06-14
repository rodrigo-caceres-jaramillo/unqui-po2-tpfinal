package unq;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AdministradorPublicacionTestCase {
	
	AdministradorPublicacion adminPublicacion;

	@BeforeEach
	void setUp() throws Exception {
		adminPublicacion = new AdministradorPublicacion();
	}

	@Test
	void testAdministradorPublicacionNoTienePublicaciones() {
		
		assertTrue(adminPublicacion.getPublicaciones().isEmpty());
	}
	
	@Test
	void testAdministradorPublicacionTienePublicaciones() {
		Publicacion publicacion = new Publicacion();
		
		adminPublicacion.agregar(publicacion);
		
		assertEquals(adminPublicacion.cantidadPublicaciones(), 1);
	}
	
	@Test
	void testAdministradorPublicacionObtienePublicacionesDeUnPropietario() {
		
	}

}

package colaboradores;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unq.Inmueble;
import unq.SitioWeb;
import unq.TipoDeInmueble;

class TipoDeInmuebleTestCase {
	TipoDeInmueble tipoDeInmueble;
	Inmueble inmueble;
	SitioWeb sitio;
	
	
	@BeforeEach
	void setUp() throws Exception {
		tipoDeInmueble = new TipoDeInmueble();
		inmueble = mock(Inmueble.class);
		sitio = mock(SitioWeb.class);
	}

	@Test
	void testUnTipoDeInmuebleTieneUnNombre() {
			tipoDeInmueble.setNombre("Hogar");
			assertEquals( tipoDeInmueble.getNombre(), "Hogar");
	}
	@Test
	void testUnTipoDeImuebleEsUnTipoDeUnInmueble() {
		when(inmueble.esDeTipo(tipoDeInmueble) ).thenReturn(true);
		
		assertTrue(tipoDeInmueble.esUnTipoDelInmueble(inmueble));
	}
	@Test
	void testUnTipoDeInmuebleEstaRegistradoEnUnSitioWeb() {
		when( sitio.registraTipoDeInmueble(tipoDeInmueble) ).thenReturn(true);
		
		
		assertTrue(tipoDeInmueble.estaRegistradoEn(sitio));
		
		
	}
}

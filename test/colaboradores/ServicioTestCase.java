package colaboradores;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unq.Inmueble;
import unq.Servicio;
import unq.SitioWeb;

class ServicioTestCase {
	Servicio servicio;
	Inmueble inmueble;
	SitioWeb sitio;

	@BeforeEach
	void setUp() throws Exception {
		servicio = new Servicio();
		inmueble = mock(Inmueble.class);
		sitio = mock(SitioWeb.class);
	}

	@Test
	void unServicioTieneUnNombre() {
		servicio.setNombre("Luz");

		assertEquals(servicio.getNombre(), "Luz");
	}

	@Test
	void unServicioEsUnServicioBrindadoPorUnInmueble() {
		servicio.setNombre("Luz");

		inmueble.addNuevoServicio(servicio);
		when(inmueble.registraServicio(servicio)).thenReturn(true);

		assertTrue(servicio.esUnServicioBrindadoPor(inmueble));
	}

//	@Test
//	void unServicioEstáRegistradoEnUnSitioWeb() {
//
//		when(sitio.registraServicioDeInmueble(servicio)).thenReturn(true);
//
//		assertTrue(servicio.estaRegistradoEnElSitio(sitio));
//	}

}

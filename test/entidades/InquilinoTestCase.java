package entidades;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import unq.CategoriaDePuntaje;
import unq.Inmueble;
import unq.Inquilino;
import unq.Propietario;
import unq.SitioWeb;

class InquilinoTestCase {

	private SitioWeb sitioWeb;
	private Inquilino inquilino;
	private Propietario propietario;
	private Inmueble inmueble1;
	private Inmueble inmueble2;
	private CategoriaDePuntaje categoriaDePuntaje;

	@BeforeEach
	void setUp() throws Exception {
		sitioWeb = mock(SitioWeb.class);
		inquilino = new Inquilino("Sergio", "sergio.99@gmail.com", 22759863);
		inmueble1 = mock(Inmueble.class);
		categoriaDePuntaje = mock(CategoriaDePuntaje.class);

		inquilino.setSitioWeb(sitioWeb);
	}

	@Test
	void testUnInquilinoRealizaUnaBusquedaConDatosObligatoriosNoEncuentraNinguno() {
		LocalDate checkIn = LocalDate.of(2021, 8, 22);
		LocalDate checkOut = LocalDate.of(2021, 8, 23);

		List<Inmueble> busquedaEsperada = new ArrayList<>();

		when(sitioWeb.getInmueblesConBusquedaPor("Villa Elisa", checkIn, checkOut, 0, 0.0, 0.0))
				.thenReturn(busquedaEsperada);

		List<Inmueble> resultadoDeLaBusqueda = inquilino.buscarInmuebles("Villa Elisa", checkIn, checkOut, 0, 0.0,
				0.0);

		assertTrue(resultadoDeLaBusqueda.isEmpty());
	}

	@Test
	void testUnInquilinoRealizaUnaBusquedaConDatosObligatoriosEncuentraUnInmueble() {
		LocalDate checkIn = LocalDate.of(2021, 8, 22);
		LocalDate checkOut = LocalDate.of(2021, 8, 23);
		List<Inmueble> busquedaEsperada = new ArrayList<>(Arrays.asList(inmueble1));

		when(sitioWeb.getInmueblesConBusquedaPor("Villa Elisa", checkIn, checkOut, 0, 0.0, 0.0)) // Acá hay que pasarle
																									// valores nulos, no
																									// 0.
				.thenReturn(busquedaEsperada);

		List<Inmueble> resultadoDeLaBusqueda = inquilino.buscarInmuebles("Villa Elisa", checkIn, checkOut, 0, 0.0,
				0.0);

		assertFalse(resultadoDeLaBusqueda.isEmpty());
	}

	@Test
	void testUnInquilinoRealizaUnAlquilerDeUnaListaDeInmuebles() {

		List<Inmueble> listadoDeInmuebles = new ArrayList<>(Arrays.asList(inmueble1));
		inquilino.alquilarInmuebleDeListado(inmueble1, listadoDeInmuebles);

		when(sitioWeb.elInmuebleEstaOcupado(inmueble1)).thenReturn(true);

		assertTrue(inquilino.elSitioRegistraOcupacionDelInmueble(inmueble1));
	}

	@Test
	void test() {

	}

	@Test
	void testUnInquilinoLeDaUnPuntajeAUnInmueble() {
		inquilino.puntuarInmueble(inmueble1, 4, categoriaDePuntaje);

		when(inmueble1.registraPuntajeDe(inquilino)).thenReturn(true);

		assertTrue(inquilino.elInmuebleRegistraPuntajePropio(inmueble1));

	}

	@Test
	void testUnInquilinoLeDaUnPuntajeAUnPropietario() {
	}

}
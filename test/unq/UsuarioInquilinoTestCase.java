package unq;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UsuarioInquilinoTestCase {

	private SitioWeb sitioWeb;
	private Usuario inquilino;
	private Publicacion publicacion1;
	private Publicacion publicacion2;

	@BeforeEach
	void setUp() throws Exception {
		inquilino = new Inquilino("Sergio", "sergio.99@gmail.com", 22759863);
		publicacion1 = new Publicacion(LocalDate.of(2021, 8, 22), LocalDate.of(2021, 8, 23),
				new Inmueble("Villa Elisa"));
		publicacion2 = new Publicacion(LocalDate.of(2021, 7, 22), LocalDate.of(2021, 7, 23), new Inmueble("El Pato"));
		sitioWeb = new SitioWeb();

	}

	@Test
	void testUnUsuarioInquilinoSeRegistraEnElSitioWeb() {
		inquilino.registrarse(sitioWeb);

		assertEquals(inquilino.getSitioWeb(), sitioWeb);
	}

	@Test
	void testUnUsuarioInquilinoAlRealizaBusquedaDeInmueblesEncuentraDentroDeLosOfertadosPorElSitioWeb() {
		LocalDate fechaDeEntrada = LocalDate.of(2021, 8, 22);
		LocalDate fechaDeSalida = LocalDate.of(2021, 8, 23);
		sitioWeb.registrarPublicacion(publicacion1);
		sitioWeb.registrarPublicacion(publicacion2);
		inquilino.registrarse(sitioWeb);

		ArrayList<Inmueble> inmuebles = inquilino.buscarInmuebles("Villa Elisa", fechaDeEntrada, fechaDeSalida);

		Boolean elInquilinoEncuentraInmueblesEnElSitio = !inmuebles.isEmpty();

		assertTrue(elInquilinoEncuentraInmueblesEnElSitio);
	}

	@Test
	void testUnUsuarioInquilinoAlRealizarBusquedaDeInmueblesNOEncuentraNingunoDentroDeLosOfertados() {
		LocalDate fechaDeEntrada = LocalDate.of(2021, 8, 22);
		LocalDate fechaDeSalida = LocalDate.of(2021, 8, 23);
		sitioWeb.registrarPublicacion(publicacion2);
		inquilino.registrarse(sitioWeb);

		ArrayList<Inmueble> inmuebles = inquilino.buscarInmuebles("Villa Elisa", fechaDeEntrada, fechaDeSalida);

		Boolean elInquilinoEncuentraInmueblesEnElSitio = !inmuebles.isEmpty();

		assertFalse(elInquilinoEncuentraInmueblesEnElSitio);
	}

}
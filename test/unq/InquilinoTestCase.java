package unq;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import org.mockito.Mock;

class InquilinoTestCase {

	private SitioWeb sitioWeb;
	private Inquilino inquilino;
	private Propietario propietario;
	private Inmueble inmueble1;
	private Inmueble inmueble2;

	@BeforeEach
	void setUp() throws Exception {
		sitioWeb = new SitioWeb();
		inquilino = new Inquilino("Sergio", "sergio.99@gmail.com", 22759863);
		propietario = mock(Propietario.class);
		inmueble1 = new Inmueble();
		inmueble2 = new Inmueble();
		sitioWeb.registrarUsuario(propietario);
		sitioWeb.registrarUsuario(inquilino);
		propietario.publicarInmueble(inmueble1);
		propietario.publicarInmueble(inmueble2);
	}

	@Test
	void testUnUsuarioInquilinoAlRealizaBusquedaDeInmueblesEncuentraDentroDeLosOfertadosPorElSitioWeb() {
		LocalDate fechaDeEntrada = LocalDate.of(2021, 8, 22);
		LocalDate fechaDeSalida = LocalDate.of(2021, 8, 23);

		ArrayList<Publicacion> resultadoDeLaBusqueda = inquilino.buscarInmuebles("Villa Elisa", fechaDeEntrada, fechaDeSalida, null, null, null, null);
		Boolean elInquilinoEncuentraInmueblesEnElSitio = !resultadoDeLaBusqueda.isEmpty();

		assertTrue(elInquilinoEncuentraInmueblesEnElSitio);
	}

	@Test
	void testUnUsuarioInquilinoAlRealizarBusquedaDeInmueblesNOEncuentraNingunoDentroDeLosOfertados() {
		LocalDate fechaDeEntrada = LocalDate.of(2021, 8, 22);
		LocalDate fechaDeSalida = LocalDate.of(2021, 8, 23);

		ArrayList<Inmueble> inmuebles = inquilino.buscarInmuebles("Villa Elisa", fechaDeEntrada, fechaDeSalida);
		Boolean elInquilinoEncuentraInmueblesEnElSitio = !inmuebles.isEmpty();

		assertFalse(elInquilinoEncuentraInmueblesEnElSitio);
	}

}
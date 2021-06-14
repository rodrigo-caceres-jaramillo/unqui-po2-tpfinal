package entidades;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unq.Inmueble;
import unq.Puntaje;
import unq.Servicio;
import unq.TipoDeInmueble;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class InmuebleTestCase {
	private Inmueble inmueble;
	private TipoDeInmueble tipoDeInmuebleHogar;
	private Servicio servicioDeInmuebleLuz;
	private Servicio servicioDeInmuebleAgua;
	private Puntaje puntaje4Parainmueble;
	private Puntaje puntaje3Parainmueble; 
	
	@BeforeEach
	void setUp() throws Exception {
		inmueble = new Inmueble(); // SUT
		tipoDeInmuebleHogar = mock(TipoDeInmueble.class); // DOT
		servicioDeInmuebleAgua = mock(Servicio.class);
		servicioDeInmuebleLuz = mock(Servicio.class); // DOT
		puntaje4Parainmueble = mock(Puntaje.class);// DOT
		puntaje3Parainmueble = mock(Puntaje.class); // DOT
	}

	@Test
	void testUnInmuebleTieneUnTipoDeInmueblefinido() {

		inmueble.setTipoDeInmueble(tipoDeInmuebleHogar);
		when(tipoDeInmuebleHogar.getNombre()).thenReturn("Hogar");

		String nombreDelTipo = inmueble.getTipoDeInmueble().getNombre();

		assertEquals(nombreDelTipo, "Hogar");
	}

	@Test
	void testUnInmuebleTieneUnaSuperficie() {
		inmueble.setSuperficie(2);
		assertEquals(inmueble.getSuperficie(), 2);

	}

	@Test
	void testUnInmuebleTieneUnPaisDeUbicacion() {
		inmueble.setPais("Argentina");
		assertEquals(inmueble.getPais(), "Argentina");
	}

	@Test
	void testUnInmuebleTieneUnaCiudadDeUbicacion() {
		inmueble.setCiudad("BsAs");
		assertEquals(inmueble.getCiudad(), "BsAs");

	}

	@Test
	void testUnInmuebleTieneUnaDireccionDeUbicacion() {
		inmueble.setDireccion("CalleDeMentira");
		assertEquals(inmueble.getDireccion(), "CalleDeMentira");

	}

	@Test
	void testUnInmuebleNoTieneUnaListaDeServicios() {

		assertTrue(inmueble.getServicios().isEmpty());
	}

	@Test
	void testUnInmuebleTieneUnaListaDeServicios() {
		inmueble.addNuevoServicio(servicioDeInmuebleAgua);
		inmueble.addNuevoServicio(servicioDeInmuebleLuz);

		assertTrue(inmueble.getServicios().contains(servicioDeInmuebleAgua));
		assertTrue(inmueble.getServicios().contains(servicioDeInmuebleLuz));
	}

	@Test
	void testUnInmuebleTieneUnaCapacidadDeInquilinos() {
		inmueble.setCapacidad(5);
		assertEquals(inmueble.getCapacidad(), 5);
	}

	@Test
	void testUnInmuebleNoRegistraUnNuevoPuntaje() {
		assertTrue(inmueble.getPuntajes().isEmpty());
	}

	@Test
	void testUnInmuebleRegistraUnNuevoPuntaje() {
		inmueble.addPuntaje(puntaje4Parainmueble);
		assertTrue(inmueble.getPuntajes().contains(puntaje4Parainmueble));

	}

	@Test
	void testUnInmuebleConocePromedioDePuntajeDeRankeos() {
		inmueble.addPuntaje(puntaje4Parainmueble);
		inmueble.addPuntaje(puntaje3Parainmueble);

		when(puntaje4Parainmueble.getValor()).thenReturn( 4);
		when(puntaje3Parainmueble.getValor()).thenReturn( 3);

		assertEquals(inmueble.getPromedioDePuntajes(), 4, 6);
	}

}

package entidades;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.*;

import java.time.LocalDate;
import java.util.*;
import unq.*;
class InquilinoTestCase {

	private SitioWeb sitio;
	private Usuario inquilino;
	private Inmueble inmueble1;
	private CategoriaDePuntaje categoriaDePuntaje;

	@BeforeEach
	void setUp() throws Exception {
		sitio = mock(SitioWeb.class);
		inquilino = new Usuario("Sergio", "sergio.99@gmail.com", 22759863);
		inmueble1 = mock(Inmueble.class); 				categoriaDePuntaje = mock(CategoriaDePuntaje.class);
		inquilino.registrarseEn(sitio);
	}

	@Test
	void unUsuariQueNoRegistraPubicacionesEsInquilino() {
		when(sitio.contienePublicacionesDe(inquilino)).thenReturn(false);
		assertTrue(inquilino.esInquilino() );
		assertFalse(inquilino.esPropietario() );
		}
		
	
	
	@Test
	void testUnInquilinoRealizaUnaBusquedaInmuebleConDatosObligatoriosNoEncuentraNinguno() {
		LocalDate checkIn = LocalDate.of(2021, 8, 22);
		LocalDate checkOut = LocalDate.of(2021, 8, 23);
		ParametrosBusqueda paramBusqueda = new ParametrosBusqueda("Buenos Aires", checkIn, checkOut, null, null, null);

		when(sitio.buscarInmueble(paramBusqueda)).thenReturn(new ArrayList<Inmueble>());

		List<Inmueble> resultadoDeLaBusqueda = inquilino.buscarInmuebles(paramBusqueda);
		verify(sitio,times(1)).buscarInmueble( paramBusqueda); 
		assertTrue(resultadoDeLaBusqueda.isEmpty());
	}

	@Test
	void testUnInquilinoRealizaUnaBusquedaConDatosObligatoriosEncuentraUnInmueble() {
		LocalDate checkIn = LocalDate.of(2021, 8, 22);
		LocalDate checkOut = LocalDate.of(2021, 8, 23);
		ParametrosBusqueda paramBusqueda = new ParametrosBusqueda("Buenos Aires", checkIn, checkOut, null, null, null);

		when(inmueble1.getCiudad()).thenReturn("Buenos Aires");

		List<Inmueble> inmueblesEsperados = new ArrayList<Inmueble>(); inmueblesEsperados.add(inmueble1);

		when(sitio.buscarInmueble(paramBusqueda)).thenReturn(inmueblesEsperados);

		List<Inmueble> resultadoDeLaBusqueda = inquilino.buscarInmuebles(paramBusqueda);

		verify(sitio,times(1)).buscarInmueble( paramBusqueda); 
	
		assertFalse(resultadoDeLaBusqueda.isEmpty());
	}

	@Test
	void testUnInquilinoRealizaUnaReservaDeUnaListaDeInmuebles() {
		Publicacion publicacion = mock(Publicacion.class);
		
		LocalDate checkIn = LocalDate.of(2021, 8, 22);
		LocalDate checkOut = LocalDate.of(2021, 8, 23);
		
		 inquilino.reservarInmueble( publicacion, FormasDePagoEnum.EFECTIVO,  checkIn, checkOut);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
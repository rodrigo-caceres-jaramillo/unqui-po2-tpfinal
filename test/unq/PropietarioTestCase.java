package unq;

/* 

//**
 * publicarInmueble(): listo
 
+ puntuarInquilino(Inquilino, int, String): 
+ aceptarReserva(Reserva):
+ informacionPropia():
A su vez, para un inmueble, el usuario podrá visualizar también la
información propia del dueño, el puntaje que otros usuarios le han dado a él mismo
y el puntaje promedio que ha obtenido.
+ bajarPrecioAPublicidadCon(Publicidad, double):
*/
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PropietarioTestCase {
	private SitioWeb sitio;
	private Propietario usuarioPropietario;

	@BeforeEach
	public void setUp() throws Exception {
		usuarioPropietario = new Propietario("ejemplin", "ejemplo@jexample.com", 42356769);
		sitio = mock(SitioWeb.class);

	}

	@Test
	void testUnPropietarioConoceSusDatosPersonales() {

		assertEquals(usuarioPropietario.getMail(), "ejemplo@jexample.com");
		assertEquals(usuarioPropietario.getNombre(), "ejemplin");
		assertEquals(usuarioPropietario.getTelefono(), 42356769);

	}

	

//	@Test
//	void testPropietarioRealizaUnaPublicacionAlSitio() {
//		usuarioPropietario.crearPublicacion(publicacion);
//
//		List<Publicacion> publicacionesEsperadas = new ArrayList<Publicacion>();
//		publicacionesEsperadas.add(publicacion);
//
//		when(sitio.getPublicacionesDe(usuarioPropietario)).thenReturn(publicacionesEsperadas);
//
//		List<Publicacion> publicacionesDelPropietario = usuarioPropietario.publicacionesEnElSitio();
//
//		assertTrue(publicacionesDelPropietario.contains(publicacion));
//	}
//
//	@Test
//	void testUnPropietarioEstableceUnMedioDePagoAUnaPublicacion() {
//		FormasDePagoEnum efectivo = FormasDePagoEnum.EFECTIVO;
//		usuarioPropietario.medioDePagoPara(publicacion, efectivo);
//		usuarioPropietario.añadirPublicacion(publicacion);
//
//		when(sitio.registraPubliDeUsuarioConFormaDePago(usuarioPropietario, efectivo)).thenReturn(true);
//
//		assertTrue(usuarioPropietario.algunaPublicacionConPago(efectivo));
//
//	}

//	@Test
//	void testUnPropietarioBajaPrecioAUnaPublicacionDeInmueble() {
//		when(publicacion.getPrecio()).thenReturn(100.0);
//		usuarioPropietario.bajarPrecioAPublicacionCon(publicacion, 0);
//
//		assertEquals(publicacion.getPrecio(), 100.0);
//	}

}

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

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

class PropietarioTestCase {
	private SitioWeb sitio;
	private Propietario usuarioPropietario;
	private Inmueble inmueble;
	private Publicacion publicacion;

	@BeforeEach
	public void setUp() throws Exception {
		usuarioPropietario = new Propietario("ejemplin", "ejemplo@jexample.com", 42356769);
		inmueble = mock(Inmueble.class);
		publicacion = mock(Publicacion.class);
		sitio = mock(SitioWeb.class);

		usuarioPropietario.registrarse(sitio);

	}

	@Test
	void testUnPropietarioSeRegistraEnElSitioWeb() {
		assertEquals(usuarioPropietario.getSitioWeb(), sitio);
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

	@Test
	void testUnPropietarioBajaPrecioAUnaPublicacionDeInmueble() {
		when(publicacion.getPrecio()).thenReturn(100.0);
		usuarioPropietario.bajarPrecioAPublicacionCon(publicacion, 0);

		assertEquals(publicacion.getPrecio(), 100.0);
	}

}

package entidades;

import static org.junit.Assert.assertFalse;
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
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unq.*;
class PropietarioTestCase {

	private Usuario usuarioPropietario;
	private SitioWeb sitio;
	private Publicacion publicacion;

	@BeforeEach
	public void setUp() throws Exception {
		usuarioPropietario = new Usuario("ejemplin", "ejemplo@jexample.com", 42356769);
		sitio = mock(SitioWeb.class);
		publicacion = mock(Publicacion.class);
		usuarioPropietario.registrarseEn(sitio);

	}

	@Test
	void testUnUsuarioNoEsPropietarioNoTienePublicacionesRealizada() {
		when(sitio.contienePublicacionesDe(usuarioPropietario)).thenReturn(false);

		assertFalse(usuarioPropietario.esPropietario() );
	}
	@Test
	void testUnUsuarioEsPropietarioSiTieneAlMenosUnaPublicacionRealizada() {
		

		when(sitio.contienePublicacionesDe(usuarioPropietario)).thenReturn(true);
	
		assertTrue(usuarioPropietario.esPropietario() );
	}
	
	
	@Test
	void testPropietarioRealizaUnaPublicacionAlSitio() {
		List <Publicacion>publisEsperadas = new ArrayList<Publicacion>(); publisEsperadas.add(publicacion);
		usuarioPropietario.agregarPublicacion(publicacion);
		when(sitio.getPublicacionesDe(usuarioPropietario)).thenReturn(publisEsperadas);
		
		assertTrue(usuarioPropietario.misPublicaciones().contains(publicacion)  );
				
	
	}
	
	@Test 
	void testPropietarioEstableceUnMedioDePagoParaUnaPublicacion() {
		Publicacion publi = new Publicacion();

		usuarioPropietario.medioDePagoPara(publi,FormasDePagoEnum.TARJETADECREDITO);
		
		assertTrue(publi.aceptaFormaDePago(FormasDePagoEnum.TARJETADECREDITO));
	}

	@Test
	void testUnPropietarioBajaPrecioAUnaPublicacionDeInmueble() {
		publicacion.setPrecio(100.0);

		usuarioPropietario.agregarPublicacion(publicacion);
		usuarioPropietario.bajarPrecioAPublicacion(publicacion, 0.0);

		assertEquals(publicacion.getPrecio(), 0.0);
	}
	
}

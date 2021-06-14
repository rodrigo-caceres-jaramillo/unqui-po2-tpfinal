package entidades;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unq.Administrador;
import unq.AdministradorPublicacion;
import unq.AdministradorUsuario;
import unq.CategoriaDePuntaje;
import unq.FormasDePagoEnum;
import unq.Inmueble;
import unq.Inquilino;
import unq.Propietario;
import unq.Publicacion;
import unq.Servicio;
import unq.SitioWeb;
import unq.TipoDeInmueble;

class SitioWebTestCase {
	private SitioWeb sitio;
	private Inquilino usuario1;
	private Propietario usuario2;
	private Administrador admin;


	@BeforeEach
	public void setUp() throws Exception {
		sitio = new SitioWeb();
		sitio.setAdminPublicacion(new AdministradorPublicacion());
		sitio.setAdminUsuario(new AdministradorUsuario());
		usuario1 = mock(Inquilino.class);
		usuario2 = mock(Propietario.class);
		admin = mock(Administrador.class);

	}

	@Test
	void testUnSitioWebPuedeRegistrarUsuarios() {
		sitio.registrarUsuario(usuario1);
		sitio.registrarUsuario(usuario2);
		assertEquals(2, sitio.getUsuarios().size());

	}

	@Test
	void testUnSitioWebPuedeAgregarUnAdministrador() {
		sitio.registrarAdministrador(admin);
		assertEquals(sitio.getAdministrador(), admin);
	}

	@Test
	void testUnSitioWebNoRegistraPublicaciones() {
		assertTrue(sitio.getPublicaciones().isEmpty());
	}

	@Test
	void testUnSitioWebRegistraUnaPublicacion() {
		Publicacion publi = mock(Publicacion.class);

		sitio.agregarPublicacion(publi);

		assertFalse(sitio.getPublicaciones().isEmpty());

	}

	@Test
	void testUnSitioNoTieneCategoriasDeRankeo() {
		assertTrue(sitio.getCategoriasDePuntaje().isEmpty());

	}

	@Test
	void testUnSitioRegistraUnaCategoriaDeRankeo() {
		CategoriaDePuntaje categoria = mock(CategoriaDePuntaje.class);

		sitio.agregarCategoriaDePuntaje(categoria);
		assertFalse(sitio.getCategoriasDePuntaje().isEmpty());
		assertTrue(sitio.getCategoriasDePuntaje().contains(categoria));

	}

	@Test
	void testUnSitioWebNotieneNingunTipoDeInmuebles() {

		assertTrue(sitio.getTiposDeInmuebles().isEmpty());
	}

	@Test
	void testUnSitioWebRegistraUnTipoDeInmuebles() {
		TipoDeInmueble tipo = mock(TipoDeInmueble.class);
		sitio.agregarTipoDeInmueble(tipo);
		assertFalse(sitio.getTiposDeInmuebles().isEmpty());
	}

	@Test
	void testUnSitoWebAgregaUnTipoDeServicioParaInmuebles() {
		Servicio tipoServicio = mock(Servicio.class);
		sitio.agregarTipoDeServicio(tipoServicio);
		assertFalse(sitio.getTiposDeServicios().isEmpty());

	}

	@Test
	void testUnSitioWebRegistraUnInmuebleGenerandoUnaPublicacion() {
		Inmueble inmueble = mock(Inmueble.class);
		sitio.registrarInmueble(usuario2, inmueble);

		assertFalse(sitio.getPublicaciones().isEmpty());

	}

	@Test
	void testUnSitioWebGeneraUnaBusquedaDeInmueblesQueNoMatchean() {
		Inmueble inmueble = mock(Inmueble.class);

		LocalDate checkIn = LocalDate.parse("2000-10-15");
		LocalDate checkOut = LocalDate.parse("2000-10-20");

		Publicacion publi = mock(Publicacion.class);
		when(publi.cumpleConEspecificaciones("BuenosAires", checkIn, checkOut, 2, 1.00, 2.00)).thenReturn(false);

		sitio.agregarPublicacion(publi);

		ArrayList<Inmueble> inmueblesEncontrados = sitio.getInmueblesConBusquedaPor("BuenosAires", checkIn, checkOut, 2,
				1.00, 2.00);
		assertTrue(!inmueblesEncontrados.contains(inmueble));
	}

	@Test
	void testUnSitioWebGeneraUnaBusquedaEnPublicacionesDeInmueblesQueMatchean() {
		Inmueble inmueble = mock(Inmueble.class);

		LocalDate checkIn = LocalDate.parse("2000-10-15");
		LocalDate checkOut = LocalDate.parse("2000-10-20");

		Publicacion publi = mock(Publicacion.class);
		when(publi.cumpleConEspecificaciones("BuenosAires", checkIn, checkOut, 2, 1.00, 2.00)).thenReturn(true);
		when(publi.getInmueble()).thenReturn(inmueble);

		sitio.agregarPublicacion(publi);

		ArrayList<Inmueble> inmueblesEncontrados = sitio.getInmueblesConBusquedaPor("BuenosAires", checkIn, checkOut, 2,
				1.00, 2.00);
		assertTrue(inmueblesEncontrados.contains(inmueble));
	}

	@Test
	void testUnSitioWebGeneraUnaBusquedaDePublicacionesDeUsuario() {
		Publicacion publi = mock(Publicacion.class);
		when(publi.getPropietario()).thenReturn(usuario2);
		//when(publi.getPropietario().equals(usuario2)).thenReturn(true);
		sitio.agregarPublicacion(publi);

		List<Publicacion> publicacionesDeUsuario = sitio.getPublicacionesDe(usuario2);

		assertTrue(publicacionesDeUsuario.contains(publi));
	}

	@Test
	void testUnSitioWebConoceQueUnUsuarioNoPublicoUnaPublicacion() {
		Publicacion publi = mock(Publicacion.class);
		when(publi.getPropietario()).thenReturn(usuario2);
		
		sitio.agregarPublicacion(publi);
		
		assertFalse(sitio.elUsuarioPublico(publi, usuario1));

	}

	@Test
	void testUnSitioWebConoceQueUnUsuarioPublicoUnaPublicacion() {
		Publicacion publi = mock(Publicacion.class);
		when(publi.getPropietario()).thenReturn(usuario2);
		
		sitio.agregarPublicacion(publi);
		
		assertTrue(sitio.elUsuarioPublico(publi, usuario2));
	}

	@Test
	void testUnSitioWebConceSiUnaPublicacionRegistraAlgunMetodoDePago() {
		Publicacion publi = mock(Publicacion.class);
		when(publi.aceptaFormaDePago(FormasDePagoEnum.TARJETADECREDITO)).thenReturn(true);
		//when(publi.esDelUsuario(usuario2)).thenReturn(true);
		when(publi.getPropietario()).thenReturn(usuario2);
		sitio.agregarPublicacion(publi);
		
		assertTrue(sitio.registraPubliDeUsuarioConFormaDePago(usuario2, FormasDePagoEnum.TARJETADECREDITO));
	}

	@Test
	void testUnSitioWebNoPuedeActualizarUnPrecioDePublicacion() {
		Publicacion publi = mock(Publicacion.class);

		//when(publi.esDelUsuario(usuario2)).thenReturn(false);
		sitio.agregarPublicacion(publi);

		// (sitio.actualizarPrecioDePublicacion(publi, 100),"error: no podés bajar
		// precio de una publicación que no es tuya");

	}
	
	
}

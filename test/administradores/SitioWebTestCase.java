package administradores;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unq.Administrador;
import unq.AdministradorPublicacion;
import unq.AdministradorUsuario;
import unq.FormasDePagoEnum;
import unq.Inmueble;
import unq.Inquilino;
import unq.ParametrosBusqueda;
import unq.Propietario;
import unq.Publicacion;
import unq.SitioWeb;
import unq.TipoDeInmueble;

class SitioWebTestCase {
	private SitioWeb sitio;
	private Inquilino inquilino;
	private Propietario propietario;
	private Administrador admin;

	@BeforeEach
	public void setUp() throws Exception {
		sitio = new SitioWeb();
		sitio.setAdminPublicacion(new AdministradorPublicacion());
		sitio.setAdminUsuario(new AdministradorUsuario());
		inquilino = mock(Inquilino.class);
		propietario = mock(Propietario.class);
		admin = mock(Administrador.class);

	}

	@Test
	void testUnSitioWebPuedeRegistrarUsuarios() {
		sitio.addUsuario(inquilino);
		sitio.addUsuario(propietario);
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

		sitio.addPublicacion(publi);

		assertFalse(sitio.getPublicaciones().isEmpty());

	}

//	@Test
//	void testUnSitioNoTieneCategoriasDeRankeo() {
//		assertTrue(sitio.getCategoriasDeRankeo().isEmpty());
//
//	}

//	@Test
//	void testUnSitioRegistraUnaCategoriaDeRankeo() {
//		CategoriaDeRankeo categoria = mock(CategoriaDeRankeo.class);
//
//		sitio.agregarCategoriaDeRankeo(categoria);
//		assertFalse(sitio.getCategoriasDeRankeo().isEmpty());
//		assertTrue(sitio.getCategoriasDeRankeo().contains(categoria));
//
//	}

	@Test
	void testUnSitioWebNotieneNingunTipoDeInmuebles() {

		assertTrue(sitio.getTiposDeInmuebles().isEmpty());
	}

	@Test
	void testUnSitioWebRegistraUnTipoDeInmuebles() {
		TipoDeInmueble tipo = mock(TipoDeInmueble.class);
		sitio.addTipoDeInmueble(tipo);
		assertFalse(sitio.getTiposDeInmuebles().isEmpty());
	}

//	@Test
//	void testUnSitoWebAgregaUnTipoDeServicioParaInmuebles() {
//		TipoDeServicio tipoServicio = mock(TipoDeServicio.class);
//		sitio.agregarTipoDeServicio(tipoServicio);
//		assertFalse(sitio.getTiposDeServicios().isEmpty());
//
//	}

	@Test
	void testUnSitioWebRegistraUnInmuebleGenerandoUnaPublicacion() {
		Publicacion publicacion = mock(Publicacion.class);
		Inmueble inmueble = mock(Inmueble.class);
		when(publicacion.getInmueble()).thenReturn(inmueble);
		
		sitio.addPublicacion(publicacion);
		
		Publicacion publiSitio = sitio.getPublicaciones().get(0);

		assertFalse(sitio.getPublicaciones().isEmpty());
		assertEquals(publiSitio.getInmueble(), inmueble);

	}

	@Test
	void testSitioWebBusquedaDeInmueblesEncontradosConParametrosObligatorios() {
		LocalDate checkIn = LocalDate.of(2021, 5, 10);
		LocalDate checkOut = LocalDate.of(2021, 5, 16);
		LocalDate checkIn2 = LocalDate.of(2021, 5, 24);
		LocalDate checkOut2 = LocalDate.of(2021, 5, 25);
		ParametrosBusqueda paramBusqueda = new ParametrosBusqueda("Buenos Aires", checkIn, checkOut);

		Inmueble inmueble1 = mock(Inmueble.class);
		Inmueble inmueble2 = mock(Inmueble.class);
		Inmueble inmueble3 = mock(Inmueble.class);

		when(inmueble1.getCiudad()).thenReturn("Buenos Aires");
		when(inmueble2.getCiudad()).thenReturn("Rio Negro");
		when(inmueble3.getCiudad()).thenReturn("Buenos Aires");

		Publicacion publicacion1 = new Publicacion(propietario, inmueble1, checkIn, checkOut, 100.0);
		Publicacion publicacion2 = new Publicacion(propietario, inmueble2, checkIn2, checkOut2, 101.0);
		Publicacion publicacion3 = new Publicacion(propietario, inmueble3, checkIn, checkOut, 100.0);

		sitio.addPublicacion(publicacion1);
		sitio.addPublicacion(publicacion2);
		sitio.addPublicacion(publicacion3);

		List<Inmueble> inmueblesFiltrados = sitio.buscarInmueble(paramBusqueda);

		assertEquals(inmueblesFiltrados.size(), 2); // Deberia ser Inmueble 1 e Inmueble 3
		assertTrue(inmueblesFiltrados.contains(inmueble1));
		// assertTrue(inmueblesFiltrados.contains(inmueble3));
	}

	@Test
	void testSitioWebBusquedaDeInmueblesEncontradosConTodosLosParametros() {
		LocalDate checkIn = LocalDate.of(2021, 5, 10);
		LocalDate checkOut = LocalDate.of(2021, 5, 16);
		LocalDate checkIn2 = LocalDate.of(2021, 5, 24);
		LocalDate checkOut2 = LocalDate.of(2021, 5, 25);
		ParametrosBusqueda paramBusqueda = new ParametrosBusqueda("Buenos Aires", checkIn2, checkOut2, 2, 100.0, 200.0);

		Inmueble inmueble1 = mock(Inmueble.class);
		Inmueble inmueble2 = mock(Inmueble.class);
		Inmueble inmueble3 = mock(Inmueble.class);

		when(inmueble1.getCiudad()).thenReturn("Buenos Aires");
		when(inmueble1.getCapacidad()).thenReturn(2);
		when(inmueble2.getCiudad()).thenReturn("Rio Negro");
		when(inmueble2.getCapacidad()).thenReturn(4);
		when(inmueble3.getCiudad()).thenReturn("Buenos Aires");
		when(inmueble3.getCapacidad()).thenReturn(2);

		Publicacion publicacion1 = new Publicacion(propietario, inmueble1, checkIn2, checkOut2, 100.0);
		Publicacion publicacion2 = new Publicacion(propietario, inmueble2, checkIn, checkOut, 101.0);
		Publicacion publicacion3 = new Publicacion(propietario, inmueble3, checkIn, checkOut, 100.0);

		sitio.addPublicacion(publicacion1);
		sitio.addPublicacion(publicacion2);
		sitio.addPublicacion(publicacion3);

		List<Inmueble> inmueblesFiltrados = sitio.buscarInmueble(paramBusqueda);

		assertEquals(inmueblesFiltrados.size(), 1); // Inmueble 1
		assertTrue(inmueblesFiltrados.contains(inmueble1));

	}

	@Test
	void testSitioWebBusquedaInmuebleConParamObligatoriosNoEncontrados() {
		LocalDate checkIn = LocalDate.of(2021, 5, 10);
		LocalDate checkOut = LocalDate.of(2021, 5, 16);
		LocalDate checkIn2 = LocalDate.of(2021, 5, 24);
		LocalDate checkOut2 = LocalDate.of(2021, 5, 25);
		ParametrosBusqueda paramBusqueda = new ParametrosBusqueda("Buenos Aires", checkIn, checkOut);

		Inmueble inmueble1 = mock(Inmueble.class);
		Inmueble inmueble2 = mock(Inmueble.class);

		when(inmueble1.getCiudad()).thenReturn("Buenos Aires");
		when(inmueble1.getCapacidad()).thenReturn(2);
		when(inmueble2.getCiudad()).thenReturn("Rio Negro");
		when(inmueble2.getCapacidad()).thenReturn(4);

		Publicacion publicacion1 = new Publicacion(propietario, inmueble1, checkIn2, checkOut2, 100.0);
		Publicacion publicacion2 = new Publicacion(propietario, inmueble2, checkIn2, checkOut2, 101.0);

		sitio.addPublicacion(publicacion1);
		sitio.addPublicacion(publicacion2);

		List<Inmueble> inmueblesFiltrados = sitio.buscarInmueble(paramBusqueda);

		assertTrue(inmueblesFiltrados.isEmpty()); // Ningun inmueble encontrado

	}

	@Test
	void testUnSitioWebGeneraUnaBusquedaDePublicacionesDeUsuario() {
		Publicacion publi = mock(Publicacion.class);
		when(publi.getPropietario()).thenReturn(propietario);
		// when(publi.getPropietario().equals(usuario2)).thenReturn(true);
		sitio.addPublicacion(publi);

		List<Publicacion> publicacionesDeUsuario = sitio.getPublicacionesDe(propietario);

		assertTrue(publicacionesDeUsuario.contains(publi));
	}

	@Test
	void testUnSitioWebConoceQueUnUsuarioNoPublicoUnaPublicacion() {
		Publicacion publi = mock(Publicacion.class);
		when(publi.getPropietario()).thenReturn(propietario);

		sitio.addPublicacion(publi);

		assertFalse(sitio.elUsuarioPublico(publi, inquilino));

	}

	@Test
	void testUnSitioWebConoceQueUnUsuarioPublicoUnaPublicacion() {
		Publicacion publi = mock(Publicacion.class);
		when(publi.getPropietario()).thenReturn(propietario);

		sitio.addPublicacion(publi);

		assertTrue(sitio.elUsuarioPublico(publi, propietario));
	}

	@Test
	void testUnSitioWebConoceSiUnaPublicacionRegistraAlgunMetodoDePago() {
		Publicacion publi = mock(Publicacion.class);
		when(publi.aceptaFormaDePago(FormasDePagoEnum.TARJETADECREDITO)).thenReturn(true);
		// when(publi.esDelUsuario(usuario2)).thenReturn(true);
		when(publi.getPropietario()).thenReturn(propietario);
		sitio.addPublicacion(publi);

		assertTrue(sitio.registraPubliDeUsuarioConFormaDePago(propietario, FormasDePagoEnum.TARJETADECREDITO));
	}

	@Test
	void testSitioWebPublicacionesAceptanTodosLosMediosDePago() {
		Publicacion publi1 = new Publicacion();
		Publicacion publi2 = new Publicacion();

		publi1.addMediosDePagoAll();
		publi2.addMediosDePagoAll();

		assertFalse(publi1.getFormasDePago().isEmpty());
		assertFalse(publi2.getFormasDePago().isEmpty());
	}
	
	@Test
	void testSitioWebActualizarPrecioDePublicacion() {
		
		Publicacion publicacion = new Publicacion();
		publicacion.setPrecio(100.0);
			
		sitio.addPublicacion(publicacion);
		sitio.actualizarPrecioDePublicacion(publicacion, 120.0);
		
		assertEquals(publicacion.getPrecio(), 120.0);
	}

	@Test
	void testUnSitioWebNoPuedeActualizarUnPrecioDePublicacion() {
		Publicacion publi = mock(Publicacion.class);

		// when(publi.esDelUsuario(usuario2)).thenReturn(false);
		sitio.addPublicacion(publi);

		// (sitio.actualizarPrecioDePublicacion(publi, 100),"error: no podés bajar
		// precio de una publicación que no es tuya");

	}

}

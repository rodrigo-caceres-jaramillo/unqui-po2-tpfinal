package administradores;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unq.AdministradorPublicacion;
import unq.Inmueble;
import unq.ParametrosBusqueda;
import unq.Publicacion;
import unq.SitioWeb;
import unq.Usuario;

class AdministradorPublicacionTestCase {

	AdministradorPublicacion adminPublicacion;
	Usuario propietario;
	SitioWeb sitio;

	@BeforeEach
	void setUp() throws Exception {
		adminPublicacion = new AdministradorPublicacion();
		propietario = mock(Usuario.class);
		sitio = mock(SitioWeb.class);
	}

	@Test
	void testAdministradorDePublicacionNoTienePublicaciones() {

		assertTrue(adminPublicacion.getPublicaciones().isEmpty());
	}

	@Test
	void testAdministradorDePublicacionTienePublicaciones() {
		Publicacion publicacion = new Publicacion();

		adminPublicacion.agregar(publicacion);

		assertEquals(adminPublicacion.cantidadPublicaciones(), 1);
	}

	@Test
	void testAdministradorPublicacionObtienePublicacionesDeUnPropietario() {
		Publicacion publicacion = mock(Publicacion.class);
		when(publicacion.getPropietario()).thenReturn(propietario);

		when(sitio.elUsuarioPublico(publicacion, propietario)).thenReturn(true);

		adminPublicacion.agregar(publicacion);

		List<Publicacion> publicacionesUsuario = adminPublicacion.obtenerPublicacionesDelUsuario(propietario);

		assertEquals(publicacionesUsuario.size(), 1);
	}

	@Test
	void testAdministradorDePublicacionesBuscaPublicacionesDadosParametrosObligatorios() {
		Publicacion publicacion = mock(Publicacion.class);
		Publicacion publicacion2 = mock(Publicacion.class);
		ParametrosBusqueda paramBusq = new ParametrosBusqueda("Buenos Aires", LocalDate.of(2021, 6, 12),
				LocalDate.of(2021, 6, 16));
		Inmueble inmueble = mock(Inmueble.class);
		Inmueble inmueble2 = mock(Inmueble.class);

		when(inmueble.getCiudad()).thenReturn("Buenos Aires");
		when(inmueble2.getCiudad()).thenReturn("La Pampa");

		when(publicacion.getInmueble()).thenReturn(inmueble);
		when(publicacion.getCheckIn()).thenReturn(LocalDate.of(2021, 6, 12));
		when(publicacion.getCheckOut()).thenReturn(LocalDate.of(2021, 6, 16));

		when(publicacion2.getInmueble()).thenReturn(inmueble2);
		when(publicacion2.getCheckIn()).thenReturn(LocalDate.of(2021, 6, 1));
		when(publicacion2.getCheckOut()).thenReturn(LocalDate.of(2021, 6, 3));

		adminPublicacion.agregar(publicacion);
		adminPublicacion.agregar(publicacion2);

		List<Publicacion> publicaciones = adminPublicacion.buscar(paramBusq);

		assertEquals(publicaciones.size(), 1);
		assertTrue(publicaciones.contains(publicacion));
	}

	@Test
	void testAdministradorDePublicacionesBuscaPublicacionesConTodosLosDatosDeParametros() {
		Inmueble inmueble = mock(Inmueble.class);
		Inmueble inmueble2 = mock(Inmueble.class);
		when(inmueble.getCiudad()).thenReturn("Buenos Aires");
		when(inmueble2.getCiudad()).thenReturn("La Plata");

		Publicacion publicacion = new Publicacion(propietario, inmueble, LocalDate.of(2021, 6, 12),
				LocalDate.of(2021, 6, 16), 150.0);
		Publicacion publicacion2 = new Publicacion(propietario, inmueble2, LocalDate.of(2021, 6, 12),
				LocalDate.of(2021, 6, 16), 101.0);

		ParametrosBusqueda paramBusq = new ParametrosBusqueda("Buenos Aires", LocalDate.of(2021, 6, 12),
				LocalDate.of(2021, 6, 16), 4, 100.0, 200.0);

		adminPublicacion.agregar(publicacion);
		adminPublicacion.agregar(publicacion2);

		List<Publicacion> publicaciones = adminPublicacion.buscar(paramBusq);

		assertEquals(publicaciones.size(), 1);
		assertTrue(publicaciones.contains(publicacion));

	}

	@Test
	void testAdministradorPublicacionesBuscaPublicacionesConParamObligatoriosYCantHuespedesYRestoNulos() {
		Inmueble inmueble = mock(Inmueble.class);
		when(inmueble.getCiudad()).thenReturn("Buenos Aires");

		Publicacion publicacion = new Publicacion(propietario, inmueble, LocalDate.of(2021, 6, 12),
				LocalDate.of(2021, 6, 16), 150.0);
		Publicacion publicacion2 = new Publicacion(propietario, inmueble, LocalDate.of(2021, 6, 12),
				LocalDate.of(2021, 6, 16), 150.0);

		ParametrosBusqueda paramBusq = new ParametrosBusqueda("Buenos Aires", LocalDate.of(2021, 6, 12),
				LocalDate.of(2021, 6, 16), 4, null, null);

		adminPublicacion.agregar(publicacion);
		adminPublicacion.agregar(publicacion2);

		List<Publicacion> publicaciones = adminPublicacion.buscar(paramBusq);

		assertEquals(publicaciones.size(), 2);
		assertTrue(publicaciones.contains(publicacion));
		assertTrue(publicaciones.contains(publicacion2));
	}

	@Test
	void testAdministradorPublicacionesBuscaPublicacionesConParamObligYPrecioMinYMax() {
		Inmueble inmueble = mock(Inmueble.class);
		when(inmueble.getCiudad()).thenReturn("Buenos Aires");

		Publicacion publicacion = new Publicacion(propietario, inmueble, LocalDate.of(2021, 6, 12),
				LocalDate.of(2021, 6, 16), 150.0);
		Publicacion publicacion2 = new Publicacion(propietario, inmueble, LocalDate.of(2021, 6, 12),
				LocalDate.of(2021, 6, 16), 150.0);

		ParametrosBusqueda paramBusq = new ParametrosBusqueda("Buenos Aires", LocalDate.of(2021, 6, 12),
				LocalDate.of(2021, 6, 16), null, 100.0, 200.0);

		adminPublicacion.agregar(publicacion);
		adminPublicacion.agregar(publicacion2);

		List<Publicacion> publicaciones = adminPublicacion.buscar(paramBusq);

		assertEquals(publicaciones.size(), 2);
		assertTrue(publicaciones.contains(publicacion));
		assertTrue(publicaciones.contains(publicacion2));
	}

	@Test
	void testAdministradorDePublicacionesBuscaPublicacionesYNoEncuentraNingunaQueCoincida() {
		Publicacion publicacion = mock(Publicacion.class);
		Publicacion publicacion2 = mock(Publicacion.class);
		ParametrosBusqueda paramBusq = new ParametrosBusqueda("Caballito", LocalDate.of(2021, 9, 12),
				LocalDate.of(2021, 9, 16));
		Inmueble inmueble = mock(Inmueble.class);
		Inmueble inmueble2 = mock(Inmueble.class);

		when(inmueble.getCiudad()).thenReturn("Buenos Aires");
		when(inmueble2.getCiudad()).thenReturn("La Pampa");

		when(publicacion.getInmueble()).thenReturn(inmueble);
		when(publicacion.getCheckIn()).thenReturn(LocalDate.of(2021, 6, 12));
		when(publicacion.getCheckOut()).thenReturn(LocalDate.of(2021, 6, 16));

		when(publicacion2.getInmueble()).thenReturn(inmueble2);
		when(publicacion2.getCheckIn()).thenReturn(LocalDate.of(2021, 6, 1));
		when(publicacion2.getCheckOut()).thenReturn(LocalDate.of(2021, 6, 3));

		adminPublicacion.agregar(publicacion);
		adminPublicacion.agregar(publicacion2);

		List<Publicacion> publicaciones = adminPublicacion.buscar(paramBusq);

		assertTrue(publicaciones.isEmpty());
	}

	@Test
	void testAdministradorPublicacionesBajaElPrecioAUnaDeSusPublicaciones() {
		Publicacion publicacion = mock(Publicacion.class);

		adminPublicacion.agregar(publicacion);
		adminPublicacion.actualizarPrecio(publicacion, 200.0);

		verify(publicacion, times(1)).actualizarPrecio(200.0);
		//verifico que al menos una vez le hayan pedido a la publicación que se actualice el precio a 200

}
	
	
	
	
	
}
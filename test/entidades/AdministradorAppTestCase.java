package entidades;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
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

class AdministradorAppTestCase {

	AdministradorPublicacion adminApp;
	SitioWeb sitioWeb;
	Usuario propietario;
	Inmueble inmueble;
	Publicacion publicacion1;
	Publicacion publicacion2;
	ParametrosBusqueda paramBusqueda;

	@BeforeEach
	void setUp() throws Exception {
		LocalDate checkIn = LocalDate.of(2021, 6, 12);
		LocalDate checkOut = LocalDate.of(2021, 6, 16);

		adminApp = new AdministradorPublicacion();
		sitioWeb = mock(SitioWeb.class);
		propietario = mock(Usuario.class);
		inmueble = mock(Inmueble.class);
		paramBusqueda = mock(ParametrosBusqueda.class);
		publicacion1 = mock(Publicacion.class);
		publicacion2 = mock(Publicacion.class);

		publicacion1 = new Publicacion(propietario, inmueble, checkIn, checkOut, 120.0);
		publicacion2 = new Publicacion(propietario, inmueble, checkIn, checkOut, 220.0);

	}

	@Test
	void testUnAdministradorDeAppLePasanPublicacionesParaFiltrar() {

		adminApp.añadirPublicacion(publicacion1);
		adminApp.añadirPublicacion(publicacion2);

		assertEquals(adminApp.cantidadPublicaciones(), 2);
	}

	@Test
	void testUnAdministradorAppFiltraPublicacionesDeAcuerdoALosParametrosObligatoriosCiudad() {

		LocalDate checkIn = LocalDate.of(2021, 6, 12);
		LocalDate checkOut = LocalDate.of(2021, 6, 16);

		when(inmueble.getCiudad()).thenReturn("Buenos Aires");

		publicacion1 = new Publicacion(propietario, inmueble, LocalDate.of(2021, 6, 20), LocalDate.of(2021, 6, 25),
				120.0);

		adminApp.añadirPublicacion(publicacion1);
		adminApp.añadirPublicacion(publicacion2);

		paramBusqueda = new ParametrosBusqueda("Buenos Aires", checkIn, checkOut);

		List<Publicacion> publisFiltradas = adminApp.buscar(paramBusqueda);

		assertTrue(publisFiltradas.contains(publicacion2));
		assertEquals(publisFiltradas.size(), 1);

	}

	@Test
	void testUnAdministradorAppFiltraPublicacionesDeAcuerdoAParametrosSobreElPrecio() {
		LocalDate checkIn = LocalDate.of(2021, 6, 12);
		LocalDate checkOut = LocalDate.of(2021, 6, 16);

		when(inmueble.getCiudad()).thenReturn("Buenos Aires");

		Publicacion publicacion1 = new Publicacion(propietario, inmueble, LocalDate.of(2021, 6, 20),
				LocalDate.of(2021, 6, 25), 120.0);

		adminApp.añadirPublicacion(publicacion1);
		adminApp.añadirPublicacion(publicacion2);

		paramBusqueda = new ParametrosBusqueda("Buenos Aires", checkIn, checkOut, 4, 100.0, 300.0);

		List<Publicacion> publisFiltradas = adminApp.buscar(paramBusqueda);

		assertTrue(publisFiltradas.contains(publicacion1));
		assertTrue(publisFiltradas.contains(publicacion2));
		assertEquals(publisFiltradas.size(), 2);

	} 

}

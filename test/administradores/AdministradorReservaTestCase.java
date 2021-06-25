package administradores;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unq.AdministradorReserva;
import unq.Inmueble;
import unq.Publicacion;
import unq.Reserva;
import unq.SitioWeb;
import unq.Usuario;

class AdministradorReservaTestCase {

	AdministradorReserva adminReserva;
	SitioWeb sitio;
	Reserva reserva;
	Usuario usuario;

	@BeforeEach
	void setUp() throws Exception {
		sitio = mock(SitioWeb.class);
		reserva = mock(Reserva.class);
		usuario = mock(Usuario.class);
		adminReserva = new AdministradorReserva();
		adminReserva.registrarseEn(sitio);
	}

	@Test
	void testAdministradorReservaAgregaUnaReserva() {
		adminReserva.agregar(reserva);

		Integer cantidadReservas = adminReserva.cantidadDeReservas();

		assertEquals(cantidadReservas, 1);
	}

	@Test
	void testAdministradorReservaConoceAlSitio() {

		assertEquals(adminReserva.getSitioWeb(), sitio);
	}

	@Test
	void testAdministradorReservaNoObtieneNingunaReservaDeUnInquilino() {
		Usuario otroInquilino = mock(Usuario.class);
		Reserva reserva2 = mock(Reserva.class);
		List<Reserva> reservasRealizadas = new ArrayList<Reserva>();

		when(reserva.getInquilino()).thenReturn(otroInquilino);
		when(reserva2.getInquilino()).thenReturn(otroInquilino);

		reservasRealizadas.add(reserva);
		reservasRealizadas.add(reserva2);

		adminReserva.agregar(reserva);
		adminReserva.agregar(reserva2);
		List<Reserva> reservasDelUsuario = adminReserva.obtenerReservasDelUsuario(usuario);

		assertTrue(reservasDelUsuario.isEmpty());

	}

	@Test
	void testAdministradorReservaObtieneReservasRealizadasPorUnUsuarioInquilino() {
		Reserva reserva2 = mock(Reserva.class);
		List<Reserva> reservasRealizadas = new ArrayList<Reserva>();

		when(reserva.getInquilino()).thenReturn(usuario);
		when(reserva2.getInquilino()).thenReturn(usuario);

		reservasRealizadas.add(reserva);
		reservasRealizadas.add(reserva2);

		adminReserva.agregar(reserva);
		adminReserva.agregar(reserva2);
		List<Reserva> reservasDelUsuario = adminReserva.obtenerReservasDelUsuario(usuario);

		assertEquals(reservasDelUsuario.size(), 2);

	}

	@Test
	void testAdministradorReservaNoObtieneReservasDeLaCiudadIngresada() {
		Publicacion publicacion = mock(Publicacion.class);
		Inmueble inmueble = mock(Inmueble.class);

		when(inmueble.getCiudad()).thenReturn("Catamarca");
		when(publicacion.getInmueble()).thenReturn(inmueble);
		when(reserva.getPublicacion()).thenReturn(publicacion);
		when(reserva.getInquilino()).thenReturn(usuario);

		List<Reserva> reservasRealizadas = new ArrayList<Reserva>();
		reservasRealizadas.add(reserva);

		adminReserva.agregar(reserva);

		List<Reserva> reservasDelUsuario = adminReserva.obtenerReservasEnLaCiudadDelUsuario(usuario, "Buenos Aires");

		assertTrue(reservasDelUsuario.isEmpty());
	}

	@Test
	void testAdministradorReservaObtieneReservasRealizadasEnUnaCiudad() {
		Publicacion publicacion = mock(Publicacion.class);
		Inmueble inmueble = mock(Inmueble.class);

		when(inmueble.getCiudad()).thenReturn("Buenos Aires");
		when(publicacion.getInmueble()).thenReturn(inmueble);
		when(reserva.getPublicacion()).thenReturn(publicacion);
		when(reserva.getInquilino()).thenReturn(usuario);

		List<Reserva> reservasRealizadas = new ArrayList<Reserva>();
		reservasRealizadas.add(reserva);

		adminReserva.agregar(reserva);

		List<Reserva> reservasDelUsuario = adminReserva.obtenerReservasEnLaCiudadDelUsuario(usuario, "Buenos Aires");

		assertEquals(reservasDelUsuario.size(), 1);
	}

	@Test
	void testAdministradorReservaObtieneReservasFuturasDeUnUsuario() {

		when(reserva.getInicioDeAlquiler()).thenReturn(LocalDate.now());
		when(reserva.getInquilino()).thenReturn(usuario);

		adminReserva.agregar(reserva);

		List<Reserva> reservasFuturas = adminReserva.obtenerReservasFuturasDelUsuario(usuario);

		assertEquals(reservasFuturas.size(), 1);

	}

}

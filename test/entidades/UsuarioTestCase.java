package entidades;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unq.CancelacionGratuita;
import unq.CancelacionSimple;
import unq.CategoriaDePuntaje;
import unq.Inmueble;
import unq.Publicacion;
import unq.Puntaje;
import unq.Reserva;
import unq.SitioWeb;
import unq.Usuario;

class UsuarioTestCase {
	Usuario usuarioPropietario;
	Usuario usuarioInquilino;
	Puntaje puntaje;
	CategoriaDePuntaje categoriaPuntaje1;
	CategoriaDePuntaje categoriaPuntaje2;

	@BeforeEach
	void setUp() throws Exception {
		usuarioPropietario = new Usuario("bian", "unEmail", 123);
		usuarioInquilino = new Usuario("tami", "unEmail", 56);
		puntaje = mock(Puntaje.class);
		categoriaPuntaje1 = mock(CategoriaDePuntaje.class);
		categoriaPuntaje2 = mock(CategoriaDePuntaje.class);

	}

	@Test
	void testUnUsuarioTieneNombreMailYNumeroDeTelefono() {

		assertEquals(usuarioPropietario.getNombre(), "bian");
		assertEquals(usuarioPropietario.getMail(), "unEmail");
		assertEquals(usuarioPropietario.getTelefono(), 123);
	}

	@Test
	void testUnUsuarioNoRegistraPuntuaciones() {
		assertTrue(usuarioPropietario.getPuntajes().isEmpty());
		assertFalse(usuarioPropietario.registraPuntajeDe(usuarioPropietario));
	}

	@Test
	void testUnUsuarioTieneUnPromedioDePunutacionesCeroSinPublicaciones() {
		assertEquals(usuarioPropietario.getPromedioDePuntajes(), 0.0);

	}

//	1. El inquilino rankea al inmueble.
//	2. El inquilino rankea al dueño del inmueble.
//	3. El dueño del inmueble rankea al inquilino.
//	
	@Test
	void testUnUsuarioPropietarioPuntuaAUnInquilino() {
		usuarioPropietario.puntuarA(usuarioInquilino, 5, categoriaPuntaje1);

		assertTrue(usuarioInquilino.registraPuntajeDe(usuarioPropietario));
	}

	@Test
	void testUnUsuarioTieneUnPromedioDePuntuaciones() {
		usuarioPropietario.puntuarA(usuarioInquilino, 5, categoriaPuntaje1);
		usuarioPropietario.puntuarA(usuarioInquilino, 4, categoriaPuntaje1);

		assertEquals(usuarioInquilino.getPromedioDePuntajes(), 4.0);
	}

	@Test
	void testUnUsuarioTieneUnaCantidadDePuntajesDeAlgunaCategoria() {
		usuarioPropietario.puntuarA(usuarioInquilino, 5, categoriaPuntaje1);
		usuarioPropietario.puntuarA(usuarioInquilino, 4, categoriaPuntaje1);
		usuarioPropietario.puntuarA(usuarioInquilino, 5, categoriaPuntaje2);

		assertEquals(usuarioInquilino.cantPuntajesDeCategoria(categoriaPuntaje1), 2);
		assertEquals(usuarioInquilino.cantPuntajesDeCategoria(categoriaPuntaje2), 1);
	}

	@Test
	void testUnUsuarioTieneCeroPromedioDePuntuacionesDeAlgunaCategoria() {

		assertEquals(usuarioInquilino.getPromedioDePuntajesDeCategoria(categoriaPuntaje1), 0.0);

	}

	@Test
	void testUnUsuarioTieneUnPromedioDePuntuacionesDeAlgunaCategoria() {
		usuarioPropietario.puntuarA(usuarioInquilino, 5, categoriaPuntaje1);
		usuarioPropietario.puntuarA(usuarioInquilino, 4, categoriaPuntaje1);

		assertEquals(usuarioInquilino.getPromedioDePuntajesDeCategoria(categoriaPuntaje1), (5 + 4) / 2);
	}

	@Test
	void testUnInquilinoNoPuedePuntuarAInmuebleNoRealizoCheckOut() {
		Inmueble inmueble = mock(Inmueble.class);

		usuarioInquilino.puntuarInmueble(inmueble, 5, categoriaPuntaje1);
	}

	@Test
	void testUnInmuebleNoRegistraUnPuntajeDeUsuario() {
		Inmueble inmueble = mock(Inmueble.class);
		when(inmueble.registraPuntajeDe(usuarioInquilino)).thenReturn(false);
		assertFalse(usuarioPropietario.elInmuebleRegistraPuntajePropio(inmueble));

	}

	@Test
	void testUnUsuarioEsInquilinoNoTienePublicacionesRealizadas() {
		SitioWeb sitioWeb = mock(SitioWeb.class);
		usuarioInquilino.registrarse(sitioWeb);
		when(sitioWeb.contienePublicacionesDe(usuarioInquilino)).thenReturn(false);

		assertTrue(usuarioInquilino.esInquilino());
		assertFalse(usuarioInquilino.esPropietario());

	}

	@Test
	void testUnUsuarioNOEsInquilinoTienePublicacionesRealizadas() {
		SitioWeb sitioWeb = mock(SitioWeb.class);
		usuarioInquilino.registrarse(sitioWeb);
		when(sitioWeb.contienePublicacionesDe(usuarioInquilino)).thenReturn(true);

		assertFalse(usuarioInquilino.esInquilino());
		assertTrue(usuarioInquilino.esPropietario());
	}

	@Test
	void testUsuarioPuedeRealizarCancelacionGratuitaDeUnaReserva() {
		CancelacionGratuita cancelacion = mock(CancelacionGratuita.class);
		Reserva reserva = mock(Reserva.class);
//		Publicacion publi = mock(Publicacion.class);

		when(cancelacion.usuarioPuedeCancelarReserva(usuarioInquilino, reserva)).thenReturn(true);
//		when(reserva.getInicioDeAlquiler()).thenReturn(LocalDate.of(2021, 6, 1));
//		when(reserva.getPublicacion()).thenReturn(publi);

		assertTrue(usuarioInquilino.puedeCancelar(cancelacion, reserva));

	}

	@Test
	void testUsuarioRealizaCancelacionGratuitaDeReservaYElSitioLeCobraMontoDeDinero() {
		CancelacionGratuita cancelacion = mock(CancelacionGratuita.class);
		Publicacion publi = mock(Publicacion.class);
		Reserva reserva = mock(Reserva.class);
		SitioWeb sitio = mock(SitioWeb.class);
		
		when(publi.getPrecio()).thenReturn(20.0);
		when(reserva.getPublicacion()).thenReturn(publi);
		when(reserva.getInicioDeAlquiler()).thenReturn(LocalDate.of(2021, 5, 10));
		when(reserva.getFinalDeAlquiler()).thenReturn(LocalDate.of(2021, 5, 12));

		usuarioInquilino.setSitioWeb(sitio);
		List<Reserva> reservas = new ArrayList<Reserva>();
		reservas.add(reserva);

		when(sitio.getReservas()).thenReturn(reservas);
		when(cancelacion.usuarioPuedeCancelarReserva(usuarioInquilino, reserva)).thenReturn(true);

		usuarioInquilino.verificarCancelacionReservaGratuita(reserva, cancelacion);

		assertTrue(usuarioInquilino.puedeCancelar(cancelacion, reserva));
		assertEquals(usuarioInquilino.getSitioWeb().getMonto(), 2.0);

	}
	
	@Test
	void testUsuarioRealizaCancelacionSimpleDeReserva() {
		CancelacionSimple cancelacion = mock(CancelacionSimple.class);
		Reserva reserva = mock(Reserva.class);
		SitioWeb sitio = mock(SitioWeb.class);
		Publicacion publi = mock(Publicacion.class);
		usuarioInquilino.setSitioWeb(sitio);

		when(publi.getPrecio()).thenReturn(20.0);
		when(reserva.getInicioDeAlquiler()).thenReturn(LocalDate.of(2021, 5, 10));
		when(reserva.getFinalDeAlquiler()).thenReturn(LocalDate.of(2021, 5, 12));
		when(reserva.getPublicacion()).thenReturn(publi);
		
		List<Reserva> reservas = new ArrayList<Reserva>();
		reservas.add(reserva);
		
		when(sitio.getReservas()).thenReturn(reservas);
		when(cancelacion.usuarioPuedeCancelarReserva(usuarioInquilino, reserva)).thenReturn(true);
		
		usuarioInquilino.verificarCancelacionReservaSimple(reserva, cancelacion);
		
		assertEquals(usuarioInquilino.getSitioWeb().getMonto(), 60.0);

	}

}

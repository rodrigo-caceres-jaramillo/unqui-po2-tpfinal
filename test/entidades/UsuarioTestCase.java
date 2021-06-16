package entidades;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unq.*;

class UsuarioTestCase {
	Usuario usuario;
	Usuario usuario2;
	Puntaje puntaje;
	CategoriaDePuntaje categoriaPuntaje1;
	CategoriaDePuntaje categoriaPuntaje2;

	@BeforeEach
	void setUp() throws Exception {
		usuario = new Inquilino("bian", "unEmail", 123);
		usuario2 = new Propietario("tami", "unEmail", 56);
		puntaje = mock(Puntaje.class);
		categoriaPuntaje1 = mock(CategoriaDePuntaje.class);
		categoriaPuntaje2 = mock(CategoriaDePuntaje.class);

	}

	@Test
	void testUnUsuarioTieneNombreMailYNumeroDeTelefono() {

		assertEquals(usuario.getNombre(), "bian");
		assertEquals(usuario.getMail(), "unEmail");
		assertEquals(usuario.getTelefono(), 123);
	}

	@Test
	void testUnUsuarioNoRegistraPuntuaciones() {
		assertTrue(usuario2.getPuntajes().isEmpty());
		assertFalse(usuario2.registraPuntajeDe(usuario));
	}

	@Test
	void testUnUsuarioPuntuaAOtroUsuario() {
		usuario.puntuarA(usuario2, 5, categoriaPuntaje1);

		assertTrue(usuario2.registraPuntajeDe(usuario));
	}

	@Test
	void testUnUsuarioTieneUnPromedioDePunutacionesCeroSinPublicaciones() {
		assertEquals(usuario.getPromedioDePuntajes(), 0.0);

	}

	@Test
	void testUnUsuarioTieneUnPromedioDePuntuaciones() {
		usuario.puntuarA(usuario2, 5, categoriaPuntaje1);
		usuario.puntuarA(usuario2, 4, categoriaPuntaje1);

		assertEquals(usuario2.getPromedioDePuntajes(), 4.0);
	}

	@Test
	void testUnUsuarioTieneUnaCantidadDePuntajesDeAlgunaCategoria() {
		usuario.puntuarA(usuario2, 5, categoriaPuntaje1);
		usuario.puntuarA(usuario2, 4, categoriaPuntaje1);
		usuario.puntuarA(usuario2, 5, categoriaPuntaje2);

		assertEquals(usuario2.cantPuntajesDeCategoria(categoriaPuntaje1), 2);
		assertEquals(usuario2.cantPuntajesDeCategoria(categoriaPuntaje2), 1);
	}

	@Test
	void testUnUsuarioTieneCeroPromedioDePuntuacionesDeAlgunaCategoria() {

		assertEquals(usuario2.getPromedioDePuntajesDeCategoria(categoriaPuntaje1), 0.0);

	}

	@Test
	void testUnUsuarioTieneUnPromedioDePuntuacionesDeAlgunaCategoria() {
		usuario.puntuarA(usuario2, 5, categoriaPuntaje1);
		usuario.puntuarA(usuario2, 4, categoriaPuntaje1);

		assertEquals(usuario2.getPromedioDePuntajesDeCategoria(categoriaPuntaje1), (5 + 4) / 2);
	}

}

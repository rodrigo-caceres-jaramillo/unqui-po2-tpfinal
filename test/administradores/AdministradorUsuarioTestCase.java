package administradores;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unq.AdministradorUsuario;
import unq.SitioWeb;
import unq.Usuario;

class AdministradorUsuarioTestCase {

	AdministradorUsuario adminUsuario;
	SitioWeb sitio;
	Usuario usuario;

	@BeforeEach
	void setUp() throws Exception {
		usuario = mock(Usuario.class);
		sitio = mock(SitioWeb.class);
		adminUsuario = new AdministradorUsuario(sitio);

	}

	@Test
	void testAdministradorUsuarioConoceAlSitio() {

		assertEquals(adminUsuario.getSitioWeb(), sitio);
	}

	@Test
	void testAdministradorUsuarioNoTieneUsuariosRegistrados() {

		List<Usuario> usuariosRegistrados = adminUsuario.getUsuarios();

		assertTrue(usuariosRegistrados.isEmpty());

	}

	@Test
	void testAdministradorUsuarioRegistraUnUsuario() {
		adminUsuario.registrar(usuario);

		List<Usuario> usuariosRegistrados = adminUsuario.getUsuarios();

		assertFalse(usuariosRegistrados.isEmpty());
		assertEquals(usuariosRegistrados.size(), 1);
	}

}

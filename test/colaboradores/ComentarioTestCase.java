package colaboradores;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unq.Comentario;
import unq.Usuario;

import static org.mockito.Mockito.mock;

class ComentarioTestCase {

	Comentario comentario; // SUT
	Usuario usuarioQueImplementaComentario; // DOT

	@BeforeEach
	void setUp() throws Exception {
		comentario = new Comentario();
		usuarioQueImplementaComentario = mock(Usuario.class);
	}

	@Test
	void testUnComentarioTieneUnUsuarioQueLoCrea() {
		comentario.setUsuario(usuarioQueImplementaComentario);

		assertEquals(comentario.getUsuario(), usuarioQueImplementaComentario);
	}

	@Test
	void testUnComentarioTieneUnCuerpo() {
		comentario.setCuerpo("el inmueble está raro");
		assertEquals(comentario.getCuerpo(), "el inmueble está raro");

	}

}

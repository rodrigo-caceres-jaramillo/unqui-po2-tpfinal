package colaboradores;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unq.CategoriaDePuntaje;
import unq.Puntaje;
import unq.Usuario;

class PuntajeTestCase {

	Puntaje puntaje;
	Usuario usuarioQueImplementaPuntuacion; // DOT
	CategoriaDePuntaje categoria;
	
	@BeforeEach
	void setUp() throws Exception {
		puntaje = new Puntaje();
		usuarioQueImplementaPuntuacion = mock(Usuario.class);
		categoria = mock(CategoriaDePuntaje.class);
	}

	@Test
	void testUnPuntajeTieneUnUsuarioQuePuntua() {
		puntaje.setUsuario(usuarioQueImplementaPuntuacion);

		assertEquals(puntaje.getUsuario(), usuarioQueImplementaPuntuacion);

	}

	@Test
	void testUnPuntajeTieneUnaCategoriaDePuntaje() {
		puntaje.setCategoria(categoria);

		assertEquals(puntaje.getCategoria(), categoria);

	}

	@Test
	void testUnPuntajeNoTieneUnValor() {
		assertEquals(puntaje.getValor(), 0);
	}

	@Test
	void testUnPuntajeRecibeValorMenorOIgualA5() {
		puntaje.setValor(5);

		assertEquals(puntaje.getValor(), 5);
	}

	@Test
	void TestUnPuntajeNoRecibeUnValorMayorA5SuLimiteEs5() {
		puntaje.setValor(9);
		assertEquals(puntaje.getValor(), 5);

	}
}

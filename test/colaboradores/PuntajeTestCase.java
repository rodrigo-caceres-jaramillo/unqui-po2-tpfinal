package colaboradores;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unq.CategoriaDePuntaje;
import unq.Puntaje;
import unq.Usuario;

class PuntajeTestCase {

	Puntaje puntaje;
	Usuario usuarioQueImplementaPuntuacion; // DOT
	CategoriaDePuntaje categoria;
	CategoriaDePuntaje categoria2;
	@BeforeEach
	void setUp() throws Exception {
		puntaje = new Puntaje();
		usuarioQueImplementaPuntuacion = mock(Usuario.class);
		categoria = mock(CategoriaDePuntaje.class);
		categoria2 = mock(CategoriaDePuntaje.class);
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
	void testUnPuntajeNoRecibeUnValorMayorA5SuLimiteEs5() {
		puntaje.setValor(9);
		assertEquals(puntaje.getValor(), 5);

	}
	@Test
	void testUnPuntajeRetornaCeroSiNoTieneUnaCategoria() {
			
		puntaje.setCategoria(categoria);
		
		assertEquals(puntaje.valorSiEsDeCategoria(categoria2), 0 );
		
	}
	
	@Test
	void testUnPuntajeRetornSuValorSiTieneUnaCategoria() {
			
		puntaje.setCategoria(categoria);
		puntaje.setValor(5);
		assertEquals(puntaje.valorSiEsDeCategoria(categoria), 5 );
		
	}
	
	
	
	
	
	
	
	
	
}

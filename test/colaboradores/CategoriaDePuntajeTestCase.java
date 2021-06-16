package colaboradores;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unq.*;

/**
 * 2. El inquilino rankea al dueño del inmueble. 3. El dueño del inmueble rankea
 * al inquilino.
 * 
 * @author bian
 *
 */
class CategoriaDePuntajeTestCase {
	private CategoriaDePuntaje categoriaDePuntajeParaInmueble;
	private CategoriaDePuntaje categoriaDePuntajeParaInquilino;
	private CategoriaDePuntaje categoriaDePuntajeParaPropietario;
	private SitioWeb sitio;
	private Administrador admin;
	public Propietario propietario;
	public Inquilino inquilino;

	@BeforeEach
	void setUp() throws Exception {
		categoriaDePuntajeParaInmueble = new CategoriaDePuntaje("hogar");
		categoriaDePuntajeParaInquilino = new CategoriaDePuntaje("deja limpio el lugar");
		categoriaDePuntajeParaPropietario = new CategoriaDePuntaje("despacha a tiempo");
		sitio = new SitioWeb();
		admin = new Administrador();
		sitio.setAdministrador(admin);
		admin.setSitioAcargo(sitio);

		propietario = new Propietario("", "", 0);
		inquilino = new Inquilino("", "", 0);

	}

	@Test
	void testUnaCategoriaDePuntajeTieneUnNombre() {

		assertEquals(categoriaDePuntajeParaInmueble.getNombre(), "hogar");
		assertEquals(categoriaDePuntajeParaInquilino.getNombre(), "deja limpio el lugar");
		assertEquals(categoriaDePuntajeParaPropietario.getNombre(), "despacha a tiempo");
	}

	
	@Test
	void testUnAdministradorSubeUnaCategoriaAlSitio() {

		admin.agregarCategoriaDePuntajeAlSitio(categoriaDePuntajeParaInmueble);
		assertTrue(sitio.registraCategoriaDePuntaje(categoriaDePuntajeParaInmueble));

	}

	@Test
	void testUnSitioConoceElPromedioDePuntajesDeUnInquilinoConUnaCategoria() {
		CategoriaDePuntaje categoriaDos = new CategoriaDePuntaje("Limpieza");
		CategoriaDePuntaje categoriaUno = new CategoriaDePuntaje("hogar");

		admin.agregarCategoriaDePuntajeAlSitio(categoriaDos);
		admin.agregarCategoriaDePuntajeAlSitio(categoriaUno);

		propietario.puntuarA(inquilino, 4, categoriaDos);
		propietario.puntuarA(inquilino, 5, categoriaUno);

		assertEquals(inquilino.getPromedioDePuntajesDeCategoria(categoriaDos), 4.0 );		
			assertEquals(inquilino.getPromedioDePuntajesDeCategoria(categoriaUno), 5.0 );		

	}

	
	
	
	
	
}

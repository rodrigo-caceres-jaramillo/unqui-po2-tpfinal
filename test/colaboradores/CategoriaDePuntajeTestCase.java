package colaboradores;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unq.Administrador;
import unq.CategoriaDePuntaje;
import unq.Inmueble;
import unq.Inquilino;
import unq.Propietario;
import unq.Puntaje;
import unq.SitioWeb;
import unq.Usuario;

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

		admin.agregarCategoriaDePuntaje(categoriaDePuntajeParaInmueble);
		assertTrue(sitio.registraCategoriaDePuntaje(categoriaDePuntajeParaInmueble));

	}

	@Test
	void testUnSitioBuscaLosPuntajesDeUnaCategoria() {
		admin.agregarCategoriaDePuntaje(categoriaDePuntajeParaInmueble);

		CategoriaDePuntaje categoriaNueva = new CategoriaDePuntaje("Hogar");
		propietario.puntuarA(inquilino, 5, categoriaDePuntajeParaInquilino);
		propietario.puntuarA(inquilino, 4, categoriaNueva);

		assertEquals(sitio.promedioDePuntajeDe(inquilino, categoriaDePuntajeParaInquilino), 5);

		assertEquals(sitio.promedioDePuntajeDe(inquilino, categoriaNueva), 4);

	}

}

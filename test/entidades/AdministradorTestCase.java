package entidades;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//import static org.mockito.Mockito.*;

import unq.Administrador;
import unq.CategoriaDePuntaje;
import unq.Servicio;
import unq.SitioWeb;
import unq.TipoDeInmueble;

class AdministradorTestCase {
	private Administrador admin;
	private SitioWeb sitio;
	private CategoriaDePuntaje categoriaDePuntaje;
	private TipoDeInmueble tipo;
	private Servicio servicio;

	@BeforeEach
	public void setUp() throws Exception {
		sitio = new SitioWeb();
		admin = new Administrador();
		sitio.registrarAdministrador(admin);
	}

	@Test
	void testUnAdminstradorPuedeAgregarCategoriasDeRankeos() {
		admin.agregarCategoriaDePuntaje(categoriaDePuntaje);
		assertEquals(1, sitio.getCategoriasDePuntaje().size());
	}

	@Test
	void testUnAdministradorPuedeAgregarTiposDeInmuebles() {
		admin.agregarTipoDeInmmueble(tipo);
		assertEquals(1, sitio.getTiposDeInmuebles().size());
	}

	@Test
	void testUnAdministradorPuedeAgregarTiposDeServicios() {
		admin.agregarTipoDeServicio(servicio);
		assertEquals(1, sitio.getTiposDeServicios().size());
	}

}
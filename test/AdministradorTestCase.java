import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//import static org.mockito.Mockito.*;

import unq.Administrador;
import unq.CategoriaDeRankeoDePropietario;
import unq.SitioWeb;
import unq.TipoDeInmueble;
import unq.TipoDeServicio;


class AdministradorTestCase {
	private Administrador admin;
	private SitioWeb sitio;
	private CategoriaDeRankeoDePropietario rank1;
	private TipoDeInmueble tipo;
	private TipoDeServicio servicio;
	
	@BeforeEach
	public void setUp() throws Exception {
		sitio = new SitioWeb();
		admin = new Administrador();
		sitio.registrarAdministrador(admin);
	}
	@Test
	void testUnAdminstradorPuedeAgregarCategoriasDeRankeos() {
		admin.agregarCategoriaDeRankeo(rank1);
		assertEquals(1, sitio.getCategoriasDeRankeo().size());
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

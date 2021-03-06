package administradores;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unq.Administrador;
import unq.CategoriaDePuntaje;
import unq.ServiciosEnum;
import unq.SitioWeb;
import unq.TipoDeInmueble;

class AdministradorTestCase {
	private Administrador admin;
	private SitioWeb sitio;
	private CategoriaDePuntaje categoriaDePuntaje;
	private TipoDeInmueble tipoDeInmueble;

	@BeforeEach
	public void setUp() throws Exception {
		tipoDeInmueble = mock(TipoDeInmueble.class); 
		categoriaDePuntaje =mock(CategoriaDePuntaje.class); //DOT
		sitio = mock(SitioWeb.class) ; //DOT
		admin = new Administrador();
		admin.setSitioAcargo(sitio); sitio.registrarAdministrador(admin);
	}

	@Test
	void testUnAdministradorTieneUnSitioACargo() {
		admin.setSitioAcargo(sitio);
		assertTrue( admin.getSitioAcargo().equals(sitio) );
	}


   @Test
    void testUnAdministradorNoTieneTiposDeServicios() {
	  assertFalse(admin.registraElTipoDeServicio(ServiciosEnum.AGUA));
	   
	}
   
   @Test
   void testUnAdminPuedeAgregarUnTipoDeServicio() {
	   admin.addTipoDeServicios(ServiciosEnum.AGUA);
	   
	   assertTrue(admin.registraElTipoDeServicio(ServiciosEnum.AGUA));
   }

	@Test
	void testUnAdminPuedeAgregarUnTipoDeServicioAlSitio() {
		when(sitio.registraTipoDeServicio(ServiciosEnum.AGUA)).thenReturn(true);
		
		admin.agregarTipoDeServicioAlSitio(ServiciosEnum.AGUA);
			
		   assertTrue(admin.registraElTipoDeServicio(ServiciosEnum.AGUA));
		   assertTrue(admin.elSitioWebRegistraElServicio(ServiciosEnum.AGUA) );
	}
	@Test
	void testUnAdminstradorPuedeAgregarCategoriasDePuntajeAlSitio() {
		when(sitio.registraCategoriaDePuntaje(categoriaDePuntaje)).thenReturn(true);

		admin.agregarCategoriaDePuntajeAlSitio(categoriaDePuntaje);
		assertTrue(admin.elSitioWebRegistraLaCategoria(categoriaDePuntaje));
	}

	@Test
	void testUnAdministradorPuedeAgregarTiposDeInmueblesAlSitio() {
		when(sitio.registraTipoDeInmueble(tipoDeInmueble)).thenReturn(true);
		admin.agregarTipoDeInmmuebleAlSitio(tipoDeInmueble);
		assertTrue(sitio.registraTipoDeInmueble(tipoDeInmueble));
	}
   

   
   
   
   
   
   
   
}

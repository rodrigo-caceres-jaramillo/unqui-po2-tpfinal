package entidades;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unq.*;

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
	   admin.addTiposDeServicios(ServiciosEnum.AGUA);
		 
	   assertTrue(admin.registraElTipoDeServicio(ServiciosEnum.AGUA));

   }

	
	@Test
	void testUnAdminstradorPuedeAgregarCategoriasDePuntaje() {
		when(sitio.registraCategoriaDePuntaje(categoriaDePuntaje)).thenReturn(true);

		admin.agregarCategoriaDePuntajeAlSitio(categoriaDePuntaje);
		assertTrue(admin.elSitioWebRegistraLaCategoria(categoriaDePuntaje));
	}

	@Test
	void testUnAdministradorPuedeAgregarTiposDeInmuebles() {
		when(sitio.registraTipoDeInmueble(tipoDeInmueble)).thenReturn(true);
		admin.agregarTipoDeInmmuebleAlSitio(tipoDeInmueble);
		assertTrue(sitio.registraTipoDeInmueble(tipoDeInmueble));
	}
   

   
   
   
   
   
   
   
}

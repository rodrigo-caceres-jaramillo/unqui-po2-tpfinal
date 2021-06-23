package colaboradores;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unq.*;


class SitioDeOfertasObservableTestCase {

	SitioDeOfertasObservable sitioDeofertas;
	Inmueble inmueble;
	SitioWeb sitio;
	Publicacion publi;
	@BeforeEach
	void setUp() throws Exception {
	
		sitioDeofertas = new SitioDeOfertasObservable(); 
		sitio = mock(SitioWeb.class);
		inmueble =mock(Inmueble.class);
        publi = mock(Publicacion.class);

	}
	

	@Test
	void testUnSitioDeOfertasNoTieneInmueblesDeInteres() {
		sitioDeofertas.setInmueblesDeInteres(new ArrayList<Inmueble>() );
		
		assertTrue(sitioDeofertas.getInmueblesDeInteres().isEmpty() );
	
	}

	@Test
	void testUnSitioDeOfertasAgregaUnInmuebleDeInteres() {
		sitioDeofertas.addInmuebleDeInteres(inmueble);
		assertFalse( sitioDeofertas.getInmueblesDeInteres().isEmpty() );
	}
	
	@Test
	void testUnSitioDeOfertasRecibeUnaPublicacionQueNoEsInteresante() {
			
		assertFalse(sitioDeofertas.esUnaPublicacionInteresante(publi) );
		
	}
	
	@Test
	void testUnSitioDeOfertasRecibeUnaPublicacionQueEsInteresante() {
		sitioDeofertas.addInmuebleDeInteres(inmueble);
		when(publi.getInmueble()).thenReturn(inmueble);
		
		assertTrue(sitioDeofertas.esUnaPublicacionInteresante(publi) );
		
	}
	
	
	
	@Test
	void testUnSitioDeOfertasTieneUnImplementadorDePublicaciones() {
		IHomePagePublisher publisher = mock(IHomePagePublisher.class);
		
		sitioDeofertas.setImplementadorDePublicaciones(publisher);
		assertTrue( sitioDeofertas.getImplementadorDePublicaciones().equals(publisher) );
	}
	
	@Test
	void testUnSitioDeOfertasLanzaUnAvisoDeOfertaDePublicacion() {
		
		sitioDeofertas.addInmuebleDeInteres(inmueble);
		when(publi.getInmueble()).thenReturn(inmueble);
		
		IHomePagePublisher publisher = mock(IHomePagePublisher.class);
		
		sitioDeofertas.setImplementadorDePublicaciones(publisher);
		String contenidoDeAviso = "hay una baja de precio en el inmueble de la publi";
		
		sitioDeofertas.lanzarAvisoDeOfertaDeInmuebleEn(publi);	

		verify(publisher, times(1) ).publish(contenidoDeAviso);
		
				
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}

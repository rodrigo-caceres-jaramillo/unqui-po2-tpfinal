package unq;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PublicacionTestCase {
	

	Publicacion publicacion ; //SUT
    Propietario propietario ;  //DOT
    Inmueble   inmuebleDePublicacion ; //DOT
    Comentario  comentarioDePublicacion; //DOT
	
	
	@BeforeEach
	void setUp() throws Exception {
		
		publicacion = new Publicacion();
		propietario = mock(Propietario.class);
		inmuebleDePublicacion =  mock(Inmueble.class);
		comentarioDePublicacion = mock(Comentario.class);
			
	}
	
	
	@Test
	
	void testUnaPublicacionTieneUnUsuario() {
					
		publicacion.setUsuario(propietario );
			
		assertEquals( publicacion.getUsuario(), propietario  );
		
	}
	
	@Test
	void testUnaPublicacionTieneUnInmuble() {
		
		publicacion.setInmuebleAPublicar(inmuebleDePublicacion);
		
		assertEquals(publicacion.getInmueble(), inmuebleDePublicacion);
	}
	
	@Test 
	void testUnaPublicacionTieneUnCheckIn(){
		LocalDate checkIn =  LocalDate.parse("2000-10-15");

		publicacion.setCheckIn( checkIn);
		
		assertEquals(publicacion.getCheckIn(), checkIn);
	}
	

	@Test 
	void testUnaPublicacionTieneUnCheckOut(){
		LocalDate checkOut = LocalDate.parse("2000-10-20");
		publicacion.setCheckOut( checkOut);
		
		assertEquals(publicacion.getCheckOut(), checkOut);
	}	
	
	@Test
	void testUnaPublicacionTieneFormasDePago() {
        ArrayList<String> formasDePago = new ArrayList<>(Arrays.asList("Efectivo", "Debito", "Credito"));
 		
        publicacion.agregarFormasDePago(formasDePago );
        
		assertEquals(publicacion.getFormasDePago(), formasDePago);
		}
	
		
	@Test 
	void testUnaPublicacionNoAceptaUnaFormaDePago() {
		String formaDePago = "Efectivo"; 
		assertFalse(publicacion.aceptaFormaDePago(formaDePago));

	}
	
	
	@Test 
	void testUnaPublicacionAceptaUnaFormaDePago() {
		 ArrayList<String> formasDePago = new ArrayList<>(Arrays.asList("Efectivo", "Debito", "Credito"));
	     publicacion.agregarFormasDePago(formasDePago );
	        
		String formaDePago = "Efectivo"; 
		assertTrue(publicacion.aceptaFormaDePago(formaDePago));

	}
	
	@Test
	void testUnaPublicacionTieneUnPrecio() {
		Double precioDePublicacion = 100.50;
		publicacion.setPrecio(precioDePublicacion);
		
		assertEquals(publicacion.getPrecio(), precioDePublicacion);

	}
	
	@Test 
	void testUnaPublicacionNoTieneComentarios() {
		
		assertFalse(publicacion.tieneComentarios() );

	}
	@Test
	void testUnaPublicacionRecibeUnComentario() {
			publicacion.addComentario(comentarioDePublicacion);
			
			assertTrue(publicacion.tieneComentarios() );
			assertTrue( publicacion.getComentarios().contains(comentarioDePublicacion));	
	}
	
	@Test 
	void testUnaPublicacionOfreceInformacionDeUsuario() {
		publicacion.setUsuario(propietario);
		
		when(propietario.getMail()     ).thenReturn("bianca@gmail.com");
		when(propietario.getNombre()   ).thenReturn("bian");
		when(propietario.getTelefono()  ).thenReturn(123);
		String informacionDeUsuario = "bian bianca@gmail.com 123";
		assertEquals( publicacion.informacionDeUsuario(), informacionDeUsuario );
		
	}	
	
	@Test 
	void testUnaPublicacionSeInstanciaConTodosLosDatos() {

		LocalDate checkIn =  LocalDate.parse("2000-10-15");
		LocalDate checkOut = LocalDate.parse("2000-10-20");

		
		Publicacion publicacionDatos = new Publicacion(propietario,inmuebleDePublicacion,checkIn , checkOut , 145.05 ) ; 
	
		assertEquals( publicacionDatos.getCheckIn(), checkIn );
		assertEquals( publicacionDatos.getCheckOut(), checkOut );
		assertEquals( publicacionDatos.getUsuario(), propietario);
		assertEquals( publicacionDatos.getInmueble(), inmuebleDePublicacion);
		assertEquals( publicacionDatos.getPrecio(), 145.05);
		assertTrue(   publicacionDatos.getFormasDePago().isEmpty());
		assertTrue(   publicacionDatos.getComentarios().isEmpty());
	}
	
	

}

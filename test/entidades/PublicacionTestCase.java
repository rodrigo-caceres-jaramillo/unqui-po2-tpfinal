package entidades;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unq.*;

class PublicacionTestCase {

	Publicacion publicacion; // SUT
	Usuario propietario; // DOT
	Inmueble inmuebleDePublicacion; // DOT
	Comentario comentarioDePublicacion; // DOT

	@BeforeEach
	void setUp() throws Exception {
		publicacion = new Publicacion();
		propietario = mock(Usuario.class);
		inmuebleDePublicacion = mock(Inmueble.class);
		comentarioDePublicacion = mock(Comentario.class);
	}

	@Test

	void testUnaPublicacionTieneUnUsuario() {
		publicacion.setPropietario(propietario);

		assertEquals(publicacion.getPropietario(), propietario);
	}

	@Test
	void testUnaPublicacionTieneUnInmuble() {
		publicacion.setInmuebleAPublicar(inmuebleDePublicacion);

		assertEquals(publicacion.getInmueble(), inmuebleDePublicacion);
	}

	@Test
	void testUnaPublicacionTieneUnCheckIn() {
		LocalDate checkIn = LocalDate.parse("2000-10-15");
		publicacion.setCheckIn(checkIn);

		assertEquals(publicacion.getCheckIn(), checkIn);
	}

	@Test
	void testUnaPublicacionTieneUnCheckOut() {
		LocalDate checkOut = LocalDate.parse("2000-10-20");
		publicacion.setCheckOut(checkOut);

		assertEquals(publicacion.getCheckOut(), checkOut);
	}

	@Test
	void testUnaPublicacionNoAceptaMediosDePagoViaSitioWeb() {

		assertTrue(publicacion.getFormasDePago().isEmpty());
	}

	@Test
	void testUnaPublicacionAceptaSoloEfectivo() {

		publicacion.configurarMediosDePago(FormasDePagoEnum.EFECTIVO);
		publicacion.getFormasDePago().add(FormasDePagoEnum.EFECTIVO);

		assertTrue(publicacion.aceptaFormaDePago(FormasDePagoEnum.EFECTIVO));
	}

	@Test
	void testUnaPublicacionAceptaSoloTarjetaDeDebito() {

		publicacion.configurarMediosDePago(FormasDePagoEnum.TARJETADEDEBITO);
		publicacion.getFormasDePago().add(FormasDePagoEnum.TARJETADEDEBITO);

		assertTrue(publicacion.aceptaFormaDePago(FormasDePagoEnum.TARJETADEDEBITO));
	}

	@Test
	void testUnaPublicacionAceptaSoloTarjetaDeCredito() {

		publicacion.configurarMediosDePago(FormasDePagoEnum.TARJETADECREDITO);
		publicacion.getFormasDePago().add(FormasDePagoEnum.TARJETADECREDITO);

		assertTrue(publicacion.aceptaFormaDePago(FormasDePagoEnum.TARJETADECREDITO));
	}

	@Test
	void testUnaPublicacionAceptaTodosLosMediosDePago() {

		publicacion.addMediosDePagoAll();

		assertTrue(publicacion.aceptaFormaDePago(FormasDePagoEnum.TARJETADECREDITO));
		assertTrue(publicacion.aceptaFormaDePago(FormasDePagoEnum.TARJETADEDEBITO));
		assertTrue(publicacion.aceptaFormaDePago(FormasDePagoEnum.EFECTIVO));
	}


	@Test
	void testUnaPublicacionAceptaUnMedioDePago() {

		publicacion.addMedioDePago(FormasDePagoEnum.TARJETADECREDITO);

		assertTrue(publicacion.aceptaFormaDePago(FormasDePagoEnum.TARJETADECREDITO));
	}
	@Test
	void testUnaPublicacionTieneUnPrecioDeInmueblePorDia() {
		Double precioDePublicacion = 100.50;
		publicacion.setPrecio(precioDePublicacion);

		assertEquals(publicacion.getPrecio(), precioDePublicacion);
	}

	@Test
	void testUnaPublicacionNoTieneComentarios() {

		assertFalse(publicacion.tieneComentarios());

	}

	@Test
	void testUnaPublicacionRecibeUnComentario() {
		publicacion.addComentario(comentarioDePublicacion);

		assertTrue(publicacion.tieneComentarios());
		assertTrue(publicacion.getComentarios().contains(comentarioDePublicacion));
	}

	@Test
	void testUnaPublicacionOfreceInformacionDeUsuario() {
		publicacion.setPropietario(propietario);

		when(propietario.getMail()).thenReturn("bianca@gmail.com");
		when(propietario.getNombre()).thenReturn("bian");
		when(propietario.getTelefono()).thenReturn(123);
		String informacionDeUsuario = "bian bianca@gmail.com 123";
		assertEquals(publicacion.informacionDeUsuario(), informacionDeUsuario);
	}

	@Test
	void testUnaPublicacionSeInstanciaConTodosLosDatos() {

		LocalDate checkIn = LocalDate.parse("2000-10-15");
		LocalDate checkOut = LocalDate.parse("2000-10-20");

		Publicacion publicacionDatos = new Publicacion(propietario, inmuebleDePublicacion, checkIn, checkOut, 145.05);

		assertEquals(publicacionDatos.getCheckIn(), checkIn);
		assertEquals(publicacionDatos.getCheckOut(), checkOut);
		assertEquals(publicacionDatos.getPropietario(), propietario);
		assertEquals(publicacionDatos.getInmueble(), inmuebleDePublicacion);
		assertEquals(publicacionDatos.getPrecio(), 145.05);
		assertTrue(publicacionDatos.getFormasDePago().isEmpty());
		assertTrue(publicacionDatos.getComentarios().isEmpty());
	}

	@Test
	void testUnaPublicacionActualizaSuPrecio() {
			
		Double precioDePublicacion = 100.50;
		publicacion.actualizarPrecio(precioDePublicacion);
		assertEquals(publicacion.getPrecio(),100.50);
	}

}

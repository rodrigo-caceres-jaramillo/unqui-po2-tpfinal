package unq;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import unq.Inmueble;
import unq.Propietario;
import unq.SitioWeb;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.mockito.Mock;

class PropietarioTestCase {
	private SitioWeb sitio;
	private Propietario usuarioPropietario;
	private Inmueble inmueble;

	@BeforeEach
	public void setUp() throws Exception {
		usuarioPropietario = new Propietario("ejemplin", "ejemplo@jexample.com", 42356769);
		inmueble = new Inmueble();
		sitio = new SitioWeb();
		sitio.registrarUsuario(usuarioPropietario);

	}

	@Test
	void testUnPropietarioSeRegistraEnElSitioWeb() {
		usuarioPropietario.registrarse(sitio);

		assertEquals(usuarioPropietario.getSitioWeb(), sitio);
	}

	/*
	 * @Test void
	 * testUnPropietarioDeseaPonerEnAlquilerUnInmuebleEnElSitioIdicandoEspecificaciones
	 * () { Inmueble inmueble2 = new Inmueble();
	 * usuarioPropietario.conInmuebleAAlquilar(inmueble2); ArrayList<String>
	 * serviciosInmueble = usuarioPropietario.añadirServiciosDeInmueble(inmueble2,
	 * "Agua", "Gas", "Electricidad", "WiFi"); ArrayList<String> fotosInmueble =
	 * usuarioPropietario.añadirFotosDeInmueble(inmueble2, "Foto1", "Foto2",
	 * "Foto3"); LocalDate checkIn = LocalDate.of(2021, 7, 20); LocalDate checkOut =
	 * LocalDate.of(2021, 7, 25); ArrayList<String> formasDePago =
	 * usuarioPropietario.añadirFormasDePago("Tarjeta de credito",
	 * "Tarjeta de debito", "Efectivo");
	 * usuarioPropietario.registrarInmuebleConEspecificaciones(inmueble2,
	 * "Departamento", 45f, "Argentina", "CABA", "example 123", serviciosInmueble,
	 * fotosInmueble, checkIn, checkOut, formasDePago);
	 * usuarioPropietario.crearPublicacion(inmueble2);
	 * 
	 * assertEquals(null, null);
	 * 
	 * }
	 */

	/**@Test
	void testUnPropietarioEspecificaLasCaracteristicasDeUnInmuebleQueDeseaPublicar() {

		ArrayList<String> servicios = servicios.añadir("Agua");
		servicios.añadir("Gas");
		servicios.añadir("WiFi");
		servicios.añadir("Agua");
		ArrayList<String> fotos = fotos.añadir("Foto1");
		fotos.añadir("Foto2");
		fotos.añadir("Foto3");
		LocalDate checkIn = LocalDate.of(2021, 7, 20); 
		LocalDate checkOut = LocalDate.of(2021, 7, 25);
		usuarioPropietario.publicarInmuebleConEspecificaciones(inmueble, "Departamento", 45f, "Argentina",
				"direccion 900", servicios, 2, fotos, checkIn, checkOut);

		assertEquals(usuarioPropietario.getPublicacion().getTipoInmueble(), "Departamento");
		assertEquals(superficie, 45f);
		assertEquals(pais, "Argentina");
		assertEquals(ciudad, "Buenos Aires");
		assertTrue(servicios.contains("Gas", "Electricidad", "Agua", "WiFi", "Baño privado"));
		assertEquals(capacidadPersonas, 2);
		assertTrue(fotos.contains("Foto1", "Foto3", "Foto3"));

	}

	@Test
	void testUnPropietarioPuedePublicarUnInmueble() {
		usuarioPropietario.publicarInmueble(inmueble);
		assertEquals(sitio.getPublicaciones().size(), 1);
	}**/

}

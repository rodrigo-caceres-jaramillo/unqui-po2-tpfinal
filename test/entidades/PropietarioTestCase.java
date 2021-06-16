package entidades;

/* 

//**
 * publicarInmueble(): listo
 
+ puntuarInquilino(Inquilino, int, String): 
+ aceptarReserva(Reserva):
+ informacionPropia():
A su vez, para un inmueble, el usuario podrá visualizar también la
información propia del dueño, el puntaje que otros usuarios le han dado a él mismo
y el puntaje promedio que ha obtenido.
+ bajarPrecioAPublicidadCon(Publicidad, double):
*/
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unq.FormasDePagoEnum;
import unq.Propietario;
import unq.Publicacion;
import unq.SitioWeb;

class PropietarioTestCase {

	private Propietario usuarioPropietario;

	@BeforeEach
	public void setUp() throws Exception {
		usuarioPropietario = new Propietario("ejemplin", "ejemplo@jexample.com", 42356769);

		// usuarioPropietario.registrarse(sitio);

	}

	@Test
	void testPropietarioRealizaUnaPublicacionAlSitio() {
		SitioWeb sitio = new SitioWeb();
		Publicacion publicacion = new Publicacion();

		publicacion.setPropietario(usuarioPropietario);
		sitio.addUsuario(usuarioPropietario);

		usuarioPropietario.agregarPublicacion(publicacion, sitio);

		List<Publicacion> publicacionesDelPropietario = usuarioPropietario.publicacionesEnElSitio(sitio);

		assertTrue(publicacionesDelPropietario.contains(publicacion));
	}

	@Test
	void testUnPropietarioEstableceUnMedioDePagoAUnaPublicacion() {
		SitioWeb sitio = new SitioWeb();
		Publicacion publicacion = new Publicacion();

		publicacion.setPropietario(usuarioPropietario);
		sitio.addUsuario(usuarioPropietario);

		FormasDePagoEnum efectivo = FormasDePagoEnum.EFECTIVO;
		usuarioPropietario.medioDePagoPara(publicacion, efectivo);
		usuarioPropietario.agregarPublicacion(publicacion, sitio);

		Boolean publisRecibenEfectivo = sitio.registraPubliDeUsuarioConFormaDePago(usuarioPropietario, efectivo);

		assertTrue(publisRecibenEfectivo);
	}

	@Test
	void testUnPropietarioBajaPrecioAUnaPublicacionDeInmueble() {
		SitioWeb sitio = new SitioWeb();
		Publicacion publicacion = new Publicacion();

		publicacion.setPrecio(100.0);

		usuarioPropietario.agregarPublicacion(publicacion, sitio);
		usuarioPropietario.bajarPrecioAPublicacionEnSitio(publicacion, 0.0, sitio);

		assertEquals(publicacion.getPrecio(), 0.0);
	}

}

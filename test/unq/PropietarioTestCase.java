package unq;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import unq.Inmueble;
import unq.Propietario;
import unq.SitioWeb;
import static org.mockito.Mockito.*;
import org.mockito.Mock;

class PropietarioTestCase {
	private SitioWeb sitio;
	private Propietario usuario;
	private Inmueble inmueble;
	
	@BeforeEach
	public void setUp() throws Exception {
		usuario = new Propietario("ejemplin", "ejemplo@jexample.com", 42356769);
		inmueble = mock(Inmueble.class);
		sitio = new SitioWeb();
		sitio.registrarUsuario(usuario);
	}
	
	@Test
	void testUnPropietarioPuedePublicarUnInmueble() {
		usuario.publicarInmueble(inmueble);
		assertEquals(sitio.getPublicaciones().size(), 1);
	}

}

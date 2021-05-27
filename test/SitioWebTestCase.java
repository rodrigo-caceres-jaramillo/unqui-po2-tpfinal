import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;
import org.mockito.Mock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import unq.Administrador;
import unq.Inquilino;
import unq.Propietario;
import unq.SitioWeb;

class SitioWebTestCase {
	private SitioWeb sitio;
	private Inquilino usuario1;
	private Propietario usuario2;
	private Administrador admin;
	
	@BeforeEach
	public void setUp() throws Exception {
		sitio = new SitioWeb();
		usuario1 = mock(Inquilino.class);
		usuario2 = mock(Propietario.class);
		admin = mock(Administrador.class);
	}
	
	@Test
	void testUnSitioWebPuedeRegistrarUsuarios() {
		sitio.registrarUsuario(usuario1);
		sitio.registrarUsuario(usuario2);
		assertEquals(2, sitio.getUsuarios().size());
	
	}
	@Test
	void testUnSitioWebPuedeAgregarUnAdministrador() {
		sitio.registrarAdministrador(admin);
		assertEquals(sitio.getAdministrador(), admin);	
	}
}

package unq;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PublicacionTestCase {

	Publicacion publicacion;
	Usuario propietario;
	Inmueble inmueble;
	IServicio servicio;

	@BeforeEach
	void setUp() throws Exception {
		propietario = new Propietario("pepe", "example@example.com", 12345678);
		inmueble = new Inmueble("Departamento", 45f);
		publicacion = new Publicacion(propietario, inmueble);
	}

	@Test
	void testUnaPublicacionDeInmuebleTieneLasEspecificaciones() {
		ArrayList<String> fotos;
		fotos.add("Foto1");
		fotos.add("Foto2");
		fotos.add("Foto3");
		
	/*
		ArrayList<String> servicios;
		servicios.add("Gas");
		servicios.add("Electricidad");
		servicios.add("Wifi");
		servicios.add("Agua");
		
		*/
		
		publicacion.conEspecificaciones("Argentina", "Buenos Aires" , "Direccion 200", servicios, 3, fotos);
	}

}

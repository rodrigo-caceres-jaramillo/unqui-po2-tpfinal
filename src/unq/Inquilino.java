package unq;

import java.time.LocalDate;
import java.util.ArrayList;

public class Inquilino extends Usuario{
	public Inquilino(String nombre, String mail, int telefono) {
		super(nombre, mail, telefono);
	}

	public ArrayList<Publicacion> buscarInmuebles(String ciudad, LocalDate fechaDeEntrada, LocalDate fechaDeSalida, int cantidadDeHuspedes, double precioMinimo, double precioMaximo) {
		ArrayList<Publicacion> inmueblesPublicados = this.getSitioWeb().getInmueblesPublicadosConEspecificaciones(ciudad, 
				fechaDeEntrada,
				fechaDeSalida,
				cantidadDeHuspedes,
				precioMinimo,
				precioMinimo);
		return inmueblesPublicados;
	}
}

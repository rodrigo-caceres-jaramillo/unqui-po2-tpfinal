package unq;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.function.BooleanSupplier;

public class Inquilino extends Usuario{
	
	public Inquilino(String nombre, String mail, int telefono) {
		super(nombre, mail, telefono);
	}

	public ArrayList<Inmueble> buscarInmuebles(String ciudad, LocalDate checkIn, LocalDate checkOut, 
											   Integer cantidadDeHuspedes, Double precioMinimo, Double precioMaximo) {
		
		return (  getSitioWeb().getInmueblesConBusquedaPor(ciudad, checkIn, checkOut,
																				cantidadDeHuspedes, precioMinimo, precioMaximo)  );
		
	}

	public void alquilarInmuebleDeListado(Inmueble inmueble, ArrayList<Inmueble> listadoDeInmuebles) {
		
		this.getSitioWeb().añadirOcupacionDelInmueble(inmueble);
		
	}

	public boolean elSitioRegistraOcupacionDelInmueble(Inmueble inmueble1) {
		return (this.getSitioWeb().elInmuebleEstaOcupado( inmueble1));
	}

	public void puntuarInmueble(Inmueble inmueble, int valorDePuntaje, CategoriaDePuntaje categoriaDePuntaje) {
			inmueble.addPuntaje(new Puntaje(valorDePuntaje, this,categoriaDePuntaje) );
	}

	public boolean elInmuebleRegistraPuntajePropio(Inmueble inmueble1) {
		return (inmueble1.registraPuntajeDe(this));
	}

	public void puntuarADueñoDeInmueble(Inmueble inmueble, int puntuacion,
			CategoriaDePuntaje categoriaDePuntajeParaPropietario) {
		super.puntuarA(inmueble.getPropietario(), puntuacion,
						categoriaDePuntajeParaPropietario);
	}


}


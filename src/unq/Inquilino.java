package unq;

import java.time.LocalDate;
import java.util.List;

public class Inquilino extends Usuario {

	public Inquilino(String nombre, String mail, Integer telefono) {
		super(nombre, mail, telefono);
	}

	public List<Inmueble> buscarInmueblesEn(ParametrosBusqueda parametrosBusqueda, SitioWeb sitio) {

		return sitio.buscarInmueble(parametrosBusqueda);

	} 
//
//	public void alquilarInmuebleDeListado(Inmueble inmueble, List<Inmueble> listadoDeInmuebles) {
//		this.getSitioWeb().añadirOcupacionDelInmueble(inmueble);
//
//	}
//
//	public boolean elSitioRegistraOcupacionDelInmueble(Inmueble inmueble1) {
//		return (this.getSitioWeb().elInmuebleEstaOcupado(inmueble1));
//	}

	public void puntuarInmueble(Inmueble inmueble, Integer valorDePuntaje, CategoriaDePuntaje categoriaDePuntaje) {

		inmueble.addPuntaje(new Puntaje(valorDePuntaje, this, categoriaDePuntaje));

	}

//	public List<Inmueble> buscarInmuebles(String ciudad, LocalDate checkIn, LocalDate checkOut,
//			Integer cantidadDeHuspedes, Double precioMinimo, Double precioMaximo) {
//
//		return (getSitioWeb().getInmueblesConBusquedaPor(ciudad, checkIn, checkOut, cantidadDeHuspedes, precioMinimo,
//				precioMaximo));
//
//	}
//
//	public void alquilarInmuebleDeListado(Inmueble inmueble, ArrayList<Inmueble> listadoDeInmuebles) {
//
//		this.getSitioWeb().añadirOcupacionDelInmueble(inmueble);
//
//	}
//
//	public boolean elSitioRegistraOcupacionDelInmueble(Inmueble inmueble1) {
//		return (this.getSitioWeb().elInmuebleEstaOcupado(inmueble1));
//	}

	public void puntuarInmueble(Inmueble inmueble, int valorDePuntaje, CategoriaDePuntaje categoriaDePuntaje) {
		inmueble.addPuntaje(new Puntaje(valorDePuntaje, this, categoriaDePuntaje));
	}

	public boolean elInmuebleRegistraPuntajePropio(Inmueble inmueble1) {
		return (inmueble1.registraPuntajeDe(this));
	}

	public void puntuarADueñoDeInmueble(Inmueble inmueble, int puntuacion,
			CategoriaDePuntaje categoriaDePuntajeParaPropietario) {
		super.puntuarA(inmueble.getPropietario(), puntuacion, categoriaDePuntajeParaPropietario);
	}

}

package unq;

import java.time.LocalDate;
import java.util.ArrayList;

public class Publicacion {
	// Atributos
	private Usuario propietario;
	private Inmueble inmueble;
	private ArrayList<Comentario> comentarios;
	private Double precio;
	private Integer cantidadDeHuespedes;
	private LocalDate fechaDeEntrada;
	private LocalDate fechaDeSalida;

	// Constructor
	public Publicacion(Usuario propietario, Inmueble inmueble) {
		super();
		this.propietario = propietario;
		this.inmueble = inmueble;
		this.comentarios = new ArrayList<Comentario>();
	}

	// Gets y sets
	public Usuario getPropietario() {
		return propietario;
	}

	public void setPropietario(Usuario propietario) {
		this.propietario = propietario;
	}

	public Inmueble getInmueble() {
		return inmueble;
	}

	public void setInmueble(Inmueble inmueble) {
		this.inmueble = inmueble;
	}

	public ArrayList<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(ArrayList<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Integer getCantidadDeHuespedes() {
		return cantidadDeHuespedes;
	}

	public void setCantidadDeHuespedes(Integer cantidadDeHuespedes) {
		this.cantidadDeHuespedes = cantidadDeHuespedes;
	}

	public boolean cumpleConEspecificaciones(String ciudad, LocalDate fechaDeEntrada, LocalDate fechaDeSalida,
			Integer cantidadHuespedes, Double precioMinimo, Double precioMaximo) {
		String ciudadDelInmueble = getInmueble().getCiudad();
		
		Boolean cumpleConEspecificacionesObligatorias = ciudadDelInmueble.equals(ciudad)
				&& getFechaDeEntrada().equals(fechaDeEntrada) && getFechaDeSalida().equals(fechaDeSalida);
		
		Boolean cumpleConEspecificacionesOpcionales = rangoDePreciosIngresadosNoEsNulo(precioMinimo, precioMaximo)
				|| cantidadHuespedesIngresadosNoEsNulo(cantidadHuespedes);
		
		return cumpleConEspecificacionesObligatorias || cumpleConEspecificacionesOpcionales;
	}

	private boolean cantidadHuespedesIngresadosNoEsNulo(Integer cantidadHuespedes) {
		if(!cantidadHuespedes.equals(null)) {
			return getCantidadDeHuespedes() == cantidadHuespedes;
		} else {
			return false;
		}
		
	}

	private boolean rangoDePreciosIngresadosNoEsNulo(Double precioMinimo, Double precioMaximo) {
		if (!precioMinimo.equals(null) && !precioMaximo.equals(null)) {
			return getPrecio() <= precioMaximo || getPrecio() >= precioMinimo;
		} else {
			return false;
		}
		
	}

	public LocalDate getFechaDeSalida() {
		return fechaDeSalida;
	}

	public void setFechaDeSalida(LocalDate fechaDeSalida) {
		this.fechaDeSalida = fechaDeSalida;
	}

	public LocalDate getFechaDeEntrada() {
		return fechaDeEntrada;
	}

	public void setFechaDeEntrada(LocalDate fechaDeEntrada) {
		this.fechaDeEntrada = fechaDeEntrada;
	}
	

}

package unq;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BooleanSupplier;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Inmueble {
	// Atributos
	private TipoDeInmueble tipoDeInmueble;
	private Integer superficie;
	private String pais;
	private String ciudad;
	private String direccion;
	private List<Servicio> servicios;
	private Integer capacidad;
	private List<Puntaje> puntaciones;
	private Propietario propietario;

	// Constructores

	public Inmueble() {
		super();
		this.servicios = new ArrayList<Servicio>();
		this.puntaciones = new ArrayList<Puntaje>();
	}

	public Inmueble(TipoDeInmueble tipo, Integer superficie, String pais, String ciudad, String direccion,
			Integer capacidad) {
		setCapacidad(capacidad);
		setCiudad(ciudad);
		setDireccion(direccion);
		setPais(pais);
		setSuperficie(superficie);
		setTipoDeInmueble(tipo);
	}

	public void setTipoDeInmueble(TipoDeInmueble tipoDeInmueble) {

		this.tipoDeInmueble = tipoDeInmueble;
	}

	public TipoDeInmueble getTipoDeInmueble() {
		return (this.tipoDeInmueble);
	}

	public void setSuperficie(Integer superficie) {
		this.superficie = superficie;
	}

	public int getSuperficie() {

		return (this.superficie);
	}

	public void setPais(String pais) {
		this.pais = pais;

	}

	public String getPais() {

		return this.pais;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getCiudad() {
		return (this.ciudad);
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDireccion() {
		return (this.direccion);
	}

	public List<Servicio> getServicios() {
		return (this.servicios);
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public Integer getCapacidad() {
		return (this.capacidad);
	}

	public List<Puntaje> getPuntajes() {
		return (this.puntaciones);
	}

	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}

	public Propietario getPropietario() {
		return (this.propietario);
	}

	// Metodos
	public Double getPromedioDePuntajes() {
		Double promedio = 0.0;
		Integer cantPuntajes = this.getPuntajes().size();
		for (int i = 0; i < cantPuntajes; i++) {
			Puntaje puntaje = this.getPuntajes().get(i);
			// promedio = +puntaje.getValor();
		}
		// return (promedio / 5);
		return (promedio / cantPuntajes);
	}

	public void addNuevoServicio(Servicio servicioDeInmueble) {
		this.getServicios().add(servicioDeInmueble);
	}

	public void addPuntaje(Puntaje puntajeParainmueble) {
		this.getPuntajes().add(puntajeParainmueble);
	}

	public Boolean registraPuntajeDe(Usuario usuario) {
		return (this.getPuntajes().stream().anyMatch(puntaje -> puntaje.getUsuario() == usuario));
	}

	public Boolean registraServicio(Servicio servicio) {
		return (this.getServicios().stream().anyMatch(s -> s == servicio));
	}

	public Boolean esDeTipo(TipoDeInmueble tipoDeInmueble) {
		return (this.getTipoDeInmueble() == tipoDeInmueble);
	}

}

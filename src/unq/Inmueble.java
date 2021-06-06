package unq;

import java.time.LocalDate;
import java.util.ArrayList;

public class Inmueble {
	// Atributos
	private TipoDeInmueble tipoDeInmueble;
	private int superficie;
	private String pais;
	private String ciudad;
	private String direccion;
	private ArrayList<TipoDeServicio> servicios;
	private int capacidad;
	private Float metrosCuadrados;
	//private ??? foto;
	private LocalDate checkIn;
	private LocalDate checkOut;
	private ArrayList<String> formasDePagoAceptadas;
	private Double precio;
	private ArrayList<Puntacion> puntaciones;
	// Constructores
	public Inmueble() {
		super();
		this.servicios = new ArrayList<TipoDeServicio>();
		this.puntaciones = new ArrayList<Puntacion>();
	}

	// Getters and Setters
	public Inmueble(String ciudad) {
		super();
		this.ciudad = ciudad;
	}

	public Inmueble(String tipoInmueble, Float metrosCuadrados) {
		setTipoDeInmueble(tipoDeInmueble);
		setMetrosCuadrados(metrosCuadrados);
		
	}

	public void setTipoDeInmueble(TipoDeInmueble tipoDeInmueble) {
		this.tipoDeInmueble = tipoDeInmueble;
	}

	public TipoDeInmueble getTipoDeInmueble() {
		return (this.tipoDeInmueble);
	}

	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}

	public int getSuperficie() {

		return (this.superficie);
	}

	public void setPais(String pais) {
		this.pais = pais;

	}

	public String getPais() {

		return (this.pais);
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

	public ArrayList<TipoDeServicio> getServicios() {
		return (this.servicios);
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public int getCapacidad() {
		return (this.capacidad);
	}

	public ArrayList<Puntacion> getPuntajesDeRankeo() {
		return (this.puntaciones);
	}

	//Metodos
	public double getPromPuntajeDeRankeos() {
		double promedio = 0;
		int cantPuntajes = this.getPuntajesDeRankeo().size();
		for (int i = 0; i < cantPuntajes; i++) {
			Puntacion puntaje = this.getPuntajesDeRankeo().get(i);
			promedio = +puntaje.getValor();
		}
		return (promedio / 5);
	}

	public void addNuevoServicio(TipoDeServicio servicioDeInmueble) {
		this.getServicios().add(servicioDeInmueble);
	}

	public void addPuntaje(Puntacion puntajeParainmueble) {
		this.getPuntajesDeRankeo().add(puntajeParainmueble);
	}

	public Float getMetrosCuadrados() {
		return metrosCuadrados;
	}

	public void setMetrosCuadrados(Float metrosCuadrados) {
		this.metrosCuadrados = metrosCuadrados;
	}

}


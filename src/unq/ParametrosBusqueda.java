package unq;

import java.time.LocalDate;

public class ParametrosBusqueda {

	private String ciudad;
	private LocalDate checkIn;
	private LocalDate checkOut;
	private Integer cantidadDeHuespedes;
	private Double precioMinimo;
	private Double precioMaximo;

	public ParametrosBusqueda(String ciudad, LocalDate checkIn, LocalDate checkOut) {
		super();
		verificarDatosObligatorios(ciudad, checkIn, checkOut);
	}

	private void verificarDatosObligatorios(String ciudad, LocalDate checkIn, LocalDate checkOut) {
		if (!(ciudad == null) && !(checkIn == null) && !(checkOut == null)) {
			setCiudad(ciudad);
			setCheckIn(checkIn);
			setCheckOut(checkOut);
		}
	}

	public ParametrosBusqueda(String ciudad, LocalDate checkIn, LocalDate checkOut, Integer cantidadDeHuespedes,
			Double precioMinimo, Double precioMaximo) {
		super();
		verificarDatosObligatorios(ciudad, checkIn, checkOut);

		setCantidadDeHuespedes(cantidadDeHuespedes);
		setPrecioMinimo(precioMinimo);
		setPrecioMaximo(precioMaximo);
	}
	
	public Boolean seIndicaCantidadDeHuespedes() {
		return getCantidadDeHuespedes() != null;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public LocalDate getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(LocalDate checkIn) {
		this.checkIn = checkIn;
	}

	public LocalDate getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(LocalDate checkOut) {
		this.checkOut = checkOut;
	}

	public Integer getCantidadDeHuespedes() {
		return cantidadDeHuespedes;
	}

	public void setCantidadDeHuespedes(Integer cantidadDeHuespedes) {
		this.cantidadDeHuespedes = cantidadDeHuespedes;
	}

	public Double getPrecioMinimo() {
		return precioMinimo;
	}

	public void setPrecioMinimo(Double precioMinimo) {
		this.precioMinimo = precioMinimo;
	}

	public Double getPrecioMaximo() {
		return precioMaximo;
	}

	public void setPrecioMaximo(Double precioMaximo) {
		this.precioMaximo = precioMaximo;
	}

}

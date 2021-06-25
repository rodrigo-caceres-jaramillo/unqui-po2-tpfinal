package unq;

import java.time.LocalDate;

public class Reserva implements Registrable{
	// Atributos
	private Publicacion publicacion;
	private Usuario propietario;
	private Usuario inquilino;
	private FormasDePagoEnum formaDePago;
	private LocalDate inicioDeAlquiler;
	private LocalDate finalDeAlquiler;
	private Integer dia;

	// Constructor
	public Reserva(Publicacion publicacion, Usuario inquilino, FormasDePagoEnum formaDePago, LocalDate inicioDeAlquiler,
			LocalDate finalDeAlquiler) {
		super();
		this.setPublicacion(publicacion);
		this.setPropietario(publicacion.getPropietario());
		this.setInquilino(inquilino);
		this.setFormaDePago(formaDePago);
		this.setInicioDeAlquiler(inicioDeAlquiler);
		this.setFinalDeAlquiler(finalDeAlquiler);
	}

	public Reserva() {
		super();
	}

	// Gets y sets
	public Publicacion getPublicacion() {
		return publicacion;
	}

	public void setPublicacion(Publicacion publicacion) {
		this.publicacion = publicacion;
	}

	public Usuario getPropietario() {
		return propietario;
	}

	public void setPropietario(Usuario propietario) {
		this.propietario = propietario;
	}

	public Usuario getInquilino() {
		return inquilino;
	}

	public void setInquilino(Usuario inquilino) {
		this.inquilino = inquilino;
	}

	public FormasDePagoEnum getFormaDePago() {
		return formaDePago;
	}

	public void setFormaDePago(FormasDePagoEnum formaDePago) {
		this.formaDePago = formaDePago;
	}

	public LocalDate getInicioDeAlquiler() {
		return inicioDeAlquiler;
	}

	public void setInicioDeAlquiler(LocalDate inicioDeAlquiler) {
		this.inicioDeAlquiler = inicioDeAlquiler;
	}

	public LocalDate getFinalDeAlquiler() {
		return finalDeAlquiler;
	}

	public void setFinalDeAlquiler(LocalDate finalDeAlquiler) {
		this.finalDeAlquiler = finalDeAlquiler;
	}

	public Inmueble getInmueble() {
		return (this.getPublicacion().getInmueble());
	}

	public Integer getDiasDeReserva() {
		return dia;
	}

	public void diasDeReserva(Integer dia) {
		this.dia = dia;
	}

	@Override
	public void registrarseEn(SitioWeb sitioWeb) {
		sitioWeb.addReserva(this);
	}

}

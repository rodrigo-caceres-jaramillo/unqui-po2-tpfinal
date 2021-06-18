package unq;

import java.time.LocalDate;

public class Reserva {
	// Atributos
	private Publicacion publicacion;
	private Usuario propietario;
	private Usuario inquilino;
	private FormasDePagoEnum formaDePago;
	private LocalDate inicioDeAlquiler;
	private LocalDate finalDeAlquiler;
	
	// Constructor
	public Reserva(Publicacion publicacion, Usuario propietario, Usuario inquilino, FormasDePagoEnum formaDePago,
			LocalDate inicioDeAlquiler, LocalDate finalDeAlquiler) {
		super();
		this.setPublicacion(publicacion);
		this.setPropietario(propietario);
		this.setInquilino(inquilino);
		this.setFormaDePago(formaDePago);
		this.setInicioDeAlquiler(inicioDeAlquiler);
		this.setFinalDeAlquiler(finalDeAlquiler);
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
	
}

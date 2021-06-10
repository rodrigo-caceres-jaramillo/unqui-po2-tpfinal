package unq;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Publicacion {

	private Usuario usuario;
	private Inmueble inmueble;
	private LocalDate checkIn;
	private LocalDate checkOut;
	private List<FormasDePagoEnum> formasDePago;
	private Double precio;
	private ArrayList<Comentario> comentarios;

	public Publicacion() {
		super();
		// this.formasDePago = new ArrayList<String>();
		this.comentarios = new ArrayList<Comentario>();
		setFormasDePago(new ArrayList<FormasDePagoEnum>());

	}

	
	public Publicacion(Usuario usuario, Inmueble inmueble) {
		setUsuario(usuario);
		setInmueble(inmueble);
		setFormasDePago(new ArrayList<FormasDePagoEnum>());

	}
	

	public Publicacion(Usuario usuario, Inmueble inmueble, LocalDate checkIn, LocalDate checkOut, Double precio) {
		super();

		this.usuario = usuario;
		this.inmueble = inmueble;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.precio = precio;
		this.comentarios = new ArrayList<Comentario>();
		setFormasDePago(new ArrayList<FormasDePagoEnum>());
	}

	public Inmueble getInmueble() {
		return (this.inmueble);
	}

	public void setInmueble(Inmueble inmueble) {
		this.inmueble = inmueble;
	}

	public List<FormasDePagoEnum> getFormasDePago() {
		return formasDePago;
	}

	public void setFormasDePago(List<FormasDePagoEnum> formasDePago) {
		this.formasDePago = formasDePago;
	}

	public ArrayList<Comentario> getComentarios() {
		return (this.comentarios);
	}

	public void setComentarios(ArrayList<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public void setUsuario(Usuario propietario) {
		this.usuario = propietario;
	}

	public Usuario getUsuario() {

		return (this.usuario);
	}

	public void setInmuebleAPublicar(Inmueble inmuebleDePublicacion) {
		this.inmueble = inmuebleDePublicacion;
	}

	public void setCheckIn(LocalDate checkIn) {
		this.checkIn = checkIn;

	}

	public LocalDate getCheckIn() {
		return (this.checkIn);
	}

	public void setCheckOut(LocalDate checkOut) {
		this.checkOut = checkOut;
	}

	public LocalDate getCheckOut() {

		return (this.checkOut);
	}

	public void setPrecio(Double precioDePublicacion) {
		this.precio = precioDePublicacion;
	}

	public Double getPrecio() {
		return (this.precio);
	}

	public Boolean aceptaFormaDePago(String formaDePago) {

		return null;// (getFormasDePago().contains(formaDePago));
	}

	public void agregarFormasDePago(ArrayList<FormasDePagoEnum> formasDePago) {
		this.formasDePago = formasDePago;
	}

	public Boolean tieneComentarios() {
		return (!getComentarios().isEmpty());
	}

	public void addComentario(Comentario comentarioDePublicacion) {
		this.getComentarios().add(comentarioDePublicacion);
	}

	public String informacionDeUsuario() {

		return (getUsuario().getNombre() + " " + getUsuario().getMail() + " " + getUsuario().getTelefono());
	}

	public Boolean cumpleConEspecificaciones(String ciudad, LocalDate checkIn, LocalDate checkOut,
			// TODO Auto-generated method stub

			Integer cantidadDeHuspedes, Double precioMinimo, Double precioMaximo) {
		return false;
	}

	public void configurarMediosDePago(FormasDePagoEnum enumValue) {
		for (FormasDePagoEnum e : FormasDePagoEnum.values()) {
			this.getFormasDePago().add(e);
		}
	} 

	public void addMediosDePagoAll() {
		if (getFormasDePago() == null) {
			setFormasDePago(new ArrayList<FormasDePagoEnum>());
		}
		for (FormasDePagoEnum e : FormasDePagoEnum.values()) {
			this.getFormasDePago().add(e);
		}
	}

}

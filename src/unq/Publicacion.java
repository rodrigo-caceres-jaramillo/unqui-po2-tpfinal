package unq;

import java.time.LocalDate;
import java.util.ArrayList;

public class Publicacion {

	private Usuario usuario;
	private Inmueble inmueble;
	private LocalDate checkIn;
	private LocalDate checkOut;
	private ArrayList<String> formasDePago;
	private Double precio;
	private ArrayList<Comentario> comentarios;

	public void setUsuario(Usuario propietario) {
		this.usuario = propietario;
	}
	
	public Publicacion(Usuario usuario, Inmueble inmueble, LocalDate checkIn, LocalDate checkOut, Double precio) {
		super();
		
		this.usuario = usuario;
		this.inmueble = inmueble;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.precio = precio;

		
		this.formasDePago = new ArrayList<String>();
		this.comentarios = new ArrayList<Comentario>();
	}

	public Publicacion() {
		super();
		this.formasDePago = new ArrayList<String>();
		this.comentarios = new ArrayList<Comentario>();
	}

	public Usuario getUsuario() {

		return (this.usuario);
	}

	public void setInmuebleAPublicar(Inmueble inmuebleDePublicacion) {
		this.inmueble = inmuebleDePublicacion;
	}

	public Inmueble getInmueble() {
		return (this.inmueble);
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

	public void agregarFormasDePago(ArrayList<String> formasDePago) {
		this.formasDePago = formasDePago;
	}

	public ArrayList<String> getFormasDePago() {
		return (this.formasDePago);
	}

	public boolean aceptaFormaDePago(String formaDePago) {

		return (getFormasDePago().contains(formaDePago));
	}

	public void setPrecio(Double precioDePublicacion) {
		this.precio = precioDePublicacion;
	}

	public Double getPrecio() {
		return (this.precio);
	}

	public ArrayList<Comentario> getComentarios() {
		return (this.comentarios);
	}

	public boolean tieneComentarios() {
		return ( !getComentarios().isEmpty()) ;
	}

	public void addComentario(Comentario comentarioDePublicacion) {
		this.getComentarios().add(comentarioDePublicacion);
	}

	public String informacionDeUsuario() {

		return (getUsuario().getNombre() + " "+  getUsuario().getMail() + " "+ getUsuario().getTelefono()   );
	}

	public boolean cumpleConEspecificaciones(String ciudad, LocalDate checkIn, LocalDate checkOut,
			// TODO Auto-generated method stub

			
			Integer cantidadDeHuspedes, Double precioMinimo,Double  precioMaximo) {
		return false;
	}

}

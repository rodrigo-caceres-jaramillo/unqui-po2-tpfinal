package unq;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Publicacion implements Registrable{

	private Usuario propietario;
	private Inmueble inmueble;
	private LocalDate checkIn;
	private LocalDate checkOut;
	private List<FormasDePagoEnum> formasDePago;
	private Double precio;
	private ArrayList<Comentario> comentarios;
	private PoliticaDeCancelacion cancelacion;

	public Publicacion() {
		super();
		this.setComentarios(new ArrayList<Comentario>());
		this.setFormasDePago(new ArrayList<FormasDePagoEnum>());
		setCancelacion(null);

	}

	public Publicacion(Usuario propietario, Inmueble inmueble, LocalDate checkIn, LocalDate checkOut, Double precio) {
		super();

		this.propietario = propietario;
		this.inmueble = inmueble;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.precio = precio;
		this.comentarios = new ArrayList<Comentario>();
		this.setFormasDePago(new ArrayList<FormasDePagoEnum>());
	}

	public Inmueble getInmueble() {
		return (this.inmueble);
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

	public Usuario getPropietario() {
		return propietario;
	}

	public void setPropietario(Usuario propietario) {
		this.propietario = propietario;
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


	public Boolean tieneComentarios() {
		return (!getComentarios().isEmpty());
	}

	public void addComentario(Comentario comentarioDePublicacion) {
		this.getComentarios().add(comentarioDePublicacion);
	}

	public String informacionDeUsuario() {

		return (getPropietario().getNombre() + " " + getPropietario().getMail() + " " + getPropietario().getTelefono());
	}


	public void configurarMediosDePago(FormasDePagoEnum enumValue) {
		for (FormasDePagoEnum e : FormasDePagoEnum.values()) {
			this.getFormasDePago().add(e);
		}
	}

	public void addMediosDePagoAll() {
		for (FormasDePagoEnum formaDePago : FormasDePagoEnum.values()) {
			this.addMedioDePago(formaDePago);
		}
	}

//	public boolean esDelUsuario(Usuario usuario) {
//		return (this.getUsuario().equals(usuario) ) ;
//	}

	public void addMedioDePago(FormasDePagoEnum formaDePago) {
		this.getFormasDePago().add(formaDePago);
	}

	public boolean aceptaFormaDePago(FormasDePagoEnum formaDePago) {
		return (this.getFormasDePago().contains(formaDePago));
	}

	public void actualizarPrecio(Double precio) {
			this.setPrecio(precio);
	}

	public Boolean tienePoliticaCancelacion(PoliticaDeCancelacion cancelacion) {
		
		return getCancelacion().equals(cancelacion);
	}

	public PoliticaDeCancelacion getCancelacion() {
		return cancelacion;
	}

	public void setCancelacion(PoliticaDeCancelacion cancelacion) {
		this.cancelacion = cancelacion;
	}

	@Override
	public void registrarseEn(SitioWeb sitioWeb) {
		sitioWeb.addPublicacion(this);
	}

}
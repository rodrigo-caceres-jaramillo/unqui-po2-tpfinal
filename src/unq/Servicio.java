package unq;


public class Servicio {

	private String nombreDeServicio;
	
	public Servicio() {
		super();
	}
	public Servicio(String nombre) {
		super();
		this.setNombre(nombre);
	}

	public void setNombre(String nombre) {
		this.nombreDeServicio = nombre;
	}

	public String getNombre() {
		return (this.nombreDeServicio);
	}

	public Boolean estaRegistradoEnElSitio(SitioWeb sitio) {
		return (sitio.registraServicioDeInmueble(this));
	}

	public Boolean esUnServicioBrindadoPor(Inmueble inmueble) {
		return (inmueble.registraServicio(this));
	}

}

package unq;


public class TipoDeInmueble implements Registrable{
	private String nombre;

	public String getNombre() {
		return (this.nombre);
	}

	public void setNombre(String nombre) {
		this.nombre = nombre ;
	}

	public boolean esUnTipoDelInmueble(Inmueble inmueble) {
		return (inmueble.esDeTipo(this));
	}

	public boolean estaRegistradoEn(SitioWeb sitio) {
		return (sitio.registraTipoDeInmueble(this)) ;
	}

	@Override
	public void registrarseEn(SitioWeb sitioWeb) {
		sitioWeb.addTipoDeInmueble(this);
	}
}

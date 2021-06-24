package unq;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

@SuppressWarnings("deprecation")
public class SitioDeOfertasObserver implements Observer {
	/*
	 * observador concreto a traves de la interfaz observer 
	 */
	private List<Inmueble> inmueblesDeInteres;
	private IHomePagePublisher implementadorDePublicaciones;
	private SitioWeb sitio;

	
	public SitioDeOfertasObserver(SitioWeb sitio) {
		super();
		this.setInmueblesDeInteres(new ArrayList<Inmueble>());
		this.sitio.addObserver(this);
	}

	public void setInmueblesDeInteres(ArrayList<Inmueble> inmueblesDeInteres) {
		this.inmueblesDeInteres = inmueblesDeInteres;
	}

	public List<Inmueble> getInmueblesDeInteres() {

		return (this.inmueblesDeInteres);
	}

	public void addInmuebleDeInteres(Inmueble inmueble) {
		this.getInmueblesDeInteres().add(inmueble);
	}

	public Boolean esUnaPublicacionInteresante(Publicacion publi) {

		return (this.getInmueblesDeInteres().contains(publi.getInmueble()));
	}

	public void setImplementadorDePublicaciones(IHomePagePublisher publisher) {
		this.implementadorDePublicaciones = publisher;
	}

	public IHomePagePublisher getImplementadorDePublicaciones() {
		return (this.implementadorDePublicaciones);
	}

	public void lanzarAvisosDeOfertaDeInmuebleEn(Publicacion publi) {
		if (this.esUnaPublicacionInteresante(publi)) {
			this.realizarOfertaConImplementador(publi);
		}
	}

	public void realizarOfertaConImplementador(Publicacion publi) {
		String contenidoDeAviso = "hay una baja de precio en el inmueble de la publi";

		this.getImplementadorDePublicaciones().publish(contenidoDeAviso);

	}

	@Override
	public void update(Observable o , Object arg) {
			Publicacion publi = (Publicacion) arg;	
			this.lanzarAvisosDeOfertaDeInmuebleEn(publi);
	}

	
	
	
}

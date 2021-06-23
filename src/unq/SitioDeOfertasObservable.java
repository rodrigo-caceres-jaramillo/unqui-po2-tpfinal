package unq;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class SitioDeOfertasObservable extends Observable {

	private List<Inmueble> inmueblesDeInteres;
	private IHomePagePublisher implementadorDePublicaciones;

	public SitioDeOfertasObservable() {
		super();
		this.setInmueblesDeInteres( new ArrayList<Inmueble>() );
	}
	
	
	public void setInmueblesDeInteres(ArrayList<Inmueble> inmueblesDeInteres) {
			this.inmueblesDeInteres =  inmueblesDeInteres;
	}

	

	public List<Inmueble> getInmueblesDeInteres() {
		
		return (this.inmueblesDeInteres);
	}

	public void addInmuebleDeInteres(Inmueble inmueble) {
			this.getInmueblesDeInteres().add(inmueble);	
	}

	public Boolean esUnaPublicacionInteresante(Publicacion publi) {
		
		return ( this.getInmueblesDeInteres().contains(publi.getInmueble()));
	}

	public void setImplementadorDePublicaciones(IHomePagePublisher publisher) {
			this.implementadorDePublicaciones=publisher;
	}

	public IHomePagePublisher getImplementadorDePublicaciones() {
		return (this.implementadorDePublicaciones);
	}


	public void lanzarAvisoDeOfertaDeInmuebleEn(Publicacion publi) {
		if (this.esUnaPublicacionInteresante(publi)) {
		this.realizarOfertaConImplementador(publi);
		}
	}


	public void realizarOfertaConImplementador(Publicacion publi) {
		String contenidoDeAviso = "hay una baja de precio en el inmueble de la publi";

			this.getImplementadorDePublicaciones().publish(contenidoDeAviso);
		
	}

}

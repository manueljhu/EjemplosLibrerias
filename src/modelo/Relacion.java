package modelo;

public class Relacion {
	private String campoOrigen;
	private String campoDestino;
	private boolean campoOrigenRelleno;
	private boolean campoDestinoRelleno;

	public Relacion() {
	}

	public Relacion(String campoOrigen, String campoDestino) {
		this.campoOrigen = campoOrigen;
		this.campoDestino = campoDestino;
	}

	public String getCampoOrigen() {
		return campoOrigen;
	}

	public void setCampoOrigen(String campoOrigen) {
		this.campoOrigen = campoOrigen;
	}

	public String getCampoDestino() {
		return campoDestino;
	}

	public void setCampoDestino(String campoDestino) {
		this.campoDestino = campoDestino;
	}

	public boolean isCampoOrigenRelleno() {
		return campoOrigenRelleno;
	}

	public void setCampoOrigenRelleno(boolean campoOrigenRelleno) {
		this.campoOrigenRelleno = campoOrigenRelleno;
	}

	public boolean isCampoDestinoRelleno() {
		return campoDestinoRelleno;
	}

	public void setCampoDestinoRelleno(boolean campoDestinoRelleno) {
		this.campoDestinoRelleno = campoDestinoRelleno;
	}
}

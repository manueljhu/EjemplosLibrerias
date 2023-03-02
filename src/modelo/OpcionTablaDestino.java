package modelo;

public class OpcionTablaDestino {

	private String descripcion;
	private String valorSwitch;
	private String tabla;

	public OpcionTablaDestino() {
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getValorSwitch() {
		return valorSwitch;
	}

	public void setValorSwitch(String valorSwitch) {
		this.valorSwitch = valorSwitch;
	}

	public String getTabla() {
		return tabla;
	}

	public void setTabla(String tabla) {
		this.tabla = tabla;
	}

	@Override
	public String toString() {
		return "OpcionTablaDestino{" + "descripcion=" + descripcion + ", tabla=" + tabla + '}';
	}
}

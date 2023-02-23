package modelo;

import java.util.ArrayList;

public class RelacionCampos {
	private String tablaOrigen;
    private String tablaDestino;
    private String tipoOperacion;
    private boolean vaciarDestino;

    private ArrayList<Relacion> relacionColumnas;

    public RelacionCampos() {
        relacionColumnas = new ArrayList<>();
    }        

   
	public String getTablaOrigen() {
        return tablaOrigen;
    }

    public void setTablaOrigen(String tablaOrigen) {
        this.tablaOrigen = tablaOrigen;
    }

    public String getTablaDestino() {
        return tablaDestino;
    }

    public void setTablaDestino(String tablaDestino) {
        this.tablaDestino = tablaDestino;
    }    

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }
    
    public boolean isVaciarDestino() {
        return vaciarDestino;
    }

    public void setVaciarDestino(boolean vaciarDestino) {
        this.vaciarDestino = vaciarDestino;
    }

    public ArrayList<Relacion> getRelacionColumnas() {
        return relacionColumnas;
    }

    public void setRelacionColumnas(ArrayList<Relacion> relacionColumnas) {
        this.relacionColumnas = relacionColumnas;
    }

    public void inicializarRelacionColumnas() {
        relacionColumnas = new ArrayList<>();
    }
    
    
}

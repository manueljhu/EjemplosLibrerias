package ejemplos;

import java.util.ArrayList;

import modelo.OpcionTablaDestino;

public class SentenciasSQL {
	String tablasOrigen = "SELECT TABLE_NAME AS name FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_TYPE='BASE TABLE' ORDER BY TABLE_NAME";
	String vistasOrigen = "SELECT TABLE_NAME AS name FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_TYPE='VIEW' ORDER BY TABLE_NAME";
	
	String nombreTabla = "aqui va el nombre de la tabla";
	
	String columnasTabla = "SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME='" + nombreTabla + "'";
	
	
	/* PARA EL COMBOBOX DE LA TABLA DESTINO UTILIZAREMOS LA OPCION Descripcion DEL OBJETO OpcionTablaDestino 
	 * Y CUANDO SELECCIONEMOS UN VALOR EN EL COMBOBOX, DEBEREMOS BUSCAR EN EL ARRAY EL OBJETO QUE SE CORRESPONDE CON EL VALOR SELECCIONADO
	 * EN EL DESPLEGABLE Y OBTENER EL VALOR DE LA VARIABLE tabla DEL OBJETO OpcionTablaDestino Y PASARLO A LA
	 * FUNCION QUE NOS DEVUELVE LOS NOMBRES DE LAS COLUMNA PARA CARGARLOS EN LA TABLA */
	ArrayList<OpcionTablaDestino> tablasDestino;
	
	public void rellenaTablasDestino() {
		OpcionTablaDestino tabla;
        tablasDestino = new ArrayList<>();
        
        tabla = new OpcionTablaDestino();
        tabla.setDescripcion("Agentes");
        tabla.setValorSwitch("Agentes");
        tabla.setTabla("AGENTG");
        tablasDestino.add(tabla);

        tabla = new OpcionTablaDestino();
        tabla.setDescripcion("Almacenes");
        tabla.setValorSwitch("Almacenes");
        tabla.setTabla("ALMACE");
        tablasDestino.add(tabla);

        tabla = new OpcionTablaDestino();
        tabla.setDescripcion("Articulos");
        tabla.setValorSwitch("Articulos");
        tabla.setTabla("ARTICU");
        tablasDestino.add(tabla);

        tabla = new OpcionTablaDestino();
        tabla.setDescripcion("Asientos");
        tabla.setValorSwitch("Asientos");
        tabla.setTabla("APUN22");
        tablasDestino.add(tabla);

        tabla = new OpcionTablaDestino();
        tabla.setDescripcion("Bancos clientes");
        tabla.setValorSwitch("BancosClientes");
        tabla.setTabla("DATBAN");
        tablasDestino.add(tabla);

        tabla = new OpcionTablaDestino();
        tabla.setDescripcion("Bancos proveedores");
        tabla.setValorSwitch("BancosProveedores");
        tabla.setTabla("DATBAN");
        tablasDestino.add(tabla);

        tabla = new OpcionTablaDestino();
        tabla.setDescripcion("Bancos empresa");
        tabla.setValorSwitch("BancosEmpresa");
        tabla.setTabla("BANCOS");
        tablasDestino.add(tabla);

        tabla = new OpcionTablaDestino();
        tabla.setDescripcion("Clientes");
        tabla.setValorSwitch("Clientes");
        tabla.setTabla("CLIENT");
        tablasDestino.add(tabla);

        tabla = new OpcionTablaDestino();
        tabla.setDescripcion("Contactos clientes");
        tabla.setValorSwitch("ContactosClientes");
        tabla.setTabla("CONTAC");
        tablasDestino.add(tabla);

        tabla = new OpcionTablaDestino();
        tabla.setDescripcion("Contactos proveedores");
        tabla.setValorSwitch("ContactosProveedores");
        tabla.setTabla("CONTAC");
        tablasDestino.add(tabla);

        tabla = new OpcionTablaDestino();
        tabla.setDescripcion("Cuentas contables");
        tabla.setValorSwitch("CuentasContables");
        tabla.setTabla("CUENTA");
        tablasDestino.add(tabla);

        tabla = new OpcionTablaDestino();
        tabla.setDescripcion("Direcciones clientes");
        tabla.setValorSwitch("DireccionesClientes");
        tabla.setTabla("DIRECC");
        tablasDestino.add(tabla);

        tabla = new OpcionTablaDestino();
        tabla.setDescripcion("Direcciones proveedores");
        tabla.setValorSwitch("DireccionesProveedores");
        tabla.setTabla("DIRECC");
        tablasDestino.add(tabla);

        tabla = new OpcionTablaDestino();
        tabla.setDescripcion("Facturas emitidas");
        tabla.setValorSwitch("FacturasEmitidas");
        tabla.setTabla("FACEMI");
        tablasDestino.add(tabla);

        tabla = new OpcionTablaDestino();
        tabla.setDescripcion("Facturas recibidas");
        tabla.setValorSwitch("FacturasRecibidas");
        tabla.setTabla("FACREC");
        tablasDestino.add(tabla);

        tabla = new OpcionTablaDestino();
        tabla.setDescripcion("Familias");
        tabla.setValorSwitch("Familias");
        tabla.setTabla("FAMILI");
        tablasDestino.add(tabla);

        tabla = new OpcionTablaDestino();
        tabla.setDescripcion("Formas de pago");
        tabla.setValorSwitch("FormasPago");
        tabla.setTabla("FORPAG");
        tablasDestino.add(tabla);

        tabla = new OpcionTablaDestino();
        tabla.setDescripcion("Marcas articulos");
        tabla.setValorSwitch("MarcasArticulos");
        tabla.setTabla("MARART");
        tablasDestino.add(tabla);

        tabla = new OpcionTablaDestino();
        tabla.setDescripcion("Previsiones");
        tabla.setValorSwitch("Previsiones");
        tabla.setTabla("EFECTO");
        tablasDestino.add(tabla);

        tabla = new OpcionTablaDestino();
        tabla.setDescripcion("Proveedores");
        tabla.setValorSwitch("Proveedores");
        tabla.setTabla("PROVEE");
        tablasDestino.add(tabla);

        tabla = new OpcionTablaDestino();
        tabla.setDescripcion("Stocks");
        tabla.setValorSwitch("Stocks");
        tabla.setTabla("ALMA01");
        tablasDestino.add(tabla);

        tabla = new OpcionTablaDestino();
        tabla.setDescripcion("Subfamilias articulos");
        tabla.setValorSwitch("SubfamiliasArticulos");
        tabla.setTabla("SUBFAM");
        tablasDestino.add(tabla);
	}

}

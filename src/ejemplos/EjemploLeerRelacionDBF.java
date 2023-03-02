package ejemplos;

import nl.knaw.dans.common.dbflib.Field;
import nl.knaw.dans.common.dbflib.IfNonExistent;
import nl.knaw.dans.common.dbflib.Record;
import nl.knaw.dans.common.dbflib.Table;
import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.InputStream;
import modelo.*;

public class EjemploLeerRelacionDBF {
	
	public static ArrayList<Almacen> almacenes;
 
	public static void main(String[] args) {
		almacenes = new ArrayList<>();
		RelacionCampos relacionCampos = new RelacionCampos();
		
		String fichero = "C:\\Users\\Manuel\\Desktop\\prueba.dbf";
		String tipoOperacion = "ACTUALIZAR";
		Boolean vaciarDestino = false;
		String tipoOrigenDatos = "DBF";
		String tablaOrigen = "TABLA_ORIGEN";
		String tablaDestino = "Almacenes";
		
		ArrayList<Relacion> rel = new ArrayList<>();
		Relacion relacion;
		
		relacion = new Relacion();
		relacion.setCampoOrigen("Nombre");
		relacion.setCampoDestino("nom");

		rel.add(relacion);

		

		relacionCampos.setTablaOrigen(tablaOrigen);
		relacionCampos.setTablaDestino(tablaDestino);
		relacionCampos.setVaciarDestino(vaciarDestino);
		relacionCampos.setTipoOperacion(tipoOperacion);
		relacionCampos.setRelacionColumnas(rel);
		
		leerDatosDBF(fichero, tablaDestino, relacionCampos);
		
		
	}
	
	
	
	public static void leerDatosDBF(String rutaFichero, String tablaDestino, RelacionCampos relacionCampos) {
		Table table = new Table(new File(rutaFichero));//Sustituye por la ruta donde se encuentra el fichero
        int filas = 0;
        
        switch (tablaDestino) {
		case "Almacenes":
			Almacen almacen;

            try {
                table.open(IfNonExistent.ERROR);
                List<Field> fields = table.getFields();
                filas = fields.size();

                for (int i = 0; i <= filas; i++) {
                    almacen = new Almacen();
                    Record record = table.getRecordAt(i);
                    
                    for (int z = 0; z < relacionCampos.getRelacionColumnas().size(); z++) {
                    	
                        AlmacenSwitch(relacionCampos, z, almacen, record);
                    }
                    almacenes.add(almacen);
                    System.out.println(almacen);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    table.close();
                } catch (IOException ex) {
                    System.out.println("Error: " + ex);
                }
            }
            break;

		default:
			break;
		}
	}
	
	public static void AlmacenSwitch(RelacionCampos relacionCampos, int z, Almacen almacen, Record record) {
        ArrayList<Relacion> relacion = relacionCampos.getRelacionColumnas();
        
        switch (relacion.get(z).getCampoDestino()) {
            case "nom":
                almacen.setNom(record.getTypedValue(relacion.get(z).getCampoOrigen()).toString().trim());
                break;
            case "ser":
                almacen.setSer(record.getTypedValue(relacion.get(z).getCampoOrigen()).toString());
                break;
            case "se2":
                almacen.setSe2(record.getTypedValue(relacion.get(z).getCampoOrigen()).toString());
                break;
            case "age":
                almacen.setAge(record.getTypedValue(relacion.get(z).getCampoOrigen()).toString());
                break;

        }
    }
}

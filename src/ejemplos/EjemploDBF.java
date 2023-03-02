package ejemplos;


import nl.knaw.dans.common.dbflib.Field;
import nl.knaw.dans.common.dbflib.IfNonExistent;
import nl.knaw.dans.common.dbflib.Record;
import nl.knaw.dans.common.dbflib.Table;
import java.util.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class EjemploDBF {

	public static void main(String[] args) { 
		// TODO Esbozo de método generado automáticamente
		//Leer columnas de tabla dbf 
		//Sustituir esta ruta por el fichero local
		String fichero = "C:\\Users\\Manuel\\Desktop\\prueba.dbf";//Sustituye por la ruta donde se encuentra el fichero
        Table table = new Table(new File(fichero));
        
        try {
            table.open(IfNonExistent.ERROR);
            List<Field> fields = table.getFields();
            for (int i = 0; i < fields.size(); i++) {
                Field columna = fields.get(i);
                System.out.println(columna.getName());

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
        
        System.out.println("Fin lectura columnas \n");
        
      //Ejemplo de lectura
        Table table2 = new Table(new File(fichero));//Sustituye por la ruta donde se encuentra el fichero
        try {
            table2.open(IfNonExistent.ERROR);
            List<Field> fields = table2.getFields();
            for (int z = 0; z <= table2.getRecordCount(); z++) {
                Record record = table2.getRecordAt(z);
                if (record.isMarkedDeleted() != true) {
                    System.out.println(record.getTypedValue("Nombre").toString()); //Sustituye por el nombre de la columna origen                                          
                }
            }

        } catch (Exception e) {
             //e.printStackTrace();
        } finally {
            try {
                table2.close();
            } catch (IOException ex) {
                System.out.println("Error: " + ex);
            }
        }
        
        System.out.println("Fin lectura valores columna NOMBRE \n");
        
        
	}

}

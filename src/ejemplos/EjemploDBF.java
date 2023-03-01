package ejemplos;

import nl.knaw.dans.common.dbflib.Field;
import nl.knaw.dans.common.dbflib.IfNonExistent;
import nl.knaw.dans.common.dbflib.Record;
import nl.knaw.dans.common.dbflib.Table;
import java.util.List;

import javax.swing.JFileChooser;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class EjemploDBF {

	public static void main(String[] args) {
		// TODO Esbozo de método generado automáticamente
		// Leer columnas de tabla dbf
		// Sustituir esta ruta por el fichero local
		JFileChooser selectorArchivoGuardar = new JFileChooser();
		JFileChooser selectorArchivoLeer = new JFileChooser();
		
		String rutaGuardado = "";

		selectorArchivoGuardar.setDialogType(JFileChooser.OPEN_DIALOG);
		selectorArchivoGuardar.setDialogTitle("Selecciona el directorio donde deseas");
		selectorArchivoGuardar.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

		try {
			if(selectorArchivoGuardar.showSaveDialog(null) == selectorArchivoGuardar.APPROVE_OPTION) {
				rutaGuardado = selectorArchivoGuardar.getSelectedFile().getAbsolutePath();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		System.out.println(rutaGuardado);

		String fichero = rutaGuardado;//"C:\\Users\\Pc\\Desktop\\CONVERSOR MAESTRO\\recursos de desarrollo\\librerias para el conversor\\dbf\\archivos\\productos.dbf";// Sustituye
		// el
		// fichero
		Table table = new Table(new File(fichero));

		try {
			table.open(IfNonExistent.ERROR);
			List<Field> fields = table.getFields();
			int nFilas = table.getRecordCount();

			for (int i = 0; i < fields.size(); i++) {
				Field columna = fields.get(i);
				
				 
				for (int z = 0; z < table.getRecordCount(); z++) {

					Record record = table.getRecordAt(z);
					if (record.isMarkedDeleted() != true) {
						System.out.println(
								"Fila " + z + " " + columna.getName() + ":" + record.getTypedValue(columna.getName()));
					}					
				}

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

		// Ejemplo de lectura
		/*
		 * Table table2 = new Table(new File(fichero));// Sustituye por la ruta donde se
		 * encuentra el fichero try { table2.open(IfNonExistent.ERROR); List<Field>
		 * fields = table2.getFields(); for (int z = 0; z <= table2.getRecordCount();
		 * z++) { Record record = table2.getRecordAt(z); if (record.isMarkedDeleted() !=
		 * true) { // String valor = record.getTypedValue("EXISTENCIA").toString();
		 * System.out.println(Double.parseDouble(record.getTypedValue("EXISTENCIA").
		 * toString())); // Sustituye // por el // nombre de // la // columna // origen
		 * } }
		 * 
		 * } catch (Exception e) { // e.printStackTrace(); // System.out.println(e); }
		 * finally { try { table2.close(); } catch (IOException ex) {
		 * System.out.println("Error: " + ex); } }
		 * 
		 * System.out.println("Fin lectura valores columna EXISTENCIA \n");
		 */

	}

	public static Object devuelveValor(Table fichero, int fila, String columna) {
		Object valor = null;
		Table table2 = fichero;// Sustituye por la ruta donde se encuentra el fichero
		try {
			table2.open(IfNonExistent.ERROR);
			List<Field> fields = table2.getFields();

			Record record = table2.getRecordAt(fila);
			if (record.isMarkedDeleted() != true) {
				// String valor = record.getTypedValue("EXISTENCIA").toString();
				// System.out.println(Double.parseDouble(record.getTypedValue("EXISTENCIA").toString()));
				// // Sustituye
				valor = record.getTypedValue(columna); // por el
				// nombre de
				// la
				// columna
				// origen
			}

		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println(e);
		} finally {
			try {
				table2.close();
			} catch (IOException ex) {
				System.out.println("Error: " + ex);
			}
		}

		return valor;
	}

}

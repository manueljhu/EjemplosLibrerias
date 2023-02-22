package ejemplos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.sl.usermodel.Resources;
import org.apache.poi.ss.usermodel.CellType;

public class EjemploEXCEL {
	
	public static void main(String[] args) {
		// TODO Esbozo de método generado automáticamente
		 
		//Sustituir esta ruta por el fichero local
		String fichero = "C:\\Users\\Manuel\\Desktop\\CONVERSOR MAESTRO\\recursos de desarrollo\\librerias para el conversor\\excel\\archivos\\clientes.xls";

		ArrayList<String> columnas = devuelveColumnasExcel(fichero);

		for (int i = 0; i < columnas.size(); i++) {
			System.out.println(columnas.get(i));
		}
		
		System.out.println("\nFin lectura de nombres de columna \n");
		
		int numeroDeFilas = devuleveNFilasExcel(fichero);
		
		System.out.println("El fichero excel tiene "+numeroDeFilas+" filas.\n");
		
		String valorColumna = devuelveValorColumna(fichero, 1, "nombre");
		
		System.out.println("El valor de la columna nombre en la fila 1 es: "+valorColumna+"\n");
		
		
		System.out.println("Valores columna nombre: \n");
		leerDatosExcel(fichero, "nombre");
		
		
	}
	
	public void setResourcesPath() {
		
	}
	
	
	
	
	// FUNCION QUE DEVUELVE LOS NOMBRES DE COLUMNA DE UN EXCEL
	public static ArrayList<String> devuelveColumnasExcel(String fichero) {
		ArrayList<String> columnas = new ArrayList<>();
		InputStream excelStream = null;
		try {
			excelStream = new FileInputStream(fichero);

			HSSFWorkbook hssfWorkbook = new HSSFWorkbook(excelStream);
			HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(0);
			HSSFRow hssfRowCabecera;

			HSSFCell cell;
			hssfRowCabecera = hssfSheet.getRow(0);

			for (int c = 0; c < hssfRowCabecera.getLastCellNum(); c++) {
				columnas.add(hssfRowCabecera.getCell(c).getStringCellValue());
			}

		} catch (FileNotFoundException fileNotFoundException) {
			System.out.println("The file not exists (No se encontró el fichero): " + fileNotFoundException);
		} catch (IOException ex) {
			System.out.println("Error in file procesing (Error al procesar el fichero): " + ex);
		} finally {
			try {
				excelStream.close();
			} catch (IOException ex) {
				System.out.println(
						"Error in file processing after close it (Error al procesar el fichero después de cerrarlo): "
								+ ex);
			}
		}

		return columnas;
	}

	// FUNCION QUE DEVUELVE EN NUMERO DE FILAS DE UN EXCEL
	public static int devuleveNFilasExcel(String fichero) {
		int filas = 0;
		InputStream excelStream = null;

		try {
			excelStream = new FileInputStream(fichero);

			HSSFWorkbook hssfWorkbook = new HSSFWorkbook(excelStream);
			HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(0);
			HSSFRow hssfRow;
			HSSFCell cell;
			filas = hssfSheet.getLastRowNum();

		} catch (FileNotFoundException fileNotFoundException) {
			System.out.println("The file not exists (No se encontró el fichero): " + fileNotFoundException);
		} catch (IOException ex) {
			System.out.println("Error in file procesing (Error al procesar el fichero): " + ex);
		} finally {
			try {
				excelStream.close();
			} catch (IOException ex) {
				System.out.println(
						"Error in file processing after close it (Error al procesar el fichero después de cerrarlo): "
								+ ex);
			}
		}
		return filas;
	}

	// FUNCION QUE DEVUELVE EL VALOR DE UNA COLUMNA RECIBIENDO COMO PARAMETROS LA
	// RUTA DEL FICHERO, LA FILA Y EL NOMBRE DE LA COLUMNA DE LA QUE QUEREMOS
	// DEVOLVER EL VALOR

	public static String devuelveValorColumna(String fichero, int fila, String nombreColumna) {
		String valor = "";
		InputStream excelStream = null;
		try {
			excelStream = new FileInputStream(fichero);

			HSSFWorkbook hssfWorkbook = new HSSFWorkbook(excelStream);
			HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(0);
			HSSFRow hssfRowCabecera;
			HSSFRow hssfRow;
			HSSFCell cell;
			hssfRowCabecera = hssfSheet.getRow(0);
			hssfRow = hssfSheet.getRow(fila);
			for (int c = 0; c < hssfRow.getLastCellNum(); c++) {
				if (hssfRowCabecera.getCell(c).getStringCellValue().equals(nombreColumna)) {
					if (hssfRow.getCell(c) != null) {
						hssfRow.getCell(c).setCellType(CellType.STRING);
						valor = hssfRow.getCell(c).getStringCellValue();
					}
				}
			}

		} catch (FileNotFoundException fileNotFoundException) {
			System.out.println("The file not exists (No se encontró el fichero): " + fileNotFoundException);
		} catch (IOException ex) {
			System.out.println("Error in file procesing (Error al procesar el fichero): " + ex);
		} finally {
			try {
				excelStream.close();
			} catch (IOException ex) {
				System.out.println(
						"Error in file processing after close it (Error al procesar el fichero después de cerrarlo): "
								+ ex);
			}
		}

		return valor;
	}

	// FUNCION PARA RECORRER Y LEER DATOS DEL EXCEL

	public static void leerDatosExcel(String rutaFichero, String columna) {
		int numeroFilas = devuleveNFilasExcel(rutaFichero);
		for (int i = 1; i < numeroFilas; i++) {
			String propiedadColumna = devuelveValorColumna(rutaFichero, i, columna);// REEMPLAZAR "NOMBRE
																								// COLUMNA" POR EL
																								// NOMBRE DE LA COLUMNA
			System.out.println(propiedadColumna);
			// PARA GUARDAR LOS PARAMETROS DE UN OBJETO SERIA ALGO COMO LO SIGUIENTE:

			/*
			 * Cliente cliente = new Cliente();
			 * cliente.setCod(devuelveValorColumna(rutaFichero, i, "CODIGO"));
			 */

			// EN CASO DE QUE EL TIPO DE DATO DESTINO SEA DIFERENTE A STRING, HABRIA QUE
			// REALIZAR LA CONVERSION DE DATO DE STRINFG AL TIPO QUE CORRESPONDA
		}

	}

}

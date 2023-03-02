package ejemplos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import modelo.Relacion;
import modelo.RelacionCampos;

public class EjemploGuardarFicheroRelacion {

	public static void main(String[] args) {
		RelacionCampos relacionCampos = new RelacionCampos();

		String fichero = "C:\\Users\\Pc\\Desktop\\ejemplofichero.inv";
		String tipoOperacion = "ACTUALIZAR";
		Boolean vaciarDestino = false;
		String tipoOrigenDatos = "SQL";
		String tablaOrigen = "TABLA_ORIGEN";
		String tablaDestino = "tab_des";

		ArrayList<Relacion> rel = new ArrayList<>();
		Relacion relacion;
		for (int i = 0; i < 7; i++) {
			relacion = new Relacion();
			relacion.setCampoOrigen("CAMPO" + i);
			relacion.setCampoDestino("cam" + i);

			rel.add(relacion);

		}

		relacionCampos.setTablaOrigen(tablaOrigen);
		relacionCampos.setTablaDestino(tablaDestino);
		relacionCampos.setVaciarDestino(vaciarDestino);
		relacionCampos.setTipoOperacion(tipoOperacion);
		relacionCampos.setRelacionColumnas(rel);

		//guardarRelacion(fichero, relacionCampos);

		relacionCampos = leerRelacion(fichero, tipoOrigenDatos);

		System.out.println("Tabla destino: " + relacionCampos.getTablaDestino());
		System.out.println("Tabla Origen: " + relacionCampos.getTablaOrigen());
		System.out.println("Operacion destino: " + relacionCampos.getTipoOperacion());
		System.out.println("Vaciar destino: " + relacionCampos.isVaciarDestino());
		

		for (int i = 0; i < relacionCampos.getRelacionColumnas().size(); i++) {
			System.out.println("Columna origen: " + relacionCampos.getRelacionColumnas().get(i).getCampoOrigen()
					+ " - Columna destino: " + relacionCampos.getRelacionColumnas().get(i).getCampoDestino());
		}

	}

	/*
	 * FUNCION QUE GUARDA LA RELACION DE LAS COLUMNAS RECIBIENDO COMO PARAMETROS: LA
	 * RUTA DONDE VAMOS A GUARDAR EL FICHERO, LA TABLA DONDE SE ENCUENTRAN LAS
	 * RELACIONES DE COLUMNAS, EL COMBOBOX DE LA TABLA ORIGEN PARA ALMACENAR LA
	 * TABLA SELECCIONADA, EL COMBOBOX DE LA TABLA DESTINO PARA ALMACENAR LA TABLA
	 * SELECCIONADA Y EL TIPO DE ORIGEN DE DATOS (SQL/DBF/EXCEL) NOTA: SOLO SE
	 * GUARDA EL NOMBRE DE LA TABLA ORIGEN CUANDO EL TIPO DE ORIGEN DE DATOS ES SQL
	 */
	public static void guardarRelacion(String ruta, RelacionCampos relacionCampos) {
		FileWriter fichero = null;
		PrintWriter pw = null;

		try {// busca el fichero para escribir en el
			fichero = new FileWriter(ruta);
			pw = new PrintWriter(fichero);

			pw.println("TabOri:" + relacionCampos.getTablaOrigen());
			pw.println("TabDes:" + relacionCampos.getTablaDestino());
			pw.println("TipOpe:" + relacionCampos.getTipoOperacion());
			pw.println("VacDes:" + relacionCampos.isVaciarDestino());

			ArrayList<Relacion> rel = relacionCampos.getRelacionColumnas();
			for (int i = 0; i < rel.size(); i++) {
				Relacion relacioncolumnas = rel.get(i);
				pw.println(relacioncolumnas.getCampoOrigen() + "-" + relacioncolumnas.getCampoDestino());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// Nuevamente aprovechamos el finally para
				// asegurarnos que se cierra el fichero.
				if (null != fichero) {
					fichero.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	/*
	 * FUNCION QUE LEE LA RELACION DESDE FICHERO Y LO CARGA EN LA TABLA RECIBIENDO
	 * LOS SIGUIENTES PARAMETROS: LA RUTA DEL FICHERO CON LAS RELACIONES, LA TABLA
	 * DONDE SE CARGARAN LAS RELACIONES DE COLUMNAS, LA TABLA DE LA COLUMNAS ORIGEN,
	 * LA TABLA DE LAS COLUMNAS DESTINO, EL DESPLEGABLE DE LAS TABLAS ORIGEN, EL
	 * DESPLEGABLE DE LAS TABLAS DESTINO Y EL ORIGEN DE TIPO DE DATOS
	 * (SQL/DBF/EXCEL)
	 */
	public static RelacionCampos leerRelacion(String ruta, String tipoOrigenDatos) {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		RelacionCampos relacionCampos = new RelacionCampos();

		try {
			// Apertura del fichero y creacion de BufferedReader para poder hacer una
			// lectura comoda (disponer del metodo readLine()).

			archivo = new File(ruta);
			// en caso de no existir un fichero con ese nombre se crea uno y se muestra por
			// pantalla lo siguiente
			if (!archivo.exists()) {

			} else {
				fr = new FileReader(archivo);
				br = new BufferedReader(fr);
				// Lectura del fichero
				String linea;
				Relacion relacioncolumna;
				ArrayList<String> lineas = new ArrayList<>();

				while ((linea = br.readLine()) != null) {
					lineas.add(linea);
				}

				for (int i = 0; i < lineas.size(); i++) {
					String lineaLeida = lineas.get(i);

					if (i >= 0 && i <= 3) {
						String id = lineaLeida.substring(0, 7);
						String valor = lineaLeida.substring(7, lineaLeida.length());
						switch (id) {
						case "TabOri:":
							if (!valor.equals("")) {
								relacionCampos.setTablaOrigen(valor);
							}

							break;
						case "TabDes:":
							if (!valor.equals("")) {
								relacionCampos.setTablaDestino(valor);
							}
							break;
						case "TipOpe:":
							if (!valor.equals("")) {
								relacionCampos.setTipoOperacion(valor);

							}
							break;
						case "VacDes:":
							if (!valor.equals("")) {
								relacionCampos.setVaciarDestino(Boolean.parseBoolean(valor));
							}
							break;
						}
					} else {
						String[] partes = lineaLeida.split("-");
						relacioncolumna = new Relacion();
						if (!partes[0].equals("")) {
							relacioncolumna.setCampoOrigen(partes[0]);
							relacioncolumna.setCampoOrigenRelleno(true);
						}

						if (!partes[1].equals("")) {
							relacioncolumna.setCampoDestino(partes[1]);
							relacioncolumna.setCampoDestinoRelleno(true);
						}
						relacionCampos.getRelacionColumnas().add(relacioncolumna);

					}

				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// En el finally cerramos el fichero, para asegurarnos que se cierra tanto si
			// todo va bien como si salta una excepcion.
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return relacionCampos;

	}
}

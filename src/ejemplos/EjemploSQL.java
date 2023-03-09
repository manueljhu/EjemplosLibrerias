package ejemplos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class EjemploSQL {

	public static void main(String[] args) {
		// TODO Esbozo de método generado automáticamente
		
		String ipServidor = "TECNICO-PC";
		String instancia = "GPBUSINESS";
		String empresa = "02";
		String contrasena = "Fsgpsql00";
		String usuario = "sa";

		String urlConexionBBDD = "jdbc:jtds:sqlserver://" + ipServidor + ";instance=" + instancia + ";DatabaseName=GpBusiness" + empresa;
		Connection cn = null;
		try {

			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			cn = DriverManager.getConnection(urlConexionBBDD, usuario, contrasena);

			JOptionPane.showMessageDialog(null, "Conexi�n establecida correctamente.", "Aviso",
					JOptionPane.INFORMATION_MESSAGE);

		} catch (Exception e) {
			System.out.println(e);
		}

		// SELECT
		String sentencia = "SELECT * FROM CLIENT";

		try {

			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(sentencia);

			while (rs.next()) {
				System.out.println(rs.getString("nom"));

			}

			rs.close();
			st.close();
			cn.close();
			//// System.out.println("Desconectado");
		} catch (Exception e) {

			System.out.println("Error al recuperar datos " + e);
		}
		
		try {

			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			cn = DriverManager.getConnection(urlConexionBBDD, usuario, contrasena);

			

		} catch (Exception e) {
			System.out.println(e);
		}

		// SELECT
		String sentencia2 = "DELETE FROM CLIENT WHERE nom='JONATHAN'";

		try {

			Statement st = cn.createStatement();
			
			st.executeUpdate(sentencia2);

			

			
			st.close();
			cn.close();
			//// System.out.println("Desconectado");
		} catch (Exception e) {

			System.out.println("Error al recuperar datos " + e);
		}
		
		try {

			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			cn = DriverManager.getConnection(urlConexionBBDD, usuario, contrasena);

			

		} catch (Exception e) {
			System.out.println(e);
		}

		// SELECT
		String sentencia3 = "UPDATE CLIENT SET nom='VENTA CONTADO' WHERE nom='VENTA DIRECTA'";

		try {

			Statement st = cn.createStatement();
			
			st.executeUpdate(sentencia3);

			

			
			st.close();
			cn.close();
			//// System.out.println("Desconectado");
		} catch (Exception e) {

			System.out.println("Error al recuperar datos " + e);
		}
	}

}

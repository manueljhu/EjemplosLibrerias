package vista;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import modelo.Relacion;
import modelo.RelacionCampos;

import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class EjemploTablas extends JFrame {

	private JPanel contentPane;
	private JTable columnaOrigen;
	private JTable columnaDestino;
	private JTable tablaRelacion;
	
	
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane_2;
	
	/** Objeto donde guardaremos la relacion de los campos*/
	private RelacionCampos relacionCampos = new RelacionCampos();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
		            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
		                if ("Windows".equals(info.getName())) {
		                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
		                    break;
		                }
		            }
		        } catch (ClassNotFoundException ex) {
		            java.util.logging.Logger.getLogger(EjemploTablas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		        } catch (InstantiationException ex) {
		            java.util.logging.Logger.getLogger(EjemploTablas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		        } catch (IllegalAccessException ex) {
		            java.util.logging.Logger.getLogger(EjemploTablas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
		            java.util.logging.Logger.getLogger(EjemploTablas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		        }
				try {
					EjemploTablas frame = new EjemploTablas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EjemploTablas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 791, 485);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 40, 118, 384);
		contentPane.add(scrollPane);
		
		columnaOrigen = new JTable();
		scrollPane.setViewportView(columnaOrigen);
		
		rellenaTablaColumnasOrigen();
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(636, 40, 129, 384);
		contentPane.add(scrollPane_2);
		
		columnaDestino = new JTable();
		scrollPane_2.setViewportView(columnaDestino);
		
		rellenaTablaColumnasDestino();
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(227, 57, 313, 367);
		contentPane.add(scrollPane_1);
		
		tablaRelacion = new JTable();
		scrollPane_1.setViewportView(tablaRelacion);
		
		JButton btnOriToRel = new JButton("=>");
		btnOriToRel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				traspasoCamposEntreTablas(columnaOrigen, tablaRelacion, columnaDestino, 1);
			}
		});
		btnOriToRel.setBounds(153, 159, 49, 154);
		contentPane.add(btnOriToRel);
		
		JButton btnDesToRel_1 = new JButton("<=");
		btnDesToRel_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				traspasoCamposEntreTablas(columnaOrigen, tablaRelacion, columnaDestino, 2);
			}
		});
		btnDesToRel_1.setBounds(564, 159, 49, 154);
		contentPane.add(btnDesToRel_1);      
		
		JButton btnBorrarRelacion = new JButton("Borrar Relacion");
		btnBorrarRelacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tablaRelacion.getSelectedRow() >= 0) {
					int fila = tablaRelacion.getSelectedRow();
					
					relacionCampos.getRelacionColumnas().remove(fila);
					
					refrescarTablaRelacion(tablaRelacion);
				}else {
					JOptionPane.showMessageDialog(null, "No se ha seleccionado ninguna relacion.", "Aviso", JOptionPane.WARNING_MESSAGE);
				}
				
				
			}
		});
		
		btnBorrarRelacion.setBounds(227, 23, 118, 23);
		contentPane.add(btnBorrarRelacion);
		
		JButton btnBorrarRelaciones = new JButton("Borrar Relaciones");
		btnBorrarRelaciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tablaRelacion.getRowCount() > 0) {
					relacionCampos.getRelacionColumnas().clear();					
					refrescarTablaRelacion(tablaRelacion);
				} else {
					JOptionPane.showMessageDialog(null, "No hay relaciones para borrar.", "Aviso", JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		
		btnBorrarRelaciones.setBounds(422, 23, 118, 23);
		contentPane.add(btnBorrarRelaciones);
        
	}
	
	private void rellenaTablaColumnasOrigen() {
		DefaultTableModel cabecera = new DefaultTableModel();
        cabecera.addColumn("Nombre columna");
		String[] fila = new String[1];
		
		ArrayList<String> campos = new ArrayList<>();		
		
		campos.add("CODIGO");
		campos.add("NOMBRE");
		campos.add("NIF");
		campos.add("TELEFONO");
		campos.add("EMAIL");
		
		for (int i = 0; i < campos.size() ; i++) {
			fila[0] = campos.get(i);
			cabecera.addRow(fila);
		}
		
		columnaOrigen.setModel(cabecera);
	}
	
	private void rellenaTablaColumnasDestino() {
		DefaultTableModel cabecera = new DefaultTableModel();
        cabecera.addColumn("Nombre columna");
		String[] fila = new String[1];
		
		ArrayList<String> campos = new ArrayList<>();
		
		campos.add("cod");
		campos.add("nom");
		campos.add("nif");
		campos.add("te1");
		campos.add("xxx");
		
		for (int i = 0; i < campos.size() ; i++) {
			fila[0] = campos.get(i);
			cabecera.addRow(fila);
		}
		
		columnaDestino.setModel(cabecera);
	}
	
	/*FUNCION QUE DEVUELVE EL NUMERO DE FILAS QUE LA COLUMNA DESTINO ESTA VACIA*/
    private int devuelveNFilasColumnaDestinoVacias(JTable tablaRelacion) {
        int nFilasDestinoVacias = 0;
        for (int i = 0; i < relacionCampos.getRelacionColumnas().size(); i++) {
            if (relacionCampos.getRelacionColumnas().get(i).getCampoDestino().equals("")) {
                nFilasDestinoVacias++;
            }
        }
        return nFilasDestinoVacias;
    }

    /*FUNCION QUE DEVUELVE LA POSICION DE LA FILA DONDE LA COLUMNA DESTINO ESTA VACIA*/
    private int devuelvePosicionColumnaDestinoVacia(JTable tablaRelacion) {
        int posicion = 0;
        for (int i = 0; i < relacionCampos.getRelacionColumnas().size(); i++) {
            if (relacionCampos.getRelacionColumnas().get(i).getCampoDestino().equals("")) {
                posicion = i;
            }
        }
        return posicion;
    }
    
    private void refrescarTablaRelacion(JTable tablaRelacion) {
        
        DefaultTableModel cabeceraRelacion = new DefaultTableModel();
        cabeceraRelacion.addColumn("Columna origen");
        cabeceraRelacion.addColumn("Columna destino");
        String[] fila;
        for (int i = 0; i < relacionCampos.getRelacionColumnas().size(); i++) {
            Relacion filaRelacion = relacionCampos.getRelacionColumnas().get(i);
            fila = new String[2];
            fila[0] = filaRelacion.getCampoOrigen();
            fila[1] = filaRelacion.getCampoDestino();
            cabeceraRelacion.addRow(fila);
        }
        tablaRelacion.setModel(cabeceraRelacion);        

    }
	/**
	 * FUNCION QUE SE ENCARGA DE TRASPASAR LOS VALORES DE LAS TABLAS ORIGENY DESTINO A LA TABLA RELACION
	 * PARA ELLO NECESITA LOS SIGUIENTES PARAMETROS:
	 * @param tablaColumnasOrigen Objeto Jtable donde se encuentran las columnas origen
	 * @param tablaRelacion Objeto Jtable donde se mostraran las relaciones entre el objeto tablaColumnasOrigen y el objeto tablaColumnasDestino
	 * @param tablaColumnasDestino Objeto Jtable donde se encuentran las columnas destino
	 * @param tipo Int que puede tener los siguientes valores: 
	 * 1 - Traspaso del obejto tablaColumnasOrigen al objeto tablaRelacion
	 * 2 - Traspaso del obejto tablaColumnasDestino al objeto tablaRelacion
	 */
	public void traspasoCamposEntreTablas(JTable tablaColumnasOrigen, JTable tablaRelacion, JTable tablaColumnasDestino, int tipo) {

        /** Declaramos un obejto DefaultTableModel y lo inicilizaremos obteniendo el modelo actual del obejto tablaRelacion*/
        DefaultTableModel cabeceraRelacion = (DefaultTableModel) tablaRelacion.getModel();
        
        /**Declaramos las variables en las que guardaremos los valores seleccionados*/
        String columnaOrigen = "";
        String columnaDestino = "";
        
        /**Obtenemos del objeto relacionCampos el array de relaciones que inicialmente esta vacio */
        ArrayList<Relacion> relacion = relacionCampos.getRelacionColumnas();
        
        /**Obtenemos la ultima fila rellena en el objeto tabla relacion*/
        int ultimaFilaRelacion = tablaRelacion.getRowCount() - 1;

        /**Declaramos un Switch-Case Statement que en funcion del int que recibe, realizaremos la 
         * operacion de devolver el valor seleccionado en la columna origen si es 1 o 
         * el valor seleccionado en la columna destino si es 2*/
        switch (tipo) {
            case 1:
            	/**Capturamos la excepcion en el caso de que no se haya seleccionado ninguna 
            	 * fila en los objetos tabla y mostramos un dialogo donde se le indica el error 
            	 * al usuario*/
                try {
                	/**Si el recuento de las filas del objeto tablaRelacion es mayor que 0 entramos
                	 * lo que quiere decir que ya hemos añadido una relacion anteriormente*/
                    if (tablaRelacion.getSelectedRowCount() > 0) {
                    	
                    	/**Obtenemos la relacion existente en la fila seleccionada */
                        Relacion filaRelacion = relacion.get(tablaRelacion.getSelectedRow());
                        
                        /**Obtenemos el valor de la fila seleccionada en el objeto tablaColumnasOrigen*/
                        columnaOrigen = (String) tablaColumnasOrigen.getValueAt(tablaColumnasOrigen.getSelectedRow(), tablaColumnasOrigen.getSelectedColumn());
                        
                        /**Comprobamos si en la relacion existente, el valor del campo destino esta vacio*/
                        if (filaRelacion.getCampoDestino().equals("")) {
                        	/**Si el valor esta vacio, sustituimos el valor exitente en la columna origen por el 
                        	 * nuevo valor selecionado en el objeto tablaColumnas origen y guardamos como vacio 
                        	 * en la relacion el campoDestino*/
                            filaRelacion.setCampoOrigen(columnaOrigen);
                            filaRelacion.setCampoDestino("");
                            filaRelacion.setCampoOrigenRelleno(true);
                            filaRelacion.setCampoDestinoRelleno(false);

                            /**Refrescamos la tabla para actualizar la vista*/
                            refrescarTablaRelacion(tablaRelacion);
                        } else {
                        	/**Si el campoDestino de la relacion no esta vacio, quiere decir que existe
                        	 *  una relacion entre el campoOrigen y campoDestino y por lo tanto creamo una nueva
                        	 *  fila para realizar otra relacion*/
                            filaRelacion = new Relacion();
                            filaRelacion.setCampoOrigen(columnaOrigen);
                            filaRelacion.setCampoDestino("");
                            filaRelacion.setCampoOrigenRelleno(true);
                            filaRelacion.setCampoDestinoRelleno(false);
                            
                            /**Añadimos la nueva relacion*/
                            relacion.add(filaRelacion);
                            
                            /**Refrescamos la tabla para actualizar la vista*/
                            refrescarTablaRelacion(tablaRelacion);
                        }

                    } else {
                    	/**Si el recuento en el objeto tablaRelacion es igual 0 quiere decir qu aun no se ha añadido
                    	 * ninguna relacion y por lo tanto creamos una nueva*/
                        Relacion filaRelacion = new Relacion();
                        
                        /**Obtenemos el valor seleccinado en el objeto tablaColumnasOrigen y guardamos como vacio 
                        	 * en la relacion el campoDestino*/
                        columnaOrigen = (String) tablaColumnasOrigen.getValueAt(tablaColumnasOrigen.getSelectedRow(), tablaColumnasOrigen.getSelectedColumn());

                        filaRelacion.setCampoOrigen(columnaOrigen);
                        filaRelacion.setCampoDestino("");
                        filaRelacion.setCampoOrigenRelleno(true);
                        filaRelacion.setCampoDestinoRelleno(false);
                        
                        /**Añadimos la nueva relacion*/
                        relacion.add(filaRelacion);
                        
                        /**Refrescamos la tabla para actualizar la vista*/
                        refrescarTablaRelacion(tablaRelacion);
                    }

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun campo de la tabla Origen.", "Aviso", JOptionPane.WARNING_MESSAGE);
                }

                break;
            case 2:
            	/**Capturamos la excepcion en el caso de que no se haya seleccionado ninguna 
            	 * fila en los objetos tabla y mostramos un dialogo donde se le indica el error 
            	 * al usuario*/
                try {
                	/**Comprobamos que exista una relacion en el objeto tablaRelacion para poder finalizar la relacion*/
                    if (relacion.size() == 1) {
                    	/**Recogemos el valor de la fila seleccionada en el objeto tablaColumnasDestino*/
                        columnaDestino = (String) tablaColumnasDestino.getValueAt(tablaColumnasDestino.getSelectedRow(), tablaColumnasDestino.getSelectedColumn());
                        
                        /**Recuperamos la ultima relacion del array utilizando la variable ultimaFilaRelacion
                         * y le asignamos el valor del campoDestino*/                        
                        relacion.get(ultimaFilaRelacion).setCampoDestino(columnaDestino);
                        
                        /**Refrescamos la tabla para actualizar la vista*/
                        refrescarTablaRelacion(tablaRelacion);
                    } else {
                    	/**Si en el objeto tablaRelacion existe mas de una fila, primero comprobamos si existe 
                    	 * mas de una fila en la que el campo destino este vacio*/
                    	
                        if (devuelveNFilasColumnaDestinoVacias(tablaRelacion) > 1) {
                        	/**Si hay mas de una fila con el campo destino vacio, obtenemos el valor de la fila 
                        	 * seleccionada en el objeto tablaColumnasDestino y lo traspasamos a la columnaDestino
                        	 * del objeto tablaRelacion que este seleccionda, en caso de no seleccionar ninguna fila
                        	 * en el objeto tablaRelacion, se muestra un dialogo indicando que no se ha seleccionado
                        	 * ninguna fila*/
                            if (tablaRelacion.getSelectedRowCount() != 0) {
                                columnaDestino = (String) tablaColumnasDestino.getValueAt(tablaColumnasDestino.getSelectedRow(), tablaColumnasDestino.getSelectedColumn());
                                relacion.get(tablaRelacion.getSelectedRow()).setCampoDestino(columnaDestino);
                                
                                /**Refrescamos la tabla para actualizar la vista*/
                                refrescarTablaRelacion(tablaRelacion);
                            } else {
                                JOptionPane.showMessageDialog(null, "No se ha selecionado la fila de la relacion.", "Aviso", JOptionPane.WARNING_MESSAGE);
                            }
                        } else {
                        	/**En caso de que no exista mas de una fila, recogemos el valo de la fila seleccionada en el
                        	 * objeto tablaColumnasDestino y lo añadimos a la ultima columna destnio que estevacia*/ 
                            columnaDestino = (String) tablaColumnasDestino.getValueAt(tablaColumnasDestino.getSelectedRow(), tablaColumnasDestino.getSelectedColumn());
                            relacion.get(devuelvePosicionColumnaDestinoVacia(tablaRelacion)).setCampoDestino(columnaDestino);
                            
                            /**Refrescamos la tabla para actualizar la vista*/
                            refrescarTablaRelacion(tablaRelacion);
                        }

                    }

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "No se ha selecionado ningun campo de la tabla Destino.", "Aviso", JOptionPane.WARNING_MESSAGE);
                }
                break;

        }
        
        
    }
}

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

public class EjemploTablas extends JFrame {

	private JPanel contentPane;
	private JTable columnaOrigen;
	private JTable columnaDestino;
	private JTable tablaRelacion;
	
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
		
		columnaOrigen = new JTable();
		columnaOrigen.setBounds(10, 40, 118, 384);
		contentPane.add(columnaOrigen);
		
		rellenaTablaColumnasOrigen();
		
		columnaDestino = new JTable();
		columnaDestino.setBounds(636, 40, 129, 384);
		contentPane.add(columnaDestino);
		
		rellenaTablaColumnasDestino();
		
		tablaRelacion = new JTable();
		tablaRelacion.setBounds(227, 57, 313, 367);
		contentPane.add(tablaRelacion);
		
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
	
	public void traspasoCamposEntreTablas(JTable tablaColumnasOrigen, JTable tablaRelacion, JTable tablaColumnasDestino, int tipo) {

        DefaultTableModel cabeceraOrigen = new DefaultTableModel();
        DefaultTableModel cabeceraRelacion = (DefaultTableModel) tablaRelacion.getModel();
        DefaultTableModel cabeceraDestino = new DefaultTableModel();

        String columnaOrigen = "";
        String columnaDestino = "";
        ArrayList<Relacion> relacion = relacionCampos.getRelacionColumnas();
        int ultimaFilaRelacion = tablaRelacion.getRowCount() - 1;

        switch (tipo) {
            case 1:
                try {
                    if (tablaRelacion.getSelectedRowCount() > 0) {
                        Relacion filaRelacion = relacion.get(tablaRelacion.getSelectedRow());
                        columnaOrigen = (String) tablaColumnasOrigen.getValueAt(tablaColumnasOrigen.getSelectedRow(), tablaColumnasOrigen.getSelectedColumn());
                        if (filaRelacion.getCampoDestino().equals("")) {
                            filaRelacion.setCampoOrigen(columnaOrigen);
                            filaRelacion.setCampoDestino("");
                            filaRelacion.setCampoOrigenRelleno(true);
                            filaRelacion.setCampoDestinoRelleno(false);

                            //relacion.add(filaRelacion);
                            refrescarTablaRelacion(tablaRelacion);
                        } else {
                            filaRelacion = new Relacion();
                            filaRelacion.setCampoOrigen(columnaOrigen);
                            filaRelacion.setCampoDestino("");
                            filaRelacion.setCampoOrigenRelleno(true);
                            filaRelacion.setCampoDestinoRelleno(false);

                            relacion.add(filaRelacion);
                            refrescarTablaRelacion(tablaRelacion);
                        }

                    } else {
                    	
                        Relacion filaRelacion = new Relacion();
                        columnaOrigen = (String) tablaColumnasOrigen.getValueAt(tablaColumnasOrigen.getSelectedRow(), tablaColumnasOrigen.getSelectedColumn());

                        filaRelacion.setCampoOrigen(columnaOrigen);
                        filaRelacion.setCampoDestino("");
                        filaRelacion.setCampoOrigenRelleno(true);
                        filaRelacion.setCampoDestinoRelleno(false);

                        relacion.add(filaRelacion);
                        refrescarTablaRelacion(tablaRelacion);
                    }

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun campo de la tabla Origen.", "Aviso", JOptionPane.WARNING_MESSAGE);
                }

                break;
            case 2:
                try {
                    if (relacion.size() == 1) {
                        columnaDestino = (String) tablaColumnasDestino.getValueAt(tablaColumnasDestino.getSelectedRow(), tablaColumnasDestino.getSelectedColumn());
                        relacion.get(ultimaFilaRelacion).setCampoDestino(columnaDestino);
                        refrescarTablaRelacion(tablaRelacion);
                    } else {
                        if (devuelveNFilasColumnaDestinoVacias(tablaRelacion) > 1) {
                            if (tablaRelacion.getSelectedRowCount() != 0) {
                                columnaDestino = (String) tablaColumnasDestino.getValueAt(tablaColumnasDestino.getSelectedRow(), tablaColumnasDestino.getSelectedColumn());
                                relacion.get(tablaRelacion.getSelectedRow()).setCampoDestino(columnaDestino);
                                refrescarTablaRelacion(tablaRelacion);
                            } else {
                                JOptionPane.showMessageDialog(null, "No se ha selecionado la fila de la relacion.", "Aviso", JOptionPane.WARNING_MESSAGE);
                            }
                        } else {
                            columnaDestino = (String) tablaColumnasDestino.getValueAt(tablaColumnasDestino.getSelectedRow(), tablaColumnasDestino.getSelectedColumn());
                            relacion.get(devuelvePosicionColumnaDestinoVacia(tablaRelacion)).setCampoDestino(columnaDestino);
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

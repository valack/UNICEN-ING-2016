package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.ImagingOpException;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JToolBar;
import java.awt.BorderLayout;
import javax.swing.JTree;

import core.Course;
import core.imp_exp.Exporter;
import core.imp_exp.Importer;
import core.imp_exp.ImporterFromDB;
import core.imp_exp.ImporterFromTextFile;
import dataBase.ConnectionPostgresql;
import dataBase.DBManager;

import javax.swing.JToggleButton;
import javax.swing.JMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.imageio.IIOImage;
import javax.print.DocFlavor.URL;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.HeadlessException;
import javax.swing.SwingConstants;
import javax.swing.text.html.ImageView;

public class DemoInterface {

	private JFrame frame;
	private final Action action = new SwingAction();
	private Course curso;
	private ConnectionPostgresql connection;
	private DBManager dbManager;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DemoInterface window = new DemoInterface();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public DemoInterface() {
		initialize();
		/* Conecto la base de datos */
		
		connection = new ConnectionPostgresql("ing123");
		
		connection.connection();
		
		/* Administrador de la base de datos*/
		
		dbManager = new DBManager(connection);	
		
		//dbManager.cleanDB();
		
		curso = new Course(dbManager);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 812, 436);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		JMenuItem rdbtnmntmCrearGrafo = new JMenuItem("Crear Grafo");
		mnArchivo.add(rdbtnmntmCrearGrafo); 
		
		JMenuItem mntmImportarDesdeDb = new JMenuItem("Importar desde DB");
		mnArchivo.add(mntmImportarDesdeDb);
		
		JMenuItem mntmImportarDesdeArchivo = new JMenuItem("Importar desde archivo");
		mnArchivo.add(mntmImportarDesdeArchivo);
		frame.getContentPane().setLayout(null);
		
		JButton btnGuardar = new JButton("Guardar grafo");
		btnGuardar.setBounds(674, 318, 116, 42);
		frame.getContentPane().add(btnGuardar);
		btnGuardar.setEnabled(false);
		
		JTextArea txtTheme = new JTextArea();
		txtTheme.setEditable(false);
		txtTheme.setBounds(28, 56, 301, 304);
		frame.getContentPane().add(txtTheme);
		txtTheme.setVisible(false);
		
		JLabel lblCorrelatives = new JLabel("Correlatividades");
		lblCorrelatives.setFont(new Font("Calibri", Font.BOLD, 18));
		lblCorrelatives.setBounds(396, 37, 157, 16);
		frame.getContentPane().add(lblCorrelatives);
		lblCorrelatives.setVisible(false);
		
		JLabel lblTheme = new JLabel("Temas");
		lblTheme.setFont(new Font("Calibri", Font.BOLD, 18));
		lblTheme.setBounds(131, 37, 111, 16);
		frame.getContentPane().add(lblTheme);
		lblTheme.setVisible(false);
		
		JTextArea txtCorrelatives = new JTextArea();
		txtCorrelatives.setBounds(363, 56, 263, 304);
		frame.getContentPane().add(txtCorrelatives);
		txtCorrelatives.setVisible(false);
		
		JButton btnExportar = new JButton("Exportar Grafo");
		btnExportar.setEnabled(false);
		btnExportar.setBounds(674, 114, 116, 42);
		frame.getContentPane().add(btnExportar);
		
		JButton btnMostrarDatos = new JButton("Mostrar Datos");
		btnMostrarDatos.setBounds(674, 56, 116, 47);
		frame.getContentPane().add(btnMostrarDatos);
		
		JButton btnClean = new JButton("Limpiar DB");
		btnClean.setBounds(674, 265, 116, 42);
		frame.getContentPane().add(btnClean);
		
		JLabel lblImagen = new JLabel("");
		lblImagen.setBounds(10, 11, 636, 354);
		frame.getContentPane().add(lblImagen);
		

		/**
		 * Acciones
		 */
		
		btnMostrarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if ( curso.getCorrelative().isEmpty() )	{
		            JOptionPane.showMessageDialog(null, "No hay datos para mostrar");
				}
				else	{
					// Agrega al JTextArea los valores de los nodos.
					for ( int i = 0; i < curso.getCorrelative().size(); i++ )	{
						txtTheme.append("	"+curso.getCorrelative().get(i).getSource().getName()+"\n");
						txtTheme.append("----------------------------------------------------------------------------\n");
						txtTheme.append("	"+curso.getCorrelative().get(i).getTarget().getName()+"\n");
						txtTheme.append("----------------------------------------------------------------------------\n");
						txtCorrelatives.append("	"+curso.getCorrelative().get(i).getTarget().getName()+"\n");
						txtCorrelatives.append("----------------------------------------------------------------------------\n");
					}
					lblTheme.setVisible(true);
					lblCorrelatives.setVisible(true);
					txtCorrelatives.setVisible(true);
					txtTheme.setVisible(true);
					btnGuardar.setEnabled(true);
					btnExportar.setEnabled(true);
				}
					
			}
		});
		
		
		rdbtnmntmCrearGrafo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/* Creacion del curso 
				/* Creacion del grafo en memoria */	
				curso.createCorrelative("RD", "REQM", null, null, null);
				curso.createCorrelative("RD", "VAL", null, null, null);
				curso.createCorrelative("RD", "TS", null, null, null);
				curso.createCorrelative("TS", "VER", null, null, null);
				curso.createCorrelative("PP", "PMC", null, null, null);
				JOptionPane.showMessageDialog(null, "Grafo creado exitosamente");
				btnExportar.setEnabled(true);
			}
		});
		
		
		
		
		mntmImportarDesdeDb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if ( !dbManager.getTablaCorrelativas().next() )	{
						JOptionPane.showMessageDialog(null, "La base de datos se encuentra vacía");
					}
					else {
						ImporterFromDB importer = new ImporterFromDB();
						curso = importer.importCourse(dbManager);
						JOptionPane.showMessageDialog(null, "La importación de los datos se ha realizado de manera exitosa");
					}
				} catch (HeadlessException | SQLException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		btnClean.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dbManager.cleanDB();
			}
		});
		
//		mntmImportarDesdeArchivo.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				try {
//					Importer importer = new ImporterFromTextFile();
//					curso = importer.importCourse("curso.txt");
//					JOptionPane.showMessageDialog(null, "La importación de los datos se ha realizado de manera exitosa");
//					
					// Inicializar areas de texto y labels.
//					txtTheme.setText("");
//					txtCorrelatives.setText(" ");
//					lblTheme.setText("");
//					lblCorrelatives.setText("");
//					
//					// Agrega al JTextArea los valores de los nodos.
//					for ( int i = 0; i < importedCourse.getCorrelative().size(); i++ )	{
//						txtTheme.append("	"+importedCourse.getCorrelative().get(i).getSource().getName()+"\n");
//						txtTheme.append("----------------------------------------------------------------------------\n");
//						txtTheme.append("	"+importedCourse.getCorrelative().get(i).getTarget().getName()+"\n");
//						txtTheme.append("----------------------------------------------------------------------------\n");
//						txtCorrelatives.append("	"+importedCourse.getCorrelative().get(i).getTarget().getName()+"\n");
//						txtCorrelatives.append("----------------------------------------------------------------------------\n");
//					}
//					
//					// Mostrar las areas de texto y label.
//					txtTheme.setVisible(true);
//					txtCorrelatives.setVisible(true);
//					lblTheme.setVisible(true);
//					lblCorrelatives.setVisible(true);
//					btnGuardar.setEnabled(true);
//			    	}	catch (Exception e2) {
//			    			System.out.println("No se encuentra el archivo");
//			    		}
//		    }
		   // });
		
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dbManager.saveBD();
				JOptionPane.showMessageDialog(null, "Guardado exitosamente");
			}
		});
		
		btnExportar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Exporter exporter = new Exporter();
					exporter.export(curso);
					//Aca pones la dirección de donde esta instalado Graphviz->bin->dot.exe      
					String dotPath = "C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe";
					//Aca pones el archivo de entrada(que indica que nodos hay y los arcos entre los nodos)
					String fileInputPath = "curso.txt";
					//Aca pones donde queres que se guarde el grafo que se origina
					String fileOutputPath = "grafo.jpg";
		
					String tParam = "-Tjpg";
					String tOParam = "-o";
		
					String[] cmd = new String[5];
					cmd[0] = dotPath;
					cmd[1] = tParam;
					cmd[2] = fileInputPath;
					cmd[3] = tOParam;
					cmd[4] = fileOutputPath;
		
					Runtime rt = Runtime.getRuntime();
		
					rt.exec( cmd );
//					
//					lblTheme.setVisible(false);
//					lblCorrelatives.setVisible(false);
//					txtCorrelatives.setVisible(false);
//					txtTheme.setVisible(false);
//					btnGuardar.setEnabled(true);
//					
//					ImageIcon icon = new ImageIcon("grafo.png"); 
//					lblImagen.setIcon(icon);
					JOptionPane.showMessageDialog(null, "Exportacion exitosa");
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}

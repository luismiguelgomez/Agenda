package unbosque.edu.co.vista;

import java.awt.Color;   
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import unbosque.edu.co.controlador.AmigosDto;
import unbosque.edu.co.controlador.ContactoDto;
import unbosque.edu.co.controlador.ManejoArchivos;
import unbosque.edu.co.controlador.Persistencia;

public class PanelAgenda extends JPanel  implements ActionListener{

	private JComboBox<String> paises;
	private JPanel panel1;
	private JPanel panel2;
	private JTextField ingresarNombreA, ingresarNombreC;
	private JTextField ingresarTelefonoA, ingresarTelefonoC;
	private JTextField ingresarCorreoA, ingresarCorreoC;
	private JTextField ingresarEmpresa;
	private JButton botonPanelA, botonPanelC;
	private JButton botonGuardarA, botonGuardarC;
	private JButton botonEliminarC, botonEliminarA;
	private JButton botonActualizarA, botonActualizarC;
	
	private String datos[][];
	private String datosContactos[][];
	private DefaultTableModel mod ;
	private DefaultTableModel modContactos;
	private int fila;
	private int filaContactos;
	private String[] cabezera = { "Nombre", "Pais", "Telefono", "Correo" };
	private String[] cabezeraContactos = { "Nombre", "Empresa", "Pais", "Telefono", "Correo" };
	private final int numeroFilasAmigos = 100;
	private final int numeroColumAmigos = 4;
	private final int numeroColumContactos = 5;
	private JTable tabla;
	private JTable tablaContactos;
	private Persistencia clasePersistencia;
	private AmigosDto claseAmigosDto;
	private ContactoDto claseContactoDto;

	/**
	 * <b>precondiciones:</b> 
	 * Tener creado la clase ManejoArchivos, tener creado la matriz datos y la matriz datosContactos, tener creado la variable fila, filaContactos, 
	 * <br>
	 * <b>poscondiciones</b> Inicia los valores de panelAgenda
	 */
	public PanelAgenda() {
		ManejoArchivos claseArchivo = new ManejoArchivos();
		claseAmigosDto = new AmigosDto();
		clasePersistencia = new Persistencia();
		claseContactoDto = new ContactoDto();
		
		//Logica para amigos
		datos = new String [numeroFilasAmigos][numeroColumAmigos];
		datos = claseArchivo.mostrarAmigos();
		fila = claseArchivo.getFila();
		
		//Logica para contactos
		datosContactos = new String[numeroFilasAmigos][numeroColumContactos];
		datosContactos = claseArchivo.mostrarContactos();
		filaContactos = claseArchivo.getFilaContactos();
		
		setLayout(null);
		setBackground(Color.WHITE);

		iniciarComponentes();
		setVisible(true);
	}

	/**
	 * <b>precondiciones:</b> JLabel titulo,JLabel texto,
	 *	JComboBox<String> paises
	 *	JPanel panel1, JPanel panel2,
	 *	JButton botonPanelA,botonPanelC,
	 *	metodos: PanelAmigos() panelContactos(), 
	 * <br>
	 * <b>poscondiciones</b> Inicia los componentes de la clase
	 */
	private void iniciarComponentes() {

		JLabel titulo = new JLabel("AGENDA");

		titulo.setFont(new Font("", Font.PLAIN, 20));
		titulo.setBounds(20, 30, 300, 30);

		JLabel texto = new JLabel("Pais:");
		texto.setBounds(20, 90, 300, 30);
		add(texto, 0);

		paises = new JComboBox<String>();
		paises.setBounds(80, 90, 150, 30);
		paises.addItem("Colombia");
		paises.addItem("Peru");
		paises.addItem("España");
		paises.addItem("Chile");
		paises.addItem("Mexico");
		paises.addItem("Argentina");
		add(paises);

		panel1 = new JPanel();
		panel1.setLayout(null);
		panel1.setBounds(0, 200, 460, 385);
		panel1.setVisible(true);

		panel2 = new JPanel();
		panel2.setLayout(null);
		panel2.setBounds(460, 200, 460, 385);
		panel2.setVisible(true);

		botonPanelA = new JButton("AMIGOS CERCANOS");
		botonPanelA.setBounds(100, 130, 230, 60);
		botonPanelA.addActionListener(this);

		botonPanelC = new JButton("CONTACTOS TRABAJO");
		botonPanelC.setBounds(570, 130, 230, 60);
		botonPanelC.addActionListener(this);

		PanelAmigos();
		panelContactos();

		add(botonPanelA);
		add(botonPanelC);
		add(panel2);
		add(panel1);

		add(titulo, 0);
	}

	public void PanelAmigos() {
		JLabel lblEtiqueta = new JLabel("Amigos cercanos");
		lblEtiqueta.setBounds(10, 11, 150, 30);
		panel1.add(lblEtiqueta);

		JLabel textoPanel1 = new JLabel("Nombre:");
		textoPanel1.setBounds(10, 40, 150, 30);
		panel1.add(textoPanel1);

		textoPanel1 = new JLabel("Telefono:");
		textoPanel1.setBounds(10, 80, 150, 30);
		panel1.add(textoPanel1);

		textoPanel1 = new JLabel("Correo:");
		textoPanel1.setBounds(10, 120, 150, 30);
		panel1.add(textoPanel1);

		ingresarNombreA = new JTextField();
		ingresarNombreA.setBounds(80, 50, 150, 20);
		panel1.add(ingresarNombreA, 0);

		ingresarTelefonoA = new JTextField();
		ingresarTelefonoA.setBounds(80, 90, 150, 20);
		panel1.add(ingresarTelefonoA, 0);

		ingresarCorreoA = new JTextField();
		ingresarCorreoA.setBounds(80, 130, 150, 20);
		panel1.add(ingresarCorreoA, 0);

		botonGuardarA = new JButton("Guardar");
		botonGuardarA.setBounds(280, 40, 150, 40);
		botonGuardarA.addActionListener(this);
		panel1.add(botonGuardarA);
		
		botonEliminarA = new JButton("Eliminar");
		botonEliminarA.setBounds(280, 160, 150, 40);
		botonEliminarA.addActionListener(this);
		panel1.add(botonEliminarA);


		botonActualizarA = new JButton("Actualizar");
		botonActualizarA.setBounds(280, 100, 150, 40);
		botonActualizarA.addActionListener(this);
		panel1.add(botonActualizarA);

		mod = new DefaultTableModel(datos, cabezera);
		
	}

	/**
	 * <b>precondiciones:</b> Tener creado:
	 * JPanel panel2,
	 * JTextField ingresarNombreC,
	 *	ingresarCorreoC
	 *	JButton botonGuardarC,botonPanelC,botonEliminarC, botonActualizarC
	 * <br>
	 * <b>poscondiciones</b> Vista de los componentes para el panel de contactos
	 */
	private void panelContactos() {
		panel2.setBorder(
				BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Contactos del trabajo"), null));

		JLabel textoPanel2 = new JLabel("Nombre:");
		textoPanel2.setBounds(10, 40, 150, 30);
		panel2.add(textoPanel2);

		textoPanel2 = new JLabel("Telefono:");
		textoPanel2.setBounds(10, 80, 150, 30);
		panel2.add(textoPanel2);

		textoPanel2 = new JLabel("Correo:");
		textoPanel2.setBounds(10, 120, 150, 30);
		panel2.add(textoPanel2);

		textoPanel2 = new JLabel("Empresa:");
		textoPanel2.setBounds(10, 160, 150, 30);
		panel2.add(textoPanel2);

		ingresarNombreC = new JTextField();
		ingresarNombreC.setBounds(100, 50, 150, 20);
		panel2.add(ingresarNombreC, 0);

		ingresarTelefonoC = new JTextField();
		ingresarTelefonoC.setBounds(100, 90, 150, 20);
		panel2.add(ingresarTelefonoC, 0);

		ingresarCorreoC = new JTextField();
		ingresarCorreoC.setBounds(100, 130, 150, 20);
		panel2.add(ingresarCorreoC, 0);

		ingresarEmpresa = new JTextField();
		ingresarEmpresa.setBounds(100, 170, 150, 20);
		panel2.add(ingresarEmpresa, 0);

		botonGuardarC = new JButton("Guardar");
		botonGuardarC.setBounds(280, 40, 150, 40);
		botonGuardarC.addActionListener(this);
		panel2.add(botonGuardarC);

		botonEliminarC = new JButton("Eliminar");
		botonEliminarC.setBounds(280, 160, 150, 40);
		botonEliminarC.addActionListener(this);
		panel2.add(botonEliminarC);

		botonActualizarC = new JButton("Actualizar");
		botonActualizarC.setBounds(280, 100, 150, 40);
		botonActualizarC.addActionListener(this);
		panel2.add(botonActualizarC);
		
		modContactos = new DefaultTableModel(datosContactos, cabezeraContactos);
	}

	/**
	 * <b>precondiciones:</b> Tener creado: JComboBox de paises
	 * <br>
	 * <b>poscondiciones</b> retornar datos de los paises
	 * @return JcomboBox de paises
	 */
	public JComboBox<String> getPaises() {
		return paises;
	}

	/**
	 * <b>precondiciones:</b> JComboBox -string paises
	 * <br>
	 * <b>poscondiciones</b> guardar el dato en paises
	 * @param paises datos del pais
	 */
	public void setPaises(JComboBox<String> paises) {
		this.paises = paises;
	}

	/**
	 * <b>precondiciones:</b> JComboBox -string paises
	 * <br>
	 * <b>poscondiciones</b> guardar el dato en paises
	 * @return panel 1
	 */
	public JPanel getPanel1() {
		return panel1;
	}

	/**
	 * <b>precondiciones:</b> Tener creado el : panel1
	 * <br>
	 * @param panel1 envia los datos a panel 1
	 */
	public void setPanel1(JPanel panel1) {
		this.panel1 = panel1;
	}

	/**
	 * <b>precondiciones:</b> tener creado: Jpanel2
	 * <br>
	 * <b>poscondiciones</b> devolver datos de panel2
	 * @return panel 2 " panel contactos"
	 */
	public JPanel getPanel2() {
		return panel2;
	}

	public void setPanel2(JPanel panel2) {
		this.panel2 = panel2;
	}

	public JTextField getIngresarNombreA() {
		return ingresarNombreA;
	}

	public void setIngresarNombreA(JTextField ingresarNombreA) {
		this.ingresarNombreA = ingresarNombreA;
	}

	public JTextField getIngresarNombreC() {
		return ingresarNombreC;
	}

	public void setIngresarNombreC(JTextField ingresarNombreC) {
		this.ingresarNombreC = ingresarNombreC;
	}

	public JTextField getIngresarTelefonoA() {
		return ingresarTelefonoA;
	}

	public void setIngresarTelefonoA(JTextField ingresarTelefonoA) {
		this.ingresarTelefonoA = ingresarTelefonoA;
	}

	public JTextField getIngresarTelefonoC() {
		return ingresarTelefonoC;
	}

	public void setIngresarTelefonoC(JTextField ingresarTelefonoC) {
		this.ingresarTelefonoC = ingresarTelefonoC;
	}

	public JTextField getIngresarCorreoA() {
		return ingresarCorreoA;
	}

	public void setIngresarCorreoA(JTextField ingresarCorreoA) {
		this.ingresarCorreoA = ingresarCorreoA;
	}

	public JTextField getIngresarCorreoC() {
		return ingresarCorreoC;
	}

	public void setIngresarCorreoC(JTextField ingresarCorreoC) {
		this.ingresarCorreoC = ingresarCorreoC;
	}

	public JTextField getIngresarEmpresa() {
		return ingresarEmpresa;
	}

	public void setIngresarEmpresa(JTextField ingresarEmpresa) {
		this.ingresarEmpresa = ingresarEmpresa;
	}

	public JButton getBotonPanelA() {
		return botonPanelA;
	}

	public void setBotonPanelA(JButton botonPanelA) {
		this.botonPanelA = botonPanelA;
	}

	public JButton getBotonPanelC() {
		return botonPanelC;
	}

	public void setBotonPanelC(JButton botonPanelC) {
		this.botonPanelC = botonPanelC;
	}

	public JButton getBotonGuardarA() {
		return botonGuardarA;
	}

	public void setBotonGuardarA(JButton botonGuardarA) {
		this.botonGuardarA = botonGuardarA;
	}

	public JButton getBotonGuardarC() {
		return botonGuardarC;
	}

	public void setBotonGuardarC(JButton botonGuardarC) {
		this.botonGuardarC = botonGuardarC;
	}

	public String[][] getDatos() {
		return datos;
	}

	public void setDatos(String[][] datos) {
		this.datos = datos;
	}

	public String[][] getDatosContactos() {
		return datosContactos;
	}

	public void setDatosContactos(String[][] datosContactos) {
		this.datosContactos = datosContactos;
	}

	public DefaultTableModel getMod() {
		return mod;
	}

	public void setMod(DefaultTableModel mod) {
		this.mod = mod;
	}

	public DefaultTableModel getModContactos() {
		return modContactos;
	}

	public void setModContactos(DefaultTableModel modContactos) {
		this.modContactos = modContactos;
	}

	public int getFila() {
		return fila;
	}

	public void setFila(int fila) {
		this.fila = fila;
	}

	public int getFilaContactos() {
		return filaContactos;
	}

	public void setFilaContactos(int filaContactos) {
		this.filaContactos = filaContactos;
	}

	public String[] getCabezera() {
		return cabezera;
	}

	public void setCabezera(String[] cabezera) {
		this.cabezera = cabezera;
	}

	public String[] getCabezeraContactos() {
		return cabezeraContactos;
	}

	public void setCabezeraContactos(String[] cabezeraContactos) {
		this.cabezeraContactos = cabezeraContactos;
	}

	@Override
	/**
	 * <b>precondiciones:</b> Tener panel1,panel2 creado con sus respectivos botones
	 * <br>
	 * <b>poscondiciones</b> Dar funcionalidad de crud a botones y mostrarlos en una tabla
	 */
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == botonPanelA) {
			panel1.setVisible(true);
			panel2.setVisible(false);
		}
		if (arg0.getSource() == botonPanelC) {
			panel2.setVisible(true);
			panel1.setVisible(false);
		}
		
		if (arg0.getSource() == botonActualizarA) {
			try {
				String nombreA = ingresarNombreA.getText();
				String pais =	(String) paises.getSelectedItem();
				String telefonoA = ingresarTelefonoA.getText();
				String correoA = ingresarCorreoA.getText();
				String datosAux[][] = datos;
				datos = claseAmigosDto.ActualizarAmigo(datosAux, nombreA, pais, telefonoA, correoA);
			} catch (Exception e) {
				// TODO: handle exception
			}
			JTable tabla = new JTable(datos, cabezera) {
				
				public boolean isCellEditable(int fila, int columna) {
					
					if (columna == 4) {
						return true;
					}else{
						return false;
					}
				};
			};
			JScrollPane scroll = new JScrollPane(tabla);
			scroll.setBounds(10, 250, 440, 130);
			panel1.add(scroll);

		}
		
		if (arg0.getSource() == botonEliminarA) {
			String datosAux[][] = datos;
			String nombreA = ingresarNombreA.getText();
			datos = claseAmigosDto.eliminarAmigo(datosAux, nombreA);
			
			 tabla = new JTable(datos, cabezera) {
				
				public boolean isCellEditable(int fila, int columna) {
					
					if (columna == 4) {
						return true;
					}else{
						return false;
					}
				};
			};
			fila = fila -1;
			JScrollPane scroll = new JScrollPane(tabla);
			scroll.setBounds(10, 250, 440, 130);
			panel1.add(scroll);
		}
		
		if (arg0.getSource() == botonGuardarA) {

			String nombreA = ingresarNombreA.getText();
			String pais = (String) paises.getSelectedItem();
			String telefonoA= ingresarTelefonoA.getText();
			String correoA = ingresarCorreoA.getText();
			
			String datosAux[][] = datos;
			datos = claseAmigosDto.agregarAmigo(datosAux, nombreA, pais, telefonoA, correoA, fila);
			
			String[] cabezera = { "Nombre", "Pais", "Telefono", "Correo" };
			mod = new DefaultTableModel(datos, cabezera) {
				
				public boolean isCellEditable(int fila, int columna) {
					
					if (columna==4) {
						return true;
					}else{
						return false;
					}
					
					
					
				};
			};

				JTable tabla = new JTable(datos, cabezera) {
				
				public boolean isCellEditable(int fila, int columna) {
					
					if (columna == 3) {
						return true;
					}else{
						return false;
					}
					
					
					
				};
			};
			
			try {
				clasePersistencia.crearArchivo(nombreA, correoA, telefonoA, pais);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JScrollPane scroll = new JScrollPane(tabla);
			scroll.setBounds(10, 250, 440, 130);
			panel1.add(scroll);
			fila = fila + 1;
		}
		if (arg0.getSource() == botonGuardarC) {
			String datosAux[][] = datosContactos;
			String nombreC = ingresarNombreC.getText();
			String empresa = ingresarEmpresa.getText();
			String pais= (String) paises.getSelectedItem();
			String telefonoC= ingresarTelefonoC.getText();
			String correoC = ingresarCorreoC.getText();
			datosContactos = claseContactoDto.agregarContacto(datosAux, nombreC, empresa, pais, telefonoC, correoC, filaContactos);
			
			
			modContactos = new DefaultTableModel(datosContactos, cabezeraContactos);
			
			JTable tabla = new JTable(modContactos) {
				public boolean isCellEditable(int fila, int columna) {
					
					if (columna == 4) {
						return true;
					}else{
						return false;
					}
					
					
					
				};
			};
			try {
				clasePersistencia.crearArchivoContactos(nombreC, empresa, correoC, telefonoC, pais);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			JScrollPane scroll = new JScrollPane(tabla);
			scroll.setBounds(10, 250, 440, 130);
			panel2.add(scroll);
			filaContactos = filaContactos + 1;			
		}
		
		if (arg0.getSource() == botonEliminarC) {
			String datosAux[][] = datosContactos;
			String nombreC = ingresarNombreC.getText();
			datosContactos = claseContactoDto.eliminarContacto(datosAux, nombreC);
			modContactos = new DefaultTableModel(datosContactos, cabezeraContactos);
			
			JTable tabla = new JTable(modContactos) {
				public boolean isCellEditable(int fila, int columna) {
					
					if (columna == 4) {
						return true;
					}else{
						return false;
					}
					
					
					
				};
			};
			filaContactos = filaContactos - 1;
			JScrollPane scroll = new JScrollPane(tabla);
			scroll.setBounds(10, 250, 440, 130);
			panel2.add(scroll);
		}
		
		
		if (arg0.getSource() == botonActualizarC) {
			String datosAux[][] = datosContactos;
			String nombreC = ingresarNombreC.getText();
			String empresa = ingresarEmpresa.getText();
			String pais= (String) paises.getSelectedItem();
			String telefonoC= ingresarTelefonoC.getText();
			String correoC = ingresarCorreoC.getText();
			datosContactos = claseContactoDto.actualizarContacto(datosAux, nombreC, empresa, pais, telefonoC, correoC);
			
			modContactos = new DefaultTableModel(datosContactos, cabezeraContactos);
			
			JTable tabla = new JTable(modContactos) {
				public boolean isCellEditable(int fila, int columna) {
					
					if (columna == 4) {
						return true;
					}else{
						return false;
					}
					
				};
			};
			JScrollPane scroll = new JScrollPane(tabla);
			scroll.setBounds(10, 250, 440, 130);
			panel2.add(scroll);
			
		}
		
	}

}

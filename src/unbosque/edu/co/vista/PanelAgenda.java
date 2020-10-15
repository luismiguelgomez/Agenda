package unbosque.edu.co.vista;

import java.awt.Color; 
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

public class PanelAgenda extends JPanel implements ActionListener {

	JComboBox<String> paises;
	JPanel panel1;
	JPanel panel2;
	JTextField ingresarNombreA, ingresarNombreC;
	JTextField ingresarTelefonoA, ingresarTelefonoC;
	JTextField ingresarCorreoA, ingresarCorreoC;
	JTextField ingresarEmpresa;
	JButton botonPanelA, botonPanelC;
	JButton botonGuardarA, botonGuardarC;
	JButton botonEliminar;
	JButton botonActualizarA, botonActualizarC;
	String datos[][];
	String datosContactos[][];
	DefaultTableModel mod ;
	DefaultTableModel modContactos;
	private int fila;
	private int filaContactos;
	String[] cabezera = { "Nombre", "Pais", "Telefono", "Correo" };
	String[] cabezeraContactos = { "Nombre", "Empresa", "Pais", "Telefono", "Correo" };
			

	public PanelAgenda() {
		fila = 0;
		filaContactos = 0;
		datos=new String [100][4];
		datosContactos = new String[100][5];

		setLayout(null);
		setBackground(Color.WHITE);

		iniciarComponentes();

	}

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
		panel1.setVisible(false);

		panel2 = new JPanel();
		panel2.setLayout(null);
		panel2.setBounds(460, 200, 460, 385);
		panel2.setVisible(false);

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

	private void PanelAmigos() {
		panel1.setBorder(
				BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Contactos amigos"), null));

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
		
		botonEliminar = new JButton("Eliminar");
		botonEliminar.setBounds(280, 160, 150, 40);
		botonEliminar.addActionListener(this);
		panel1.add(botonEliminar);


		botonActualizarC = new JButton("Actualizar");
		botonActualizarC.setBounds(280, 100, 150, 40);
		botonActualizarC.addActionListener(this);
		panel1.add(botonActualizarC);

		mod = new DefaultTableModel(datos, cabezera);
		

		JTable tabla = new JTable(mod);
		JScrollPane scroll = new JScrollPane(tabla);
		scroll.setBounds(10, 250, 440, 130);
		panel1.add(scroll);
	}

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

		botonEliminar = new JButton("Eliminar");
		botonEliminar.setBounds(280, 160, 150, 40);
		botonEliminar.addActionListener(this);
		panel2.add(botonEliminar);

		botonActualizarC = new JButton("Actualizar");
		botonActualizarC.setBounds(280, 100, 150, 40);
		botonActualizarC.addActionListener(this);
		panel2.add(botonActualizarC);

		modContactos = new DefaultTableModel(datosContactos, cabezeraContactos);

		JTable tabla = new JTable(modContactos);
		JScrollPane scroll = new JScrollPane(tabla);
		scroll.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Lista de contactos de la empresa"),null));

		scroll.setBounds(10, 215, 440, 160);
		panel2.add(scroll);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == botonPanelA) {
			panel1.setVisible(true);
			panel2.setVisible(false);
		}
		if (arg0.getSource() == botonPanelC) {
			panel2.setVisible(true);
			panel1.setVisible(false);
		}
		if (arg0.getSource() == botonGuardarA) {

			String nombreAmigo;
			String correoAmigo;
			String telefonoAmigo;
			datos[fila][0]=	ingresarNombreA.getText();
			datos[fila][1]=	(String) paises.getSelectedItem();
			datos[fila][2]= ingresarTelefonoA.getText();
			datos[fila][3]= ingresarCorreoA.getText();
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

			JTable tabla = new JTable(mod);
			JScrollPane scroll = new JScrollPane(tabla);
			scroll.setBounds(10, 250, 440, 130);
			panel1.add(scroll);
			fila = fila + 1;
		
		}
		if (arg0.getSource() == botonGuardarC) {

			System.out.println(ingresarNombreC.getText());
			datosContactos[filaContactos][0]= ingresarNombreC.getText();
			datosContactos[filaContactos][1]= ingresarEmpresa.getText();
			datosContactos[filaContactos][2]= (String) paises.getSelectedItem();
			datosContactos[filaContactos][3]= ingresarTelefonoC.getText();
			datosContactos[filaContactos][4]= ingresarCorreoC.getText();
			
			modContactos = new DefaultTableModel(datosContactos, cabezeraContactos);

			JTable tabla = new JTable(modContactos);
			JScrollPane scroll = new JScrollPane(tabla);
			scroll.setBounds(10, 250, 440, 130);
			panel2.add(scroll);
			filaContactos = filaContactos + 1;			
		}
	}

}

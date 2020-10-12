package unbosque.edu.co.vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
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
	String datos[][];
	DefaultTableModel mod ;
	private int fila;

	public PanelAgenda() {
		fila = 0;
		datos=new String [100][4];

		setLayout(null);
		setBackground(Color.WHITE);

		iniciarComponentes();

	}

	private void iniciarComponentes() {

		JLabel titiulo = new JLabel("AGENDA");
		titiulo.setFont(new Font("", Font.PLAIN, 20));
		titiulo.setBounds(20, 30, 300, 30);

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

		add(titiulo, 0);
	}

	private void PanelAmigos() {
		JLabel lblEtiqueta = new JLabel("Amigos cercanos");
		lblEtiqueta.setBounds(10, 11, 150, 30);
		panel1.add(lblEtiqueta);

		JLabel textoPanel1 = new JLabel("Nombre:");
		textoPanel1.setBounds(10, 70, 150, 30);
		panel1.add(textoPanel1);

		textoPanel1 = new JLabel("Telefono:");
		textoPanel1.setBounds(10, 110, 150, 30);
		panel1.add(textoPanel1);

		textoPanel1 = new JLabel("Correo:");
		textoPanel1.setBounds(10, 150, 150, 30);
		panel1.add(textoPanel1);

		ingresarNombreA = new JTextField();
		ingresarNombreA.setBounds(80, 80, 150, 20);
		panel1.add(ingresarNombreA, 0);

		ingresarTelefonoA = new JTextField();
		ingresarTelefonoA.setBounds(80, 120, 150, 20);
		panel1.add(ingresarTelefonoA, 0);

		ingresarCorreoA = new JTextField();
		ingresarCorreoA.setBounds(80, 160, 150, 20);
		panel1.add(ingresarCorreoA, 0);

		botonGuardarA = new JButton("Guardar");
		botonGuardarA.setBounds(280, 200, 150, 40);
		botonGuardarA.addActionListener(this);
		panel1.add(botonGuardarA);

		String[] cabezera = { "Nombre", "Pais", "Telefono", "Correo" };

		mod = new DefaultTableModel(datos, cabezera);

		JTable tabla = new JTable(mod);
		JScrollPane scroll = new JScrollPane(tabla);
		scroll.setBounds(10, 250, 440, 130);
		panel1.add(scroll);

	}

	private void panelContactos() {
		JLabel lblEtiqueta = new JLabel("Contactos del trabajo");
		lblEtiqueta.setBounds(10, 11, 150, 30);
		panel2.add(lblEtiqueta);

		JLabel textoPanel1 = new JLabel("Nombre:");
		textoPanel1.setBounds(10, 70, 150, 30);
		panel2.add(textoPanel1);

		textoPanel1 = new JLabel("Telefono:");
		textoPanel1.setBounds(10, 110, 150, 30);
		panel2.add(textoPanel1);

		textoPanel1 = new JLabel("Correo:");
		textoPanel1.setBounds(10, 150, 150, 30);
		panel2.add(textoPanel1);

		textoPanel1 = new JLabel("Empresa:");
		textoPanel1.setBounds(10, 190, 150, 30);
		panel2.add(textoPanel1);

		ingresarNombreC = new JTextField();
		ingresarNombreC.setBounds(100, 80, 150, 20);
		panel2.add(ingresarNombreC, 0);

		ingresarTelefonoC = new JTextField();
		ingresarTelefonoC.setBounds(100, 120, 150, 20);
		panel2.add(ingresarTelefonoC, 0);

		ingresarCorreoC = new JTextField();
		ingresarCorreoC.setBounds(100, 160, 150, 20);
		panel2.add(ingresarCorreoC, 0);

		ingresarEmpresa = new JTextField();
		ingresarEmpresa.setBounds(100, 200, 150, 20);
		panel2.add(ingresarEmpresa, 0);

		botonGuardarC = new JButton("Guardar");
		botonGuardarC.setBounds(280, 200, 150, 40);
		botonGuardarC.addActionListener(this);
		panel2.add(botonGuardarC);

		String[] cabezera = { "Nombre", "Empresa", "Pais", "Telefono", "Correo" };
		String[][] datos = { { "marlon", "Toshiba", "colombia", "3015389715", "marlon@.com" } };

		DefaultTableModel mod = new DefaultTableModel(datos, cabezera);

		JTable tabla = new JTable(mod);
		JScrollPane scroll = new JScrollPane(tabla);
		scroll.setBounds(10, 250, 440, 130);
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
			System.out.println(paises.getSelectedItem());
			datos[fila][0]=	nombreAmigo = ingresarNombreA.getText();
			datos[fila][1]=	(String) paises.getSelectedItem();
			datos[fila][2]=telefonoAmigo = ingresarTelefonoA.getText();
			datos[fila][3]=correoAmigo = ingresarCorreoA.getText();
			String[] cabezera = { "Nombre", "Pais", "Telefono", "Correo" };
			mod = new DefaultTableModel(datos, cabezera);

			JTable tabla = new JTable(mod);
			JScrollPane scroll = new JScrollPane(tabla);
			scroll.setBounds(10, 250, 440, 130);
			panel1.add(scroll);
			fila = fila + 1;			
		}
		if (arg0.getSource() == botonGuardarC) {
			String nombreAmigo;
			String correoAmigo;
			String telefonoAmigo;
			System.out.println(paises.getSelectedItem());
			datos[fila][0]=	nombreAmigo = ingresarNombreA.getText();
			datos[fila][1]=	(String) paises.getSelectedItem();
			datos[fila][2]=telefonoAmigo = ingresarTelefonoA.getText();
			datos[fila][3]=correoAmigo = ingresarCorreoA.getText();
			String[] cabezera = { "Nombre", "Pais", "Telefono", "Correo" };
			mod = new DefaultTableModel(datos, cabezera);

			JTable tabla = new JTable(mod);
			JScrollPane scroll = new JScrollPane(tabla);
			scroll.setBounds(10, 250, 440, 130);
			panel1.add(scroll);
			fila = fila + 1;			
		}
	}

}

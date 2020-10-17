package unbosque.edu.co.vista;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class View extends JFrame {

	// Constantes

	// ruta de la imagen

	// atributos de la interaz

	private JLabel label;
	private ImageIcon imagenF;
	private JButton botonA;
	private JButton botonS;
	private JPanel panel;

	private JScrollPane scroll;
	private PanelAgenda agenda;

	public View() {

		setSize(939, 625);
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		iniciarComponentes();
		setVisible(true);
	}

	public void iniciarComponentes() {
		agenda = new PanelAgenda();
		scroll = new JScrollPane();
		scroll.setBounds(0, 0, getWidth(), getHeight());
		// imagen fondo
		// fondo de presentacion empleado fijo

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, getWidth(), getHeight());
		add(panel);

		label = new JLabel();
		label.setBounds(0, 0, getWidth(), getHeight());
		imagenF = new ImageIcon("src/unbosque/edu/co/vista/imagenes/fondo.jpg");
		imagenF = new ImageIcon(imagenF.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_DEFAULT));
		label.setIcon(imagenF);
		panel.add(label, 0);

		botonA = new JButton();
		botonA.setBounds(400, 250, 90, 80);
		imagenF = new ImageIcon("src/unbosque/edu/co/vista/imagenes/contactosL.png");
		imagenF = new ImageIcon(imagenF.getImage().getScaledInstance(90, 80, Image.SCALE_DEFAULT));
		botonA.setOpaque(false);
		botonA.setBackground(new Color(0, 0, 0, 0));
		botonA.setBorder(null);
		botonA.setIcon(imagenF);
//		botonA.addActionListener(this);

		botonS = new JButton();
		botonS.setBounds(400, 350, 90, 80);
		imagenF = new ImageIcon("src/unbosque/edu/co/vista/imagenes/uno-removebg-preview.png");
		imagenF = new ImageIcon(imagenF.getImage().getScaledInstance(90, 80, Image.SCALE_DEFAULT));
		botonS.setOpaque(false);
		botonS.setBackground(new Color(0, 0, 0, 0));
		botonS.setBorder(null);
		botonS.setIcon(imagenF);
//		botonS.addActionListener(this);

		panel.add(botonA, 0);
		panel.add(botonS, 0);
		add(scroll);

	}

	public JLabel getLabel() {
		return label;
	}

	public void setLabel(JLabel label) {
		this.label = label;
	}

	public ImageIcon getImagenF() {
		return imagenF;
	}

	public void setImagenF(ImageIcon imagenF) {
		this.imagenF = imagenF;
	}

	public JButton getBotonA() {
		return botonA;
	}

	public void setBotonA(JButton botonA) {
		this.botonA = botonA;
	}

	public JButton getBotonS() {
		return botonS;
	}

	public void setBotonS(JButton botonS) {
		this.botonS = botonS;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public JScrollPane getScroll() {
		return scroll;
	}

	public void setScroll(JScrollPane scroll) {
		this.scroll = scroll;
	}

	public PanelAgenda getAgenda() {
		return agenda;
	}

	public void setAgenda(PanelAgenda agenda) {
		this.agenda = agenda;
	}

	public void definirPanel(PanelAgenda agenda1) {

		scroll.setViewportView(agenda1);
	}

}

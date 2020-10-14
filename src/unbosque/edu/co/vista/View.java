package unbosque.edu.co.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Menu;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class View extends JFrame implements ActionListener {

	// Constantes

	// ruta de la imagen

	// atributos de la interaz

	JLabel label;
	ImageIcon imagenF;
	JButton botonA,botonS;
	JPanel panel;

	PanelAgenda agenda;

	public View() {

		setSize(939, 625);
		setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		iniciarComponentes();
	}

	public void iniciarComponentes() {
		agenda = new PanelAgenda();

			agenda.setBounds(0, 0, getWidth(), getHeight());
			agenda.setVisible(false);
		// fondo de presentacion empleado fijo

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, getWidth(), getHeight());
		panel.setVisible(true);
		add(panel);

		label = new JLabel();
		label.setBounds(0, 0, getWidth(), getHeight());
		imagenF = new ImageIcon("unbosque/edu/co/vista/imagenes/fondo.jpg");
		imagenF = new ImageIcon(imagenF.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_DEFAULT));
		label.setIcon(imagenF);
		panel.add(label, 0);

		botonA = new JButton();
		botonA.setBounds(400, 250, 90, 80);
		imagenF = new ImageIcon("unbosque/edu/co/vista/imagenes/contactosL.png");
		imagenF = new ImageIcon(imagenF.getImage().getScaledInstance(90, 80, Image.SCALE_DEFAULT));
		botonA.setOpaque(false);
		botonA.setBackground(new Color(0, 0, 0, 0));
		botonA.setBorder(null);
		botonA.setIcon(imagenF);
		botonA.addActionListener(this);

		botonS = new JButton();
		botonS.setBounds(400, 350, 90, 80);
		imagenF = new ImageIcon("unbosque/edu/co/vista/imagenes/uno-removebg-preview.png");
		imagenF = new ImageIcon(imagenF.getImage().getScaledInstance(90, 80, Image.SCALE_DEFAULT));
		botonS.setOpaque(false);
		botonS.setBackground(new Color(0, 0, 0, 0));
		botonS.setBorder(null);
		botonS.setIcon(imagenF);
		botonS.addActionListener(this);
		panel.add(botonA,0);
		panel.add(botonS,0);
		panel.add(agenda,0);

	}

	private void definirPanel(PanelAgenda agenda1) {
		
		agenda1.setVisible(true);
		
	}
	
	
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==botonA) {
				definirPanel(agenda);
				botonS.setVisible(false);
			}
				
			if(e.getSource()==botonS) {
				System.exit(0);
			}
		}


	}

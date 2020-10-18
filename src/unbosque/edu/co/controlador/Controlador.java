package unbosque.edu.co.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import unbosque.edu.co.vista.PanelAgenda;
import unbosque.edu.co.vista.View;

public class Controlador implements ActionListener {
	View v;
	PanelAgenda agenda;
	private DefaultTableModel mod;

	/**
	 * Metodo constructor
	 * <b>precondiciones:</b> Ser llamado desde AplMain
	 * <br>
	 * <b>poscondiciones</b> cargar la clase View y tener el action performed de esta 
	 */
	public Controlador() {
		v = new View();
		agenda = new PanelAgenda();
		asignarOyentes();

//		v.setVisible(true);
	}

	/**
	 * <b>precondiciones:</b> Ser llamado desde el metodo constructor
	 * <br>
	 * <b>poscondiciones</b> 
	 * Agregar las acciones para el boton que puede salir del programa,
	 * Agregar la accion para continuar   
	 */
	private void asignarOyentes() {
		v.getBotonA().addActionListener(this);
		v.getBotonS().addActionListener(this);
	

//		agenda.getBotonPanelA().addActionListener(this);
//		agenda.getBotonPanelC().addActionListener(this);
//		agenda.getBotonGuardarA().addActionListener(this);
//		agenda.getIngresarNombreA().addActionListener(this);
//		agenda.getPaises().addActionListener(this);
//		agenda.getIngresarTelefonoA().addActionListener(this);
//		agenda.getIngresarCorreoA().addActionListener(this);
	}

	@Override
	/**
	 * Action performed
	 * <b>precondiciones:</b> Tener el botonA en la clase View, tiener el botonS en la clase View
	 * <br>
	 * <b>poscondiciones</b> Dar funcionalidad a los botones de salir y continuar
	 */
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == v.getBotonA()) {
//			v.definirPanel(v.getAgenda());
			v.getBotonS().setVisible(false);
			v.getBotonA().setVisible(false);
			v.definirPanel(agenda);
			
		}

		if (arg0.getSource() == v.getBotonS()) {
			System.exit(0);
		}
//		if (arg0.getSource() == agenda.getBotonPanelA()) {
//			System.out.println("estoy en paa");
//			agenda.getPanel1().setVisible(true);
//			agenda.getPanel2().setVisible(false);
//		
//		}
//		if (arg0.getSource() == agenda.getBotonPanelC()) {
//			System.out.println("estoy en pc");
//			agenda.getPanel1().setVisible(true);
//			
//			agenda.getPanel2().setVisible(false);
//		}
//		System.out.println("estamos aca?");
////		if (arg0.getSource() == v.getAgenda().getBotonGuardarA()) {
//		if (arg0.getSource() == agenda.getBotonGuardarA()) {
//			System.out.println("-------ENTRAMOS A BOTN A------");
//			agenda.getDatos()[0][0] = agenda.getIngresarNombreA().getText();
//			agenda.getDatos()[0][1] = (String) agenda.getPaises().getSelectedItem();
//			agenda.getDatos()[0][2] = agenda.getIngresarTelefonoA().getText();
//			agenda.getDatos()[0][3] = agenda.getIngresarCorreoA().getText();
//			mod = new DefaultTableModel(agenda.getDatos(), agenda.getCabezera());
//
//			JTable tabla = new JTable(mod);
//			JScrollPane scroll = new JScrollPane(tabla);
//			scroll.setBounds(10, 250, 440, 130);
//			agenda.getPanel1().add(scroll);
////			fila = fila + 1;			
//		}
//		if (arg0.getSource() == agenda.getBotonGuardarC()) {
//			System.out.println("boton c");
//		}
//	}
////		if (arg0.getSource() == botonGuardarC) {
////			
////			System.out.println("quivo perrito");
////			System.out.println(ingresarNombreC.getText());
////			datosContactos[filaContactos][0]= ingresarNombreC.getText();
////			datosContactos[filaContactos][1]= ingresarEmpresa.getText();
////			datosContactos[filaContactos][2]= (String) paises.getSelectedItem();
////			datosContactos[filaContactos][3]= ingresarTelefonoC.getText();
////			datosContactos[filaContactos][4]= ingresarCorreoC.getText();
////			
////			modContactos = new DefaultTableModel(datosContactos, cabezeraContactos);
////
////			JTable tabla = new JTable(modContactos);
////			JScrollPane scroll = new JScrollPane(tabla);
////			scroll.setBounds(10, 250, 440, 130);
////			panel2.add(scroll);
////			filaContactos = filaContactos + 1;			
////		}
	}
}
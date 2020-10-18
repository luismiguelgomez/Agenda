package unbosque.edu.co.controlador;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Persistencia {

	private ArrayList<String> datosTxt;
	private String datos;
	
	public Persistencia() {
		// Declaración de un ArrayList de "String". Puede ser de cualquier otro Elemento u Objeto (float, Boolean, Object, ...)
		datosTxt= new ArrayList<String>();
	}
	
	
	
	public void crearArchivo(String nombreA, String correoA, String telefonoA, String pais) {
		try {
			FileWriter permiteEscrito = new FileWriter("src/unbosque/edu/co/persistence/agendaDigital.txt");
			BufferedWriter bw = new BufferedWriter(permiteEscrito);
			String texto = nombreA;
			String texto2 = correoA;
			String texto3 = telefonoA;
			String texto4 = pais;
			PrintWriter imprimir = new PrintWriter(permiteEscrito);
			
			datos = "Contacto Amigo: "+ texto+ "||"+texto2 + "||"+texto3 + "||"+texto4+"\n";
			datosTxt.add(datos);
			
			for (String string : datosTxt) {
				imprimir.print(string);	
			}
			
			
			permiteEscrito.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al crear o escribir el archivo txt");
		}
		
	}
	
	public void crearArchivoContactos(String nombreC,String empresaC, String correoC, String telefonoC,String pais ) {
		try {
			FileWriter permiteEscrito = new FileWriter("src/unbosque/edu/co/persistence/agendaDigital.txt");
			BufferedWriter bw = new BufferedWriter(permiteEscrito);
			String texto = nombreC;
			String texto2 = correoC;
			String texto3 = telefonoC;
			String texto4 = pais;
			String texto5 = empresaC;
			PrintWriter imprimir = new PrintWriter(permiteEscrito);
			
			datos = "Contacto Agregado: "+ texto+ "||"+texto2 + "||"+texto3 + "||"+texto4 + "||" + texto5 + "\n";
			datosTxt.add(datos);
			
			for (String string : datosTxt) {
				imprimir.print(string);	
			}
			
			
			permiteEscrito.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al crear o escribir el archivo txt");
		}
		
	}



	public ArrayList<String> getDatosTxt() {
		return datosTxt;
	}



	public void setDatosTxt(ArrayList<String> datosTxt) {
		this.datosTxt = datosTxt;
	}
	
	

}

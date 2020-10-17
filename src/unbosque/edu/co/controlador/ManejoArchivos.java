package unbosque.edu.co.controlador;

import java.io.File; 
import java.io.FileInputStream;
import java.util.Properties;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class ManejoArchivos {
	File f;
	Properties pro;
	private int fila = 0;
	private int filaContactos = 0;
	public String contacto[][] = new String[100][5];
	public String amigo[][] = new String[100][5];
	public final int cantidadContactos = 3;
	public final int cantidadAmigos = 4;

	public ManejoArchivos() {
		// TODO Auto-generated constructor stub
		pro = new Properties();
		pro = cargarFichero();
		
	}

	public void iniciar() {
		listarArchivo();
		mostrarContactos();
	}

	public int getCantidadContactos() {
		return cantidadContactos;
	}

	public int getCantidadAmigos() {
		return cantidadAmigos;
	}

	public void listarArchivo() {
		pro.list(System.out);
	}

	public String[][] mostrarContactos() {
		try {
			for (int i = 1; i <= 3; i++) {
				contacto[filaContactos][0] = pro.getProperty("contacto.nombre" + i);
				contacto[filaContactos][1] = pro.getProperty("contacto.empresa" + i);
				contacto[filaContactos][2] = pro.getProperty("contacto.pais" + i);
				contacto[filaContactos][3] = pro.getProperty("contacto.telefonoManager" + i);
				contacto[filaContactos][4] = pro.getProperty("contacto.correo" + i);
				
				filaContactos = filaContactos + 1;
			}
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "Debe seleccionar un properties");
		}
		
		return contacto;
	}

	public String[][] mostrarAmigos() {
		for (int i = 1; i <= 4; i++) {
			amigo[fila][0] = pro.getProperty("amigo.nombre" + i);
			amigo[fila][1] = pro.getProperty("amigo.pais" + i);
			amigo[fila][2] = pro.getProperty("amigo.telefono" + i);
			amigo[fila][3] = pro.getProperty("amigo.correo" + i);
			
			fila = fila + 1;
		}
		
		return amigo;
	}

	public void mostrarAgenda() {
		for (int i = 0; i < Integer.parseInt(pro.getProperty("agenda.paises")); i++) {
			pro.getProperty("agenda.pais" + i);
		}
	}

	public Properties cargarFichero() {
		try {
			JFileChooser fc = new JFileChooser(System.getProperty("user.dir"));
			fc.showOpenDialog(fc);
			f = fc.getSelectedFile();
			FileInputStream archivo = new FileInputStream(f);
			Properties pro = new Properties();
			pro.load(archivo);
			archivo.close();
			if (!pro.isEmpty()) {
				return pro;
			}
			System.out.println("archivo cargado");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return null;
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

}

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

	/**
	 * <b>precondiciones:</b> Tener el metodo cargar fichero
	 * <br>
	 * <b>poscondiciones</b> leer el archivo properties y guardarlo en una matriz de String 
	 */
	public ManejoArchivos() {
		// TODO Auto-generated constructor stub
		pro = new Properties();
		pro = cargarFichero();
		
	}

	/**
	 * <b>precondiciones:</b> Tener creado el metodo listarArchivo y mostrarContactos dentro de esta misma clase
	 * <br>
	 * <b>poscondiciones</b> Leer los contactos
	 */
	public void iniciar() {
		listarArchivo();
		mostrarContactos();
	}

	/**
	 * Get de cantidad de contactos
	 * <b>precondiciones:</b> Tener creado el entero de cantidad de contactos
	 * <br>
	 * <b>poscondiciones</b> Devolver un entero de la cantidad de contactos
	 * @return Entero con la cantidad de contactos que tiene el propeties
	 */
	public int getCantidadContactos() {
		return cantidadContactos;
	}

	/**
	 * <b>precondiciones:</b> Tener creada la variable de tipo int 
	 * <br>
	 * <b>poscondiciones</b> devolver un entero con la cantidad de amigos
	 * @return Entero con cantidad de amigos que tiene en el properties
	 */
	public int getCantidadAmigos() {
		return cantidadAmigos;
	}

	/**
	 * <b>precondiciones:</b> Tener una variable de Properties llamada pro
	 * <br>
	 * <b>poscondiciones</b> Lista los datos que tiene el properties
	 */
	public void listarArchivo() {
		pro.list(System.out);
	}

	/**
	 * <b>precondiciones:</b> Tener creado: la matriz contacto, el int de filaContactos y la variable del properties "pro"
	 * <br>
	 * <b>poscondiciones</b> Guardar los datos de los contactos en la matriz "contacto" 
	 * @return Matriz de string con los datos que tiene el properties en contacto
	 */
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

	/**
	 * <b>precondiciones:</b> Tener creado: la matriz amigo, el int de fila y la variable del properties "pro"
	 * <br>
	 * <b>poscondiciones</b> Guardar los datos de los contactos en la matriz amigo 
	 * @return Matriz de String con los datos que tiene el properties de amigo
	 */
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

	/**
	 * <b>precondiciones:</b> Tener de Properties la variable pro
	 * <br>
	 * <b>poscondiciones</b> Muestra los datos de los paises 
	 */
	public void mostrarAgenda() {
		for (int i = 0; i < Integer.parseInt(pro.getProperty("agenda.paises")); i++) {
			pro.getProperty("agenda.pais" + i);
		}
	}

	/**
	 * <b>precondiciones:</b> Variable f de tipo File, 
	 * <br>
	 * <b>poscondiciones</b> cargar el properties para despues comenzarlo a leer 
	 * @return properties
	 */
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

	/**
	 * <b>precondiciones:</b> debe tener creado
	 * <br>
	 * <b>poscondiciones</b> Muestra los datos de los paises 
	 * @return entero del numero de filas que tenemos de amigos
	 */
	public int getFila() {
		return fila;
	}

	/**
	 * <b>precondiciones:</b> Tener de Properties la variable pro
	 * <br>
	 * <b>poscondiciones</b> Muestra los datos de los paises 
	 * @param fila para amigos
	 */
	public void setFila(int fila) {
		this.fila = fila;
	}

	/**
	 * <b>precondiciones:</b> Tener una variable int llamada filaContactos creada
	 * <br>
	 * <b>poscondiciones</b> Entrega entero con el numero de fila para los contactos 
	 * @return entero de fila de contactos
	 */
	public int getFilaContactos() {
		return filaContactos;
	}

	/**
	 * <b>precondiciones:</b> Tener creado el entero de filaContactos
	 * <br>
	 * <b>poscondiciones</b> actualizar el valor de filaContactos
	 * @param filaContactos entero 
	 */
	public void setFilaContactos(int filaContactos) {
		this.filaContactos = filaContactos;
	}

}

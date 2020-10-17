package unbosque.edu.co.controlador;

import unbosque.edu.co.modelo.AmigosDao;
import unbosque.edu.co.vista.PanelAgenda;

public class AmigosDto {
	
	AmigosDao claseDtoAmigos;
	String datosContactos[][];
	public AmigosDto () {
		datosContactos = new String[100][4];
		claseDtoAmigos = new AmigosDao();
	}
	
	public String [][] EliminarAmigo (String buscarAmigo, String matrix [][]) {
		datosContactos = claseDtoAmigos.eliminar(buscarAmigo, matrix);
		
		return datosContactos; 
	}
	
	public void buscarAmigo (String nombre, String [][] matriz) {
		claseDtoAmigos.buscar(nombre, matriz);
	}

}

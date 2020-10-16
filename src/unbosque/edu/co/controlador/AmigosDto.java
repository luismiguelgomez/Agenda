package unbosque.edu.co.controlador;

import unbosque.edu.co.modelo.AmigosDao;

public class AmigosDto {

	public AmigosDto (String parametro) {
		AmigosDao claseDtoAmigos = new AmigosDao();
		claseDtoAmigos.buscar(parametro);
	}
	
	public AmigosDto () {
		
	}

}

package unbosque.edu.co.controlador;

import unbosque.edu.co.modelo.AmigosDao; 

public class AmigosDto {
	
	AmigosDao claseDtoAmigos;
	String datosAmigos[][];
	private final int numeroFilasAmigos = 100;
	private final int numeroColumAmigos = 4;
	private int Colombia;
	private int Peru, Espania, chile, mexico, argentina;
	
	/**
	 * <b>precondiciones:</b> Tener una matriz datosAmigos 
	 * <br>
	 * <b>poscondiciones</b> inicia la matriz
	 */
	public AmigosDto () {
		datosAmigos = new String[100][4];
		claseDtoAmigos = new AmigosDao();
	}
	
	/**
	 * <b>precondiciones:</b> datosAmigos[][]
	 * <br>
	 * <b>poscondiciones</b> Elimina amigo
	 * @param buscarAmigo string 
	 * @param matrix matriz proveniente de vista
	 * @return un String [][]
	 */
	public String [][] EliminarAmigo (String buscarAmigo, String matrix [][]) {
		datosAmigos = claseDtoAmigos.eliminar(buscarAmigo, matrix);
		
		return datosAmigos; 
	}
	
	/**
	 * <b>precondiciones:</b> tener creado la claseDAOde amigos
	 * <br>
	 * <b>poscondiciones</b> Dar funcionalidad de crud a botones y mostrarlos en una tabla
	 * @param nombre String
	 * @param matriz String[][]
	 */
	public void buscarAmigo (String nombre, String [][] matriz) {
		claseDtoAmigos.buscar(nombre, matriz);
	}
	
	/**
	 * <b>precondiciones:</b> Tener datosAmigos
	 * <br>
	 * <b>poscondiciones</b> Dar funcionalidad de crud a botones y mostrarlos en una tabla
	 * @param matriz proveniente de la vista
	 * @param nombreA string
	 * @param pais string 
	 * @param telefonoA string 
	 * @param correoA string
	 * @return String[][] con datos actualizados
	 */
	public String [][] ActualizarAmigo (String [][] matriz , String nombreA, String pais, String telefonoA, String correoA) {
		datosAmigos = matriz;
		
		try {
			for (int i = 0; i < numeroFilasAmigos; i++) {
				for (int j = 0; j < 3; j++) {
					if (datosAmigos[i][j].equals(nombreA)) {
//						System.out.println(datosAmigos[i][j]);
						datosAmigos[i][0] = nombreA;
						datosAmigos[i][1] = pais;
						datosAmigos[i][2] = telefonoA;
						datosAmigos[i][3] = correoA;
					}
					
				}
			}
		} catch (Exception e) {
		}
		
		return datosAmigos;
		
	}
	
	/**
	 * <b>precondiciones:</b> Tener datosAmigos
	 * parametros de String[][], string nombreA
	 * <br>
	 * <b>poscondiciones</b> Dar funcionalidad de crud a botones y mostrarlos en una tabla
	 * @param datosAux matriz proveniente de view
	 * @param nombreA String del nombre que se da a buscar
	 * @return String [][]
	 */
	public String [][] eliminarAmigo (String datosAux [][], String nombreA ) {
		datosAmigos = datosAux;
		try {
			
			for (int i = 0; i < numeroFilasAmigos; i++) {
				for (int j = 0; j < 3; j++) {
					 
					if (datosAmigos[i][j].equals(nombreA)) {
						datosAmigos[i][0] = null;
						datosAmigos[i][1] = null;
						datosAmigos[i][2] = null;
						datosAmigos[i][3] = null;
						datosAmigos[i][4] = null;
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		 return datosAmigos;
	}
	
	/**
	 *  <b>precondiciones:</b> Tener datosAmigos
	 * <br>
	 * <b>poscondiciones</b> agregar amigo en string[][]
	 * @param datosAux matriz [][]
	 * @param nombreA string de nombre proveniente de view
	 * @param pais string de pais proveniente de view
	 * @param telefonoA string de tel proveniente de view
	 * @param correoA string de correo proveniente de view
	 * @param pFila string de fila proveniente de view
	 * @return String [][] con datos actualizados
	 */
	public String [][] agregarAmigo (String datosAux [][],String nombreA,String pais, String telefonoA, String correoA, int pFila) {
		datosAmigos = datosAux;

		try {
			datosAmigos[pFila][0]= nombreA;
			datosAmigos[pFila][1]= pais;
			datosAmigos[pFila][2]= telefonoA;
			datosAmigos[pFila][3]= correoA;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return datosAmigos;
	}
	
	public void contarPaises(String matriz[][]) {
		datosAmigos = matriz;
		try {
			for (int i = 0; i < numeroFilasAmigos; i++) {
				for (int j = 0; j < 1; j++) {
					String pais = datosAmigos[i][1];

					if (pais.equals("Colombia")) {
						Colombia = Colombia + 1;
					}
					if (pais.equals("Peru")) {
						Peru = Peru + 1;
					}
					if (pais.equals("España")) {
						Espania = Espania + 1;
					}
					if (pais.equals("Chile")) {
						chile = chile + 1;
					}
					if (pais.equals("Mexico")) {
						mexico = mexico + 1;
					}
					if (pais.equals("Argentina")) {
						argentina = argentina + 1;
					}
				}

			}
		} catch (Exception e) {
		}
		System.out.println("aqui voy");
	}

	public int getColombia() {
		return Colombia;
	}

	public void setColombia(int colombia) {
		Colombia = colombia;
	}

	public int getPeru() {
		return Peru;
	}

	public void setPeru(int peru) {
		Peru = peru;
	}

	public int getEspania() {
		return Espania;
	}

	public void setEspania(int espania) {
		Espania = espania;
	}

	public int getChile() {
		return chile;
	}

	public void setChile(int chile) {
		this.chile = chile;
	}

	public int getMexico() {
		return mexico;
	}

	public void setMexico(int mexico) {
		this.mexico = mexico;
	}

	public int getArgentina() {
		return argentina;
	}

	public void setArgentina(int argentina) {
		this.argentina = argentina;
	}
	
	

}

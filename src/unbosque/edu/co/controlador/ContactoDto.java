package unbosque.edu.co.controlador;

public class ContactoDto {

	String datosAmigos[][];
	private final int numeroFilasAmigos = 100;
	private final int numeroColumAmigos = 5;

	/**
	 * <b>precondiciones:</b> Tener datosAmigos
	 * <br>
	 * <b>poscondiciones</b> Dar funcionalidad de crud a botones y mostrarlos en una tabla
	 */
	public ContactoDto() {
		datosAmigos = new String[numeroFilasAmigos][numeroColumAmigos];
	}

	/**
	 * <b>precondiciones:</b> Tener datosAmigos y los parametros requeridos
	 * <br>
	 * <b>poscondiciones</b> Agregar contacto
	 * @param datosAux string matriz
	 * @param nombreC String nombre
	 * @param empresa String empresa
	 * @param pais string pais
	 * @param telefonoC string tel
	 * @param correoC string correo
	 * @param pFila int fila
	 * @return String[][]
	 */
	public String[][] agregarContacto(String datosAux[][], String nombreC, String empresa, String pais,
			String telefonoC, String correoC, int pFila) {
		datosAmigos = datosAux;

		datosAmigos[pFila][0] = nombreC;
		datosAmigos[pFila][1] = empresa;
		datosAmigos[pFila][2] = pais;
		datosAmigos[pFila][3] = telefonoC;
		datosAmigos[pFila][4] = correoC;

		return datosAmigos;
	}

	/**
	 * <b>precondiciones:</b> Tener datosAmigos
	 * <br>
	 * <b>poscondiciones</b> eliminar contacto
	 * @param datosAux matriz
	 * @param nombreC string nombre
	 * @return String[][]
	 */
	public String[][] eliminarContacto(String datosAux[][], String nombreC) {
		datosAmigos = datosAux;

		try {
			for (int i = 0; i < numeroFilasAmigos; i++) {
				for (int j = 0; j < numeroColumAmigos; j++) {
					if (datosAmigos[i][j].equals(nombreC)) {
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
	 * <b>precondiciones:</b> Tener datosAmigos
	 * <br>
	 * <b>poscondiciones</b> Actualizar contacto
	 * @param matriz matriz
	 * @param nombreA string nombre
	 * @param empresa string empresa
	 * @param pais string pais
	 * @param telefonoA string telefono
	 * @param correoA string correo
	 * @return Strin[][]
	 */
	public String[][] actualizarContacto(String[][] matriz, String nombreA, String empresa, String pais,
			String telefonoA, String correoA) {
		datosAmigos = matriz;

		try {
			for (int i = 0; i < numeroFilasAmigos; i++) {
				for (int j = 0; j < 3; j++) {
					if (datosAmigos[i][j].equals(nombreA)) {
						datosAmigos[i][1] = empresa;
						datosAmigos[i][2] = pais;
						datosAmigos[i][3] = telefonoA;
						datosAmigos[i][4] = correoA;
					}

				}
			}
		} catch (Exception e) {
		}

		return datosAmigos;
	}
}

/**
 * 
 */
package unbosque.edu.co.modelo;

/**
 * @author gomez
 *
 */
public class AmigosDao {

	String datosContactos[][];

	/**
	 * 
	 */
	public AmigosDao() {
		datosContactos = new String[100][4];
//		buscar(pInfo);
//		eliminar(pInfo);
//		actualizarDatos(1, "nombre", "pais", "3232", "coquito@l");
	}

	public boolean actualizarDatos(int fila, String nombre, String pais, String tel, String correo) {
		if (fila < datosContactos.length) {
			datosContactos[fila][0] = nombre;
			datosContactos[fila][1] = pais;
			datosContactos[fila][2] = tel;
			datosContactos[fila][3] = correo;

			return true;
		} else {
			return false;
		}
	}

	public boolean buscar(String pInfo, String matriz[][]) {
		boolean boleanoBuscar = false;
		datosContactos = matriz;
		datosContactos = matriz;

//		for (int i = 0; i < datosContactos.length; i++) {
////			for (int j = 0; j < datosContactos[i].length; j++) {
////				System.out.println("ESTOY EN " + datosContactos[i][j]);
//				if (datosContactos[i].equals(pInfo)) {
//					System.out.println("La info es " + datosContactos[i][0]);
//					System.out.println("La info es " + datosContactos[i][1]);
//					System.out.println("La info es " + datosContactos[i][2]);
//					System.out.println("La info es " + datosContactos[i][3]);
////					System.out.println("La info es " +datosContactos[i][4]);
////					boleanoBuscar = true;
//				}
//			}
		for (String[] strings : matriz) {
			System.out.println("La info es " + matriz);
			System.out.println("La info es " + strings);
			System.out.println("La info es " + strings);
			System.out.println("La info es " + strings);
		}
//		}
//		}
		return boleanoBuscar;

	}

	public String[][] eliminar(String pInfo, String matriz[][]) {
		int referencia;
		datosContactos = matriz;

		for (int i = 0; i < datosContactos.length; i++) {
			for (int j = 0; j < datosContactos[i].length; j++) {
				if (pInfo == datosContactos[i][j]) {
					// datos que seran actualizados a null
					referencia = i;
					datosContactos[i][0] = null;
					datosContactos[i][1] = null;
					datosContactos[i][2] = null;
					datosContactos[i][3] = null;
					datosContactos[i][4] = null;
//					actualizaReferencia(referencia);
				}

			}

		}

		return datosContactos;
	}

	public void actualizaReferencia(int referencia) {
		String pais, tel, correo, nombreAnt, empresa;

		for (int i = 0; i < datosContactos.length; i++) {
			for (int j = 0; j < 5; j++) {
				if (i == referencia) {
					nombreAnt = datosContactos[i][0];
					empresa = datosContactos[i][1];
					pais = datosContactos[i][2];
					tel = datosContactos[i][3];
					correo = datosContactos[i][4];

					referencia = referencia + 1;

					datosContactos[referencia][0] = nombreAnt;
					datosContactos[referencia][1] = empresa;
					datosContactos[referencia][0] = pais;
					datosContactos[referencia][0] = tel;
					datosContactos[referencia][0] = correo;
				}
			}
		}

	}
}

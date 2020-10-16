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
		datosContactos = new String[100][5];
		infoBasica();
//		buscar(pInfo);
//		eliminar(pInfo);
//		actualizarDatos(1, "nombre", "pais", "3232", "coquito@l");
	}
	
	public void infoBasica() {
		datosContactos[3][0]  = "nombre";
		datosContactos[3][1] = "empresa";
		datosContactos[3][2] = "pais";
		datosContactos[3][3] = "tele";
		datosContactos[3][4] = "coco@l";
	}

	public boolean actualizarDatos (int fila, String nombre, String pais , String tel, String correo  ) {
		if (fila < datosContactos.length) {
			datosContactos [fila][0] = nombre;
			datosContactos [fila][1] = pais;
			datosContactos [fila][2] = tel;
			datosContactos [fila][3] = correo;
			
			return true;
		} else {
			return false;
		}
	}
	
	public String buscar(String pInfo) {
		String info = pInfo;
		
		for (int i = 0; i < datosContactos.length; i++) {
			for (int j = 0; j < 5; j++) {
				if (pInfo == datosContactos[i][j]) {
					System.out.println("La info es " +datosContactos[i][0]);
					System.out.println("La info es " +datosContactos[i][1]);
					System.out.println("La info es " +datosContactos[i][2]);
					System.out.println("La info es " +datosContactos[i][3]);
					System.out.println("La info es " +datosContactos[i][4]);
				}
				
			}
		}
		
		return info;
	}

	public boolean eliminar (String pInfo) {
		boolean dato = false;
		int referencia;
		
		for (int i = 0; i < datosContactos.length; i++) {
			for (int j = 0; j < 5; j++) {
				if (pInfo == datosContactos[i][j]) {
					//datos que seran actualizados a null
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
		
		return dato;
	}

	public void actualizaReferencia(int referencia) {
		String pais, tel,correo, nombreAnt,empresa;
		
		
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

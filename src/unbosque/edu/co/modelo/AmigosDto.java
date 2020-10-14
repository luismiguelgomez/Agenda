/**
 * 
 */
package unbosque.edu.co.modelo;

/**
 * @author gomez
 *
 */
public class AmigosDto {

	String datosContactos[][];
	/**
	 * 
	 */
	public AmigosDto(String pInfo) {
		datosContactos = new String[100][5];
		infoBasica();
		buscar(pInfo);
		eliminar(pInfo);
	}
	
	private void infoBasica() {
		datosContactos[3][0]  = "nombre";
		datosContactos[3][1] = "empresa";
		datosContactos[3][2] = "pais";
		datosContactos[3][3] = "tele";
		datosContactos[3][4] = "coco@l";
	}

	private String buscar(String pInfo) {
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

	private boolean eliminar (String pInfo) {
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
					
					actualizarDatos(referencia);
				}
				
			}
		}
		
		return dato;
	}

	private void actualizarDatos(int referencia) {
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


/**
 * 
 */
package unbosque.edu.co.vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * @author gomez
 *
 */
public class PanelMenu extends JPanel implements ActionListener {

	/**
	 * 
	 */

	// Constantes

	public final static String Agenda = "agenda";
	public final static String Salir = "salir";
	// Atributos de la interfaz

	private JButton btnAgenda;
	private JButton btnSalir;

	// atrivutos
	
	private PanelAgenda agenda;
	private View ventana;

	public PanelMenu(View pVentana) {
        }


	
	
	
	
	
	public void actionPerformed(ActionEvent pEvento) {
		String comando = pEvento.getActionCommand();
		
		
		if (comando.equals(Agenda)) {
			
		}if (comando.equals(Salir)) {
			System.exit(0);
		} 

		

	}



}
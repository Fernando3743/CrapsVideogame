/**
 * 
 */
package ventana;

import java.awt.EventQueue;

/**
 * @author Paola JR
 *
 */
public class PrincipalVentana {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				GUIBasica miVentana = new GUIBasica();
			}
		});

	}

}

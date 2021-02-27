/**
 * 
 */
package ventana;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 * @author Paola JR
 *
 */
public class GUIBasica extends JFrame {
	//atributos
	private JButton boton1, boton2;
	private Escucha escucha;
	 
	//metodos
	public GUIBasica() {
		initGUI();
		
		//Configuración por defecto de la ventana
		this.setTitle("Ventana");
		this.setSize(300, 200);
		this.setResizable(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	
	private void initGUI() {
		// TODO Auto-generated method stub
		//configurar container y layout
		Container contenedor= this.getContentPane();
		contenedor.setLayout(new FlowLayout());
		
		//Crear objeto control
		
		//crear el objeto escucha
		escucha = new Escucha();
		
		
		//configurar los componentes gráficos
		boton1 = new JButton("boton1");
		boton1.addActionListener(escucha);
		this.add(boton1);
		
		boton2 = new JButton("boton2");
		boton2.addActionListener(escucha);
		add(boton2);
	}
	
	//estructura a usar si hago cambios en algún componente gráfico 
	//por medio de un método externo al escucha
	private void miMetodo() {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				//codigo que cambie componentes gráficos
			}
			
		});
	}
	
	private class Escucha implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent eventObject) {
			// TODO Auto-generated method stub
			
			if(eventObject.getSource()==boton1) {
				JOptionPane.showMessageDialog(null, "diste click en boton1 ");
				boton1.setVisible(false);
			} else {
				JOptionPane.showMessageDialog(null, "diste click en boton2 ");
				boton1.setVisible(true);
			}	
		}
	}

}

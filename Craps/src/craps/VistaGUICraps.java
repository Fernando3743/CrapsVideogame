/**
 * 
 */
package craps;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * @author Fernando Lara
 *
 */
public class VistaGUICraps extends JFrame 
{
	//atributos
	private JLabel dado1, dado2;
	private JButton lanzar;
	private ImageIcon imagen; 
	private Escucha escucha;
	private ControlCraps controlCraps;
	
	//metodos
	public VistaGUICraps()
	{
		//Window container y layout
		Container contenedor= this.getContentPane();
		contenedor.setLayout(new FlowLayout());
		
		//Crear objeto escucha, objeto control
		escucha = new Escucha();
		controlCraps = new ControlCraps();
		
		//agregar los componentes graficos
		imagen = new ImageIcon("src/imagenes/dado.png");
		dado1 = new JLabel(imagen);
		dado2 = new JLabel(imagen);	
		
		lanzar = new JButton("Lanzar");
		lanzar.addActionListener(escucha);
		
		contenedor.add(dado1);
		contenedor.add(dado2);
		contenedor.add(lanzar);
		
		
		this.setTitle("Juego Craps");
		this.setSize(350, 210);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	//Inner class
	private class Escucha implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub
			if(event.getSource()==lanzar)
			{
				visualizarCaras();
				controlCraps.determinarJuego();
				String tiro = "El tiro fue "+controlCraps.getTiro()+"\n";
				Icon icon;
				switch(controlCraps.getEstado())
				{
				case 1: icon =new ImageIcon("src/imagenes/ganaste.png");
					JOptionPane.showMessageDialog(lanzar,tiro+"Has ganado!!","Resultado",JOptionPane.DEFAULT_OPTION, icon);
					controlCraps.resetGame();
					break;
				case 2:icon =new ImageIcon("src/imagenes/perdiste.png");
					JOptionPane.showMessageDialog(lanzar,tiro+"Has perdido!!","Resultado",JOptionPane.DEFAULT_OPTION, icon);
					controlCraps.resetGame();
					break;
				case 3:String punto = "Has establecido punto en: "
					+controlCraps.getPunto()+" debes volver a sacar el valor del punto para ganar,"
							+ "\npero si sacas antes 7 perderas";
					icon = new ImageIcon("src/imagenes/punto.png");
					JOptionPane.showMessageDialog(lanzar, tiro+punto, "Resultado",
							JOptionPane.DEFAULT_OPTION, icon);
					break;					
				}
			}
		}
		
	}
	private void visualizarCaras()
	{
		controlCraps.calcularTiro();
		imagen = new ImageIcon("src/imagenes/"+controlCraps.getCarasDados()[0]+".png");
		dado1.setIcon(imagen);
		imagen = new ImageIcon("src/imagenes/"+controlCraps.getCarasDados()[1]+".png");
		dado2.setIcon(imagen);
	}

}

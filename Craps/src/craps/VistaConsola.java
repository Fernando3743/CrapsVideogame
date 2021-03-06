/*
 * Programacion interactiva
 * Author: Luis Fernando Lara S - 2024730-3743
 * Caso 1 Juego Craps
 */

package craps;
import java.util.Scanner;

// TODO: Auto-generated Javadoc
/**
 * The Class VistaConsola. Clase encargada de realizar las operaciones
 * I/O por linea de comando usando objeto Scanner.
 */
public class VistaConsola
{
	private ControlCraps controlCraps;
	private String pregunta;
	private Scanner lecturaDatos;
	
	/**
	 * Instantiates a new vista consola. Constructor de la clase
	 * inicia los objetos auxiliares
	 */
	//Constructor
	public VistaConsola()
	{
		controlCraps = new ControlCraps();
		lecturaDatos = new Scanner(System.in);
	}
	
	/**
	 * Iniciar juego. Inicia la ronda de juego
	 */
	public void iniciarJuego()
	{
		System.out.println("Desea lanzar los dados? y/n");
		pregunta = lecturaDatos.nextLine();
		
		if(pregunta.equalsIgnoreCase("y"))
		{
			//inicia juego
			controlCraps.calcularTiro();
			System.out.printf("Dado 1 = %d Dado 2 = %d Tiro = %d \n",controlCraps.getCarasDados()[0],
					controlCraps.getCarasDados()[1],controlCraps.getTiro());
			controlCraps.determinarJuego();
			
			switch(controlCraps.getEstado())
			{
			case 1: 
				System.out.println("Has ganado");
				break;
			case 2:
				System.out.println("Has perdido");
				break;
			case 3:
				System.out.printf("Has establecido punto = %d, debes lanzar nuevamente !! \n"
						,controlCraps.getPunto());
				while(controlCraps.getEstado()==3)
				{
					System.out.println("Desea lanzar? escribe y/n");
					pregunta = lecturaDatos.nextLine();
					
					if(pregunta.equalsIgnoreCase("y"))
					{
						controlCraps.calcularTiro();
						System.out.printf("Dado 1 = %d Dado 2 = %d Tiro = %d \n",controlCraps.getCarasDados()[0],
								controlCraps.getCarasDados()[1],controlCraps.getTiro());
						controlCraps.determinarJuego();					
					}
					else
					{
						System.out.println("Perdiste por abandonar el juego");
						controlCraps.setAbandono();
					}
				}
				if(controlCraps.getEstado()==1)
				{
					System.out.println("Lograste punto y Ganaste!!");
				}
				else
				{
					System.out.println("Perdiste!!");
				}
				break;
			}
			seguirJuego();
		}
		else
		{
			System.out.println("Ok,Bye!!");
		}
	}
	
	/**
	 * Seguir juego. Inicia una nueva ronda de juego.
	 */
	private void seguirJuego()
	{
		controlCraps.resetGame();
		System.out.println("Quieres volver a jugar otra ronda? Escribe y/n");
		pregunta = lecturaDatos.nextLine();
		if(pregunta.equalsIgnoreCase("y"))
		{
			iniciarJuego();
		}
		else
		{
			System.out.println("Bye!!");
		}
	}
}

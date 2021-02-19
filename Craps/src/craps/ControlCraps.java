package craps;

public class ControlCraps 
{
	private Dado dado1,dado2;
	private int tiro,punto,estado;
	private boolean lanzamiento;
	private int[] carasDados;
	
	//Constructor	
	public ControlCraps()
	{
		dado1 = new Dado();
		dado2 = new Dado();
		lanzamiento = true; //ronda de tiro
		carasDados = new int[2];		
	}
	
	public void calcularTiro()
	{
		carasDados[0]=dado1.getCaraVisible();
		carasDados[1]=dado2.getCaraVisible();
		tiro=carasDados[0]+carasDados[1];
	}
	
	public void determinarJuego()
	{
		if(lanzamiento)
		{
			//primer lanzamiento o ronda de tiro
			if(tiro==7 || tiro==11)
			{
				estado=1; //ganar
			}
			//error 
			else if(tiro==2 || tiro==3 || tiro==12)
			{
				estado=2; //perder
			}
			else
			{
				estado=3; //entra a ronda de punto
				punto=tiro;
				lanzamiento=false;
			}
		}
		else
		{
			rondaPunto();
		}
		
	}
	
	public int getTiro() {
		return tiro;
	}

	public int getPunto() {
		return punto;
	}

	public int getEstado() {
		return estado;
	}

	public int[] getCarasDados() {
		return carasDados;
	}

	private void rondaPunto()
	{
		if(tiro==punto)
		{
			estado=1;//ganar
			lanzamiento=true;
		}
		if(tiro==7)
		{
			estado=2;//perder
		}
	}
	
	public void setAbandono()
	{
		estado=2;//perdio
		lanzamiento=true;
	}
	
	public void resetGame()
	{
		tiro=0;
		punto=0;
		estado=0;
		lanzamiento=true;
		carasDados[0]=0;
		carasDados[1]=0;
	}

}

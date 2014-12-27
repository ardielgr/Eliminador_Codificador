package patrones.principal;

import java.util.Observable;

import patornes.vista.Menu;
import patornes.vista.Directory;

public class Principal extends Observable {
	Menu ventana;
	Principal (){
		System.out.println("Aqui llamo a los procedimientos de ventana y codificacion");
		ventana = new Menu();
		ventana.Call();
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Principal ejecucion = new Principal();
	}

}

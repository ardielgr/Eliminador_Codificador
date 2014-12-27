package patrones.codificacion;

import java.util.ArrayList;

public interface ICodificacion {
	void lectura_fichero(String linea);
	ArrayList<String[]> getDatos();

}

package patornes.vista;

import java.io.File;
import java.util.ArrayList;

import patrones.principal.Reader;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Directory extends JFrame {
	ArrayList<String> ListaPath = new ArrayList();
	Directory(){
	
    	JFileChooser chooser = new JFileChooser();
		chooser.setMultiSelectionEnabled(true);
		
		int option = chooser.showOpenDialog(null);
		if (option == JFileChooser.APPROVE_OPTION) {
			File[] sf = chooser.getSelectedFiles();
			String path = "";
			String filelist = "nothing";
			if (sf.length > 0) 
				filelist = sf[0].getName();
				//lista = sf[0].getAbsoluteFile();
				path = sf[0].getAbsolutePath();
				ListaPath.add(path);
				
			System.out.println("Ruta-->" + path);
			for (int i = 1; i < sf.length; i++) {
				filelist += ", " + sf[i].getName();
				path = sf[i].getAbsolutePath();
				ListaPath.add(path);
				System.out.println("Rutas-->" +sf[i].getAbsolutePath());
			}
			System.out.println("He elegido = "+ filelist);
			
			statusbar.setText("You chose " + filelist);
			Reader lectura = new Reader(ListaPath);
		}
		else {
			statusbar.setText("You canceled.");
		}
	}
	final JLabel statusbar = 
			new JLabel("Output of your selection will go here");

	
//	public ArrayList<String> eleccion(){
//		
//		
//		return ListaPath;
//		
//	}
}

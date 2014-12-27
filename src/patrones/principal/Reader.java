package patrones.principal;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class Reader {
	
	String variable_;
	ArrayList<String> var;
	static RandomAccessFile fichero_;
	static ArrayList<String> buffer = new ArrayList<String>();
	
	public Reader(ArrayList<String> listaPath) throws IOException {
		for (int i = 0; i < listaPath.size(); i++){
			variable_ = listaPath.get(i);
			fichero_ = new RandomAccessFile(variable_, "rw");
			OpenFile(fichero_);
		}
		//fichero_ = new RandomAccessFile(variable_, "rw");
	}
	public void OpenFile(RandomAccessFile fichero_) throws IOException{
		try{
			
			do {
				System.out.println(fichero_.readLine());
			}	while ((fichero_.readLine()) !=null);
		}
		catch(IOException e){
			System.out.println("Error con el fichero");
			return;
		}
	}

}

package patornes.vista;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

import patrones.codificacion.ICodificacion;
import patrones.codificacion.Random_Change;
import patornes.vista.Directory;


public class Menu implements ActionListener, ItemListener {
	JTextArea output;
	JScrollPane scrollPane;
	String newline = "\n";
	ArrayList<String> Option = new ArrayList();
	
	public JMenuBar createMenuBar() {
		JMenuBar menuBar;
		JMenu menu, submenu;
		JMenuItem menuItem;
		JRadioButtonMenuItem rbMenuItem;
		JCheckBoxMenuItem cbMenuItem;

		//Create the menu bar.
		menuBar = new JMenuBar();

		//Primer Menu
		menu = new JMenu("Archivo");
		menu.setMnemonic(KeyEvent.VK_A);
		menu.getAccessibleContext().setAccessibleDescription(
				"The only menu in this program that has menu items");
		menuBar.add(menu);

		//a group of JMenuItems
		menuItem = new JMenuItem("Abrir Archivo",
				KeyEvent.VK_T);
		//menuItem.setMnemonic(KeyEvent.VK_T); //used constructor instead
		menuItem.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_1, ActionEvent.ALT_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription(
				"This doesn't really do anything");
		menuItem.addActionListener(this);
		menu.add(menuItem);
//
//		ImageIcon icon = createImageIcon("images/middle.gif");
//		menuItem = new JMenuItem("Both text and icon", icon);
//		menuItem.setMnemonic(KeyEvent.VK_B);
//		menuItem.addActionListener(this);
//		menu.add(menuItem);
//
//		menuItem = new JMenuItem(icon);
//		menuItem.setMnemonic(KeyEvent.VK_D);
//		menuItem.addActionListener(this);
//		menu.add(menuItem);
//
//		//a group of radio button menu items
//		menu.addSeparator();
//		ButtonGroup group = new ButtonGroup();
//
//		rbMenuItem = new JRadioButtonMenuItem("A radio button menu item");
//		rbMenuItem.setSelected(true);
//		rbMenuItem.setMnemonic(KeyEvent.VK_R);
//		group.add(rbMenuItem);
//		rbMenuItem.addActionListener(this);
//		menu.add(rbMenuItem);
//
//		rbMenuItem = new JRadioButtonMenuItem("Another one");
//		rbMenuItem.setMnemonic(KeyEvent.VK_O);
//		group.add(rbMenuItem);
//		rbMenuItem.addActionListener(this);
//		menu.add(rbMenuItem);

		//a group of check box menu items
//		menu.addSeparator();
//		cbMenuItem = new JCheckBoxMenuItem("A check box menu item");
//		cbMenuItem.setMnemonic(KeyEvent.VK_C);
//		cbMenuItem.addItemListener(this);
//		menu.add(cbMenuItem);
//
//		cbMenuItem = new JCheckBoxMenuItem("Another one");
//		cbMenuItem.setMnemonic(KeyEvent.VK_H);
//		cbMenuItem.addItemListener(this);
//		menu.add(cbMenuItem);
//
//		//a submenu
//		menu.addSeparator();
//		submenu = new JMenu("Utilidades");
//		submenu.setMnemonic(KeyEvent.VK_S);
//
//		menuItem = new JMenuItem("An item in the submenu");
//		menuItem.setAccelerator(KeyStroke.getKeyStroke(
//				KeyEvent.VK_2, ActionEvent.ALT_MASK));
//		menuItem.addActionListener(this);
//		submenu.add(menuItem);
//
//		menuItem = new JMenuItem("Another item");
//		menuItem.addActionListener(this);
//		submenu.add(menuItem);
//		menu.add(submenu);

		//Build second menu in the menu bar.
		menu = new JMenu("Opciones");
		menu.setMnemonic(KeyEvent.VK_N);
		menu.getAccessibleContext().setAccessibleDescription(
				"Este menu contiene las opciones de encriptacion y borrado");
		menuBar.add(menu);
		menu.addSeparator();
		ButtonGroup group = new ButtonGroup();
//
		cbMenuItem = new JCheckBoxMenuItem("Random Change");
		cbMenuItem.addItemListener(this);
		menu.add(cbMenuItem);

		cbMenuItem = new JCheckBoxMenuItem("Row Change");
		cbMenuItem.addItemListener(this);
		menu.add(cbMenuItem);

		menu.addSeparator();
		rbMenuItem = new JRadioButtonMenuItem("Encriptado");
		rbMenuItem.setSelected(false);
		group.add(rbMenuItem);
		rbMenuItem.addActionListener(this);
		menu.add(rbMenuItem);
		
		menu = new JMenu("Run");
		menu.setMnemonic(KeyEvent.VK_R);
		menu.getAccessibleContext().setAccessibleDescription(
				"The only menu in this program that has menu items");
		menuBar.add(menu);

		//a group of JMenuItems
		menuItem = new JMenuItem("Run",
				KeyEvent.VK_T);
		//menuItem.setMnemonic(KeyEvent.VK_T); //used constructor instead
		menuItem.setAccelerator(KeyStroke.getKeyStroke(
				KeyEvent.VK_2, ActionEvent.ALT_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription(
				"This doesn't really do anything");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		return menuBar;
	}

	public Container createContentPane() {
		//Create the content-pane-to-be.
		JPanel contentPane = new JPanel(new BorderLayout());
		contentPane.setOpaque(true);

		//Create a scrolled text area.
		output = new JTextArea(5, 30);
		output.setEditable(false);
		scrollPane = new JScrollPane(output);

		//Add the text area to the content pane.
		contentPane.add(scrollPane, BorderLayout.CENTER);

		return contentPane;
	}
	protected static ImageIcon createImageIcon(String path) {
		java.net.URL imgURL = Menu.class.getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}

	protected String getClassName(Object o) {
		String classString = o.getClass().getName();
		int dotIndex = classString.lastIndexOf(".");
		return classString.substring(dotIndex+1);
	}
	   
	
	public void itemStateChanged(ItemEvent e) {
        JMenuItem source = (JMenuItem)(e.getSource());
        
        
        
        
        
        String s = "Item event detected."
                   + newline
                   + "    Event source: " + source.getText()
                   + " (an instance of " + getClassName(source) + ")"
                   + newline
                   + "    New state: "
                   + ((e.getStateChange() == ItemEvent.SELECTED) ?
                     "selected":"unselected");
        Option.add(source.getText());
        output.append(s + newline);
        output.setCaretPosition(output.getDocument().getLength());
        
        
    }
 


	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	//	ArrayList<String> lista = new ArrayList();
		
		ICodificacion ejemplo;
		final JLabel statusbar = 
				new JLabel("Output of your selection will go here");
		JMenuItem source = (JMenuItem)(e.getSource());
		String s = "Action event detected."
				+ newline
				+ "    Event source: " + source.getText()
				+ " (an instance of " + getClassName(source) + ")";
		output.append(s + newline);
		output.setCaretPosition(output.getDocument().getLength());
		if (source.getText() == "Abrir Archivo"){
			System.out.println("Me entra aqui");
			Directory directorio = new Directory();
		}
		if (source.getText() == "Run"){
			for (int indiceOpciones = 0; indiceOpciones < Option.size(); indiceOpciones++){
				if (Option.get(indiceOpciones) == "Random Change"){
					System.out.println("RUN RUNEANDO en RANDOM");
					ejemplo = new Random_Change();
					ejemplo.lectura_fichero(null);
				}
				if (Option.get(indiceOpciones) == "Row Change"){
						System.out.println(("Run runeando en ROW CHANGE"));
				}
			}
				
		}
	}
	
	 private static void createAndShowGUI() {
	        //Create and set up the window.
	        JFrame frame = new JFrame("Eliminador CodEncrypt");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 
	        //Create and set up the content pane.
	        Menu demo = new Menu();
	        frame.setJMenuBar(demo.createMenuBar());
	        frame.setContentPane(demo.createContentPane());
	 
	        //Display the window.
	        frame.setSize(450, 260);
	        frame.setVisible(true);
	    }
	 
	 public void Call(){
		 createAndShowGUI();
	 }
}
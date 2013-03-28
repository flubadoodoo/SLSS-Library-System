package main;

import java.awt.GraphicsEnvironment;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.SwingUtilities;

import org.jdesktop.swingx.JXFrame;

import panel.abstractPanel.AbstractPanel;
import panel.account.AccountScreen;
import panel.account.BooksScreen;
import panel.account.FinesScreen;
import panel.library_func.LibraryBooksScreen;
import panel.library_func.LibraryFunctionScreen;
import panel.library_func.LibraryStudentsScreen;
import panel.welcome.LoggedInScreen;
import panel.welcome.WelcomeScreen;

@SuppressWarnings("serial")
public class Main extends JXFrame {
	
	private static final int DISPLAY_WIDTH = 1000; // the width of the window
	private static final int DISPLAY_HEIGHT = 592; // the height of the window
	
	private static Main mainFrame;
	
	private static ArrayList<AbstractPanel> panels;
	
	public static enum PANELS {
		WELCOME, LOGGED_IN, ACCOUNT, BOOKS, FINES, LIBRARY_FUNC, LIB_BOOKS, LIB_STUDENTS
	};
	
	/* Constructor of the Main class.
	 * Sets some properties of the JXFrame. Sets the initial JXPanel to the WelcomeScreen.
	 * */
	public Main() {
		
	}
	
	/* Main method.
	 * The program starts here. This method creates a new instance of Main.
	 * */
	public static void main(String[] args) {
		fixFiles();
		mainFrame = new Main(); // create a new frame
		Main.setPanels(new ArrayList<AbstractPanel>()); // initialize the array list of panels
		Main.addPanel(new WelcomeScreen("Welcome to the Stephen Lewis Library System!")); // create a welcome screen
		Main.addPanel(new LoggedInScreen("logged in")); // create a student logged in screen
		Main.addPanel(new AccountScreen("my account"), "LoggedInScreen"); // create a my account screen
		Main.addPanel(new BooksScreen("my books"), "AccountScreen"); // create a my books screen
		Main.addPanel(new FinesScreen("my fines"), "AccountScreen"); // create a my fines screen
		Main.addPanel(new LibraryFunctionScreen("library functions"), "LoggedInScreen"); // create a library functions screen
		Main.addPanel(new LibraryBooksScreen("library books"), "LibraryFuctionScreen"); // create a library books screen
		Main.addPanel(new LibraryStudentsScreen("library students"), "LibraryFunctionScreen"); // create a library students screen
		// set the initial location of the window to be centered on the display
		mainFrame.setLocation((int) GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint().getX() - DISPLAY_WIDTH / 2, (int) GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint().getY() - DISPLAY_HEIGHT / 2);
		mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE); // set what happens when the close button is pressed
		mainFrame.setTitle("SLSS Library System"); // set the title of the window
		mainFrame.setSize(DISPLAY_WIDTH, DISPLAY_HEIGHT); // set the size of the window
		Main.setPanel(Main.PANELS.WELCOME); // set the content pane to show the welcome screen panel
		mainFrame.setVisible(true); // make the window visible
	}
	
	private static void addPanel(AbstractPanel panel, String superPanel) {
		Main.addPanel(panel);
		try {
			BufferedWriter w = new BufferedWriter(new FileWriter("file/sys/pnl/pnl.txt", true));
			w.write(panel.getClass().getSimpleName() + ":" + superPanel + "\n");
			w.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void addPanel(AbstractPanel panel) {
		Main.getPanels().add(panel);
	}
	
	private static void fixFiles() {
		// make directories
		String usrDir = "file/usr/";
		File file = new File(usrDir);
		file.mkdirs();
		
		String sysDir = "file/sys/";
		file = new File(sysDir);
		file.mkdirs();
		
		String logDir = sysDir + "log/";
		file = new File(logDir);
		file.mkdirs();
		
		String pnlDir = sysDir + "pnl/";
		file = new File(pnlDir);
		file.mkdirs();
		
		String bkDir = sysDir + "bk/";
		file = new File(bkDir);
		file.mkdirs();
		
		// make files
		String logFile = logDir + "log.txt";
		file = new File(logFile);
		try {
			file.createNewFile();
			BufferedWriter w = new BufferedWriter(new FileWriter(file));
			w.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String pnlFile = pnlDir + "pnl.txt";
		file = new File(pnlFile);
		try {
			file.createNewFile();
			FileWriter w = new FileWriter(file);
			w.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String bkFile = bkDir + "bk.txt";
		file = new File(bkFile);
		try {
			file.createNewFile();
			FileWriter w = new FileWriter(file);
			w.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void setPanel(PANELS panel) {
		switch (panel) {
		case WELCOME: // switch to the welcome screen [index 0]
			Main.getMainFrame().setContentPane(Main.getPanels().get(0).initialize());
			break;
		case LOGGED_IN: // switch to the logged in welcome screen [index 1]
			Main.getMainFrame().setContentPane(Main.getPanels().get(1).initialize());
			break;
		case ACCOUNT: // switch to the my account screen [index 2]
			Main.getMainFrame().setContentPane(Main.getPanels().get(2).initialize());
			break;
		case BOOKS: // switch to the my books screen [index 3]
			Main.getMainFrame().setContentPane(Main.getPanels().get(3).initialize());
			break;
		case FINES: // switch to the my fines screen [index 4]
			Main.getMainFrame().setContentPane(Main.getPanels().get(4).initialize());
			break;
		case LIBRARY_FUNC: // switch to the library functions screen [index 5]
			Main.getMainFrame().setContentPane(Main.getPanels().get(5).initialize());
			break;
		case LIB_BOOKS: // switch to the library books screen [index 6]
			Main.getMainFrame().setContentPane(Main.getPanels().get(6).initialize());
			break;
		case LIB_STUDENTS: // switch to the library students screen [index 7]
			Main.getMainFrame().setContentPane(Main.getPanels().get(7).initialize());
			break;
		}
		SwingUtilities.updateComponentTreeUI(Main.getMainFrame()); // update the frame
	}
	
	public static int getDisplayWidth() {
		return DISPLAY_WIDTH;
	}
	
	public static int getDisplayHeight() {
		return DISPLAY_HEIGHT;
	}
	
	public static Main getMainFrame() {
		return mainFrame;
	}
	
	public static void setMainFrame(Main mainFrame) {
		Main.mainFrame = mainFrame;
	}
	
	public static ArrayList<AbstractPanel> getPanels() {
		return panels;
	}
	
	public static void setPanels(ArrayList<AbstractPanel> panels) {
		Main.panels = panels;
	}
	
}

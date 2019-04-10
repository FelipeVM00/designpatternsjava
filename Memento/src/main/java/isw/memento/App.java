package isw.memento;

import java.awt.EventQueue;

import isw.memento.gui.EmployeeGUI;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	EventQueue.invokeLater(new Runnable() {
    		public void run() {
    			new EmployeeGUI().setVisible(true);
    		}
    	});
    }   
}

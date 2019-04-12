package isw.templatemethod;

import java.io.File;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import isw.templatemethod.impl.DrugstoreFileProcess;
import isw.templatemethod.impl.GroceryFileProcess;

public class TemplateMethodMain extends TimerTask
{
    private static final String[] PATHS =
    		new String[]{"C:/Users/ESTUDIANTES/eclipse-workspace/templatemethod/src/main/java/META-INF/files/drugstore", "C:/Users/ESTUDIANTES/eclipse-workspace/templatemethod/src/main/java/META-INF/files/grocery"};
    private static final String LOG_DIR = "C:/Users/ESTUDIANTES/eclipse-workspace/templatemethod/src/main/java/META-INF/files/logs";
    private static final String PROCESS_DIR = "C:/Users/ESTUDIANTES/eclipse-workspace/templatemethod/src/main/java/META-INF/files/process";
    
    public static void main(String[] args) {
    	new TemplateMethodMain().start();
    }

    public void start() {
    	try {
    		Timer timer = new Timer();
    		timer.schedule(this, new Date(), (long) 1000 * 10);
    		System.in.read();
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
    
    @Override
    public void run() {
    	System.out.println("> Monitoring start");
    	File f = new File(PATHS[0]);
    	if(!f.exists())
    		throw new RuntimeException("El path '"+PATHS[0]+"' no existe");
    	System.out.println("> Read Path " + PATHS[0]);
    	File[] drugstoreFiles = f.listFiles();
    	for (File file : drugstoreFiles) {
    		try {
    			System.out.println("> File found > " + file.getName());
    			new DrugstoreFileProcess(file,LOG_DIR,PROCESS_DIR).execute();
    			System.out.println("Archivo procesado > " + file.getName());
    		} catch (Exception e) {
    			System.err.println(e.getMessage());
    		}
    	}
    	
    	f = new File(PATHS[1]);
    	if(!f.exists())
    		throw new RuntimeException("El path '"+PATHS[1]+"' no existe");

    	System.out.println("> Read Path " + PATHS[1]);
    	File[] groceryFiles = f.listFiles();
    	for (File file : groceryFiles) {
    		try {
    			System.out.println("> File found > " + file.getName());
    			new GroceryFileProcess(file,LOG_DIR,PROCESS_DIR).execute();
    			System.out.println("Archivo procesado > " + file.getName());
    		} catch (Exception e) {
    			System.err.println(e.getMessage());
    		}
    	}
    }
}
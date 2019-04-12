package isw.templatemethod.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import isw.templatemethod.util.OnMemoryDataBase;

public class GroceryFileProcess extends AbstractFileProcessTemplate{
	private String log = "";

	public GroceryFileProcess(File file, String logPath, String movePath) {
		super(file, logPath, movePath);
	}
	
	@Override
	protected void validateName() throws Exception {
		String fileName = file.getName();
		if (!fileName.endsWith(".gry")) {
			throw new Exception("Nombre del archivo no válido"
					+ ", debe terminar con .gry");
		}
		
		if (fileName.length() != 7) {
			throw new Exception("El documento no tiene el formato esperado");
		}
	}
	
	@Override
	protected void processFile() throws Exception {
		FileInputStream input = new FileInputStream(file);
		try {
			byte[] fileContect = new byte[input.available()];
			input.read(fileContect);
			String message = new String(fileContect);
			String[] lines = message.split("\n");
			for (String line : lines) {
				String[] parts = line.split(",");
				String id = parts[0];
				String customer = parts[1];
				double amount = Double.parseDouble(parts[2]);
				String date = parts[3];
				boolean exist = OnMemoryDataBase.customerExist(
						Integer.parseInt(customer));
				if (!exist) {
					log += id + " E" + customer + "\t\t" + date
							+ " El cliente no existe\n";
				} else if (amount > 200) {
					log += id + " E" + customer + "\t\t" + date
							+ " El monto excede el máximo\n";
				} else {
//	@TODO Aplicar el pago.
					log += id + " E" + customer + "\t\t" + date + " Aplicado exitosamente\n";
					
				}
			}
		} finally {
			try {
				input.close();
			} catch (Exception e) {
			}
		}
	}
	
	@Override
	protected void createLog() throws Exception {
		FileOutputStream out = null;
		try {
			File outFile = new File(logPath + "/" + file.getName());
			if (!outFile.exists()) {
				outFile.createNewFile();
			}
			out = new FileOutputStream(outFile, false);
			out.write(log.getBytes());
			out.flush();
		} finally {
			out.close();
		}
	}
}
	
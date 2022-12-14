package part_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class VehicleLogger {

	private VehicleWasher washer;
	
	private FileWriter fw;
	private PrintWriter pw;
	
	private FileReader fr;
	private BufferedReader br;
	
	public VehicleLogger(VehicleWasher washer) {
		
		this.washer=washer;
	}
	
	public void write() throws IOException {
		
		fw = new FileWriter("Log.txt");
		pw= new PrintWriter(fw);
		
		fw.close();
		pw.close();
		
	}
	
	
	
	
	
	
}

package part_1;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		VehicleWasher vv= new VehicleWasher(2,4,3,1.5);
		VehicleLogger vl= new VehicleLogger(vv);
		
		Vehicle v= new SUV(vv);
		Vehicle v2= new Car(vv);
		Vehicle v3= new Truck(vv);
		Vehicle v4= new MiniBus(vv);
		
		
		Thread thread = new Thread(v);
		Thread thread2 = new Thread(v2);
		Thread thread3 = new Thread(v3);
		Thread thread4 = new Thread(v4);
		
		thread.start();
		thread2.start();
		thread3.start();
		thread4.start();
		
		try {
			thread.join();
			thread2.join();
			thread3.join();
			thread4.join();
			
		}
		catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		try {
			vl.write();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

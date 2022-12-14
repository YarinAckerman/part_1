package part_1;

import java.util.UUID;

public abstract class Vehicle implements Runnable {

	protected VehicleWasher washer;
	
	public Vehicle(VehicleWasher washer) {
		
		this.washer=washer;
		
	}
	
	@Override
	public void run() {
		
//		System.out.println(this.toString()+" Entered to waiting at position: "+(this.washer.getWaitingFront()));
		
		try {
			Thread.sleep(washer.getWaitingTime());
			washer.enqueueWaiting(this);
//			System.out.println(this.toString() + " id " + (Thread.currentThread().getId() + (-14)) + ": was added to the line ");
//			
//			
//			
//			washer.dequeueWaiting();
//			washer.addToWashing();
//			System.out.println(this.toString() + " id " + (Thread.currentThread().getId() + (-14)) + ": was added to the washing ");
//			washer.removeFromWashing();
//			System.out.println(this.toString() + " id " + (Thread.currentThread().getId() + (-14)) + ": has finished washing");
		}
		catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		
		washer.atWashing();

		//washer.washedToList(this);
	}
	
}

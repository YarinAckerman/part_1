package part_1;

import java.util.concurrent.Semaphore;

public class VehicleWasher {

	private int waitingFront = 0;
	private int waitingRear = 0;
	private int washingTime;
	private int waitingTime;

	private Vehicle waiting[];
	private Semaphore washing;

	private Car washedCar[];
	private SUV washedSUV[];
	private Truck washedTruck[];
	private MiniBus washedMiniBus[];

	public VehicleWasher(int n, int m, double washingAvarage, double waitingAvarage) {

		this.washing = new Semaphore(n, true);

		this.waiting = new Vehicle[m];

		this.washedCar = new Car[m];
		this.washedMiniBus = new MiniBus[m];
		this.washedTruck = new Truck[m];
		this.washedSUV = new SUV[m];

		this.washingTime = washingTime(washingAvarage);
		this.waitingTime = washingTime(waitingAvarage);
	}

	public synchronized void enqueueWaiting(Vehicle v) throws InterruptedException {

		waiting[waitingRear] = v;
		waitingRear++;

		System.out.println(v.toString() + " id " + (Thread.currentThread().getId() + (-14)) + ": was added to the line ");
		
	}

	public synchronized Vehicle dequeueWaiting() {

		Vehicle temp;
		temp = waiting[waitingFront];
		waitingFront++;

		return temp;
	}

	public void atWashing() {

		Vehicle vehicle;
		vehicle = dequeueWaiting();

//		synchronized (this) {

			try {

				addToWashing();

				System.out.println(vehicle.toString() + " id " + (Thread.currentThread().getId() + (-14))
						+ ": Was Added to washing");

				Thread.sleep(2000);

			} catch (InterruptedException e) {

				e.printStackTrace();
			}
//		}

		removeFromWashing();
		
		System.out.println(vehicle.toString() + " id " + (Thread.currentThread().getId() + (-14)) + ": Has finished washing");
		
		washedToList(vehicle);
	}

	public int getWashingTime() {
		return washingTime;
	}

	public int getWaitingTime() {
		return waitingTime;
	}

	public synchronized void addToWashing() throws InterruptedException {

		washing.acquire();
	}

	public void removeFromWashing() {

		washing.release();

		//System.out.println("Thread id: "+ (Thread.currentThread().getId()+(-14)) +" Has finished washing");
	}

	public int washingTime(double avg) {

		double U = Math.random() * 1;
		double nextTime = -1 * (Math.log(U) / avg);

		nextTime *= 1000;

		return (int) nextTime;
	}

	public synchronized void washedToList(Vehicle v) {

		if (v instanceof Car) {
			for (int i = 0; i < washedCar.length; i++) {
				if (washedCar[i] == null) {
					washedCar[i] = (Car) v;
					break;
				}
			}
		}

		else if (v instanceof SUV) {

			for (int i = 0; i < washedSUV.length; i++) {
				if (washedSUV[i] == null) {
					washedSUV[i] = (SUV) v;
					break;
				}
			}

		}

		else if (v instanceof Truck) {
			for (int i = 0; i < washedTruck.length; i++) {
				if (washedTruck[i] == null) {
					washedTruck[i] = (Truck) v;
					break;
				}
			}
		}

		else if (v instanceof MiniBus) {
			for (int i = 0; i < washedMiniBus.length; i++) {
				if (washedMiniBus[i] == null) {
					washedMiniBus[i] = (MiniBus) v;
					break;
				}
			}
		}

	}

	public void print() {

		for (int i = 0; i < washedCar.length; i++) {

			if (washedCar[i] == null) {
				break;
			} else {
				System.out.println(washedCar[i].toString());
			}
		}

		for (int i = 0; i < washedSUV.length; i++) {

			if (washedSUV[i] == null) {
				break;
			}

			System.out.println(washedSUV[i].toString());
		}
		for (int i = 0; i < washedTruck.length; i++) {

			if (washedTruck[i] == null) {
				break;
			}

			System.out.println(washedTruck[i].toString());
		}
		for (int i = 0; i < washedMiniBus.length; i++) {

			if (washedMiniBus[i] == null) {
				break;
			}

			System.out.println(washedMiniBus[i].toString());
		}
	}

	public Car[] getWashedCar() {
		return washedCar;
	}

	public SUV[] getWashedSUV() {
		return washedSUV;
	}

	public Truck[] getWashedTruck() {
		return washedTruck;
	}

	public MiniBus[] getWashedMiniBus() {
		return washedMiniBus;
	}
}
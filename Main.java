package part_1;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		//Yarin Ackerman 318666443
		//Rami Abu Rabia 314820135

		Scanner input = new Scanner(System.in);

		System.out.println("Please enter numbers of vehicles");
		int numOfVehicle = input.nextInt();

		System.out.println("Please enter numbers of washing stations");
		int numOfWStaion = input.nextInt();

		VehicleWasher vehicleWasher = new VehicleWasher(numOfWStaion, numOfVehicle, numOfWStaion, numOfWStaion);
		input.close();

		Thread[] threadsArr = new Thread[numOfVehicle];
		Vehicle[] vehicleArr = new Vehicle[numOfVehicle];

		for (int i = 0; i < vehicleArr.length; i++) {

			int random = ((int) (Math.random() * 4) + 1);

			switch (random) {

			case 1:
				vehicleArr[i] = new Car(vehicleWasher);
				break;

			case 2:
				vehicleArr[i] = new SUV(vehicleWasher);
				break;

			case 3:
				vehicleArr[i] = new Truck(vehicleWasher);
				break;

			case 4:
				vehicleArr[i] = new MiniBus(vehicleWasher);
				break;
			}
		}

		for (int i = 0; i < threadsArr.length; i++)
			threadsArr[i] = new Thread(threadsArr[i]);

		for (int i = 0; i < threadsArr.length; i++)
			threadsArr[i].start();

	}

}

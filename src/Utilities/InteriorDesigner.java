package Utilities;

import java.util.InputMismatchException;
import java.util.Scanner;

import RoomTypes.*;

// Created a class that holds all the utility methods
public class InteriorDesigner {
	public void menu() {
		try {
			Scanner in = new Scanner(System.in);

			House house = new House();

			while (true) {
				System.out.println("Menu:");
				System.out.println("1. Print the house");
				System.out.println("2. Add room(s)");
				System.out.println("0. Exit");
				System.out.print("Enter your choice: ");
				int choice = in.nextInt();

				switch (choice) {
					case 1 :
						printHouse(house);
						break;
					case 2 :
						addHouse(in, house);
						break;
					case 0 :
						System.out.println("Goodbyeeeee");
						System.exit(0);
					default :
						System.out.println("Invalid choice. Please try again.");
				}

				System.out.println();
			}
		} catch (InputMismatchException e) {
			System.err.println("Invalid input");
		}
	}
	void printHouse(House house) {
		// Account for if the house is empty
		if (house.getRooms().isEmpty()) {
			System.err.println("The house is empty. Please add a room first.");
			return;
		} else {
			System.out.println("House Details:");
			for (int i = 0; i < house.getRooms().size(); i++) {
				Room room = house.getRooms().get(i);
				System.out.println("\tRoom " + (i + 1));

				// Uses the name of the class as a string
				System.out
						.println("\tShape: " + room.getClass().getSimpleName());

				System.out.println("\tSquare Footage: " + room.getArea());
				System.out.println("\tPerimeter: " + room.getPerimeter());
				System.out.println("\tHeight: " + (room.getHeight()));
				System.out.println("\t\tFurniture:");
				for (Furniture furniture : room.getFurniture()) {
					System.out.println("\t\t\t- " + furniture.getName()
							+ " (Cost: $" + furniture.getCost()
							+ ", Description: " + furniture.getDescription()
							+ ", Height: " + furniture.getHeight() + ", Width: "
							+ furniture.getWidth() + ", Weight: "
							+ furniture.getWeight() + ")");
				}
				System.out.println();
			}
		}
	}

	void addHouse(Scanner in, House house) {
		try {
			System.out.print("Enter the number of rooms: ");
			int numRooms = in.nextInt();
			in.nextLine(); // Consume the newline character after reading
							// numRooms

			for (int i = 0; i < numRooms; i++) {
				System.out.println("Room " + (i + 1));
				System.out.print(
						"Enter the angle(s) of the room separated by a space: ");
				String angleString = in.nextLine();
				int[] angles = anglesConverter(angleString);

				Room room;
				if (checkAnglesForSquareOrRectangle(angles)) {
					System.out.print("Enter the side length: ");
					float length = in.nextFloat();
					System.out.print("Enter the width: ");
					float width = in.nextFloat();
					System.out.print("Enter the height: ");
					float height = in.nextFloat();

					// Determine if the shape is a rectangle or square
					if (length == width) {
						room = new Square(length, width, height);
					} else {
						room = new Rectangle(length, width, height);
					}
				} else if (angles.length == 1 && sumOfAngles(angles) == 360) {
					System.out.print("Enter the radius: ");
					float radius = in.nextFloat();
					System.out.print("Enter the height: ");
					float height = in.nextFloat();

					room = new Circle(radius, height);

				} else if (sumOfAngles(angles) == 180) {
					System.out.print("Enter the length of side 1: ");
					float side1 = in.nextFloat();
					System.out.print("Enter the length of side 2: ");
					float side2 = in.nextFloat();
					System.out.print("Enter the length of side 3: ");
					float side3 = in.nextFloat();
					System.out.print("Enter the height: ");
					float height = in.nextFloat();
					room = new Triangle(side1, side2, side3, height);
				} else {
					System.err.println("Invalid room shape. Skipping room.");
					continue;
				}

				System.out.print("Enter the number of furniture items: ");
				int numFurniture = in.nextInt();
				in.nextLine();

				for (int j = 0; j < numFurniture; j++) {
					System.out.println("Furniture " + (j + 1));
					System.out.print("Enter the name: ");
					String name = in.nextLine();
					System.out.print("Enter the cost: ");
					float cost = in.nextFloat();
					in.nextLine(); // Consume the newline character
					System.out.print("Enter the description: ");
					String description = in.nextLine();
					System.out.print("Enter the height: ");
					float height = in.nextFloat();
					System.out.print("Enter the width: ");
					float width = in.nextFloat();
					System.out.print("Enter the weight: ");
					float weight = in.nextFloat();
					in.nextLine();

					Furniture furniture = new Furniture(name, cost, description,
							height, width, weight);
					room.addFurniture(furniture);
				}

				house.addRoom(room);
				in.nextLine(); // Clears the input scanner
			}
			if (!house.getRooms().isEmpty()) {
				System.out.println("Room successfully added");
			} else {
				System.err.println("Error with adding room");

			}
		} catch (InputMismatchException | NumberFormatException e) {
			System.err.println("Invalid Input");
		}

	}
	// Converts the array of String angles into and array of integers, which is
	// further used to calculate if the sum is equal to 180 to determine if it
	// is a triangle or not
	int[] anglesConverter(String angleString) {
		String[] angleStrings = angleString.split(" ");
		int[] angles = new int[angleStrings.length];

		for (int i = 0; i < angleStrings.length; i++) {
			angles[i] = Integer.parseInt(angleStrings[i]);
		}
		return angles;
	}

	int sumOfAngles(int[] angles) {
		int sum = 0;
		for (int angle : angles) {
			sum += angle;
		}
		return sum;
	}
	// Checks if the angles are appropriate for squares or rectangles
	boolean checkAnglesForSquareOrRectangle(int[] angles) {
		boolean allAnglesAre90 = true;
		for (int angle : angles) {
			if (angle != 90) {
				allAnglesAre90 = false;
				break;
			}
		}
		return allAnglesAre90;
	}
}

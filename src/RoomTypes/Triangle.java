package RoomTypes;
import java.util.ArrayList;
import java.util.List;

import Utilities.Furniture;
import Utilities.Room;

public class Triangle implements Room {
	private float side1;
	private float side2;
	private float side3;
	private float height;
	private List<Furniture> furniture;

	public Triangle(float side1, float side2, float side3, float height) {
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
		this.height = height;
		this.furniture = new ArrayList<>();
	}

	@Override
	public float getArea() {
		float semiPerimeter = (side1 + side2 + side3) / 2;
		return (float) Math.sqrt(semiPerimeter * (semiPerimeter - side1)
				* (semiPerimeter - side2) * (semiPerimeter - side3));
	}

	@Override
	public float getPerimeter() {
		return side1 + side2 + side3;
	}

	@Override
	public void addFurniture(Furniture furniture) {
		this.furniture.add(furniture);
	}

	@Override
	public List<Furniture> getFurniture() {
		return furniture;
	}
	@Override
	public float getHeight() {
		return height;
	}

	// Getters and Setters
	public void setHeight(float height) {
		this.height = height;
	}

	public void setFurniture(List<Furniture> furniture) {
		this.furniture = furniture;
	}

}

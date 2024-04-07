package RoomTypes;
import java.util.ArrayList;
import java.util.List;

import Utilities.Furniture;
import Utilities.Room;

public class Circle implements Room {
	float radius;
	float height;
	List<Furniture> furniture;

	public Circle(float radius, float height) {
		this.radius = radius;
		this.height = height;
		this.furniture = new ArrayList<>();
	}
	@Override
	public float getArea() {
		return (float) (Math.PI * radius * radius);
	}
	@Override
	public float getPerimeter() {
		return (float) (2 * Math.PI * radius);
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
	public float getRadius() {
		return radius;
	}
	public void setRadius(float radius) {
		this.radius = radius;
	}
	public void setHeight(float height) {
		this.height = height;
	}
	public void setFurniture(List<Furniture> furniture) {
		this.furniture = furniture;
	}

}

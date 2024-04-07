package RoomTypes;
import java.util.ArrayList;
import java.util.List;

import Utilities.Furniture;
import Utilities.Room;

public class Rectangle implements Room {
	float height;
	float length;
	float width;
	List<Furniture> furniture;

	public Rectangle(float height, float length, float width) {

		this.height = height;
		this.length = length;
		this.width = width;
		this.furniture = new ArrayList<>();
	}

	@Override
	public float getArea() {
		return length * width;
	}

	@Override
	public float getPerimeter() {
		return 2 * (length + width);
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

	public void setHeight(float height) {
		this.height = height;
	}

	public float getLength() {
		return length;
	}

	public void setLength(float length) {
		this.length = length;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public void setFurniture(List<Furniture> furniture) {
		this.furniture = furniture;
	}

}

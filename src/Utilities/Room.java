package Utilities;
import java.util.List;

public interface Room {
	// Create an interface with the appropriate methods that all the room
	// related classes will implement
	float getArea();
	float getPerimeter();
	float getHeight();

	void addFurniture(Furniture furniture);
	List<Furniture> getFurniture();

}

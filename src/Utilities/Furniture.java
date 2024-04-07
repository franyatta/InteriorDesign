package Utilities;

public class Furniture {
	// Create data fields that apply to furniture
	String name;
	float cost;
	String description;
	float height;
	float width;
	float weight;
	
	public Furniture(String name, float cost, String description, float height,
			float width, float weight) {

		this.name = name;
		this.cost = cost;
		this.description = description;
		this.height = height;
		this.width = width;
		this.weight = weight;
	}
	
	// Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}
	
}

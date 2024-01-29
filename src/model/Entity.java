package model;

import java.awt.Dimension;
import java.awt.Point;

public abstract class Entity{
	private Dimension dim;
	private Point coordinates; //in pixel
	private int velocity;
	private int direction;
	protected int lifes;
	private boolean isMoving;
	protected boolean isAlive;
	
	public Entity(Dimension dim, Point coordinates, int velocity, int lifes) {
		this.dim=dim;
		this.coordinates=coordinates;
		this.velocity=velocity;
		this.lifes=lifes;
		isAlive = true;
	}
	
	public void move(int dx, int dy) {
		coordinates.x = coordinates.x + dx;
		coordinates.y = coordinates.y + dy;
	}

	public Dimension getDim() {
		return dim;
	}

	public Point getCoordinates() {
		return coordinates;
	}

	public int getVelocity() {
		return velocity;
	}

	public int getDirection() {
		return direction;
	}

	public int getLifes() {
		return lifes;
	}

	public boolean isMoving() {
		return isMoving;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setCoordinates(Point coordinates) {
		this.coordinates = coordinates;
	}

	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public void setLifes(int lifes) {
		this.lifes = lifes;
	}

	public void setMoving(boolean isMoving) {
		this.isMoving = isMoving;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
	
	
}

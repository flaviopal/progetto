package model;

import java.awt.Dimension;
import java.awt.Point;

public class Drone extends Enemy{
	
	
	
	public Drone(Dimension dim, Point coordinates) {
		super (dim, coordinates, 20, 1, 100);
	}

}

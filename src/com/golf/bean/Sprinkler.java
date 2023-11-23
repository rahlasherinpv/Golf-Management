package com.golf.bean;

public class Sprinkler {
private int sprinklerId;

public Sprinkler(int sprinklerId) {
	super();
	this.sprinklerId = sprinklerId;
}

public Sprinkler() {
	super();
	// TODO Auto-generated constructor stub
}

public int getSprinklerId() {
	return sprinklerId;
}

public void setSprinklerId(int sprinklerId) {
	this.sprinklerId = sprinklerId;
}

//method
public void activate(Sensor sensor) {
    System.out.println("Sprinkler " + sprinklerId + " activated for Sensor " );
    try {
        Thread.sleep(60000); // Sprinkler active for 1 minute
        sensor.setActive(false);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    System.out.println("Sprinkler " + sprinklerId + " deactivated for Sensor" );
}
}

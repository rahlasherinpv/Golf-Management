package com.golf.bean;

import java.util.Random;

public class Sensor extends Thread {
private int sensorId;
private Sprinkler sprinkler;
private boolean active=false;
private int moisture;

public Sensor()  {
	super();
}
public Sensor(int sensorId, Sprinkler sprinkler) {
	super();
	this.sensorId = sensorId;
	this.sprinkler = sprinkler;
}
public int getSensorId() {
	return sensorId;
}
public void setSensorId(int sensorId) {
	this.sensorId = sensorId;
}
public Sprinkler getSprinkler() {
	return sprinkler;
}
public void setSprinkler(Sprinkler sprinkler) {
	this.sprinkler = sprinkler;
}
public boolean isActive() {
	return active;
}
public void setActive(boolean active) {
	this.active = active;
}
public int getMoisture() {
	return moisture;
}
public void setMoisture(int moisture) {
	this.moisture = moisture;
}
@Override
public String toString() {
	return "Sensor [sensorId=" + sensorId + ", sprinkler=" + sprinkler + "]";
}

public void run(){
	while(true) {
		try {
			Thread.sleep(5000);
			checkMoisture();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}


private void checkMoisture() {
if(active==false) {
	moisture=new Random().nextInt(101);
	System.out.println("Soil moisture for Sensor " + sensorId + ": " + moisture + "%");
	 if (moisture < 10) {
		 active = true;
         sprinkler.activate(this);
         
	 }
}
	
}

}

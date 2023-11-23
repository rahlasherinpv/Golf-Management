package com.golf.lib;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import com.golf.bean.Sensor;
import com.golf.bean.Sprinkler;
public class SensorManagementService {
	static Logger logger = Logger.getLogger(SensorManagementService.class.getName());
	static List<Sensor> sensors;
	Sensor sensor;
	Sprinkler sprinkler;
	
	 public SensorManagementService () {
		super();
		sensors=new ArrayList<Sensor>();
		
		
		for (int i = 1; i <= 15; i++) {
			  sensor =new Sensor();
			  sprinkler = new Sprinkler();
			 sensor.setSensorId(i);
			 sprinkler.setSprinklerId(i);
			 sensor.setSprinkler(sprinkler);
			 sensors.add(sensor);
			 System.out.println(sensors);
			 
		}		
	}

	public static void main(String[] args){
		 
		 try {
			LogManager.getLogManager().readConfiguration(new FileInputStream("mylogging.properties"));
		} catch (SecurityException | IOException e) {
			e.printStackTrace();
		}
		 
		 logger.setLevel(Level.FINE);
		 logger.addHandler(new ConsoleHandler());
		 logger.addHandler(new MyHandler());
		 
		 //FileHandler file name with max size and number of log files limit
         Handler fileHandler;
		try {
			fileHandler = new FileHandler("logfile.log", 20000, 1);
			
			fileHandler.setFormatter(new MyFormatter());
		       //setting custom filter for FileHandler
		         fileHandler.setFilter(new MyFilter());
		         logger.addHandler(fileHandler);
		         
		         for (Sensor s:sensors) {
		        	 s.start();
		         }
		         
		        
//		         for(int i=0; i<100; i++){
//		             //logging messages
//		             logger.log(Level.INFO, "Msg"+i);
//		         }
		         
		         logger.log(Level.CONFIG, "Config data");
		} catch (SecurityException | IOException e) {
		
			e.printStackTrace();
		}
         
         
	 }
}

package com.myapp.snowpark.SnowParkApp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import com.myapp.snowpark.SnowParkApp.bean.Car;
import com.myapp.snowpark.SnowParkApp.bean.Engine;
import com.myapp.snowpark.SnowParkApp.bean.Tire;
import com.myapp.snowpark.SnowParkApp.util.RandomDateUtil;

import org.springframework.stereotype.Service;

@Service
public class RandomCarService implements CarService{

    @Override
	public Car generateCar() {
		
		var brand = BRANDS.get(ThreadLocalRandom.current().nextInt(0, BRANDS.size()));
		
		var color = COLORS.get(ThreadLocalRandom.current().nextInt(0, COLORS.size()));
		
		var type = TYPES.get(ThreadLocalRandom.current().nextInt(0, TYPES.size()));
		
		var available = ThreadLocalRandom.current().nextBoolean();
		
		var price = ThreadLocalRandom.current().nextInt(5000, 12001);
		
		var firstReleaseDate = RandomDateUtil.generateRandomLocalDate();
		
		int randomCount = ThreadLocalRandom.current().nextInt(ADDITIONAL_FEATURES.size());
		
		var additionalFeatures = new ArrayList<String>();
		
		for(int i=0; i<randomCount; i++) {
			additionalFeatures.add(ADDITIONAL_FEATURES.get(i));
		}
		
		var fuelType = FUELTYPE.get(ThreadLocalRandom.current().nextInt(0, FUELTYPE.size()));
		
		var horsePower = ThreadLocalRandom.current().nextInt(120, 241);
		
		var engine = new Engine(fuelType, horsePower);
		
		List<Tire> tires = new ArrayList<Tire>();
		for(int i=0; i<3; i++) {
			
			var tireManufacturer = TIRE_MANUFACTURER.get(ThreadLocalRandom.current().nextInt(TIRE_MANUFACTURER.size()));
			var tirePrice = ThreadLocalRandom.current().nextInt(200, 501);
			var size = ThreadLocalRandom.current().nextInt(15, 18);
			
			var tire = new Tire(tireManufacturer, size, tirePrice);
			
			tires.add(tire);
		}
		
		var result = new Car(brand, color, type);
		result.setAvailable(available);
		result.setPrice(price);
		result.setFirstReleaseDate(firstReleaseDate);
		result.setAdditionalFeatures(additionalFeatures);
		result.setEngine(engine);
		result.setTires(tires);
		
		return result;
		
	}

}

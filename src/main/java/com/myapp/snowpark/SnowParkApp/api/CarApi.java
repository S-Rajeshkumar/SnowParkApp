package com.myapp.snowpark.SnowParkApp.api;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import com.myapp.snowpark.SnowParkApp.bean.Car;
import com.myapp.snowpark.SnowParkApp.bean.SearchCondition;
import com.myapp.snowpark.SnowParkApp.common.JDBCWriter;
import com.myapp.snowpark.SnowParkApp.service.CarService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/cars")
public class CarApi {

    private static final Logger LOG = LoggerFactory.getLogger(CarApi.class);

    @Autowired
    private CarService carService;

    @GetMapping(value = "/generateRandomCars", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Car> generateRandomCars(){
		List<Car> randomCars = new ArrayList<Car>();
		for(int i=0; i<ThreadLocalRandom.current().nextInt(1, 10); i++) {
			randomCars.add(carService.generateCar());
		}
		// JDBCWriter jdbcWriter = new JDBCWriter();
		// String result = jdbcWriter.writeCarDataToSnowFlake(randomCars);
		// return result;
		return randomCars;
	}

    @GetMapping(value = "/random", produces = MediaType.APPLICATION_JSON_VALUE)
    public Car Random() {
		return carService.generateCar();	
	}

	@PostMapping(value = "/echo", produces = MediaType.APPLICATION_JSON_VALUE)
    public String echo(@RequestBody Car car) {
		LOG.info("Car is {}", car);
		return car.toString();
	}

	public List<Car> searchByTextField(@RequestBody SearchCondition searchCondition) {

		return null;
	}
}

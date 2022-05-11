package com.myapp.snowpark.SnowParkApp;

import java.io.File;
import java.io.FileNotFoundException;

import com.snowflake.snowpark_java.DataFrame;
import com.snowflake.snowpark_java.Functions;
import com.snowflake.snowpark_java.Session;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.ResourceUtils;

@SpringBootApplication
public class SnowParkAppApplication {

	public static void main(String[] args) throws FileNotFoundException {
		SpringApplication.run(SnowParkAppApplication.class, args);
		System.out.println("Hello World!!!");

		boolean TRUE = true;
		File file = ResourceUtils.getFile("classpath:snowflake.properties");
    	Session session = Session.builder().configFile(file.toString()).create();
    
		DataFrame dFrame1 = session.table("CARS.PARK.CAR");
		DataFrame dFrame2 = dFrame1.filter(Functions.col("AVAILABLE").equal_to(Functions.lit(TRUE)).and(Functions.col("TYPE").equal_to(Functions.lit("Sedan"))));
		DataFrame dFrame3 = dFrame2.select(Functions.col("ID"), Functions.col("COLOR"));
		dFrame3.show();

	}

}

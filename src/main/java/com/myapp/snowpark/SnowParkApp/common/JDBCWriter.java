package com.myapp.snowpark.SnowParkApp.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

import com.myapp.snowpark.SnowParkApp.bean.Car;

public class JDBCWriter {

    private static final String URL = "jdbc:snowflake://<account identifier>.snowflakecomputing.com";
    private static final String USERNAME = "<username>";
    private static final String PASSWORD = "<password>";

    public String writeCarDataToSnowFlake(List<Car> cars) {

        try {

            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            connection.setAutoCommit(false);
    
            String query = "INSERT INTO CARS.PARK.CAR VALUES (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt = connection.prepareStatement(query);
    
            for(Car car: cars) {
                pstmt.setString(1, car.getId());
                pstmt.setString(2, car.getBrand());
                pstmt.setString(3, car.getColor());
                pstmt.setString(4, car.getType());
                pstmt.setInt(5, car.getStartingPrice());
                pstmt.setInt(6, car.getEndingPrice());
                pstmt.setBoolean(7, car.isAvailable());
                pstmt.setString(8, car.getFirstReleaseDate().toString());
                
                // Getting Error for the below fields as FeatureNotSupported
                pstmt.setObject(9, car.getAdditionalFeatures());
                pstmt.setObject(10, car.getEngine());
                pstmt.setObject(11, car.getTires());
                pstmt.addBatch();   
            }
    
            int[] count = pstmt.executeBatch(); // After execution, count[0]=1, count[1]=1
            connection.commit();

        } catch(Exception e) {
            return "Error Occured While Writing Data to Snowflake";
        }

        return "Success";

    }

}

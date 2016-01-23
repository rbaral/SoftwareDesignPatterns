/**
 * this is an illustration of Builder pattern
 * ref:https://en.wikipedia.org/wiki/Builder_pattern
 */
package com.design.creational;

/**
 * this is the main object that we will build using the builder
 * @author rbaral
 *
 */
class Car{
	boolean hasGPS;
	boolean isTripComputer;
	int noOfSeats;
	String carType;
	//enum CARTYPE {CITY_CAR,SPRTS_CAR,CABRIOLET}
	public Car(CarBuilder builder){
		this.hasGPS = builder.hasGPS;
		this.isTripComputer = builder.isTripComputer;
		this.noOfSeats = builder.seats;
		this.carType = builder.carType;
	}
}

/**
 * this is the builder class that builds the Car class object
 * by using the attributes accumulated
 * @author rbaral
 *
 */
class CarBuilder{
	int seats;
	String carType;
	boolean hasGPS, isTripComputer;
	public CarBuilder(){}
	public Car getResult(){
		return new Car(this);
	}
	
	public CarBuilder setSeats(int seats){
		this.seats = seats;
		return this;
	}
	
	public CarBuilder setCityCar(){
		this.carType = "city";
		return this;
	}
	public CarBuilder setCabriolet(){
		this.carType = "cabriolet";
		return this;
	} 
	
	public CarBuilder setSportsCar(){
		this.carType = "sports";
		return this;
	}
	public CarBuilder setTripComputer(){
		this.isTripComputer = true;
		return this;
	}
	public CarBuilder unsetTripComputer(){
		this.isTripComputer = false;
		return this;
	}
	public CarBuilder setGPS(){
		this.hasGPS = true;
		return this;
	} 
	public CarBuilder unsetGPS(){
		this.hasGPS = false;
		return this;
	} 

    
}

/**
 * this is like the client module
 * @author rbaral
 *
 */
public class Builder {

	public static void main(String[] args) {
		//Construct a CarBuilder called carBuilder
		CarBuilder carBuilder = new CarBuilder();
		carBuilder.setSeats(2);
		carBuilder.setSportsCar();
		carBuilder.setTripComputer();
		carBuilder.unsetGPS();
		Car car = carBuilder.getResult();
		System.out.println(car.hasGPS);
	}
}

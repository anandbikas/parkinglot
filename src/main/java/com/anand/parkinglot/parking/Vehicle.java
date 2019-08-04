/**
 * @Author:     Bikas Anand,
 *              Sr. Software Engineer (SDE 3).
 *              Git: https://github.com/anandbikas
 *              LinkedIn: https://linkedin.com/in/anand-iitr-mca/
 *              Alma Mater: Indian Institute of Technology, Roorkee.
 */
package com.anand.parkinglot.parking;

import com.anand.parkinglot.exception.InvalidVehicleColorException;
import com.anand.parkinglot.exception.InvalidVehicleRegistrationException;
import com.anand.parkinglot.utils.Validation;

import java.util.Objects;

/**
 * Car class for parking lot.
 */
public class Vehicle {

    private String registrationNumber;
    private Colour color;

    /**
     * Constructor
     *
     * @param registrationNumber
     * @param colour
     */
    public Vehicle(String registrationNumber, String colour) {

        this.registrationNumber = registrationNumber;
        if(!Validation.isValidRegistrationNumber(registrationNumber)){
            throw new InvalidVehicleRegistrationException(
                    String.format("Vehicle registration number: %s, invalid", registrationNumber));
        }

        this.color = Colour.fromValue(colour);
        if(color==null){
            throw new InvalidVehicleColorException(String.format("Vehicle color: %s, invalid", colour));
        }
    }

    /**
     *
     * @return
     */
    public Colour getColor() {
        return color;
    }

    /**
     *
     * @param color
     */
    public void setColor(Colour color) {
        this.color = color;
    }

    /**
     *
     * @return
     */
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    /**
     *
     * @param registrationNumber
     */
    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    /**
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(registrationNumber, vehicle.registrationNumber) &&
                color == vehicle.color;
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return "Vehicle{" +
                "registrationNumber='" + registrationNumber + '\'' +
                ", color=" + color +
                '}';
    }
}

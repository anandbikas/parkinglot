/**
 * @Author:     Bikas Anand,
 *              Sr. Software Engineer (SDE 3).
 *              Git: https://github.com/anandbikas
 *              LinkedIn: https://linkedin.com/in/anand-iitr-mca/
 *              Alma Mater: Indian Institute of Technology, Roorkee.
 */
package com.anand.parkinglot.parking;

import com.anand.heap.BinaryMinHeap;
import com.anand.parkinglot.exception.DuplicateVehicleException;
import com.anand.parkinglot.exception.ParkingFullException;
import com.anand.parkinglot.exception.ParkingSlotOutOfBoundException;
import com.anand.parkinglot.exception.VehicleNotFoundException;
import com.anand.trie.TrieDictionary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ParkingLot
 */
public class ParkingLot {

    private Vehicle[] vehicleSlots;
    private int size;

    private BinaryMinHeap<Integer> emptySlotPool;

    //TODO: colour-> list map: list can be expensive for delete operation, Optimization?
    private Map<Colour, List<Integer>> colorVehicleSlotMap = new HashMap<>();

    private TrieDictionary registrationDictionary = new TrieDictionary();

    /**
     *
     * @param size
     */
    public ParkingLot(int size){
        this.size = size;
        this.vehicleSlots = new Vehicle[size+1];

        //Populate empty slot pool using BinaryMinHeap
        emptySlotPool = new BinaryMinHeap<>(size);
        for(int i= 1; i<=size; i++){
            emptySlotPool.insert(i);
        }
    }

    /**
     *
     * @return
     */
    public int getVehicleCount() {
        return size-emptySlotPool.getSize();
    }

    /**
     *
     * @param slotNumber
     * @return
     */
    public Vehicle getVehicle(int slotNumber){
        if(slotNumber<1 || slotNumber > size){
            return null;
        }

        return vehicleSlots[slotNumber];
    }

    /**
     * Synchronized park method, to avoid corruption of vehicleSlots, count, nearestEmptySlotNumber
     *
     * @param vehicle
     * @return
     */
    public synchronized Integer park(Vehicle vehicle){

        if(vehicle == null){
            throw new IllegalArgumentException("Vehicle object is null");
        }

        if(emptySlotPool.isEmpty()){
            throw new ParkingFullException("Sorry, parking lot is full");
        }

        // Duplicate registration_number should be rejected.
        Integer existingVehicleSlot = registrationDictionary.search(vehicle.getRegistrationNumber());
        if(existingVehicleSlot!=null){
            throw new DuplicateVehicleException(
                    String.format("Vehicle with registration no: %s already parked, duplicate request rejected",
                            vehicle.getRegistrationNumber()));
        }

        int allottedSlot = emptySlotPool.extractMin();

        // Park the vehicle
        vehicleSlots[allottedSlot] = vehicle;

        // To support O(1) search result for color lookup command, maintain a colorVehicle map
        // 1. registration_numbers_for_cars_with_colour
        // 2. slot_numbers_for_cars_with_colour
        colorVehicleSlotMap.computeIfAbsent(vehicle.getColor(), k->new ArrayList<>());
        colorVehicleSlotMap.get(vehicle.getColor()).add(allottedSlot);

        // To support O(1) search result for registration lookup command, maintain a registrationDictionary
        // 1. slot_number_for_registration_number
        registrationDictionary.insert(vehicle.getRegistrationNumber(), allottedSlot);

        return allottedSlot;
    }

    /**
     * Synchronized leave method, to avoid corruption of vehicleSlots, count, nearestEmptySlotNumber
     *
     * @param slotNumber
     */
    public synchronized Vehicle leave(Integer slotNumber){
        if(slotNumber<1 || slotNumber>size){
            throw new ParkingSlotOutOfBoundException(String.format("Parking slot: %s not found", slotNumber));
        }

        if(vehicleSlots[slotNumber]==null){
            throw new VehicleNotFoundException(String.format("Parking slot: %s has no vehicle", slotNumber));
        }

        Vehicle leavingVehicle = vehicleSlots[slotNumber];
        vehicleSlots[slotNumber] = null;

        colorVehicleSlotMap.get(leavingVehicle.getColor()).remove(slotNumber);
        registrationDictionary.delete(leavingVehicle.getRegistrationNumber());

        emptySlotPool.insert(slotNumber);

        return leavingVehicle;
    }

    /**
     * print parking status report
     *
     */
    public void status(){
        System.out.println("Slot No.    Registration No    Colour");
        if(vehicleSlots == null){
            return;
        }

        Vehicle vehicle;
        for(int i=1; i<=size; i++){
            vehicle = vehicleSlots[i];
            if(vehicle==null){
                continue;
            }
            System.out.println(String.format("%-11d %-18s %s", i, vehicle.getRegistrationNumber(), vehicle.getColor()));
        }
    }

    /**
     *
     * @return
     */
    public void displayEmptySlots(){
        emptySlotPool.display();
    }

    /**
     * return list of vehicles with a particular color
     *
     * @param colour
     * @return
     */
    public List<Integer> getVehiclesOfColor(final Colour colour){
        return colorVehicleSlotMap.get(colour);
    }

    /**
     *
     * @param registrationNumber
     * @return
     */
    public Integer getSlotNumberForRegistrationNumber(final String registrationNumber){
        return registrationDictionary.search(registrationNumber);
    }
}

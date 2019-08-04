## ParkingLot System
Parking Lot system project is designed to manage and operate a parking space.


###Supported Commands
- create_parking_lot <slot_count>
- park <registration_number> <color>
- leave <slot_number>
- status
- registration_numbers_for_cars_with_colour <color>
- slot_numbers_for_cars_with_colour <color>
- slot_number_for_registration_number <registration_number>
- exit


###Project Compilation
- **Compile/test:** 
    ```bash
    ./bin/setup
    ```

###Mode of Operations
- Batch Mode:
    - Run the parking_lot command and enter the operation command through terminal.
    ```bash 
    ./bin/parking_lot
    create_parking_lot 5
    park KA-01-HH-1234 White
    park KA-01-HH-3141 Black
    leave 4
    status
    park KA-01-P-333 White
    registration_numbers_for_cars_with_colour White
    slot_numbers_for_cars_with_colour White
    slot_number_for_registration_number KA-01-HH-3141
    exit
    ```
- Interactive Mode:
    - Collect the commands in a file input.txt and run the the command
    ```bash 
    ./bin/parking_lot input.txt
    ```

####Author:
- Bikas Anand<br>
Sr. Software Engineer (SDE 3)<br>
Git: https://github.com/anandbikas<br>
LinkedIn: https://linkedin.com/in/anand-iitr-mca<br>
Alma Mater: Indian Institute of Technology, Roorkee.<br>
 
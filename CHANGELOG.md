###CHANGELOG
- Add author signature.

- Optimize nearestEmptySlot calculation by maintaining emptySlotPool using binaryMinHeap.

- BinaryMinHeap, can be used as empty slots pool to support O(log n) nearestEmptySlot calculation.

- Fix EXIT condition.

- setup and parking_lot bin scripts to compile and run the parkingLot program.

- ExtendedByteArrayOutputStream custom ByteArrayOutputStream class to add getBuf method.

- Main class test with input file input.txt and output file output.txt.

- Main class to run the parkingLot program either in terminal mode or batch processing mode with input file.

- ParkingProcessor class to maintain a parking_lot and execute parking related commands like create_parking_lot, park, leave, status, exit etc.

- ParkingLot class with parking slots and methods like park, leave, lot status, getVehiclesOfColor, getSlotNumberForRegistrationNumber methods.

- Vehicle and Color class with invalid color and registration exception.

- ParkingLot command enumeration.

- Vehicle Registration number regex validation.

- TrieDictionary: To maintain dictionary of vehicle_registration_number -> parking_slot_number for O(1) vehicle registration lookup.

- ParkingLot Maven Project.

- Initial commit.
package com.anand.parkinglot.command;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Command Enumeration
 */
public enum Command {

    CREATE_PARKING_LOT("create_parking_lot",
            "create_parking_lot <slot_count>"),
    PARK("park",
            "park <registration_number> <color>"),
    LEAVE("leave",
            "leave <slot_number>"),
    STATUS("status",
            "status"),
    REGISTRATION_NUMBERS_FOR_CARS_WITH_COLOR(
            "registration_numbers_for_cars_with_colour",
            "registration_numbers_for_cars_with_colour <color>"),
    SLOT_NUMBERS_FOR_CARS_WITH_COLOUR(
            "slot_numbers_for_cars_with_colour",
            "slot_numbers_for_cars_with_colour <color>"),
    SLOT_NUMBER_FOR_REGISTRATION_NUMBER(
            "slot_number_for_registration_number",
            "slot_number_for_registration_number <registration_number>"),
    EXIT("exit",
            "exit");


    private final String command;
    private final String description;

    /**
     *
     * @param command
     */
    private Command(final String command, final String description) {
        this.command = command;
        this.description = description;
    }

    private static final Map<String, Command> COMMAND_MAP = new LinkedHashMap<>();
    static {
        for (final Command type : Command.values()) {
            COMMAND_MAP.put(type.command, type);
        }
    }

    /**
     * String value to command type.
     *
     * Case insensitive.
     *
     * @param value the command type value to specify the type.
     * @return command
     */
    public static Command fromValue(final String value) {
        if(value == null){
            return null;
        }
        return COMMAND_MAP.get(value.toLowerCase());
    }

    /**
     *
     * @return
     */
    public String getValue() {
        return command;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return command;
    }

    /**
     *
     */
    public static void display(){
        for(String command: COMMAND_MAP.keySet()) {
            System.out.println(COMMAND_MAP.get(command).description);
        }
    }
}

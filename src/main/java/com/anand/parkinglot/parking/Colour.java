package com.anand.parkinglot.parking;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Color Enumeration
 */
public enum Colour {
    RED("Red"),
    GREEN("Green"),
    BLUE("Blue"),
    YELLOW("Yellow"),
    WHITE("White"),
    GRAY("Gray"),
    BLACK("Black"),
    SILVER("Silver");

    private final String color;

    /**
     *
     * @param color
     */
    private Colour(final String color) {
        this.color = color;
    }

    private static final Map<String, Colour> COLOR_MAP = new LinkedHashMap<>();
    static {
        for (final Colour type : Colour.values()) {
            COLOR_MAP.put(type.color.toLowerCase(), type);
        }
    }

    /**
     * String value to color type.
     *
     * @param value the color type value to specify the type.
     * @return Color
     */
    public static Colour fromValue(final String value) {
        if(value == null){
            return null;
        }
        return COLOR_MAP.get(value.toLowerCase());
    }

    /**
     *
     * @return
     */
    public String getValue() {
        return color;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return color;
    }
}

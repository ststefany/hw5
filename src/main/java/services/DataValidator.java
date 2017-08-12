package services;

import models.ElectricalAppliance;

import java.util.List;

public class DataValidator {

    public static void check(String s) {
        if (s == null || s.isEmpty())
            throw new IllegalArgumentException("String doesn't consict any data");
    }

    public static void check(List<ElectricalAppliance> listOfDevicesInARoom) {
        if (listOfDevicesInARoom == null || listOfDevicesInARoom.isEmpty()) {
            throw new IllegalArgumentException("There's nothing in the list of devices in the room");
        }
    }


}

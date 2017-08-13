package services;

import exceptions.EmptyArgumentException;
import models.ElectricalAppliance;
import exceptions.InvalidArgumentException;

import java.util.List;


public class DataValidator {

    public static void check(String s) throws EmptyArgumentException {
        if (s == null) {
            throw new InvalidArgumentException("Provided string doesn't consist any data");
        }
        if (s.isEmpty()) {
            throw new EmptyArgumentException();
        }
    }

    public static void check(List<ElectricalAppliance> listOfDevicesInARoom) throws EmptyArgumentException {
        if (listOfDevicesInARoom == null) {
            throw new InvalidArgumentException("There's nothing in the list of devices in the room");
        }
        if (listOfDevicesInARoom.isEmpty()) {
            throw new EmptyArgumentException();
        }

    }


}

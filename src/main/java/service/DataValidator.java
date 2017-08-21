package service;

import exception.DeviceNotFoundException;
import exception.EmptyArgumentException;
import model.ElectricalAppliance;
import exception.InvalidArgumentException;

import java.util.List;


public class DataValidator {

    public static void isNullOrEmpty(String s) throws EmptyArgumentException {
        if (s == null) {
            throw new InvalidArgumentException("Provided string doesn't consist any data");
        }
        if (s.isEmpty()) {
            throw new EmptyArgumentException();
        }
    }

    public static void isNullOrEmpty(List<ElectricalAppliance> listOfDevicesInARoom) throws EmptyArgumentException {
        if (listOfDevicesInARoom == null) {
            throw new InvalidArgumentException("There's nothing in the list of devices in the room");
        }
        if (listOfDevicesInARoom.isEmpty()) {
            throw new EmptyArgumentException();
        }
    }

    public static void isNullOrEmpty(ElectricalAppliance device) throws DeviceNotFoundException {
        if (device == null) {
            throw new DeviceNotFoundException("Device doesn't exist");
        }
    }


    public static void checkMinMax(int min, int max) {
        if (min < 0 || max < 0) {
            throw new InvalidArgumentException("Minimum and maximum values must be more than 0");
        }
        if (min > max) {
            throw new InvalidArgumentException("Minimum value cannot be more than maximum one");
        }
    }
}

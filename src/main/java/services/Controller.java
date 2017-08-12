package services;

import models.ElectricalAppliance;

import java.security.InvalidParameterException;
import java.util.List;

public class Controller {
    private List<ElectricalAppliance> listOfDevicesInARoom;
    private Service service;

    public Controller(String dataresource) {
        listOfDevicesInARoom = new Initializer(dataresource).initialize();
        service = new Service();
        DataValidator.check(listOfDevicesInARoom);
    }


    public int getCurrentPower() {
        return service.getCurrentPower(listOfDevicesInARoom);
    }

    public List<ElectricalAppliance> sortMinToMaxPower() {
        return service.sort(listOfDevicesInARoom);
    }

    public List<ElectricalAppliance> findDeviceBasedOnParameters(int minPower, int maxPower) {
        return service.findDeviceBasedOnParameters(minPower, maxPower, listOfDevicesInARoom);
    }

    public void switchOn(ElectricalAppliance device) {
        if (isInTheRoom(device))
            service.switchOn(device);
        else throw new InvalidParameterException("There is no such device in the room");
    }

    public void switchOff(ElectricalAppliance device) {
        if (isInTheRoom(device))
            service.switchOff(device);
        else throw new InvalidParameterException("There is no such device in the room");
    }


    public boolean isInTheRoom(ElectricalAppliance device) {
        for (ElectricalAppliance e : listOfDevicesInARoom)
            if (e.equals(device)) return true;
        return false;
    }

    public ElectricalAppliance findDevicebyName(String name) {
        DataValidator.check(name);
        for (ElectricalAppliance e : listOfDevicesInARoom)
            if (e.getName().equals(name))
                return e;
        throw new InvalidParameterException("No device witn " + name + " name");
    }

}

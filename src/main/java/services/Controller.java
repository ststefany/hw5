package services;

import exceptions.EmptyArgumentException;
import exceptions.InvalidDeviceException;
import models.ElectricalAppliance;

import java.util.List;

public class Controller {
    private List<ElectricalAppliance> listOfDevicesInARoom;
    private Service service;

    public Controller() {
    }

    public Controller initController(String dataResource) {
        listOfDevicesInARoom = new Initializer(dataResource).initialize();
        service = new Service();
        try {
            DataValidator.check(listOfDevicesInARoom);
        } catch (EmptyArgumentException e) {
            System.out.println("There are no devices in the room. All your next actions will be pointless");
        }
        return this;
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
        if (isInTheRoom(device)) {
            service.switchOn(device);
        } else System.err.println("There is no such device in the room");
    }

    public void switchOff(ElectricalAppliance device) {
        if (isInTheRoom(device))
            service.switchOff(device);
        else System.err.println("There is no such device in the room");
    }


    private boolean isInTheRoom(ElectricalAppliance device) {
        if (device == null) {
            return false;
        }
        for (ElectricalAppliance e : listOfDevicesInARoom)
            if (e.equals(device)) return true;
        return false;
    }

    public ElectricalAppliance findDeviceByName(String name) {
        try {
            DataValidator.check(name);
        } catch (EmptyArgumentException e) {
            System.out.println("There are no devices in the room");
            return null;
        }
        for (ElectricalAppliance e : listOfDevicesInARoom) {
            if (e.getName().equals(name)) {
                return e;
            }
        }
        return null;
    }
}

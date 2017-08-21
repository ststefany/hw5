package services;

import daos.DAO;
import exceptions.DeviceNotFoundException;
import models.ElectricalAppliance;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Service {
    private List<ElectricalAppliance> listOfDevicesInARoom = DAO.getDAO().getData();


    public final void switchOn(ElectricalAppliance e) {
        if (!e.isTurnedOn()) {
            e.switchOn();
        }
        System.out.println(e.toString() + " is switched on");
    }

    public final void switchOff(ElectricalAppliance e) {
        if (e.isTurnedOn()) {
            e.switchOff();
        }
        System.out.println(e.toString() + " is switched off");
    }

    public final int getCurrentPower() {
        int result = 0;
        for (ElectricalAppliance device : listOfDevicesInARoom) {
            result += device.getCurrentPower();
        }
        return result;
    }

    public List<ElectricalAppliance> sort() {
        listOfDevicesInARoom.sort(Comparator.comparing(ElectricalAppliance::getPower));
        return listOfDevicesInARoom;
    }

    public List<ElectricalAppliance> findDeviceBasedOnParameters(int minPower, int maxPower) {
        List<ElectricalAppliance> matchingDevices = listOfDevicesInARoom.stream()
                .filter((ElectricalAppliance e) -> e.getPower() <= maxPower && e.getPower() >= minPower)
                .collect(Collectors.toList());
        return matchingDevices;
    }

    public ElectricalAppliance findDeviceByName(String name) throws DeviceNotFoundException {
        for (ElectricalAppliance e : listOfDevicesInARoom) {
            if (e.getName().equals(name)) {
                return e;
            }
        }
        throw new DeviceNotFoundException("Device not found");
    }

    public boolean isInTheRoom(ElectricalAppliance device) {
        for (ElectricalAppliance e : listOfDevicesInARoom)
            if (e.equals(device)) {
                return true;
            }
        return false;

    }
}

package services;

import models.ElectricalAppliance;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Service {

    final void switchOn(ElectricalAppliance e) {
        if (!e.isTurnedOn())
            e.switchOn();
        System.out.println(e.toString() + " is switched on");
    }

    final void switchOff(ElectricalAppliance e) {
        if (e.isTurnedOn())
            e.switchOff();
        System.out.println(this.toString() + " is switched off");
    }

    final int getCurrentPower(List<ElectricalAppliance> listOfDevicesInTheRoom) {
        int result = 0;
        for (ElectricalAppliance device : listOfDevicesInTheRoom)
            result += device.getCurrentPower();
        return result;
    }

    List<ElectricalAppliance> sort(List<ElectricalAppliance> listOfDevicesInTheRoom) {
        listOfDevicesInTheRoom.sort(Comparator.comparing(ElectricalAppliance::getPower));
        return listOfDevicesInTheRoom;
    }

    List<ElectricalAppliance> findDeviceBasedOnParameters(int minPower, int maxPower, List<ElectricalAppliance> listOfDevicesInTheRoom) {
        List<ElectricalAppliance> matchingDevices = listOfDevicesInTheRoom.stream()
                .filter((ElectricalAppliance e) -> e.getPower() <= maxPower && e.getPower() >= minPower)
                .collect(Collectors.toList());
        return matchingDevices;
    }


}

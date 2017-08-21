package controller;

import exception.DeviceNotFoundException;
import exception.EmptyArgumentException;
import exception.InvalidArgumentException;
import model.ElectricalAppliance;
import service.DataValidator;
import service.Initializer;
import service.Service;
import java.util.List;

public class Controller {
    private Service service = new Service();

    private Controller() {
    }

    public static Controller createController(String dataResource) {
        new Initializer(dataResource).initialize();
        return new Controller();
    }

    public int getCurrentPower() {
        return service.getCurrentPower();
    }

    public List<ElectricalAppliance> sortMinToMaxPower() {
        return service.sort();
    }

    public List<ElectricalAppliance> findDeviceBasedOnParameters(int minPower, int maxPower) {
        DataValidator.checkMinMax(minPower, maxPower);
        return service.findDeviceBasedOnParameters(minPower, maxPower);
    }

    public void switchOn(ElectricalAppliance device) {

        if (isInTheRoom(device)) {
            service.switchOn(device);
        } else {
            System.err.println("There is no such device in the room");
        }
    }

    public void switchOff(ElectricalAppliance device) {
        if (isInTheRoom(device)) {
            service.switchOff(device);
        } else {
            System.err.println("There is no such device in the room");
        }
    }


    public ElectricalAppliance findDeviceByName(String name) {
        try {
            DataValidator.isNullOrEmpty(name);
        } catch (EmptyArgumentException | InvalidArgumentException e) {
            System.err.println(e.getMessage());
            return null;
        }

        try {
            return service.findDeviceByName(name);
        } catch (DeviceNotFoundException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    private boolean isInTheRoom(ElectricalAppliance device) {
        try {
            DataValidator.isNullOrEmpty(device);
        } catch (DeviceNotFoundException e) {
            System.err.println(e.getMessage());
            return false;
        }
        return service.isInTheRoom(device);
    }

}

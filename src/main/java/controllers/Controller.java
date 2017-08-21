package controllers;

import daos.DAO;
import exceptions.DeviceNotFoundException;
import exceptions.EmptyArgumentException;
import exceptions.InvalidArgumentException;
import models.ElectricalAppliance;
import services.DataValidator;
import services.Initializer;
import services.Service;

import java.util.List;

public class Controller {
    private Service service = new Service();

    private Controller() {
        try {
            DataValidator.check(DAO.getDAO().getData());
        } catch (EmptyArgumentException e) {
            System.err.println("There are no devices in the room. All your next actions will be useless. Please, use" +
                    "different data source");
        }
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
            DataValidator.check(name);
        } catch (EmptyArgumentException | InvalidArgumentException e) {
            e.getMessage();
            return null;
        }

        try {
            return service.findDeviceByName(name);
        } catch (DeviceNotFoundException e) {
            e.getMessage();
            return null;
        }
    }

    private boolean isInTheRoom(ElectricalAppliance device) {
        try {
            DataValidator.check(device);
        } catch (DeviceNotFoundException e) {
            e.getMessage();
            return false;
        }
        return service.isInTheRoom(device);
    }

}

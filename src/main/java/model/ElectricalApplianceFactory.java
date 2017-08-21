package model;

import exception.ApplianceCreationException;
import exception.EmptyArgumentException;
import service.DataValidator;
import service.ElectricalApplianceTypes;

import java.security.InvalidParameterException;

public class ElectricalApplianceFactory {
    private static final int TYPE = 0;
    private static final int NAME = 1;
    private static final int POWER = 2;


    public ElectricalAppliance create(String[] params) throws ApplianceCreationException {
        try {
            for (String i : params) {
                DataValidator.isNullOrEmpty((i));
            }
        } catch (EmptyArgumentException e) {
            throw new ApplianceCreationException("Impossible to create an Electrical Appliance with given data");
        }

        String name = getName(params);
        int power = getPower(params);

        switch (getType(params)) {
            case BLENDER:
                return new Blender(name, power);
            case COMPUTER:
                return new Computer(name, power);
            case FAN:
                return new Fan(name, power);
            case FRIDGE:
                return new Fridge(name, power);
            case HOOVER:
                return new Hoover(name, power);
            case IRON:
                return new Iron(name, power);
            case MICROWAVEOVEN:
                return new MicrowaveOven(name, power);
            case STOVE:
                return new Stove(name, power);
            case TV:
                return new TV(name, power);
            case WASHER:
                return new Washer(name, power);

        }
        throw new ApplianceCreationException("Impossible to create an Electrical Appliance with given data");
    }

    private ElectricalApplianceTypes getType(String[] params) {
        return ElectricalApplianceTypes.valueOf(params[TYPE].trim());
    }

    private String getName(String[] params) {
        return params[NAME].trim();
    }

    private int getPower(String[] params) throws ApplianceCreationException {
        int power = -1;
        try {
            power = Integer.parseInt(params[POWER].trim());
        } catch (NumberFormatException e) {
            throw new ApplianceCreationException("Invalid value of power");
        }
        if (power < 0) {
            throw new InvalidParameterException();
        }
        return power;
    }


}

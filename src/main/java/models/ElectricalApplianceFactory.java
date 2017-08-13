package models;

import exceptions.EmptyArgumentException;
import services.DataValidator;
import services.ElectricalApplianceTypes;

import java.security.InvalidParameterException;

public class ElectricalApplianceFactory {
    private static final int TYPE = 0;
    private static final int NAME = 1;
    private static final int POWER = 2;


    public ElectricalAppliance create(String[] params) {
        try {
            for (String i : params) {
                DataValidator.check((i));
            }
        } catch (EmptyArgumentException e) {
            //here is a good place to throw a checked exception. And handle this exception.
            System.err.println("Any of parameters cannot be empty");
            return null;
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
            default:
                return null;
        }
    }

    private ElectricalApplianceTypes getType(String[] params) {
        return ElectricalApplianceTypes.valueOf(params[TYPE].trim());
    }

    private String getName(String[] params) {
        return params[NAME].trim();
    }

    private int getPower(String[] params) {
        int power = Integer.parseInt(params[POWER].trim());
        if (power < 0) throw new InvalidParameterException();
        return power;
    }


}

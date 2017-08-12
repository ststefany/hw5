package services;

import models.ElectricalAppliance;
import models.ElectricalApplianceFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Initializer {
    private String resourceName;

    Initializer(String resourceName) {
        this.resourceName = resourceName;
    }

    List<ElectricalAppliance> initialize() {
        ElectricalApplianceFactory factory = new ElectricalApplianceFactory();
        List<String[]> list = getDataFromSource();
        List<ElectricalAppliance> listOfDevicesInTheRoom = new ArrayList<>();

        for (String[] i : list) {
            listOfDevicesInTheRoom.add(factory.create(i));
        }
        return listOfDevicesInTheRoom;
    }


    private List<String[]> getDataFromSource() {
        List<String[]> list = new ArrayList<>();
        try (FileReader freader = new FileReader(resourceName)) {
            BufferedReader reader = new BufferedReader(freader);
            String line = reader.readLine();
            while (line != null) {
                list.add(line.split(","));
                line = reader.readLine();
            }
        }
        catch (IOException e) {
            System.err.println("I/O exception occurred");
            e.printStackTrace();
        }
        return list;
    }


}

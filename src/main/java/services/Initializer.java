package services;

import exceptions.FileValidateException;
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
        try (FileReader fReader = new FileReader(resourceName)) {
            BufferedReader reader = new BufferedReader(fReader);
            String line = reader.readLine();
            while (line != null) {
                list.add(line.split(","));
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new FileValidateException();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }


}

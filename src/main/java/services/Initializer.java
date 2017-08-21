package services;

import daos.DAO;
import exceptions.ApplianceCreationException;
import exceptions.EmptyArgumentException;
import exceptions.FileValidateException;
import models.ElectricalAppliance;
import models.ElectricalApplianceFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Initializer {
    private String resourceName;

    public Initializer(String resourceName) {
        this.resourceName = resourceName;
    }

    public List<ElectricalAppliance> initialize() {
        List<ElectricalAppliance> listOfDevicesInTheRoom = new ArrayList<>();

        try {
            DataValidator.check(resourceName);
        } catch (EmptyArgumentException e) {
            DAO.getDAO().update(listOfDevicesInTheRoom);
            return listOfDevicesInTheRoom;
        }

        int countOfSkipped = 0;

        ElectricalApplianceFactory factory = new ElectricalApplianceFactory();
        List<String[]> list = getDataFromSource();

        for (String[] i : list) {
            try {
                listOfDevicesInTheRoom.add(factory.create(i));
            } catch (ApplianceCreationException e) {
                e.getMessage();
                countOfSkipped++;
            }
        }

        System.out.println(countOfSkipped + " lines of " + resourceName + " was(were) skipped");

        DAO.getDAO().update(listOfDevicesInTheRoom);

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
            throw new FileValidateException("File can't be found");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }


}

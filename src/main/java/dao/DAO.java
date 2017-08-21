package dao;

import model.ElectricalAppliance;

import java.util.List;

public class DAO {
    private static List<ElectricalAppliance> listOfDevicesInARoom;
    private static final DAO dao = new DAO();

    private DAO() {
    }

    public static DAO getDAO() {
        return dao;
    }

    public List<ElectricalAppliance> getData() {
        return listOfDevicesInARoom;
    }

    public void update(List<ElectricalAppliance> list) {
        listOfDevicesInARoom = list;
    }
}

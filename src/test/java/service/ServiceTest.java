package service;

import exception.DeviceNotFoundException;
import model.ElectricalAppliance;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;


public class ServiceTest {
    static final String VALID_DATA = "src/test/resources/ValidDataExample.csv";

    @Before
    public void init() {
        new Initializer(VALID_DATA).initialize();
    }

    @Test(expected = DeviceNotFoundException.class)
    public void testThrowsDeviceNotFoundExceptionIfDeviceIsNotInTheList() throws DeviceNotFoundException {
        new Service().findDeviceByName(" ");
    }

    @Test
    public void testCurrentPowerIs0WhenAllDevicesAreOff() {
        Assert.assertTrue(new Service().getCurrentPower() == 0);
    }


    @Test
    public void testSortReturnsListWhereFirstElementPowerIsLessThanLast() {
        List<ElectricalAppliance> list = new Service().sort();
        Assert.assertTrue(list.get(0).getPower() < list.get(list.size() - 1).getPower());
    }
}

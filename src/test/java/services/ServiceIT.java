package services;

import models.ElectricalAppliance;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ServiceIT {

    @Before
    public void init(){

    }

    @Test
    public void testDeviceIsTurnedOffAfterSwitchOff() {
        Controller controller = new Controller("src/test/resources/ValidDataExample.csv");
        ElectricalAppliance e = controller.findDevicebyName("CatAlwaysGetsInsideWasher");
        controller.switchOff(e);
        Assert.assertFalse(e.isTurnedOn());
    }

    @Test
    public void testDeviceIsTurnedOnAfterSwitchOn() {
        Controller controller = new Controller("src/test/resources/ValidDataExample.csv");
        ElectricalAppliance e = controller.findDevicebyName("CatAlwaysGetsInsideWasher");
        controller.switchOff(e);
        Assert.assertTrue(e.isTurnedOn());
    }


}
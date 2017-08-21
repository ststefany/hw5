package models;

import exceptions.ApplianceCreationException;
import org.junit.Assert;
import org.junit.Test;

public class ElectricalApplianceFactoryTest {

    @Test
    public void testCreatesValidObjectFromValidParams() throws ApplianceCreationException {
        ElectricalApplianceFactory factory = new ElectricalApplianceFactory();
        ElectricalAppliance e = factory.create(new String[]{" FRIDGE ","name ", " 100"});
        Assert.assertTrue(e.getPower()==100);
        Assert.assertTrue(e.getName().equals("name"));
        Assert.assertTrue(e instanceof Fridge);
    }

}
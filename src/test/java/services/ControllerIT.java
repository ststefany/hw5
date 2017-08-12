package services;

import org.junit.Assert;
import org.junit.Test;

public class ControllerIT {
    @Test
    public void testGetCurrentPower() {
    }

    @Test(expected = IllegalArgumentException.class)
    public void testControllerFailsToBeCreatedIfDataSourceIsEmpty() {
       Controller controller = new Controller("src/test/resources/Empty.csv");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testControllerFailsToBeCreatedIfDataSourceDoesntExist(){
        Controller controller = new Controller(" ");
    }

    public void testControllerCanBeCreatedWithValidData(){
        Controller controller = new Controller("src/test/resources/ValidDataExample.csv");
        Assert.assertNotNull(controller);
    }

}
package controllers;

import exceptions.FileValidateException;
import exceptions.InvalidArgumentException;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;

public class ControllerTest {

    @Test(expected = FileValidateException.class)
    public void testControllerFailsToBeCreatedIfDataSourceDoesntExist() {
        Controller.createController(" ");
    }

    @Test
    public void testControllerCanBeCreatedWithValidData() {
        Controller controller = Controller.createController("src/test/resources/ValidDataExample.csv");
        Assert.assertNotNull(controller);
    }


}
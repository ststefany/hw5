package application;

import exceptions.InvalidArgumentException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import services.Controller;

import java.io.FileNotFoundException;

public class MainTest {
    private Main main;

    @Before
    public void mainInitialize() {
        this.main = new Main();
    }

    @Test(expected = InvalidArgumentException.class)
    public void testControllerFailsToBeCreatedIfDataSourceIsEmpty() {
        main.createController("src/test/resources/Empty.csv");
    }

    @Test(expected = FileNotFoundException.class)
    public void testControllerFailsToBeCreatedIfDataSourceDoesntExist() {
        main.createController(" ");
    }

    @Test
    public void testControllerCanBeCreatedWithValidData() {
        Controller controller = main.createController("src/test/resources/ValidDataExample.csv");
        Assert.assertNotNull(controller);
    }
}
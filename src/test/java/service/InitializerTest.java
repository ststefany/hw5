package service;

import exception.FileValidateException;
import model.ElectricalAppliance;
import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class InitializerTest {
    private static final String VALID_DATA = "src/test/resources/ValidDataExample.csv";
    private static final String EMPTY_DATA = "src/test/resources/Empty.csv";
    private static final String NOT_VALID = "src/test/resources/NoFile";


    @Test
    public void testCreatedListIsEmptyIfDataSourceIsEmpty() {
        Initializer initializer = new Initializer(EMPTY_DATA);
        Assert.assertTrue(initializer.initialize().isEmpty());
    }

    @Test
    public void testCreatedListIsEmptyIfArgumentIsEmpty() {
        Initializer initializer = new Initializer("");
        Assert.assertTrue(initializer.initialize().isEmpty());
    }


    @Test(expected = FileValidateException.class)
    public void testFileValidateExceptionIsThrownIfDataSourceDoesntExist() {
        Initializer initializer = new Initializer(NOT_VALID);
        initializer.initialize();
    }

    @Test
    public void testCreatedListIsNotNullIfDataSourceIsValid() {
        Initializer initializer = new Initializer(VALID_DATA);
        Assert.assertFalse(initializer.initialize() == null);
    }

    @Test
    public void testEmptyLinesAreSkipped() {
        Initializer initializer = new Initializer(VALID_DATA);
        List<ElectricalAppliance> list = initializer.initialize();
        int allLines = 0;
        int emptyLines = 0;
        String s;
        try (BufferedReader reader = new BufferedReader(new FileReader(VALID_DATA))) {
            while ((s = reader.readLine()) != null) {
                allLines++;
                if (s.isEmpty()) {
                    emptyLines++;
                }
            }
        } catch (IOException e) {
            e.getStackTrace();
        }

        Assert.assertTrue(list.size() == (allLines - emptyLines));

    }


}

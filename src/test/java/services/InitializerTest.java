package services;

import controllers.Controller;
import exceptions.FileValidateException;
import exceptions.InvalidArgumentException;
import models.ElectricalAppliance;
import org.junit.Assert;
import org.junit.Test;
import sun.rmi.log.LogInputStream;

import java.io.*;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

import static org.mockito.Mockito.mock;

public class InitializerTest {
    static final String VALID_DATA = "src/test/resources/ValidDataExample.csv";
    static final String EMPTY_DATA = "src/test/resources/Empty.csv";
    static final String NOT_VALID = "src/test/resources/NoFile";


    @Test
    public void testCreatedListIsEmptyIfDataSourceIsEmpty() {
        Initializer initializer = new Initializer(EMPTY_DATA);
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

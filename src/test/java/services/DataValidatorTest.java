package services;

import exceptions.EmptyArgumentException;
import exceptions.InvalidArgumentException;
import models.ElectricalAppliance;
import org.junit.Test;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;

public class DataValidatorTest {
    @Test(expected = InvalidArgumentException.class)
    public void testIfListIsNullThrowsEmptyArgumentException() throws EmptyArgumentException {
        List<ElectricalAppliance> list = null;
        DataValidator.check(list);
    }

    @Test(expected = EmptyArgumentException.class)
    public void testIfListIsEmptyThrowsEmptyArgumentException() throws EmptyArgumentException {
        List<ElectricalAppliance> list = new ArrayList<>();
        DataValidator.check(list);
    }

    @Test(expected = InvalidArgumentException.class)
    public void testIfStingIsNullThrowsEmptyArgumentException() throws EmptyArgumentException {
        String s = null;
        DataValidator.check(s);
    }

    @Test(expected = EmptyArgumentException.class)
    public void testIfStringIsEmptyThrowsEmptyArgumentException() throws EmptyArgumentException {
        String s = "";
        DataValidator.check(s);
    }

    @Test(expected = InvalidArgumentException.class)
    public void testIfMinBelow0ThrowsInvalidArgumentException() {

        DataValidator.checkMinMax(-1, 1);
    }

    @Test(expected = InvalidArgumentException.class)
    public void testIfMaxBelowMinThrowsInvalidArgumentException() {
        DataValidator.checkMinMax(6, 4);
    }
}
package service;

import exception.EmptyArgumentException;
import exception.InvalidArgumentException;
import model.ElectricalAppliance;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DataValidatorTest {
    @Test(expected = InvalidArgumentException.class)
    public void testIfListIsNullThrowsEmptyArgumentException() throws EmptyArgumentException {
        List<ElectricalAppliance> list = null;
        DataValidator.isNullOrEmpty(list);
    }

    @Test(expected = EmptyArgumentException.class)
    public void testIfListIsEmptyThrowsEmptyArgumentException() throws EmptyArgumentException {
        List<ElectricalAppliance> list = new ArrayList<>();
        DataValidator.isNullOrEmpty(list);
    }

    @Test(expected = InvalidArgumentException.class)
    public void testIfStingIsNullThrowsEmptyArgumentException() throws EmptyArgumentException {
        String s = null;
        DataValidator.isNullOrEmpty(s);
    }

    @Test(expected = EmptyArgumentException.class)
    public void testIfStringIsEmptyThrowsEmptyArgumentException() throws EmptyArgumentException {
        String s = "";
        DataValidator.isNullOrEmpty(s);
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
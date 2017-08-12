package services;

import models.ElectricalAppliance;
import org.junit.Test;

import java.util.List;

public class DataValidatorTest {
    @Test(expected = IllegalArgumentException.class)
    public void testCheckListsIsNullThrowsException() {
        List<ElectricalAppliance> list = null;
        DataValidator.check(list);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCheckStringIsNullThrowsException() {
        String s = null;
        DataValidator.check(s);
    }

}
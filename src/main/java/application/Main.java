package application;/*Домашние электроприборы. Определить иерархию электроприборов.
Включить некоторые в розетку. Посчитать потребляемую мощность
Провести сортировку приборов в квартире на основе мощности. Найти
прибор в квартире, соответствующий заданному диапазону параметров.*/

import controller.Controller;
import model.ElectricalAppliance;

public class Main {
    private final static int MIN = 0;
    private final static int MAX = 2300;

    public static void main(String[] args) {

        Controller controller = Controller.createController("src/main/resources/OneRoomStudioDevices.csv");


        ElectricalAppliance fridge = controller.findDeviceByName("BostonDynamicsFridge");
        ElectricalAppliance notExisting = controller.findDeviceByName("TeslaHome");

        System.out.println(controller.findDeviceBasedOnParameters(MIN, MAX));

        controller.switchOn(fridge);
        controller.switchOff(fridge);
        controller.switchOn(notExisting);

        System.out.println("All devices are off. Power - " + controller.getCurrentPower());
        controller.switchOn(fridge);
        System.out.println("Fridge (100) is on. Power - " + controller.getCurrentPower());

        System.out.println(controller.sortMinToMaxPower());

    }
}

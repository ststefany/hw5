package application;/*Домашние электроприборы. Определить иерархию электроприборов.
Включить некоторые в розетку. Посчитать потребляемую мощность
Провести сортировку приборов в квартире на основе мощности. Найти
прибор в квартире, соответствующий заданному диапазону параметров.*/

import services.Controller;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Controller controller = main.createController("src/main/resources/OneRoomStudioDevices.csv");

        System.out.println(controller.findDeviceBasedOnParameters(0, 2300));

            controller.switchOn(controller.findDeviceByName("BostonDynamicsFridge"));
            controller.switchOn(controller.findDeviceByName("TeslaHome"));

        System.out.println(controller.getCurrentPower());
        System.out.println(controller.sortMinToMaxPower());

    }

    public Controller createController(String dataResource) {
        Controller controller = new Controller();
        return controller.initController(dataResource);
    }
}

/*Домашние электроприборы. Определить иерархию электроприборов.
Включить некоторые в розетку. Посчитать потребляемую мощность
Провести сортировку приборов в квартире на основе мощности. Найти
прибор в квартире, соответствующий заданному диапазону параметров.*/

import services.Controller;

public class Main {
    public static void main(String[] args) {

        Controller controller = new Controller("src/main/resources/OneRoomStudioDevices.csv");

        System.out.println(controller.findDeviceBasedOnParameters(0, 2300));
        controller.switchOn(controller.findDevicebyName("BostonDynamicsFridge"));
        controller.switchOn(controller.findDevicebyName("TeslaHomeIron"));
        System.out.println(controller.getCurrentPower());
        System.out.println(controller.sortMinToMaxPower());


    }

}

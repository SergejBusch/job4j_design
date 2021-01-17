package ru.job4j.solid.ocp;

public class Printer {
    public Printer(String printerTyp) {
        System.out.println(printerTyp);
    }

    public void changeCartridgeCanon55() {
        System.out.println("change");
    }

    public void changeCartridgeHP33() {
        System.out.println("change");
    }
}

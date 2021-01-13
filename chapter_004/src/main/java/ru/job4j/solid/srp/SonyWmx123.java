package ru.job4j.solid.srp;

public class SonyWmx123 implements Headset {
    private int credit = 3;

    @Override
    public void playMusic() {
        if (credit > 0) {
            play();
        }
    }

    void play() {

    }
}

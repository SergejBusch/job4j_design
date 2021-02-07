package ru.job4j.solid.isp;

public interface IMenuChild {
    void addChild(IMenuElement... elements);

    boolean hasChildElements();

    IMenuElement getFirstChild();
}

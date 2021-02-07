package ru.job4j.solid.isp;

public interface IMenuSibling {
    boolean hasNextSibling();

    IMenuElement getNextSibling();
}

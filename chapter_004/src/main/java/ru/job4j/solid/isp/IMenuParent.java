package ru.job4j.solid.isp;

public interface IMenuParent {
    IMenuElement getParent();

    void setParent(IMenuElement parent);
}

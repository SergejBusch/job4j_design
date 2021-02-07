package ru.job4j.solid.isp;

import java.util.ListIterator;

public interface IMenuIterator {
    ListIterator<IMenuElement> getIterator();
}

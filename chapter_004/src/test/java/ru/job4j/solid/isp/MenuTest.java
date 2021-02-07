package ru.job4j.solid.isp;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import org.junit.Test;

public class MenuTest {

    @Test
    public void createMenu() {
        var menu = new Menu();
        var mainMenu = menu.getRoot();
        var a = new Menu.MenuElement("A");
        var b = new Menu.MenuElement("B");
        var c = new Menu.MenuElement("C");
        var x = new Menu.MenuElement("X");
        var y = new Menu.MenuElement("Y");
        var y1 = new Menu.MenuElement("1");
        var y2 = new Menu.MenuElement("2");
        y2.setText("Task2");
        var z = new Menu.MenuElement("Z");
        y.addChild(y1, y2);
        b.addChild(x, y, z);
        mainMenu.addChild(a, b, c);
        new MenuPrinter().show(menu.getRoot());
        Input input = new StringInput("2", "exit");
        var action = new Action(input);
        action.doAction(menu.getRoot());
        assertThat(action.output, is("Task2"));
    }
}

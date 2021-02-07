package ru.job4j.solid.isp;

public class MenuPrinter implements IPrintMenu {

    @Override
    public void show(IMenuElement rootNode) {
        var node = rootNode.getFirstChild();

        while (node != null) {
            System.out.println(getDash(node) + node.getName());

            if (node.hasChildElements()) {
                node = node.getFirstChild();
            } else {
                while (!node.hasNextSibling() && node != rootNode) {
                    node = node.getParent();
                }
                node = node.getNextSibling();
            }
        }
    }

    private String getDash(IMenuElement node) {
        StringBuilder dash = new StringBuilder();
        var element = node;

        while (element.getParent().getParent() != null) {
            dash.append("--");
            element = element.getParent();
        }
        return dash.toString();
    }
}

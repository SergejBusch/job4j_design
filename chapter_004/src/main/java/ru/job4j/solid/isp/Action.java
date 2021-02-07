package ru.job4j.solid.isp;

public class Action implements IMenuAction {
    Input input;
    String name;
    boolean found;
    String output;

    public Action(Input input) {
        this.input = input;
    }

    @Override
    public void doAction(IMenuElement root) {
        do {
            found = false;
            System.out.println("give the task name or type \"exit\"");
            name = input.getString();

            var node = root.getFirstChild();

            while (node != null) {
                if (node.getName().equals(name)) {
                    found = true;
                    output = node.getText();
                    System.out.println(output + "\n");
                    break;
                }

                if (node.hasChildElements()) {
                    node = node.getFirstChild();
                } else {
                    while (!node.hasNextSibling() && node != root) {
                        node = node.getParent();
                    }
                    node = node.getNextSibling();
                }
            }
            if (!found && !name.equals("exit")) {
                output = "element not found";
                System.out.println(output);
            }
        } while (!name.equals("exit"));
    }
}

package ru.job4j.solid.isp;

import java.time.Instant;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Menu {
    private final MenuElement root = new MenuElement("");

    public MenuElement getRoot() {
        return root;
    }

    public static class MenuElement implements IMenuElement {
        private String name;
        private String text;
        private IMenuElement parent;
        final private List<IMenuElement> children = new LinkedList<>();
        private ListIterator<IMenuElement> iterator;
        private Date date = Date.from(Instant.now());

        public MenuElement(String name) {
            this.name = name;
        }

        @Override
        public void addChild(IMenuElement... elements) {
            for (var e : elements) {
                children.add(e);
                e.setParent(this);
            }
        }

        public boolean hasChildElements() {
            return !children.isEmpty();
        }

        @Override
        public IMenuElement getFirstChild() {
            iterator = children.listIterator();
            if (iterator.hasNext()) {
                return iterator.next();
            }
            return null;
        }

        public void initIterator() {
            iterator = children.listIterator();
        }

        @Override
        public boolean hasNextSibling() {
            if (this.getParent() != null) {
                return this.getParent().getIterator().hasNext();
            }
            return false;
        }

        @Override
        public IMenuElement getNextSibling() {
            if (this.getParent() != null) {
                var parentIterator = this.getParent().getIterator();

                if (parentIterator.hasNext()) {
                    return parentIterator.next();
                }
            }
            return null;
        }

        @Override
        public void setParent(IMenuElement parent) {
            this.parent = parent;
        }

        @Override
        public IMenuElement getParent() {
            return parent;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        @Override
        public ListIterator<IMenuElement> getIterator() {
            if (iterator == null) {
                initIterator();
            }
            return iterator;
        }
    }
}

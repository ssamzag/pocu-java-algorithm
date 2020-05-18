package academy.pocu.comp2500.lab3;

import java.util.ArrayList;

public class ListItem {
    private String text;
    private char bulletStyle;
    private int depth;
    private final ArrayList<ListItem> listItem;

    public ListItem(String text) {
        this(text, '*');
    }

    public ListItem(String text, char bulletStyle) {
        this.text = text;
        this.bulletStyle = bulletStyle;
        this.depth = 0;
        this.listItem = new ArrayList<ListItem>();
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public char getBulletStyle() {
        return this.bulletStyle;
    }

    public void addSublistItem(ListItem listItem) {
        this.listItem.add(listItem);
    }
    public ListItem getSublistItem(int index) {
        return this.listItem.get(index);
    }

    public void removeSublistItem(int index) {
        this.listItem.remove(index);
    }

    private ListItem setDepth(int depth) {
        this.depth = depth == 2 ? depth : ++depth;
        return this;
    }

    private String getSpacingBullet() {
        return " ".repeat(this.depth * 4) + this.bulletStyle + " ";
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(getSpacingBullet() + this.getText() + "%s", System.lineSeparator()));
        for (var list: listItem) {
            sb.append(list);
        }
        return sb.toString();
    }
}

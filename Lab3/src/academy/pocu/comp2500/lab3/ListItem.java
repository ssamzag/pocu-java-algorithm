package academy.pocu.comp2500.lab3;

import java.util.ArrayList;

public class ListItem {
    private String text;
    private char bulletStyle;
    private int depth;
    private ArrayList<ListItem> listItemArrayList;

    public ListItem(String text) {
        this(text, '*');
    }

    public ListItem(String text, char bulletStyle) {
        this.text = text;
        this.bulletStyle = bulletStyle;
        this.listItemArrayList = new ArrayList<ListItem>();
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

    public void setBulletStyle(char bullet) {
        this.bulletStyle = bullet;
    }

    public void addSublistItem(ListItem listItem) {
        this.listItemArrayList.add(listItem);
    }

    public ListItem getSublistItem(int index) {
        return this.listItemArrayList.get(index);
    }

    public void removeSublistItem(int index) {
        this.listItemArrayList.remove(index);
    }

    private void setDepth(int depth) {
        this.depth = Math.min(depth + 1, 2);
    }

    private int getDepth() {
        return this.depth;
    }

    private String aa(int depth) {
        StringBuilder sb = new StringBuilder();
        depth = Math.min(depth, 2);
        sb.append(String.format(" ".repeat(4 * depth) + this.bulletStyle + " " + this.text + "%s", System.lineSeparator()));

        for (var listItem : this.listItemArrayList) {
            sb.append(listItem.aa(depth + 1));
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return aa(0);
    }
}

package academy.pocu.comp2500.lab3;

import java.util.ArrayList;

public class ListItem {
    private String text;
    private final ArrayList<ListItem> listItem;
    private char bulletStyle;
    private int depth;

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

    public void setBulletStyle(char bulletStyle) {
        this.bulletStyle = bulletStyle;
    }

    public void addSublistItem(ListItem listItem) {
        this.listItem.add(listItem);
        listItem.setDepth();
    }

    public ListItem getSublistItem(int index) {
        return this.listItem.get(index);
    }

    public void setDepth() {
        this.depth = this.depth == 2 ? this.depth : ++this.depth;
    }

    private String getSpacingBullet() {
        return " ".repeat(this.depth * 4) + this.bulletStyle + " ";
    }

    public void removeSublistItem(int index) {
        this.listItem.remove(index);
    }

    @Override
    public String toString() {
        return String.format(getSpacingBullet() + this.text, System.lineSeparator());
    }

}

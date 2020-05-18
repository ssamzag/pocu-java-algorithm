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

    public ListItem setBulletStyle(char bulletStyle) {
        this.bulletStyle = bulletStyle;
        return this;
    }

    public ListItem addSublistItem(ListItem listItem) {
        this.listItem.add(listItem);
        listItem.setDepth();
        return this;
    }

    public ListItem getSublistItem(int index) {
        return this.listItem.get(index);
    }

    public ListItem setDepth() {
        this.depth = this.depth == 2 ? this.depth : ++this.depth;
        return this;
    }

    private String getSpacingBullet() {
        return " ".repeat(this.depth * 4) + this.bulletStyle + " ";
    }

    public ListItem removeSublistItem(int index) {
        this.listItem.remove(index);
        return this;
    }

    @Override
    public String toString() {
        return getSpacingBullet() + this.text;
    }

}

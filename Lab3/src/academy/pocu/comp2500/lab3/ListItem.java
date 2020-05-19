package academy.pocu.comp2500.lab3;

import java.util.ArrayList;

public class ListItem {
    private String text;
    private char bulletStyle;
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
    private String getAssembledText(int depth){
        return " ".repeat(4 * depth) + this.bulletStyle + " " + this.text;
    }
    
    private String getListItemText(int depth) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s%s", getAssembledText(depth++), System.lineSeparator()));

        for (var listItem : this.listItemArrayList) {
            sb.append(listItem.getListItemText(depth));
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return getListItemText(0);
    }
}

package models;

public class Store {
    private Item[][] items;

    public Store() {
        this.items = new Item[7][3];
    }

    public Item getItems(int row, int column) {
        return new Item(items[row][column]);
    }

    public void setItems(int row, int column, Item item) {
        items[row][column] = new Item(item);
    }
    public String toString(){
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < items.length; i++) {
            switch (i) {
                case 0 -> temp.append("\t1.DRINKS:        ");
                case 1 -> temp.append("\t2.CEREAL:        ");
                case 2 -> temp.append("\t3.DAIRY:         ");
                case 3 -> temp.append("\t4.DELI:          ");
                case 4 -> temp.append("\t5.GREENS:        ");
                case 5 -> temp.append("\t6.CLOTHING:      ");
                case 6 -> temp.append("\t7.ELECTRONICS:   ");
            }
            for (int j = 0; j < items[i].length; j++) {
                temp.append(items[i][j].toString());
            }
            temp.append("\n\n");

        }
        temp.append("\t************************************************************************\n");
        return temp.toString();
    }
}

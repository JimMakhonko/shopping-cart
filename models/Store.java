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
                case 0 -> temp.append("\tDRINKS:        ");
                case 1 -> temp.append("\tCEREAL:        ");
                case 2 -> temp.append("\tDAIRY:         ");
                case 3 -> temp.append("\tDELI:          ");
                case 4 -> temp.append("\tGREENS:        ");
                case 5 -> temp.append("\tCLOTHING:      ");
                case 6 -> temp.append("\tELECTRONICS:   ");
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

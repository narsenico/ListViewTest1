package it.amonshore.listviewtest1.data;

/**
 * Created by Narsenico on 12/03/2015.
 */
public class ItemInfo {

    public final static String PAR_NUMBER = "item_info_number";
    public final static String PAR_NAME = "item_info_name";
    public final static String PAR_NOTES = "item_info_notes";

    private int number;
    private String name;
    private String notes;

    public ItemInfo(int number, String name, String notes) {
        this.number = number;
        this.name = name;
        this.notes = notes;
    }

    public int getNumber() { return number; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}

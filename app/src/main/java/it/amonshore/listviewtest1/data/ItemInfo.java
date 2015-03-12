package it.amonshore.listviewtest1.data;

/**
 * Created by Narsenico on 12/03/2015.
 */
public class ItemInfo {
    private String name;
    private String editor;

    public ItemInfo(String name, String editor) {
        this.name = name;
        this.editor = editor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }
}

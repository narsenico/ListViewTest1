package it.amonshore.listviewtest1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import it.amonshore.listviewtest1.data.ItemInfo;

/**
 * Created by Narsenico on 13/03/2015.
 */
public class ItemsAdapter extends BaseAdapter {

    private List<ItemInfo> items = null;
    private Context context = null;

    public ItemsAdapter(Context context, List<ItemInfo> items) {
        this.context = context;
        this.items = items;
    }

    public int add(ItemInfo item) {
        items.add(item);
        return items.size() - 1;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).hashCode();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.listactivity_row_article, null);
        }

        ItemInfo item = (ItemInfo)getItem(position);
        TextView txtName = (TextView)convertView.findViewById(R.id.lbl_name);
        txtName.setText(item.getName());
        TextView txtNotes = (TextView)convertView.findViewById(R.id.txt_notes);
        txtNotes.setText(item.getNotes());
        TextView txtNumber = (TextView)convertView.findViewById(R.id.txt_number);
        txtNumber.setText(Integer.toString(item.getNumber()));
        return convertView;
    }
}

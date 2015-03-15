package it.amonshore.listviewtest1;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import it.amonshore.listviewtest1.data.ItemInfo;


public class MainActivity extends ActionBarActivity {

    public final int ACTION_ITEM_ADD = 10001;
    public final int ACTION_ITEM_EDIT = 10002;

    private ItemsAdapter adapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView)findViewById(R.id.listView);

        //eventi lista
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                view.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
            }
        });

       //imposto adapter
        adapter = new ItemsAdapter(this, createItems());
        listView.setAdapter(adapter);
    }

    private List<ItemInfo> createItems() {
        ArrayList<ItemInfo> items = new ArrayList<>();
        //items.add(new ItemInfo("Naruto", "Planet Manga"));
        //items.add(new ItemInfo("One Piece", "Star Comics"));
        for (int ii=0; ii<2; ii++) {
            items.add(new ItemInfo("Item" + ii, "Editor" + ii));
        }
        return items;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        //nuovo elemento
        else if (id == R.id.action_addnew) {
//            int pos = adapter.add(new ItemInfo("Item" + adapter.getCount(), "Editor" + adapter.getCount()));
//            adapter.notifyDataSetChanged();
//            listView.setSelection(pos);
            Intent intent = new Intent(this, ItemEditorActivity.class);
            //nel caso passare parametri con putExtra()
            startActivityForResult(intent, ACTION_ITEM_ADD);
            return true;
        //vai a TabbedActivity
        } else if (id == R.id.action_gototabs) {
            Intent intent = new Intent(this, TabbedActivity.class);
            startActivity(intent);
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK && requestCode == ACTION_ITEM_ADD) {
            //data.get...
            int pos = adapter.add(new ItemInfo("Item" + adapter.getCount(), "Editor" + adapter.getCount()));
            adapter.notifyDataSetChanged();
            listView.setSelection(pos);
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}

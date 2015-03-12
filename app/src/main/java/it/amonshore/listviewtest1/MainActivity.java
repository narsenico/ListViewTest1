package it.amonshore.listviewtest1;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import it.amonshore.listviewtest1.data.ItemInfo;


public class MainActivity extends ActionBarActivity {

    private ItemsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter = new ItemsAdapter(this, createItems());
        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);
    }

    private List<ItemInfo> createItems() {
        ArrayList<ItemInfo> items = new ArrayList<>();
        //items.add(new ItemInfo("Naruto", "Planet Manga"));
        //items.add(new ItemInfo("One Piece", "Star Comics"));
        for (int ii=0; ii<100; ii++) {
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

        return super.onOptionsItemSelected(item);
    }
}

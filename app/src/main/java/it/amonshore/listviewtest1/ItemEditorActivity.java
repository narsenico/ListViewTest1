package it.amonshore.listviewtest1;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import it.amonshore.listviewtest1.data.ItemInfo;


public class ItemEditorActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_editor);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_item_editor, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_save) {
            Intent intent = new Intent();

            EditText txtNumber = (EditText)findViewById(R.id.txt_number);
            EditText txtName = (EditText)findViewById(R.id.txt_name);
            EditText txtNotes = (EditText)findViewById(R.id.txt_notes);

            intent.putExtra(ItemInfo.PAR_NUMBER, Integer.parseInt(txtNumber.getText().toString()) );
            intent.putExtra(ItemInfo.PAR_NAME, txtName.getText().toString());
            intent.putExtra(ItemInfo.PAR_NOTES, txtNotes.getText().toString());

            setResult(Activity.RESULT_OK, intent);
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}

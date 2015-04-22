package xyz.yyagi.sampleapp;

import android.app.ActionBar;
import android.app.FragmentManager;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import it.neokree.materialnavigationdrawer.MaterialNavigationDrawer;


public class MainActivity extends MaterialNavigationDrawer {

    @Override
    public void init(Bundle savedInstanceState) {
        // setDrawerHeaderImage(R.drawable.abc_cab_background_top_material);
        this.addSection(newSection("Section 1", new FragmentIndex()));
        Uri uri = Uri.parse("https://github.com/y-yagi/travel_base");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);

        this.addSubheader("Subheader title");
        this.addSection(newSection("OpenURL", intent));
        this.addSection(newSection("Section 2", new FragmentIndex()));
        this.addSection(newSection("Section 3", R.drawable.ic_arrow_drop_down_white_24dp, new FragmentButton()).setSectionColor(Color.parseColor("#9c27b0")));
        this.addBottomSection(newSection("Bottom Section", R.drawable.ic_arrow_drop_up_white_24dp, new Intent(this, Settings.class)));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
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

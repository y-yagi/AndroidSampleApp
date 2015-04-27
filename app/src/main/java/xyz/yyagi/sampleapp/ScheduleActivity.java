package xyz.yyagi.sampleapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import it.neokree.materialnavigationdrawer.MaterialNavigationDrawer;


public class ScheduleActivity extends BaseActivity {

    public void init(Bundle savedInstanceState) {
        super.init(savedInstanceState);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState)  {
        super.onPostCreate(savedInstanceState);
        setDefaultSectionLoaded(1);
    }
}

package xyz.yyagi.sampleapp;

import android.app.ListFragment;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;

import java.util.ArrayList;

import xyz.yyagi.sampleapp.models.Schedule;


/**
 * A placeholder fragment containing a simple view.
 */
public class TimeTableActivityFragment extends ListFragment {

    TimeTableAdapter mTimeTableAdapter;

    public TimeTableActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_time_table, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayList<Schedule> mItems = new ArrayList<Schedule>();
        mItems.add(new Schedule("戸田公園", "とおくなるー", "10:00", "11:00"));
        mItems.add(new Schedule("伊勢神宮", "三重県なり", "12:00", "14:00"));
        mItems.add(new Schedule("出雲大社", "島根県はとおいなあ", "15:00", "16:00"));
        mTimeTableAdapter = new TimeTableAdapter(getActivity(), mItems);
        setListAdapter(mTimeTableAdapter);
    }
}

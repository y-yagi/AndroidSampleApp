package xyz.yyagi.sampleapp;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import xyz.yyagi.sampleapp.models.Schedule;

/**
 * Created by yaginuma on 15/05/05.
 */
public class TimeTableAdapter implements ListAdapter {
    private final Context mContext;
    ArrayList<Schedule> mItems = new ArrayList<Schedule>();

    public TimeTableAdapter(Context context, ArrayList<Schedule> items) {
        mContext = context;
        mItems = items;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return true;
    }

    @Override
    public boolean isEnabled(int position) {
        return true;
    }

    public void registerDataSetObserver(DataSetObserver observer) {
    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public Object getItem(int position) {
        return mItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        int layoutResId = R.layout.time_table_item;
        view = ((LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE))
                .inflate(layoutResId, parent, false);

        Schedule schedule = mItems.get(position);

        TextView textView = (TextView) view.findViewById(R.id.title);
        textView.setText(schedule.title);
        textView = (TextView)view.findViewById(R.id.detail);
        textView.setText(schedule.detail);
        textView = (TextView)view.findViewById(R.id.start_time);
        textView.setText(schedule.startTime);
        textView = (TextView)view.findViewById(R.id.end_time);
        textView.setText(schedule.endTime);

        return view;
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public boolean isEmpty() {
        return mItems.isEmpty();
    }
}

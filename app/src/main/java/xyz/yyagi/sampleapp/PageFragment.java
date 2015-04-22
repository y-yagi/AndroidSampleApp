package xyz.yyagi.sampleapp;


import android.os.Bundle;
import android.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class PageFragment extends Fragment {
    public PageFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        TextView text = new TextView(this.getActivity());
        text.setText("Fragment!!!");
        text.setGravity(Gravity.CENTER);
        return text;

        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_page, container, false);
    }


}

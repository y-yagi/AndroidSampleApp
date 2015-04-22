package xyz.yyagi.sampleapp;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v13.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v13.FragmentPagerItems;

public class FragmentIndex extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Activity activity = getActivity();
        TextView text = new TextView(activity);
        text.setText("Fragment!!!");
        text.setGravity(Gravity.CENTER);

        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getFragmentManager(), FragmentPagerItems.with(activity)
                .add(R.string.tab1, PageFragment.class)
                .add(R.string.tab2, PageFragment.class)
                .create());

        ViewPager viewPager = (ViewPager) activity.findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter);

        SmartTabLayout viewPagerTab = (SmartTabLayout) activity.findViewById(R.id.viewpagertab);
        viewPagerTab.setViewPager(viewPager);
        return text;
    }
}


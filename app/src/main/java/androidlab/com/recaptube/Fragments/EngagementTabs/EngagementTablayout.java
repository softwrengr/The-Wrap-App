package androidlab.com.recaptube.Fragments.EngagementTabs;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidlab.com.recaptube.R;

public class EngagementTablayout extends Fragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    TextView textView;
    String strText;
    Bundle bundle;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_engagement_tablayout, container, false);

        viewPager = (ViewPager) view.findViewById(R.id.viewpagerEng);
        tabLayout = (TabLayout) view.findViewById(R.id.tabsEng);
        bundle=new Bundle();
        textView=(TextView)view.findViewById(R.id.tvTopEng);
        strText=getArguments().getString("text");
        textView.setText(strText);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        LinearLayout linearLayout = (LinearLayout)tabLayout.getChildAt(0);
        linearLayout.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
        GradientDrawable drawable = new GradientDrawable();
        drawable.setColor(Color.GRAY);
        drawable.setSize(1, 1);
        linearLayout.setDividerPadding(10);
        linearLayout.setDividerDrawable(drawable);
        tabLayout.addTab(tabLayout.newTab().setText("ACTIVITY"));
        tabLayout.addTab(tabLayout.newTab().setText("EXERCISE"));
        tabLayout.addTab(tabLayout.newTab().setText("DIVERSION"));
        tabLayout.addTab(tabLayout.newTab().setText("CUSTOM"));
        viewPager.setAdapter(new PagerAdapter(((FragmentActivity) getActivity()).getSupportFragmentManager(), tabLayout.getTabCount()));
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        for(int i=0; i < tabLayout.getTabCount(); i++) {
            View tab = ((ViewGroup) tabLayout.getChildAt(0)).getChildAt(i);
            ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) tab.getLayoutParams();
            p.setMargins(50, 0, 50, 0);
            tab.requestLayout();
        }
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return view;
    }
    @Override
    public void onDestroyView() {
        //mContainer.removeAllViews();
        ViewGroup mContainer = (ViewGroup) getActivity().findViewById(R.id.mainContainer);
        mContainer.removeAllViews();
        super.onDestroyView();
    }

    public class PagerAdapter extends FragmentStatePagerAdapter {
        int mNumOfTabs;

        public PagerAdapter(android.support.v4.app.FragmentManager fm, int NumOfTabs) {
            super(fm);
            this.mNumOfTabs = NumOfTabs;
        }

        @Override
        public android.support.v4.app.Fragment getItem(int position) {

            switch (position) {
                case 0:
                    EngagementActivityFragmnet fragmentDiscussion=new EngagementActivityFragmnet();
                    bundle.putString("text", strText);
                    fragmentDiscussion.setArguments(bundle);
                    return fragmentDiscussion;
                case 1:
                    EngagementExcerciseFragment fragmentDiscussion2=new EngagementExcerciseFragment();
                    bundle.putString("text", strText);
                    fragmentDiscussion2.setArguments(bundle);
                    return fragmentDiscussion2;
                case 2:
                    EngagementDiversionFragment fragmentDiscussion3=new EngagementDiversionFragment();
                    bundle.putString("text", strText);
                    fragmentDiscussion3.setArguments(bundle);
                    return fragmentDiscussion3;
                case 3:
                    EngagementCustomFragment fragmentDiscussion4=new EngagementCustomFragment();
                    bundle.putString("text", strText);
                    fragmentDiscussion4.setArguments(bundle);
                    return fragmentDiscussion4;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return mNumOfTabs;
        }
    }

}

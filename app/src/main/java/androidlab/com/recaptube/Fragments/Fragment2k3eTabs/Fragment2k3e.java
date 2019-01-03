package androidlab.com.recaptube.Fragments.Fragment2k3eTabs;

import android.content.Context;
import android.content.SharedPreferences;
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


public class Fragment2k3e extends Fragment {

    TextView textPreview;
    String text;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    Bundle bundle;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_fragment2k3e, container, false);

        sharedPreferences = getActivity().getSharedPreferences("recap", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        textPreview=(TextView)view.findViewById(R.id.textPreview2K3e1);
        text=getArguments().getString("text");
        editor.putString("finalstring",text).commit();
        textPreview.setText(text);
        bundle=new Bundle();
        bundle.putString("text",text);
        viewPager = (ViewPager)view. findViewById(R.id.viewpager2k3e);
        tabLayout = (TabLayout)view.findViewById(R.id.tab2k3e);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        LinearLayout linearLayout = (LinearLayout)tabLayout.getChildAt(0);
        linearLayout.setShowDividers(LinearLayout.SHOW_DIVIDER_MIDDLE);
        GradientDrawable drawable = new GradientDrawable();
        drawable.setColor(Color.GRAY);
        drawable.setSize(1, 1);
        linearLayout.setDividerPadding(10);
        linearLayout.setDividerDrawable(drawable);
        tabLayout.addTab(tabLayout.newTab().setText("POSITIVE"));
        tabLayout.addTab(tabLayout.newTab().setText("NEUTRAL"));
        tabLayout.addTab(tabLayout.newTab().setText("NEGATIVE"));
        tabLayout.addTab(tabLayout.newTab().setText("QUOTE"));
        viewPager.setAdapter(new PagerAdapter(((FragmentActivity) getActivity()).getSupportFragmentManager(), tabLayout.getTabCount()));
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        for(int i=0; i < tabLayout.getTabCount(); i++) {
            View tab = ((ViewGroup) tabLayout.getChildAt(0)).getChildAt(i);
            ViewGroup.MarginLayoutParams p = (ViewGroup.MarginLayoutParams) tab.getLayoutParams();
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
                    PositiveFragment positiveFragment=new PositiveFragment();
                    positiveFragment.setArguments(bundle);
                    return positiveFragment;
                case 1:
                    NeutralFragment neutralFragment=new NeutralFragment();
                    neutralFragment.setArguments(bundle);
                    return neutralFragment;
                case 2:
                    NegativeFragment negativeFragment=new NegativeFragment();
                    negativeFragment.setArguments(bundle);
                    return negativeFragment;
                case 3:
                    QuoteTab quoteTab=new QuoteTab();
                    quoteTab.setArguments(bundle);
                    return quoteTab;
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

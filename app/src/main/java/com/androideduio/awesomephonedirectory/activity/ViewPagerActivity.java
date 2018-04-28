package com.androideduio.awesomephonedirectory.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.androideduio.awesomephonedirectory.R;
import com.androideduio.awesomephonedirectory.adapter.ViewPagerAdapter;
import com.androideduio.awesomephonedirectory.fragment.ContactListFragment;
import com.androideduio.awesomephonedirectory.fragment.SecondFragment;

public class ViewPagerActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener, ViewPager.OnPageChangeListener {


    private TabLayout tabLayout = null;
    private ViewPager vpFragments = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        initView();
    }

    private void initView() {


        tabLayout = findViewById(R.id.activity_view_pager_sample_tablayout);
        vpFragments = findViewById(R.id.activity_view_pager_sample_vpFragments);


        initEvent();
    }

    private void initEvent() {

        tabLayout.setupWithViewPager(vpFragments);
        tabLayout.addOnTabSelectedListener(this);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());


        ContactListFragment contactListFragment = new ContactListFragment();
        SecondFragment addContactFragment = new SecondFragment();

        viewPagerAdapter.addFragment(contactListFragment, "CONTACT LIST");
        viewPagerAdapter.addFragment(addContactFragment, "ADD CONTACT");

        vpFragments.setAdapter(viewPagerAdapter);
        vpFragments.addOnPageChangeListener(this);
        vpFragments.setCurrentItem(1);
    }


    @Override
    public void onTabSelected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}

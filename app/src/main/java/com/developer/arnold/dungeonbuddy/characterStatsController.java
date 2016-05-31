package com.developer.arnold.dungeonbuddy;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author      Arnold Goncharenko
 *
 * A class designed to store all the fragments related to the characters stats.
 */
public class characterStatsController extends Fragment {

    //creates a tab host that will store all the fragments
    private FragmentTabHost mTabHost;

    /**
     * function that acts as the default constructor for the class.
     */
    public characterStatsController() {
    }

    /**
     * function that is called when the activity is loaded.
     *
     * @param inflater              a object that is used to show (or inflate) the current fragment that has a specific view.
     * @param container             the container that the class is stored in (usually some sort of layout).
     * @param savedInstanceState    contains the saved instance of the application, containing all necessary information.
     * @return                      returns the tabhost to be used to store all the fragments.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mTabHost = new FragmentTabHost(getActivity());
        mTabHost.setup(getActivity(), getChildFragmentManager(), R.id.realtabcontent);

        //add tabs for the fragment host.
        mTabHost.addTab(mTabHost.newTabSpec("simple").setIndicator("Simple"),
                abilities.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("contacts").setIndicator("Contacts"),
                savingThrows.class, null);
        mTabHost.addTab(mTabHost.newTabSpec("custom").setIndicator("Custom"),
                skills.class, null);

        return mTabHost;
    }

    /**
     * function that is called when a fragment is destroyed.
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mTabHost = null;
    }
}

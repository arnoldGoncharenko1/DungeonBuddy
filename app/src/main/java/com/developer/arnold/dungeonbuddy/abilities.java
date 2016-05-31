package com.developer.arnold.dungeonbuddy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author      Arnold Goncharenko
 *
 * A class designed to have a fragment that will show the characters abilities.
 */
public class abilities extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_abilities, container, false);
    }
}

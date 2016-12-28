package com.developer.arnold.dungeonbuddy.CharacterView;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.developer.arnold.dungeonbuddy.R;


public class SpellsFragment extends Fragment {

    public SpellsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_spells, container, false);

        return rootView;
    }

}


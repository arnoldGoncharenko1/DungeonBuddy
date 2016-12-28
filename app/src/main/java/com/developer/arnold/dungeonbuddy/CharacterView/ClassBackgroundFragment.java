package com.developer.arnold.dungeonbuddy.CharacterView;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.developer.arnold.dungeonbuddy.R;

/**
 * Created by Arnold on 10/27/2016.
 */
public class ClassBackgroundFragment extends Fragment {

    public ClassBackgroundFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_class_background, container, false);

        return rootView;
    }

}

package com.developer.arnold.dungeonbuddy.CharacterView;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.developer.arnold.dungeonbuddy.R;

/**
 * Created by Arnold on 10/27/2016.
 */
public class EquipmentFragment extends Fragment {

    ListView armorList;
    ListView weaponList;
    ListView itemList;

    public EquipmentFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_equipment, container, false);

        armorList = (ListView) rootView.findViewById(R.id.lstArmor);
        weaponList = (ListView) rootView.findViewById(R.id.lstWeapons);
        itemList = (ListView) rootView.findViewById(R.id.lstItems);

        //inventory.find(inventory.class, "charID = ?", );

        return rootView;
    }

}

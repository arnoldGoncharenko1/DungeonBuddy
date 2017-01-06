package com.developer.arnold.dungeonbuddy.CharacterView;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.developer.arnold.dungeonbuddy.R;

/**
 * Created by Arnold on 10/27/2016.
 */
public class EquipmentFragment extends Fragment {

    ListView armorList;
    ListView weaponList;
    ListView itemList;

    int charId;
    Button btnAddSpells = null;

    public EquipmentFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_equipment, container, false);

        charId = getArguments().getInt("charId");

        armorList = (ListView) rootView.findViewById(R.id.lstArmor);
        weaponList = (ListView) rootView.findViewById(R.id.lstWeapons);
        itemList = (ListView) rootView.findViewById(R.id.lstItems);

        btnAddSpells = (Button) rootView.findViewById(R.id.addSpell);

        btnAddSpells.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
            Intent intent = new Intent(getActivity(), characterWeaponList.class);
            intent.putExtra("charId", charId);
            startActivity(intent);
            }
        });

        return rootView;
    }

}

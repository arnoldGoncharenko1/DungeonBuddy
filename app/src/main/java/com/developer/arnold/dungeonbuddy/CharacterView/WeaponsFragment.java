package com.developer.arnold.dungeonbuddy.CharacterView;

/**
 * Created by Arnold on 1/6/2017.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import com.developer.arnold.dungeonbuddy.DataModels.Weapon;
import com.developer.arnold.dungeonbuddy.DataModels.WeaponItem;
import com.developer.arnold.dungeonbuddy.R;

import java.util.ArrayList;
import java.util.List;

public class WeaponsFragment extends Fragment {

    Button btnAddSWeapon = null;
    ListView weaponList;
    int charId;
    List<WeaponItem> weaponItems = new ArrayList<WeaponItem>();
    List<String> weapons = new ArrayList<String>();

    public WeaponsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_weapons, container, false);

        charId = getArguments().getInt("charId");

        weaponItems = WeaponItem.listAll(WeaponItem.class);

        for(int i=0; i<weaponItems.size(); i++){
            String weaponIds = String.valueOf(weaponItems.get(i).getWeaponId());
            List<Weapon> weapon = Weapon.find(Weapon.class, "WEAPON_ID = ?", weaponIds);
            weapons.add(weapon.get(0).getWeaponName());
        }

        btnAddSWeapon = (Button) rootView.findViewById(R.id.addWeapon);
        weaponList = (ListView) rootView.findViewById(R.id.lstWeapons);

        ArrayAdapter<String> itemsAdapter =
                new ArrayAdapter<String>(rootView.getContext(), android.R.layout.simple_list_item_1, weapons);

        weaponList.setAdapter(itemsAdapter);

        btnAddSWeapon.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(getActivity(), characterSpellList.class);
                intent.putExtra("charId", charId);
                startActivity(intent);
            }
        });

        return rootView;
    }
}

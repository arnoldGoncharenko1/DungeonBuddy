package com.developer.arnold.dungeonbuddy.CharacterView;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.developer.arnold.dungeonbuddy.CharacterCreation.CharacterWorkflow.characterSpellList;
import com.developer.arnold.dungeonbuddy.R;


public class SpellsFragment extends Fragment {

    Button btnAddSpells = null;
    ListView spellList;

    public SpellsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_spells, container, false);

        btnAddSpells = (Button) rootView.findViewById(R.id.addSpell);
        spellList = (ListView) rootView.findViewById(R.id.lstSpells);

        btnAddSpells.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(getActivity(), characterSpellList.class);
                startActivity(intent);
            }
        });

        return rootView;
    }

}


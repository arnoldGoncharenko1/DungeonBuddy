package com.developer.arnold.dungeonbuddy.CharacterView;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.developer.arnold.dungeonbuddy.DataModels.CharSpell;
import com.developer.arnold.dungeonbuddy.DataModels.Spell;
import com.developer.arnold.dungeonbuddy.R;

import java.util.ArrayList;
import java.util.List;


public class SpellsFragment extends Fragment {

    Button btnAddSpells = null;
    ListView spellList;
    int charId;
    List<CharSpell> charSpells = new ArrayList<CharSpell>();
    List<String> spells = new ArrayList<String>();

    public SpellsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_spells, container, false);

        charId = getArguments().getInt("charId");

        charSpells = CharSpell.listAll(CharSpell.class);

        for(int i=0; i<charSpells.size(); i++){
            String spellIds = String.valueOf(charSpells.get(i).getSpellId());
            List<Spell> spell = Spell.find(Spell.class, "SPELL_ID = ?", spellIds);
            spells.add(spell.get(0).getName());
        }

        btnAddSpells = (Button) rootView.findViewById(R.id.addSpell);
        spellList = (ListView) rootView.findViewById(R.id.lstSpells);

        ArrayAdapter<String> itemsAdapter =
                new ArrayAdapter<String>(rootView.getContext(), android.R.layout.simple_list_item_1, spells);

        spellList.setAdapter(itemsAdapter);

        btnAddSpells.setOnClickListener(new View.OnClickListener()
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


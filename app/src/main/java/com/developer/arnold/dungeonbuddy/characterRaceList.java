package com.developer.arnold.dungeonbuddy;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

public class characterRaceList extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_race_list);

        ListView listview = (ListView) findViewById(R.id.lstCharacterRace);
        listview.setAdapter(new raceListAdapter(this, new String[] { "Dwarf", "Human", "Tiefling" }));
    }

}

class raceListAdapter extends BaseAdapter {

    Context context;
    String[] data;
    private static LayoutInflater inflater = null;

    public raceListAdapter(Context context, String[] data) {
        // TODO Auto-generated constructor stub
        this.context = context;
        this.data = data;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return data.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return data[position];
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View vi;
        vi = convertView;
        if (vi == null)
            vi = inflater.inflate(R.layout.list_view_item, null);

        Button btnMoreInfo = (Button) vi.findViewById(R.id.btnMoreRaceInfo);

        btnMoreInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, raceInfo.class);
                intent.putExtra("raceExtraInfoNum", position);
                context.startActivity(intent);
            }
        });

        RadioButton raceName = (RadioButton) vi.findViewById(R.id.radioRace);
        raceName.setText(data[position]);

        return vi;
    }
}

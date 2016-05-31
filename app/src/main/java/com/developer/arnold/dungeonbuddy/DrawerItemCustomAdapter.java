package com.developer.arnold.dungeonbuddy;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * @author      Arnold Goncharenko
 *
 * A class designed to be used as a custom adapter with a drawer.
 */
public class DrawerItemCustomAdapter extends ArrayAdapter<ObjectDrawerItem> {

    //block of code that is used to store the context of the drawer, the ID, and the data that it will contain.
    Context drawerContext;
    int layoutResourceId;
    ObjectDrawerItem data[] = null;

    /**
     * constructor that is used to create a adapter to be used with the drawer.
     *
     * @param drawerContext     contains the context where the drawer is located.
     * @param layoutResourceId  contains the ID of the drawer.
     * @param data              contains the data that will be added to the adapter.
     */
    public DrawerItemCustomAdapter(Context drawerContext, int layoutResourceId, ObjectDrawerItem[] data) {

        //creates the drawer object.
        super(drawerContext, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.drawerContext = drawerContext;
        this.data = data;
    }

    /**
     * function that is used to the get the list item that the drawer is on.
     *
     * @param position     contains the position of the view.
     * @param convertView  contains a reference to the view.
     * @param parent       contains the parent of the view.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //block of code that generates
        //a list item based on the view that was inflated.
        View listItem = convertView;

        LayoutInflater inflater = ((Activity) drawerContext).getLayoutInflater();
        listItem = inflater.inflate(layoutResourceId, parent, false);

        TextView textViewName = (TextView) listItem.findViewById(R.id.textViewName);

        ObjectDrawerItem folder = data[position];

        textViewName.setText(folder.name);

        return listItem;
    }

}
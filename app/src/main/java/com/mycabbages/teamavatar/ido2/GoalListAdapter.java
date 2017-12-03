package com.mycabbages.teamavatar.ido2;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by Conrad on 12/2/2017.
 */

public class GoalListAdapter extends ArrayAdapter<Goal>{


    public GoalListAdapter(@NonNull Context context, Goal data[]) {
        super(context, R.layout.goal_view, data);

    }

    @Override
    public View getView(int postition, View convertView, ViewGroup parent){

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View customView = inflater.inflate(R.layout.goal_view, parent, false);

        // object item based on the position
        //Goal goal = data[position];
        // get the TextView and then set the text (item name) and tag (item ID) values

//        TextView textViewItem = (TextView) convertView.findViewById(R.id.textViewItem);
//        textViewItem.setText(objectItem.itemName);
//        textViewItem.setTag(objectItem.itemId);

        Goal goals = getItem(postition);
        //TextView

        return convertView;

    }
}

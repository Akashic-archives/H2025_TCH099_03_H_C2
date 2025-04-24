package com.example.liarschess.Adapters;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.liarschess.Entity.Game;
import com.example.liarschess.R;

import java.util.List;

public class HistoryGameListAdapter extends ArrayAdapter<Game> {
    private List<Game> gameHistoryList;

    private Context context;
    private int viewResourceID;

    private Resources resources;

    public HistoryGameListAdapter(@NonNull Context context, int viewResourceID, @NonNull List<Game> gameHistoryList){
        super(context, viewResourceID, gameHistoryList);
        this.context = context;
        this.viewResourceID = viewResourceID;
        this.resources = context.getResources();
        this.gameHistoryList = gameHistoryList;
    }
    @Override
    public int getCount(){ return this.gameHistoryList.size();}

    @NonNull
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){

        View view = convertView;

        if(view == null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(this.viewResourceID,parent,false);
        }

        final Game game = this.gameHistoryList.get(position);

        if(game != null){
            final TextView whiteid = (TextView) view.findViewById(R.id.whitename);
            final TextView blackid = (TextView) view.findViewById(R.id.blackname);
            final ImageView whiteking = (ImageView)  view.findViewById(R.id.whiteking);
            final ImageView blackking = (ImageView)  view.findViewById(R.id.blackking);

            whiteid.setText(game.getWhiteplayer());
            blackid.setText(game.getBlackplayer());





        }
        return view;
    }

}

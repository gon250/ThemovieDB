package gdg.spanish.themoviedb.Holders;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import gdg.spanish.themoviedb.R;


public class ViewHolderSerieMovie extends RecyclerView.ViewHolder {

    public TextView name;
    public TextView description;

    public ViewHolderSerieMovie(LayoutInflater inflater, ViewGroup parent) {
        super(inflater.inflate(R.layout.item_card, parent, false));

        name = (TextView) itemView.findViewById(R.id.card_title);
        description = (TextView) itemView.findViewById(R.id.card_text);

    }
}

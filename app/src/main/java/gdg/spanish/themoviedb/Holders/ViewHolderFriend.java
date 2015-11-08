package gdg.spanish.themoviedb.Holders;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import gdg.spanish.themoviedb.R;


public class ViewHolderFriend extends RecyclerView.ViewHolder  {

    public TextView name;
    public TextView likes;
    public TextView dislikes;

    public ViewHolderFriend(LayoutInflater inflater, ViewGroup parent) {
        super(inflater.inflate(R.layout.user_item, parent, false));

        name = (TextView) itemView.findViewById(R.id.user_name_text);
        likes = (TextView) itemView.findViewById(R.id.number_of_likes);
        dislikes = (TextView) itemView.findViewById(R.id.number_of_dislikes);

    }
}

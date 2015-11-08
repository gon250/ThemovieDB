package gdg.spanish.themoviedb.Adapters;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;

import gdg.spanish.themoviedb.Holders.ViewHolderFriend;

public class FriendAdapter extends RecyclerView.Adapter<ViewHolderFriend> {

    private ArrayList<String> result;

    public FriendAdapter(ArrayList list) {
        this.result = list;
    }

    public FriendAdapter() {
        this.result = null;
    }

    @Override
    public ViewHolderFriend onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolderFriend(LayoutInflater.from(parent.getContext()), parent);
    }

    @Override
    public void onBindViewHolder(ViewHolderFriend holder, int position) {
        //String item = result.get(position);

        //TODO: Set data comming from result
        //holder.headerImage =
        //holder.title.setText(item.getString("titleDev"));
        //holder.user.setText(item.getString("createdByDev"));
    }

    @Override
    public int getItemCount() {
        if (result != null) {
            return result.size();
        }
        return 1;
    }
}
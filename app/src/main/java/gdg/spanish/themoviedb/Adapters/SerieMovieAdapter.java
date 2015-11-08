package gdg.spanish.themoviedb.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;

import gdg.spanish.themoviedb.Holders.ViewHolderSerieMovie;


public class SerieMovieAdapter extends RecyclerView.Adapter<ViewHolderSerieMovie>{

    private ArrayList<String> result;

    public SerieMovieAdapter (ArrayList list){
        this.result = list;
    }

    public SerieMovieAdapter(){
        this.result = null;
    }

    @Override
    public ViewHolderSerieMovie onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolderSerieMovie(LayoutInflater.from(parent.getContext()), parent);
    }

    @Override
    public void onBindViewHolder(ViewHolderSerieMovie holder, int position) {
        String item = result.get(position);

            //TODO: Set data comming from result
            //holder.headerImage =
            //holder.title.setText(item.getString("titleDev"));
            //holder.user.setText(item.getString("createdByDev"));
    }

    @Override
    public int getItemCount() {
        if(result != null){
            return result.size();
        }
        return 1;
    }
}


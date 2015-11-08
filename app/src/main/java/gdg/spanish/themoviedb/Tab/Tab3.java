package gdg.spanish.themoviedb.Tab;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import gdg.spanish.themoviedb.Adapters.SerieMovieAdapter;
import gdg.spanish.themoviedb.R;

public class Tab3 extends Fragment {

    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        recyclerView = (RecyclerView) inflater.inflate(R.layout.recycler_view_tab, container, false);

        //TODO: Get DATA
        SerieMovieAdapter adapter = new SerieMovieAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return recyclerView;
    }

}

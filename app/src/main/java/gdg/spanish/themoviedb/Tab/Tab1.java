package gdg.spanish.themoviedb.Tab;


import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import gdg.spanish.themoviedb.LoginActivity;
import gdg.spanish.themoviedb.R;

public class Tab1 extends Fragment {

    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.tab_1,container,false);

        final Firebase ref = new Firebase("https://intense-fire-6233.firebaseio.com/usersLists/"+LoginActivity.UID+"/followers/");

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
               


            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        return v;

        /*
        recyclerView = (RecyclerView) inflater.inflate(R.layout.recycler_view_tab, container, false);

        //TODO: Implement content

        return recyclerView;
        */
    }

}


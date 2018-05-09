package pl.org.sh.portalharcerza.Fragments;


import android.content.Context;
import android.database.SQLException;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.IOException;

import pl.org.sh.portalharcerza.DataBaseHelper;
import pl.org.sh.portalharcerza.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    public DataBaseHelper myDbHelper;

    public MainFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
        //myDbHelper = new DataBaseHelper(getActivity());



    }




}

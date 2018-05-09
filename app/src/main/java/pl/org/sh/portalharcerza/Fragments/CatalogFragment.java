package pl.org.sh.portalharcerza.Fragments;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.ButtonBarLayout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import pl.org.sh.portalharcerza.Adapters.ExpListVievAdapter;
import pl.org.sh.portalharcerza.DataBaseHelper;
import pl.org.sh.portalharcerza.DetailActivity;
import pl.org.sh.portalharcerza.HomeActivity;
import pl.org.sh.portalharcerza.RegisterActivity;
import pl.org.sh.portalharcerza.SprawnoscCzysta;
import pl.org.sh.portalharcerza.R;


public class CatalogFragment extends Fragment {

    View v;
    DataBaseHelper db_helper;
    private HashMap<String, List<SprawnoscCzysta>> hash_map;
    private List<String> kategorie_list;
    private ExpandableListView Exp_list;
    private ExpListVievAdapter adapter;

    public CatalogFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        v = inflater.inflate(R.layout.fragment_catalog, container, false);
        db_helper = new DataBaseHelper(getActivity());
        Exp_list = v.findViewById(R.id.exp_list);
        hash_map = getCatalogData();
        adapter = new ExpListVievAdapter(getActivity(), hash_map, kategorie_list);
        Exp_list.setAdapter(adapter);

        Exp_list.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id)
            {
                final SprawnoscCzysta sprawnosc = getItemFromDB(groupPosition,childPosition);

                String child_title = sprawnosc.getNazwa();
                int child_lvl = sprawnosc.getPoziom();
                String child_level;
                switch (child_lvl){
                    case 1: child_level = "*";
                        break;
                    case 2: child_level = "**";
                        break;
                    case 3: child_level = "***";
                        break;
                    case 4: child_level = "M";
                        break;
                    default:child_level = "?";
                        break;
                }
                final String child_label = child_title + " " + child_level;

                Context context = getActivity();
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);
                View mView = inflater.inflate(R.layout.dialog_layout,null);
                TextView Label = mView.findViewById(R.id.DialogNazwa);
                Label.setText(child_label);

                int licznik = 0;
                while(true) {
                    TextView W1 = mView.findViewById(R.id.wym1);
                    W1.setText((String)sprawnosc.getWymagania().get(0));
                    W1.setVisibility(View.VISIBLE);
                    View d1 = mView.findViewById(R.id.divider1);
                    d1.setVisibility(View.VISIBLE);
                    licznik++;
                    if (licznik==sprawnosc.getWymagania().size())
                        break;

                    TextView W2 = mView.findViewById(R.id.wym2);
                    W2.setText((String)sprawnosc.getWymagania().get(1));
                    licznik++;
                    W2.setVisibility(View.VISIBLE);
                    View d2 = mView.findViewById(R.id.divider2);
                    d2.setVisibility(View.VISIBLE);
                    if (licznik==sprawnosc.getWymagania().size())
                        break;

                    TextView W3 = mView.findViewById(R.id.wym3);
                    W3.setText((String)sprawnosc.getWymagania().get(2));
                    W3.setVisibility(View.VISIBLE);
                    View d3 = mView.findViewById(R.id.divider3);
                    d3.setVisibility(View.VISIBLE);
                    licznik++;
                    if (licznik==sprawnosc.getWymagania().size())
                        break;

                    TextView W4 = mView.findViewById(R.id.wym4);
                    W4.setText((String)sprawnosc.getWymagania().get(3));
                    W4.setVisibility(View.VISIBLE);
                    View d4 = mView.findViewById(R.id.divider4);
                    d4.setVisibility(View.VISIBLE);
                    licznik++;
                    if (licznik==sprawnosc.getWymagania().size())
                        break;

                    TextView W5 = mView.findViewById(R.id.wym5);
                    W5.setText((String)sprawnosc.getWymagania().get(4));
                    W5.setVisibility(View.VISIBLE);
                    View d5 = mView.findViewById(R.id.divider5);
                    d5.setVisibility(View.VISIBLE);
                    licznik++;
                    if (licznik==sprawnosc.getWymagania().size())
                        break;

                    TextView W6 = mView.findViewById(R.id.wym6);
                    W6.setText((String)sprawnosc.getWymagania().get(5));
                    W6.setVisibility(View.VISIBLE);
                    View d6 = mView.findViewById(R.id.divider6);
                    d6.setVisibility(View.VISIBLE);
                    licznik++;
                    if (licznik==sprawnosc.getWymagania().size())
                        break;

                    TextView W7 = mView.findViewById(R.id.wym7);
                    W7.setText((String)sprawnosc.getWymagania().get(6));
                    W7.setVisibility(View.VISIBLE);
                    View d7 = mView.findViewById(R.id.divider7);
                    d7.setVisibility(View.VISIBLE);
                    licznik++;
                    if (licznik==sprawnosc.getWymagania().size())
                        break;

                    TextView W8 = mView.findViewById(R.id.wym8);
                    W8.setText((String)sprawnosc.getWymagania().get(7));
                    W8.setVisibility(View.VISIBLE);
                    View d8 = mView.findViewById(R.id.divider8);
                    d8.setVisibility(View.VISIBLE);
                    licznik++;
                    if (licznik==sprawnosc.getWymagania().size())
                        break;

                    TextView W9 = mView.findViewById(R.id.wym9);
                    W9.setText((String)sprawnosc.getWymagania().get(8));
                    W9.setVisibility(View.VISIBLE);
                    View d9 = mView.findViewById(R.id.divider9);
                    d9.setVisibility(View.VISIBLE);
                    licznik++;
                    if (licznik==sprawnosc.getWymagania().size())
                        break;

                    TextView W10 = mView.findViewById(R.id.wym10);
                    W10.setText((String)sprawnosc.getWymagania().get(9));
                    W10.setVisibility(View.VISIBLE);
                    licznik++;
                    if (licznik==sprawnosc.getWymagania().size())
                        break;
                }
                Button rozpisz_btn = mView.findViewById(R.id.btn_rozpisz);
                Button wstecz_btn = mView.findViewById(R.id.btn_wstecz);

                alertDialog.setView(mView);
                final AlertDialog dialog = alertDialog.create();
                dialog.show();

                wstecz_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.cancel();
                    }
                });

                rozpisz_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.cancel();
                        Intent intent = new Intent(getActivity(), DetailActivity.class);
                        Bundle b = new Bundle();
                        String arg = "rozpisz";
                        // "rozpisz" - rozpisywana nowa sprawnosc
                        // "wyswietl" - sprawdzenie stan zdobytej lub zdobywanej
                        // "zmien" - edycja rozpisanej lub zdobytej sprawnosci
                        ArrayList <String> params = new ArrayList<String>();
                        params.add(child_label);
                        for (int i=0; i<sprawnosc.getWymagania().size(); i++)
                            params.add((String)sprawnosc.getWymagania().get(i));
                        b.putStringArrayList("wymagania",params);
                        b.putString("mode",arg);
                        intent.putExtras(b);
                        startActivity(intent);
                    }
                });
                return false;
                }
            }
        );
        return v;
    }

    public SprawnoscCzysta getItemFromDB (int gr, int ch){

        Cursor Data = db_helper.getItemByName(adapter.getChild(gr,ch).getNazwa());
        Data.moveToFirst();
        SprawnoscCzysta spr = new SprawnoscCzysta();

        spr.setNazwa(Data.getString(0));
        spr.setKategoria(Data.getString(1));
        spr.setPoziom(Data.getInt(2));
        List<String> wymagania = new ArrayList<>();
        for (int i=3; i<13; i++) {
            if (Data.getString(i) != null)
            {
                String lp = Integer.toString(i-2);
                wymagania.add(lp+". "+Data.getString(i));
            }
        }
        spr.setWymagania(wymagania);

        return spr;
    }

    public HashMap<String, List<SprawnoscCzysta>> getCatalogData()
    {
        HashMap<String, List<SprawnoscCzysta>>hashMapfromMemory = new HashMap<>();
        kategorie_list = new ArrayList<>(); // group list
        List <SprawnoscCzysta> lista = new ArrayList<>(); //actual child list
        Cursor Data = db_helper.getAllCatalogData();
        Data.moveToFirst();
        SprawnoscCzysta child =  new SprawnoscCzysta(Data.getString(0),Data.getString(1), Data.getInt(2),null);
        String kategoria = Data.getString(1);
        lista.add(child);
        while (Data.moveToNext())
        {
            if(Data.getString(1).equals(kategoria))
            {
                child =  new SprawnoscCzysta(Data.getString(0),Data.getString(1), Data.getInt(2),null);
                lista.add(child);
            }
            else
            {
                hashMapfromMemory.put(kategoria, lista);
                kategorie_list.add(kategoria);
                lista = new ArrayList<>();
                child =  new SprawnoscCzysta(Data.getString(0),Data.getString(1), Data.getInt(2),null);
                lista.add(child);
                kategoria = Data.getString(1);
            }
        }
        return hashMapfromMemory;
    }
}
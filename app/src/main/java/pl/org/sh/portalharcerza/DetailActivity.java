package pl.org.sh.portalharcerza;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.Toolbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import pl.org.sh.portalharcerza.Fragments.CatalogFragment;

public class DetailActivity extends AppCompatActivity {

    // Data from DB
    private List <String> Wymagania;
    private List <String> Zadania;
    private List <Integer> Realizacja;
    // Widgets objects
    private List <EditText> zad;
    private List <CheckBox> real;
    private String mode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        zad = new ArrayList<>();
        real = new ArrayList<>();

        // Get Activity parameters
        mode = getIntent().getExtras().getString("mode");
        Wymagania = new ArrayList<>();
        Wymagania = getIntent().getExtras().getStringArrayList("wymagania");

        // Show the Up button in the action bar.
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(Wymagania.get(0));
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        // Set table rows
        for (int i=1; i<Wymagania.size(); i++)
        {
            String RowID = "row_" + i;
            int rowID = getResources().getIdentifier(RowID, "id", getPackageName());
            TableRow row = (TableRow) findViewById(rowID);
            row.setVisibility(View.VISIBLE);

            String TextID = "text" + i + "_1";
            int textID = getResources().getIdentifier(TextID, "id", getPackageName());
            TextView my_text = (TextView) findViewById(textID);
            my_text.setText(Wymagania.get(i));

            String EditID = "text" + i + "_2";
            int editID = getResources().getIdentifier(EditID, "id", getPackageName());
            EditText my_edit = (EditText) findViewById(editID);
            zad.add(my_edit);

            String ChboxID = "chbox" + i + "_3";
            int chboxID = getResources().getIdentifier(ChboxID, "id", getPackageName());
            CheckBox my_chbox = (CheckBox) findViewById(chboxID);
            real.add(my_chbox);
        }

        EditText otwarcie = (EditText)findViewById(R.id.edit_data_otw);
        EditText zamkniecie = (EditText)findViewById(R.id.edit_data_zamk);
        TableLayout tabel = (TableLayout)findViewById(R.id.table1);
        Button btn = (Button) findViewById(R.id.OK_btn);

        if(mode.equals("rozpisz"))
        {
            btn.setText("ROZPISZ SPRAWNOSC");
        }

        if(mode.equals("wyswietl"))
        {
            for (int i=0; i<zad.size(); i++)
            {
                zad.get(i).setText("Coś z bazy"+i);
                zad.get(i).setEnabled(false);
            }
            // pobierze z bazy danych rozpisaną sprawnosc i zablokuj mozliwosc edycji zadan i dat
        }

        if(mode.equals("zmien"))
        {
            btn.setText("ZATWIERDŻ");
           // odswiez activity i odblokuj mozliwosc edycji
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mode.equals("rozpisz"))
                {
                   // zapisz zadania, daty i realizacje do bazy danych
                }

                if(mode.equals("wyswietl"))
                {
                    // zapisz rezlizacje do bazy danych i wyjdz
                }

                if(mode.equals("zmien"))
                {
                    // zapisz zmiany do bazy danych
                }
            }
        });

        otwarcie.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hideKeyboard(v);
                }
            }
        });

        zamkniecie.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hideKeyboard(v);
                }
            }
        });
        // powtorzyc kilka razy
        zad.get(0).setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hideKeyboard(v);
                }
            }
        });
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            // This ID represents the Home or Up button. In the case of this
            // activity, the Up button is shown. For
            // more details, see the Navigation pattern on Android Design:
            //
            // http://developer.android.com/design/patterns/navigation.html#up-vs-back
            //
            navigateUpTo(new Intent(this, CatalogFragment.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager =(InputMethodManager)getSystemService(RegisterActivity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
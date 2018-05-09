package pl.org.sh.portalharcerza;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // ------------- Declarations --------------
        Context context = getApplicationContext();
        sharedPref = context.getSharedPreferences("PORTAL_HARCERZA", Context.MODE_PRIVATE);

        final Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.szczep_array, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);

        final Spinner spinner3 = (Spinner) findViewById(R.id.spinner3);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.stopnie_array, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter3);

        final EditText etAge = (EditText) findViewById(R.id.text_age);
        final EditText etName = (EditText) findViewById(R.id.text_name);
        final EditText etSurname = (EditText) findViewById(R.id.text_surname);
        final EditText etEmail = (EditText) findViewById(R.id.text_email);
        final EditText etDruz = (EditText) findViewById(R.id.text_druz);
        final Button bRegister = (Button) findViewById(R.id.button_dalej);

        etAge.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hideKeyboard(v);
                }
            }
        });

        etName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hideKeyboard(v);
                }
            }
        });

        etSurname.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hideKeyboard(v);
                }
            }
        });

        etEmail.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hideKeyboard(v);
                }
            }
        });

        etDruz.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hideKeyboard(v);
                }
            }
        });

        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String name = etName.getText().toString();
                if (TextUtils.isEmpty(name)) {
                    etName.setError("Podaj imię");
                    return;
                }
                final String surname = etSurname.getText().toString();
                if (TextUtils.isEmpty(surname)) {
                    etSurname.setError("Podaj Nazwisko");
                    return;
                }
                final String email = etEmail.getText().toString();
                final String age = etAge.getText().toString();
                if (TextUtils.isEmpty(age)) {
                    etAge.setError("Podaj wiek");
                    return;
                }
                final String druz = etDruz.getText().toString();
                if (TextUtils.isEmpty(druz)) {
                    etDruz.setError("Z jakiej drużyny jesteś?");
                    return;
                }
                final String szczep = spinner2.getSelectedItem().toString();
                final String stopien = spinner3.getSelectedItem().toString();

                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("Imię", name);
                editor.putInt("Wiek", Integer.parseInt(age));
                editor.putString("Nazwisko", surname);
                editor.putString("Email", email);
                editor.putString("Drużyna", druz);
                editor.putString("Szczep", szczep);
                editor.putString("Stopien", stopien);
                editor.apply();

                Intent homeIntent = new Intent(RegisterActivity.this, HomeActivity.class);
                startActivity(homeIntent);
                finish();
            }
        });
    }

    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager =(InputMethodManager)getSystemService(RegisterActivity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
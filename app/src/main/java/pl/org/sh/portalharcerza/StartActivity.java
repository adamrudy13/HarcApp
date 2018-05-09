package pl.org.sh.portalharcerza;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

public class StartActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 3000;
    SharedPreferences sharedPref;
    boolean new_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_start);

        Context context = getApplicationContext();
        sharedPref = context.getSharedPreferences("PORTAL_HARCERZA", Context.MODE_PRIVATE);
        // to zakomentowac
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.remove("Imię");
        editor.apply();
        //
        new_user =! sharedPref.contains("Imię");

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if(new_user) {
                    Intent intent = new Intent(StartActivity.this, RegisterActivity.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    Intent homeIntent = new Intent(StartActivity.this, HomeActivity.class);
                    startActivity(homeIntent);
                    finish();
                }
            }
        },SPLASH_TIME_OUT);
    }
}

package pt.unl.fct.di.landcommunity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button loginButtonMenu;
    Button registerButtonMenu;
    Button aboutUsMenu;
    Button contactUsMenu;
    Button termsConditionsMenu;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // Get buttons
        loginButtonMenu = (Button) findViewById(R.id.btn_loginMenu);
        registerButtonMenu = (Button) findViewById(R.id.btn_registerMenu);
        aboutUsMenu = (Button) findViewById(R.id.btn_aboutUsMenu);
        contactUsMenu = (Button) findViewById(R.id.btn_contactsMenu);
        termsConditionsMenu = (Button) findViewById(R.id.btn_termsAndConditions);

        loginButtonMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, LoginActivity.class)); // Main --> Login
            }
        });

        registerButtonMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, RegisterActivity.class)); // Main --> Register
            }
        });

        aboutUsMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // About Us --> About Us Website (Maybe later needs change)
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://projeto-adc-349323.appspot.com/about/about.html")));
            }
        });

        contactUsMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            // Contact Us --> Contact Us Website (Maybe later needs change)
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://projeto-adc-349323.appspot.com/contacts/contact.html")));
            }
        });

        termsConditionsMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                https://policies.google.com/terms?hl=en
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://policies.google.com/terms?hl=en")));
            }
        });
    }
}

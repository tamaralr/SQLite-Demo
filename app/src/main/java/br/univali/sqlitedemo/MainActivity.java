package br.univali.sqlitedemo;


import java.util.List;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHandler db = new DatabaseHandler(MainActivity.this);

                /**
                 * CRUD Operations
                 * */

                // Inserting Contacts
                Log.d("Inserir: ", "Inserindo ..");
                db.addContact(new Contact("José", "9100000000"));
                db.addContact(new Contact("Celeste", "9199999999"));
                db.addContact(new Contact("Creisson", "9522222222"));
                db.addContact(new Contact("Josemir", "9533333333"));

                // Reading all contacts
                Log.d("Lendo: ", "Lendo os contatos");
                List<Contact> contacts = db.getAllContacts();

                for (Contact cn : contacts) {
                    String log = "Id: "+cn.getID()+" ,Nome: " + cn.getName() + " ,Fone: " + cn.getPhoneNumber();
                    // Writing Contacts to log
                    Log.d("Nome: ", log);
                }
                TextView TVWarning = (TextView) findViewById(R.id.TextViewWarning);
                TVWarning.setText("Dados inseridos com sucesso! Consulte o LogCat");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

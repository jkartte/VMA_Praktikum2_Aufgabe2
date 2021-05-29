// Programmierung verteilter und mobiler Anwendungen
// Prof. Dr. Carsten Vogt
// Technische Hochschule Köln
// Fakultät für Informations-, Medien- und Elektrotechnik
// Stand: 26.7.2016

// Demonstration der verschiedenen Arten von Menus und der App Bar.

// Video dazu: https://www.youtube.com/watch?v=Qrb20oa1AtI

package de.thkoeln.cvogt.android.menus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends Activity {

    private TextView operanden;
    private EditText operand1;
    private EditText operand2;
    private TextView rechne;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        operanden = (TextView) findViewById(R.id.operand);
        operand1 = (EditText) findViewById(R.id.operand1);
        operand2 = (EditText) findViewById(R.id.operand2);
        rechne = (TextView) findViewById(R.id.rechne);

        //Kontextmenü
        registerForContextMenu(findViewById(R.id.rechne));
    }

    //Optionsmenü
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater mi = new MenuInflater(this);
        mi.inflate(R.menu.optionsmenu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (operand1.getText().length() == 0 || operand2.getText().length() == 0) {
            Toast.makeText(MainActivity.this, "Falsche Eingabe!", Toast.LENGTH_SHORT).show();
        }
        else {
            double eingabe1 = Double.parseDouble(operand1.getText().toString());
            double eingabe2 = Double.parseDouble(operand2.getText().toString());
            double ergebnis = 0.0;
            String operator = "";


            if (item.getItemId() == R.id.op_addition) {
                ergebnis = eingabe1 + eingabe2;
                operator = " + ";
            }
            if (item.getItemId() == R.id.op_multiplikation) {
                ergebnis = eingabe1 * eingabe2;
                operator = " * ";
            }
            if (item.getItemId() == R.id.op_subtraktion) {
                ergebnis = eingabe1 - eingabe2;
                operator = " - ";
            }
            String ausgabe = eingabe1 + operator + eingabe2 + " = " + ergebnis;
            Toast.makeText(MainActivity.this, ausgabe, Toast.LENGTH_SHORT).show();
        }
        return true;
    }


    //Kontextmenü
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo info) {
        super.onCreateContextMenu(menu,v,info);
        MenuInflater mi = new MenuInflater(this);
        mi.inflate(R.menu.kontextmenu, menu);
    }

    public boolean onContextItemSelected(MenuItem item) {
        if (operand1.getText().length() == 0 || operand2.getText().length() == 0) {
            Toast.makeText(MainActivity.this, "Falsche Eingabe!", Toast.LENGTH_SHORT).show();
        }
        else {
            double eingabe1 = Double.parseDouble(operand1.getText().toString());
            double eingabe2 = Double.parseDouble(operand2.getText().toString());
            double ergebnis = 0.0;
            String operator = "";

            if (item.getItemId() == R.id.addition) {
                ergebnis = eingabe1 + eingabe2;
                operator = " + ";
            }
            if (item.getItemId() == R.id.multiplikation) {
                ergebnis = eingabe1 * eingabe2;
                operator = " * ";
            }
            String ausgabe = eingabe1 + operator + eingabe2 + " = " + ergebnis;
            Toast.makeText(MainActivity.this, ausgabe, Toast.LENGTH_SHORT).show();
        }
        return true;
    }

}
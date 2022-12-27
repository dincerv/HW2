package com.dincervelioglu.hw2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.dincervelioglu.hw2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    TextView tvSpin;
    Spinner spGym;
    SpinnerAdapter spinnerAdapter;

    boolean isDefaultSelected = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Hiding title bar using code
        getSupportActionBar().hide();
        // Hiding the status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);
        tvSpin = findViewById(R.id.txtSpin);
        spGym = findViewById(R.id.spinPlaces);

        GymSys.prepareData();

        spinnerAdapter = new com.dincervelioglu.hw2.SpinnerAdapter(getBaseContext(), R.layout.gymspinner_layout, GymSys.getGym());

        spGym.setAdapter(spinnerAdapter);
        spGym.setSelection(0, false);
        spGym.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override

            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                int selectedItem = spGym.getSelectedItemPosition();

                Gym gm = GymSys.getItem(selectedItem);
                Bundle b = new Bundle();
                b.putParcelable("Object", gm);
                intent.putExtras(b);
                startActivity(intent);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
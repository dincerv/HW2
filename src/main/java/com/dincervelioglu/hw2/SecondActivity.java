package com.dincervelioglu.hw2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.dincervelioglu.hw2.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {

    Intent intent;
    Gym gm = null;

    Dialog customDialog;
    TextView tvDialogTitle,txtDialogEquipment;
    Button btnDialogClose, btnGame;
    ImageView imgDialogGym;

    ActivitySecondBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Hiding title bar using code
        getSupportActionBar().hide();
        // Hiding the status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        binding = ActivitySecondBinding.inflate(getLayoutInflater());
        View view= binding.getRoot();
        setContentView(view);

        intent = getIntent();
        Bundle b = intent.getExtras();

        gm = b.getParcelable("Object");
        binding.txtGymExerciseName.setText("Exercise"+"\n"+gm.getName());
        binding.txtPlace.setText(""+gm.getName());
        binding.imgMuseum.setImageResource(gm.getImgId());

        createDailog();

        binding.btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customDialog.show();
            }

        });

    }
    public void GestureGame() {
        Intent intent = new Intent(this, GestureGame.class);
        startActivity(intent);
    }

    public void createDailog(){
        customDialog = new Dialog(this);
        customDialog.setContentView(R.layout.dialog);

        tvDialogTitle = customDialog.findViewById(R.id.tvDialogTitle);
        txtDialogEquipment  = customDialog.findViewById(R.id.txtDialogEquipment);
        imgDialogGym = customDialog.findViewById(R.id.imgDialogGym);
        btnDialogClose = customDialog.findViewById(R.id.btnDialogClose);
        btnGame = customDialog.findViewById(R.id.button);

        btnGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GestureGame();
            }
        });

        tvDialogTitle.setText(""+gm.getName());
        txtDialogEquipment.setText("Equipment\n "+gm.getEquipment());
        imgDialogGym.setImageResource(gm.getImgId());

        btnDialogClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customDialog.dismiss();
            }
        });
    }
}
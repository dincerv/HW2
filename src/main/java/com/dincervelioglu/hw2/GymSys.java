package com.dincervelioglu.hw2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Collections;

public class GymSys {
    public static ArrayList<Gym> gymExercises = new ArrayList<>();

    public static void prepareData(){
        Collections.addAll(gymExercises,
                new Gym(0,"Exercises","Bench-Barbell", R.drawable.gym),
                new Gym(1,"Bench Press","Bench-Barbell", R.drawable.chest),
                new Gym(2,"Biceps","Dumbell", R.drawable.biceps),
                new Gym(3,"Triceps","Dumbell", R.drawable.triceps),
                new Gym(4,"Shoulders","Dumbell", R.drawable.shoulders),
                new Gym(5,"Back","Dumbell", R.drawable.back),
                new Gym(6,"Legs","Barbell", R.drawable.leg)
        );
    }

    public static ArrayList<Gym> getGym() {

        return gymExercises;
    }

    public static Gym getItem(int selectedPos) {

        return gymExercises.get(selectedPos);
    }

}
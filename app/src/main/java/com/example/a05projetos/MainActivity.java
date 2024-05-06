package com.example.a05projetos;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerDice, spinnerNumberOfDice;
    private Button buttonRoll;
    private TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerDice = findViewById(R.id.spinnerDice);
        spinnerNumberOfDice = findViewById(R.id.spinnerNumberOfDice);
        buttonRoll = findViewById(R.id.buttonRoll);
        textResult = findViewById(R.id.textResult);

        ArrayAdapter<CharSequence> diceAdapter = ArrayAdapter.createFromResource(this,
                R.array.dice_types, android.R.layout.simple_spinner_item);
        diceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDice.setAdapter(diceAdapter);

        ArrayAdapter<CharSequence> numberOfDiceAdapter = ArrayAdapter.createFromResource(this,
                R.array.number_of_dice, android.R.layout.simple_spinner_item);
        numberOfDiceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerNumberOfDice.setAdapter(numberOfDiceAdapter);

        buttonRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice();
            }
        });
    }

    private void rollDice() {
        String selectedDice = spinnerDice.getSelectedItem().toString();
        int numberOfDice = Integer.parseInt(spinnerNumberOfDice.getSelectedItem().toString());

        Random random = new Random();
        StringBuilder result = new StringBuilder();

        switch (selectedDice) {
            case "D4":
                for (int i = 0; i < numberOfDice; i++) {
                    result.append(random.nextInt(4) + 1).append(" ");
                }
                break;
            case "D6":
                for (int i = 0; i < numberOfDice; i++) {
                    result.append(random.nextInt(6) + 1).append(" ");
                }
                break;
            case "D8":
                for (int i = 0; i < numberOfDice; i++) {
                    result.append(random.nextInt(8) + 1).append(" ");
                }
                break;
            case "D10":
                for (int i = 0; i < numberOfDice; i++) {
                    result.append(random.nextInt(10) + 1).append(" ");
                }
                break;
            case "D12":
                for (int i = 0; i < numberOfDice; i++) {
                    result.append(random.nextInt(12) + 1).append(" ");
                }
                break;
            case "D20":
                for (int i = 0; i < numberOfDice; i++) {
                    result.append(random.nextInt(20) + 1).append(" ");
                }
                break;
            case "D100":
                for (int i = 0; i < numberOfDice; i++) {
                    result.append(random.nextInt(100) + 1).append(" ");
                }
                break;
        }

        textResult.setText(result.toString());
    }
}

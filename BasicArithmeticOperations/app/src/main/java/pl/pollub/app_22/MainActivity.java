package pl.pollub.app_22;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText et1,et2;
    TextView tv1;
    Button b1;

    RadioButton rb1,rb2,rb3,rb4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        et1 = findViewById(R.id.editTextText);
        et2 = findViewById(R.id.editTextText2);
        tv1 = findViewById(R.id.textView);
        b1 = findViewById(R.id.button);
        rb1 = findViewById(R.id.radioButton);
        rb2 = findViewById(R.id.radioButton2);
        rb3 = findViewById(R.id.radioButton3);
        rb4 = findViewById(R.id.radioButton4);

    }

    public void Calculate(View v) {
        float a = Float.parseFloat(et1.getText().toString());
        float b = Float.parseFloat(et2.getText().toString());


        try {
            if (rb1.isChecked()) {
                float sum = a + b;
                tv1.setText("Sum : " + sum);
            } else if (rb2.isChecked()) {
                float multip = a * b;
                tv1.setText("Multiplication : " + multip);
            } else if (rb3.isChecked()) {
                float subs = a - b;
                tv1.setText("Substraction : " + subs);
            } else {
                if (b == 0) {
                    throw new ArithmeticException("Division by zero is not allowed.");
                }
                float div = a / b;
                tv1.setText("Division : " + div);
            }
        } catch (ArithmeticException e) {
            tv1.setText("Error: " + e.getMessage());
        }



    }
}
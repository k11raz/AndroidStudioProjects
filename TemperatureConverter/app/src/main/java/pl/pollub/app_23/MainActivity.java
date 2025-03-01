package pl.pollub.app_23;

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

    EditText et1;
    TextView tv1;
    Button b1;
    RadioButton rb1,rb2;

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
        tv1 = findViewById(R.id.textView);
        b1 = findViewById(R.id.button);
        rb1 = findViewById(R.id.radioButton);
        rb2 = findViewById(R.id.radioButton2);
    }

    public void Convert(View v) {
        float temp = Float.parseFloat(et1.getText().toString());

        if (rb1.isChecked()) {
            float f = ((temp * 9) / 5) + 32;
            tv1.setText("Result: " + String.valueOf(f));
        }else {
            float c = ((temp - 32) * 5 ) / 9;
            tv1.setText("Result: " + String.valueOf(c));
        }
    }


}
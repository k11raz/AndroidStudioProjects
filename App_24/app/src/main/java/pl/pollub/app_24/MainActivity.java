package pl.pollub.app_24;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText et1,et2,et3;
    TextView tv1,tv2,tv3,tv4,tv5;

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
        et3 = findViewById(R.id.editTextText3);

        tv1 = findViewById(R.id.textView);
        tv2 = findViewById(R.id.textView2);
        tv3 = findViewById(R.id.textView3);
        tv4 = findViewById(R.id.textView4);
        tv5 = findViewById(R.id.textView5);

    }

    public void Calculate(View v) {
        try {
            float a = Float.parseFloat(et1.getText().toString());
            float b = Float.parseFloat(et2.getText().toString());
            float c = Float.parseFloat(et3.getText().toString());

            // calculate discriminant
            float discriminant = b * b - 4 * a * c;

            // Determine the number of solutions
            if (discriminant > 0) {
                float root1 = (float) ((-b + Math.sqrt(discriminant)) / (2 * a));
                float root2 = (float) ((-b - Math.sqrt(discriminant)) / (2 * a));
                tv4.setText("Two solutions exist:");
                tv5.setText("x1 = " + root1 + ", x2 = " + root2);
            } else if (discriminant == 0) {
                float root = -b / (2 * a);
                tv4.setText("One solution exists:");
                tv5.setText("x = " + root);
            } else {
                tv4.setText("No real solutions exist (Δ < 0).");
                tv5.setText("");
            }

        } catch (NumberFormatException e) {
            tv4.setText("Error: Please enter valid numbers.");
            tv5.setText("");
        }
    }
}
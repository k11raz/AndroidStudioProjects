package pl.pollub.app_41;


import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    private EditText inputTemperature;
    private TextView resultTemperature, conversionType;
    private boolean reverseConversion = false; // Tracks conversion direction
    private String currentConversion = "Celsius to Fahrenheit";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setup Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        inputTemperature = findViewById(R.id.editTextText);
        resultTemperature = findViewById(R.id.textView);
        conversionType = findViewById(R.id.textView2);

        conversionType.setText(currentConversion);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.ctof) {
            currentConversion = "Celsius to Fahrenheit";
            reverseConversion = false;
        } else if (item.getItemId() == R.id.ctok) {
            currentConversion = "Celsius to Kelvin";
            reverseConversion = false;
        } else if (item.getItemId() == R.id.ftoc) {
            currentConversion = "Fahrenheit to Celsius";
            reverseConversion = false;
        } else if (item.getItemId() == R.id.ktoc) {
            currentConversion = "Kelvin to Celsius";
            reverseConversion = false;
        } else if (item.getItemId() == R.id.ktof) {
            currentConversion = "Kelvin to Fahrenheit";
            reverseConversion = false;
        } else if (item.getItemId() == R.id.ftok) {
            currentConversion = "Fahrenheit to Kelvin";
            reverseConversion = false;
        }else if (item.getItemId() == R.id.convertReverse) {
            reverseConversion = !reverseConversion;
            updateConversionType();
            convertTemperature();
        }
        else {
            return super.onOptionsItemSelected(item);
        }
        updateConversionType();
        convertTemperature();
        return true;
    }


    private void updateConversionType() {
        String reversed = reverseConversion ? " (Reversed)" : "";
        conversionType.setText(currentConversion + reversed);
    }

    private void convertTemperature() {
        String input = inputTemperature.getText().toString();
        if (input.isEmpty()) {
            resultTemperature.setText("Please enter a temperature");
            return;
        }

        double temperature = Double.parseDouble(input);
        double converted = 0;

        switch (currentConversion) {
            case "Celsius to Fahrenheit":
                converted = reverseConversion ? (temperature - 32) * 5 / 9 : (temperature * 9 / 5) + 32;
                break;
            case "Celsius to Kelvin":
                converted = reverseConversion ? temperature - 273.15 : temperature + 273.15;
                break;
            case "Fahrenheit to Celsius":
                converted = reverseConversion ? (temperature * 9 / 5) + 32 : (temperature - 32) * 5 / 9;
                break;
            case "Kelvin to Celsius":
                converted = reverseConversion ? temperature + 273.15 : temperature - 273.15;
                break;
            case "Kelvin to Fahrenheit":
                converted = reverseConversion ? (temperature - 32) * 5 / 9 + 273.15 : (temperature - 273.15) * 9 / 5 + 32;
                break;
            case "Fahrenheit to Kelvin":
                converted = reverseConversion ? (temperature - 273.15) * 9 / 5 + 32 : (temperature - 32) * 5 / 9 + 273.15;
                break;
        }

        resultTemperature.setText(String.format("Result: %.2f", converted));
    }
}

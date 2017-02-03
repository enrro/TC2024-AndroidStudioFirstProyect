package mx.itesm.class2friday;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textView2 = (TextView)findViewById(R.id.textView2);

        Intent intent = getIntent();

        textView2.setText(intent.getStringExtra("texto"));

    }

    public void goBack(View v){

        Intent intent = new Intent();
        intent.putExtra("regreso", "MENSAJE DE ACTIVIDAD 2");
        setResult(Activity.RESULT_OK, intent);
        finish();
    }
}

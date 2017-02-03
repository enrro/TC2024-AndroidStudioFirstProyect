package mx.itesm.class2friday;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int MAIN2_REQUEST_CODE = 0;

    private TextView textView;
    private EditText editText;
    private Button button1, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // all widgets extend View
        textView = (TextView)findViewById(R.id.textView);
        editText = (EditText)findViewById(R.id.editText);
        button1 = (Button)findViewById(R.id.button);
        button2 = (Button)findViewById(R.id.button2);

        textView.setText("HEY GUYZ");
        editText.setText("SALU2");
        button1.setText("BUTTON 1");
        button2.setText("BUTTON 2");

        button2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(), "ANONYMOUS CLASS", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // first way to capture a button press
    // a method that can listen to it
    public void exampleClick(View v){

        // Context
        // - a class whose objects contain information about the device
        // - 2 ways to access our current context
        // -- first way - getApplicationContext
        // -- all activities extend Context - therefore you can use this

        Toast t = Toast.makeText(this, "THIS IS A TOAST", Toast.LENGTH_SHORT);
        t.show();

        // in Android we do not order an activity change
        // we kindly request!

        // Intent - object that contains exchange information
        Intent intent = new Intent(this, Main2Activity.class);

        intent.putExtra("texto", editText.getText().toString());

        startActivityForResult(intent, MAIN2_REQUEST_CODE);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){

        // method that listens for an activity ending
        Log.d("MAINACTIVITY", "REQUEST CODE: " + requestCode);
        if(requestCode == MAIN2_REQUEST_CODE && resultCode == Activity.RESULT_OK){

            Toast.makeText(this, data.getStringExtra("regreso"), Toast.LENGTH_SHORT).show();
        }
    }
}

package app.com.tringuyen.dialogexample.improved;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import app.com.tringuyen.dialogexample.R;

public class Improved_dialog extends AppCompatActivity {
    private Button showCustomDialog;
    private TextView textView;
    private EditText inputText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_improved_dialog);
        initialize();
        showCustomDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = inputText.getText().toString();
                inputText.setText("");

                ImprovedDialogFragment dialog = ImprovedDialogFragment.newInstance(text);
                dialog.show(getFragmentManager(),"Tag");
            }
        });
    }
    private void initialize() {
        showCustomDialog = (Button) findViewById(R.id.customeDialogButton);
        textView = (TextView) findViewById(R.id.dialogInfo);
        inputText = (EditText) findViewById(R.id.edit_text_input);
    }
}

package app.com.tringuyen.dialogexample;

import android.app.Dialog;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  implements CustomDialog.NoticeDialogListener {
    private Button showCustomDialog;
    private TextView textView;
    private EditText inputText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();

        showCustomDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = inputText.getText().toString();
                inputText.setText("");
                FragmentManager manager = getSupportFragmentManager();
                CustomDialog dialog = CustomDialog.newInstance(content);
                dialog.show(manager,"fragment_custom_dialog");
            }
        });
    }

    private void initialize() {
        showCustomDialog = (Button) findViewById(R.id.customeDialogButton);
        textView = (TextView) findViewById(R.id.dialogInfo);
        inputText = (EditText) findViewById(R.id.edit_text_input);
    }

    @Override
    public void onDialogPositiveClick(DialogFragment dialog) {
        // edit text from dialog
        EditText editText = (EditText) dialog.getDialog().findViewById(R.id.username);
        textView.setText(editText.getText().toString());
    }
}

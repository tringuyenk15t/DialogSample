package app.com.tringuyen.dialogexample.improved;

import android.app.Dialog;
import android.os.Bundle;

import app.com.tringuyen.dialogexample.R;

/**
 * Created by Tri Nguyen on 11/5/2016.
 * This class is base on Udacity shoppinglist++ structure
 */

public class ImprovedDialogFragment extends BaseDialogFragment {

    private String text;

    /**
     * Public static constructor that creates fragment and passes a bundle with data into it when adapter is created
     */
    public static ImprovedDialogFragment newInstance(String text)
    {
        ImprovedDialogFragment improvedDialogFragment = new ImprovedDialogFragment();
        Bundle bundle = improvedDialogFragment.newInstance(text,R.layout.customized_dialog_layout);
        // we can add more variables than base fragment if necessary
        improvedDialogFragment.setArguments(bundle);
        return improvedDialogFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        text = getArguments().getString("text");
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.createDialogHelper(R.layout.customized_dialog_layout);
        helpSetDefaultValueEditText(text);
        return dialog;
    }

    @Override
    protected void handlebuttonClick() {

    }
}

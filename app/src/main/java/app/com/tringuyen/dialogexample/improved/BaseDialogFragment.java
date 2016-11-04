package app.com.tringuyen.dialogexample.improved;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import app.com.tringuyen.dialogexample.R;

/**
 * Created by Tri Nguyen on 11/5/2016.
 * This class is base on Udacity shoppinglist++ structure
 * this class is made to reuse dialog Fragment
 */

public abstract class BaseDialogFragment extends DialogFragment{
    EditText mEditTextForList;
    int mResource;

    protected static Bundle newInstance(String text, int resource)
    {
        Bundle bundle = new Bundle();
        bundle.putString("text",text);
        bundle.putInt("resource",resource);
        return bundle;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mResource = getArguments().getInt("resource");
    }

    protected Dialog createDialogHelper(int stringResourceForPositiveButton)
    {
        /* Use the Builder class for convenient dialog construction */
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        /* Get the layout inflater */
        LayoutInflater inflater = getActivity().getLayoutInflater();

        /* Inflate the layout, set root ViewGroup to null*/
        View rootView = inflater.inflate(mResource, null);
        mEditTextForList = (EditText) rootView.findViewById(R.id.username);

        builder.setView(rootView)
        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                handlebuttonClick();
            }
        })
        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        })
        .setTitle("This is title");

        return builder.create();
    }

    protected void helpSetDefaultValueEditText(String defaultText) {
        mEditTextForList.setText(defaultText);
        mEditTextForList.setSelection(defaultText.length());
    }

    /**
     * Method to be overriden with when handling positive button
     */
    protected abstract void handlebuttonClick();
}

package app.com.tringuyen.dialogexample;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v4.app.DialogFragment;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Tri Nguyen on 10/16/2016.
 */

public class CustomDialog extends DialogFragment {

    private String titleText;
    private NoticeDialogListener mListener;
    private EditText tv_name;

    private LayoutInflater inflater;
    private View v;

    public static CustomDialog newInstance(String text)
    {
        CustomDialog customDialog = new CustomDialog();
        Bundle bundle = new Bundle();
        bundle.putString("Data",text);
        customDialog.setArguments(bundle);
        return customDialog;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.titleText = getArguments().getString("Data");

        inflater = getActivity().getLayoutInflater();
        v = inflater.inflate(R.layout.customized_dialog_layout,null);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
        dialog.setView(v)
                .setTitle(titleText)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //TODO do some positive actions
                        mListener.onDialogPositiveClick(CustomDialog.this);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Todo do some negative
                        dismiss();
                    }
                });

        return dialog.create();
    }

    public interface NoticeDialogListener {
        public void onDialogPositiveClick(DialogFragment dialog);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mListener = (NoticeDialogListener)context;
    }

    public String getTitleText() {
        return titleText;
    }
}

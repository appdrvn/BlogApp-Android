package com.appdrvn.blogapp.dialogs;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appdrvn.blogapp.R;
import com.appdrvn.blogapp.delegates.DialogsDelegates;
import com.appdrvn.blogapp.widgets.DefaultDialogFragment;

/**
 * Created by kelvynlaw on 14/02/2018.
 */

public class ForgotPasswordDialog extends DefaultDialogFragment {

    public static ForgotPasswordDialog newInstance() {

        Bundle args = new Bundle();

        ForgotPasswordDialog fragment = new ForgotPasswordDialog();
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.dialog_forgot_password, null);

        initToolBar(getResources().getString(R.string.forgot_password), rootView);
        setRightIcon(R.drawable.ic_close, closeClickListener, rootView);

        rootView.findViewById(R.id.submit).setOnClickListener(submitClickListener);

        return rootView;
    }

    View.OnClickListener closeClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            dismiss();
        }
    };

    View.OnClickListener submitClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            DialogsDelegates.showMessage(getActivity(), getResources().getString(R.string.instruction_to_reset_your_password_has_been_sent_to_your_email), "", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dismiss();
                }
            });
        }
    };
}

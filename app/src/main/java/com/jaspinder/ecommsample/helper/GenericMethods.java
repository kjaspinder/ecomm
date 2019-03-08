package com.jaspinder.ecommsample.helper;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import com.jaspinder.ecommsample.R;
public class GenericMethods
{

	public static void showErrorDialog(String heading, String msg, Context c) {
		AlertDialog.Builder builder;

		builder = new AlertDialog.Builder(c);

		builder.setTitle(heading)
				.setMessage(msg)
				.setPositiveButton(c.getString(R.string.cancel), new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						// continue with delete
						dialog.dismiss();
					}
				})
				.setCancelable(false)
				.setIcon(android.R.drawable.ic_dialog_alert)
				.show();
	}

}

package com.scheffsblend.aokp_backup;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.LinearLayout;

public class BackupFragment extends Fragment {
	private static final int BACKUP_ID = 42;
	private static final String BACKUP_NAME_FORMAT = "MM-dd-yyyy-HH-mm-ss";

	CheckBox mBackupAll;
	CheckListView mListView;
	Context mContext;

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		setHasOptionsMenu(true);
	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		if (container == null) {
			// We have different layouts, and in one of them this
			// fragment's containing frame doesn't exist. The fragment
			// may still be created from its saved state, but there is
			// no reason to try to create its view hierarchy because it
			// won't be displayed. Note this is not needed -- we could
			// just run the code below, where we would create and return
			// the view hierarchy; it would just never be used.
			return null;
		}

		mContext = getActivity().getApplicationContext();

		LinearLayout layout = (LinearLayout) inflater.inflate(
				R.layout.tab_backupfrag_layout, container, false);
		mListView = (CheckListView) layout.findViewById(R.id.backup_items);

		String[] items = getResources().getStringArray(
				R.array.backup_items_text);
		mListView.setAdapter(new CheckListAdapter(mContext, R.id.item, items));

		mBackupAll = (CheckBox) layout.findViewById(R.id.backup_all);
		mBackupAll.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				mListView.checkAll(isChecked);
			}
		});

		return layout;
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		menu.add(Menu.NONE, BACKUP_ID, 0, "BACKUP SELECTED").setShowAsAction(
				MenuItem.SHOW_AS_ACTION_IF_ROOM);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		final ContentResolver cr = getActivity().getContentResolver();

		switch (item.getItemId()) {
		case BACKUP_ID:
			AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
			alert.setTitle("Backup name");

			SimpleDateFormat sdf = new SimpleDateFormat(BACKUP_NAME_FORMAT, Locale.getDefault());
			String defaultName = sdf.format(new Date());
			
			// Set an edit text for user to name this backup
			final EditText input = new EditText(mContext);
			input.setText(defaultName);
			alert.setView(input);

			alert.setPositiveButton("Ok",
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog,
								int whichButton) {
							Editable value = input.getText();
							// Do something with value!
						}
					});

			alert.setNegativeButton("Cancel",
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog,
								int whichButton) {
							// Canceled.
						}
					});

			alert.show();

			ArrayList<Integer> indices = mListView.getSelectedItems();
			String[] items = getResources().getStringArray(
					R.array.backup_items_ids);
			for (int i = 0; i < indices.size(); i++) {
				if (items[indices.get(i)].equals(Constants.BATTERY)) {

				} else if (items[indices.get(i)].equals(Constants.CLOCK)) {

				} else if (items[indices.get(i)].equals(Constants.GENERAL)) {

				} else if (items[indices.get(i)].equals(Constants.LOCKSCREEN)) {

				} else if (items[indices.get(i)].equals(Constants.NAVBAR)) {

				} else if (items[indices.get(i)].equals(Constants.PERFORMANCE)) {

				} else if (items[indices.get(i)].equals(Constants.POWER)) {

				} else if (items[indices.get(i)].equals(Constants.SIGNAL)) {

				} else if (items[indices.get(i)].equals(Constants.STARTUP)) {

				} else if (items[indices.get(i)].equals(Constants.TOGGLES)) {

				} else if (items[indices.get(i)].equals(Constants.UI)) {

				} else if (items[indices.get(i)].equals(Constants.WEATHER)) {

				}
			}
			return true;
		}

		return false;
	}
}

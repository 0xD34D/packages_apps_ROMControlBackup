/**
 * 
 */
package com.scheffsblend.aokp_backup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * @author 0xD34D
 *
 */
public class CheckListAdapter extends ArrayAdapter<String> {
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;
		if (v == null) {
			LayoutInflater vi = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			v = vi.inflate(R.layout.list_item_layout, null);
		}
		String item = mItems[position];
		if (item != null) {
			TextView tv = (TextView)v.findViewById(mResID);
			if (tv != null)
				tv.setText(item);
		}
		
		return v;
	}

	private String[] mItems;
	private Context mContext;
	private int mResID; 

	public CheckListAdapter(Context context, int textViewResourceId,
			String[] items) {
		super(context, textViewResourceId, items);
		mItems = items;
		mContext = context;
		mResID = textViewResourceId;
	}
}

/**
 * 
 */
package com.scheffsblend.aokp_backup;

import java.util.ArrayList;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CheckBox;
import android.widget.ListView;

/**
 * @author Clark Scheff
 *
 */
public class CheckListView extends ListView {
	private OnItemsCheckedChanged mListener = null;
	private boolean mIsAllChecked = false;

	public CheckListView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public CheckListView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public CheckListView(Context context) {
		super(context);
	}
	
	public void checkAll(boolean all) {
		for (int i = 0; i < this.getChildCount(); i++) {
			CheckBox cb = (CheckBox)getChildAt(i);
			cb.setChecked(all);
			mIsAllChecked = all;
		}
	}
	
	public interface OnItemsCheckedChanged {
		public void onAllItemsChecked();
		public void onNotAllItemsChecked();
	}
	
	public ArrayList<Integer> getSelectedItems() {
		ArrayList<Integer> items = new ArrayList<Integer>();
		for (int i = 0; i < this.getChildCount(); i++) {
			CheckBox cb = (CheckBox)getChildAt(i);
			if (cb.isChecked())
				items.add(i);
		}
		
		return items;
	}
}

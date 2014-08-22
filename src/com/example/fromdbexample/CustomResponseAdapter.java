package com.example.fromdbexample;

import java.util.List;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomResponseAdapter extends BaseAdapter {
	Context context;
	List<ResponseModel> rowItems;

	public CustomResponseAdapter(Context mContext, List<ResponseModel> rowItems) {
		this.context = mContext;
		this.rowItems = rowItems;
	}

	@Override
	public int getCount() {

		return rowItems.size();
	}

	@Override
	public Object getItem(int pos) {
		return rowItems.get(pos);
	}

	@Override
	public long getItemId(int pos) {
		return rowItems.indexOf(getItem(pos));
	}

	private class ViewHolder {
		TextView txtName;
		TextView txtPhone;
		TextView txtResponse;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder = null;
		LayoutInflater mInflater = (LayoutInflater) context
				.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.list_item, null);
			holder = new ViewHolder();

			holder.txtName = (TextView) convertView.findViewById(R.id.txtName);
			holder.txtPhone = (TextView) convertView
					.findViewById(R.id.txtPhone);
			holder.txtResponse = (TextView) convertView
					.findViewById(R.id.txtReponse);

			ResponseModel rowpos = rowItems.get(position);
			holder.txtName.setText(rowpos.getName());
			holder.txtPhone.setText(rowpos.getPhone());
			holder.txtResponse.setText(rowpos.getResponse());

			convertView.setTag(holder);

		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		return convertView;
	}

}

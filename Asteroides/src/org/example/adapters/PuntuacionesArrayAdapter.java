package org.example.adapters;

import java.util.List;

import org.example.asteroides.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/*PATTERN LIST HOLDER*/

public class PuntuacionesArrayAdapter extends ArrayAdapter {

	static class ViewHolder {
		public TextView text;
	}

	/** Points list */
	private List points;

	/** Context */
	private Context context;

	public PuntuacionesArrayAdapter(Context context, int textViewResourceId,
			List points) {
		super(context, textViewResourceId, points);
		this.context = context;
		this.points = points;
	}

	@Override
	public View getView(int position, View v, ViewGroup parent) {
		// Keeps reference to avoid future findViewById()
		ViewHolder viewHolder;

		if (v == null) {
			LayoutInflater li = (LayoutInflater) getContext().getSystemService(
					Context.LAYOUT_INFLATER_SERVICE);
			v = li.inflate(R.layout.elemento_lista, parent, false);

			viewHolder = new ViewHolder();
			viewHolder.text = (TextView) v.findViewById(R.id.titulo);

			v.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) v.getTag();
		}

		String point = (String) points.get(position);
		if (point != null) {
			viewHolder.text.setText(point);

		}
		return v;
	}

	static class ContactsViewHolder {
		TextView txName;
		TextView txEmails;
		TextView txPhones;
	}
}

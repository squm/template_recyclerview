// package anitras.dance;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created on 9/24/15.
 */
public class ListProd extends RecyclerView.Adapter<ListProd.ViewHolder> {

public List<String> data;
public View.OnClickListener sel;
// public Action1<Integer> sel;

@Override
public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
	// Create new views (invoked by the layout manager)
	// create a new view

	View v = LayoutInflater
		.from(parent.getContext())
		.inflate(R.layout.row_prod, parent, false);

	// set the view's size, margins, paddings and layout parameters
	ViewHolder holder = new ViewHolder(v);

	if (sel != null) v.setOnClickListener(sel);

//	View.OnClickListener listener = new View.OnClickListener() {
//		@Override
//		public void onClick(View view) {
//			sel.call(holder.getAdapterPosition());
//		}
//	};

//	if (sel != null) v.setOnClickListener(listener);

	return holder;
}
@Override
public void onBindViewHolder(ViewHolder holder, int position) {
	// Replace the contents of a view (invoked by the layout manager)
	// - get element from your dataset at this position
	// - replace the contents of the view with that element

	holder.text.setText(data.get(position));
}
@Override
public int getItemCount() {
	return data.size();
}
public static class ViewHolder extends RecyclerView.ViewHolder {
	// Provide a reference to the views for each data item
	// Complex data items may need more than one view per item, and
	// you provide access to all the views for a data item in a view holder

	public TextView text;
	public ViewHolder(View view) {
		super(view);

		text = (TextView) view.findViewById(R.id.row_text);
	}
}
}

// package anitras.dance;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

/**
 * Created on 9/24/15.
 */

public class ActivityProd extends AppCompatActivity {

@Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.activity_prod);
	loadTable(new ArrayList<String>());
}
@Override
public boolean onCreateOptionsMenu(Menu menu) {
	// Inflate the menu; this adds items to the action bar if it is present.
	getMenuInflater().inflate(R.menu.menu_prod, menu);
	return true;
}
@Override
public boolean onOptionsItemSelected(MenuItem item) {
	return super.onOptionsItemSelected(item);
}
private void loadTable(final List<String> rows) {
//	Action1<Integer> sel = new Action1<Integer>() {
//		@Override
//		public void call(final Integer row) {
//			clickRow(row);
//		}
//	};

	View.OnClickListener sel = new View.OnClickListener() {
		@Override
		public void onClick(View view) {
			clickRow((Integer) view.getTag());
		}
	};

	adapter = new ListProd();
	adapter.sel = sel;
	adapter.data = rows;
	
	RecyclerView recycler =
		(RecyclerView) findViewById(R.id.a_prod_list);

	if (recycler == null) return;

	// use this setting to improve performance if you know that changes
	// in content do not change the layout size of the RecyclerView
	recycler.setHasFixedSize(true);
	recycler.setLayoutManager(new LinearLayoutManager(this));
	recycler.setAdapter(adapter);
}
private void loadData() {
	List<String> tmp = Arrays.asList("Anitra's", "Dance");

	data = new ArrayList<>();

	for (String text : tmp) {
		final int row = data.size();
		data.add(text);
		adapter.data.add(text);
		adapter.notifyItemInserted(row);
	}
}
private void clickRow(final Integer pos) {
	say("ActivityProd clickRow: %d", pos);
}
public void clickNext(View view) {
	loadData();
}
}


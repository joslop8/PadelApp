package net.developers.padelapp;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;

public class Login extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		putEventEditText();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	private void putEventEditText() {
		((EditText) findViewById(R.id.Edit_User_Login))
				.setOnFocusChangeListener(new OnFocusChangeListener() {

					@Override
					public void onFocusChange(View v, boolean hasFocus) {
						controlToEditText(v, hasFocus);
					}
				});

		((EditText) findViewById(R.id.Edit_User_Password))
				.setOnFocusChangeListener(new OnFocusChangeListener() {
					@Override
					public void onFocusChange(View v, boolean hasFocus) {
						controlToEditText(v, hasFocus);
					}
				});
	}

	private void controlToEditText(View v, boolean hasFocus) {
		EditText editFocus = (EditText) v;
		String texto = editFocus.getText().toString();
		if (!hasFocus && texto.equals("")) {
			editFocus.setText(editFocus.getContentDescription());
			if (editFocus.getId() == R.id.Edit_User_Password)
				editFocus.setInputType(InputType.TYPE_NULL);
		} else if (hasFocus
				&& ((editFocus.getId() == R.id.Edit_User_Login && texto
						.equals(getString(R.string.User)))
						|| texto.equals(getString(R.string.Pass)) || texto
							.equals(getString(R.string.Email)))) {
			editFocus.setText("");
			if (editFocus.getId() == R.id.Edit_User_Password)
				editFocus.setInputType(InputType.TYPE_CLASS_TEXT
						| InputType.TYPE_TEXT_VARIATION_PASSWORD);
		}
	}
}

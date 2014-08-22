package com.example.fromdbexample;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.fromdbexample.library.ServiceHandler;

import android.support.v7.app.ActionBarActivity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.ListView;

public class MainActivity extends ActionBarActivity {
	private String URL = "http://10.0.2.2/fetchfromdb/fetchresponses.php";

	private ArrayList<ResponseModel> responseModel = new ArrayList<ResponseModel>();
	CustomResponseAdapter custRAdapter;

	ListView lvResponse;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
		setContentView(R.layout.activity_main);

		new getResponses().execute();
	}

	public void setdataonlist() {
		lvResponse = (ListView) findViewById(R.id.listView);
		custRAdapter = new CustomResponseAdapter(getApplicationContext(),
				responseModel);
		lvResponse.setAdapter(custRAdapter);

	}

	private class getResponses extends AsyncTask<String, Void, Void> {

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			// show progress bar
			setProgressBarIndeterminateVisibility(true);
		}

		@Override
		protected Void doInBackground(String... arg0) {
			ServiceHandler sh = new ServiceHandler();
			String jsonresults = sh.makeServiceCall(URL, sh.GET);

			Log.e("Response: ", "> " + jsonresults);
			if (jsonresults != null) {
				try {
					JSONObject jsonObj = new JSONObject(jsonresults);
					if (jsonObj != null) {
						JSONArray arrresponse = jsonObj
								.getJSONArray("allresponses");
						for (int i = 0; i < arrresponse.length(); i++) {
							JSONObject jo = arrresponse.getJSONObject(i);

							String name = jo.getString("name");
							String phone = jo.getString("phone");
							String response = jo.getString("response");

							ResponseModel rModel = new ResponseModel(name,
									phone, response);
							responseModel.add(rModel);

						}
					}
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			super.onPostExecute(result);
			setProgressBarIndeterminateVisibility(false);
			setdataonlist();
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
}

package com.fos.android.loginapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapAct extends Activity implements LocationListener {

	int TIMEOUT_MILLISEC = 10000;
	GoogleMap googleMap;
	GoogleMap mMap;
	String value;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mapact);
		Intent i = getIntent();
		if (i.hasExtra("User")) {
			value = i.getStringExtra("User");
		}

		LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

		locationManager.requestLocationUpdates(
				LocationManager.NETWORK_PROVIDER, 1, 1, this);

		googleMap = ((MapFragment) getFragmentManager().findFragmentById(
				R.id.map)).getMap();

		googleMap.setOnMapClickListener(new OnMapClickListener() {

			@Override
			public void onMapClick(LatLng latLng) {

				Toast.makeText(getApplicationContext(), latLng.toString(),
						Toast.LENGTH_LONG).show();
			}
		});

	}

	@Override
	public void onLocationChanged(Location location) {

		Double latti = location.getLatitude();

		Double longi = location.getLongitude();
		String a = latti.toString();
		String t = a + "+";

		String b = longi.toString();

		String c = t + b + "+" + value;

		new HttpAsyncTask().execute(c);

		LatLng position = new LatLng(latti, longi);

		MarkerOptions markerOptions = new MarkerOptions();

		markerOptions.position(position);

		googleMap.animateCamera(CameraUpdateFactory
				.newLatLngZoom(position, 17f));

		googleMap.addMarker(markerOptions);

	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub

	}

	private class HttpAsyncTask extends AsyncTask<String, Void, String> {
		InputStream is = null;
		String response = null;
		BufferedReader reader = null;
		HttpPost httpPost;
		DefaultHttpClient httpClient;

		@Override
		protected String doInBackground(String... urls) {
			try {

				Double lati = null;
				Double longi = null;
				String user = null;
				StringTokenizer stringTokenizer = new StringTokenizer(urls[0],
						"+");
				while (stringTokenizer.hasMoreElements()) {
					lati = Double.parseDouble(stringTokenizer.nextElement()
							.toString());
					longi = Double.parseDouble(stringTokenizer.nextElement()
							.toString());
					user = stringTokenizer.nextElement().toString();
					;
				}

				List<NameValuePair> name = new ArrayList<NameValuePair>(1);
				name.add(new BasicNameValuePair("lat", lati.toString()));
				name.add(new BasicNameValuePair("long", longi.toString()));
				name.add(new BasicNameValuePair("user", user));
				HttpParams httpParameters = new BasicHttpParams();

				int timeoutConnection = 4000;
				HttpConnectionParams.setConnectionTimeout(httpParameters,
						timeoutConnection);

				int timeoutSocket = 6000;
				HttpConnectionParams
						.setSoTimeout(httpParameters, timeoutSocket);

				httpClient = new DefaultHttpClient(httpParameters);
				HttpEntity httpEntity = null;
				HttpResponse httpResponse = null;

				httpPost = new HttpPost(
						"http://feetonstreet.hostoi.com/default.php");

				if (name != null) {
					httpPost.setEntity(new UrlEncodedFormEntity(name));
				}

				httpResponse = httpClient.execute(httpPost);
				httpEntity = httpResponse.getEntity();
				is = httpEntity.getContent();

			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			try {
				BufferedReader reader = new BufferedReader(
						new InputStreamReader(is, "UTF-8"), 8);
				StringBuilder sb = new StringBuilder();
				String line = null;
				while ((line = reader.readLine()) != null) {
					sb.append(line + "\n");
				}
				is.close();
				response = sb.toString();
			} catch (Exception e) {
				Log.e("Buffer Error", "Error: " + e.toString());
			}

			// check for success tag

			return null;

		}

		// onPostExecute displays the results of the AsyncTask.
		@Override
		protected void onPostExecute(String result) {
			Toast.makeText(getBaseContext(), "Data Sent!", Toast.LENGTH_LONG)
					.show();
			this.cancel(true);
			httpPost.abort();
		}

	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		finish();
	}
}

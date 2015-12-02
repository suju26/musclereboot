package info.androidhive.slidingmenu;

import java.util.ArrayList;
import java.util.List;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;

public class YourProfileFragment extends Fragment {
	Spinner spinneractivity ;
	String selecteditem;
	public YourProfileFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.your_profile, container, false);
         
        Spinner activity_spinner = (Spinner) rootView.findViewById(R.id.spinnerprofile_ui_activity);
		// Spinner click listener
		// activity_spinner.setOnItemSelectedListener(this);
		// Spinner Drop down elements
		List<String> setactivity = new ArrayList<String>();
		setactivity.add("Little to no exercise");
		setactivity.add("3 time per week");
		setactivity.add("5 time per week");
		setactivity.add("Daily Exercise and physical job");
		// Creating adapter for spinner
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, setactivity);
		// Drop down layout style - list view with radio button
		dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// attaching data adapter to spinner
		activity_spinner.setAdapter(dataAdapter);



		//radiogender=(RadioGroup)findViewById(R.id.radioGroup1);
		//Spinner Activity Level
		spinneractivity = (Spinner)rootView.findViewById(R.id.spinnerprofile_ui_activity);
		spinneractivity.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				selecteditem=parent.getItemAtPosition(position).toString();	
				Log.d("", "selecteditem : "+selecteditem);
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub

			}

		});
        
        
        
        return rootView;
    }
}

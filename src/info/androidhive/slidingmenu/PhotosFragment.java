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

public class PhotosFragment extends Fragment {
	Spinner spinneractivity;
	String selecteditem;
	Spinner spinnernuriplan;
	String selectednutriplan;
	
	public PhotosFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_your_goal, container, false);
        /*Spinner activity_spinner = (Spinner) rootView.findViewById(R.id.macro_calculate_goal);
      		// Spinner click listener
      		// activity_spinner.setOnItemSelectedListener(this);
      		// Spinner Drop down elements
      		List<String> setactivity = new ArrayList<String>();
      		setactivity.add("Maintenance");
      		setactivity.add("Fat Loss");
      		setactivity.add("Bulking");
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

      		});*/
      		
      		/* Spinner nutriplan_spinner = (Spinner) rootView.findViewById(R.id.macro_nutrition_spinner);
       		// Spinner click listener
       		// activity_spinner.setOnItemSelectedListener(this);
       		// Spinner Drop down elements
       		List<String> setnutriplan = new ArrayList<String>();
       		setnutriplan.add("Normal");
       		setnutriplan.add("Zone Diet");
       		setnutriplan.add("Low Carb Macro");
       		setnutriplan.add("Ketogenic");
       		// Creating adapter for spinner
       		ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, setnutriplan);
       		// Drop down layout style - list view with radio button
       		dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
       		// attaching data adapter to spinner
       		nutriplan_spinner.setAdapter(dataAdapter1);



       		//radiogender=(RadioGroup)findViewById(R.id.radioGroup1);
       		//Spinner Activity Level
       		spinnernuriplan = (Spinner)rootView.findViewById(R.id.spinnerprofile_ui_activity);
       		spinnernuriplan.setOnItemSelectedListener(new OnItemSelectedListener() {

       			@Override
       			public void onItemSelected(AdapterView<?> parent, View view,
       					int position, long id) {
       				// TODO Auto-generated method stub
       				selectednutriplan=parent.getItemAtPosition(position).toString();	
       				Log.d("", "selectednutriplan : "+selectednutriplan);
       			}

       			@Override
       			public void onNothingSelected(AdapterView<?> parent) {
       				// TODO Auto-generated method stub

       			}

       		});*/
              
        return rootView;
    }
}

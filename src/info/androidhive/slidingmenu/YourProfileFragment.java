package info.androidhive.slidingmenu;

import java.util.ArrayList;
import java.util.List;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.TextView;

public class YourProfileFragment extends Fragment {
	Spinner spinneractivity ;
	String selected_Activity_level;
	EditText age,height,weight;
	RadioGroup radiogender;
	RadioButton radioSexButton;
	Double bmr;
	View rootView ;
	SharedPreferences sharedpreferences;
	public static final String MyPREFERENCES = "MyPrefs" ;
	public YourProfileFragment(){}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		rootView = inflater.inflate(R.layout.fragment_profile, container, false);

		//Shared Prefferance

		/*String age_saved=sharedpreferences.getString("age_key", "");
		age.setText(age_saved);*/

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
				selected_Activity_level=parent.getItemAtPosition(position).toString();	
				Log.d("", "selecteditem : "+selected_Activity_level);
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub

			}

		});

		//Initializing all component
		age=(EditText)rootView.findViewById(R.id.profile_ui_age);
		radiogender=(RadioGroup)rootView.findViewById(R.id.radioGroup1);
		height=(EditText)rootView.findViewById(R.id.profile_ui_height_cm);
		weight=(EditText)rootView.findViewById(R.id.profile_ui_weight);
		sharedpreferences = getActivity().getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);

		Button bt=(Button)rootView.findViewById(R.id.profile_ui_save);
		bt.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				OnSave();
			}
		});





		return rootView;
	}
	public void OnSave()
	{

		String age_string=age.getText().toString();
		double age_input= Double.parseDouble(age_string);
		String height_string=height.getText().toString();
		double height_input=Double.parseDouble(height_string);
		String weight_string=weight.getText().toString();
		double weight_input= Double.parseDouble(weight_string);

		//BMR Calculation 

		int selectedId=radiogender.getCheckedRadioButtonId();
		radioSexButton=(RadioButton)rootView.findViewById(selectedId);
		if(radioSexButton.getText().equals("Male")){
			bmr=10*weight_input+6.25*height_input-5*age_input+5;
		}
		if(radioSexButton.getText().equals("Female"))
		{
			bmr=10*weight_input+6.25*height_input-5*age_input-161;

		}

		/*	TextView result=(TextView)rootView.findViewById(R.id.textView5);
			result.setText(""+Math.round(bmr));*/
		String bmr_result=Double.toString(Math.round(bmr));

		SharedPreferences.Editor editor = sharedpreferences.edit();
		editor.putString("bmr_key", bmr_result);
		editor.putString("age_key",age_string );
		editor.putString("weight_key",weight_string );
		editor.putString("height_key", height_string);
		if(selectedId == R.id.profile_ui_male_radio)
			editor.putBoolean("is_male", true);
		else
			editor.putBoolean("is_male", false);

		editor.commit();
	}

}



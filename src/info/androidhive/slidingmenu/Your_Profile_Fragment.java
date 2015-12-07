package info.androidhive.slidingmenu;

import java.util.ArrayList;
import java.util.List;




import android.app.Fragment;
import android.app.FragmentManager;
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
import android.widget.Toast;

public class Your_Profile_Fragment extends Fragment {
	Spinner spinneractivity ;
	String selected_Activity_level;
	EditText age,height,weight;
	RadioGroup radiogender;
	RadioButton radioSexButton;
	Double bmr;
	View rootView ;
	SharedPreferences sharedpreferences;
	public static final String MyPREFERENCES = "MyPrefs" ;
	double tdde;
	public Your_Profile_Fragment(){}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		rootView = inflater.inflate(R.layout.fragment_your_profile, container, false);

		//Shared Prefferance

		/*String age_saved=sharedpreferences.getString("age_key", "");
		age.setText(age_saved);*/

		Spinner activity_spinner = (Spinner) rootView.findViewById(R.id.spinnerprofile_ui_activity);
		// Spinner click listener
		// activity_spinner.setOnItemSelectedListener(this);
		// Spinner Drop down elements
		List<String> setactivity = new ArrayList<String>();
		setactivity.add("Select Your Activity Level");
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

		Button bth=(Button)rootView.findViewById(R.id.height);
		bth.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				onheight();
			}
		});

		Button btw=(Button)rootView.findViewById(R.id.weight);
		btw.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				onweight();
			}
		});





		return rootView;
	}
	public void OnSave()
	{

		String age_string=age.getText().toString();
		String height_string=height.getText().toString();
		String weight_string=weight.getText().toString();

		if(age_string.equals("")||height_string.equals("")||weight_string.equals("")){

			Toast.makeText(getActivity(), "Enter all Required Details",
					Toast.LENGTH_SHORT).show();

		}else{
			if(selected_Activity_level.equals("Select Your Activity Level"))
			{
				Toast.makeText(getActivity(), "Please Select your Activity Level",
						Toast.LENGTH_SHORT).show();
			}else{
				double age_input= Double.parseDouble(age_string);

				double height_input=Double.parseDouble(height_string);

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



				if(selected_Activity_level.equals("Little to no exercise"))
				{
					tdde=bmr*1.2;
				}
				if(selected_Activity_level.equals("3 time per week"))
				{
					tdde=bmr*1.375;
				}
				if(selected_Activity_level.equals("5 time per week"))
				{
					tdde=bmr*1.55;
				}
				if(selected_Activity_level.equals("Daily Exercise and physical job"))
				{
					tdde=bmr*1.725;
				}
				String final_tdde=Double.toString(Math.round(tdde));

				SharedPreferences.Editor editor = sharedpreferences.edit();
				editor.putString("bmr_key", final_tdde);
				editor.putString("age_key",age_string );
				editor.putString("weight_key",weight_string );
				editor.putString("height_key", height_string);
				if(selectedId == R.id.profile_ui_male_radio)
					editor.putBoolean("is_male", true);
				else
					editor.putBoolean("is_male", false);

				editor.commit();

				Fragment fragment = new Your_Goal_Fragment();
				// Insert the fragment by replacing any existing fragment
				FragmentManager fragmentManager = getFragmentManager();
				fragmentManager.beginTransaction()
				.replace(R.id.frame_container, fragment)
				.commit();


			}
		}
	}

	public void onheight()
	{
		TextView feet=(TextView)rootView.findViewById(R.id.editText2);
		TextView inch=(TextView)rootView.findViewById(R.id.editText3);
		TextView result_txt=(TextView)rootView.findViewById(R.id.textView5);
		String feet_input=feet.getText().toString();
		String inch_input=inch.getText().toString();
		if(feet_input.equals("")||inch_input.equals("")){

			Toast.makeText(getActivity(), "Enter your Height In Feet and Inches (Eg 5 10)",
					Toast.LENGTH_SHORT).show();
		}else{
			double feet_num=Double.parseDouble(feet_input);
			double inch_num=Double.parseDouble(inch_input);
			double result_feet=feet_num*12;
			double result_height=(result_feet+inch_num)*2.5;
			result_txt.setText(""+Math.round(result_height));
		}
	}

	public void onweight()
	{
		TextView weight=(TextView)rootView.findViewById(R.id.editText1);
		String weight_input=weight.getText().toString();
		if(weight_input.equals(""))
		{
			Toast.makeText(getActivity(), "Enter your Weight in LBS (Eg:142)",
					Toast.LENGTH_SHORT).show();
		}else{
			double weight_num=Double.parseDouble(weight_input);
			double weight_result=weight_num/2.2046;
			TextView inkg=(TextView)rootView.findViewById(R.id.textView6);
			inkg.setText(""+Math.round(weight_result));
		}

	}
}


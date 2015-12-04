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
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.TextView;

public class Macro_Requirement_Fragment extends Fragment {
	Spinner goal_spinner;
	String selectedgoal;
	Spinner nutri_spinner;
	String selectednutri;
	SharedPreferences sharedpreferences;
	String Astatus;
	TextView text_gaol;
	TextView tdee_result;
	String tdde_activity;
	double tdde_num;
	double tdde_goal;
	TextView txtview_percent_macro_protein;
	TextView txtview_percent_maccro_fats;
	TextView txtview_percent_maccro_carbs;
	TextView txt_macro_protein_percentage_manual;
	TextView txt_macro_fat_percentage_manual;
	TextView txt_macro_carb_percentage_manual;
	double your_pro,your_carbs,your_fats;
	TextView txt_macro_fats_percentage_manual;
	TextView txt_macro_carbs_percentage_manual;



	public Macro_Requirement_Fragment(){}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_macro_requirement, container, false);
		goal_spinner = (Spinner) rootView.findViewById(R.id.macro_goal_spinner);
		// Spinner click listener
		// activity_spinner.setOnItemSelectedListener(this);
		// Spinner Drop down elements
		List<String> setactivity = new ArrayList<String>();
		setactivity.add("Gain Weight");
		setactivity.add("Loss Weight");
		setactivity.add("Maintain Weight");
		// Creating adapter for spinner
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, setactivity);
		// Drop down layout style - list view with radio button
		dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// attaching data adapter to spinner
		goal_spinner.setAdapter(dataAdapter);
		//All TextView 
		text_gaol=(TextView)rootView.findViewById(R.id.macro_goal_calories_calculated);
		txtview_percent_macro_protein=(TextView)rootView.findViewById(R.id.macro_protein_percentage_calculated);
		txtview_percent_maccro_fats=(TextView)rootView.findViewById(R.id.macro_fat_percentage_calculated);
		txtview_percent_maccro_carbs=(TextView)rootView.findViewById(R.id.macro_carb_percentage_calculated);
		txt_macro_protein_percentage_manual=(TextView)rootView.findViewById(R.id.macro_protein_percentage_manual);
		txt_macro_fats_percentage_manual=(TextView)rootView.findViewById(R.id.macro_fat_percentage_manual);
		txt_macro_carbs_percentage_manual=(TextView)rootView.findViewById(R.id.macro_carb_percentage_manual);



		//radiogender=(RadioGroup)findViewById(R.id.radioGroup1);
		//Spinner Activity Level
		//goal_spinner = (Spinner)rootView.findViewById(R.id.macro_goal_spinner);
		goal_spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				selectedgoal=parent.getItemAtPosition(position).toString();	


				//TDEE Calculation Based on Goal Selected

				if(selectedgoal.equals("Gain Weight"))
				{
					tdde_activity=tdee_result.getText().toString();
					tdde_num=Double.parseDouble(tdde_activity);
					tdde_goal=tdde_num+(tdde_num*0.20);
					text_gaol.setText(""+Math.round(tdde_goal));

				}

				if(selectedgoal.equals("Loss Weight"))
				{
					tdde_activity=tdee_result.getText().toString();
					tdde_num=Double.parseDouble(tdde_activity);
					tdde_goal=tdde_num-(tdde_num*0.20);
					text_gaol.setText(""+tdde_goal);

				}

				if(selectedgoal.equals("Maintain Weight"))
				{
					tdde_activity=tdee_result.getText().toString();
					tdde_num=Double.parseDouble(tdde_activity);
					tdde_goal=tdde_num;
					text_gaol.setText(""+tdde_goal);

				}
				Log.d("", "selecteditem : "+selectedgoal);
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub

			}

		});


		nutri_spinner = (Spinner) rootView.findViewById(R.id.macro_nutrition_spinner);
		// Spinner click listener
		// activity_spinner.setOnItemSelectedListener(this);
		// Spinner Drop down elements
		List<String> setnutri = new ArrayList<String>();
		setnutri.add("Ketogenic Macro");
		setnutri.add("Zone Macro");
		setnutri.add("Low Carb Macro");
		// Creating adapter for spinner
		ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, setnutri);
		// Drop down layout style - list view with radio button
		dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// attaching data adapter to spinner
		nutri_spinner.setAdapter(dataAdapter1);




		//Spinner Activity Level
		//nutri_spinner = (Spinner)rootView.findViewById(R.id.macro_nutrition_spinner);
		nutri_spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				selectednutri=parent.getItemAtPosition(position).toString();
				Log.d("", "selecteditem : "+selectednutri);

				if(selectednutri.equals("Ketogenic Macro"))
				{
					txtview_percent_macro_protein.setText("35%");
					txtview_percent_maccro_fats.setText("60%");
					txtview_percent_maccro_carbs.setText("5%");
					your_pro=tdde_goal*0.35/4;
					your_carbs=tdde_goal*0.05/4;
					your_fats=tdde_goal*0.6/9;
					txt_macro_protein_percentage_manual.setText(""+Math.round(your_pro));
					txt_macro_fats_percentage_manual.setText(""+Math.round(your_fats));
					txt_macro_carbs_percentage_manual.setText(""+Math.round(your_carbs));

				}
				if(selectednutri.equals("Zone Macro"))
				{
					txtview_percent_macro_protein.setText("30%");
					txtview_percent_maccro_fats.setText("60%");
					txtview_percent_maccro_carbs.setText("40%");

					your_pro=tdde_goal*0.30/4;
					your_carbs=tdde_goal*0.40/4;
					your_fats=tdde_goal*0.60/9;
					txt_macro_protein_percentage_manual.setText(""+Math.round(your_pro));
					txt_macro_fats_percentage_manual.setText(""+Math.round(your_fats));
					txt_macro_carbs_percentage_manual.setText(""+Math.round(your_carbs));
				}

				if(selectednutri.equals("Low Carb Macro"))
				{
					txtview_percent_macro_protein.setText("45%");
					txtview_percent_maccro_fats.setText("30%");
					txtview_percent_maccro_carbs.setText("25%");	

					your_pro=tdde_goal*0.45/4;
					your_carbs=tdde_goal*0.25/4;
					your_fats=tdde_goal*0.30/9;
					txt_macro_protein_percentage_manual.setText(""+Math.round(your_pro));
					txt_macro_fats_percentage_manual.setText(""+Math.round(your_fats));
					txt_macro_carbs_percentage_manual.setText(""+Math.round(your_carbs));
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				txtview_percent_macro_protein.setText("0%");

			}

		});
		sharedpreferences = getActivity().getSharedPreferences("MyPREFERENCES", Context.MODE_PRIVATE);
		Astatus = sharedpreferences.getString("bmr_key", "");
		tdee_result=(TextView)rootView.findViewById(R.id.txt_result);
		tdee_result.setText(""+Astatus);

		////Your Macro Split




		return rootView;
	}


}

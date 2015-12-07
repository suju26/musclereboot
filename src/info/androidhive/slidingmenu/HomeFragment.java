package info.androidhive.slidingmenu;

import android.app.Fragment;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

public class HomeFragment extends Fragment {
	
	public HomeFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
         
		TextView intro=(TextView)rootView.findViewById(R.id.TextView_Intro);
		intro.setText(Html.fromHtml("<h2>Introduction</h2><br><p>Before beginning, please understand a few things very clearly </p><br>"
				+ "<p>1. Bodybuilding is science. You’re getting results doing bullshit? good for you, please move on.</p><p> 2. To lose weight you have to take lesser calories than your BMR*, to gain weight you have to take more calories than your BMR* </p>"
				+ "<br><p>That’s it, there is no other way around these two things. Let science guide your transformation journey not bro-science.  "
				+ "</p><br><p>I figured the best way to tell you everything would be to start from the start. It will be boring initially as its all science and stuff, but trust me, you’ll see almost 99% of the things are relevant. So please don’t skip anything and if possible read again and again. Good luck! </p>"));
		
        
		TextView meta=(TextView)rootView.findViewById(R.id.TextView_Metabolism);
		meta.setText(Html.fromHtml("<h2>Metabolism</h2><br><p>Your body is like a car, it needs fuel to run. However unlike a petrol or diesel car, your body can use multiple fuels. In simple words, the process, in which your body uses the fuel to provide energy to your body is called Metabolism.</p><br>"
				+ "<p>Food contains ingredients which your body can use as fuel. But even fuel is not yet energy! If I give you fully charged battery, try using it to bake an egg. Having an energy containing fuel does not mean that it is ready to use. </p><br>"
				+ "<p>It all starts with food, and its metabolically active ingredients</p><br>"
				+ "<p>-Fat <br>- Fiber <br>- Long Carbs  <br>- Short carbs ( Sugar in other words)<br> - Protein</p><br>"
				+ "<p>Fat contain 9 calories (kilocalories per gram), Carbs and protein contain 4 calories. While fibers do not yield any energy, they are extremely important in making digested food leave your body, they help in digestion as well.</p><br>"
				+ "<p>Now, what are these fuels that we’ve been talking about, so far we’ve only discussed the fuel sources. Let’s have a look Your body can extract at least the following three kinds of fuel from what you ingest: </p><br>"
				+ "<p>- Fatty Acids <br>- Glucose <br>- Amino Acids  <br>Fat -> fatty acids <br>Fibers -> used for excreting ingredients <br>Long carbohydrates -> shorter -> glucose <br>Shorter carbohydrates ('sugars') -> glucose <br>Proteins -> Amino acids </p>"));

        return rootView;
    }
}

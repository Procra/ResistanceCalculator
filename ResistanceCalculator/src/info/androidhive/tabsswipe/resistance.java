package info.androidhive.tabsswipe;

import java.util.ArrayList;

import info.androidhive.tabsswipe.R;
import android.support.v4.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Spinner;
import android.widget.TextView;

public class resistance extends Fragment {

	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		final View rootView = inflater.inflate(R.layout.resistance, container, false);
		
		Spinner Spinner1 = (Spinner) rootView.findViewById(R.id.Spinner1);
		Spinner Spinner2 = (Spinner) rootView.findViewById(R.id.Spinner2);
		Spinner Spinner3 = (Spinner) rootView.findViewById(R.id.Spinner3);
		Spinner Spinner4 = (Spinner) rootView.findViewById(R.id.Spinner4);

		 // String valeur
		 ArrayList<ColorSpinnerAdapterItem> colors = new ArrayList<ColorSpinnerAdapterItem>();
	        colors.add(new ColorSpinnerAdapterItem(Color.rgb(52, 38, 40), "    "));
	        colors.add(new ColorSpinnerAdapterItem(Color.rgb(83, 69, 41), "    "));
	        colors.add(new ColorSpinnerAdapterItem(Color.rgb(255, 0, 0), "    "));
	        colors.add(new ColorSpinnerAdapterItem(Color.rgb(255, 145, 0), "    "));
	        colors.add(new ColorSpinnerAdapterItem(Color.rgb(232, 253, 1), "    "));
	        colors.add(new ColorSpinnerAdapterItem(Color.rgb(0, 255, 0), "    "));
	        colors.add(new ColorSpinnerAdapterItem(Color.rgb(0, 0, 255), "    "));
	        colors.add(new ColorSpinnerAdapterItem(Color.rgb(157, 0, 170), "    "));
	        colors.add(new ColorSpinnerAdapterItem(Color.rgb(120, 95, 103), "    "));
	        colors.add(new ColorSpinnerAdapterItem(Color.rgb(255, 255, 255), "    "));
	        ColorSpinnerAdapter adapteurValeur = new ColorSpinnerAdapter(getActivity(), android.R.layout.simple_list_item_1, colors);

	     // String multiplicateur
			 ArrayList<ColorSpinnerAdapterItem> colors2 = new ArrayList<ColorSpinnerAdapterItem>();
			 colors2.add(new ColorSpinnerAdapterItem(Color.rgb(249, 213, 0), "    "));
		        colors2.add(new ColorSpinnerAdapterItem(Color.rgb(184, 184, 184), "    "));
		        colors2.add(new ColorSpinnerAdapterItem(Color.rgb(52, 38, 40), "    "));
		        colors2.add(new ColorSpinnerAdapterItem(Color.rgb(83, 69, 41), "    "));
		        colors2.add(new ColorSpinnerAdapterItem(Color.rgb(255, 0, 0), "    "));
		        colors2.add(new ColorSpinnerAdapterItem(Color.rgb(255, 145, 0), "    "));
		        colors2.add(new ColorSpinnerAdapterItem(Color.rgb(232, 253, 1), "    "));
		        colors2.add(new ColorSpinnerAdapterItem(Color.rgb(0, 255, 0), "    "));
		        colors2.add(new ColorSpinnerAdapterItem(Color.rgb(0, 0, 255), "    "));
		        colors2.add(new ColorSpinnerAdapterItem(Color.rgb(157, 0, 170), "    "));
		        ColorSpinnerAdapter adapteurMultiplicateur = new ColorSpinnerAdapter(getActivity(), android.R.layout.simple_list_item_1, colors2);
	        
		        //string tolerance
		        ArrayList<ColorSpinnerAdapterItem> colors3 = new ArrayList<ColorSpinnerAdapterItem>();
		        colors3.add(new ColorSpinnerAdapterItem(Color.rgb(249, 213, 0), "    "));
		        colors3.add(new ColorSpinnerAdapterItem(Color.rgb(184, 184, 184), "    "));
		        ColorSpinnerAdapter adapteurTolerance = new ColorSpinnerAdapter(getActivity(), android.R.layout.simple_list_item_1, colors3);
		        
		 Spinner1.setAdapter(adapteurValeur);
		 Spinner2.setAdapter(adapteurValeur);
		 Spinner3.setAdapter(adapteurMultiplicateur);
		 Spinner4.setAdapter(adapteurTolerance);
		 
		 
		 Spinner1.setOnItemSelectedListener(new OnItemSelectedListener() {
			    public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
			    	Spinner Spinner1 = (Spinner) rootView.findViewById(R.id.Spinner1);
					Spinner Spinner2 = (Spinner) rootView.findViewById(R.id.Spinner2);
					Spinner Spinner3 = (Spinner) rootView.findViewById(R.id.Spinner3);
					Spinner Spinner4 = (Spinner) rootView.findViewById(R.id.Spinner4);
					
					int pos1 = Spinner1.getSelectedItemPosition();
					int pos2 = Spinner2.getSelectedItemPosition();
					int pos3 = Spinner3.getSelectedItemPosition();
					int pos4 = Spinner4.getSelectedItemPosition();

					double multi = 0;
					String unite = "Ohms";
					double tolerance = 0;
					if(pos3 == 0){multi = 0.01;unite="Ohms";}
					else if(pos3 == 1){multi = 0.1;unite="Ohms";}
					else if(pos3 == 2){multi = 1;unite="Ohms";}
					else if(pos3 == 3){multi = 10;unite="Ohms";}
					else if(pos3 == 4){multi = 100;unite="Ohms";}
					else if(pos3 == 5){multi = 1;unite="KOhms";}
					else if(pos3 == 6){multi = 10;unite="KOhms";}
					else if(pos3 == 7){multi = 100;unite="KOhms";}
					else if(pos3 == 8){multi = 1;unite="MOhms";}
					else if(pos3 == 9){multi = 10;unite="MOhms";}
					
					if(pos4 == 0){tolerance = 5;}
					else if(pos4 == 1){tolerance = 10;}
					
					String AddValues = String.valueOf(pos1) + String.valueOf(pos2);
					double calcul = Integer.parseInt(AddValues) * multi;
					final TextView resultat = (TextView) rootView.findViewById(R.id.resultat);
					final TextView resultatTolerance = (TextView) rootView.findViewById(R.id.resultatTolerance);
					resultatTolerance.setText("Tolérance : " + tolerance + "%");
					resultat.setText(calcul + " " + unite);
			    }
			    	
			    public void onNothingSelected(AdapterView<?> parentView) {
				    // your code here
				 }
		 });
		 
		 Spinner2.setOnItemSelectedListener(new OnItemSelectedListener() {
			    public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
			    	Spinner Spinner1 = (Spinner) rootView.findViewById(R.id.Spinner1);
					Spinner Spinner2 = (Spinner) rootView.findViewById(R.id.Spinner2);
					Spinner Spinner3 = (Spinner) rootView.findViewById(R.id.Spinner3);
					Spinner Spinner4 = (Spinner) rootView.findViewById(R.id.Spinner4);
					
					int pos1 = Spinner1.getSelectedItemPosition();
					int pos2 = Spinner2.getSelectedItemPosition();
					int pos3 = Spinner3.getSelectedItemPosition();
					int pos4 = Spinner4.getSelectedItemPosition();

					double multi = 0;
					String unite = "Ohms";
					double tolerance = 0;
					if(pos3 == 0){multi = 0.01;unite="Ohms";}
					else if(pos3 == 1){multi = 0.1;unite="Ohms";}
					else if(pos3 == 2){multi = 1;unite="Ohms";}
					else if(pos3 == 3){multi = 10;unite="Ohms";}
					else if(pos3 == 4){multi = 100;unite="Ohms";}
					else if(pos3 == 5){multi = 1;unite="KOhms";}
					else if(pos3 == 6){multi = 10;unite="KOhms";}
					else if(pos3 == 7){multi = 100;unite="KOhms";}
					else if(pos3 == 8){multi = 1;unite="MOhms";}
					else if(pos3 == 9){multi = 10;unite="MOhms";}
					
					if(pos4 == 0){tolerance = 5;}
					else if(pos4 == 1){tolerance = 10;}
					
					String AddValues = String.valueOf(pos1) + String.valueOf(pos2);
					double calcul = Integer.parseInt(AddValues) * multi;
					final TextView resultat = (TextView) rootView.findViewById(R.id.resultat);
					final TextView resultatTolerance = (TextView) rootView.findViewById(R.id.resultatTolerance);
					resultatTolerance.setText("Tolérance : " + tolerance + "%");
					resultat.setText(calcul + " " + unite);
			    }
			    	
			    public void onNothingSelected(AdapterView<?> parentView) {
				    // your code here
				 }
		 });
		 
		 Spinner3.setOnItemSelectedListener(new OnItemSelectedListener() {
			    public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
			    	Spinner Spinner1 = (Spinner) rootView.findViewById(R.id.Spinner1);
					Spinner Spinner2 = (Spinner) rootView.findViewById(R.id.Spinner2);
					Spinner Spinner3 = (Spinner) rootView.findViewById(R.id.Spinner3);
					Spinner Spinner4 = (Spinner) rootView.findViewById(R.id.Spinner4);
					
					int pos1 = Spinner1.getSelectedItemPosition();
					int pos2 = Spinner2.getSelectedItemPosition();
					int pos3 = Spinner3.getSelectedItemPosition();
					int pos4 = Spinner4.getSelectedItemPosition();

					double multi = 0;
					String unite = "Ohms";
					double tolerance = 0;
					if(pos3 == 0){multi = 0.01;unite="Ohms";}
					else if(pos3 == 1){multi = 0.1;unite="Ohms";}
					else if(pos3 == 2){multi = 1;unite="Ohms";}
					else if(pos3 == 3){multi = 10;unite="Ohms";}
					else if(pos3 == 4){multi = 100;unite="Ohms";}
					else if(pos3 == 5){multi = 1;unite="KOhms";}
					else if(pos3 == 6){multi = 10;unite="KOhms";}
					else if(pos3 == 7){multi = 100;unite="KOhms";}
					else if(pos3 == 8){multi = 1;unite="MOhms";}
					else if(pos3 == 9){multi = 10;unite="MOhms";}
					
					if(pos4 == 0){tolerance = 5;}
					else if(pos4 == 1){tolerance = 10;}
					
					String AddValues = String.valueOf(pos1) + String.valueOf(pos2);
					double calcul = Integer.parseInt(AddValues) * multi;
					final TextView resultat = (TextView) rootView.findViewById(R.id.resultat);
					final TextView resultatTolerance = (TextView) rootView.findViewById(R.id.resultatTolerance);
					resultatTolerance.setText("Tolérance : " + tolerance + "%");
					resultat.setText(calcul + " " + unite);
			    }
			    	
			    public void onNothingSelected(AdapterView<?> parentView) {
				    // your code here
				 }
		 });

	
	Spinner4.setOnItemSelectedListener(new OnItemSelectedListener() {
	    public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {			
	    	Spinner Spinner1 = (Spinner) rootView.findViewById(R.id.Spinner1);
			Spinner Spinner2 = (Spinner) rootView.findViewById(R.id.Spinner2);
			Spinner Spinner3 = (Spinner) rootView.findViewById(R.id.Spinner3);
			Spinner Spinner4 = (Spinner) rootView.findViewById(R.id.Spinner4);
			
			int pos1 = Spinner1.getSelectedItemPosition();
			int pos2 = Spinner2.getSelectedItemPosition();
			int pos3 = Spinner3.getSelectedItemPosition();
			int pos4 = Spinner4.getSelectedItemPosition();

			double multi = 0;
			String unite = "Ohms";
			double tolerance = 0;
			if(pos3 == 0){multi = 0.01;unite="Ohms";}
			else if(pos3 == 1){multi = 0.1;unite="Ohms";}
			else if(pos3 == 2){multi = 1;unite="Ohms";}
			else if(pos3 == 3){multi = 10;unite="Ohms";}
			else if(pos3 == 4){multi = 100;unite="Ohms";}
			else if(pos3 == 5){multi = 1;unite="KOhms";}
			else if(pos3 == 6){multi = 10;unite="KOhms";}
			else if(pos3 == 7){multi = 100;unite="KOhms";}
			else if(pos3 == 8){multi = 1;unite="MOhms";}
			else if(pos3 == 9){multi = 10;unite="MOhms";}
			
			if(pos4 == 0){tolerance = 5;}
			else if(pos4 == 1){tolerance = 10;}
			
			String AddValues = String.valueOf(pos1) + String.valueOf(pos2);
			double calcul = Integer.parseInt(AddValues) * multi;
			final TextView resultat = (TextView) rootView.findViewById(R.id.resultat);
			final TextView resultatTolerance = (TextView) rootView.findViewById(R.id.resultatTolerance);
			resultatTolerance.setText("Tolérance : " + tolerance + "%");
			resultat.setText(calcul + " " + unite);
	    }

	    public void onNothingSelected(AdapterView<?> parentView) {
	        // your code here
	    }

	});
	return rootView;
}
}

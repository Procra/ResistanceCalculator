package info.androidhive.tabsswipe;

import java.util.ArrayList;

import info.androidhive.tabsswipe.R;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class resistanceInverse extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		final View rootView = inflater.inflate(R.layout.resistanceinverse, container, false);
		
		final Spinner Spinner1 = (Spinner) rootView.findViewById(R.id.Spinner1);
		
		// String tolerance
		ArrayList<ColorSpinnerAdapterItem> colors = new ArrayList<ColorSpinnerAdapterItem>();
        colors.add(new ColorSpinnerAdapterItem(Color.rgb(249, 213, 0), "    "));
        colors.add(new ColorSpinnerAdapterItem(Color.rgb(184, 184, 184), "    "));
        ColorSpinnerAdapter adapteurTolerance = new ColorSpinnerAdapter(getActivity(), android.R.layout.simple_list_item_1, colors);
		
		Spinner1.setAdapter(adapteurTolerance);
		
		EditText input = (EditText) rootView.findViewById(R.id.input);
		
	    input.addTextChangedListener(new TextWatcher() {
	    	Spinner Spinner1 = (Spinner) rootView.findViewById(R.id.Spinner1);
	    	public void beforeTextChanged(CharSequence s, int start, int count,int after) {
				// TODO Auto-generated method stub	
			}
			public void onTextChanged(CharSequence s, int start, int before,int count) {
				final EditText resultat = (EditText) rootView.findViewById(R.id.input);
				rootView.findViewById(R.id.Spinner1);
				
				if(resultat.getText().toString().length()>=2){
					int val1=Integer.parseInt(resultat.getText().toString().substring(0,1));
					int val2=Integer.parseInt(resultat.getText().toString().substring(1,2));
					int pos = Spinner1.getSelectedItemPosition();
					
					String affiche1 = "";
					String affiche2 = "";
					String affiche3 = "";
					
					if(pos == 0){affiche3 = "Or";}
					else if(pos == 1){affiche3 = "Argent";}
					
					switch(val1){
						case 0:affiche1="Noir";break;
						case 1:affiche1="Marron";break;
						case 2:affiche1="Rouge";break;
						case 3:affiche1="Orange";break;
						case 4:affiche1="Jaune";break;
						case 5:affiche1="Vert";break;
						case 6:affiche1="Bleu";break;
						case 7:affiche1="Violet";break;
						case 8:affiche1="Gris";break;
						case 9:affiche1="Blanc";break;
						default:affiche1="";break;
					}
					
					switch(val2){
						case 0:affiche2="Noir";break;
						case 1:affiche2="Marron";break;
						case 2:affiche2="Rouge";break;
						case 3:affiche2="Orange";break;
						case 4:affiche2="Jaune";break;
						case 5:affiche2="Vert";break;
						case 6:affiche2="Bleu";break;
						case 7:affiche2="Violet";break;
						case 8:affiche2="Gris";break;
						case 9:affiche2="Blanc";break;
						default:affiche2="";break;
					}
				
					final TextView result = (TextView) rootView.findViewById(R.id.resultat);
					result.setText(affiche1 + " - " + affiche2 + " - Noir - " + affiche3);
				}
			}
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub	
			}
			});
	    
	    Spinner1.setOnItemSelectedListener(new OnItemSelectedListener() {
		    public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
		    	final EditText resultat = (EditText) rootView.findViewById(R.id.input);
		    	rootView.findViewById(R.id.Spinner1);
				
		    	if(resultat.getText().toString().length()>=2){
					int val1=Integer.parseInt(resultat.getText().toString().substring(0,1));
					int val2=Integer.parseInt(resultat.getText().toString().substring(1,2));
					int pos = Spinner1.getSelectedItemPosition();
					
					String affiche1 = "";
					String affiche2 = "";
					String affiche3 = "";
					
					if(pos == 0){affiche3 = "Or";}
					else if(pos == 1){affiche3 = "Argent";}
					
					switch(val1){
						case 0:affiche1="Noir";break;
						case 1:affiche1="Marron";break;
						case 2:affiche1="Rouge";break;
						case 3:affiche1="Orange";break;
						case 4:affiche1="Jaune";break;
						case 5:affiche1="Vert";break;
						case 6:affiche1="Bleu";break;
						case 7:affiche1="Violet";break;
						case 8:affiche1="Gris";break;
						case 9:affiche1="Blanc";break;
						default:affiche1="";break;
					}
					
					switch(val2){
						case 0:affiche2="Noir";break;
						case 1:affiche2="Marron";break;
						case 2:affiche2="Rouge";break;
						case 3:affiche2="Orange";break;
						case 4:affiche2="Jaune";break;
						case 5:affiche2="Vert";break;
						case 6:affiche2="Bleu";break;
						case 7:affiche2="Violet";break;
						case 8:affiche2="Gris";break;
						case 9:affiche2="Blanc";break;
						default:affiche2="";break;
					}
				
					final TextView result = (TextView) rootView.findViewById(R.id.resultat);
					result.setText(affiche1 + " - " + affiche2 + " - Noir - " + affiche3);
				}
	 }

			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
	    });
	    return rootView;
	}
}

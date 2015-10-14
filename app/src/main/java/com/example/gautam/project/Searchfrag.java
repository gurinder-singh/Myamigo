package com.example.gautam.project;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Searchfrag extends Fragment implements com.wdullaer.materialdatetimepicker.date.DatePickerDialog.OnDateSetListener {
    private Spinner spinner1, spinner2;
    private EditText mEdit;
    private ImageButton img;
    private Button bft;
    private Activity2 activity;
    public Searchfrag(Activity2 activity) {
        this.activity = activity;
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup cointainer, Bundle savedInstancestate) {
        View v = inflater.inflate(R.layout.frgment3, cointainer, false);
        mEdit = (EditText) v.findViewById(R.id.editText1);
        img = (ImageButton) v.findViewById(R.id.imageButton1);

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        mEdit.setText(formatter.format(new Date()));
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar now = Calendar.getInstance();
                DatePickerDialog dpd = DatePickerDialog.newInstance(
                        Searchfrag.this,
                        now.get(Calendar.YEAR),
                        now.get(Calendar.MONTH),
                        now.get(Calendar.DAY_OF_MONTH)

                );
                dpd.show(getFragmentManager(), "Datepickerdialog");
            }
        });
        getActivity().setTitle("Search trip");
        spinner1 = (Spinner) v.findViewById(R.id.spinner1);
        bft = (Button) v.findViewById(R.id.buttonfindtrip);
        bft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("SearchFrag", "jhujghjkll");
                TripFragment frag = new TripFragment();
                activity.replaceFragment(frag);

            }
        });
        String[] cities = {
                "Panaji",
                "Calgute",
                "Mapusa",
                "Dona paula",
                "Margao",
                "Vasco",

        };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item, cities);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner1.setAdapter(adapter);

        spinner2 = (Spinner) v.findViewById(R.id.spinner2);
        String[] activity = {
                "Water sport",
                "Adventure sport",
                "Relaxation",
                "Scuba diving",
                "Banana boat",
                "River cruise",
                "Casinos",

        };
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item, activity);
        adapter1.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner2.setAdapter(adapter1);
        return v;


    }

    @Override
    public void onDateSet(com.wdullaer.materialdatetimepicker.date.DatePickerDialog datePickerDialog, int year, int monthOfYear, int dayOfMonth) {
        String date =  + dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;

        mEdit.setText(date);
    }

    /*public void selectDate(View v) {
        DialogFragment newFragment = new SelectDateFragment();
        Log.d("Tag Name", "DAte picker");
        newFragment.show(((AppCompatActivity) getActivity()).getFragmentManager(), "DatePicker");
    }*/

    public void populateSetDate(int year, int month, int day) {

//        mEdit.setText(month + "/" + day + "/" + year);


    }



    /*public class SelectDateFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final Calendar calendar = Calendar.getInstance();
            int yy = calendar.get(Calendar.YEAR);
            int mm = calendar.get(Calendar.MONTH);
            int dd = calendar.get(Calendar.DAY_OF_MONTH);
            return new DatePickerDialog(getActivity(), this, yy, mm, dd);
        }

        public void onDateSet(DatePicker v, int yy, int mm, int dd) {
            populateSetDate(yy, mm + 1, dd);

        }


    }*/

}



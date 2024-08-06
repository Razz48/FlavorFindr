package com.example.flavorfinder.Location;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.flavorfinder.R;
import com.example.flavorfinder.databinding.ActivityLocationBinding;

public class LocationActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    ActivityLocationBinding locationBinding;
    String selectedProvince,selectedDistrict;
    ArrayAdapter<CharSequence> provinceAdapter,districtAdapter;
    private static final String TAG = "LocationActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        setContentView(R.layout.activity_location);
        locationBinding=ActivityLocationBinding.inflate(getLayoutInflater());
        View view=locationBinding.getRoot();
        setContentView(view);



    provinceAdapter=ArrayAdapter.createFromResource(this,R.array.ProvincesOfNepal, android.R.layout.simple_spinner_item);
    provinceAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

    locationBinding.spinnerProvince.setAdapter(provinceAdapter);

    locationBinding.spinnerProvince.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (provinceAdapter != null ) {
            selectedProvince = locationBinding.spinnerProvince.getSelectedItem().toString().toString();

//            Toast.makeText(this, "Selected province: " + selectedProvince, Toast.LENGTH_SHORT).show();
            int parentID = parent.getId();

            Log.d("LLocationActivity","parentsIdd="+locationBinding.spinnerProvince.getId());

            if (parentID == locationBinding.spinnerProvince.getId()) {

                switch (selectedProvince) {
                    case "Select province":
                        districtAdapter = ArrayAdapter.createFromResource(parent.getContext(), R.array.default_district, android.R.layout.simple_spinner_item);

                        break;
                    case "Province No. 1":
                        districtAdapter = ArrayAdapter.createFromResource(parent.getContext(), R.array.ProvinceNo1Districts, android.R.layout.simple_spinner_item);
                        break;
                    case "Province No. 2":
                        districtAdapter = ArrayAdapter.createFromResource(parent.getContext(), R.array.ProvinceNo2Districts, android.R.layout.simple_spinner_item);
                        break;
                    case "Bagmati Province":
                        districtAdapter = ArrayAdapter.createFromResource(parent.getContext(), R.array.BagmatiProvinceDistricts, android.R.layout.simple_spinner_item);
                        break;
                    case "Gandaki Province":
                        districtAdapter = ArrayAdapter.createFromResource(parent.getContext(), R.array.GandakiProvinceDistricts, android.R.layout.simple_spinner_item);
                        break;
                    case "Lumbini Province":
                        districtAdapter = ArrayAdapter.createFromResource(parent.getContext(), R.array.LumbiniProvinceDistricts, android.R.layout.simple_spinner_item);
                        break;
                    case "Karnali Province":
                        districtAdapter = ArrayAdapter.createFromResource(parent.getContext(), R.array.KarnaliProvinceDistricts, android.R.layout.simple_spinner_item);
                        break;
                    case "Sudurpashchim Province":
                        districtAdapter = ArrayAdapter.createFromResource(parent.getContext(), R.array.SudurpashchimProvinceDistricts, android.R.layout.simple_spinner_item);
                        break;
                    default:
                        districtAdapter = null;
                        break;
                }

                    districtAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    locationBinding.spinnerDistrict.setAdapter(districtAdapter);

            }
        }
    }
//    if(position!=0){
//        Toast.makeText(this,
//                "name of state is"+selectedProvince,
//                Toast.LENGTH_SHORT).show();
//    }


    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
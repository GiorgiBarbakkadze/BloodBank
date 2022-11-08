package giorgibarbakadze.example.bloodbank;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

import giorgibarbakadze.example.bloodbank.databinding.FragmentDonorDetailsBinding;


public class DonorDetailsFragment extends Fragment implements DatePickerDialog.OnDateSetListener {


    private static final String TAG = "DonorFragment";
    private FragmentDonorDetailsBinding binding;
    String name, address, bloodType, lastDateOfDonation, donationFrequency, healthProblems;
    int phone, hasHealthProblems;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDonorDetailsBinding.inflate(inflater, container,  false);

        String[] bloodTypes = getResources().getStringArray(R.array.blood_types);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(requireContext(), R.layout.drop_down_item, bloodTypes);
        binding.bloodTypeSpinner.setAdapter(arrayAdapter);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        binding.nameTIE.addTextChangedListener(textWatcher(binding.nameTIE));
        binding.phoneTIE.addTextChangedListener(textWatcher(binding.phoneTIE));
        binding.addressTIE.addTextChangedListener(textWatcher(binding.addressTIE));
        binding.dateOfDonationTIE.addTextChangedListener(textWatcher(binding.dateOfDonationTIE));
        binding.timeBetweenTIE.addTextChangedListener(textWatcher(binding.timeBetweenTIE));
        binding.bloodTypeSpinner.addTextChangedListener(textWatcher(binding.bloodTypeSpinner));


        binding.dateOfDonationTIE.setOnClickListener(v -> {
            MyDatePickerDialog myDatePickerDialog = new MyDatePickerDialog();
            myDatePickerDialog.show(requireActivity().getSupportFragmentManager(), "datePicker");
        });






        binding.hasHealthProblem.setOnCheckedChangeListener((compoundButton, b) -> {
                    if (compoundButton.isChecked()) {
                        binding.healthProblemTIL.setVisibility(View.VISIBLE);
                        binding.healthProblemTIE.addTextChangedListener(textWatcher(binding.healthProblemTIE));
                    } else{
                        binding.healthProblemTIL.setVisibility(View.GONE);
                    }
        });


        binding.submit.setOnClickListener(v -> {
            if (binding.bloodTypeSpinner.getText().toString().isEmpty()) {
                binding.bloodTypeTIL.setError("This Field Can Not Be Empty");
            }
            if(validate(new TextInputEditText[]{binding.nameTIE, binding.phoneTIE, binding.addressTIE, binding.dateOfDonationTIE, binding.timeBetweenTIE, binding.healthProblemTIE})){
//                Donor donor = new Donor();
//                donor.setName(Objects.requireNonNull(binding.nameTIE.getText()).toString());
//                donor.setPhone(Integer.parseInt(Objects.requireNonNull(binding.phoneTIE.getText()).toString()));
//                donor.setAddress(Objects.requireNonNull(binding.addressTIE.getText()).toString());
//                donor.setBloodType(binding.bloodTypeSpinner.getText().toString());

            }
        });
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

    }

    private boolean validate(TextInputEditText[] fields) {
        boolean isValid = false;
        for (TextInputEditText currentField : fields) {
            if (Objects.requireNonNull(currentField.getText()).toString().isEmpty()) {
                setError((TextInputLayout) currentField.getParent().getParent());
                isValid = false;
            } else {
                isValid = true;
            }
        }
        return isValid;
    }

    private void setError (TextInputLayout textInputLayout) {
        textInputLayout.setError("This Field Can Not Be Empty");

    }



    private TextWatcher textWatcher(View view) {
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                switch (view.getId()) {
                    case R.id.nameTIE:
                        binding.nameTIL.setErrorEnabled(false);
                        break;
                    case R.id.phoneTIE:
                        binding.phoneTIL.setErrorEnabled(false);
                        break;
                    case R.id.addressTIE:
                        binding.addressTIL.setErrorEnabled(false);
                        break;
                    case R.id.dateOfDonationTIE:
                        binding.dateOfDonationTIL.setErrorEnabled(false);
                        break;
                    case R.id.timeBetweenTIE:
                        binding.timeBetweenTIL.setErrorEnabled(false);
                        break;
                    case R.id.healthProblemTIE:
                        binding.healthProblemTIL.setErrorEnabled(false);
                        break;
                    case R.id.bloodTypeSpinner:
                        binding.bloodTypeTIL.setErrorEnabled(false);
                }


            }
        };
    }




    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}
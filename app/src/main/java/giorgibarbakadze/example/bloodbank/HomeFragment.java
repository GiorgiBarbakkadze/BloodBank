package giorgibarbakadze.example.bloodbank;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class HomeFragment extends Fragment {

    Button becomeDonorBtn, getBloodBtn;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        becomeDonorBtn = view.findViewById(R.id.becomeDonor);
        getBloodBtn = view.findViewById(R.id.getBlood);

        becomeDonorBtn.setOnClickListener(v -> {
            getParentFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, DonorDetailsFragment.class, null).commit();
        });

        getBloodBtn.setOnClickListener(v -> {

        });
    }
}
package es.travelworld.ejercicio7_viewpager.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import es.travelworld.ejercicio7_viewpager.databinding.FragmentRoommateBinding;

public class RoommateFragment extends Fragment {

    private FragmentRoommateBinding binding;

    public RoommateFragment() {
        // Required empty public constructor
    }


    public static RoommateFragment newInstance(String param1, String param2) {
        RoommateFragment fragment = new RoommateFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentRoommateBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        return view;
    }
}
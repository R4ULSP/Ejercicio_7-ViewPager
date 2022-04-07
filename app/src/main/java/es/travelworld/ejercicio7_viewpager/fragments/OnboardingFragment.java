package es.travelworld.ejercicio7_viewpager.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import es.travelworld.ejercicio7_viewpager.databinding.FragmentOnboardingBinding;

public class OnboardingFragment extends Fragment {

    private FragmentOnboardingBinding binding;

    public OnboardingFragment() {
        // Required empty public constructor
    }


    public static OnboardingFragment newInstance(String param1, String param2) {
        OnboardingFragment fragment = new OnboardingFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentOnboardingBinding.inflate(inflater,container,false);
        View view = binding.getRoot();

        return view;
    }
}
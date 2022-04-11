package es.travelworld.ejercicio7_viewpager.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import es.travelworld.ejercicio7_viewpager.databinding.FragmentOnboardingBinding;

public class OnBoardingFragment extends Fragment {

    private FragmentOnboardingBinding binding;

    public OnBoardingFragment() {
        // Required empty public constructor
    }


    public static OnBoardingFragment newInstance(String param1, String param2) {
        OnBoardingFragment fragment = new OnBoardingFragment();

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
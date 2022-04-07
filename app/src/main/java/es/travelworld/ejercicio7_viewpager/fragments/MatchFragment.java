package es.travelworld.ejercicio7_viewpager.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import es.travelworld.ejercicio7_viewpager.databinding.FragmentMatchBinding;

public class MatchFragment extends Fragment {

    private FragmentMatchBinding binding;

    public MatchFragment() {
        // Required empty public constructor
    }


    public static MatchFragment newInstance(String param1, String param2) {
        MatchFragment fragment = new MatchFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentMatchBinding.inflate(inflater,container,false);
        View view = binding.getRoot();

        return view;
    }
}
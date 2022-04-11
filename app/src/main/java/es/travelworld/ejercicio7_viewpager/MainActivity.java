package es.travelworld.ejercicio7_viewpager;

import static es.travelworld.ejercicio7_viewpager.domain.References.MATCH_FRAGMENT;
import static es.travelworld.ejercicio7_viewpager.domain.References.NUM_PAGES;
import static es.travelworld.ejercicio7_viewpager.domain.References.ON_BOARDING_FRAGMENT;
import static es.travelworld.ejercicio7_viewpager.domain.References.ROOMMATE_FRAGMENT;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import android.os.Bundle;

import es.travelworld.ejercicio7_viewpager.databinding.ActivityMainBinding;
import es.travelworld.ejercicio7_viewpager.fragments.MatchFragment;
import es.travelworld.ejercicio7_viewpager.fragments.OnBoardingFragment;
import es.travelworld.ejercicio7_viewpager.fragments.RoommateFragment;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        FragmentStateAdapter fragmentStateAdapter = new MainActivityFragmentStateAdapter(this);
        binding.viewPager.setAdapter(fragmentStateAdapter);

    }

    @Override
    public void onBackPressed() {
        if (binding.viewPager.getCurrentItem() == 0) {
            super.onBackPressed();
        } else {
            binding.viewPager.setCurrentItem(binding.viewPager.getCurrentItem() - 1);
        }
    }

    private class MainActivityFragmentStateAdapter extends FragmentStateAdapter {
        public MainActivityFragmentStateAdapter(MainActivity mainActivity) {
            super(mainActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            Fragment fragment = new Fragment();

            if (position == 0) {
                fragment = startOnBoardingFragment();
            } else if (position == 1) {
                fragment = startMatchFragment();
            } else if (position == 2) {
                fragment = startRoommateFragment();
            }

            return fragment;
        }

        @Override
        public int getItemCount() {
            return NUM_PAGES;
        }

        private Fragment startOnBoardingFragment() {
            OnBoardingFragment fragment = (OnBoardingFragment) getSupportFragmentManager().findFragmentByTag(ON_BOARDING_FRAGMENT);

            if (fragment != null) {
                return fragment;
            } else {
                return new OnBoardingFragment();
            }
        }

        private Fragment startMatchFragment() {
            MatchFragment fragment = (MatchFragment) getSupportFragmentManager().findFragmentByTag(MATCH_FRAGMENT);

            if (fragment != null) {
                return fragment;
            } else {
                return new MatchFragment();
            }
        }

        private Fragment startRoommateFragment() {
            RoommateFragment fragment = (RoommateFragment) getSupportFragmentManager().findFragmentByTag(ROOMMATE_FRAGMENT);

            if (fragment != null) {
                return fragment;
            } else {
                return new RoommateFragment();
            }
        }
    }
}
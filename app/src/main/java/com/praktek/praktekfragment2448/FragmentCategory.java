package com.praktek.praktekfragment2448;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentCategory#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentCategory extends Fragment implements View.OnClickListener {

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle saveInstanceState) {
        super.onViewCreated(view, saveInstanceState);
        Button btnSubCategory = view.findViewById(R.id.btn_sub_category);
        btnSubCategory.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_sub_category) {
            SubCategoryFragment mSubCategoryFragment = new SubCategoryFragment();

            Bundle mBundle = new Bundle();
            mBundle.putString(SubCategoryFragment.EXTRA_NAME, "ini dikirim dengan bundle");
            String description = "ini dikirim dengan getter setter";

            mSubCategoryFragment.setArguments(mBundle);
            mSubCategoryFragment.setDescription(description);

            FragmentManager mFragmentManager = getFragmentManager();
            if (mFragmentManager != null) {
                mFragmentManager.beginTransaction().replace(R.id.frame_container, mSubCategoryFragment, SubCategoryFragment.class.getSimpleName()).addToBackStack(null).commit();
            }
        }
    }
}
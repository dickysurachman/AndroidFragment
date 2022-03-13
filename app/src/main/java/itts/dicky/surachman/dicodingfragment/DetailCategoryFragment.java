package itts.dicky.surachman.dicodingfragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.DialogFragment;
//import android.app.Fragment;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailCategoryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailCategoryFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    TextView tvCategoryName;
    TextView tvCategoryDescription;
    Button btnProfile;
    Button btnShowDialog;
    public static String EXTRA_NAME = "extra_name";
    public static String EXTRA_DESCRIPTION = "extra_description";
    private String description;

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DetailCategoryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DetailCategoryFragment newInstance(String param1, String param2) {
        DetailCategoryFragment fragment = new DetailCategoryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail_category, container, false);
        //return inflater.inflate(R.layout.fragment_detail_category, container, false);
        tvCategoryName = view.findViewById(R.id.tv_category_name);
        tvCategoryDescription = view.findViewById(R.id.tv_category_description);
        btnProfile = view.findViewById(R.id.btn_profile);
        btnShowDialog = view.findViewById(R.id.btn_show_dialog);
        String categoryName = getArguments().getString(EXTRA_NAME);
        tvCategoryName.setText(categoryName);
        tvCategoryDescription.setText(getDescription());
        if (savedInstanceState != null) {
            String descFromBundle = savedInstanceState.getString(EXTRA_DESCRIPTION);
            setDescription(descFromBundle);
        }

        if (getArguments() != null) {
            categoryName = getArguments().getString(EXTRA_NAME);
            tvCategoryName.setText(categoryName);
            tvCategoryDescription.setText(getDescription());
        }
        Button button=view.findViewById(R.id.btn_show_dialog);
        Button button1=view.findViewById(R.id.btn_profile);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.btn_show_dialog) {
                    OptionDialogFragment mOptionDialogFragment = new OptionDialogFragment();
                    FragmentManager mFragmentManager = getChildFragmentManager();
                    mOptionDialogFragment.show(mFragmentManager,"test");//show(mFragmentManager,OptionDialogFragment.class.getSimpleName());
                   // mOptionDialogFragment.show(mFragmentManager, OptionDialogFragment.class.getSimpleName());
                   // mOptionDialogFragment.show(mFragmentManager, OptionDialogFragment.class.getSimpleName());
                    //OptionDialogFragment mOptionDialogFragment = new OptionDialogFragment();
                    //FragmentManager mFragmentManager = getChildFragmentManager();
                    //if (mFragmentManager != null) {
                    //    mFragmentManager
                    //            .beginTransaction()
                    //            .replace(R.id.frame_container1, mOptionDialogFragment, OptionDialogFragment.class.getSimpleName())
                    //            .addToBackStack(null)
                    //            .commit();
                   // }
                }
              }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.btn_profile) {
                    CategoryFragment mCategoryFragment = new CategoryFragment();
                    FragmentManager mFragmentManager = getParentFragmentManager();
                    mFragmentManager
                            .beginTransaction()
                            .replace(R.id.frame_container1, mCategoryFragment, CategoryFragment.class.getSimpleName())
                            .addToBackStack(null)
                            .commit();
                }
            }
        });
        return view;
    }
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(EXTRA_DESCRIPTION, getDescription());
    }

    public final OptionDialogFragment.OnOptionDialogListener optionDialogListener = new OptionDialogFragment.OnOptionDialogListener() {
        @Override
        public void onOptionChosen(String text) {
            Toast.makeText(getActivity(), text, Toast.LENGTH_SHORT).show();
        }
    };
}
package itts.dicky.surachman.dicodingfragment;

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
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment  {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Home2fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Home2fragment newInstance(String param1, String param2) {
        Home2fragment fragment = new Home2fragment();
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
        View view = inflater.inflate(R.layout.fragment_home2, container, false);
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_home2, container, false);
        Button button=view.findViewById(R.id.btn_category);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.btn_category) {
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
}
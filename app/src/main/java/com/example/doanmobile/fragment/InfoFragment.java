package com.example.doanmobile.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.doanmobile.R;
import com.example.doanmobile.model.Users;
import com.example.doanmobile.ui.Util;
import com.google.gson.Gson;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InfoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InfoFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public InfoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment InfoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InfoFragment newInstance(String param1, String param2) {
        InfoFragment fragment = new InfoFragment();
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
//    TextView tvUsernameC;
//    private final Gson gson = new Gson();
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//        View view = inflater.inflate(R.layout.fragment_info, container, false);
//        tvUsernameC = view.findViewById(R.id.tvUserName);
//        //
//        SharedPreferences shareget = getActivity().getSharedPreferences(Util.SHARE_PREFERENCES_APP, Context.MODE_PRIVATE);
//        String userPref = shareget.getString(Util.KEY_USER, null);
//        Users user = gson.fromJson(userPref, Users.class);
//        // user = null có nghĩa là chưa có user đăng ký
//        if (user == null) {
//            tvUsernameC.setText("không có dữ liệu");
//        }
//        else {
//            String info = "User name: " + user.getUserName() + "\n";
//            info += "Email: " + user.getEmail() + "\n";
//            tvUsernameC.setText(info);
//        }
//        return view;
//    }
}
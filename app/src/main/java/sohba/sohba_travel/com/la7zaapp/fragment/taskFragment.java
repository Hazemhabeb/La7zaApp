package sohba.sohba_travel.com.la7zaapp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import sohba.sohba_travel.com.la7zaapp.Activities.addRequest;
import sohba.sohba_travel.com.la7zaapp.R;


/**
 * @author hazem
 */
public class taskFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.categ, container, false);
        ImageView add_requestImage= (ImageView) view.findViewById(R.id.add_requestImage);
        add_requestImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), addRequest.class));
            }
        });

        return view;
    }





}
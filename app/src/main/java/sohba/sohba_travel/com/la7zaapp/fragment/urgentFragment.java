package sohba.sohba_travel.com.la7zaapp.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import sohba.sohba_travel.com.la7zaapp.R;
import sohba.sohba_travel.com.la7zaapp.adapter.categAdapter;
import sohba.sohba_travel.com.la7zaapp.adapter.urgentAdapter;
import sohba.sohba_travel.com.la7zaapp.model.urgentModel;

/**
 * @author hazem
 */
public class urgentFragment extends Fragment {


    private List<urgentModel> product_list = new ArrayList<>();
    private RecyclerView recyclerView;
    private urgentAdapter mAdapter;


    private SwipeRefreshLayout swipeContainer;

    ArrayList<urgentModel> categ_data;


    public urgentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_main_ad, container, false);


        // that the real data
        categ_data=new ArrayList<>();


        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerViewSub);



        // that is the fake data
        mAdapter = new urgentAdapter(getContext(),product_list);

        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);


        recyclerView.setAdapter(mAdapter);
        recyclerView.addOnItemTouchListener(new categAdapter.RecyclerTouchListener(getContext(), recyclerView, new categAdapter.ClickListener() {
            @Override
            public void onClick(View view, int position) {

            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));



        //Lookup the swipe container view
        swipeContainer = (SwipeRefreshLayout) v.findViewById(R.id.swipeContainer);
        // Setup refresh listener which triggers new data loading
        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // Your code to refresh the list here.
                // Make sure you call swipeContainer.setRefreshing(false)
                // once the network request has completed successfully.
//                getData();
            }
        });
        // Configure the refreshing colors
        swipeContainer.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);

        populateRecycle();

        return v;
    }


    private void populateRecycle(){
        product_list.add(new urgentModel());product_list.add(new urgentModel());product_list.add(new urgentModel());
        product_list.add(new urgentModel());product_list.add(new urgentModel());product_list.add(new urgentModel());

        product_list.add(new urgentModel());product_list.add(new urgentModel());product_list.add(new urgentModel());
        product_list.add(new urgentModel());product_list.add(new urgentModel());product_list.add(new urgentModel());

        product_list.add(new urgentModel());product_list.add(new urgentModel());product_list.add(new urgentModel());
        product_list.add(new urgentModel());product_list.add(new urgentModel());product_list.add(new urgentModel());

        product_list.add(new urgentModel());product_list.add(new urgentModel());product_list.add(new urgentModel());
        product_list.add(new urgentModel());product_list.add(new urgentModel());product_list.add(new urgentModel());

        product_list.add(new urgentModel());product_list.add(new urgentModel());product_list.add(new urgentModel());
        product_list.add(new urgentModel());product_list.add(new urgentModel());product_list.add(new urgentModel());


    }


}
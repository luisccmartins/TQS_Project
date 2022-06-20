package com.example.expressdelivery;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.expressdelivery.Controller.AppController;
import com.example.expressdelivery.Model.Order;
import com.example.expressdelivery.Model.Rider;
import com.example.expressdelivery.Service.AppService;

import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    RecyclerView recyclerView1;
    RecyclerView recyclerView2;
    private MyAdapterNew.RecyclerViewClickListener listenerNew;
    private MyAdapterInProgress.RecyclerViewClickListener listenerInProgress;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        setOnClickListenerNew();
        setOnClickListenerInProgress();

        List<Integer> arrayIdCreated = new ArrayList<Integer>();
        List<String> arrayDescriptionCreated = new ArrayList<String>();

        List<Integer> arrayIdPickedup = new ArrayList<Integer>();
        List<String> arrayDescriptionPickedup = new ArrayList<String>();

        AppService retrofitService = new AppService();
        AppController connection = retrofitService.getConnection();

        connection.getCreatedOrders().enqueue(new Callback<List<Order>>() {
            @Override
            public void onResponse(Call<List<Order>> call, Response<List<Order>> response) {
                //Toast.makeText(getContext(), "Successful!", Toast.LENGTH_SHORT).show();
                for (Order order : response.body()){
                    arrayIdCreated.add(order.getStore_id());
                    arrayDescriptionCreated.add(order.getDescription());
                }
                MyAdapterNew myAdapterData = new MyAdapterNew(getContext(),arrayIdCreated,arrayDescriptionCreated,listenerNew);
                recyclerView1.setAdapter(myAdapterData);
                recyclerView1.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Order>> call, Throwable t) {
                Toast.makeText(getContext(), "Failed to connect with database!!!", Toast.LENGTH_SHORT).show();
            }
        });

        connection.getPickedupOrders().enqueue(new Callback<List<Order>>() {
            @Override
            public void onResponse(Call<List<Order>> call, Response<List<Order>> response) {
                //Toast.makeText(getContext(), "Successful!", Toast.LENGTH_SHORT).show();
                for (Order order : response.body()){
                    arrayIdPickedup.add(order.getStore_id());
                    arrayDescriptionPickedup.add(order.getDescription());
                }
                MyAdapterNew myAdapterData = new MyAdapterNew(getContext(),arrayIdPickedup,arrayDescriptionPickedup,listenerNew);
                recyclerView2.setAdapter(myAdapterData);
                recyclerView2.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<Order>> call, Throwable t) {
                Toast.makeText(getContext(), "Failed to connect with database!!!", Toast.LENGTH_SHORT).show();
            }
        });

        recyclerView1 = view.findViewById(R.id.recyclerViewNewOrders);
        recyclerView2 = view.findViewById(R.id.recyclerViewInProgress);

        recyclerView1.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView2.setLayoutManager(new LinearLayoutManager(getContext()));


        MyAdapterNew myAdapterNew = new MyAdapterNew(getContext(),arrayIdCreated,arrayDescriptionCreated,listenerNew);
        MyAdapterInProgress myAdapterInProgress = new MyAdapterInProgress(getContext(),arrayIdPickedup,arrayDescriptionPickedup,listenerInProgress);

        recyclerView1.setAdapter(myAdapterNew);
        recyclerView2.setAdapter(myAdapterInProgress);

        return view;
    }

    private void setOnClickListenerNew() {
        listenerNew = new MyAdapterNew.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(getContext(),NewOrderActivity.class);
                startActivity(intent);
            }
        };
    }

    private void setOnClickListenerInProgress() {
        listenerInProgress = new MyAdapterInProgress.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent(getContext(),FinishOrderActivity.class);
                startActivity(intent);
            }
        };
    }
}
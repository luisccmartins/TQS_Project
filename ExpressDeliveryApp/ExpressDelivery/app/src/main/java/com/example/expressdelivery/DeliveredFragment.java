package com.example.expressdelivery;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.expressdelivery.Controller.AppController;
import com.example.expressdelivery.Model.Order;
import com.example.expressdelivery.Service.AppService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DeliveredFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DeliveredFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    RecyclerView recyclerView1;
    private MyAdapterDelivered.RecyclerViewClickListener listener;

    public DeliveredFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DeliveredFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DeliveredFragment newInstance(String param1, String param2) {
        DeliveredFragment fragment = new DeliveredFragment();
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
        View view = inflater.inflate(R.layout.fragment_delivered, container, false);

        List<Order> deliveredOrders = new ArrayList<Order>();

        setOnClickListenerDelivered();

        List<Integer> arrayIdDelivered = new ArrayList<Integer>();
        List<String> arrayDescriptionDelivered = new ArrayList<String>();

        AppService retrofitService = new AppService();
        AppController connection = retrofitService.getConnection();

        TextView textViewProfile  = getActivity().findViewById(R.id.textViewProfile);
        String profile = textViewProfile.getText().toString();

        if(profile.equals("No Rider logged")){
            Toast.makeText(getContext(), "You need to loggin to check orders", Toast.LENGTH_SHORT).show();
        } else {
            connection.getDeliveredOrders().enqueue(new Callback<List<Order>>() {
                @Override
                public void onResponse(Call<List<Order>> call, Response<List<Order>> response) {
                    //Toast.makeText(getContext(), "Successful!", Toast.LENGTH_SHORT).show();
                    List<Order> deliveredOrders = new ArrayList<Order>();
                    List<Integer> arrayIdCreated = new ArrayList<Integer>();
                    List<String> arrayDescriptionCreated = new ArrayList<String>();
                    for (Order order : response.body()){
                        deliveredOrders.add(order);
                        arrayIdDelivered.add(order.getId());
                        arrayDescriptionDelivered.add(order.getDescription());
                    }
                    MyAdapterDelivered myAdapterData = new MyAdapterDelivered(getContext(),deliveredOrders,arrayIdDelivered,arrayDescriptionDelivered,profile,listener);
                    recyclerView1.setAdapter(myAdapterData);
                    recyclerView1.getAdapter().notifyDataSetChanged();
                }

                @Override
                public void onFailure(Call<List<Order>> call, Throwable t) {
                    Toast.makeText(getContext(), "Failed to connect with database!!!", Toast.LENGTH_SHORT).show();
                }
            });
        }



        recyclerView1 = view.findViewById(R.id.recyclerViewDeliveredOrders);

        recyclerView1.setLayoutManager(new LinearLayoutManager(getContext()));

        MyAdapterDelivered myAdapterDelivered = new MyAdapterDelivered(getContext(),deliveredOrders,arrayIdDelivered,arrayDescriptionDelivered,profile,listener);

        recyclerView1.setAdapter(myAdapterDelivered);

        return view;
    }

    private void setOnClickListenerDelivered() {
        listener = new MyAdapterDelivered.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position, List<Order> array, String profile) {
                Intent intent = new Intent(getContext(),DeliveredActivity.class);
                intent.putExtra("orderId", String.valueOf(array.get(position).getId()));
                intent.putExtra("orderDescription", array.get(position).getDescription());
                intent.putExtra("orderDestination", array.get(position).getDestination());
                intent.putExtra("orderPhoneNumber", String.valueOf(array.get(position).getClient_phone_number()));
                intent.putExtra("riderEmail", profile);
                startActivity(intent);
            }
        };
    }
}
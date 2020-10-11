package calories.com.Fragments;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;

import java.text.DateFormat;
import java.util.Calendar;

import calories.com.LoginActivity;
import calories.com.R;

public class HomeFragment extends Fragment {

    private TextView tv_kebutuhan_kalori_tubuh;
    private TextView tv_batas_kalori_makan;
    private TextView alert;
    private TextView tv_date;
    private Double strtext;
    private Double strtextkalorimakanan;
    private MaterialButton mtbn_logout;


    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        initView(v);
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }



    public void initView(View rootView){
        tv_kebutuhan_kalori_tubuh = rootView.findViewById(R.id.tv_kebutuhan_kalori_tubuh);
        tv_batas_kalori_makan = rootView.findViewById(R.id.tv_batas_kalori_makan);
        mtbn_logout = rootView.findViewById(R.id.mbtn_logout);

        //tanggal sekarang
        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance().format(calendar.getTime());
        tv_date = rootView.findViewById(R.id.tv_date);
        tv_date.setText(currentDate);


        //sp kalori tubuh
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
        strtext = (double) sharedPreferences.getFloat("Hasil Kalori",0);
        if(strtext != null){
            tv_kebutuhan_kalori_tubuh.setText(String.format("%.2f", strtext));
        }

        //sp kalori makan
        SharedPreferences totalKaloriPreferences = getActivity().getSharedPreferences("PrefTotalKalori", Context.MODE_PRIVATE);
        strtextkalorimakanan = (double) totalKaloriPreferences.getFloat("Total Kalori",0);
        if(strtextkalorimakanan != null){
            tv_batas_kalori_makan.setText(String.format("%.2f", strtextkalorimakanan));
        }

        //kondisi overkalori
        if (strtextkalorimakanan > strtext){

            AlertDialog alertDialog = new AlertDialog.Builder(getActivity())
                    .create();
            alertDialog.setCancelable(false);
            alertDialog.setTitle("OVER KALORI!");
            alertDialog.setMessage("Harap berhati-hati, jumlah kalori yang Anda konsumsi telah melebihi jumlah kebutuhan kalori tubuh Anda.");
            alertDialog.setButton("OK", new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            alertDialog.show();
        }

        mtbn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), LoginActivity.class);
                startActivity(i);
        }
        });

    }

}
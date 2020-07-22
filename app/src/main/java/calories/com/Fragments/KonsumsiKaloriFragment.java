package calories.com.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import calories.com.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class KonsumsiKaloriFragment extends Fragment {

    public KonsumsiKaloriFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_konsumsi_kalori, container, false);
    }
}

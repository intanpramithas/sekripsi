package calories.com;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {

    private TextView tv_batas_kalori_tubuh;
    private Double strtext;
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
        tv_batas_kalori_tubuh = rootView.findViewById(R.id.tv_batas_kalori_tubuh);
//        strtext = getArguments().getDouble("hasilkalori");
//        if(strtext != null){
//            tv_batas_kalori_tubuh.setText(strtext.toString());
//        }

    }
}
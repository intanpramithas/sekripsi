package calories.com;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainFragment extends Fragment {

    private BottomNavigationView bottomNavigationView;
    private FrameLayout flFragmentContainer;

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_main, container, false);
        initView(v);
        return v;

    }

    private void initView(View rootView){
        bottomNavigationView = rootView.findViewById(R.id.bottom_nav_view);
        flFragmentContainer = rootView.findViewById(R.id.fl_fragment_container);
        switchFragment(new HomeFragment());

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.navigation_home:
                        switchFragment(new HomeFragment());
                        return true;
                    case R.id.navigation_hitung:
                        switchFragment(new HitungKaloriFragment());
                        return true;
                    case R.id.navigation_konsumsikalori:
                        switchFragment(new KonsumsiKaloriFragment());
                        return true;
                    case R.id.navigation_kalorimakanan:
                        switchFragment(new DaftarKaloriFragment());
                        return true;
                }
                return false;
            }
        });
    }

    private void switchFragment(Fragment newFragment){
        FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fl_fragment_container, newFragment);
        fragmentTransaction.commit();
    }
}

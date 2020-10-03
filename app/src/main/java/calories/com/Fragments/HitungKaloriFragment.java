package calories.com.Fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import calories.com.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HitungKaloriFragment extends Fragment {

    Spinner spinnerActivityLevel;
    private TextInputEditText beratbadan;
    private TextInputEditText tinggibadan;
    private TextInputEditText usia;
    private RadioGroup rg_jeniskelamin;
    private RadioButton rb_male;
    private RadioButton rb_female;
    private String tamp_jeniskelamin;
    private Button btn_hitung;
    private double BMR;
    private double hasilkalori;
    private TextInputLayout cont_beratbadan, cont_tinggibadan, cont_usia;
    private TextView tv_eror_jeniskelamin;
    private TextView tv_eror_levelaktivitas;

    public HitungKaloriFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_hitung_kalori, container, false);

        initView(v);

        btn_hitung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                if (isValidForm() == true) {
                    hitungKalori();
                }
            }
        });

        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setSpinner();
    }

    public void initView(View rootView) {
        cont_beratbadan = rootView.findViewById(R.id.til_body_weight);
        cont_tinggibadan = rootView.findViewById(R.id.til_body_height);
        cont_usia = rootView.findViewById(R.id.til_age);
        spinnerActivityLevel = rootView.findViewById(R.id.spinner_activity_level);
        beratbadan = rootView.findViewById(R.id.tiet_body_weight);
        tinggibadan = rootView.findViewById(R.id.tiet_body_height);
        usia = rootView.findViewById(R.id.tiet_age);
        btn_hitung = rootView.findViewById(R.id.button_hitung);
        rb_male = rootView.findViewById(R.id.rb_male);
        rb_female = rootView.findViewById(R.id.rb_female);
        tv_eror_jeniskelamin = rootView.findViewById(R.id.tv_eror_jeniskelamin);
        tv_eror_levelaktivitas = rootView.findViewById(R.id.tv_eror_levelaktivitas);
        rg_jeniskelamin = rootView.findViewById(R.id.rg_sex);

        rg_jeniskelamin.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch(checkedId) {
                    case R.id.rb_male:
                        tamp_jeniskelamin = "Laki-laki";
                        break;
                    case R.id.rb_female:
                        tamp_jeniskelamin = "Perempuan";
                        break;
                }
            }
        });

        //change listener
        beratbadan.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                cont_beratbadan.setError(null);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        tinggibadan.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                cont_tinggibadan.setError(null);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        usia.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                cont_usia.setError(null);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }

    public void setSpinner() {
        String[] listActivityLevel = {
                "Pilih Level Aktivitas",
                "Sangat Jarang Olahraga",
                "Jarang Olahraga (1-3 hari / minggu)",
                "Normal Olahraga (3-5 hari / minggu)",
                "Sering Olahraga (6-7 hari / minggu)",
                "Sangat Sering Olahraga (tiap hari bisa 2 kali dalam sehari)"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), R.layout.item_spinner, listActivityLevel);
        spinnerActivityLevel.setAdapter(adapter);
    }

    public boolean isValidForm(){
        boolean isValid = true;
        boolean isValidBeratbadan = true;
        boolean isValidTinggibadan = true;
        boolean isValidJeniskelamin = true;
        boolean isValidUsia = true;
        boolean isValidLevelaktivitas = true;

        if (beratbadan.getText().toString().isEmpty()) {
            cont_beratbadan.setError("Berat badan tidak boleh kosong!");
            isValidBeratbadan = false;
        }
        if (tinggibadan.getText().toString().isEmpty()) {
            cont_tinggibadan.setError("Tinggi badan tidak boleh kosong!");
            isValidTinggibadan = false;
        }
        if (!rb_male.isChecked() || !rb_female.isChecked()) {
            tv_eror_jeniskelamin.setTextColor(Color.RED);
            tv_eror_jeniskelamin.setText("Jenis kelamin tidak boleh kosong!");
            isValidJeniskelamin = false;
        }
        if (rb_male.isChecked() || rb_female.isChecked()){
            tv_eror_jeniskelamin.setText("");
            isValidJeniskelamin = true;
        }
        if (usia.getText().toString().isEmpty()){
            cont_usia.setError("Usia tidak boleh kosong!");
            isValidUsia = false;
        }
        if (spinnerActivityLevel.getSelectedItem().toString().equals("Pilih Level Aktivitas")){
            tv_eror_levelaktivitas.setTextColor(Color.RED);
            tv_eror_levelaktivitas.setText("Anda harus memilih level aktivitas!");
            isValidLevelaktivitas = false;
        }
        if (!spinnerActivityLevel.getSelectedItem().toString().equals("Pilih Level Aktivitas")){
            tv_eror_levelaktivitas.setText("");
            isValidLevelaktivitas = true;
        }
        if (isValidBeratbadan == true && isValidTinggibadan == true && isValidJeniskelamin == true
                && isValidUsia == true && isValidLevelaktivitas == true){

            isValid = true;
        }else {

            isValid = false;
        }
        return isValid;
    }


    public void hitungKalori() {
        if (!isValidForm()) return;
        if (tamp_jeniskelamin == "Laki-laki") {
            BMR = 66.47 + (13.75 * Integer.parseInt(beratbadan.getText().toString()))
                    + (5 * Integer.parseInt((tinggibadan.getText().toString())))
                    - (6.76 * Integer.parseInt(usia.getText().toString()));
        } else if (tamp_jeniskelamin == "Perempuan") {
            BMR = 655.1 + (9.56 * Integer.parseInt(beratbadan.getText().toString()))
                    + (1.85 * Integer.parseInt((tinggibadan.getText().toString())))
                    - (4.68 * Integer.parseInt(usia.getText().toString()));
        }

        if (spinnerActivityLevel.getSelectedItem().toString().trim().equals("Sangat Jarang Olahraga")) {
            hasilkalori = BMR * 1.2;
        } else if (spinnerActivityLevel.getSelectedItem().toString().trim().equals("Jarang Olahraga (1-3 hari / minggu)")) {
            hasilkalori = BMR * 1.375;
        } else if (spinnerActivityLevel.getSelectedItem().toString().trim().equals("Normal Olahraga (3-5 hari / minggu)")) {
            hasilkalori = BMR * 1.55;
        } else if (spinnerActivityLevel.getSelectedItem().toString().trim().equals("Sering Olahraga (6-7 hari / minggu)")) {
            hasilkalori = BMR * 1.725;
        } else if (spinnerActivityLevel.getSelectedItem().toString().trim().equals("Sangat Sering Olahraga (tiap hari bisa 2 kali dalam sehari)")) {
            hasilkalori = BMR * 1.9;
        } else {
            hasilkalori = BMR;
        }

        Toast.makeText(getActivity(), hasilkalori + "", Toast.LENGTH_SHORT).show();

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putInt("berat badan", Integer.parseInt(beratbadan.getText().toString()));
        editor.putInt("tinggi badan", Integer.parseInt(tinggibadan.getText().toString()));
        editor.putInt("usia", Integer.parseInt(usia.getText().toString()));
        editor.putString("jenis kelamin", tamp_jeniskelamin);
        editor.putString("level aktivitas", spinnerActivityLevel.getSelectedItem().toString().trim());
        editor.putFloat("Hasil Kalori", (float) hasilkalori);

        editor.apply();
    }


//        String tamp_hasil_kalori;
//        tamp_hasil_kalori = hasilkalori + "";
//        Bundle bundle = new Bundle();
//        bundle.putDouble("hasilkalori", hasilkalori);
//        HomeFragment homeFragment = new HomeFragment();
//        homeFragment.setArguments(bundle);

}

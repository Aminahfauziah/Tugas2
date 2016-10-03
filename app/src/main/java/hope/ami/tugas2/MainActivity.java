package hope.ami.tugas2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {

    @BindView(R.id.etnim) EditText _nim;
    @BindView(R.id.etnama) EditText _nama;
    @BindView(R.id.cb1) CheckBox _cb1;
    @BindView(R.id.cb2) CheckBox _cb2;
    @BindView(R.id.cb3) CheckBox _cb3;
    @BindView(R.id.btsubmit) Button _btsubmit;

    String strnama, strnim, strcb1, strcb2, strcb3, simpancb1, simpancb2, simpancb3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        strcb1 = _cb1.getText().toString();
        strcb2 = _cb2.getText().toString();
        strcb3 = _cb3.getText().toString();

        simpancb1 = ""; simpancb2 = ""; simpancb3 = "";

        _cb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(_cb1.isChecked()) {
                    simpancb1 = strcb1;
                }
                else
                    simpancb1 = "";
            }
        });

        _cb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(_cb2.isChecked()){
                    simpancb2 = strcb2;
                }
                else
                    simpancb2 = "";
            }
        });

        _cb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(_cb3.isChecked()){
                    simpancb3 = strcb3;
                }
                else
                    simpancb3 = "";
            }
        });

        _btsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                strnim = _nim.getText().toString();
                strnama = _nama.getText().toString();

                Bundle b = new Bundle();
                b.putString("strnim", strnim);
                b.putString("strnama", strnama);
                b.putString("cb1", simpancb1);
                b.putString("cb2", simpancb2);
                b.putString("cb3", simpancb3);

                Intent i = new Intent(MainActivity.this, halamanKrs.class);
                i.putExtras(b);
                startActivity(i);
                finish();



                /*Intent itangkap = new Intent(IntentActivity.this, TangkapIntent.class);
                itangkap.putExtra("strnim", strnim);
                itangkap.putExtra("strnama", strnama);
                itangkap.putExtra("cb1", simpancb1);
                itangkap.putExtra("cb2", simpancb2);
                itangkap.putExtra("cb3", simpancb3);
                startActivity(itangkap);*/
            }
        });

    }
}
package hope.ami.tugas2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by acer on 10/4/2016.
 */
public class halamanKrs extends AppCompatActivity{

        @BindView(R.id.tvnim) TextView tvnim;
        @BindView(R.id.tvnama) TextView tvnama;
        @BindView(R.id.lvlist) ListView lvlist;
        @BindView(R.id.btnback) Button kembali;

        String nim, nama, cb1, cb2, cb3;
        ArrayList<String> matkul = new ArrayList<String>();

        ArrayAdapter adapter;

        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.hasil_layout);

            ButterKnife.bind(this);

            Bundle b = getIntent().getExtras();

            assert b != null;
            nim = b.getString("strnim");
            nama = b.getString("strnama");
            cb1 = b.getString("cb1");
            cb2 = b.getString("cb2");
            cb3 = b.getString("cb3");
        /*cb3 = getIntent().getStringExtra("cb3");*/


            tvnim.setText(nim);
            tvnama.setText(nama);

            if(!cb1.equals("")){
                matkul.add(cb1);
            }
            if(!cb2.equals("")){
                matkul.add(cb2);
            }
            if(!cb3.equals("")){
                matkul.add(cb3);
            }

            adapter = new ArrayAdapter<String>(this, R.layout.item_list, R.id.item, matkul);

            lvlist.setAdapter(adapter);

            kembali.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent back = new Intent(halamandua.this, MainActivity.class);
                    startActivity(back);
                    finish();
                }
            });

        /*Toast.makeText(TangkapIntent.this, "NIM maneh: " + nim + "\nNgaran maneh: " + nama +
                "\n MataKuliah: " + s, Toast.LENGTH_LONG).show();*/
        }
    }
}

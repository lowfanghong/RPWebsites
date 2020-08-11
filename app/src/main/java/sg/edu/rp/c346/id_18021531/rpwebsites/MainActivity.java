package sg.edu.rp.c346.id_18021531.rpwebsites;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    Spinner spinner1, spinner2;
    Button btnGo;
    ArrayList<String> alCat;
    ArrayAdapter<String> aaCat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner1 = findViewById(R.id.spinnerCat);
        spinner2 = findViewById(R.id.spinnerSubCat);
        btnGo = findViewById(R.id.buttonGo);
        alCat = new ArrayList<>();
        aaCat = new ArrayAdapter<>(this,android.
                R.layout.simple_spinner_dropdown_item,alCat);
       spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               alCat.clear();
               switch (position){
                   case 0:
                       String[] strNumbers = getResources().getStringArray(R.array.sub_RP);
//Convert Array to List and add to the ArrayList
                       alCat.addAll(Arrays.asList(strNumbers));
                       spinner2.setAdapter(aaCat);
                       break;
                   case 1:
                       String[]  strNumber = getResources().getStringArray(R.array.sub_SOI);
//Convert Array to List and add to the ArrayList
                       alCat.addAll(Arrays.asList(strNumber));
                       spinner2.setAdapter(aaCat);
                       break;

               }
               aaCat.notifyDataSetChanged();
           }

           @Override
           public void onNothingSelected(AdapterView<?> parent) {

           }
       });
      btnGo.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              int pos = spinner1.getSelectedItemPosition();
              int pos1 = spinner2.getSelectedItemPosition();
              alCat.clear();
              if (pos == 0 && pos1 == 0 ){
                  Intent intent = new Intent(Intent.ACTION_VIEW);
                  // Set the URL to be used.
                  intent.setData(Uri.parse("https://www.rp.edu.sg/"));
                  startActivity(intent);
              }else if (pos == 0 && pos1 == 1){
                  Intent intent1 = new Intent(Intent.ACTION_VIEW);
                  // Set the URL to be used.
                  intent1.setData(Uri.parse("https://www.rp.edu.sg/student-life"));
                  startActivity(intent1);
              }else if (pos == 1 && pos1 ==0){
                  Intent intent2 = new Intent(Intent.ACTION_VIEW);
                  // Set the URL to be used.
                  intent2.setData(Uri.parse("https://www.rp.edu.sg/soi/full-time-diplomas/details/r47"));
                  startActivity(intent2);
              }else {
                  Intent intent3 = new Intent(Intent.ACTION_VIEW);
                  // Set the URL to be used.
                  intent3.setData(Uri.parse("https://www.rp.edu.sg/soi/full-time-diplomas/details/r12"));
                  startActivity(intent3);
              }

          }
      });

    }
}
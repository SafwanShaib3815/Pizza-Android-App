/*
 *Safwan Shaib
 *N01343815
 *CENG-258-RNC
*/
package safwan.shaib.n01343815;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.app.AlertDialog;

import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SafwanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safwan);

        Button next = findViewById(R.id.next_btn1);
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.Safwan_RadioGroup);
        String[] pizza_stores = getResources().getStringArray(R.array.pizza_stores);

        RadioButton rb1 = (RadioButton) findViewById(R.id.radioButton1);
        RadioButton rb2 = (RadioButton) findViewById(R.id.radioButton2);
        RadioButton rb3 = (RadioButton) findViewById(R.id.radioButton3);
        RadioButton rb4 = (RadioButton) findViewById(R.id.radioButton4);
        rb1.setText(pizza_stores[0]);
        rb2.setText(pizza_stores[1]);
        rb3.setText(pizza_stores[2]);
        rb4.setText(pizza_stores[3]);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i)
            {
                inform();
            }
        });
        //Next button to move to the selected option's screen
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioGroup radioGroup = (RadioGroup) findViewById(R.id.Safwan_RadioGroup);
                int selectedRbId = radioGroup.getCheckedRadioButtonId();
                //Validate a selection
                if (selectedRbId == -1) {
                    Toast.makeText(getApplicationContext(), R.string.validateSelection, Toast.LENGTH_SHORT).show();
                }
                if (selectedRbId == R.id.radioButton1) {
                    //Toast.makeText(getApplicationContext(), "move to bt1 special screen", Toast.LENGTH_LONG).show();
                }
                if (selectedRbId == R.id.radioButton2) {
                    //btn2 second screen
                }
                if (selectedRbId == R.id.radioButton3) {
                    //btn3 second screen
                }
                if (selectedRbId == R.id.radioButton4){
                    //btn4 seconf screen
                }
            }
        });
    }
        //To inform user what radio button being chosen
        public void inform()
        {
            RadioButton rb1 = (RadioButton) findViewById(R.id.radioButton1);
            RadioButton rb2 = (RadioButton) findViewById(R.id.radioButton2);
            RadioButton rb3 = (RadioButton) findViewById(R.id.radioButton3);
            RadioButton rb4 = (RadioButton) findViewById(R.id.radioButton4);
            if(rb1.isChecked()){
                Toast.makeText(getApplicationContext(), R.string.selectionToast1,Toast.LENGTH_SHORT).show();
            }
            if(rb2.isChecked()){
                Toast.makeText(getApplicationContext(), R.string.selectionToast2,Toast.LENGTH_SHORT).show();
            }
            if(rb3.isChecked()){
                Toast.makeText(getApplicationContext(), R.string.selectionToast3,Toast.LENGTH_SHORT).show();
            }
            if(rb4.isChecked()) {
                Toast.makeText(getApplicationContext(), R.string.selectionToast4,Toast.LENGTH_SHORT).show();
            }
        }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.app_menu, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent = null;
        switch (item.getItemId()) {
            case R.id.safwan_help:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.help_link)));
                startActivity(intent);
                break;
            case R.id.safwan_pizza:
                intent = new Intent(Intent.ACTION_DIAL, Uri.parse(getString(R.string.phone_number)));
                startActivity(intent);
                break;
            case R.id.safwan_safwan:
                intent = new Intent(this,MyInfoActivity.class);
                startActivity(intent);
                break;
        }
        return true;
    }

    //confirm exiting alert dialog
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.alertMsg1)
        .setMessage(R.string.alertMsg2)
        .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        })
        .setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        }).setIcon(R.drawable.exiticon)
        .show();
    }


}
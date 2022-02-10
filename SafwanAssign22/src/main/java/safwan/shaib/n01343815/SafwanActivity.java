/*
 *Safwan Shaib
 *N01343815
 *CENG-258-RNC
*/
package safwan.shaib.n01343815;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SafwanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safwan);

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.Safwan_RadioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i)
            {
                RadioButton rb1 = (RadioButton) findViewById(R.id.radioButton1);
                if(rb1.isChecked()){
                    //do something
                }
                RadioButton rb2 = (RadioButton) findViewById(R.id.radioButton2);
                if(rb2.isChecked()){
                    //do something
                }
                RadioButton rb3 = (RadioButton) findViewById(R.id.radioButton3);
                if(rb3.isChecked()){
                    //do something
                }
                RadioButton rb4 = (RadioButton) findViewById(R.id.radioButton4);
                if(rb4.isChecked()){
                    //do something
                }
            }
        }


        );
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
                intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:(416)504-1044"));
                startActivity(intent);
                break;
            case R.id.safwan_safwan:
                intent = new Intent(this,MyInfoActivity.class);
                startActivity(intent);
                break;
        }
        return true;
    }




}
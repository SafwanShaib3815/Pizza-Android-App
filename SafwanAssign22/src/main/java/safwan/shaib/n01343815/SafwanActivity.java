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
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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

import java.io.ByteArrayOutputStream;

public class SafwanActivity extends AppCompatActivity {
    Intent intent = null;

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

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i)
            {
                inform();
            }
        });
        //the Next button to move to the selected option's screen
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioGroup radioGroup = (RadioGroup) findViewById(R.id.Safwan_RadioGroup);
                int selectedRbId = radioGroup.getCheckedRadioButtonId();
                intent = new Intent(getApplicationContext(), SafwanOrderActivity.class);

                //Validate a selection
                if (selectedRbId == -1) {
                    Toast.makeText(getApplicationContext(), R.string.validateSelection1, Toast.LENGTH_SHORT).show();
                }
                if (selectedRbId == R.id.radioButton1) {
                    Button rb1 = (Button) findViewById(R.id.radioButton1);

                    Bitmap bitmap = BitmapFactory.decodeResource
                            (getResources(), R.drawable.pizzahut_image);
                    ByteArrayOutputStream bos = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 50, bos);
                    intent.putExtra(getString(R.string.storeImage), bos.toByteArray());

                    String sendHut = rb1.getText().toString();
                    intent.putExtra(getString(R.string.storeSelection), sendHut);
                    startActivity(intent);
                }
                if (selectedRbId == R.id.radioButton2) {
                    Button rb2 = (Button) findViewById(R.id.radioButton2);

                    Bitmap bitmap = BitmapFactory.decodeResource
                            (getResources(), R.drawable.nova_image);
                    ByteArrayOutputStream bos = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 50, bos);
                    intent.putExtra(getString(R.string.storeImage), bos.toByteArray());

                    String sendNova = rb2.getText().toString();
                    intent.putExtra(getString(R.string.storeSelection), sendNova);
                    startActivity(intent);
                }
                if (selectedRbId == R.id.radioButton3) {
                    Button rb3 = (Button) findViewById(R.id.radioButton3);

                    Bitmap bitmap = BitmapFactory.decodeResource
                            (getResources(), R.drawable.dominos_image);
                    ByteArrayOutputStream bos = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 50, bos);
                    intent.putExtra(getString(R.string.storeImage), bos.toByteArray());

                    String sendDominos = rb3.getText().toString();
                    intent.putExtra(getString(R.string.storeSelection), sendDominos);
                    startActivity(intent);
                }
                if (selectedRbId == R.id.radioButton4){
                    Button rb4 = (Button) findViewById(R.id.radioButton4);

                    Bitmap bitmap = BitmapFactory.decodeResource
                            (getResources(), R.drawable.pizzapizza_image);
                    ByteArrayOutputStream bos = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 50, bos);
                    intent.putExtra(getString(R.string.storeImage), bos.toByteArray());

                    String sendPizzapizza = rb4.getText().toString();
                    intent.putExtra(getString(R.string.storeSelection), sendPizzapizza);
                    startActivity(intent);
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

//Implementing menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.app_menu, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
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
        }).setIcon(R.drawable.exit_icon)
        .show();
    }


}
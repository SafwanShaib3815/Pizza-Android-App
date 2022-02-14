package safwan.shaib.n01343815;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SafwanCheckoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safwan_checkout);

        //get textviews from this layout to contain user info from payment screen
        TextView name, email, phone, addr, cCard, pin, cExp, delivery, confirm;
        Boolean isDelivery;
        Button chckOut = (Button) findViewById(R.id.chck_out);

        confirm = (TextView) findViewById(R.id.confirm);

        name = (TextView) findViewById(R.id.get_name);
        name.setText(getIntent().getStringExtra(getResources().getString(R.string.send_name)));
        email = (TextView) findViewById(R.id.get_email);
        email.setText(getIntent().getStringExtra(getResources().getString(R.string.send_email)));
        phone = (TextView) findViewById(R.id.get_phone);
        phone.setText(getIntent().getStringExtra(getResources().getString(R.string.send_phone)));
        addr = (TextView) findViewById(R.id.get_address);
        addr.setText(getIntent().getStringExtra(getResources().getString(R.string.send_address)));
        cCard = (TextView) findViewById(R.id.get_card);
        cCard.setText(getIntent().getStringExtra(getResources().getString(R.string.send_card)));
        //Do something with the pin here (been sent)
        cExp = (TextView) findViewById(R.id.get_expiry);
        cExp.setText(getIntent().getStringExtra(getResources().getString(R.string.send_expiry)));

        delivery = (TextView) findViewById(R.id.get_delivery);
        if(getIntent().getExtras().getBoolean(getResources().getString(R.string.is_delivery))){
            delivery.setText(R.string.delivery_msg);
        }
        else {
            delivery.setText(R.string.pickup_msg);
        }

        chckOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
                builder.setTitle(R.string.alert2_title)
                        .setMessage(R.string.alert2_msg)
                        .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                int random = (int)(Math.random() * 50 + 1);
                                String confMsg = getString(R.string.confMsg) + random;
                                confirm.setText(confMsg);
                            }
                        })
                        .setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                                Intent intent = new Intent(getApplicationContext(), SafwanActivity.class);
                                startActivity(intent);
                            }
                        })
                        .show();
            }
        });


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
}
package safwan.shaib.n01343815;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class SafwanPaymentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safwan_payment);

        Button prev;
        ImageButton order;
        //Get components from this layout to edit
        TextView storeSelection, typeSelection, sizeSelection, toppingsSelection;
        storeSelection = (TextView) findViewById(R.id.rcv_store_selection2);
        typeSelection = (TextView) findViewById(R.id.rcv_type);
        sizeSelection = (TextView) findViewById(R.id.rcv_size);
        toppingsSelection = (TextView) findViewById(R.id.rcv_toppings);
        order = (ImageButton) findViewById(R.id.order_btn);

        //Recive selected store name
        storeSelection.setText(getIntent().getStringExtra(getString(R.string.storeSelection)));
        //Recieve selected store image
        ImageView storeImage = (ImageView) findViewById(R.id.rcv_store_img2);
            Bundle bundle = getIntent().getExtras();
            int imgval = bundle.getInt(getString(R.string.storeImage));
            storeImage.setImageResource(imgval);
        //Recive selected type
        typeSelection.setText(getIntent().getStringExtra("typeSelection"));
        //Recive selected size
        sizeSelection.setText(getIntent().getStringExtra("sizeSelection"));
        //Recive selected toppings
        toppingsSelection.setText(getIntent().getStringExtra("toppingsSelection"));


        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //get components from this layout to validate
                EditText name, email, phone, addr, cCard, pin, cExp;
                name = (EditText) findViewById(R.id.user_name);
                email = (EditText) findViewById(R.id.user_email);
                phone = (EditText) findViewById(R.id.user_phone);
                addr = (EditText) findViewById(R.id.user_address);
                cCard = (EditText) findViewById(R.id.user_creditCard);
                pin = (EditText) findViewById(R.id.user_pin);
                cExp = (EditText) findViewById(R.id.user_creditEx);

                Switch delivery = (Switch) findViewById(R.id.switch1);
                boolean delivery_switch = delivery.isChecked();

                //Validate inputs
                if(TextUtils.isEmpty(name.getText())){
                    name.setError(getString(R.string.validate_name));
                }
                if(TextUtils.isEmpty(email.getText()) && TextUtils.isEmpty(phone.getText())){
                    Toast.makeText(getApplicationContext(),R.string.validate_contactInfo, Toast.LENGTH_LONG).show();
                }
                if(TextUtils.isEmpty(addr.getText())){
                    addr.setError(getString(R.string.validate_address));
                }
                if(TextUtils.isEmpty(cCard.getText())){
                    cCard.setError(getString(R.string.validate_card));
                }
                if(TextUtils.isEmpty(pin.getText())){
                    pin.setError(getString(R.string.validate_pin));
                }
                if(TextUtils.isEmpty(cExp.getText())){
                    cExp.setError(getString(R.string.validate_expDate));
                }
                else{
                    //Send user data to checkout screen
                    Intent intent = new Intent(getApplicationContext(), SafwanCheckoutActivity.class);
                    intent.putExtra(getString(R.string.send_name),name.getText().toString());
                    intent.putExtra(getString(R.string.send_email),email.getText().toString());
                    intent.putExtra(getString(R.string.send_phone),phone.getText().toString());
                    intent.putExtra(getString(R.string.send_address),addr.getText().toString());
                    intent.putExtra(getString(R.string.send_card),cCard.getText().toString());
                    intent.putExtra(getString(R.string.send_pin),pin.getText().toString());
                    intent.putExtra(getString(R.string.send_expiry),cExp.getText().toString());
                    intent.putExtra(getString(R.string.is_delivery), delivery_switch);
                    startActivity(intent);
                }

            }
        });



        //Previous button
        prev = (Button) findViewById(R.id.prev_btn2);
        prev.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(),SafwanActivity.class);
            startActivity(intent);
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
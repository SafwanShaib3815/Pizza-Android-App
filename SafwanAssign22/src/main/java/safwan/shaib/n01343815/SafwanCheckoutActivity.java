package safwan.shaib.n01343815;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class SafwanCheckoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safwan_checkout);

        //get textviews from this layout to contain user info from payment screen
        TextView name, email, phone, addr, cCard, pin, cExp;
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
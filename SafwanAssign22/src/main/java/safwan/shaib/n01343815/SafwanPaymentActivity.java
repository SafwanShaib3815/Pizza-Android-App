package safwan.shaib.n01343815;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SafwanPaymentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safwan_payment);

        Button next,prev;
        //Get text views from this layout to edit
        TextView storeSelection, typeSelection, sizeSelection, toppingsSelection;
        storeSelection = (TextView) findViewById(R.id.rcv_store_selection2);
        typeSelection = (TextView) findViewById(R.id.rcv_type);
        sizeSelection = (TextView) findViewById(R.id.rcv_size);
        toppingsSelection = (TextView) findViewById(R.id.rcv_toppings);

        //Revive selected store name
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
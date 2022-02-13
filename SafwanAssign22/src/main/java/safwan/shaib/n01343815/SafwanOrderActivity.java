package safwan.shaib.n01343815;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class SafwanOrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safwan_order);

        TextView storeSelection = (TextView) findViewById(R.id.rcv_store_selection);
        ImageView storeImage = (ImageView) findViewById(R.id.rcv_store_img);
        Button next,prev;
        storeSelection.setText(getIntent().getStringExtra(getString(R.string.storeSelection)));

        Bitmap bitmap = BitmapFactory.decodeByteArray(
                getIntent().getByteArrayExtra(getString(R.string.storeImage)),
                0, getIntent().getByteArrayExtra(getString(R.string.storeImage)).length);

        storeImage.setImageBitmap(bitmap);

        //Next button
        next = (Button) findViewById(R.id.next_btn2);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, R.string.sbtext1, Snackbar.LENGTH_LONG)
                        .setAction(getString(R.string.sbyes), new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
//                                        Intent intent = new Intent(getApplicationContext(),SafwanPaymentActivity.class);
//                                        startActivity(intent);
                                    }
                                }
                        )
                        .setActionTextColor(getResources().getColor(android.R.color.holo_purple))
                        .show();
            }
        });




        //Previous button
        prev = (Button) findViewById(R.id.prev_btn1);
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),SafwanActivity.class);
                startActivity(intent);
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
package safwan.shaib.n01343815;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MyInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_info);
        final TextView textView = (TextView) findViewById(R.id.safwan_info);
        textView.setText(getString(R.string.myInfo));

    }
}
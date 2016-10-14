package music.chaanel.com.musicchannel.W.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import music.chaanel.com.musicchannel.R;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        getSupportFragmentManager().beginTransaction().replace(R.id.container,new Frg_Main()).commit();
    }
}

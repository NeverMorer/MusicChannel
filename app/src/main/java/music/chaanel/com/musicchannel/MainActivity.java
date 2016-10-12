package music.chaanel.com.musicchannel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import music.chaanel.com.musicchannel.homepage.view.HomePageFragment;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    @BindView(R.id.rg_main)
    RadioGroup radioGroup;
    private HomePageFragment homePageFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        radioGroup.setOnCheckedChangeListener(this);
        homePageFragment = new HomePageFragment();
        RadioButton rb_home = (RadioButton) findViewById(R.id.rb_home_main);
        rb_home.setChecked(true);
        getSupportFragmentManager().beginTransaction().replace(R.id.container_main,homePageFragment).commit();

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i) {
            case R.id.rb_home_main:

                break;
        }
    }
}

package music.chaanel.com.musicchannel;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import music.chaanel.com.musicchannel.W.View.Frg_Main;
import music.chaanel.com.musicchannel.homepage.view.HomePageFragment;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    @BindView(R.id.rg_main)
    RadioGroup radioGroup;
    private HomePageFragment homePageFragment;
    private Frg_Main vFragment;
    private Fragment lastFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initView();
    }

    private void initView() {

        radioGroup.setOnCheckedChangeListener(this);
        RadioButton rb_home = (RadioButton) findViewById(R.id.rb_home_main);
        rb_home.setChecked(true);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i) {
            case R.id.rb_home_main:
                if (homePageFragment == null) {
                    homePageFragment = new HomePageFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.container_main,homePageFragment).commit();
                }else{
                    getSupportFragmentManager().beginTransaction().show(homePageFragment).hide(lastFragment).commit();
                }
                lastFragment = homePageFragment;
                break;
            case R.id.rb_v_main:
                if (vFragment == null) {
                    vFragment = new Frg_Main();
                    getSupportFragmentManager().beginTransaction().add(R.id.container_main,vFragment).hide(lastFragment).commit();
                }else{
                    getSupportFragmentManager().beginTransaction().show(vFragment).hide(lastFragment).commit();
                }
                lastFragment = vFragment;
                break;
        }
    }


}

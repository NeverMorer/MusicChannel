package music.chaanel.com.musicchannel.W.View;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import music.chaanel.com.musicchannel.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Frg_Main extends Fragment implements RadioGroup.OnCheckedChangeListener {

    private Fragment Album;
    private Fragment China;
    private Fragment MV;
    private Fragment lastFrg;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_frg__v, container, false);
        RadioGroup group = ((RadioGroup) v.findViewById(R.id.radiogroup_v));
        group.setOnCheckedChangeListener(this);
        MV = new Frg_MV();
        getChildFragmentManager().beginTransaction().replace(R.id.container,MV).commit();
        lastFrg = MV;
        return v;
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
        switch (checkedId) {
            case R.id.rb_alb:
                if(Album==null)
                {
                    Album = new Frg_Album();
                    fragmentTransaction.hide(lastFrg).add(R.id.container,Album);
                    lastFrg = Album;
                }
                else if(lastFrg!=Album)
                {
                    fragmentTransaction.hide(lastFrg).show(Album);
                    lastFrg = Album;
                }
                break;
            case R.id.rb_cvc:
                if(China==null)
                {
                    China = new Frg_China();
                    fragmentTransaction.hide(lastFrg).add(R.id.container,China);
                    lastFrg = China;
                }
                else if(lastFrg!=China)
                {
                    fragmentTransaction.hide(lastFrg).show(China);
                    lastFrg = China;
                }
                break;
            case R.id.rb_mv:
                if(MV==null)
                {
                    MV = new Frg_MV();
                    fragmentTransaction.hide(lastFrg).add(R.id.container,MV);
                    lastFrg = MV;
                }
                else if(lastFrg!=MV)
                {
                    fragmentTransaction.hide(lastFrg).show(MV);
                    lastFrg = MV;
                }
                break;
        }
        fragmentTransaction.commit();
    }
}

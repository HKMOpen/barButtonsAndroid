package com.hkm.jofullwidthbutton;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by zJJ on 5/15/2016.
 */
public class ArrowSwitch extends fusebasic implements Switch.OnCheckedChangeListener {

    private Switch mswitcher;
    private boolean value;
    private checker onCheck;

    public ArrowSwitch(Context context) {
        super(context);

    }

    public ArrowSwitch(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    public ArrowSwitch(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    @Override
    protected int reslayout() {
        return R.layout.selectionswitcher;
    }


    public interface checker {
        void oncheck(boolean n);
    }

    protected void bind(View hh) {
        title = (TextView) hh.findViewById(R.id.tpm_display);
        mswitcher = (Switch) hh.findViewById(R.id.mswitcher);
        imIcon = (ImageView) hh.findViewById(R.id.tpm_icon_place);
        //imArrow = (ImageView) hh.findViewById(R.id.tpm_arrow);
        if (mswitcher != null) {
            mswitcher.setOnCheckedChangeListener(this);
        }

    }

    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        Toast.makeText(getContext(), "The Switch is " + (isChecked ? "on" : "off"),
                Toast.LENGTH_SHORT).show();
        value = isChecked;
        if (onCheck != null) {
            onCheck.oncheck(isChecked);
        }
    }

    public void setCheckListener(checker listen) {
        onCheck = listen;
    }

    public void setValue(boolean first) {
        mswitcher.setChecked(first);
        value = first;
    }

    public void removeListener() {
        onCheck = null;
    }

    public void toggle() {
        mswitcher.toggle();
    }

    public boolean getcurrent() {
        return value;
    }
}

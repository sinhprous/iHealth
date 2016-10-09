package com.tungbk.ihealth.fragment;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.tungbk.ihealth.R;

/**
 * Created by nxtbk on 10/9/2016.
 */

public class MeasureFragment extends Fragment {

    private ImageView heartRateButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_measure, container, false);

        final int[] imgArr = {R.drawable.heart_rate, R.drawable.heart_rate_white};


        heartRateButton = (ImageView) v.findViewById(R.id.heart_view_measure_image);
        final Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            int i = 0;

            public void run() {
                heartRateButton.setImageResource(imgArr[i]);
                i++;
                if (i > imgArr.length - 1) {
                    i = 0;
                }
                handler.postDelayed(this, 300);
            }
        };
        handler.postDelayed(runnable, 300);

        return v;
    }
}

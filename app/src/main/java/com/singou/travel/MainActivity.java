package com.singou.travel;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity {
    private CheckBox mEraseSdCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEraseSdCard = (CheckBox) findViewById(R.id.erase_sdcard);

        //noinspection ConstantConditions
        findViewById(R.id.factory_reset).setOnClickListener(onClickListener);
    }

    private OnClickListener onClickListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            factoryReset();
        }
    };

    private void factoryReset() {
        boolean isEraseSdCard = mEraseSdCard.isChecked();
        DeviceEraser.factoryReset(MainActivity.this, isEraseSdCard);
    }
}

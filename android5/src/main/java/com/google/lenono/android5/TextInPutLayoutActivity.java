package com.google.lenono.android5;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextInPutLayoutActivity extends AppCompatActivity implements View.OnClickListener {
    TextInputLayout textInPutLayout;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_in_put_layout);
        btn1 = (Button) findViewById(R.id.text_input_btn1);
        textInPutLayout = (TextInputLayout) findViewById(R.id.text_input_layout);
        btn1.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (matcherInput()) {
            Log.i("aaa", "验证成功");
            textInPutLayout.setErrorEnabled(false);

        } else {
            Log.i("aaa", "验证失败");
            textInPutLayout.setErrorEnabled(true);
            textInPutLayout.setError("输入错误");
        }
    }

    public boolean matcherInput() {
        String inputText = textInPutLayout.getEditText().getText().toString();
        String patternText = "^[A-Za-z0-9]+$";
        Pattern pattern = Pattern.compile(patternText);
        Matcher m = pattern.matcher(inputText);
        return m.matches();
    }
}

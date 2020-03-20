package com.ibm.bank.extract;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.ibm.bank.R;

interface ExtractActivityInput {
    void displayExtractData(ExtractViewModel viewModel);
}

public class ExtractActivity extends AppCompatActivity implements ExtractActivityInput, View.OnClickListener {

    private ImageButton btnExit;

    ExtractInteractorInput output;
    ExtractRouter router;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extract);

        bindViews();
        bindOnClick();

        ExtractConfigurator.INSTANCE.configure(this);
    }

    @Override
    public void displayExtractData(ExtractViewModel viewModel) {
        // set values in activity
    }

    @Override
    public void onClick(View v) {
        finish();
    }

    private void bindViews() {
        btnExit = findViewById(R.id.btnExit);
    }

    private void bindOnClick() {
        btnExit.setOnClickListener(this);
    }
}
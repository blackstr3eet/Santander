package com.ibm.bank.extract;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.ibm.bank.MockList;
import com.ibm.bank.R;
import com.ibm.bank.StatementList;

import java.util.List;

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

        RecyclerView recyclerView = findViewById(R.id.extractListItems);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        RecyclerView.Adapter adapter = new ExtractAdapter(MockList.INSTANCE.createMockListItemsExtract());
        recyclerView.setAdapter(adapter);
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

    private class ExtractAdapter extends RecyclerView.Adapter<ExtractAdapter.ViewHolder> {
        private List<StatementList> items;

        public ExtractAdapter(List<StatementList> items) {
            this.items = items;
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public TextView title;
            public TextView description;
            public TextView date;
            public TextView value;

            public ViewHolder(View view) {
                super(view);
                title = view.findViewById(R.id.title);
                description = view.findViewById(R.id.description);
                date = view.findViewById(R.id.date);
                value = view.findViewById(R.id.value);
            }
        }

        @Override
        public ExtractAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_extract_list, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.title.setText(items.get(position).getTitle());
            holder.description.setText(items.get(position).getDesc());
            holder.date.setText(items.get(position).getDate());
            holder.value.setText(String.format("R$%.2f", items.get(position).getValue()));
        }

        @Override
        public int getItemCount() {
            return items.size();
        }
    }
}
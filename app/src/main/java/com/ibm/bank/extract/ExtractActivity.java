package com.ibm.bank.extract;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.ibm.bank.R;
import com.ibm.bank.domain.StatementList;
import com.ibm.bank.login.LoginRouter;
import java.util.List;

interface ExtractActivityInput {
    void displayExtractData(List<StatementList> statements);
}

public class ExtractActivity extends AppCompatActivity implements ExtractActivityInput, View.OnClickListener {

    private TextView name;
    private TextView data;
    private TextView value;
    private ProgressBar progressBar;
    private RecyclerView recyclerView;
    private ImageButton exit;

    ExtractInteractorInput interactorInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extract);

        bindViews();
        retrieveActivityDataPrevious();
        bindOnClick();

        ExtractConfigurator.INSTANCE.configure(this);

        ExtractRequest request = new ExtractRequest();
        request.details();
        changeStatusLoading(true);

        Handler handler = new Handler();
        handler.postDelayed( () -> {
            changeStatusLoading(false);
            interactorInput.fetchExtractData(request);
        }, 2000);
    }

    @Override
    public void displayExtractData(List<StatementList> statements) {
        ExtractViewModel viewModel = ViewModelProviders.of(this).get(ExtractViewModel.class);

        viewModel.data.observe(this, values -> {
            recyclerView.setHasFixedSize(true);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
            recyclerView.setLayoutManager(layoutManager);
            RecyclerView.Adapter adapter = new ExtractAdapter(values);
            recyclerView.setAdapter(adapter);
        });

        viewModel.getStatementList(statements);
    }

    @Override
    public void onClick(View v) {
        finish();
    }

    private void bindViews() {
        name = findViewById(R.id.name);
        data = findViewById(R.id.data);
        value = findViewById(R.id.value);
        progressBar = findViewById(R.id.progressBarRecyclerView);
        recyclerView = findViewById(R.id.extractListItems);
        exit = findViewById(R.id.btnExit);
    }

    private void bindOnClick() {
        exit.setOnClickListener(this);
    }

    private void retrieveActivityDataPrevious() {
        Bundle bundle = getIntent().getExtras();
        name.setText(bundle.getString(LoginRouter.KEY_BUNDLE_NAME));
        data.setText(String.format("%s / %s", bundle.getString(LoginRouter.KEY_BUNDLE_AGENCY), bundle.getString(LoginRouter.KEY_BUNDLE_ACCOUNT)));
        value.setText(bundle.getString(LoginRouter.KEY_BUNDLE_BALANCE));
    }

    private void changeStatusLoading(boolean loading) {
        if(loading) {
            progressBar.setVisibility(View.VISIBLE);
        }
        else {
            progressBar.setVisibility(View.INVISIBLE);
            recyclerView.setVisibility(View.VISIBLE);
        }
    }

    private static class ExtractAdapter extends RecyclerView.Adapter<ExtractAdapter.ViewHolder> {
        private List<StatementList> items;

        public ExtractAdapter(List<StatementList> items) {
            this.items = items;
        }

        public static class ViewHolder extends RecyclerView.ViewHolder {
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
            holder.date.setText(formatterDate(items.get(position).getDate()));
            holder.value.setText(String.format("R$%.2f", items.get(position).getValue()));
        }

        @Override
        public int getItemCount() {
            return items.size();
        }

        private String formatterDate(String date) {
            StringBuilder builder = new StringBuilder();

            builder.append(date.substring(8,10));
            builder.append("/");
            builder.append(date.substring(5,7));
            builder.append("/");
            builder.append(date.substring(0,4));

            return builder.toString();
        }
    }
}
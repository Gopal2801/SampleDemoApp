package com.example.sampledemoapp.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sampledemoapp.R;
import com.example.sampledemoapp.adapters.MySampleCustomAdapter;
import com.example.sampledemoapp.models.SongResponse;
import com.example.sampledemoapp.retrofit.APIClient;
import com.example.sampledemoapp.retrofit.APIInterface;
import com.google.gson.Gson;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SampleActivity extends AppCompatActivity {

    private ProgressBar mProgressBar;

    private RecyclerView mRecylerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sample_activity_main);
        mProgressBar = (ProgressBar) findViewById(R.id.progress_bar);
        mRecylerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        toCallRXJava();
    }

    private void toCallRXJava() {

        APIInterface apiService =
                APIClient.getClientRX().create(APIInterface.class);

        Observable<ArrayList<SongResponse>> observable = apiService.getSongList();

        observable.subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<ArrayList<SongResponse>>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.e("onSubscribe", "onSubscribe");

            }

            @Override
            public void onNext(ArrayList<SongResponse> songResponse) {
                Log.e("onNext", new Gson().toJson(songResponse));

                toUpdateSampleList(songResponse);
            }

            @Override
            public void onError(Throwable e) {
                Log.e("onError", e.toString());

            }

            @Override
            public void onComplete() {
                Log.e("onComplete", "onComplete");

            }
        });

    }

    private void toUpdateSampleList(ArrayList<SongResponse> aSongList) {

        mRecylerView.setHasFixedSize(true);

        MySampleCustomAdapter adapter = new MySampleCustomAdapter(this, aSongList);

        mRecylerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        mRecylerView.setAdapter(adapter);
    }
}

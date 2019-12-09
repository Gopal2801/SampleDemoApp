package com.example.sampledemoapp.activity;

import android.content.Context;
import android.graphics.Movie;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sampledemoapp.R;
import com.example.sampledemoapp.adapters.RecyclerViewDataAdapter;
import com.example.sampledemoapp.models.Album;
import com.example.sampledemoapp.models.Artist;
import com.example.sampledemoapp.models.Category;
import com.example.sampledemoapp.models.HomeData;
import com.example.sampledemoapp.models.HomeField;
import com.example.sampledemoapp.models.HomePageResponse;
import com.example.sampledemoapp.models.SectionDataModel;
import com.example.sampledemoapp.models.SingleItemModel;
import com.example.sampledemoapp.models.Song;
import com.example.sampledemoapp.retrofit.APIClient;
import com.example.sampledemoapp.retrofit.APIInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;

    private ArrayList<SectionDataModel> allSampleData;
    private ProgressBar mProgressBar;
    private RecyclerView mRecylerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mProgressBar = (ProgressBar) findViewById(R.id.progress_bar);

        mRecylerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        allSampleData = new ArrayList<SectionDataModel>();

        // createDummyData();


        toCallHomePageItem();


    }

    private void toCallHomePageItem() {

        if (isNetworkAvailable()) {
            callListItem();
        }

    }

    public void createDummyData() {

        for (int i = 1; i <= 5; i++) {

            SectionDataModel dm = new SectionDataModel();

            dm.setHeaderTitle("Section " + i);

            ArrayList<SingleItemModel> singleItem = new ArrayList<SingleItemModel>();

            for (int j = 0; j <= 5; j++) {

                SingleItemModel aModel = new SingleItemModel();

                aModel.setName("Item " + j);

                aModel.setUrl("URL " + j);

                singleItem.add(aModel);

                // singleItem.add(new SingleItemModel("Item " + j, "URL " + j));
            }

            dm.setAllItemsInSection(singleItem);

            allSampleData.add(dm);

        }
    }

    private void callListItem() {

        mProgressBar.setVisibility(View.VISIBLE);

        APIInterface apiService =
                APIClient.getClient().create(APIInterface.class);

        Call<HomePageResponse> aCall = apiService.getHomePage();

        aCall.enqueue(new Callback<HomePageResponse>() {
            @Override
            public void onResponse(Call<HomePageResponse> call, Response<HomePageResponse> response) {
                HomePageResponse aResponse = response.body();

                //Log.e("DATA", )
                mProgressBar.setVisibility(View.GONE);

                updateList(aResponse);

            }

            @Override
            public void onFailure(Call<HomePageResponse> call, Throwable t) {

            }
        });

    }

    private void updateList(HomePageResponse aResponse) {

        ArrayList<HomeData> aHomePageFinalData = new ArrayList<HomeData>();

        if (aResponse != null) {

            //For Album

            if (aResponse.getAlbums() != null) {

                List<Album> aAlbum = aResponse.getAlbums();

                if (aAlbum.size() > 0) {

                    HomeData aItem1 = new HomeData();

                    ArrayList<HomeData> aHomePageData1 = new ArrayList<HomeData>();

                    ArrayList<HomeField> aAlbumList = new ArrayList<HomeField>();

                    for (int k = 0; k < aAlbum.size(); k++) {

                        Album aItem = aAlbum.get(k);

                        HomeField aData = new HomeField();

                        aData.setName(aItem.getSongName());

                        aData.setUrl(aItem.getLogo());

                        aAlbumList.add(aData);


                    }

                    aItem1.setHomeFiledListItem(aAlbumList);

                    aItem1.setTitle("Album");

                    aHomePageData1.add(aItem1);

                    aHomePageFinalData.addAll(aHomePageData1);
                }
            }


            //For Songs
            if (aResponse.getSongs() != null) {

                HomeData aItem2 = new HomeData();

                ArrayList<HomeData> aHomePageData2 = new ArrayList<HomeData>();

                List<Song> aSongs = aResponse.getSongs();

                if (aSongs.size() > 0) {

                    ArrayList<HomeField> aItemList2 = new ArrayList<HomeField>();

                    for (int k = 0; k < aSongs.size(); k++) {

                        Song aItem = aSongs.get(k);

                        HomeField aData = new HomeField();

                        aData.setName(aItem.getName());

                        aData.setUrl(aItem.getLogo());

                        aItemList2.add(aData);

                    }

                    aItem2.setTitle("Songs");

                    aItem2.setHomeFiledListItem(aItemList2);

                    aHomePageData2.add(aItem2);

                    aHomePageFinalData.addAll(aHomePageData2);

                }
            }

            //For Artist

            if (aResponse.getArtists() != null) {

                HomeData aItem3 = new HomeData();

                ArrayList<HomeData> aHomePageData3 = new ArrayList<HomeData>();

                List<Artist> aArtist = aResponse.getArtists();

                if (aArtist.size() > 0) {

                    ArrayList<HomeField> aItemList3 = new ArrayList<HomeField>();

                    for (int k = 0; k < aArtist.size(); k++) {

                        Artist aItem = aArtist.get(k);

                        HomeField aData = new HomeField();

                        aData.setName(aItem.getName());

                        aData.setUrl(aItem.getLogo());

                        aItemList3.add(aData);

                    }

                    aItem3.setTitle("Artist");

                    aItem3.setHomeFiledListItem(aItemList3);

                    aHomePageData3.add(aItem3);

                    aHomePageFinalData.addAll(aHomePageData3);

                }
            }


            //For Category
            if (aResponse.getCategory() != null) {

                HomeData aItem4 = new HomeData();

                ArrayList<HomeData> aHomePageData4 = new ArrayList<HomeData>();

                List<Category> aCategory = aResponse.getCategory();

                if (aCategory.size() > 0) {

                    ArrayList<HomeField> aItemList3 = new ArrayList<HomeField>();

                    for (int k = 0; k < aCategory.size(); k++) {

                        Category aItem = aCategory.get(k);

                        HomeField aData = new HomeField();

                        aData.setName(aItem.getCat());

                        aData.setUrl(aItem.getSongs());

                        aItemList3.add(aData);

                    }

                    aItem4.setTitle("Category");

                    aItem4.setHomeFiledListItem(aItemList3);

                    aHomePageData4.add(aItem4);

                    aHomePageFinalData.addAll(aHomePageData4);
                }

            }
        }

        toLoadListItem(aHomePageFinalData, aResponse);
    }

    private void toLoadListItem(ArrayList<HomeData> aHomePageData, HomePageResponse aResponse) {

        for (int i = 0; i < aHomePageData.size(); i++) {

            SectionDataModel dm = new SectionDataModel();

            HomeData aDat = aHomePageData.get(i);

            dm.setHeaderTitle(aDat.getTitle());

            ArrayList<SingleItemModel> singleItem = new ArrayList<SingleItemModel>();

            ArrayList<HomeField> aInnerItemList = aHomePageData.get(i).getHomeFiledListItem();

            for (int j = 0; j < aInnerItemList.size(); j++) {

                HomeField aData = aInnerItemList.get(j);

                SingleItemModel aModel = new SingleItemModel();

                aModel.setName(aData.getName());

                aModel.setUrl(aData.getUrl());

                singleItem.add(aModel);

                // singleItem.add(new SingleItemModel("Item " + j, "URL " + j));
            }

            dm.setAllItemsInSection(singleItem);

            allSampleData.add(dm);

        }


        mRecylerView.setHasFixedSize(true);

        RecyclerViewDataAdapter adapter = new RecyclerViewDataAdapter(this, allSampleData);

        mRecylerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        mRecylerView.setAdapter(adapter);

    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}

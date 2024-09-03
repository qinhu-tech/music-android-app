package com.example.doanmobile.search;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

import com.example.doanmobile.PlayActivity;
import com.example.doanmobile.R;
import com.example.doanmobile.StartActivity;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {
    private RecyclerView rcvUser;
    private SearchAdapter searchAdapter;
    private SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        rcvUser =findViewById(R.id.rcv_user);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvUser.setLayoutManager(linearLayoutManager);
        searchAdapter = new SearchAdapter(getListUsers1(), new SearchAdapter.ICLickItemsonglist() {
            @Override
            public void onClicksongitem(Usersss usersss) {
                Click(usersss);
            }
        });
        rcvUser.setAdapter(searchAdapter);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        rcvUser.addItemDecoration(itemDecoration);
    }

    private void Click(Usersss usersss) {
        startActivity(new Intent(this, PlayActivity.class));
    }

    private List<Usersss> getListUsers1() {
        List<Usersss> list = new ArrayList<>();
        list.add(new Usersss(R.drawable.chacaidoseve,"Chắc Ai Đó Sẽ Về ","Sơn Tùng M-TP"));
        list.add(new Usersss(R.drawable.chayngaydi,"Chạy Ngay Đi","Sơn Tùng M-TP"));
        list.add(new Usersss(R.drawable.chungtakhongthuocvenhau,"Chúng Ta Không Thuộc Về Nhau","Sơn Tùng M-TP"));
        list.add(new Usersss(R.drawable.cochacyeuladay,"Có Chắc Yêu Là Đây","Sơn Tùng M-TP"));
        list.add(new Usersss(R.drawable.haytraochoanh,"Hãy Trao Cho Anh","Sơn Tùng M-TP"));
        list.add(new Usersss(R.drawable.lactroi,"Lạc Trôi","Sơn Tùng M-TP"));
        list.add(new Usersss(R.drawable.muonroimasaocon,"Muộn Rồi Mà Sao Còn","Sơn Tùng M-TP"));
        list.add(new Usersss(R.drawable.nangamxadan,"Nắng Ấm Xa Dần","Sơn Tùng M-TP"));
        list.add(new Usersss(R.drawable.nhungayhomqua,"Như Ngày Hôm Qua","Sơn Tùng M-TP"));
        list.add(new Usersss(R.drawable.noinaycoanh,"Nơi Này Có Anh","Sơn Tùng M-TP"));
        return  list;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        SearchManager searchManager =(SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                searchAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }
}
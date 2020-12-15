
package com.example.litepaltest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.litepal.LitePal;
import org.litepal.crud.LitePalSupport;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button createDatabase = (Button) findViewById(R.id.create_database);
        createDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LitePal.getDatabase();
            }
        });
        Button addData = (Button) findViewById(R.id.add_data);
        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book = new Book();
                book.setName("The Da vinci Code");
                book.setAuthor("Dan Brown");
                book.setPages(454);
                book.setPrices(16.96);
                book.setPress("Unknow");
                book.save();
            }
        });
        Button updateData = (Button) findViewById(R.id.update_data);
        updateData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book = new Book();
                book.setPrices(14.95);
                book.setPress("Anchor");
                book.updateAll("name=? and author =?","The Da vinci Code","Dan Brown");
            }
        });
        Button deleteData = (Button) findViewById(R.id.delete_data);
        deleteData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LitePal.deleteAll(Book.class,"prices < ? ","60");
            }
        });
        Button queryButton = (Button) findViewById(R.id.query_data);
        queryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Book> books = LitePal.findAll(Book.class);
                for(Book book : books){
                    Log.d("MainActivity","book name is" +book.getName());
                    Log.d("MainActivity","book author is" +book.getAuthor());
                    Log.d("MainActivity","book pages is" +book.getPages());
                    Log.d("MainActivity","book prices is" +book.getPrices());
                    Log.d("MainActivity","book Press is" +book.getPress());
                }
            }
        });
    }
}
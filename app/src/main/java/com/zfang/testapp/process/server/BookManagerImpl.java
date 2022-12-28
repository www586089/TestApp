package com.zfang.testapp.process.server;

import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.zfang.testapp.process.aidl.Book;
import com.zfang.testapp.process.aidl.IBookManager;

import java.util.ArrayList;
import java.util.List;

public class BookManagerImpl extends IBookManager.Stub {
    private static final String TAG = "zfang";

    private List<Book> bookList = new ArrayList<>();

    @Override
    public void addBook(Book book) throws RemoteException {
        Log.d(TAG, "addBook: book = " + book);

        book.setIndex(2);
        bookList.add(book);
    }
}

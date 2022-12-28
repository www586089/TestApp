package com.zfang.testapp.process.client;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.zfang.testapp.process.aidl.Book;
import com.zfang.testapp.process.aidl.IBookManager;

public class BookClient implements ServiceConnection {
    private String TAG = "zfang";

    private static final BookClient instance = new BookClient();

    public static BookClient getInstance() {
        return instance;
    }

    private IBookManager bookService = null;

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        Log.d(TAG, "onServiceConnected: service = " + service);
        if (null != service) {
            bookService = IBookManager.Stub.asInterface(service);
            Book book = new Book();
            Log.e(TAG, "before add, book = " + book);
            try {
                book.setIndex(1);
                bookService.addBook(book);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            Log.e(TAG, "after add, book = " + book);
        }
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        Log.d(TAG, "onServiceDisconnected: ");
    }
}

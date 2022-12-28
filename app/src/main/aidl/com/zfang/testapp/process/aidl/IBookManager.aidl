// IBook.aidl
package com.zfang.testapp.process.aidl;

import com.zfang.testapp.process.aidl.Book;
// Declare any non-default types here with import statements

interface IBookManager {
    void addBook(inout Book book);
}
package com.zfang.testapp.process.aidl;

import android.os.Parcel;
import android.os.Parcelable;

public class Book implements Parcelable {
    private String name = "name";
    private String author = "author";
    private int index = -1;

    public Book() {

    }
    public Book(String name, String author, int index) {
        this.name = name;
        this.author = author;
        this.index = index;
    }


    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    protected Book(Parcel in) {
        name = in.readString();
        author = in.readString();
        index = in.readInt();
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(author);
        dest.writeInt(index);
    }

    public void readFromParcel(Parcel reply) {
        this.name = reply.readString();
        this.author = reply.readString();
        this.index = reply.readInt();
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", index=" + index +
                '}';
    }
}

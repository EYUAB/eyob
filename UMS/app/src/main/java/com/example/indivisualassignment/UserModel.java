package com.example.indivisualassignment;

import android.os.Parcel;
import android.os.Parcelable;

public class UserModel implements Parcelable {
    private String fullname;
    private String email;
    private String username;
    private String gender;
    private String phone;

    public UserModel(String fullname, String username,String email,String phone, String p,String gender) {
        this.fullname = fullname;
        this.email = email;
        this.username = username;
        this.phone = phone;
        this.gender=gender;
    }

    protected UserModel(Parcel in) {
        fullname = in.readString();
        email = in.readString();
        username = in.readString();
        gender = in.readString();
        phone = in.readString();
    }

    public static final Creator<UserModel> CREATOR = new Creator<UserModel>() {
        @Override
        public UserModel createFromParcel(Parcel in) {
            return new UserModel(in);
        }

        @Override
        public UserModel[] newArray(int size) {
            return new UserModel[size];
        }
    };

    public String getFullname() {
        return fullname;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getGender() {
        return gender;
    }

    public String getPhone() {
        return phone;
    }
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(fullname);
        dest.writeString(email);
        dest.writeString(username);
        dest.writeString(gender);
        dest.writeString(phone);
    }
}

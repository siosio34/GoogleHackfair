package com.ar.siosi.swmaestrobackendproject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joyeongje on 2016. 9. 9..
 */
public class User {

    private String userId;
    private String userName; // 유저 이름
    private String userEmail; // 유저 아이디
    private int folloingNumber; // 팔로잉 넘버
    private int followerNumber; // 팔로워 넘버
    public List<String> haveFollowerList = new ArrayList<>();
    public List<String> haveFollowingList = new ArrayList<>();

    public static User currentUser = new User();

    public User() {}
    public User(String userId,String userName,String userEmail,int folloingNumber,int followerNumber,List<String> haveFollowingList,List<String> haveFollowerList) {
        this.userId = userId;
        this.userEmail = userEmail;
        this.userName = userName;
        this.folloingNumber = folloingNumber;
        this.followerNumber = followerNumber;
        this.haveFollowerList = haveFollowingList;
        this.haveFollowingList = haveFollowingList;

    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public int getFolloingNumber() {
        return folloingNumber;
    }

    public void setFolloingNumber(int folloingNumber) {
        this.folloingNumber = folloingNumber;
    }

    public int getFollowerNumber() {
        return followerNumber;
    }

    public void setFollowerNumber(int followerNumber) {
        this.followerNumber = followerNumber;
    }

    public List<String> getHaveFollowerList() {
        return haveFollowerList;
    }

    public void setHaveFollowerList(List<String> haveFollowerList) {
        this.haveFollowerList = haveFollowerList;
    }

    public List<String> getHaveFollowingList() {
        return haveFollowingList;
    }

    public void setHaveFollowingList(List<String> haveFollowingList) {
        this.haveFollowingList = haveFollowingList;
    }
}


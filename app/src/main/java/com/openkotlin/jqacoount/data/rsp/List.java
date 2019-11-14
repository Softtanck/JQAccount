package com.openkotlin.jqacoount.data.rsp;

/**
 * Current name : List in `JQAcoount`
 * <p>
 * Created by Tanck on 2019-11-14 15:41.
 * <p>
 * Note : N/A
 */
public class List {

    /**
     * id : null
     * cardNumber : null
     * userName : null
     * expireTime : null
     * userPassword : null
     * bindNumber : null
     * tieBindNumber : 0
     * lastLoginTime : 2019-11-13T15:08:50.000+0000
     * gameName : 矫情工作室0x1
     * gameAccount : q422013
     * gamePassword : XXXX
     * gameTeamName : 专业代练俱乐部
     * expired : false
     * online : false
     */

    private Object id;
    private Object cardNumber;
    private Object userName;
    private Object expireTime;
    private Object userPassword;
    private Object bindNumber;
    private int tieBindNumber;
    private String lastLoginTime;
    private String gameName;
    private String gameAccount;
    private String gamePassword;
    private String gameTeamName;
    private boolean expired;
    private boolean online;

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public Object getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Object cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Object getUserName() {
        return userName;
    }

    public void setUserName(Object userName) {
        this.userName = userName;
    }

    public Object getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Object expireTime) {
        this.expireTime = expireTime;
    }

    public Object getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(Object userPassword) {
        this.userPassword = userPassword;
    }

    public Object getBindNumber() {
        return bindNumber;
    }

    public void setBindNumber(Object bindNumber) {
        this.bindNumber = bindNumber;
    }

    public int getTieBindNumber() {
        return tieBindNumber;
    }

    public void setTieBindNumber(int tieBindNumber) {
        this.tieBindNumber = tieBindNumber;
    }

    public String getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getGameAccount() {
        return gameAccount;
    }

    public void setGameAccount(String gameAccount) {
        this.gameAccount = gameAccount;
    }

    public String getGamePassword() {
        return gamePassword;
    }

    public void setGamePassword(String gamePassword) {
        this.gamePassword = gamePassword;
    }

    public String getGameTeamName() {
        return gameTeamName;
    }

    public void setGameTeamName(String gameTeamName) {
        this.gameTeamName = gameTeamName;
    }

    public boolean isExpired() {
        return expired;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }
}

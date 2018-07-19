/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kate
 */
public class user {
    private Integer id;
    private Integer uid;
    private String fname;
    private String lname;
    private String uname;
    private Integer UserId;
    private Integer GroupID;

    public user() {
    }

    
    public user(Integer id,Integer uid, String fname, String lname, String uname,Integer UserId, Integer GroupID) {
        this.uid = uid;
        this.fname = fname;
        this.lname = lname;
        this.uname = uname;
        this.UserId=UserId;
        this.id=id;
        this.GroupID=GroupID;
    }

    public Integer getGroupID() {
        return GroupID;
    }

    public void setGroupID(Integer GroupID) {
        this.GroupID = GroupID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return UserId;
    }

    public void setUserId(Integer UserId) {
        this.UserId = UserId;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kate
 */
public class contact {
    private Integer cid;
    private String fname;
    private String lname;
    private String address;
    private String Phone;
    private Integer uid;

    public contact() {
    }

    
    public contact(Integer cid, String fname, String lname, String address, String Phone, Integer uid) {
        this.cid = cid;
        this.fname = fname;
        this.lname = lname;
        this.address = address;
        this.Phone = Phone;
        this.uid = uid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
    
    

    
}
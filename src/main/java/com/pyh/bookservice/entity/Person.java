/**
 * 2019.11.9 16：25
 * author:pyh
 */
package com.pyh.bookservice.entity;

public class Person {
    private String personid;
    private String personname;
    private String personpassword;

    public Person(String personid, String personname, String personpassword) {
        this.personid = personid;
        this.personname = personname;
        this.personpassword = personpassword;
    }

    public String getPersonid() {
        return personid;
    }

    public void setPersonid(String personid) {
        this.personid = personid;
    }

    public String getPersonname() {
        return personname;
    }

    public void setPersonname(String personname) {
        this.personname = personname;
    }

    public String getPersonpassword() {
        return personpassword;
    }

    public void setPersonpassword(String personpassword) {
        this.personpassword = personpassword;
    }
}

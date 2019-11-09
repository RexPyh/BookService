/**
 * 2019.11.9 16：25
 * author:pyh
 */
package com.pyh.bookservice.entity;

public class Person {
    private String personid;
    private String personname;
    private String personpassword;
    private String userid;
    private String personsex;
    private String personemail;
    private String personhome;
    private String persontel;
    private String persondelete;

    public Person() {}

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

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPersonsex() {
        return personsex;
    }

    public void setPersonsex(String personsex) {
        this.personsex = personsex;
    }

    public String getPersonemail() {
        return personemail;
    }

    public void setPersonemail(String personemail) {
        this.personemail = personemail;
    }

    public String getPersonhome() {
        return personhome;
    }

    public void setPersonhome(String personhome) {
        this.personhome = personhome;
    }

    public String getPersontel() {
        return persontel;
    }

    public void setPersontel(String persontel) {
        this.persontel = persontel;
    }

    public String getPersondelete() {
        return persondelete;
    }

    public void setPersondelete(String persondelete) {
        this.persondelete = persondelete;
    }
}

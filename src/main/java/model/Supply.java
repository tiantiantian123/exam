package model;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/5/13.
 */
public class Supply  implements Serializable{

    private Integer id;
    private String name;
    private String addr;
    private String linkman;
    private String materials;
    private String tel;

    public Supply(){

    }

    public Supply(Integer id, String name, String addr, String linkman, String materials, String tel) {
        this.id = id;
        this.name = name;
        this.addr = addr;
        this.linkman = linkman;
        this.materials = materials;
        this.tel = tel;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    public String getMaterials() {
        return materials;
    }

    public void setMaterials(String materials) {
        this.materials = materials;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Supply{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", addr='" + addr + '\'' +
                ", linkman='" + linkman + '\'' +
                ", materials='" + materials + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }
}

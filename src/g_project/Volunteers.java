/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g_project;


/**
 *
 * @author Mortooo.x
 */

public class Volunteers  {

 
    private Integer id;
 
    private String name;

    private String addrees;

    private String phone;

    private String accountName;

    private String accountNumber;

    private byte[] proofIdentity;

    private String calss;

    private String note;

    public Volunteers() {
    }

    public Volunteers(Integer id) {
        this.id = id;
    }

    public Volunteers(Integer id, String name, String addrees, String phone, String accountName, String accountNumber, byte[] proofIdentity, String calss, String note) {
        this.id = id;
        this.name = name;
        this.addrees = addrees;
        this.phone = phone;
        this.accountName = accountName;
        this.accountNumber = accountNumber;
        this.proofIdentity = proofIdentity;
        this.calss = calss;
        this.note = note;
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

    public String getAddrees() {
        return addrees;
    }

    public void setAddrees(String addrees) {
        this.addrees = addrees;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public byte[] getProofIdentity() {
        return proofIdentity;
    }

    public void setProofIdentity(byte[] proofIdentity) {
        this.proofIdentity = proofIdentity;
    }

    public String getCalss() {
        return calss;
    }

    public void setCalss(String calss) {
        this.calss = calss;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Volunteers)) {
            return false;
        }
        Volunteers other = (Volunteers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "g_project.Volunteers[ id=" + id + " ]";
    }
    
}

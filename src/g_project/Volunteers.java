/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g_project;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Mortooo.x
 */

public class Volunteers extends Database {

 
    private Integer id;
 
    private String name;

    private String addrees;

    private String phone;

    private String account_name;

    private String account_number;

    private byte[] proof_identity;

    private String calss;

    private String note;

    public Volunteers() {
    }

    public Volunteers(Integer id) {
        this.id = id;
    }

    public Volunteers(Integer id, String name, String addrees, String phone, String account_name, String account_number, byte[] proofIdentity, String calss, String note) {
        this.id = id;
        this.name = name;
        this.addrees = addrees;
        this.phone = phone;
        this.account_name = account_name;
        this.account_number = account_number;
        this.proof_identity = proofIdentity;
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

    public String getAccount_name() {
        return account_name;
    }

    public void setAccount_name(String accountName) {
        this.account_name = accountName;
    }

    public String getAccount_number() {
        return account_number;
    }

    public void setAccount_number(String accountNumber) {
        this.account_number = accountNumber;
    }

    public byte[] getProof_identity() {
        return proof_identity;
    }

    public void setProof_identity(byte[] proofIdentity) {
        this.proof_identity = proofIdentity;
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
    
    
    
    
    
    
     public List<Volunteers> getAll() throws SQLException {

        String sql =  "SELECT * FROM `volunteers` ;" ;

        List<Volunteers> list = new ArrayList<Volunteers>();

        con = getConnection();
        pre = con.prepareStatement(sql);
        resultSet = pre.executeQuery();

        while (resultSet.next()) {

            Volunteers volunteer = new Volunteers(resultSet.getInt(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getBytes(7),
                    resultSet.getString(8),
                    resultSet.getString(9)
                  
            );

            list.add(volunteer);
        }

        resultSet.close();
        pre.close();
        con.close();

        return list;
    }

}

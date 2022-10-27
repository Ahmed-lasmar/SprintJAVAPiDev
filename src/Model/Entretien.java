/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.sql.Date;

/**
 *
 * @author HP
 */
public class Entretien {
    private int id_entretien;
    private int id_candidat;
    private String firstname_candidat;
    private String name_candidat;
    private String heure;
    private String person_present;
    private Date date_entretien;

    public Entretien() {
    }

    public Entretien( String name_candidat,String firstname_candidat, String heure,String person_present,Date date_entretien) {
        this.firstname_candidat = firstname_candidat;
        this.name_candidat = name_candidat;
        this.heure = heure;
        this.person_present = person_present;
        this.date_entretien = date_entretien;
    }

    public Entretien(int id_entretien, int id_candidat, String firstname_candidat, String name_candidat, String heure, String person_present, Date date_entretien) {
        this.id_entretien = id_entretien;
        this.id_candidat = id_candidat;
        this.firstname_candidat = firstname_candidat;
        this.name_candidat = name_candidat;
        this.heure = heure;
        this.person_present = person_present;
        this.date_entretien = date_entretien;
    }

    public Entretien(int id_candidat, String firstname_candidat, String name_candidat, String heure, String person_present, Date date_entretien) {
        this.id_candidat = id_candidat;
        this.firstname_candidat = firstname_candidat;
        this.name_candidat = name_candidat;
        this.heure = heure;
        this.person_present = person_present;
        this.date_entretien = date_entretien;
    }

    public Entretien(String heure, Date date_entretien) {
        this.heure = heure;
        this.date_entretien = date_entretien;
    }

    public int getId_entretien() {
        return id_entretien;
    }

    public void setId_entretien(int id_entretien) {
        this.id_entretien = id_entretien;
    }

    public int getId_candidat() {
        return id_candidat;
    }

    public void setId_candidat(int id_candidat) {
        this.id_candidat = id_candidat;
    }

    public String getFirstname_candidat() {
        return firstname_candidat;
    }

    public void setFirstname_candidat(String firstname_candidat) {
        this.firstname_candidat = firstname_candidat;
    }

    public String getName_candidat() {
        return name_candidat;
    }

    public void setName_candidat(String name_candidat) {
        this.name_candidat = name_candidat;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public String getPerson_present() {
        return person_present;
    }

    public void setPerson_present(String person_present) {
        this.person_present = person_present;
    }

    public Date getDate_entretien() {
        return date_entretien;
    }

    public void setDate_entretien(Date date_entretien) {
        this.date_entretien = date_entretien;
    }

    @Override
    public String toString() {
        return "Entretien{" + "id_entretien=" + id_entretien + ", id_candidat=" + id_candidat + ", firstname_candidat=" + firstname_candidat + ", name_candidat=" + name_candidat + ", heure=" + heure + ", person_present=" + person_present + ", date_entretien=" + date_entretien + '}';
    }
    
    
}

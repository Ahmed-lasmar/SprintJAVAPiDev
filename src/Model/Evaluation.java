/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author HP
 */
public class Evaluation {
    private int id_evaluation;
    private String avis;
    private int id_entretien;
    private int note;

    public Evaluation() {
    }

    public Evaluation(int id_entretien, int note,String avis ) {
        this.avis = avis;
        this.id_entretien = id_entretien;
        this.note = note;
    }

    public Evaluation(int id_evaluation, String avis, int id_entretien, int note) {
        this.id_evaluation = id_evaluation;
        this.avis = avis;
        this.id_entretien = id_entretien;
        this.note = note;
    }

    public Evaluation( int note,String avis) {
        this.avis = avis;
        this.note = note;
    }

    public Evaluation(int id_entretien, int note) {
        this.id_entretien = id_entretien;
        this.note = note;
    }
    

   

    public Evaluation(int note) {
        this.note = note;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public Evaluation(String avis) {
        this.avis = avis;
    }

    @Override
    public String toString() {
        return "Evaluation{" + "id_evaluation=" + id_evaluation + ", avis=" + avis + ", id_entretien=" + id_entretien + '}';
    }
    

    public int getId_evaluation() {
        return id_evaluation;
    }

    public void setId_evaluation(int id_evaluation) {
        this.id_evaluation = id_evaluation;
    }

    public String getAvis() {
        return avis;
    }

    public void setAvis(String avis) {
        this.avis = avis;
    }

    public int getId_entretien() {
        return id_entretien;
    }

    public void setId_entretien(int id_entretien) {
        this.id_entretien = id_entretien;
    }
}

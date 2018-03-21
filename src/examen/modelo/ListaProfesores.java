/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen.modelo;

import java.util.ArrayList;

/**
 *
 * @author Yulissa T
 */
public class ListaProfesores {
    
    private ArrayList<Profesor> profesores = new ArrayList<Profesor>();
    
    public ListaProfesores() {
    }

    public ArrayList<Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(ArrayList<Profesor> profesores) {
        this.profesores = profesores;
    }

    public void agregar(Profesor p) {
        this.profesores.add(p);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examen.modelo;

/**
 *
 * @author Yulissa T
 */
public  class Profesor {

    private String cedula;
    private String nombres;
    private String apellidos;
    private int horasClase;
    private String carrera;
    private int horasSemanales;
    private int horasComplementarias;
    private String tipoProfesor;

    public Profesor(String cedula, String nombres, String apellidos, int horasClase, String carrera, int horasSemanales, int horasComplementarias, String tipoProfesor) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.horasClase = horasClase;
        this.carrera = carrera;
        this.horasSemanales = horasSemanales;
        this.horasComplementarias = horasComplementarias;
        this.tipoProfesor = tipoProfesor;
    }

    

    public int getHorasSemanales() {
        return horasComplementarias;
    }

    public void setHorasSemanales(int horasSemanales) {
        this.horasComplementarias = horasSemanales;
    }

    public String getTipoProfesor() {
        return tipoProfesor;
    }

    public void setTipoProfesor(String tipoProfesor) {
        this.tipoProfesor = tipoProfesor;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getHorasClase() {
        return horasClase;
    }

    public void setHorasClase(int horasClase) {
        this.horasClase = horasClase;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public int getHorasComplementarias() {
        return horasComplementarias;
    }

    public void setHorasComplementarias(int horasComplementarias) {
        this.horasComplementarias = horasComplementarias;
    }

   

}

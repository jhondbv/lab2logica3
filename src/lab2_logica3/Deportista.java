/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2_logica3;

/**
 *
 * @author jhon
 */
public class Deportista {
/**
 * 
 * @return nombre del deportista
 */
    public String getNombre() {
        return nombre;
    }
/**
 * ingresa el nombre
 * @param nombre 
 * 
 */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
/**
 * 
 * @return apellido del deportista
 */
    public String getPrimerApellido() {
        return primerApellido;
    }
/**
 * ingresa el apellido
 * @param primerApellido 
 */
    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }
/**
 * 
 * @return segundo apellido
 */
    public String getSegundoApellido() {
        return segundoApellido;
    }
/**
 * 
 * @param segundoApellido 
 */
    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }
/**
 * 
 * @return numero de cedula
 */
    public Long getCedula() {
        return cedula;
    }
/**
 * ingresa cedula
 * @param cedula 
 */
    public void setCedula(Long cedula) {
        this.cedula = cedula;
    }
/**
 * 
 * @return email del deportista
 */
    public String getEmail() {
        return email;
    }
/**
 * 
 * @param email 
 */
    public void setEmail(String email) {
        this.email = email;
    }
/**
 * 
 * @return puntaje del deportista
 */
    public double getPuntaje() {
        return puntaje;
    }
/**
 * 
 * @param puntaje 
 */
    public void setPuntaje(double puntaje) {
        this.puntaje = puntaje;
    }
    
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private Long  cedula;
    private String email;
    private double puntaje;
}

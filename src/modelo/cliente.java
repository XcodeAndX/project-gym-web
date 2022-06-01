package modelo;

import java.util.Calendar;

public class cliente {

    private int id;
    private String Nombre;
    private String Apellido;
    private String email;
    private int edad;
    private double peso;
    private double estatura;
    private double imc;


    public cliente() {
        Calendar fechaInicial = Calendar.getInstance();
        Calendar fechaFinal = Calendar.getInstance();
    }

    public cliente(int id, String nombre, String apellido, String email, int edad, double peso, double estatura, double imc) {
        this.id = id;
        Nombre = nombre;
        Apellido = apellido;
        this.email = email;
        this.edad = edad;
        this.peso = peso;
        this.estatura = estatura;
        this.imc = imc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getEstatura() {
        return estatura;
    }

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    public double getImc(){
            this.imc = peso/Math.pow(2, this.estatura);
        return imc;

    }
}

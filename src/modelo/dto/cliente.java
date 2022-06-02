package modelo.dto;

import java.util.Calendar;
import java.util.Objects;

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

    @Override
    public String toString() {
        return "cliente{" +
                "id=" + id +
                ", Nombre='" + Nombre + '\'' +
                ", Apellido='" + Apellido + '\'' +
                ", email='" + email + '\'' +
                ", edad=" + edad +
                ", peso=" + peso +
                ", estatura=" + estatura +
                ", imc=" + imc +
                '}';

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        cliente cliente = (cliente) o;
        return getId() == cliente.getId() && getEdad() == cliente.getEdad() && Double.compare(cliente.getPeso(),
                getPeso()) == 0 && Double.compare(cliente.getEstatura(), getEstatura()) == 0 &&
                Double.compare(cliente.getImc(), getImc()) == 0 && Objects.equals(getNombre(), cliente.getNombre()) &&
                Objects.equals(getApellido(), cliente.getApellido()) && Objects.equals(getEmail(), cliente.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNombre(), getApellido(), getEmail(), getEdad(), getPeso(), getEstatura(), getImc());
    }

    public double getImc(){
            this.imc = peso/Math.pow(2, this.estatura);
        return imc;

    }

}

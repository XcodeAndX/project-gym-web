package modelo.tests_deportivos;

import modelo.dto.cliente;

public class testCooper extends cliente {

    public int id;
    public int oxigenoMaximo;
    public int kilometroReccorido;

    public testCooper() {
        oxigenoMaximo = 0;
        kilometroReccorido = 0;
    }

    public testCooper(int id, int oxigenoMaximo, int kilometroReccorido) {
        super(id);
        this.oxigenoMaximo = oxigenoMaximo;
        this.kilometroReccorido = kilometroReccorido;
    }

    public int getOxigenoMaximo() {
        return oxigenoMaximo;
    }

    public void setOxigenoMaximo(int oxigenoMaximo) {
        this.oxigenoMaximo = oxigenoMaximo;
    }

    public int getKilometroReccorido() {
        return kilometroReccorido;
    }

    public void setKilometroReccorido(int kilometroReccorido) {
        this.kilometroReccorido = kilometroReccorido;
    }


    public int calcularTestCooper(){
        this.oxigenoMaximo = (22*this.kilometroReccorido)-11;
        return this.oxigenoMaximo;
    }



}

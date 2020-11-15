
package modelo;


public class Mascota {
    int idMascota;
    int idPropietario;
    String nombre;
    String tipo;
    String raza;
    String color;
    float peso;
    int edad;
    String observaciones;
    int idHistoriaClinica;
    int carnetVacunacionIdCarnet;
    
    public Mascota(){
        idMascota=0;
        idPropietario=0;
        nombre="";
        tipo="";
        raza="";
        color="";
        peso=0;
        edad=0;
        observaciones="";
        idHistoriaClinica=0;
        carnetVacunacionIdCarnet=0;
    }

    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }

    public int getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(int idPropietario) {
        this.idPropietario = idPropietario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public int getIdHistoriaClinica() {
        return idHistoriaClinica;
    }

    public void setIdHistoriaClinica(int idHistoriaClinica) {
        this.idHistoriaClinica = idHistoriaClinica;
    }

    public int getCarnetVacunacionIdCarnet() {
        return carnetVacunacionIdCarnet;
    }

    public void setCarnetVacunacionIdCarnet(int carnetVacunacionIdCarnet) {
        this.carnetVacunacionIdCarnet = carnetVacunacionIdCarnet;
    }
  
    
    
    
    
    
    
    
}

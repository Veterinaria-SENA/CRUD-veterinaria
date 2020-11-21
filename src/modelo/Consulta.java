/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Date;

/**
 *
 * @author wilso
 */
public class Consulta { 
    private String id;
    private String id_historia_clinica;
    private String id_veterinario;      
    private Date fecha;
    private String id_tipo_consulta;
    private String diagnostico; 
       
    
    public Consulta (){ 
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getid_historia_clinica() {
        return id_historia_clinica;
    }

    public void setid_historia_clinica(String id_historia_clinica) {
        this.id_historia_clinica = id_historia_clinica;
    }

    public String getid_veterinario() {
        return id_veterinario;
    }

    public void setid_veterinario(String id_veterinario) {
        this.id_veterinario = id_veterinario;
    }

    public Date getfecha() {
        return fecha;
    }

    public void setfecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getid_tipo_consulta() {
        return id_tipo_consulta;
    }

    public void setid_tipo_consulta(String id_tipo_consulta) {
        this.id_tipo_consulta = id_tipo_consulta;
    }

    public String getdiagnostico() {
        return diagnostico;
    }

    public void setdiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    
}

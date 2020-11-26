/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.awt.Color;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import vista.*;
import modelo.*;
/**
 *
 * @author DA5H
 */
public class validaciones {
    
    public boolean validacion(JFCarnetVacunacion vistaCarnetvacunacion)
    {
        vistaCarnetvacunacion.jLerror.setText("");
        boolean respuesta=true;
        if(vacio(vistaCarnetvacunacion.txcarnet.getText())==true 
                || vacio(vistaCarnetvacunacion.txvacuna.getText())==true 
                || vacio(vistaCarnetvacunacion.txmascota.getText())==true 
                || vistaCarnetvacunacion.jDdateFecha.getDate()==null)
        {
            if(vacio(vistaCarnetvacunacion.txcarnet.getText())==true)
            {
                vistaCarnetvacunacion.txcarnet.setBackground(Color.pink);
                vistaCarnetvacunacion.jLerror.setText("Por favor llenar todas las casillas obligatorias");
            } 
            if(vacio(vistaCarnetvacunacion.txmascota.getText())==true)
            {
                vistaCarnetvacunacion.txmascota.setBackground(Color.pink);
                vistaCarnetvacunacion.jLerror.setText("Por favor llenar todas las casillas obligatorias");
            } 
            if(vacio(vistaCarnetvacunacion.txvacuna.getText())==true)
            {
                vistaCarnetvacunacion.txvacuna.setBackground(Color.pink);
                vistaCarnetvacunacion.jLerror.setText("Por favor llenar todas las casillas obligatorias");
            }  
            if(vistaCarnetvacunacion.jDdateFecha.getDate()==null)
            {
                if(vacio(vistaCarnetvacunacion.jLerror.getText())==true)
                {
                    vistaCarnetvacunacion.jLerror.setText("Por favor seleccionar una fecha");          
                }
                else
                {
                    vistaCarnetvacunacion.jLerror.setText("Por favor llenar todas las casillas obligatorias y seleccionar una fecha");
                }
            }    
            respuesta=false;
        }
        else
        {
            if(numerico(vistaCarnetvacunacion.txcarnet.getText())==false)
            {
                vistaCarnetvacunacion.txcarnet.setBackground(Color.pink);
                vistaCarnetvacunacion.jLerror.setText("Por favor llenar la casilla id carnet solo con numeros");
                respuesta=false;
            } 
            else if(numerico(vistaCarnetvacunacion.txmascota.getText())==false)
            {
                vistaCarnetvacunacion.txmascota.setBackground(Color.pink);
                vistaCarnetvacunacion.jLerror.setText("Por favor llenar la casilla id mascota solo con numeros");
                respuesta=false;
            } 
            else if(numerico(vistaCarnetvacunacion.txvacuna.getText())==false)
            {
                vistaCarnetvacunacion.txvacuna.setBackground(Color.pink);
                vistaCarnetvacunacion.jLerror.setText("Por favor llenar la casilla id vacuna solo con numeros");
                respuesta=false;
            }   
        }
        return respuesta;
    }
    
    public boolean validacion(JFConsulta vistaConsulta)
    {
        vistaConsulta.jLerror.setText("");
        boolean respuesta=true;
        if(vacio(vistaConsulta.txId.getText())==true
                || vacio(vistaConsulta.txid_historia_clinica.getText())== true
                || vacio(vistaConsulta.txid_veterinario.getText())==true
                || vistaConsulta.txFecha.getDate()==null
                || vacio(vistaConsulta.txid_tipo_consulta.getText())==true
                || vacio(vistaConsulta.txdiagnostico.getText())==true)
        {
            if(vacio(vistaConsulta.txId.getText())==true)
            {
                vistaConsulta.txId.setBackground(Color.pink);
                vistaConsulta.jLerror.setText("Por favor llenar todas las casillas obligatorias");
            }
            if(vacio(vistaConsulta.txid_historia_clinica.getText())==true)
            {
                vistaConsulta.txid_historia_clinica.setBackground(Color.pink);
                vistaConsulta.jLerror.setText("Por favor llenar todas las casillas obligatorias");
            }
            if(vacio(vistaConsulta.txid_veterinario.getText())==true)
            {
                vistaConsulta.txid_veterinario.setBackground(Color.pink);
                vistaConsulta.jLerror.setText("Por favor llenar todas las casillas obligatorias");
            }
            if(vacio(vistaConsulta.txid_tipo_consulta.getText())==true)
            {
                vistaConsulta.txid_tipo_consulta.setBackground(Color.pink);
                vistaConsulta.jLerror.setText("Por favor llenar todas las casillas obligatorias");
            }
            if(vacio(vistaConsulta.txdiagnostico.getText())==true)
            {
                vistaConsulta.txdiagnostico.setBackground(Color.pink);
                vistaConsulta.jLerror.setText("Por favor llenar todas las casillas obligatorias");
            }
            if(vistaConsulta.txFecha.getDate()==null)
            {
                if(vacio(vistaConsulta.jLerror.getText())==true)
                {
                    vistaConsulta.jLerror.setText("Por favor seleccionar una fecha");          
                }
                else
                {
                    vistaConsulta.jLerror.setText("Por favor llenar todas las casillas obligatorias y seleccionar una fecha");
                }
            }
            respuesta=false;
        }
        else
        {
            if(numerico(vistaConsulta.txId.getText())==false)
            {
                vistaConsulta.txId.setBackground(Color.pink);
                vistaConsulta.jLerror.setText("Por favor llenar la casilla id solo con numeros");
                respuesta=false;
            }
            else if(numerico(vistaConsulta.txid_historia_clinica.getText())==false)
            {
                vistaConsulta.txid_historia_clinica.setBackground(Color.pink);
                vistaConsulta.jLerror.setText("Por favor llenar la casilla id historia clinica solo con numeros");
                respuesta=false;
            } 
            else if(numerico(vistaConsulta.txid_veterinario.getText())==false)
            {
                vistaConsulta.txid_veterinario.setBackground(Color.pink);
                vistaConsulta.jLerror.setText("Por favor llenar la casilla id veterinario solo con numeros");
                respuesta=false;
            } 
            else if(numerico(vistaConsulta.txid_tipo_consulta.getText())==false)
            {
                vistaConsulta.txid_tipo_consulta.setBackground(Color.pink);
                vistaConsulta.jLerror.setText("Por favor llenar la casilla id tipo consulta solo con numeros");
                respuesta=false;
            } 
            else if(alfabetico(vistaConsulta.txdiagnostico.getText())==false)
            {
                vistaConsulta.txdiagnostico.setBackground(Color.pink);
                vistaConsulta.jLerror.setText("Por favor llenar la casilla diagnostico solo con numeros");
                respuesta=false;
            } 
        }
        
        return respuesta;
    }
    public boolean validacion(JFHistoriaClinica vistaHistoriaClinica)
    {
        vistaHistoriaClinica.jLerror.setText("");
        boolean respuesta=true;
        if(vacio(vistaHistoriaClinica.txtIdHistoriaClinica.getText())==true
                || vacio(vistaHistoriaClinica.txtIdMascota.getText())==true
                || vistaHistoriaClinica.txtFechaApertura.getDate()==null)
        {
            if(vacio(vistaHistoriaClinica.txtIdHistoriaClinica.getText())==true)
            {
                vistaHistoriaClinica.txtIdHistoriaClinica.setBackground(Color.pink);
                vistaHistoriaClinica.jLerror.setText("Por favor llenar todas las casillas obligatorias");
            }
            if(vacio(vistaHistoriaClinica.txtIdMascota.getText())==true)
            {
                vistaHistoriaClinica.txtIdMascota.setBackground(Color.pink);
                vistaHistoriaClinica.jLerror.setText("Por favor llenar todas las casillas obligatorias");
            }
            if(vistaHistoriaClinica.txtFechaApertura.getDate()==null)
            {
                if(vacio(vistaHistoriaClinica.jLerror.getText())==true)
                {
                    vistaHistoriaClinica.jLerror.setText("Por favor seleccionar una fecha");          
                }
                else
                {
                    vistaHistoriaClinica.jLerror.setText("Por favor llenar todas las casillas obligatorias y seleccionar una fecha");
                }
            }
            respuesta = false;
        }
        else
        {
            if(numerico(vistaHistoriaClinica.txtIdHistoriaClinica.getText())==false)
            {
                vistaHistoriaClinica.txtIdHistoriaClinica.setBackground(Color.pink);
                vistaHistoriaClinica.jLerror.setText("Por favor llenar la casilla id Historia Clinica solo con numeros");
                respuesta=false;
            }
            else if(numerico(vistaHistoriaClinica.txtIdMascota.getText())==false)
            {
                vistaHistoriaClinica.txtIdMascota.setBackground(Color.pink);
                vistaHistoriaClinica.jLerror.setText("Por favor llenar la casilla id Mascota solo con numeros");
                respuesta=false;
            }
        }
        return respuesta;
    }
    public boolean validacion(JFMascota vistaMascota)
    {
        vistaMascota.jLerror.setText("");
        boolean respuesta=true;
        if(vacio(vistaMascota.txtObservaciones.getText())==true)
        {
            vistaMascota.txtObservaciones.setText("ninguna");
        }
        if(vacio(vistaMascota.txtIdMascota.getText())==true
                ||vacio(vistaMascota.txtIdPropietario.getText())==true
                ||vacio(vistaMascota.txtNombre.getText())==true
                ||vacio(vistaMascota.txtTipo.getText())==true
                ||vacio(vistaMascota.txtRaza.getText())==true
                ||vacio(vistaMascota.txtColor.getText())==true
                ||vacio(vistaMascota.txtEdad.getText())==true
                ||vacio(vistaMascota.txtPeso.getText())==true)
        {
            if(vacio(vistaMascota.txtIdMascota.getText())==true)
            {
                vistaMascota.txtIdMascota.setBackground(Color.pink);
                vistaMascota.jLerror.setText("Por favor llenar todas las casillas obligatorias");
            }
            if(vacio(vistaMascota.txtIdPropietario.getText())==true)
            {
                vistaMascota.txtIdPropietario.setBackground(Color.pink);
                vistaMascota.jLerror.setText("Por favor llenar todas las casillas obligatorias");
            }
            if(vacio(vistaMascota.txtNombre.getText())==true)
            {
                vistaMascota.txtNombre.setBackground(Color.pink);
                vistaMascota.jLerror.setText("Por favor llenar todas las casillas obligatorias");
            }
            if(vacio(vistaMascota.txtTipo.getText())==true)
            {
                vistaMascota.txtTipo.setBackground(Color.pink);
                vistaMascota.jLerror.setText("Por favor llenar todas las casillas obligatorias");
            }
            if(vacio(vistaMascota.txtRaza.getText())==true)
            {
                vistaMascota.txtRaza.setBackground(Color.pink);
                vistaMascota.jLerror.setText("Por favor llenar todas las casillas obligatorias");
            }
            if(vacio(vistaMascota.txtColor.getText())==true)
            {
                vistaMascota.txtColor.setBackground(Color.pink);
                vistaMascota.jLerror.setText("Por favor llenar todas las casillas obligatorias");
            }
            if(vacio(vistaMascota.txtEdad.getText())==true)
            {
                vistaMascota.txtEdad.setBackground(Color.pink);
                vistaMascota.jLerror.setText("Por favor llenar todas las casillas obligatorias");
            }
            if(vacio(vistaMascota.txtPeso.getText())==true)
            {
                vistaMascota.txtPeso.setBackground(Color.pink);
                vistaMascota.jLerror.setText("Por favor llenar todas las casillas obligatorias");
            }
            respuesta = false;
        }
        else
        {
            if(numerico(vistaMascota.txtIdMascota.getText())==false)
            {
                vistaMascota.txtIdMascota.setBackground(Color.pink);
                vistaMascota.jLerror.setText("Por favor llenar la casilla id mascota solo con numeros");
                respuesta=false;
            }
            else if(numerico(vistaMascota.txtIdPropietario.getText())==false)
            {
                vistaMascota.txtIdPropietario.setBackground(Color.pink);
                vistaMascota.jLerror.setText("Por favor llenar la casilla id propietario solo con numeros");
                respuesta=false;
            }
            else if(alfabetico(vistaMascota.txtNombre.getText())==false)
            {
                vistaMascota.txtNombre.setBackground(Color.pink);
                vistaMascota.jLerror.setText("Por favor llenar la casilla nombre solo con letras");
                respuesta=false;
            }
            else if(alfabetico(vistaMascota.txtTipo.getText())==false)
            {
                vistaMascota.txtTipo.setBackground(Color.pink);
                vistaMascota.jLerror.setText("Por favor llenar la casilla tipo solo con letras");
                respuesta=false;
            }
            else if(alfabetico(vistaMascota.txtRaza.getText())==false)
            {
                vistaMascota.txtRaza.setBackground(Color.pink);
                vistaMascota.jLerror.setText("Por favor llenar la casilla raza solo con letras");
                respuesta=false;
            }
            else if(alfabetico(vistaMascota.txtColor.getText())==false)
            {
                vistaMascota.txtColor.setBackground(Color.pink);
                vistaMascota.jLerror.setText("Por favor llenar la casilla color solo con letras");
                respuesta=false;
            }
            else if(numerico(vistaMascota.txtEdad.getText())==false)
            {
                vistaMascota.txtEdad.setBackground(Color.pink);
                vistaMascota.jLerror.setText("Por favor llenar la casilla edad solo con numeros");
                respuesta=false;
            }
            else if(numerico(vistaMascota.txtPeso.getText())==false)
            {
                vistaMascota.txtPeso.setBackground(Color.pink);
                vistaMascota.jLerror.setText("Por favor llenar la casilla peso solo con numeros");
                respuesta=false;
            }
            else if(numerico(vistaMascota.txtObservaciones.getText())==false)
            {
                vistaMascota.txtObservaciones.setBackground(Color.pink);
                vistaMascota.jLerror.setText("Por favor llenar la casilla observaciones solo con letras");
                respuesta=false;
            }
            
        }
        return respuesta;
    }
    public boolean validacion(JFPropietario vistaPropietario)
    {
        vistaPropietario.jLerror.setText("");
        boolean respuesta=true;
        if(vacio(vistaPropietario.txId.getText())==true
                ||vacio(vistaPropietario.txNombre.getText())==true
                ||vacio(vistaPropietario.txApellido.getText())==true
                ||vacio(vistaPropietario.txDireccion.getText())==true
                ||vacio(vistaPropietario.txTelefono.getText())==true
                ||vacio(vistaPropietario.txCelular.getText())==true
                ||vacio(vistaPropietario.txCorreo.getText())==true)
        {
            if(vacio(vistaPropietario.txId.getText())==true)
               {
                   vistaPropietario.txId.setBackground(Color.pink);
                   vistaPropietario.jLerror.setText("Por favor llenar todas las casillas obligatorias");
               }
            if(vacio(vistaPropietario.txNombre.getText())==true)
               {
                   vistaPropietario.txNombre.setBackground(Color.pink);
                   vistaPropietario.jLerror.setText("Por favor llenar todas las casillas obligatorias");
               }
            if(vacio(vistaPropietario.txApellido.getText())==true)
               {
                   vistaPropietario.txApellido.setBackground(Color.pink);
                   vistaPropietario.jLerror.setText("Por favor llenar todas las casillas obligatorias");
               }
            if(vacio(vistaPropietario.txDireccion.getText())==true)
               {
                   vistaPropietario.txDireccion.setBackground(Color.pink);
                   vistaPropietario.jLerror.setText("Por favor llenar todas las casillas obligatorias");
               }
            if(vacio(vistaPropietario.txTelefono.getText())==true)
               {
                   vistaPropietario.txTelefono.setBackground(Color.pink);
                   vistaPropietario.jLerror.setText("Por favor llenar todas las casillas obligatorias");
               }
            if(vacio(vistaPropietario.txCelular.getText())==true)
               {
                   vistaPropietario.txCelular.setBackground(Color.pink);
                   vistaPropietario.jLerror.setText("Por favor llenar todas las casillas obligatorias");
               }
            if(vacio(vistaPropietario.txCorreo.getText())==true)
               {
                   vistaPropietario.txCorreo.setBackground(Color.pink);
                   vistaPropietario.jLerror.setText("Por favor llenar todas las casillas obligatorias");
               }
            respuesta=false;
        }
        else
        {
            if(numerico(vistaPropietario.txId.getText())==false)
            {
                vistaPropietario.txId.setBackground(Color.pink);
                vistaPropietario.jLerror.setText("Por favor llenar la casilla id solo con numeros");
                respuesta=false;
            }
            else if(alfabetico(vistaPropietario.txNombre.getText())==false)
            {
                vistaPropietario.txNombre.setBackground(Color.pink);
                vistaPropietario.jLerror.setText("Por favor llenar la casilla nombre solo con letras");
                respuesta=false;
            }
            else if(alfabetico(vistaPropietario.txApellido.getText())==false)
            {
                vistaPropietario.txApellido.setBackground(Color.pink);
                vistaPropietario.jLerror.setText("Por favor llenar la casilla apellido solo con letras");
                respuesta=false;
            }
            else if(numerico(vistaPropietario.txTelefono.getText())==false)
            {
                vistaPropietario.txTelefono.setBackground(Color.pink);
                vistaPropietario.jLerror.setText("Por favor llenar la casilla telefono solo con numeros");
                respuesta=false;
            }
            else if(numerico(vistaPropietario.txCelular.getText())==false)
            {
                vistaPropietario.txCelular.setBackground(Color.pink);
                vistaPropietario.jLerror.setText("Por favor llenar la casilla celular solo con numeros");
                respuesta=false;
            }
            else if(correo(vistaPropietario.txCorreo.getText())==false)
            {
                vistaPropietario.txCorreo.setBackground(Color.pink);
                vistaPropietario.jLerror.setText("Por favor llenar la casilla correo con un correo valido");
                respuesta=false;
            }
            
        }
        return respuesta;
    }
    public boolean validacion(JFVeterinario vistaVeterinario)
    {
        vistaVeterinario.jLerror.setText("");
        boolean respuesta=true;
        if(vacio(vistaVeterinario.txId.getText())==true
                ||vacio(vistaVeterinario.txNombre.getText())==true
                ||vacio(vistaVeterinario.txApellido.getText())==true
                ||vacio(vistaVeterinario.txDireccion.getText())==true
                ||vacio(vistaVeterinario.txTelefono.getText())==true
                ||vacio(vistaVeterinario.txCelular.getText())==true
                ||vacio(vistaVeterinario.txCorreo.getText())==true)
        {
            if(vacio(vistaVeterinario.txId.getText())==true)
               {
                   vistaVeterinario.txId.setBackground(Color.pink);
                   vistaVeterinario.jLerror.setText("Por favor llenar todas las casillas obligatorias");
               }
            if(vacio(vistaVeterinario.txNombre.getText())==true)
               {
                   vistaVeterinario.txNombre.setBackground(Color.pink);
                   vistaVeterinario.jLerror.setText("Por favor llenar todas las casillas obligatorias");
               }
            if(vacio(vistaVeterinario.txApellido.getText())==true)
               {
                   vistaVeterinario.txApellido.setBackground(Color.pink);
                   vistaVeterinario.jLerror.setText("Por favor llenar todas las casillas obligatorias");
               }
            if(vacio(vistaVeterinario.txDireccion.getText())==true)
               {
                   vistaVeterinario.txDireccion.setBackground(Color.pink);
                   vistaVeterinario.jLerror.setText("Por favor llenar todas las casillas obligatorias");
               }
            if(vacio(vistaVeterinario.txTelefono.getText())==true)
               {
                   vistaVeterinario.txTelefono.setBackground(Color.pink);
                   vistaVeterinario.jLerror.setText("Por favor llenar todas las casillas obligatorias");
               }
            if(vacio(vistaVeterinario.txCelular.getText())==true)
               {
                   vistaVeterinario.txCelular.setBackground(Color.pink);
                   vistaVeterinario.jLerror.setText("Por favor llenar todas las casillas obligatorias");
               }
            if(vacio(vistaVeterinario.txCorreo.getText())==true)
               {
                   vistaVeterinario.txCorreo.setBackground(Color.pink);
                   vistaVeterinario.jLerror.setText("Por favor llenar todas las casillas obligatorias");
               }
            respuesta=false;
        }
        else
        {
            if(numerico(vistaVeterinario.txId.getText())==false)
            {
                vistaVeterinario.txId.setBackground(Color.pink);
                vistaVeterinario.jLerror.setText("Por favor llenar la casilla id solo con numeros");
                respuesta=false;
            }
            else if(alfabetico(vistaVeterinario.txNombre.getText())==false)
            {
                vistaVeterinario.txNombre.setBackground(Color.pink);
                vistaVeterinario.jLerror.setText("Por favor llenar la casilla nombre solo con letras");
                respuesta=false;
            }
            else if(alfabetico(vistaVeterinario.txApellido.getText())==false)
            {
                vistaVeterinario.txApellido.setBackground(Color.pink);
                vistaVeterinario.jLerror.setText("Por favor llenar la casilla apellido solo con letras");
                respuesta=false;
            }
            else if(numerico(vistaVeterinario.txTelefono.getText())==false)
            {
                vistaVeterinario.txTelefono.setBackground(Color.pink);
                vistaVeterinario.jLerror.setText("Por favor llenar la casilla telefono solo con numeros");
                respuesta=false;
            }
            else if(numerico(vistaVeterinario.txCelular.getText())==false)
            {
                vistaVeterinario.txCelular.setBackground(Color.pink);
                vistaVeterinario.jLerror.setText("Por favor llenar la casilla celular solo con numeros");
                respuesta=false;
            }
            else if(correo(vistaVeterinario.txCorreo.getText())==false)
            {
                vistaVeterinario.txCorreo.setBackground(Color.pink);
                vistaVeterinario.jLerror.setText("Por favor llenar la casilla correo con un correo valido");
                respuesta=false;
            }
            
        }
        return respuesta;
    }
    public boolean vacio(String entrada)
    {
        Pattern patron = Pattern.compile("^$");
        Matcher coincidencia = patron.matcher(entrada); 
        return coincidencia.matches();
    }
    public boolean alfabetico(String entrada)
    {
        boolean respuesta = true;
        for(int i=0;i<entrada.length();i++)
        {
            Pattern patron = Pattern.compile("^[a-zA-Z\\s]$");
            Matcher coincidencia = patron.matcher(String.valueOf(entrada.charAt(i))); 
            if(coincidencia.matches()==false)
            {
                respuesta=false;
                break;
            }
        }
        return respuesta;
    }
    public boolean numerico(String entrada)
    {
        boolean respuesta = true;
        for(int i=0;i<entrada.length();i++)
        {
            Pattern patron = Pattern.compile("^[\\s0-9]$");
            Matcher coincidencia = patron.matcher(String.valueOf(entrada.charAt(i))); 
            if(coincidencia.matches()==false)
            {
                respuesta=false;
                break;
            }
        }
        return respuesta;
    }
    public boolean correo(String entrada)
    {
        boolean respuesta = true;
        int val=0;
        for(int i=0;i<entrada.length();i++)
        {
            Pattern patron = Pattern.compile("^[@]$");
            Matcher coincidencia = patron.matcher(String.valueOf(entrada.charAt(i))); 
            if(coincidencia.matches()==true)
            {
                val++;
            }
        }
        if (val!=1)
        {
            respuesta=false;
        }
        return respuesta;
    }
    public boolean usuario(String usuario,String clave)
    {
        VeterinarioDAO modeloCRUD = new VeterinarioDAO();
        ArrayList<Veterinario> listaVeterinario=modeloCRUD.listveterinario();
        int numRegistro =listaVeterinario.size();
        boolean respuesta=false;
        for(int i=0;i<numRegistro;i++)
        {
            if(usuario.trim().equals(listaVeterinario.get (i).getCorreo().trim()) && clave.trim().equals(listaVeterinario.get (i).getTelefono().trim()))
            {
                respuesta = true;
                i=numRegistro;
            }
        }
        return respuesta;
    }
}

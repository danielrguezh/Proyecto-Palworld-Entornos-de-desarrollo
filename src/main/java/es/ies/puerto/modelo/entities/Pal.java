package es.ies.puerto.modelo.entities;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.io.Serializable;
import java.util.Objects;


public class Pal implements Serializable {
    private String palId;
    private String nombre;
    private String elemento;
    private HabilidadPal habilidad;
    private int hp;
    private int atk;
    private int def;

    private String personajeId;

    public Pal(){}

    public Pal(String palId){
        this.palId = palId;
    }

    public Pal(String palId, String nombre, String elemento, HabilidadPal habilidad, int hp, int atk, int def, String personajeId) {
        this.palId = palId;
        this.nombre = nombre;
        this.elemento = elemento;
        this.habilidad = habilidad;
        this.hp = hp;
        this.atk = atk;
        this.def = def;
        this.personajeId = personajeId;
    }

    public String getPalId() {
        return palId;
    }

    public void setPalId(String palId) {
        this.palId = palId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getElemento() {
        return elemento;
    }

    public void setElemento(String elemento) {
        this.elemento = elemento;
    }

    public HabilidadPal getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(HabilidadPal habilidad) {
        this.habilidad = habilidad;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public String getPersonajeId() {
        return personajeId;
    }

    public void setPersonajeId(String personajeId) {
        this.personajeId = personajeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pal pal = (Pal) o;
        return Objects.equals(palId, pal.palId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(palId);
    }

    @Override
    public String toString() {
        return "Pal{" +
                "palId='" + palId + '\'' +
                ", nombre='" + nombre + '\'' +
                ", elemento='" + elemento + '\'' +
                ", habilidad=" + habilidad +
                ", hp=" + hp +
                ", atk=" + atk +
                ", def=" + def +
                ", personajeId='" + personajeId + '\'' +
                '}';
    }
}

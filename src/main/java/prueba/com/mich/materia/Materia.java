package prueba.com.mich.materia;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "materia")
public class Materia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String nombremateria;

    @Column(nullable = false, length = 50)
    private String profesor;

    @Column(nullable = false, length = 50)
    private String carrera;

    @Column(name = "horas_semanales", nullable = false)
    private Integer horasSemanales;

    @SuppressWarnings("unused")
    public Materia() {
    }

    @SuppressWarnings("unused")
    public Materia(String nombremateria, String profesor, String carrera, Integer horasSemanales) {
        this.nombremateria = nombremateria;
        this.profesor = profesor;
        this.carrera = carrera;
        this.horasSemanales = horasSemanales;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombremateria() {
        return nombremateria;
    }

    public void setNombremateria(String nombremateria) {
        this.nombremateria = nombremateria;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public Integer getHorasSemanales() {
        return horasSemanales;
    }

    public void setHorasSemanales(Integer horasSemanales) {
        this.horasSemanales = horasSemanales;
    }

    @Override
    @SuppressWarnings("unused")
    public String toString() {
        return "Materia{" +
                "id=" + id +
                ", nombremateria='" + nombremateria + '\'' +
                ", profesor='" + profesor + '\'' +
                ", carrera='" + carrera + '\'' +
                ", horasSemanales=" + horasSemanales +
                '}';
    }
}

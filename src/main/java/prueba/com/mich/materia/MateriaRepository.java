package prueba.com.mich.materia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MateriaRepository extends JpaRepository<Materia, Long> {

    @Query("""
        SELECT m FROM Materia m
        WHERE LOWER(m.nombremateria) LIKE LOWER(CONCAT('%', :valor, '%'))
           OR LOWER(m.profesor) LIKE LOWER(CONCAT('%', :valor, '%'))
           OR LOWER(m.carrera) LIKE LOWER(CONCAT('%', :valor, '%'))
           OR CAST(m.id AS string) LIKE CONCAT('%', :valor, '%')
    """)
    List<Materia> buscarPorTodo(@Param("valor") String valor);
}

package com.sostraik1903.distroprofes_v3.repository;

import com.sostraik1903.distroprofes_v3.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface CursoRepository extends JpaRepository<Curso, Integer> {

    @Query(value = "select pc.id_profesor, p.email, pc.id_curso, c.nombre from profesores_curso pc inner join profesor p on pc.id_profesor = p.id_profesor inner join curso c on pc.id_curso = c.id_curso;", nativeQuery = true)
    public abstract Collection<Object[]> findAllWithProfesores();
}

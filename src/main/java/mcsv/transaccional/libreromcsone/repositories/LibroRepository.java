package mcsv.transaccional.libreromcsone.repositories;

import mcsv.transaccional.libreromcsone.models.Autor;
import mcsv.transaccional.libreromcsone.models.Categoria;
import mcsv.transaccional.libreromcsone.models.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroRepository extends JpaRepository<Libro, String> {

    List<Libro> findLibroByTituloContainingIgnoreCase(String titulo);
}

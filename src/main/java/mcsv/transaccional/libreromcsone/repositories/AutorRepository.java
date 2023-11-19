package mcsv.transaccional.libreromcsone.repositories;

import mcsv.transaccional.libreromcsone.models.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<Autor, String> {
    Autor findLibroByNombreContainingIgnoreCase(String nombreAuthor);
}

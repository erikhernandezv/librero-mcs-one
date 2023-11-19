package mcsv.transaccional.libreromcsone.repositories;

import mcsv.transaccional.libreromcsone.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, String> {
    Categoria findLibroByNombreContainingIgnoreCase(String nombreCategory);
}

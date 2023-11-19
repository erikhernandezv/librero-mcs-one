package mcsv.transaccional.libreromcsone.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mcsv.transaccional.libreromcsone.models.Autor;
import mcsv.transaccional.libreromcsone.models.Categoria;
import mcsv.transaccional.libreromcsone.repositories.AutorRepository;
import mcsv.transaccional.libreromcsone.repositories.CategoriaRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@Service
@AllArgsConstructor
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public Categoria findCategoriaByNombreContainingIgnoreCase(String nombreCategory) {
        try {
            return categoriaRepository.findCategoriaByNombreContainingIgnoreCase(nombreCategory);
        } catch (DataAccessException e) {
            log.error("Error al buscar la categoria ingresado", e);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error al buscar la categoria ingresado", e);
        }
    }
}

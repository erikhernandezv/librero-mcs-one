package mcsv.transaccional.libreromcsone.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mcsv.transaccional.libreromcsone.models.Autor;
import mcsv.transaccional.libreromcsone.repositories.AutorRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@Service
@AllArgsConstructor
public class AutorService {

    private final AutorRepository autorRepository;

    public Autor findLibroByNombreContainingIgnoreCase(String nombreAuthor) {
        try {
            return autorRepository.findLibroByNombreContainingIgnoreCase(nombreAuthor);
        } catch (DataAccessException e) {
            log.error("Error al buscar el autor ingresado", e);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error al buscar el autor ingresado", e);
        }
    }
}

package mcsv.transaccional.libreromcsone.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mcsv.transaccional.libreromcsone.models.Autor;
import mcsv.transaccional.libreromcsone.models.Libro;
import mcsv.transaccional.libreromcsone.repositories.LibroRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Slf4j
@Service
@AllArgsConstructor
public class LibroService {

    private final LibroRepository libroRepository;

    public Libro saveLibro(Libro libro) {
        try {
            return libroRepository.save(libro);
        } catch (DataAccessException e) {
            log.error("Error al guardar el libro", e);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error al guardar el libro", e);
        }
    }
    public Libro getLibroById(String id) {
        try {
            return libroRepository.findById(id).orElse(null);
        } catch (DataAccessException e) {
            log.error("Error al consultar el libro por id", e);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error al guardar el libro", e);
        }
    }

    public List<Libro> getAllLibros() {
        try {
            return libroRepository.findAll();
        } catch (DataAccessException e) {
            log.error("Error al buscar todos los libros", e);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error al buscar todos los libros", e);
        }
    }

    public Libro updateLibro(Libro libro) {
        try {
            Libro existingLibro = libroRepository.findById(libro.getId()).orElse(null);
            Objects.requireNonNull(existingLibro).setTitulo( libro.getTitulo() );
            Objects.requireNonNull(existingLibro).setCategoria( libro.getCategoria() );
            Objects.requireNonNull(existingLibro).setAutor( libro.getAutor() );

            return libroRepository.save(existingLibro);
        } catch (DataAccessException e) {
            log.error("Error al actualizar el libro", e);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error al guardar el libro", e);
        }
    }

    public String deleteLibro(String id) {
        Optional<Libro> optionalLibro = libroRepository.findById(id);

        if (optionalLibro.isPresent()) {
            Libro usuario = optionalLibro.get();
            libroRepository.deleteById(usuario.getId());
            log.info("El libro con Id= " + id + " ha sido eliminado");
            return "El libro con Id= " + id + " ha sido eliminado";
        } else {
            log.error("Libro con Id=" + id + " no encontrado");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Libro con Id=" + id + " no encontrado");
        }
    }

    public List<Libro> findLibroByTituloContainingIgnoreCase(String titulo) {
        try {
            return libroRepository.findLibroByTituloContainingIgnoreCase(titulo);
        } catch (DataAccessException e) {
            log.error("Error al buscar libro por titulo", e);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error al guardar el libro", e);
        }
    }

}

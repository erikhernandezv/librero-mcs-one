package mcsv.transaccional.libreromcsone.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import mcsv.transaccional.libreromcsone.models.Libro;
import mcsv.transaccional.libreromcsone.services.LibroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/v1/libros")
@Tag(name = "Libros", description = "Operaciones sobre los libros de la aplicacion Librero")
public class LibroController {

    private final LibroService libroService;

    @PostMapping("")
    @Operation(summary = "Crear un nuevo libro", description = "Permite crear un nuevo libro")
    @Parameter(name = "Libro", description = "Libro a crear", content = @Content(schema = @Schema(implementation = Libro.class)))
    @ApiResponse(responseCode = "200", description = "Libro Creado",
            content = @Content(schema = @Schema(implementation = Libro.class)))
    public Libro saveUsuario(@RequestBody Libro libro) {
        return libroService.saveLibro(libro);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Consultar un libro por Id", description = "Permite consultar un libro por Id")
    @Parameter(name = "Id", description = "Id del libro a buscar")
    @ApiResponse(responseCode = "200", description = "Libro encontrado",
            content = @Content(schema = @Schema(implementation = Libro.class)))
    public Libro getUsuarioById(@PathVariable String id) {
        return libroService.getLibroById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    @Operation(summary = "Borrar un libro por Id", description = "Permite borrar un libro, dado un Id")
    @Parameter(name = "Id", description = "Id del libro a borrar")
    @ApiResponse(responseCode = "204", description = "Libro eliminado")
    public ResponseEntity<String> deleteUsuario(@PathVariable String id) {
        try {
            return new ResponseEntity<>(libroService.deleteLibro(id), HttpStatus.NO_CONTENT);
        } catch (ResponseStatusException ex) {
            return new ResponseEntity<>(ex.getStatusCode());
        }
    }

    @GetMapping("")
    @Operation(summary = "Buscar todos los libros", description = "Permite obtener el listado de todos los libros")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Libro creados en el sistema",
                    content = @Content(schema = @Schema(implementation = Libro.class)))
    })
    public List<Libro> getAllLibros(){
        return libroService.getAllLibros();
    }

    @PutMapping("")
    @Operation(summary = "Actualizar un libro", description = "Permite actualizar un libro existente")
    @Parameter(name = "Libro", description = "Libro a actualizar", content = @Content(schema = @Schema(implementation = Libro.class)))
    @ApiResponse(responseCode = "200", description = "Libro actualizado",
            content = @Content(schema = @Schema(implementation = Libro.class)))
    public Libro updateUsuario(@RequestBody Libro libro) {
        return libroService.updateLibro(libro);
    }

    @GetMapping("/findByEmail/{email}")
    @Operation(summary = "Buscar libros por titulo", description = "Permite buscar libros por su titulo")
    @Parameter(name = "Titulo", description = "Titulo del libro a buscar")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Libros que contienen el titulo dado",
                    content = @Content(schema = @Schema(implementation = Libro.class)))
    })
    public List<Libro> findTituloByLibro(@PathVariable String titulo){
        return libroService.findLibroByTituloContainingIgnoreCase(titulo);
    }
}

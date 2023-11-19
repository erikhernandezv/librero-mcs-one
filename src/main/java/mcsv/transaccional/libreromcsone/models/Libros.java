package mcsv.transaccional.libreromcsone.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "libros")
@Schema(description = "modelo que gestiona los libros del librero")
public class Libros {

    @jakarta.persistence.Id
    @Schema(description = "Id unico del libro, usualmente una identificacion con tipo", example = "123456")
    protected String id;

    @Schema(description = "Titulo del libro", example = "Spring Boot y sus ventajas")
    protected String titulo;

    @Schema(description = "Identificar del Autores de los libros", example = "145")
    @Column(name = "idautor")
    protected Autor autor;

    @Schema(description = "Identificadpr de las Categorias de los libros", example = "456")
    @Column(name = "idcategoria")
    protected Categoria categoria;

    @Override
    public String toString() {
        return "Libros{" +
                "id='" + id + '\'' +
                ", titulo='" + titulo + '\'' +
                ", autor=" + autor +
                ", categoria=" + categoria +
                '}';
    }
}

package mcsv.transaccional.libreromcsone.models;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Table(name = "autor")
@Schema(description = "modelo que gestiona las categorias del librero")
public class Categoria {

    @jakarta.persistence.Id
    @Schema(description = "Id unico del libro, usualmente una identificacion con tipo", example = "123456")
    protected String id;

    @Schema(description = "Nombre de la categoria del autor de los libros", example = "Desarrollo")
    protected String nombre;

    @Schema(description = "Descripción de la categoria del autor de los libros", example = "Libros técnicos de desarrollo de software")
    protected String descripcion;

    @Override
    public String toString() {
        return "Categoria{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}

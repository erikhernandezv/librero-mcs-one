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
@Schema(description = "modelo que gestiona los autores del librero")
public class Autor {

    @jakarta.persistence.Id
    @Schema(description = "Id unico del libro, usualmente una identificacion con tipo", example = "123456")
    protected String id;

    @Schema(description = "Nombre del autor del libro", example = "Erik Hernandez")
    protected String nombre;

    @Override
    public String toString() {
        return "Autor{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}

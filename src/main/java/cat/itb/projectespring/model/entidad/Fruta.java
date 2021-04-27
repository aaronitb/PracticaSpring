package cat.itb.projectespring.model.entidad;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Fruta {

    @Id
    @NotNull
    @NotEmpty
    private String nombreFruta;
    @NotNull
    @NotEmpty
    private String colorFruta;
    @NotNull
    @NotEmpty
    private String saborFruta;
    @NotNull
    @NotEmpty
    private String temporadaFruta;

}

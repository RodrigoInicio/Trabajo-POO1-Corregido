package ar.com.practico1.trabajo.trabajo_01.clases;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class Cliente {
    //Clase "abstract" para que todos los tipos de cliente partan de esta unica base
    private int numero;
}

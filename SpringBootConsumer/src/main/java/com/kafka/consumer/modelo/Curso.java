package com.kafka.consumer.modelo;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Curso {
    private Long id;
    private String nombre;
    private String descripcion;
}

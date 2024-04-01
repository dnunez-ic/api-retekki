package com.innerconsulting.retekki.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reaction {
    @PrimaryKey
    private String id;
    private String ubicacion;
    private String fechaHora;
    private String emocion;
}

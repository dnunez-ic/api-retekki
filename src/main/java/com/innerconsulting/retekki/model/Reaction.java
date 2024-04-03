package com.innerconsulting.retekki.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;


@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reaction {

    @Id
    @PrimaryKey("id")
    @PrimaryKeyColumn(name = "id", type = PrimaryKeyType.PARTITIONED)
    private UUID id;

    private String id_unidad;
    private String ubicacion;
    private String fechaHora;
    private String emocion;
}


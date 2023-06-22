package com.example.retrofitpaisesroomsqlite

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "pais_table")
data class PaisEntity(
    @PrimaryKey
    @Embedded
    @SerializedName("id")
    val id: Id,
    @SerializedName("nome")
    val nome: String,
    @Embedded
    @SerializedName("regiao-intermediaria")
    val regiaoIntermediaria: RegiaoIntermediaria?,
    @Embedded
    @SerializedName("sub-regiao")
    val subRegiao: SubRegiao
)
{
    data class Id(
        @SerializedName("ISO-ALPHA-2")
        val iSOALPHA2: String,
        @SerializedName("ISO-ALPHA-3")
        val iSOALPHA3: String,
        @SerializedName("M49")
        val m49: Int
    )

    data class RegiaoIntermediaria(
        @Embedded
        @SerializedName("id")
        val id: Id,
        @SerializedName("nome")
        val nome: String
    ) {
        data class Id(
            @SerializedName("M49")
            val m49: Int
        )
    }

    data class SubRegiao(
        @Embedded
        @SerializedName("id")
        val id: Id,
        @SerializedName("nome")
        val nome: String,
        @Embedded
        @SerializedName("regiao")
        val regiao: Regiao
    ) {
        data class Id(
            @SerializedName("M49")
            val m49: Int
        )

        data class Regiao(
            @Embedded
            @SerializedName("id")
            val id: Id,
            @SerializedName("nome")
            val nome: String
        ) {
            data class Id(
                @SerializedName("M49")
                val m49: Int
            )
        }
    }
}
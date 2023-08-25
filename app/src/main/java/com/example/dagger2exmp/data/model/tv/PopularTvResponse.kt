package com.example.dagger2exmp.data.model.tv


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/*https://api.themoviedb.org/3/tv/popular?language=en-US&page=1*/
data class PopularTvResponse(
    @SerializedName("page")
    val page: Int?,
    @SerializedName("results")
    val tvs: List<Tv>?,
    @SerializedName("total_pages")
    val totalPages: Int?,
    @SerializedName("total_results")
    val totalResults: Int?
)

@Entity(tableName = "popular_tv_shows")
data class Tv(
    @PrimaryKey
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String?,
    @SerializedName("original_language")
    val originalLanguage: String?,
    @SerializedName("original_name")
    val originalName: String?,
    @SerializedName("overview")
    val overview: String?,
    @SerializedName("popularity")
    val popularity: Double?,
    @SerializedName("poster_path")
    val posterPath: String?,
)
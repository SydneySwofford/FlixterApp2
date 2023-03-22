package com.codepath.articlesearch
import android.support.annotation.Keep
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable




@Keep
@Serializable
data class BaseResponse(
    @SerialName("results")
    val docs: List<Article>?
)

@Keep
@Serializable
data class Article(
    @SerialName("overview")
    val abstract: String?,

    @SerialName("original_language")
    val byline: String?,

    @SerialName("title")
    val headline: String?,

    @SerialName("poster_path")
    val multimedia: String,

) : java.io.Serializable {
    val mediaImageUrl = "https://image.tmdb.org/t/p/w500${multimedia}"
}

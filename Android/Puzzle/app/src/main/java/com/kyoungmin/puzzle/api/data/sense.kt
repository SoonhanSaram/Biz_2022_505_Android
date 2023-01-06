package com.kyoungmin.puzzle.api.data


import com.tickaroo.tikxml.annotation.Element
import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml

@Xml(name="sense")
data class sense(
    @PropertyElement(name="definition")
    var definition: String? = "",
    @Element(name="translation")
    var translation: List<translation>
)

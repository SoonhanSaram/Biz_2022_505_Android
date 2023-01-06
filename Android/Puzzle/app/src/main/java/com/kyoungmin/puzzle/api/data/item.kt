package com.kyoungmin.puzzle.api.data


import com.tickaroo.tikxml.annotation.Element
import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml


@Xml(name="item")

data class item(
    @PropertyElement(name="target_code")
    var target_code: Int? =0,
    @PropertyElement(name="word")
    var word : String? = "",
    @PropertyElement(name="sup_no")
    var sup_no:Int? =0,
    @PropertyElement(name="pos")
    var pos : String? ="" ,
    @PropertyElement(name="link")
    var link : String? ="",
    @Element(name="sense")
    var sense: List<sense>
)

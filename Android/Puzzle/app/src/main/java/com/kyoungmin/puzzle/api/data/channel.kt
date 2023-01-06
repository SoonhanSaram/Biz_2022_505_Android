package com.kyoungmin.puzzle.api.data

import com.tickaroo.tikxml.annotation.Element
import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml

@Xml(name="response")
data class response (
    @Element(name = "channel")
    val channel: List<channel>
    )

@Xml(name="channel")
data class channel(
    @PropertyElement(name="title")
    var title : String? = "",
    @PropertyElement(name="description")
    var description: String?="",
    @PropertyElement(name="link")
    var link : String? = "",
    @PropertyElement(name="lastBuildDate")
    var lastBuildDate: String? = "",
    @PropertyElement(name="total")
    var total: Int? = 0,
    @PropertyElement(name="start")
    var start: Int? = 0,
    @PropertyElement(name="num")
    var num : Int?=0,
    @Element(name="item")
    var item: List<item>?
)

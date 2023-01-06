package com.kyoungmin.puzzle.api.data

import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml

@Xml(name="translation")
class translation (
    @PropertyElement(name="trans_lang")
    var trans_lang: String? = "",
    @PropertyElement(name="trans_word")
    var trans_word: String? = "",
)
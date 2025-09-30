package org.example.item

import org.intellij.lang.annotations.Identifier
import javax.management.Descriptor
open class Item(
    var id: Int,
    var nom: String,
    var description: String,
)

open class Item(val id: Int, val nom: String, val description: String)



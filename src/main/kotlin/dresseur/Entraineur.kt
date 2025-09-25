package org.example

import org.example.item.Badge

class Entraineur {
    var id: Int = 0
    var nom: String = ""
    var argent: Int = 0
    constructor(id: Int, nom: String, argent: Int) {
        this.id = id
        this.nom = nom
        this.argent = argent
        var equipeMonstre: MutableList<IndividuMonstre> = mutableListOf()
        var boiteMonstre: MutableList<IndividuMonstre> = mutableListOf()

    }
    fun afficheDetail(){
        println("${this.id}")
        println("${this.nom}")
        println("${this.argent}")
    }
}

fun compterBadges(): Int {
    val inventaire = null
    return inventaire.filterIsInstance<Badge>().size
}

class Entraineur(val nom: String) {
    val equipe: MutableList<IndividuMonstre> = mutableListOf()  // <- obligatoire
}


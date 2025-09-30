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
        println(this.id)
        println(this.nom)
        println(this.argent)
    }
}

fun compterBadges(): Int {
    val inventaire = null
    return inventaire.filterIsInstance<Badge>().size
}

class Entraineur(val nom: String) {
    val equipe: MutableList<IndividuMonstre> = mutableListOf()  // <- obligatory
}

import item.Sac
import IndividuMonstre

/**
 * Classe représentant un entraîneur Pokémon.
 */
class Entraineur(
    val nom: String
) {
    // L’équipe de monstres de l’entraîneur
    val equipe: MutableList<IndividuMonstre> = mutableListOf()

    // Le sac d’objets de l’entraîneur
    val sac: Sac = Sac()

    /**
     * Ajoute un monstre à l’équipe.
     */
    fun ajouterMonstre(monstre: IndividuMonstre) {
        equipe.add(monstre)
        println("${monstre.nom} ajouté à l’équipe de $nom !")
    }

    /**
     * Affiche l’équipe du dresseur.
     */
    fun afficherEquipe() {
        println("Équipe de $nom :")
        if (equipe.isEmpty()) {
            println("Aucun monstre.")
        } else {
            equipe.forEach { println("- ${it.nom}") }
        }
    }

    /**
     * Affiche le contenu du sac du dresseur.
     */
    fun afficherSac() {
        println("Sac de $nom :")
        sac.afficherContenu()
    }
}

class Entraineur(val nom: String) {
    val equipe: MutableList<IndividuMonstre> = mutableListOf()
    val sac: Sac = Sac()

    fun ajouterMonstre(monstre: IndividuMonstre) {
        equipe.add(monstre)
    }
}

class Entraineur(val nom: String) {
    val equipe = mutableListOf<IndividuMonstre>()
    val inventaire = mutableListOf<Item>()
}


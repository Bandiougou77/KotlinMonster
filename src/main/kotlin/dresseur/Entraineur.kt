package dresseur

import item.Item
import monstre.IndividuMonstre

/**
 * Classe représentant un entraîneur Pokémon.
 */
class Entraineur(
    var id: Int,
    var nom: String,
    var argent: Int,
    // L’équipe de monstres de l’entraîneur
    var equipeMonstre: MutableList<IndividuMonstre> = mutableListOf(),
    var boiteMonstre: MutableList<IndividuMonstre> = mutableListOf(),
    // Le sac d’objets de l’entraîneur
    val sacItem: MutableList<Item> = mutableListOf<Item>()
) {


    fun afficheDetail() {
        println(this.id)
        println(this.nom)
        println(this.argent)
    }

    /**
     * Ajoute un monstre à l’équipe.
     */
    fun ajouterMonstre(monstre: IndividuMonstre) {
        equipeMonstre.add(monstre)
        println("${monstre.nom} ajouté à l’équipe de $nom !")
    }

    /**
     * Affiche l’équipe du dresseur.
     */
    fun afficherEquipe() {
        println("Équipe de $nom :")
        if (equipeMonstre.isEmpty()) {
            println("Aucun monstre.")
        } else {
            equipeMonstre.forEach { println("- ${it.nom}") }
        }
    }

    /**
     * Affiche le contenu du sac du dresseur.
     */
    fun afficherSac() {
        println("Sac de $nom :")
        //TODO
    }
}



package org.example.Item

package item

/**
 * Classe représentant le sac d’un dresseur.
 * Le sac contient une liste d’objets [Item].
 */
class Sac {

    // Liste des objets présents dans le sac
    val objets: MutableList<Item> = mutableListOf()

    /**
     * Ajoute un objet au sac.
     */
    fun ajouterObjet(item: Item) {
        objets.add(item)
        println("${item.nom} ajouté au sac.")
    }

    /**
     * Retire un objet du sac.
     */
    fun retirerObjet(item: Item) {
        if (objets.remove(item)) {
            println("${item.nom} retiré du sac.")
        } else {
            println("${item.nom} n’est pas dans le sac.")
        }
    }

    /**
     * Affiche le contenu du sac.
     */
    fun afficherContenu() {
        if (objets.isEmpty()) {
            println("Le sac est vide.")
        } else {
            println("Contenu du sac :")
            objets.forEach { println("- ${it.nom} : ${it.description}") }
        }
    }
}

import item.Utilisable

class Sac {
    private val objets: MutableList<Utilisable> = mutableListOf()

    fun ajouter(objet: Utilisable) {
        objets.add(objet)
    }

    fun utiliser(index: Int, cible: IndividuMonstre): Boolean {
        if (index < 0 || index >= objets.size) return false
        val objet = objets[index]
        val succes = objet.utiliser(cible)
        if (succes) objets.removeAt(index) // supprime l'objet après utilisation réussie
        return succes
    }

    fun afficherContenu() {
        println("Contenu du sac :")
        objets.forEachIndexed { i, obj ->
            println("$i : ${obj.javaClass.simpleName}")
        }
    }
}

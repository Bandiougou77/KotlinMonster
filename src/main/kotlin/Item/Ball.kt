package org.example.Item

package item

import IndividuMonstre

/**
 * Classe représentant une Ball (comme une Pokéball).
 *
 * Elle implémente l'interface [Utilisable], donc elle peut être utilisée
 * sur un [IndividuMonstre] pour tenter de le capturer.
 */
class Ball(
    val nom: String,
    private val tauxCapture: Double // probabilité de réussite (ex : 0.5 = 50%)
) : Utilisable {

    override fun utiliser(cible: IndividuMonstre): Boolean {
        println("$nom lancée sur ${cible.nom} !")

        val chance = Math.random() // nombre aléatoire entre 0 et 1
        return if (chance < tauxCapture) {
            println("${cible.nom} a été capturé !")
            true
        } else {
            println("${cible.nom} s'est échappé...")
            false
        }
    }
}

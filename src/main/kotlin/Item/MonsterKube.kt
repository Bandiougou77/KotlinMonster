package org.example.Item
import org.example.IndividuMonstre
import org.example.item.Item
import org.example.item.Utilisable

/**
 * Représente un kube (Pokéball) permettant de capturer un monstre.
 */
class MonsterKube(
    id: Int,
    nom: String,
    description: String,
    private val tauxCapture: Double // probabilité de capture (ex: 0.5 = 50%)
) : Item(id, nom, description), Utilisable {

    override fun utiliser(cible: IndividuMonstre): Boolean {
        val chance = Math.random()
        return if (chance < tauxCapture) {
            println("Capture réussie de ${cible.nom} avec $nom !")
            true
        } else {
            println("Échec de la capture de ${cible.nom}...")
            false
        }
    }
}

package item

import monstre.IndividuMonstre
import kotlin.random.Random

class MonsterKube(
    id: Int,
    nom: String,
    description: String,
    val tauxCapture: Double // entre 0.0 et 1.0
) : Item(id, nom, description), Utilisable {

    override fun utiliser(cible: IndividuMonstre): Boolean {
        val chance = Random.nextDouble()
        return if (chance < tauxCapture) {
            println("🎉 Capture réussie de ${cible.nom} !")
            true
        } else {
            println("💨 ${cible.nom} s’échappe du kube...")
            false
        }
    }
}

class MonsterKube(
    id: Int,
    nom: String,
    description: String
) : Item(id, nom, description), Utilisable {

    override fun utiliser(cible: IndividuMonstre): Boolean {
        if (cible.estKO()) return false
        val captureReussie = (0..100).random() < 50 // 50% de chance
        if (captureReussie) println("${cible.nom} a été capturé !")
        else println("La capture a échoué !")
        return captureReussie
    }
}

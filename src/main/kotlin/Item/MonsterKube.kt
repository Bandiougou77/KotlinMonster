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

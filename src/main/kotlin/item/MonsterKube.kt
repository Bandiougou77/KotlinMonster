package item
import monstre.IndividuMonstre

/**
 * Représente un kube (Pokéball) permettant de capturer un monstre.
 */

class MonsterKube(
    id: Int,
    nom: String,
    description: String,
    val chanceCapture :Int
) : Item(id, nom, description), Utilisable {

    override fun utiliser(cible: IndividuMonstre): Boolean {
        if (cible.pv <= 0) return false
        val nbAlea = (0..100).random()
        if (nbAlea < chanceCapture)
        {
            println("${cible.nom} a été capturé !")
            return  true
        }
        else println("La capture a échoué !")
        return  false

    }
}

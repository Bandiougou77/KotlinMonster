package item

/**
import monstre.IndividuMonstre


 * Représente un objet qui enlève un statut négatif sur un monstre.

class ItemAntiStatut(
    id: Int,
    nom: String,
    description: String,
    private val statutSupprime: String
) : Item(id, nom, description), Utilisable {

    override fun utiliser(cible: IndividuMonstre): Boolean {
        return if (cible.statut == statutSupprime) {
            cible.statut = null
            println("${cible.nom} est libéré du statut $statutSupprime grâce à $nom !")
            true
        } else {
            println("${cible.nom} n’est pas affecté par $statutSupprime.")
            false
        }
    }
}
*/
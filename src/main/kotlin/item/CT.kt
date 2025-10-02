package item


/**
 * Représente une Capsule Technique qui enseigne une nouvelle attaque à un monstre.

class CT(
    id: Int,
    nom: String,
    description: String,
    private val attaque: String
) : Item(id, nom, description), Utilisable {

    override fun utiliser(cible: IndividuMonstre): Boolean {
        return if (!cible.capacites.contains(attaque)) {
            cible.capacites.add(attaque)
            println("${cible.nom} a appris l’attaque $attaque grâce à $nom !")
            true
        } else {
            println("${cible.nom} connaît déjà $attaque.")
            false
        }
    }
}
*/
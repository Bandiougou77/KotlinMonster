package org.example.Item

import monstre.IndividuMonstre

/**
 * Représente une potion qui soigne un monstre.
 */
class Potion(
    id: Int,
    nom: String,
    description: String,
    private val soin: Int // points de vie rendus
) : Item(id, nom, description), Utilisable {

    override fun utiliser(cible: IndividuMonstre): Boolean {
        val vieAvant = cible.vie
        cible.vie += soin
        println("${cible.nom} a récupéré $soin PV (${vieAvant} → ${cible.vie})")
        return true
    }
}

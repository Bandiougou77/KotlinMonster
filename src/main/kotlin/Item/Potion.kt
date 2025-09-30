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

package item

import monstre.IndividuMonstre

class Potion(
    id: Int,
    nom: String,
    description: String,
    val soin: Int
) : Item(id, nom, description), Utilisable {

    override fun utiliser(cible: IndividuMonstre): Boolean {
        if (cible.vie == cible.espece.vieMax) {
            println("⚠️ ${cible.nom} a déjà toute sa vie, la potion est inutile.")
            return false
        }

        val avant = cible.vie
        cible.vie = (cible.vie + soin).coerceAtMost(cible.espece.vieMax)

        println("🧴 ${cible.nom} récupère ${cible.vie - avant} PV grâce à la potion.")
        return true
    }
}

package item

import IndividuMonstre

/**
 * Classe représentant une potion de soin.
 *
 * Elle implémente [Utilisable], donc peut être utilisée sur un [IndividuMonstre]
 * pour lui rendre de la vie.
 */
class Potion(
    val nom: String,
    private val soin: Int // quantité de PV rendus
) : Utilisable {

    override fun utiliser(cible: IndividuMonstre): Boolean {
        val ancienneVie = cible.vie
        cible.vie += soin
        println("$nom utilisée sur ${cible.nom} : +$soin PV (de $ancienneVie à ${cible.vie})")
        return true
    }
}

class Potion(val soin: Int) : Utilisable {
    override fun utiliser(cible: IndividuMonstre): Boolean {
        if (cible.vie <= 0) return false
        cible.vie += soin
        println("${cible.nom} récupère $soin PV !")
        return true
    }
}

class Potion(
    id: Int,
    nom: String,
    description: String,
    private val soin: Int
) : Item(id, nom, description), Utilisable {

    override fun utiliser(cible: IndividuMonstre): Boolean {
        if (cible.estKO()) return false
        cible.pv += soin
        println("${cible.nom} récupère $soin PV !")
        return true
    }
}

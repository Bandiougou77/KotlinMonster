package org.example.Combat

import org.example.Entraineur
import org.example.IndividuMonstre

package combat


class Combat(
    private val dresseur1: Entraineur,
    private val dresseur2: Entraineur
) {
    fun lancer() {
        println("⚔️ Combat entre ${dresseur1.nom} et ${dresseur2.nom} !")

        val monstre1 = dresseur1.equipe.first()
        val monstre2 = dresseur2.equipe.first()

        println("${dresseur1.nom} envoie ${monstre1.nom} (${monstre1.vie} PV)")
        println("${dresseur2.nom} envoie ${monstre2.nom} (${monstre2.vie} PV)")

        // Boucle de combat
        while (monstre1.vie > 0 && monstre2.vie > 0) {
            // Tour du monstre1
            attaquer(monstre1, monstre2)
            if (monstre2.vie <= 0) break

            // Tour du monstre2
            attaquer(monstre2, monstre1)
        }

        // Fin du combat
        if (monstre1.vie > 0) {
            println("${monstre1.nom} remporte le combat ! 🎉")
        } else {
            println("${monstre2.nom} remporte le combat ! 🎉")
        }
    }

    private fun attaquer(attaquant: IndividuMonstre, defenseur: IndividuMonstre) {
        val degats = (5..10).random()
        defenseur.vie -= degats
        println("${attaquant.nom} attaque et inflige $degats dégâts à ${defenseur.nom} (${defenseur.vie} PV restants)")
    }
}

package combat

import dresseur.Entraineur
import monstre.IndividuMonstre

class Combat(
    val dresseur1: Entraineur,
    val dresseur2: Entraineur
) {
    var actif1: IndividuMonstre? = null
    var actif2: IndividuMonstre? = null

    fun demarrer() {
        // On prend le premier monstre de chaque équipe
        actif1 = dresseur1.equipe.firstOrNull()
        actif2 = dresseur2.equipe.firstOrNull()

        println("⚔️ Combat entre ${dresseur1.nom} et ${dresseur2.nom} !")
        println("${dresseur1.nom} envoie ${actif1?.nom} !")
        println("${dresseur2.nom} envoie ${actif2?.nom} !")
    }
}

package combat

import dresseur.Entraineur
import monstre.IndividuMonstre
import monstre.Capacite

class Combat(
    val dresseur1: Entraineur,
    val dresseur2: Entraineur
) {
    var actif1: IndividuMonstre? = null
    var actif2: IndividuMonstre? = null

    fun demarrer() {
        actif1 = dresseur1.equipe.firstOrNull()
        actif2 = dresseur2.equipe.firstOrNull()

        println("⚔️ Combat entre ${dresseur1.nom} et ${dresseur2.nom} !")
        println("${dresseur1.nom} envoie ${actif1?.nom} !")
        println("${dresseur2.nom} envoie ${actif2?.nom} !")
    }

    fun attaquer(attaquant: IndividuMonstre, cible: IndividuMonstre, capacite: Capacite) {
        println("${attaquant.nom} utilise ${capacite.nom} sur ${cible.nom} !")

        cible.vie -= capacite.degats
        if (cible.vie < 0) cible.vie = 0

        println("${cible.nom} perd ${capacite.degats} PV. Il reste ${cible.vie}/${cible.espece.vieMax} PV.")

        if (cible.vie == 0) {
            println("💀 ${cible.nom} est K.O. !")
        }
    }
}

import item.Utilisable

/**
 * Classe représentant un combat entre deux entraîneurs.
 */
class Combat(
    private val dresseur1: Entraineur,
    private val dresseur2: Entraineur
) {

    /**
     * Lance un combat simplifié.
     */
    fun demarrer() {
        println("🔥 Combat entre ${dresseur1.nom} et ${dresseur2.nom} ! 🔥")

        // On suppose que chaque dresseur utilise son premier monstre
        val monstre1 = dresseur1.equipe.first()
        val monstre2 = dresseur2.equipe.first()

        print

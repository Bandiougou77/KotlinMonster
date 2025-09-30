package org.example.Combat

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

    fun lancerCombat() {
        demarrer()

        while (actif1 != null && actif2 != null) {
            // Le dresseur1 attaque
            val capacite1 = actif1!!.capacites.random()
            attaquer(actif1!!, actif2!!, capacite1)

            if (actif2!!.vie == 0) {
                actif2 = dresseur2.equipe.firstOrNull { it.vie > 0 }
                if (actif2 == null) {
                    println("🏆 ${dresseur1.nom} a gagné le combat !")
                    return
                }
                println("${dresseur2.nom} envoie ${actif2!!.nom} !")
            }

            // Le dresseur2 attaque
            val capacite2 = actif2!!.capacites.random()
            attaquer(actif2!!, actif1!!, capacite2)

            if (actif1!!.vie == 0) {
                actif1 = dresseur1.equipe.firstOrNull { it.vie > 0 }
                if (actif1 == null) {
                    println("🏆 ${dresseur2.nom} a gagné le combat !")
                    return
                }
                println("${dresseur1.nom} envoie ${actif1!!.nom} !")
            }
        }
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

    fun lancerCombat() {
        demarrer()

        while (actif1 != null && actif2 != null) {
            // --- Tour du joueur (dresseur1) ---
            println("\nTour de ${dresseur1.nom} : Choisis une capacité pour ${actif1!!.nom}")
            for ((index, cap) in actif1!!.capacites.withIndex()) {
                println("${index + 1}. ${cap.nom} (dégâts: ${cap.degats})")
            }

            var choix: Int
            while (true) {
                print("👉 Entre ton choix (1-${actif1!!.capacites.size}): ")
                val input = readLine()
                choix = input?.toIntOrNull() ?: -1
                if (choix in 1..actif1!!.capacites.size) break
                println("❌ Choix invalide, réessaie.")
            }

            val capacite1 = actif1!!.capacites[choix - 1]
            attaquer(actif1!!, actif2!!, capacite1)

            if (actif2!!.vie == 0) {
                actif2 = dresseur2.equipe.firstOrNull { it.vie > 0 }
                if (actif2 == null) {
                    println("\n🏆 ${dresseur1.nom} a gagné le combat !")
                    return
                }
                println("${dresseur2.nom} envoie ${actif2!!.nom} !")
            }

            // --- Tour de l'ordinateur (dresseur2) ---
            val capacite2 = actif2!!.capacites.random()
            attaquer(actif2!!, actif1!!, capacite2)

            if (actif1!!.vie == 0) {
                actif1 = dresseur1.equipe.firstOrNull { it.vie > 0 }
                if (actif1 == null) {
                    println("\n🏆 ${dresseur2.nom} a gagné le combat !")
                    return
                }
                println("${dresseur1.nom} envoie ${actif1!!.nom} !")
            }
        }
    }
}

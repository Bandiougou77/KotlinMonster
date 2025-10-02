package Combat

import dresseur.Entraineur
import monstre.IndividuMonstre


class CombatMonstre(
    private val dresseur1: Entraineur,
    private val dresseur2: Entraineur
) {
    fun lancer() {
        println("⚔️ Combat entre ${dresseur1.nom} et ${dresseur2.nom} !")

        val monstre1 = dresseur1.equipeMonstre.first()
        val monstre2 = dresseur2.equipeMonstre.first()

        println("${dresseur1.nom} envoie ${monstre1.nom} (${monstre1.pv} PV)")
        println("${dresseur2.nom} envoie ${monstre2.nom} (${monstre2.pv} PV)")

        // Boucle de combat
        while (monstre1.pv > 0 && monstre2.pv > 0) {
            // Tour du monstre1
            attaquer(monstre1, monstre2)
            if (monstre2.pv <= 0) break

            // Tour du monstre2
            attaquer(monstre2, monstre1)
        }

        // Fin du combat
        if (monstre1.pv > 0) {
            println("${monstre1.nom} remporte le combat ! 🎉")
        } else {
            println("${monstre2.nom} remporte le combat ! 🎉")
        }
    }

    private fun attaquer(attaquant: IndividuMonstre, defenseur: IndividuMonstre) {
        val degats = (5..10).random()
        defenseur.pv -= degats
        println("${attaquant.nom} attaque et inflige $degats dégâts à ${defenseur.nom} (${defenseur.pv} PV restants)")
    }
}




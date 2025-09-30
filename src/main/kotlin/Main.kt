package org.example

import item.*
import monstre.*
import org.example.Combat.Combat
import org.example.monstre.Capacite

val combat: Any
private val Entraineur.equipe: Any

// Fonction utilitaire pour mettre de la couleur dans la console
fun changeCouleur(message: String, couleur: String = ""): String {
    val reset = "\u001B[0m"
    val codeCouleur = when (couleur.lowercase()) {
        "rouge" -> "\u001B[31m"
        "vert" -> "\u001B[32m"
        "jaune" -> "\u001B[33m"
        "bleu" -> "\u001B[34m"
        "magenta" -> "\u001B[35m"
        "cyan" -> "\u001B[36m"
        "blanc" -> "\u001B[37m"
        else -> "" // pas de couleur si non reconnu
    }
    return "$codeCouleur$message$reset"
}

fun main() {
    // === Test couleurs ===
    println(changeCouleur("Hello", "rouge"))
    println(changeCouleur("World", "bleu"))
    println("Hello ${changeCouleur("my", "jaune")} World")
    println(changeCouleur("Pokemon", "magenta"))

    // === Création de dresseurs ===
    val joueur = Entraineur(1, "Sacha", 100)
    val rival = Entraineur(2, "Regis", 200)

    println("Dresseur : ${joueur.nom} | Argent : ${joueur.argent}")
    println("Dresseur : ${rival.nom} | Argent : ${rival.argent}")

    joueur.argent += 50
    println("Après gain, argent de ${joueur.nom} : ${joueur.argent}")

    joueur.afficheDetail()
    rival.afficheDetail()

    // === Création d’espèces de monstres ===
    val especeAquamy = EspeceMonstre("Aquamy", 55)
    val especeFlamkip = EspeceMonstre("Flamkip", 50)
    val especeSpringleaf = EspeceMonstre("Springleaf", 60)

    println(especeAquamy.afficheArt())
    println(especeFlamkip.afficheArt())
    println(especeSpringleaf.afficheArt())

    // === Création d’un monstre et test d’items ===
    val pikachu = EspeceMonstre("Pikachu", 35)
    val monstre = IndividuMonstre(pikachu, 20)

    val potion = Potion(1, "Potion", "Restaure 20 PV", 20)
    val kube = MonsterKube(2, "Kube Basique", "Permet de capturer un monstre", 0.5)

    joueur.ajouterItem(potion)
    joueur.ajouterItem(kube)

    joueur.utiliserItem(potion, monstre)
    joueur.utiliserItem(kube, monstre)

    // === Test ItemAntiStatut ===
    monstre.statut = "Poison"
    val antiPoison = ItemAntiStatut(3, "Anti-Poison", "Soigne l’empoisonnement", "Poison")
    antiPoison.utiliser(monstre)

    // === Test CT ===
    val ctTonnerre = CT(4, "CT-Tonnerre", "Apprend l’attaque Tonnerre", "Tonnerre")
    ctTonnerre.utiliser(monstre)
    ctTonnerre.utiliser(monstre) // deuxième fois → déjà appris

    // === Test Badge ===
    val badgeRoche = Badge(1, "Badge Roche", "Premier badge obtenu à Argenta", joueur)
    println("Nom du badge : ${badgeRoche.nom}")
    println("Champion associé : ${badgeRoche.champion.nom}")
}

fun main() {
    val sacha = Entraineur("Sacha")
    val regis = Entraineur("Regis")

    val pikachu = IndividuMonstre(EspeceMonstre("Pikachu", 35), 35)
    val salameche = IndividuMonstre(EspeceMonstre("Salameche", 39), 39)

    sacha.equipe.add(pikachu)
    regis.equipe.add(salameche)

    val combat = Combat(sacha, regis)
    combat.lancer()
}

fun main() {
    val sacha = Entraineur("Sacha")
    val regis = Entraineur("Regis")

    val pikachu = IndividuMonstre(EspeceMonstre("Pikachu", 35), 35)
    val salameche = IndividuMonstre(EspeceMonstre("Salameche", 39), 39)

    // Ajouter des capacités
    val eclair = Capacite("Éclair", 10, 95)
    val charge = Capacite("Charge", 8, 100)
    val flammes = Capacite("Flammes", 12, 90)

    pikachu.capacites.add(eclair)
    pikachu.capacites.add(charge)
    salameche.capacites.add(flammes)

    sacha.equipe.add(pikachu)
    regis.equipe.add(salameche)

    class IndividuMonstre(
        val espece: EspeceMonstre,
        var vie: Int
    ) {
        val nom: String = espece.nom
        val capacites: MutableList<Capacite> = mutableListOf()  // <- obligatoire
    }


    // Exemple d’utilisation
    pikachu.utiliserCapacite(eclair, salameche)
    salameche.utiliserCapacite(flammes, pikachu)
}

fun main() {
    // Création des dresseurs
    val sacha = Entraineur("Sacha")
    val regis = Entraineur("Regis")

    // Création des espèces
    val especePikachu = EspeceMonstre("Pikachu", 100)
    val especeSalameche = EspeceMonstre("Salamèche", 90)

    // Création des monstres
    val pikachu = IndividuMonstre(especePikachu, 100)
    val salameche = IndividuMonstre(especeSalameche, 90)

    // Création des capacités
    val eclair = Capacite("Éclair", 20)
    val charge = Capacite("Charge", 10)
    val flammes = Capacite("Flammes", 25)

    // Attribution des capacités
    pikachu.capacites.add(eclair)
    pikachu.capacites.add(charge)
    salameche.capacites.add(flammes)

    // Attribution des monstres aux dresseurs
    sacha.equipe.add(pikachu)
    regis.equipe.add(salameche)

    // 🚀 Début du combat
    val combat = Combat(sacha, regis)
    combat.demarrer()
}

fun main() {
    // Création des dresseurs
    val sacha = Entraineur("Sacha")
    val regis = Entraineur("Regis")

    // Création des espèces
    val especePikachu = EspeceMonstre("Pikachu", 100)
    val especeSalameche = EspeceMonstre("Salamèche", 90)

    // Création des monstres
    val pikachu = IndividuMonstre(especePikachu, 100)
    val salameche = IndividuMonstre(especeSalameche, 90)

    // Création des capacités
    val eclair = Capacite("Éclair", 20)
    val charge = Capacite("Charge", 10)
    val flammes = Capacite("Flammes", 25)

    // Attribution des capacités
    pikachu.capacites.add(eclair)
    pikachu.capacites.add(charge)
    salameche.capacites.add(flammes)

    // Attribution des monstres aux dresseurs
    sacha.equipe.add(pikachu)
    regis.equipe.add(salameche)

    // 🚀 Début du combat
    val combat = Combat(sacha, regis)
    combat.demarrer()

    // 🥊 Tour de combat
    combat.attaquer(pikachu, salameche, eclair)
    combat.attaquer(salameche, pikachu, flammes)
}

fun main() {
    val sacha = Entraineur("Sacha")
    val regis = Entraineur("Regis")

    val especePikachu = EspeceMonstre("Pikachu", 100)
    val especeSalameche = EspeceMonstre("Salamèche", 90)

    val pikachu = IndividuMonstre(especePikachu, 100)
    val salameche = IndividuMonstre(especeSalameche, 90)

    val eclair = Capacite("Éclair", 20)
    val charge = Capacite("Charge", 10)
    val flammes = Capacite("Flammes", 25)

    pikachu.capacites.add(eclair)
    pikachu.capacites.add(charge)
    salameche.capacites.add(flammes)

    sacha.equipe.add(pikachu)
    regis.equipe.add(salameche)

    val combat = Combat(sacha, regis)
    combat.lancerCombat()
}

fun main() {
    val sacha = Entraineur("Sacha")
    val regis = Entraineur("Regis")

    val especePikachu = EspeceMonstre("Pikachu", 100)
    val especeSalameche = EspeceMonstre("Salamèche", 90)

    val pikachu = IndividuMonstre(especePikachu, 40) // déjà blessé
    val salameche = IndividuMonstre(especeSalameche, 90)

    val eclair = Capacite("Éclair", 20)
    val charge = Capacite("Charge", 10)
    val flammes = Capacite("Flammes", 25)

    pikachu.capacites.add(eclair)
    pikachu.capacites.add(charge)
    salameche.capacites.add(flammes)

    sacha.equipe.add(pikachu)
    regis.equipe.add(salameche)

    // Création d’objets
    val potion = Potion(1, "Potion", "Restaure 20 PV", 20)
    val kube = MonsterKube(2, "Kube simple", "Permet de capturer un monstre", 0.5)

    // Test d’utilisation
    println("\n--- Utilisation des objets ---")
    potion.utiliser(pikachu)   // soigne Pikachu
    kube.utiliser(salameche)   // tente de capturer Salamèche

    // Combat classique
    val combat = Combat(sacha, regis)
    combat.lancerCombat()
}

fun main() {
    val sac = item.Sac()

    val potion = item.Potion("Potion", 20)
    val kube = item.MonsterKube("PokéKube", 0.5)

    sac.ajouterObjet(potion)
    sac.ajouterObjet(kube)

    sac.afficherContenu()

    sac.retirerObjet(potion)
    sac.afficherContenu()
}

fun main() {
    val sacha = Entraineur("Sacha")

    val pikachu = IndividuMonstre("Pikachu", 100)
    sacha.ajouterMonstre(pikachu)

    val potion = item.Potion("Potion", 20)
    val kube = item.MonsterKube("PokéKube", 0.5)

    sacha.sac.ajouterObjet(potion)
    sacha.sac.ajouterObjet(kube)

    sacha.afficherEquipe()
    sacha.afficherSac()
}

fun main() {
    val sacha = Entraineur("Sacha")
    val regis = Entraineur("Regis")

    val pikachu = IndividuMonstre("Pikachu", 100)
    val salameche = IndividuMonstre("Salamèche", 100)

    val eclair = Capacite("Éclair", 20)
    val flammes = Capacite("Flammes", 25)

    pikachu.capacites.add(eclair)
    salameche.capacites.add(flammes)

    sacha.ajouterMonstre(pikachu)
    regis.ajouterMonstre(salameche)

    val combat = Combat(sacha, regis)
    combat.demarrer()
}

fun main() {
    val sacha = Entraineur("Sacha")
    val regis = Entraineur("Regis")

    val pikachu = IndividuMonstre("Pikachu", 100)
    val salameche = IndividuMonstre("Salamèche", 100)

    val eclair = Capacite("Éclair", 20)
    val flammes = Capacite("Flammes", 25)

    pikachu.capacites.add(eclair)
    salameche.capacites.add(flammes)

    sacha.ajouterMonstre(pikachu)
    regis.ajouterMonstre(salameche)

    val combat = Combat(sacha, regis)
    combat.demarrer()
}

fun main() {
    // Création des capacités
    val eclair = Capacite("Éclair", 40)
    val charge = Capacite("Charge", 20)
    val flammes = Capacite("Flammes", 35)

    // Création des monstres
    val pikachu = IndividuMonstre("Pikachu", 100, 55, 30)
    val salameche = IndividuMonstre("Salamèche", 90, 50, 25)

    pikachu.capacites.add(eclair)
    pikachu.capacites.add(charge)
    salameche.capacites.add(flammes)

    // Création des dresseurs
    val sacha = Entraineur("Sacha")
    val regis = Entraineur("Régis")

    sacha.equipe.add(pikachu)
    regis.equipe.add(salameche)

    // Création d’items
    val potion = Potion(1, "Potion", "Soigne 30 PV", 30)
    val kube = MonsterKube(2, "Kube", "Permet de capturer un monstre")

    sacha.inventaire.add(potion)
    sacha.inventaire.add(kube)

    // Création des badges
    val badgeElectrik = Badge(1, "Badge Éclair", "Badge de la ville de Bourg-Palette", regis)

    // Combat simple tour par tour
    combatTourParTour(sacha, regis)
}

fun combatTourParTour(joueur: Entraineur, adversaire: Entraineur) {
    val monstreJoueur = joueur.equipe.first()
    val monstreAdv = adversaire.equipe.first()

    while (!monstreJoueur.estKO() && !monstreAdv.estKO()) {
        // Tour du joueur
        val capacite = monstreJoueur.capacites.first()
        monstreAdv.pv -= capacite.puissance
        println("${monstreJoueur.nom} utilise ${capacite.nom} !")
        println("${monstreAdv.nom} a maintenant ${monstreAdv.pv} PV")

        if (monstreAdv.estKO()) {
            println("${monstreAdv.nom} est KO !")
            break
        }

        // Tour de l'adversaire
        val capaciteAdv = monstreAdv.capacites.first()
        monstreJoueur.pv -= capaciteAdv.puissance
        println("${monstreAdv.nom} utilise ${capaciteAdv.nom} !")
        println("${monstreJoueur.nom} a maintenant ${monstreJoueur.pv} PV")

        if (monstreJoueur.estKO()) {
            println("${monstreJoueur.nom} est KO !")
            break
        }
    }

    // Attribution du badge si victoire
    if (!monstreJoueur.estKO()) {
        println("${joueur.nom} gagne le combat et obtient le badge ${badgeElectrik.nom} !")
    } else {
        println("${joueur.nom} a perdu le combat...")
    }
}
